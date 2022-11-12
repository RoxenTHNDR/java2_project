package lambda;

import java2_final_project_demo.MyException;
import java2_final_project_demo.data_access.MyDAO;
import java2_final_project_demo.data_access.MyDAOFactory;
import java1refresher.Book;
import java1refresher.Person;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

public class Demo {
    public static void main(String[] args) throws MyException {
        String data_source = "csv";
        MyDAO<Person> personDAO = MyDAOFactory.getMyDAO(data_source);
        if(personDAO == null) {
            System.out.println("Person data object not found");
            return;
        }
        try {
            personDAO.readInData();
        } catch(MyException e) {
            System.out.println(e.getMessage());
            return;
        }
        List<Person> people = personDAO.getAll();

        Consumer<String> nameLength = (name) -> System.out.println(name + " " + name.length());
        for(Person person: people) {
            nameLength.accept(person.getFirstName());
        }
        System.out.println();

        Consumer<String> printWordAndLength = (str) -> System.out.println(str + " " + str.length());
        for (Person p : people) {
            printWordAndLength.accept(p.getFirstName());
        }
        System.out.println();

        MyAnalyzer<String> startsWith = (search, target) -> target.startsWith(search);
        for(Person person: people) {
            if(startsWith.analyze("g", person.getFirstName().toLowerCase())) {
                System.out.println("Match: " + person.getFirstName() + " " + person.getLastName());
            }
        }
        System.out.println();

        Supplier<String> today = () -> {
            DateTimeFormatter df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
            return df.format(ZonedDateTime.now());
        };
        System.out.println(today.get());

        Supplier<ZonedDateTime> today1 = () -> ZonedDateTime.now();
        FormatStyle[] dateStyles = {FormatStyle.FULL, FormatStyle.LONG, FormatStyle.MEDIUM, FormatStyle.SHORT};
        for(FormatStyle style: dateStyles) {
            DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(style);
            System.out.println("Today is " + dtf.format(today1.get()));
        }

        System.out.println();

        Supplier<Integer> diceRoll = () -> ThreadLocalRandom.current().nextInt(1, 7);
        for(int i = 0; i < 10;) {
            System.out.println("Roll #" + ++i + ": " + diceRoll.get());
        }
        System.out.println();

        Supplier<Book> bs = Book::new; // equivalent to () -> new Book();
        Book book = bs.get();
        book.setTitle("I love my lambdas");
        book.setAuthor(people.get(42));
        System.out.println(book);


        Supplier<LocalDate> randDate = () -> LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
        for(int i = 0; i < 10; i++) {
            System.out.println(randDate.get());
        }

    }
}
