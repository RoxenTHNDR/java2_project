package challenge1;

import java1refresher.Book;
import java1refresher.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    
    private Book book;
    @BeforeEach
    void setup(){
        book = new Book();
    }

    @Test
    void getTitle(){
        assertEquals(Book.DEFAULT_TITLE, book.getTitle());
    }

    @Test
    void setTitle(){
        // Good tests
        book.setTitle("Gone with the wind");
        assertEquals("Gone with the wind", book.getTitle());

        // Bad tests
        Exception ex = assertThrows(IllegalArgumentException.class, () -> book.setTitle(""));
        assertEquals(Book.NO_EMPTY_TITLE, ex.getMessage());
    }

    @Test
    void getAuthor(){
        assertEquals(Person.DEFAULT_FIRST_NAME,book.getAuthor().getFirstName());
        assertEquals(Person.DEFAULT_LAST_NAME,book.getAuthor().getLastName());
    }

    @Test
    void setAuthor(){
        // Good tests
        book.setAuthor(new Person("Jules", "Vern"));
        assertEquals("Jules",book.getAuthor().getFirstName());
        assertEquals("Vern",book.getAuthor().getLastName());

        // Bad tests
        Exception ex = assertThrows(IllegalArgumentException.class, () -> book.setAuthor(null));
        assertEquals(Book.NO_NULL_AUTHOR, ex.getMessage());
    }

    @Test
    void getNumPages(){
        assertEquals(Book.DEFAULT_PAGES,book.getNumPages());
    }

    @Test
    void setNumPages(){
        // Good tests
        book.setNumPages(50);
        assertEquals(50,book.getNumPages());
        book.setNumPages(100);
        assertEquals(100,book.getNumPages());

        // Bad tests
        Exception ex = assertThrows(IllegalArgumentException.class, () -> book.setNumPages(-1));
        assertEquals(Book.GREATER_THAN_ZERO, ex.getMessage());
        ex = assertThrows(IllegalArgumentException.class, () -> book.setNumPages(-10));
        assertEquals(Book.GREATER_THAN_ZERO, ex.getMessage());
    }

    @Test
    void getPublishDate(){
        assertEquals(Book.DEFAULT_PUBLISH_DATE,book.getPublishDate());
    }

    @Test
    void setPublishDate(){

        // Good test
        LocalDate yesterday = LocalDate.now().minusDays(1);
        book.setPublishDate(yesterday);
        assertTrue(book.getPublishDate().equals(yesterday));

        // Bad tests
        Exception ex =assertThrows(IllegalArgumentException.class, () -> book.setPublishDate(LocalDate.now().plusDays(1)));
        assertEquals(Book.NO_FUTURE, ex.getMessage());

        assertThrows(IllegalArgumentException.class, () -> book.setPublishDate(LocalDate.now().plusDays(1)));
    }

    @Test
    void getUnitPrice(){
        assertEquals(Book.DEFAULT_UNIT_PRICE,book.getUnitPrice());
    }

    @Test
    void setUnitPrice(){

        // Good test
        book.setUnitPrice(0.99);
        assertEquals(0.99, book.getUnitPrice());
        book.setUnitPrice(0.992);
        assertEquals(0.99, book.getUnitPrice());
        book.setUnitPrice(10.992);
        assertEquals(10.99, book.getUnitPrice());

        // Bad Test
        Exception ex = assertThrows(IllegalArgumentException.class, () -> book.setUnitPrice(-1));
        assertEquals(Book.UNIT_PRICE_OVER_ZERO, ex.getMessage());
        ex = assertThrows(IllegalArgumentException.class, () -> book.setUnitPrice(-1.99));
        assertEquals(Book.UNIT_PRICE_OVER_ZERO, ex.getMessage());

    }

    @Test
    void testToString() {
        assertEquals("Book{" + "title='"
                                     + book.getTitle()
                                     + '\''
                                     + ", author='"
                                     + book.getAuthor()
                                     + '\''
                                     + ", read="
                                     + book.isRead()
                                     + ", numPages="
                                     + book.getNumPages()
                                     + '}',
                book.toString());
    }

    @Test
    void TestCompareTo() {
        Book book1 = new Book("Gone with the wind",new Person("Jules", "Vern"),false,20,LocalDate.now().minusYears(50),0.99);
        Book book2 = new Book("Bible",new Person("Jesus", "Christ"),true,349, LocalDate.now().minusYears(1000),5.99);
        assertTrue(book.compareTo(book2) < 0);
        assertTrue(book.compareTo(book1) < 0);
        assertTrue(book.compareTo(book) == 0);
        assertTrue(book2.compareTo(book) > 0);
        assertTrue(book2.compareTo(book1) >0);
        assertTrue(book2.compareTo(book2) == 0);
    }
}
