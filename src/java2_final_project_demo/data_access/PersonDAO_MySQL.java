package java2_final_project_demo.data_access;

import java1refresher.Person;
import java2_final_project_demo.MyException;

import java.util.List;

import java.time.LocalDate;
import java.util.*;

public class PersonDAO_MySQL implements MyDAO<Person> {
    private List<Person> list;

    @Override
    public void readInData() throws MyException {

    }

    @Override
    public void add(Person obj) throws MyException {

    }

    @Override
    public Person get(int id) throws MyException {
        return null;
    }

    @Override
    public List<Person> get(String str) throws MyException {
        return null;
    }

    @Override
    public List<Person> get(LocalDate date) throws MyException {
        return null;
    }

    @Override
    public List<Person> getAll() throws MyException {
        return null;
    }

    @Override
    public void set(int id, Person obj) throws MyException {

    }

    @Override
    public boolean remove(Person obj) throws MyException {
        return false;
    }
}
