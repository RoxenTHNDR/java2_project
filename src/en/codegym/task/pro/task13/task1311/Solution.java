package en.codegym.task.pro.task13.task1311;

import java.util.HashMap;
import java.util.Map;

/*
Student performance — 3
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        printStudentsInfo();
    }

    public static void addStudents() {
        grades.put("Walt Whitman", 4.3d);
        grades.put("Emily Dickenson", 4.1d);
        grades.put("William Shakespeare", 4.9d);
        grades.put("Maya Angelou", 3.7d);
        grades.put("Shel Silverstein", 3.2d);
    }

    public static void printStudentsInfo() {
        for(Map.Entry student: grades.entrySet()){
            System.out.println(student.getKey() + ": " + student.getValue());
        }
    }


}
