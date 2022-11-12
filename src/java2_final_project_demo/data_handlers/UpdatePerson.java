package java2_final_project_demo.data_handlers;

import java2_final_project_demo.MyException;
import java2_final_project_demo.UIUtility;
import java2_final_project_demo.UserInput;
import java2_final_project_demo.data_access.MyDAO;
import java1refresher.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UpdatePerson implements MyDataHandler {
    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        List<Person> list = data_source.getAll();
        int choice = 0;
        while(true) {
            String menuTitle = "Update Person";
            String prompt = "Select a person to update";
            String[] menuOptions = new String[list.size()];
            for(int i = 0; i < menuOptions.length; i++) {
                menuOptions[i] = list.get(i).getFirstName() + " " + list.get(i).getLastName();
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
            Person person = list.get(choice - 1);
            updatePerson(data_source, person, choice - 1, scanner, messages);
            break;
        }
    }

    public void updatePerson(MyDAO data_source, Person person, int choice, Scanner scanner, ResourceBundle messages) throws MyException {

        String keep = " (Press Enter to keep the current value)";
        System.out.println("First name: " + person.getFirstName());
        for(;;) {
            try {
                String userIn = UserInput.getString("New first name" + keep, scanner);
                if(userIn.equals("")) {
                    break;
                }
                person.setFirstName(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        System.out.println("Last name: " + person.getLastName());
        for(;;) {
            try {
                String userIn = UserInput.getString("New last name" + keep, scanner);
                if(userIn.equals("")) {
                    break;
                }
                person.setLastName(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        System.out.println("Height: " + person.getHeightInInches());
        for(;;) {
            try {
                String userIn = UserInput.getString("New height" + keep, scanner);
                if(userIn.equals("")) {
                    break;
                }
                person.setHeightInInches(Integer.parseInt(userIn));
                break;
            } catch(NumberFormatException e) {
                UIUtility.showErrorMessage("Invalid number", scanner, messages);
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        System.out.println("Weight: " + person.getWeightInPounds());
        for(;;) {
            try {
                String userIn = UserInput.getString("New weight" + keep, scanner);
                if(userIn.equals("")) {
                    break;
                }
                person.setWeightInPounds(Double.parseDouble(userIn));
                break;
            } catch(NumberFormatException e) {
                UIUtility.showErrorMessage("Invalid number", scanner, messages);
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        System.out.println("Date of birth: " + person.getDateOfBirth().toLocalDate());
        for(;;) {
            try {
                String userIn = UserInput.getString("New date of birth" + keep, scanner);
                if(userIn.equals("")) {
                    break;
                }
                DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(userIn, formatterInput);
                person.setDateOfBirth(date.atStartOfDay());
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            } catch(DateTimeParseException e) {
                UIUtility.showErrorMessage("Invalid date", scanner, messages);
            }
        }

        data_source.set(choice, person);
        System.out.println("\nPerson updated.");
    }
}
