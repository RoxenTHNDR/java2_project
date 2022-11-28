package java2_final_project_demo.data_handlers;

import java1refresher.Book;
import java1refresher.Person;
import java2_final_project_demo.MyException;
import java2_final_project_demo.UIUtility;
import java2_final_project_demo.UserInput;
import java2_final_project_demo.data_access.MyDAO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AddBook implements MyDataHandler{
    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        Book book = new Book();


        for(;;) {
            try {
                int userIn = UserInput.getInt(messages.getString("enter-book-id"), scanner,messages);
                book.setBookID(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        for(;;) {
            try {
                String userIn = UserInput.getString(messages.getString("enter-title"), scanner);
                book.setTitle(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        for(;;) {
            try {
                String userInFirst = UserInput.getString(messages.getString("enter-author"), scanner);
                String[] name = userInFirst.split(" ");
                Person author = new Person(name[0],name[1]);
                book.setAuthor(author);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        for(;;) {
            try {
                String[] answers = new String[]{"yes", "Yes", "no","No"};
                String userIn = UserInput.validateString(messages.getString("enter-read"), answers,scanner,messages);
                Boolean read = Boolean.parseBoolean(userIn);
                book.setRead(read);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        for(;;) {
            try {
                int userIn = UserInput.getInt(messages.getString("enter-num-pages"), scanner,messages);
                book.setNumPages(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        for(;;) {
            try {
                LocalDateTime userIn = UserInput.getDate(messages.getString("enter-publish-date"), scanner, messages);
                book.setPublishDate(userIn.toLocalDate());
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        for(;;) {
            try {
                double userIn = UserInput.getDouble(messages.getString("enter-unit-price"), scanner, messages);
                book.setUnitPrice(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }



        data_source.add(book);
        UIUtility.showSectionTitle(messages.getString("book-added"));

    }
}
