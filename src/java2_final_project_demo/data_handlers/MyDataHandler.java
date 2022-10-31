package java2_final_project_demo.data_handlers;

import java2_final_project_demo.data_access.MyDAO;
import java2_final_project_demo.MyException;

import java.util.ResourceBundle;
import java.util.Scanner;

public interface MyDataHandler {
    void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException;
}