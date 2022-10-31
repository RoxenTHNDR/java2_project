package generics;

import java1refresher.Book;

public class GenericsDemo {
    public static void main(String[] args) {
        Box<Food> box = new Box<Food>();
        Apple apple = new Apple();
        box.add(apple);
        Banana banana = new Banana();
        box.add(banana);
        Food food = box.remove();
        box.add(banana);
        food = box.remove();

        Box<Book> box2= new Box<>();
        Book book = new Book();
        add(book, box2);
//        add(apple, box2); Red line due to type
    }

    public static <T> void add(T item, Box<T> box) {
        box.add(item);
    }
}
