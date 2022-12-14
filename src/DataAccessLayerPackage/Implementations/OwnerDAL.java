package DataAccessLayerPackage.Implementations;

import AssetsPackage.CharacterPackage.Worker;
import DataAccessLayerPackage.Interfaces.ICharacterDAL;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class OwnerDAL implements ICharacterDAL {

    @Override
    public void displayById(Statement statement, String id) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ownertable WHERE OwnerId = '"+id+"'");
            while(resultSet.next()){
                System.out.println("Owner Id : "+resultSet.getString(1) + " \nOwner Name : "+resultSet.getString(2)+" \nOwner Phone : "+resultSet.getString(3)+" \nOwner SSN : "+resultSet.getString(4)+" \nOwner Adress : "+resultSet.getString(5)+" \nOwner Market Id : "+resultSet.getString(6)+" \nOwner birth date : "+resultSet.getDate(7)+" \nOwner Share Percentage : "+resultSet.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void displayByName(Statement statement, String name) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ownertable WHERE OwnerName = '"+name+"'");
            while(resultSet.next()){
                System.out.println("Owner Id : "+resultSet.getString(1) + " \nOwner Name : "+resultSet.getString(2)+" \nOwner Phone : "+resultSet.getString(3)+" \nOwner SSN : "+resultSet.getString(4)+" \nOwner Adress : "+resultSet.getString(5)+" \nOwner Market Id : "+resultSet.getString(6)+" \nOwner birth date : "+resultSet.getDate(7)+" \nOwner Share Percentage : "+resultSet.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void displayBySsn(Statement statement, String ssn) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ownertable WHERE OwnerSSN = '"+ssn+"'");
            while(resultSet.next()){
                System.out.println("Owner Id : "+resultSet.getString(1) + " \nOwner Name : "+resultSet.getString(2)+" \nOwner Phone : "+resultSet.getString(3)+" \nOwner SSN : "+resultSet.getString(4)+" \nOwner Adress : "+resultSet.getString(5)+" \nOwner Market Id : "+resultSet.getString(6)+" \nOwner birth date : "+resultSet.getDate(7)+" \nOwner Share Percentage : "+resultSet.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(Statement statement, String id) {
        try {
            boolean isDeleted = statement.execute("DELETE FROM ownertable WHERE OwnerId = '"+id+"'");
            if(isDeleted){
                System.out.println("Owner can not be deleted.");
            }
            else{
                System.out.println("Owner with "+id+" id is deleted.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteBySsn(Statement statement, String ssn) {
        try {
            boolean isDeleted = statement.execute("DELETE FROM ownertable WHERE OwnerSSN = '"+ssn+"'");
            if(isDeleted){
                System.out.println("Owner can not be deleted.");

            }
            else{
                System.out.println("Owner with "+ssn+" ssn is deleted.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createNewOwner(Statement statement, String name, String phone, Date dateOfBirth, String ssn, String address, String workerId, String marketId, String workerPassword, float sharePercentage) {
        try {
            String stringSharePercentage = Float.toString(sharePercentage);
            boolean isAdded = statement.execute("INSERT INTO ownertable (`OwnerId`, `OwnerName`, `OwnerPhone`, `OwnerSSN`, `OwnerAddress`, `MarketId`, `DateOfBirth`, `WorkerPassword`, `SharePercentage`) VALUES ('"+workerId+"', '"+name+"', '"+phone+"', '"+ssn+"', '"+address+"', '"+marketId+"', '"+dateOfBirth+"', '"+workerPassword+"', '"+ stringSharePercentage+"')");
            if(isAdded){
                System.out.println("Owner can not be added.");
            }
            else{
                System.out.println("Owner with is added.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}