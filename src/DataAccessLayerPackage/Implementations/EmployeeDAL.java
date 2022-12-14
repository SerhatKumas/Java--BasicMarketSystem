package DataAccessLayerPackage.Implementations;

import AssetsPackage.CharacterPackage.Employee;
import AssetsPackage.CharacterPackage.Worker;
import DataAccessLayerPackage.Interfaces.ICharacterDAL;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class EmployeeDAL implements ICharacterDAL {

    @Override
    public void displayById(Statement statement, String id) {
        try {
        ResultSet resultSet = statement.executeQuery("select * from employeetable where EmployeeId = '"+id+"'");
        while(resultSet.next()){
            System.out.println("Employee Id : "+resultSet.getString(1) + " \nEmployee Name : "+resultSet.getString(2)+" \nEmployee Phone : "+resultSet.getString(3)+" \nEmployee SSN : "+resultSet.getString(4)+" \nEmployee Adress : "+resultSet.getString(5)+" \nEmployee Market Id : "+resultSet.getString(6)+" \nEmployee birth date : "+resultSet.getDate(7)+" \nEmployee Title : "+resultSet.getString(8)+" \nEmployee Job Start Date : "+resultSet.getDate(9)+" \nEmployee Job End Date : "+null+"\n");
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    }

    @Override
    public void displayByName(Statement statement, String name) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employeetable WHERE EmployeeName = '"+name+"'");
            while(resultSet.next()){
                System.out.println("Employee Id : "+resultSet.getString(1) + " \nEmployee Name : "+resultSet.getString(2)+" \nEmployee Phone : "+resultSet.getString(3)+" \nEmployee SSN : "+resultSet.getString(4)+" \nEmployee Adress : "+resultSet.getString(5)+" \nEmployee Market Id : "+resultSet.getString(6)+" \nEmployee birth date : "+resultSet.getDate(7)+" \nEmployee Title : "+resultSet.getString(8)+" \nEmployee Job Start Date : "+resultSet.getDate(9)+" \nEmployee Job End Date : "+null+"\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void displayBySsn(Statement statement, String ssn) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employeetable WHERE EmployeeSSN = '"+ssn+"'");
            while(resultSet.next()){
                System.out.println("Employee Id : "+resultSet.getString(1) + " \nEmployee Name : "+resultSet.getString(2)+" \nEmployee Phone : "+resultSet.getString(3)+" \nEmployee SSN : "+resultSet.getString(4)+" \nEmployee Adress : "+resultSet.getString(5)+" \nEmployee Market Id : "+resultSet.getString(6)+" \nEmployee birth date : "+resultSet.getDate(7)+" \nEmployee Title : "+resultSet.getString(8)+" \nEmployee Job Start Date : "+resultSet.getDate(9)+" \nEmployee Job End Date : "+null+"\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(Statement statement, String id) {
        try {
         boolean isDeleted = statement.execute("DELETE FROM employeetable WHERE EmployeeId = '"+id+"'");
         if(isDeleted){
             System.out.println("Employee with "+id+" is deleted.");
         }
         else{
             System.out.println("Employee can not be deleted.");
         }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteBySsn(Statement statement, String ssn) {
        try {
            boolean isDeleted = statement.execute("DELETE FROM employeetable WHERE EmployeeSSN = '"+ssn+"'");
            if(isDeleted){
                System.out.println("Employee with "+ssn+" is deleted.");
            }
            else{
                System.out.println("Employee can not be deleted.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createNewEmployee(Statement statement, String workerId, String name, String phone, String ssn, String address, String marketId, Date dateOfBirth, String title, Date startDate, Date endDate, String workerPassword) {
        try {
            boolean isAdded = statement.execute("INSERT INTO employeetable (`EmployeeId`, `EmployeeName`, `EmployeePhone`, `EmployeeSSN`, `EmployeeAddress`, `MarketId`, `DateOfBirth`, `EmployeeTitle`, `StartDate`, `EndDate`, `WorkerPassword`) VALUES ('"+workerId+"', '"+name+"', '"+phone+"', '"+ssn+"', '"+address+"', '"+marketId+"', '"+dateOfBirth+"', '"+title+"', '"+startDate+"', '"+endDate+"', '"+workerPassword+"')");
            if(isAdded){
                System.out.println("Employee with is added.");
            }
            else{
                System.out.println("Employee can not be added.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
