package java2_final_project_demo.data_handlers;

import java2_final_project_demo.MyException;
import java2_final_project_demo.UserInput;
import java2_final_project_demo.data_access.MyDAO;
import java1refresher.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GetPerson implements MyDataHandler {
    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        String userIn = UserInput.getString("Search for person by their id, first name, last name, or date of birth (YYYY-MM-DD)", scanner);
        try{
            // Search by id
            int id = Integer.parseInt(userIn);
            Person person = (Person)data_source.get(id);
            if(person == null) {
                System.out.println("No person found with id '" + id + "'.");
            } else {
                System.out.println("\nRetrieved:");
                System.out.println(person);
            }
        } catch(NumberFormatException e1){
            // Search by birthday
            try{
                DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateOfBirth = LocalDate.parse(userIn, formatterInput);
                List<Person> list = (List<Person>)data_source.get(dateOfBirth);
                if(list.size() == 0) {
                    System.out.println("No person found with birth date '" + dateOfBirth + "'.");
                } else {
                    System.out.println("\nRetrieved:");
                    for(Person person: list) {
                        System.out.println(person);
                    }
                }
            } catch(DateTimeParseException e2){
                // Search by name
                List<Person> list = (List<Person>)data_source.get(userIn);
                if(list.size() == 0) {
                    System.out.println("No person found with first or last name containing '" + userIn +"'.");
                } else {
                    System.out.println("Retrieved:");
                    for(Person person: list) {
                        System.out.println(person);
                    }
                }
            }
        }
    }
}
