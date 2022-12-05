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
        List<MyDAO> data_objects = MyDAOFactory.getMyDAO(data_source);
        MyDAO<Person> personDAO = data_objects.get(0);
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

//        Supplier<LocalDate> randDate = () -> LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
//        for(int i = 0; i < 10; i++) {
//            System.out.println(randDate.get());
//        }

//        Supplier<String> ranDate = () -> {
//            GregorianCalendar gc = new GregorianCalendar();
//            int start = 1900;
//            int end = LocalDate.now().getYear();
//            int year = start + (int)Math.round(Math.random() * (end - start));
//            gc.set(gc.YEAR, year);
//            start = 1;
//            end = gc.getActualMaximum(gc.DAY_OF_YEAR);
//            int dayOfYear = start + (int)Math.round(Math.random() * (end - start));
//            gc.set(gc.DAY_OF_YEAR, dayOfYear);
//            return gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);
//        };
//        System.out.println();
//
//        for(int i = 0; i < 10; i++) {
//            System.out.println(ranDate.get());
//        }

//        Supplier<LocalDate> randDate = () -> LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
//        for (int i = 0; i < 10;) {
//            System.out.println("Date #" + ++i + " : " + randDate.get());
//        }

        Supplier<LocalDate> randombd = () -> LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
        for(int i = 0; i < 10; i++) {
            System.out.println(randombd.get() + " ");
        }

        Supplier<LocalDate> randDate = () ->{
            return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
        };

        for (int i = 0; i < 10; i++){
            System.out.println(randDate.get());
        }

        Supplier<LocalDate> randomBirthday = () -> LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
        for (int i = 0; i < 10; i++) {
            System.out.println(randomBirthday.get());
        }


        Supplier<LocalDate> randomDateOfBirth = () -> LocalDate.now().minus(Period.ofDays((ThreadLocalRandom.current().nextInt(365 * 70))));
        for(int i = 0; i < 10;) {
            System.out.println("Date #" + ++i + ": " + randomDateOfBirth.get());
        }

        Supplier<Integer> random = () -> ThreadLocalRandom.current().nextInt(365 * 70);
        for(int i = 0; i <10;i++){
            System.out.println(LocalDate.now().minus(Period.ofDays(random.get())));
        }

        Consumer<Integer> factorial = (num) -> {
            int result = 1;
            for(int i = 2; i <= num; i++) {
                result *= i;
            }
            System.out.println("The factorial of " + num + " is " + result);
        };
        factorial.accept(10);
        factorial.accept(5);
        factorial.accept(4);


        Consumer<String> yell = (str) -> System.out.println(str.toUpperCase() + "!");
        yell.accept("i love lambdas");

        Consumer<LocalDate> dayAfter = (date) -> {
            DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
            System.out.println(df.format(date.plusDays(1)));
        };
        dayAfter.accept(LocalDate.now());
        dayAfter.accept(LocalDate.of(1981,2,6));

        BiConsumer<String, Integer> repeater = (str, num) -> {
            String result = "";
            for(int i = 0; i < num; i++) {
                result += str;
            }
            System.out.println(result);
        };
        repeater.accept("Java", 5);
        repeater.accept("Pizza", 3);







        Consumer<Book> bookPrinter = (b) -> System.out.printf("\"%s\", written by %s %s", b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName());
        Book b = bs.get();
        b.setTitle("I love Lambda Expressions");
        b.setAuthor(new Person("Marc", "Hauschildt"));
        bookPrinter.accept(b);


        Function<LocalDate, Integer> calculateAge = (birthDate) -> {
            if (birthDate != null) {
                return Period.between(birthDate, LocalDate.now()).getYears();
            }
            return 0;
        };
        Consumer<Person> nameAndAge = (person) -> System.out.println(person.getFirstName() + " is " + calculateAge.apply(person.getDateOfBirth().toLocalDate()));
        people.forEach(nameAndAge);

        Map<String, String> states = new HashMap<>();
        states.put("Iowa", "Des Moines");
        states.put("Wisconsin", "Madison");
        states.put("Minnesota", "St. Paul");
        BiConsumer<String, String> printCapital = (state, capital) -> System.out.println("The capital of " + state + " is " + capital);
        states.forEach(printCapital);


        Predicate<Integer> isEven = (num) -> num % 2 == 0;

        List<Integer> myNums = new ArrayList<>(Arrays.asList(13,5,20,16,19,-8));
        myNums.removeIf((num) -> num >= 13 && num <= 19);
        System.out.println(myNums);





        int n = 4;
        System.out.println(n + " is " + (isEven.test(n) ? "even" : "odd"));
        n = 5;
        System.out.println(n + " is " + (isEven.test(n) ? "even" : "odd"));

        Predicate<String> containsHashTag = (str) -> str.indexOf("#") >= 0;
        String tweet = "Kirkwood Eagles advance to the #NJCAAVB DII Championships for the fifth straight year";
        if(containsHashTag.test(tweet)) {
            System.out.println(tweet);
        }

        tweet = "Kirkwood Eagles advance to the DII Championships for the fifth straight year";
        if(containsHashTag.test(tweet)) {
            System.out.println(tweet);
        }

        BiPredicate<Integer, Integer> isFactorOf = (num1, num2) -> num1 % num2 == 0;
        int n1 = 10;
        int n2 = 2;
        System.out.println(n2 + (isFactorOf.test(n1, n2) ? " is " : " is not ") + "a factor of" + n1);
        n2 = 3;
        System.out.println(n2 + (isFactorOf.test(n1, n2) ? " is " : " is not ") + "a factor of " + n1);


    }



}
