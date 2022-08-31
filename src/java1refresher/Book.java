package java1refresher;

public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private boolean read;
    private int numPages;
    private static final String DEFAULT_TITLE = "Undefined";
    private static int bookCount = 0;

    public Book() {
        title = DEFAULT_TITLE;
        author  = DEFAULT_TITLE;
        read = false;
        numPages = 1;
        bookCount++;
    }

    public Book(String title, String author, boolean read, int numPages) {
        setTitle(title);
        setAuthor(author);
        setRead(read);
        setNumPages(numPages);
        bookCount++;
    }

    public static int getBookCount() {
        return bookCount;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
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
            throw new IllegalArgumentException("The title is required.");
        } else {
            this.title = title;
        }
    }
    public void setAuthor(String author) {
        if(author.equals("")) {
            throw new IllegalArgumentException("The author is required.");
        } else {
            this.author = author;
        }
    }
    public void setRead(boolean read) {
        this.read = read;
    }
    public void setNumPages(int numPages) {
        if(numPages < 1 ) {
            throw new IllegalArgumentException("There must be at least one page.");
        } else {
            this.numPages = numPages;
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
