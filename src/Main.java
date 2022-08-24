import java1refresher.Book;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("Java a beginners Guide", "Herbert Schildt", true, 688);
//        System.out.println(book1);
//        System.out.println(book2);
        Book[] bookshelf = new Book[4];
        bookshelf[0] = book1;
        bookshelf[1] = book2;

//        for (Book book : bookshelf) {
//            System.out.println(book);
//        }
        for (int i = 0; i < Book.getBookCount(); i++){
            System.out.println(bookshelf[i]);
        }
    }
}