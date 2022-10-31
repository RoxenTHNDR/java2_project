package java2_final_project_demo.data_handlers;

import java2_final_project_demo.data_access.MyDAO;
import java2_final_project_demo.MyException;
import java2_final_project_demo.UIUtility;
import java2_final_project_demo.UserInput;
import java1refresher.Person;

import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AddPerson implements MyDataHandler{
    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        Person person = new Person();

        for(;;) {
            try {
                String userIn = UserInput.getString(messages.getString("enter-first-name"), scanner);
                person.setFirstName(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        for(;;) {
            try {
                String userIn = UserInput.getString(messages.getString("enter-last-name"), scanner);
                person.setLastName(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        for(;;) {
            try {
                int userIn = UserInput.getInt(messages.getString("enter-height"), scanner, messages);
                person.setHeightInInches(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        for(;;) {
            try {
                double userIn = UserInput.getDouble(messages.getString("enter-weight"), scanner, messages);
                person.setWeightInPounds(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        for(;;) {
            try {
                LocalDateTime userIn = UserInput.getDate(messages.getString("enter-date-of-birth"), scanner, messages);
                person.setDateOfBirth(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        data_source.add(person);
        UIUtility.showSectionTitle(messages.getString("person-added"));

    }
}
