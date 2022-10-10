package en.codegym.task.pro.task13.task1310;

import java.util.HashMap;

/*
Student performance — 2
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println("Student list: ");
        printStudents();
        System.out.print("Average grade: " + getAverageMark());
    }

    public static void addStudents() {
        grades.put("William Butler Yeats", 4.3d);
        grades.put("Emily Dickenson", 4.1d);
        grades.put("William Shakespeare", 4.9d);
        grades.put("Maya Angelou", 3.7d);
        grades.put("Shel Silverstein", 3.2d);
    }

    public static void printStudents() {
        for(String name : grades.keySet()){

            System.out.println(name);

        }
    }

    public static Double getAverageMark() {
        double sum = 0;
        for(Double grade: grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
