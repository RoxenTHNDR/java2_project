package java1refresher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;
    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void getFirstName() {
        assertEquals(Person.DEFAULT_FIRST_NAME, person.getFirstName());
    }

    @Test
    void setFirstName() {
        // Good tests
        person.setFirstName("Marvin");
        assertEquals("Marvin", person.getFirstName());

        // Bad tests
        Exception e = assertThrows(IllegalArgumentException.class, () -> person.setFirstName("1"));
        assertEquals(Person.FIRST_NAME_NO_NUMBER_ERR, e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> person.setFirstName(""));
        assertEquals(Person.FIRST_NAME_EMPTY_ERR, e.getMessage());
    }

    @Test
    void getLastName() {
        assertEquals(Person.DEFAULT_LAST_NAME, person.getLastName());
    }

    @Test
    void setLastName() {
        fail();
    }

    @Test
    void getHeightInInches() {
        assertEquals(Person.DEFAULT_HEIGHT, person.getHeightInInches());
    }

    @Test
    void setHeightInInches() {
        // Good data
        person.setHeightInInches(0);
        assertEquals(0, person.getHeightInInches());
        person.setHeightInInches(100);
        assertEquals(100, person.getHeightInInches());
        //Bad input data
        assertThrows(IllegalArgumentException.class, () -> person.setHeightInInches(-1));
        assertThrows(IllegalArgumentException.class, () -> person.setHeightInInches(101));
    }

    @Test
    void getWeightInPounds() {
        assertEquals(Person.DEFAULT_WEIGHT, person.getWeightInPounds());
    }

    @Test
    void setWeightInPounds() {
        fail();
    }

    @Test
    void getDateOfBirth() {
        assertEquals(Person.DEFAULT_DOB, person.getDateOfBirth());
    }

    @Test
    void setDateOfBirth() {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        person.setDateOfBirth(yesterday);
        assertTrue(person.getDateOfBirth().equals(yesterday));

        LocalDateTime laterToday = LocalDateTime.now().plusHours(9);
        person.setDateOfBirth(laterToday);
        assertTrue(person.getDateOfBirth().equals(laterToday));

        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        assertThrows(IllegalArgumentException.class, () -> person.setDateOfBirth(tomorrow));
    }

    @Test
    void testToString() {
        assertEquals(String.format("Person{firstName='%s', lastName='%s'}",
                Person.DEFAULT_FIRST_NAME, Person.DEFAULT_LAST_NAME), person.toString());
    }

    @Test
    void compareTo() {
        Person person2 = new Person("Amy", "Hauschildt");
        Person person3 = new Person("Marc", "Hauschildt");
        Person person4 = new Person("Jane", "Doe");
        assertTrue(person.compareTo(person2) < 0); // Doe to Hauschildt
        assertTrue(person.compareTo(person4) > 0); // John Doe to Jane Doe
        assertTrue(person2.compareTo(person3) < 0); // Amy Hauschildt to Marc Hauschildt
        assertTrue(person3.compareTo(person4) > 0); // Hauschildt to Doe
        assertTrue(person.compareTo(person) == 0);
    }
}