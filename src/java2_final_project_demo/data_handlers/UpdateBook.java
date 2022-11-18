package java2_final_project_demo.data_handlers;

import java1refresher.Book;
import java1refresher.Person;
import java2_final_project_demo.MyException;
import java2_final_project_demo.UIUtility;
import java2_final_project_demo.UserInput;
import java2_final_project_demo.data_access.MyDAO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UpdateBook implements MyDataHandler {

    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        List<Book> list = data_source.getAll();
        int choice = 0;
        while(true) {
            String menuTitle = "Update Book";
            String prompt = "Select a Book to update";
            String[] menuOptions = new String[list.size()];
            for(int i = 0; i < menuOptions.length; i++) {
                menuOptions[i] = list.get(i).getTitle();
            }
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if (choice <= 0 || choice > menuOptions.length + 1) {
                UIUtility.pressEnterToContinue(scanner, messages);
                continue;
            }
            if (choice == menuOptions.length + 1) {
                break;
            }
            UIUtility.showSectionTitle("Updating " + menuOptions[choice - 1]);
            Book book = list.get(choice - 1);
            updateBook(data_source, book, choice - 1, scanner, messages);
            break;
        }
    }
    public void updateBook(MyDAO data_source, Book book, int choice, Scanner scanner, ResourceBundle messages) throws MyException {

        String keep = " (Press Enter to keep the current value)";
        System.out.println("ID: " + book.getBookID());
        for(;;) {
            try {
                String userIn = UserInput.getString("New book ID" + keep, scanner);
                if(userIn.equals("")) {
                    break;
                }
                book.setBookID(Integer.parseInt(userIn));
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        System.out.println("Title: " + book.getTitle());
        for(;;) {
            try {
                String userIn = UserInput.getString("New book Title" + keep, scanner);
                if(userIn.equals("")) {
                    break;
                }
                book.setTitle(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        System.out.println("Authors first name: " + book.getAuthor().getFirstName());
        for(;;) {
            try {
                String userIn = UserInput.getString("New first name" + keep, scanner);
                if(userIn.equals("")) {
                    break;
                }
                book.getAuthor().setFirstName(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        System.out.println("Authors last name: " + book.getAuthor().getLastName());
        for(;;) {
            try {
                String userIn = UserInput.getString("New last name" + keep, scanner);
                if(userIn.equals("")) {
                    break;
                }
                book.getAuthor().setLastName(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        System.out.println("Read: " + book.getRead());
        for(;;) {
            try {
                String userIn = UserInput.getString("New Read" + keep, scanner);
                if(userIn.equals("")) {
                    break;
                }
                book.setRead(Boolean.parseBoolean(userIn));
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        System.out.println("Amount of pages: " + book.getBookID());
        for(;;) {
            try {
                String userIn = UserInput.getString("New Page number" + keep, scanner);
                if(userIn.equals("")) {
                    break;
                }
                book.setNumPages(Integer.parseInt(userIn));
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        System.out.println("Publishing date: " + book.getPublishDate());
        for(;;) {
            try {
                String userIn = UserInput.getString("New publish Date", scanner);
                if(userIn.equals("")) {
                    break;
                }
                DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(userIn, formatterInput);
                book.setPublishDate(date);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        System.out.println("Unit Price: " + book.getUnitPrice());
        for(;;) {
            try {
                String userIn = UserInput.getString("New unit price", scanner);
                if(userIn.equals("")) {
                    break;
                }
                book.setUnitPrice(Double.parseDouble(userIn));
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        data_source.set(choice, book);
        System.out.println("\nPerson updated.");
    }

}
