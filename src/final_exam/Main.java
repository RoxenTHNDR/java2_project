package final_exam;


import java1refresher.Book;

import java.util.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {



    public static void main(String[] args){
        ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.getDefault());
        System.out.println("\n" + messages.getString("usa"));
        messages = ResourceBundle.getBundle("messages", new Locale("de", "DE"));
        System.out.println("\n" + messages.getString("usa"));
        messages = ResourceBundle.getBundle("messages", new Locale("fr", "FR"));
        System.out.println("\n" + messages.getString("usa"));

        ParkingSpace<Car> car;
        ParkingSpace<Motorcycle> bike;
        //ParkingSpace<Book> book;
    }


}
