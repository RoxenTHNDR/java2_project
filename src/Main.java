import java1refresher.Book;
import intro.assignments.Version;

import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Book book1 = new Book("PHP and MySQL", "Welling", true, 1000);
//        Book book2 = new Book("Java A Beginner's Guide","Herbert Schildt",true,688);
//        System.out.println(book1);
//        System.out.println(book2);
//        System.out.println(book2.getAuthor());
////        Book[] bookshelf = new Book[4];
//        List<Book> bookshelf = new ArrayList<>();
//        bookshelf.add(book1);
//        bookshelf.add(book2);
//        bookshelf.add(new Book("Java A Beginner's Guide","Herbert Schildt",true,720));
//        bookshelf.add(new Book());
//        bookshelf.remove(bookshelf.size() - 1);
//        System.out.println();
//        Collections.sort(bookshelf);
//        for(Book book: bookshelf) {
//            System.out.println(book);
//        }
//        System.out.println();
//        for(int i = 0; i < bookshelf.size(); i++) {
//            System.out.println(bookshelf.get(i));
//        }
//        System.out.println();
//        bookshelf.forEach(book -> System.out.println(book));
//        bookshelf.forEach(System.out::println);

        try {
            Version version;
            version = new Version();
            // version = new Version("1.2.3");
            // version = new Version("1.2.3.4");
            // version = new Version("1.2.3.d");
            // version = new Version("1");
            // version = new Version("1.1");
            // version = new Version(1, 2, 3);
            // version = new Version("a.b.c");
            // version = new Version("");

            System.out.println(version.getMajor());
            System.out.println(version.getMinor());
            System.out.println(version.getPatch());
            System.out.println(version);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}