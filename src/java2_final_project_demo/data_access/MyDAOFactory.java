package java2_final_project_demo.data_access;

import java1refresher.Book;
import java2_final_project_demo.data_access.MyDAO;
import java1refresher.Person;

import java.util.ArrayList;
import java.util.List;

public class MyDAOFactory {

    public static List<MyDAO> getMyDAO(String dao_source) {
        List<MyDAO> data_objects = new ArrayList<>();
        MyDAO<Person> person_dao = null;
        MyDAO<Book> book_dao= null;
        switch(dao_source.toUpperCase()) {
            case "CSV":
                person_dao = new PersonDAO_CSV();
                //                book_dao = new BookDAO_CSV();
                break;
            case "XML":
                person_dao = new PersonDAO_XML();
                //                book_dao = new BookDAO_XML();
                break;
            case "MYSQL":
                person_dao = new PersonDAO_MySQL();
                //                book_dao = new BookDAO_MySQL();
                break;
        }
        data_objects.add(person_dao);
        data_objects.add(book_dao);
        return data_objects;
    }
}
