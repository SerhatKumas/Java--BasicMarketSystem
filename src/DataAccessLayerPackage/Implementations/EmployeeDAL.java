package DataAccessLayerPackage.Implementations;

import DataAccessLayerPackage.Interfaces.ICharacterDAL;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class EmployeeDAL implements ICharacterDAL {

    //Displays all employee in employee table
    @Override
    public void displayAll(Statement statement) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employeetable where EndDate = '0000-00-00'");
            while (resultSet.next()) {
                System.out.println("Employee Id : " + resultSet.getString(1) + " \nEmployee Name : " + resultSet.getString(2) + " \nEmployee Phone : " + resultSet.getString(3) + " \nEmployee SSN : " + resultSet.getString(4) + " \nEmployee Adress : " + resultSet.getString(5) + " \nEmployee Market Id : " + resultSet.getString(6) + " \nEmployee birth date : " + resultSet.getDate(7) + " \nEmployee Title : " + resultSet.getString(8) + " \nEmployee Job Start Date : " + resultSet.getDate(9) + "\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays employee by employee id in employee table
    @Override
    public void displayById(Statement statement, String id) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employeetable WHERE EmployeeId = '" + id + "' AND EndDate = '0000-00-00'");
            while (resultSet.next()) {
                System.out.println("Employee Id : " + resultSet.getString(1) + " \nEmployee Name : " + resultSet.getString(2) + " \nEmployee Phone : " + resultSet.getString(3) + " \nEmployee SSN : " + resultSet.getString(4) + " \nEmployee Adress : " + resultSet.getString(5) + " \nEmployee Market Id : " + resultSet.getString(6) + " \nEmployee birth date : " + resultSet.getDate(7) + " \nEmployee Title : " + resultSet.getString(8) + " \nEmployee Job Start Date : " + resultSet.getDate(9) + "\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays employee by employee name in employee table
    @Override
    public void displayByName(Statement statement, String name) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employeetable WHERE EmployeeName = '" + name + "' AND EndDate = '0000-00-00'");
            while (resultSet.next()) {
                System.out.println("Employee Id : " + resultSet.getString(1) + " \nEmployee Name : " + resultSet.getString(2) + " \nEmployee Phone : " + resultSet.getString(3) + " \nEmployee SSN : " + resultSet.getString(4) + " \nEmployee Adress : " + resultSet.getString(5) + " \nEmployee Market Id : " + resultSet.getString(6) + " \nEmployee birth date : " + resultSet.getDate(7) + " \nEmployee Title : " + resultSet.getString(8) + " \nEmployee Job Start Date : " + resultSet.getDate(9) + "\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays employee by employee ssn in employee table
    @Override
    public void displayBySsn(Statement statement, String ssn) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employeetable WHERE EmployeeSSN = '" + ssn + "' AND EndDate = '0000-00-00'");
            while (resultSet.next()) {
                System.out.println("Employee Id : " + resultSet.getString(1) + " \nEmployee Name : " + resultSet.getString(2) + " \nEmployee Phone : " + resultSet.getString(3) + " \nEmployee SSN : " + resultSet.getString(4) + " \nEmployee Adress : " + resultSet.getString(5) + " \nEmployee Market Id : " + resultSet.getString(6) + " \nEmployee birth date : " + resultSet.getDate(7) + " \nEmployee Title : " + resultSet.getString(8) + " \nEmployee Job Start Date : " + resultSet.getDate(9) + "\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Deletes employee by employee id in employee table
    @Override
    public void deleteById(Statement statement, String id) {
        try {
            boolean isDeleted = statement.execute("DELETE FROM employeetable WHERE EmployeeId = '" + id + "' AND EndDate = '0000-00-00'");
            if (isDeleted) {
                System.out.println("Employee can not be deleted.");

            } else {
                System.out.println("Employee with " + id + " id is deleted.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Deletes employee by employee ssn in employee table
    @Override
    public void deleteBySsn(Statement statement, String ssn) {
        try {
            boolean isDeleted = statement.execute("DELETE FROM employeetable WHERE EmployeeSSN = '" + ssn + "' AND EndDate = '0000-00-00'");
            if (isDeleted) {
                System.out.println("Employee can not be deleted.");
            } else {
                System.out.println("Employee with " + ssn + " ssn is deleted.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Creates employee in employee table
    public void createNewEmployee(Statement statement, String workerId, String name, String phone, String ssn, String address, String marketId, Date dateOfBirth, String title, Date startDate, Date endDate, String workerPassword) {
        try {
            boolean isAdded = statement.execute("INSERT INTO employeetable (`EmployeeId`, `EmployeeName`, `EmployeePhone`, `EmployeeSSN`, `EmployeeAddress`, `MarketId`, `DateOfBirth`, `EmployeeTitle`, `StartDate`, `EndDate`, `WorkerPassword`) VALUES ('" + workerId + "', '" + name + "', '" + phone + "', '" + ssn + "', '" + address + "', '" + marketId + "', '" + dateOfBirth + "', '" + title + "', '" + startDate + "', '" + endDate + "', '" + workerPassword + "')");
            if (isAdded) {
                System.out.println("Employee can not be added.");

            } else {
                System.out.println("Employee is added.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
