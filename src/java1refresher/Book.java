package java1refresher;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class Book implements Comparable<Book>{
    private String title;
    private Person author;
    private boolean read;
    private int numPages;
    private double unitPrice;
    private static  LocalDate publishDate;
    private int bookID;
    public static final int DEFAULT_BOOKID = 100000000;
    public static final String DEFAULT_TITLE = "Undefined";
    public static final LocalDate DEFAULT_PUBLISH_DATE = LocalDate.now();
    public static final LocalDateTime MIDNIGHT_TONIGHT = LocalDateTime.of(
            LocalDate.now(ZoneId.of("America/Chicago")), LocalTime.MIDNIGHT).plusDays(1);
    public static final String NO_EMPTY_TITLE = "The title is required.";
    public static  final String NO_NULL_AUTHOR = "The author is required.";
    public static final int DEFAULT_PAGES = 1;
    public static final String GREATER_THAN_ZERO = "Pages must be greater than 0.";
    public static final double DEFAULT_UNIT_PRICE = 0.00;
    public static final String UNIT_PRICE_OVER_ZERO = "Price must be equal to or less than 0";
    public static final String NO_FUTURE = "Publish date hasn't happened yet?";
    public static final String VALID_ID = "Please insert a valid ID.";
    private static int bookCount = 0;

    public Book() {
        title = DEFAULT_TITLE;
        author  = new Person();
        read = false;
        numPages = DEFAULT_PAGES;
        publishDate = DEFAULT_PUBLISH_DATE;
        unitPrice = DEFAULT_UNIT_PRICE;
        bookID = DEFAULT_BOOKID;
        bookCount++;
    }

    public Book( String title, Person author, boolean read, int numPages, LocalDate date, double price) {
        setTitle(title);
        setAuthor(author);
        setRead(read);
        setNumPages(numPages);
        setPublishDate(date);
        setUnitPrice(price);
        bookCount++;
    }

    public Book( int id,String title, Person author, boolean read, int numPages, LocalDate date, double price) {
        setTitle(title);
        setAuthor(author);
        setRead(read);
        setNumPages(numPages);
        setPublishDate(date);
        setUnitPrice(price);
        setBookID(id);
        bookCount++;
    }

    public Book(String title) {
        this.title = title;
        author  = new Person();
        read = false;
        numPages = 1;
        bookCount++;
    }

    public static int getBookCount() {
        return bookCount;
    }

    public String getTitle() {
        return title;
    }
    public Person getAuthor() {
        return author;
    }
    public boolean isRead() {
        return read;
    }
    public int getNumPages() {
        return numPages;
    }

    public void setTitle(String title) {
        if(title.equals("")) {
            throw new IllegalArgumentException(NO_EMPTY_TITLE);
        } else {
            this.title = title;
        }
    }
    public void setAuthor(Person author) {
        if(author == null) {
            throw new IllegalArgumentException(NO_NULL_AUTHOR);
        } else {
            this.author = author;
        }
    }
    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean getRead(){
        return read;
    }
    public void setNumPages(int numPages) {
        if(numPages < 1 ) {
            throw new IllegalArgumentException(GREATER_THAN_ZERO);
        } else {
            this.numPages = numPages;
        }
    }
    public void setBookID(int id) {
        if(id < 100000000){
            throw new IllegalArgumentException(VALID_ID);
        }
        else{
            bookID = id;
        }
    }

    public int getBookID() {
        return bookID;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate date) {
        if(date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(NO_FUTURE);
        }
        publishDate = date;
    }

    public double getUnitPrice(){
        return unitPrice;
    }

    public void setUnitPrice(double price){
        if(price <= 0 ) {
            throw new IllegalArgumentException(UNIT_PRICE_OVER_ZERO);
        } else {
            BigDecimal bigPrice = new BigDecimal(price).setScale(2, RoundingMode.HALF_DOWN);
            unitPrice = bigPrice.doubleValue();
        }
    }



    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", read=" + read +
                ", numPages=" + numPages +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        int result = this.title.compareTo(o.title) * -1;
        if(result == 0)
            result = (this.numPages - o.numPages) * -1;
        return result;
    }
}

