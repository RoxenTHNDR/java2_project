package java2_final_project_demo.data_access;

import java1refresher.Book;
import java1refresher.Person;
import java2_final_project_demo.MyException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDAO_CSV implements MyDAO<Book>{

    private static final String FILE_NAME = "src/main/resources/csv_files/book.csv";
    private List<Book> list;
    @Override
    public void readInData() throws MyException {
        try(Scanner scanner = new Scanner(new File(FILE_NAME))) {
            list = new ArrayList<>();
            String line = "";
            int lineCount = 1;
            String[] fields;
            int id;
            String title;
            Person author;
            boolean read;
            int numPages;
            LocalDate publishDate;
            double unitPrice;
            line = scanner.nextLine();
            while(scanner.hasNextLine()){
                lineCount++;
                line = scanner.nextLine();
                fields = line.split(",");
                try {
                    id = Integer.parseInt(fields[0]);
                    title = fields[1];
                    String[] name = fields[2].split(" ");
                    author = new Person(name[0],name[1]);
                    read = Boolean.parseBoolean(fields[3]);
                    numPages = Integer.parseInt(fields[4]);
                    publishDate = LocalDate.parse(fields[5]);
                    unitPrice = Double.parseDouble(fields[6]);

                } catch(NumberFormatException e) {
                    throw new MyException("Number error occurred on line " + lineCount + " in file '" + FILE_NAME + "'.");
                } catch(DateTimeParseException e) {
                    throw new MyException("Date error occurred on line " + lineCount + " in file '" + FILE_NAME + "'.");
                }

                Book book = new Book();
                for(Book boo : list) {
                    if(boo.getBookID() == id) {
                        throw new MyException("Duplicate id error occurred on line " + lineCount + " in file '" + FILE_NAME + "'.");
                    }
                }

                book.setBookID(id);
                book.setTitle(title);
                book.setAuthor(author);
                book.setRead(read);
                book.setNumPages(numPages);
                book.setPublishDate(publishDate);
                book.setUnitPrice(unitPrice);
                list.add(book);
            }



        } catch(FileNotFoundException e) {
            throw new MyException("File '" + FILE_NAME + "' not found");
        }
    }

    @Override
    public void add(Book obj) throws MyException {
        list.add(obj);
        saveToFile();
    }

    private void saveToFile() throws MyException{
        try(FileWriter writer = new FileWriter(FILE_NAME)) {
            String line = "id,title,author,read,numPages,datePublished,unitPrice";
            writer.write(line + "\n");
            for(Book book: list) {
                line = book.getBookID() + ","
                        + book.getTitle() + ","
                        + book.getAuthor() + ","
                        + book.getRead() + ","
                        + book.getNumPages() + ","
                        + book.getPublishDate() +","
                        + book.getUnitPrice();
                writer.write(line + "\n");
            }
        } catch(IOException e) {
            throw new MyException("File '" + FILE_NAME + "' not found");
        }
    }

    @Override
    public Book get(int id) throws MyException {
        try(Scanner in = new Scanner(new File(FILE_NAME))){
            String line = in.nextLine();
            while(in.hasNextLine()){
                line = in.nextLine();
                String[] fields = line.split(",");
                if(id == Integer.parseInt(fields[0])) {
                    Book book = new Book();
                    book.setBookID(id);
                    book.setTitle(fields[1]);
                    String[] name = fields[2].split(" ");
                    book.setAuthor(new Person(name[0],name[1]));
                    book.setRead(Boolean.parseBoolean(fields[3]));
                    book.setNumPages(Integer.parseInt(fields[4]));
                    book.setPublishDate(LocalDate.parse(fields[5]));
                    book.setUnitPrice(Double.parseDouble(fields[6]));
                    return book;

                }
            }
        } catch(FileNotFoundException e){

        }
        return null;
    }

    @Override
    public List<Book> get(String str) throws MyException {
        List<Book> result = new ArrayList<>();
        try(Scanner in = new Scanner(new File(FILE_NAME))){
            String line = in.nextLine();
            while(in.hasNextLine()){
                line = in.nextLine();
                String[] fields = line.split(",");
                String title = fields[1].toLowerCase();
                if(title.equals(str.toLowerCase())) {
                    Book book = new Book();
                    book.setBookID(Integer.parseInt(fields[0]));
                    book.setTitle(fields[1]);
                    String[] name = fields[2].split(" ");
                    book.setAuthor(new Person(name[0],name[1]));
                    book.setRead(Boolean.parseBoolean(fields[3]));
                    book.setNumPages(Integer.parseInt(fields[4]));
                    book.setPublishDate(LocalDate.parse(fields[5]));
                    book.setUnitPrice(Double.parseDouble(fields[6]));
                    result.add(book);
                }
            }
        } catch(FileNotFoundException e){

        }
        return result;
    }

    @Override
    public List<Book> get(LocalDate date) throws MyException {
        List<Book> result = new ArrayList<>();
        try(Scanner in = new Scanner(new File(FILE_NAME))){
            String line = in.nextLine();
            while(in.hasNextLine()){
                line = in.nextLine();
                String[] fields = line.split(",");
                String title = fields[1].toLowerCase();
                if(date.equals(LocalDate.parse(fields[5]))) {
                    Book book = new Book();
                    book.setBookID(Integer.parseInt(fields[0]));
                    book.setTitle(fields[1]);
                    String[] name = fields[2].split(" ");
                    book.setAuthor(new Person(name[0],name[1]));
                    book.setRead(Boolean.parseBoolean(fields[3]));
                    book.setNumPages(Integer.parseInt(fields[4]));
                    book.setPublishDate(LocalDate.parse(fields[5]));
                    book.setUnitPrice(Double.parseDouble(fields[6]));
                    result.add(book);
                }
            }
        } catch(FileNotFoundException e){

        }
        return result;
    }

    @Override
    public List<Book> getAll() throws MyException {
        return list;
    }

    @Override
    public void set(int id, Book obj) throws MyException {
        list.set(id, obj);
        saveToFile();
    }

    @Override
    public boolean remove(Book obj) throws MyException {
        boolean result = list.remove(obj);
        saveToFile();
        return result;
    }
}
