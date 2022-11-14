package java2_final_project_demo;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Language {
    private ResourceBundle messages;

    public Language() {
        messages = ResourceBundle.getBundle("messages", Locale.getDefault());
    }

    public ResourceBundle getMessages() {
        return messages;
    }

    public void setMessages(Scanner scanner) {

        int choice = 0;
        while(true) {
            String menuTitle = messages.getString("languages-available");
            String prompt = messages.getString("select-language");
            String[] menuOptions = {
                    messages.getString("english"), messages.getString("french"), messages.getString("german")
            };

            System.out.print(menuOptions.length + 1);

            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if(choice <= 0 || choice > menuOptions.length + 1) {
                UIUtility.pressEnterToContinue(scanner, messages);
                continue;
            }
            else if(choice == menuOptions.length + 1) {
                System.out.println("\n" + messages.getString("language-canceled"));
                break;
            }
            else if(choice == 1) {
                messages = ResourceBundle.getBundle("messages", Locale.getDefault());
                System.out.println("\n" + messages.getString("language-changed") + ".");
                break;
            }
            else if(choice == 2) {
                messages = ResourceBundle.getBundle("messages", new Locale("fr", "FR"));
                System.out.println("\n" + messages.getString("language-changed") + ".");
                break;
            }
            else if(choice == 3) {
                messages = ResourceBundle.getBundle("messages", new Locale("de", "DE"));
                System.out.println("\n" + messages.getString("language-changed") + ".");
                break;
            }
        }

    }
}
