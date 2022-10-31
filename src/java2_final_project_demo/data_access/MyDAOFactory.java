package java2_final_project_demo.data_access;

import java1refresher.Person;
import java2_final_project_demo.data_access.MyDAO;

public class MyDAOFactory {
    private static final String DAO_SOURCE = "CSV";

    public static MyDAO getMyDAO(String dao_source) {
        MyDAO<Person> dao = null;
        switch(dao_source.toUpperCase()) {
            case "CSV":

                break;
            case "XML":

                break;
            case "MYSQL":

                break;
        }
        return dao;
    }
}
