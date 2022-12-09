package java2_final_project_demo.data_access;

import java2_final_project_demo.MyException;
import java1refresher.Person;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class PersonDAO_CSV implements MyDAO<Person> {
    private static final String FILE_NAME = "src/main/resources/csv_files/person.csv";
    private List<Person> list;
    private int next_id = 0;

    @Override
    public void readInData() throws MyException {
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            list = new ArrayList<Person>();
            String line = "";
            int lineCount = 1;
            String[] fields;
            int id;
            String firstName;
            String lastName;
            int height;
            double weight;
            LocalDate dateOfBirth;
            line = reader.readLine(); // reads in header row
            while(true) {
                lineCount++;
                line = reader.readLine();
                if(line == null){
                    break;
                }
                fields = line.split(",");
                try {
                    id = Integer.parseInt(fields[0]);
                    firstName = fields[1];
                    lastName = fields[2];
                    height = Integer.parseInt(fields[3]);
                    weight = Double.parseDouble(fields[4]);
                    dateOfBirth = LocalDate.parse(fields[5]);
                } catch(NumberFormatException e) {
                    throw new MyException("Number error occurred on line " + lineCount + " in file '" + FILE_NAME + "'.");
                } catch(DateTimeParseException e) {
                    throw new MyException("Date error occurred on line " + lineCount + " in file '" + FILE_NAME + "'.");
                }
                Person person = new Person();
                for(Person p : list) {
                    if(p.getId() == id) {
                        throw new MyException("Duplicate id error occurred on line " + lineCount + " in file '" + FILE_NAME + "'.");
                    }
                }
                person.setId(id);
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setHeightInInches(height);
                person.setWeightInPounds(weight);
                person.setDateOfBirth(dateOfBirth.atStartOfDay());
                list.add(person);
                if(id > next_id) {
                    next_id = id;
                }
            }

        } catch(IOException e) {
            throw new IllegalArgumentException("File '" + FILE_NAME + "' not found");
        }
    }

    @Override
    public void add(Person obj) throws MyException {
        obj.setId(++next_id);
        list.add(obj);
        saveToFile();
    }

    private void saveToFile() throws MyException{
        try(FileWriter writer = new FileWriter(FILE_NAME)) {
            String line = "id,firstName,lastName,heightInInches,weightInPounds,dateOfBirth";
            writer.write(line + "\n");
            for(Person person: list) {
                line = person.getId() + ","
                        + person.getFirstName() + ","
                        + person.getLastName() + ","
                        + person.getHeightInInches() + ","
                        + person.getWeightInPounds() + ","
                        + person.getDateOfBirth().toLocalDate();
                writer.write(line + "\n");
            }
        } catch(IOException e) {
            throw new MyException("File '" + FILE_NAME + "' not found");
        }
    }

    @Override
    public Person get(int id) throws MyException {
        try(Scanner in = new Scanner(new File(FILE_NAME))){
            String line = in.nextLine();
            while(in.hasNextLine()){
                line = in.nextLine();
                String[] fields = line.split(",");
                if(id == Integer.parseInt(fields[0])) {
                    Person person = new Person();
                    person.setId(id);
                    person.setFirstName(fields[1]);
                    person.setLastName(fields[2]);
                    person.setHeightInInches(Integer.parseInt(fields[3]));
                    person.setWeightInPounds(Double.parseDouble(fields[4]));
                    person.setDateOfBirth(LocalDate.parse(fields[5]).atStartOfDay());
                    return person;

                }
            }
        } catch(FileNotFoundException e){

        }
        return null;
    }

    @Override
    public List<Person> get(String str) throws MyException {
        List<Person> result = new ArrayList<>();
        try(Scanner in = new Scanner(new File(FILE_NAME))){
            String line = in.nextLine();
            while(in.hasNextLine()){
                line = in.nextLine();
                String[] fields = line.split(",");
                String fName = fields[1].toLowerCase();
                String lName = fields[2].toLowerCase();
                if(fName.contains(str.toLowerCase()) || lName.contains(str.toLowerCase())
                        || fName.concat(" ".concat(lName)).equals(str.toLowerCase())) {
                    Person person = new Person();
                    person.setId(Integer.parseInt(fields[0]));
                    person.setFirstName(fields[1]);
                    person.setLastName(fields[2]);
                    person.setHeightInInches(Integer.parseInt(fields[3]));
                    person.setWeightInPounds(Double.parseDouble(fields[4]));
                    person.setDateOfBirth(LocalDate.parse(fields[5]).atStartOfDay());
                    result.add(person);
                }
            }
        } catch(FileNotFoundException e){

        }
        return result;
    }

    @Override
    public List<Person> get(LocalDate date) throws MyException {
        List<Person> result = new ArrayList<>();
        try(Scanner in = new Scanner(new File(FILE_NAME))){
            String line = in.nextLine();
            while(in.hasNextLine()){
                line = in.nextLine();
                String[] fields = line.split(",");
                if(date.equals(LocalDate.parse(fields[5]))) {
                    Person person = new Person();
                    person.setId(Integer.parseInt(fields[0]));
                    person.setFirstName(fields[1]);
                    person.setLastName(fields[2]);
                    person.setHeightInInches(Integer.parseInt(fields[3]));
                    person.setWeightInPounds(Double.parseDouble(fields[4]));
                    person.setDateOfBirth(LocalDate.parse(fields[5]).atStartOfDay());
                    result.add(person);
                }
            }
        } catch(FileNotFoundException e){

        }
        return result;
    }

    @Override
    public List<Person> getAll() throws MyException {
        return list;
    }

    @Override
    public void set(int id, Person obj) throws MyException {
        list.set(id, obj);
        saveToFile();
    }


    @Override
    public boolean remove(Person obj) throws MyException {
        boolean result = list.remove(obj);
        saveToFile();
        return result;
    }
}
