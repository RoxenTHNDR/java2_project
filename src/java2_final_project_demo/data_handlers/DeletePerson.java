package java2_final_project_demo.data_handlers;

import java2_final_project_demo.MyException;
import java2_final_project_demo.UIUtility;
import java2_final_project_demo.data_access.MyDAO;
import java1refresher.Person;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DeletePerson implements MyDataHandler{
    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        List<Person> list = data_source.getAll();
        int choice = 0;
        while(true) {
            String menuTitle = "Delete Person";
            String prompt = "Select a person to delete";
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
            Person person = list.get(choice - 1);
            if(data_source.remove(person)) {
                System.out.println("Person deleted");
            } else {
                System.out.println("Delete function failed");
            }
            break;
        }
    }
}
