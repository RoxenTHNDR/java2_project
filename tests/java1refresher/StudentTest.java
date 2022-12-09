package java1refresher;

import final_exam.Student;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student student;

    @BeforeEach
    void setup(){
        student = new Student();
    }

    @Test
    void testGetStudentID(){
        assertEquals(Student.DEFAULT_STUDENTID,student.getStudentId());
    }

    @Test
    void testSetStudentID(){
        student.setStudentId("k0000001");
        assertEquals("k0000001",student.getStudentId());

        Exception e = assertThrows(IllegalArgumentException.class, () -> student.setStudentId("1"));
        assertEquals("ID must be 8 characters long", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> student.setStudentId("00000000"));
        assertEquals("ID must start with a 'k'", e.getMessage());
    }

    @Test
    void testGetGPA(){
        assertEquals(Student.DEFAULT_GPA,student.getGpa());
    }

    @Test
    void testSetGPA(){
        student.setGpa(3.1);
        assertEquals(3.1,student.getGpa());

        Exception e = assertThrows(IllegalArgumentException.class, () -> student.setGpa(-100));
        assertEquals("Gpa must be between 0 and 4", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> student.setGpa(100));
        assertEquals("Gpa must be between 0 and 4", e.getMessage());
    }

    @Test
    void testToSTring(){
        assertEquals("k0000000 0.0",student.toString());
    }

    @Test
    void testCompareTo(){
        Student student2 = new Student("k0000002",2);
        assertTrue(student.compareTo(student2) > 0);
        assertTrue(student2.compareTo(student) < 0);
        assertTrue(student.compareTo(student) == 0);

    }


}
