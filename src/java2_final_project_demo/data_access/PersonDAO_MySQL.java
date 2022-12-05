package java2_final_project_demo.data_access;

import java2_final_project_demo.MyException;
import java1refresher.Person;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class PersonDAO_MySQL implements MyDAO<Person> {

    List<Person> list;

    private Connection getConnection() throws SQLException {
        String driver = "mariadb";
        String host = "127.0.0.1";
        String port = "3307";
        String db_name = "java2_22";
        String user = "root";
        String password = "password";
        String connectionString = "jdbc:"+ driver +"://"+ host +":" + port + "/" + db_name;
        Connection connection = DriverManager.getConnection(connectionString, user, password);
        return connection;
    }

    @Override
    public void readInData() throws MyException {
        try(Connection connection = getConnection()) {
            if(connection.isValid(2)) {
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
                CallableStatement statement = connection.prepareCall("{call sp_get_all_people()}");
                ResultSet resultSet = statement.executeQuery();
                list = new ArrayList<>();
                while(resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    int heightInInches = resultSet.getInt("heightInInches");
                    double weightInPounds = resultSet.getDouble("weightInPounds");
                    LocalDateTime dateOfBirth= resultSet.getTimestamp("dateOfBirth").toLocalDateTime();
                    Person person = new Person(id, firstName, lastName, heightInInches, weightInPounds, dateOfBirth);
                    list.add(person);
                }
                resultSet.close();
                statement.close();
            }
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
        }
    }

    @Override
    public void add(Person obj) throws MyException {
        // add to ArrayList
        if(list == null) {
            readInData();
        }
        list.add(obj);
        // add to database
        try (Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{call sp_add_person(?, ?, ?, ?, ?)}");
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.setInt(3, obj.getHeightInInches());
            statement.setDouble(4, obj.getWeightInPounds());
            statement.setTimestamp(5, Timestamp.valueOf(obj.getDateOfBirth()));
            statement.execute();
            statement.close();
        } catch(SQLException e) {

        }
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
        if(list == null) {
            readInData();
        }
        return list;
    }

    @Override
    public void set(int id, Person obj) throws MyException {

    }

    @Override
    public boolean remove(Person obj) throws MyException {
        return false;
    }
}
