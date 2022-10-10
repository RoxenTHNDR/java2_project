package en.codegym.task.pro.task13.task1309;

import java.util.HashMap;

/*
Student performance
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("A", 0d);
        grades.put("B", 0.0);
        grades.put("C", 0.0);
        grades.put("D", 0.0);
        grades.put("E", 0.0);
    }
}