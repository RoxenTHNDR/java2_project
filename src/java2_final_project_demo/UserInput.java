package java2_final_project_demo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class UserInput {
    /**
     * Prompts the user for a String and returns whatever was entered.
     *
     * @param prompt the prompt text for the user
     * @param in a Scanner object
     * @return the String entered by the user
     */
    public static String getString(String prompt, Scanner in) {
        System.out.print(prompt + ": ");
        return in.nextLine().trim();
    }

    /**
     * Validates that the user's input is included in a list of possible values
     * @param prompt - the prompt text for the user
     * @param possibleValues - a list of strings
     * @param in - a Scanner object
     * @param messages - a ResourceBundle object
     * @return - the user's input if it was valid
     */
    public static String validateString(String prompt, String[] possibleValues, Scanner in, ResourceBundle messages) {
        int attempts = 0;
        String possibleValuesString = Arrays.toString(possibleValues);
        String possibleValuesLowercase = possibleValuesString.toLowerCase();
        while (true){
            String newPrompt;
            String invalidInputMsg = "";
            if(attempts > 0) {
                invalidInputMsg = "\n" + messages.getString("invalid-input") + "\n";
            }
            newPrompt = invalidInputMsg + prompt + possibleValuesString;
            String userInput = getString(newPrompt, in);
            String inputLowercase = userInput.toLowerCase();
            if(possibleValuesLowercase.contains(inputLowercase)){
                return userInput;
            }
            attempts += 1;
        }
    }

    /**
     * Prompts the user for a whole number between the low bound (inclusive) and
     * the high bound (inclusive).
     *
     * @param prompt the text of the user prompt
     * @param lowBound the lower boundary of the range, inclusive
     * @param highBound the upper boundary of the range, inclusive
     * @param in a Scanner object
     * @param messages a ResourceBundle object
     * @return the entered whole number
     */
    public static int getIntInRange(String prompt, int lowBound, int highBound, Scanner in, ResourceBundle messages) {
        int value = -1;
        boolean needed = true;
        while (needed) {
            value = getInt(prompt, in, messages);
            if (value < lowBound || value > highBound) {
                UIUtility.showErrorMessage(messages.getString("int-not-in-range") + " " + lowBound + " - " + highBound + ".", in, messages);
            } else {
                needed = false;
            }
        }
        return value;
    }

    /**
     * Prompts the user to enter a whole number. If the value is not a whole
     * number, prints the notIntMessage and tries again. Otherwise, returns the
     * int that was entered.
     *
     * @param prompt the prompt text for the user
     * @param in a Scanner object
     * @param messages a ResourceBundle object
     * @return the int entered
     */
    public static int getInt(String prompt, Scanner in, ResourceBundle messages) {
        int value = 0;
        String input;
        boolean needed = true;
        while (needed) {
            System.out.print(prompt + ": ");
            input = in.nextLine().trim();
            try {
                value = Integer.parseInt(input);
                needed = false;
            } catch (NumberFormatException nfe) {
                UIUtility.showErrorMessage(messages.getString("int-invalid"), in, messages);
            }
        }
        return value;
    }

    /**
     * Prompts the user to enter a number. If the value is not a number, it prints an invalid input message and tries again.  Otherwise, it returns the value that was entered.
     * @param prompt - the prompt text for the user
     * @param in - a Scanner object
     * @param messages - a ResourceBundle object
     * @return the number entered
     */
    public static double getDouble(String prompt, Scanner in, ResourceBundle messages){
        String input;
        while(true){
            try {
                input = getString(prompt, in);
                return Double.parseDouble(input);
            } catch (NumberFormatException nfe) {
                UIUtility.showErrorMessage(messages.getString("double-invalid"), in, messages);
            }
        }
    }

    /**
     * Prompts the user to enter a whole number. If the value is not a whole
     * number, prints the notIntMessage and tries again. Otherwise, returns the
     * int that was entered.
     *
     * @param prompt the prompt text for the user
     * @param in a Scanner object
     * @param messages a ResourceBundle object
     * @return the int entered
     */
    public static LocalDateTime getDate(String prompt, Scanner in, ResourceBundle messages) {
        LocalDateTime value = null;
        String input;
        boolean needed = true;
        while (needed) {
            System.out.print(prompt + " (YYYY-MM-DD): ");
            input = in.nextLine().trim();
            try {
                DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(input, formatterInput);
                value = date.atStartOfDay();
                needed = false;
            } catch (DateTimeParseException e) {
                UIUtility.showErrorMessage(messages.getString("date-invalid"), in, messages);
            }
        }
        return value;
    }


}