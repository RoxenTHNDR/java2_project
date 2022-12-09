package final_exam;

import java1refresher.Person;

public class Student extends Person implements Comparable<Student> {

    private String StudentID;
    private double gpa;

    public static final String DEFAULT_STUDENTID = "k0000000";
    public static final double DEFAULT_GPA = 0;

    public Student(){
        StudentID = DEFAULT_STUDENTID;
        gpa = DEFAULT_GPA;
    }

    public Student(String id, double newgpa){
        StudentID = id;
        gpa = newgpa;
    }

    public String getStudentId() {
        return StudentID;
    }

    public void setStudentId(String newid) {
        if(!(newid.length() == 8)){
            throw new IllegalArgumentException("ID must be 8 characters long");
        } else if (!(newid.charAt(0) == 'k')) {
            throw new IllegalArgumentException("ID must start with a 'k'");
        }
        StudentID = newid;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double newgpa) {
        if(newgpa < 0 || newgpa > 4) {
            throw new IllegalArgumentException("Gpa must be between 0 and 4");
        }
        gpa = newgpa;
    }

    @Override
    public String toString() {
        return StudentID + " " + gpa;
    }

    @Override
    public int compareTo(Student o) {
        if(this.gpa < o.gpa) {
            return 1;
        } else if (this.gpa > o.gpa){
            return -1;
        }
        else{return 0;}
    }
}
