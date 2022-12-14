package java2_final_project_demo.data_handlers;

import java1refresher.Book;
import java2_final_project_demo.MyException;
import java2_final_project_demo.UserInput;
import java2_final_project_demo.data_access.MyDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GetBook implements MyDataHandler{
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        String userIn = UserInput.getString("Search for a book by its id, title, or publish date(YYYY-MM-DD)", scanner);
        try{
            // Search by id
            int id = Integer.parseInt(userIn);
            Book book = (Book)data_source.get(id);
            if(book == null) {
                System.out.println("No book found with id '" + id + "'.");
            } else {
                System.out.println("\nRetrieved:");
                System.out.println(book);
            }
        } catch(NumberFormatException e1){
            // Search by publish
            try{
                List<Book> list = (List<Book>)data_source.get(userIn);
                if(list.size() == 0) {
                    System.out.println("No book found: '" + userIn +"'.");
                } else {
                    System.out.println("Retrieved:");
                    for(Book book: list) {
                        System.out.println(book);
                    }
                }
            } catch(Exception e2){
                List<Book> list = (List<Book>)data_source.get(userIn);
                if(list.size() == 0) {
                    System.out.println("No book foundHell: '" + userIn +"'.");
                }
            }
        }
    }
}
