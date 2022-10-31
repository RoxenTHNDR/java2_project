package generics;

import java1refresher.Book;

import java.math.BigDecimal;
import java.time.LocalDate;

// A simple generic class with two type
// parameters: T and V.
class TwoGen<T, V> {
    T ob1;
    V ob2;

    // Pass the constructor a reference to
    // an object of type T.
    TwoGen(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    // Show types of T and V.
    void showTypes() {
        System.out.println("Type of T is " +
                ob1.getClass().getSimpleName());

        System.out.println("Type of V is " +
                ob2.getClass().getSimpleName());
    }

    T getob1() {
        return ob1;
    }

    V getob2() {
        return ob2;
    }
}

// Demonstrate TwoGen.
class Main2 {
    public static void main(String args[]) {

        TwoGen<Integer, String> tgObj =
                new TwoGen<Integer, String>(88, "Generics");

        // Show the types.
        tgObj.showTypes();

        // Obtain and show values.
        int v = tgObj.getob1();
        System.out.println("value: " + v);

        String str = tgObj.getob2();
        System.out.println("value: " + str);


        TwoGen<LocalDate, Book> myObj;

        System.out.println();
        myObj = new TwoGen<>(LocalDate.now(), new Book());
        System.out.println("value: " + myObj.getob1());
        System.out.println("value: " + myObj.getob2());

        TwoGen<Book, Integer> bookCount;
        TwoGen<Book, Double> bookCount2;
        TwoGen<Book, BigDecimal> bookCount3;
        TwoGen<Book, Apple> bookCount4;
    }

}