package DataAccessLayerPackage.Implementations;

import AssetsPackage.ShiftPackage.Shift;
import DataAccessLayerPackage.Interfaces.IShiftDAL;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class ShiftDAL implements IShiftDAL {

    @Override
    public void displayAllShifts(Statement statement) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shifttable");
            while(resultSet.next()){
                System.out.println("Shift Id : "+resultSet.getString(1) + " \nEmployee Id : "+resultSet.getString(2)+" \nEmployee Name : "+resultSet.getString(3)+" \nStart Time : "+resultSet.getString(4)+" \nEnd Time : "+resultSet.getString(5)+" \nShift Day : "+resultSet.getDate(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void displayByShiftId(Statement statement, String id) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shifttable WHERE ShiftId = '"+id+"'");
            while(resultSet.next()){
                System.out.println("Shift Id : "+resultSet.getString(1) + " \nEmployee Id : "+resultSet.getString(2)+" \nEmployee Name : "+resultSet.getString(3)+" \nStart Time : "+resultSet.getString(4)+" \nEnd Time : "+resultSet.getString(5)+" \nShift Day : "+resultSet.getDate(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void displayByDate(Statement statement, String date) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shifttable WHERE ShiftDate = '"+date+"'");
            while(resultSet.next()){
                System.out.println("Shift Id : "+resultSet.getString(1) + " \nEmployee Id : "+resultSet.getString(2)+" \nEmployee Name : "+resultSet.getString(3)+" \nStart Time : "+resultSet.getString(4)+" \nEnd Time : "+resultSet.getString(5)+" \nShift Day : "+resultSet.getDate(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void displayByTimeRange(Statement statement, String startTime, String endTime) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shifttable WHERE TimeOfStart >= '"+startTime+"' AND TimeOfEnd <= '"+endTime+"'");
            while(resultSet.next()){
                System.out.println("Shift Id : "+resultSet.getString(1) + " \nEmployee Id : "+resultSet.getString(2)+" \nEmployee Name : "+resultSet.getString(3)+" \nStart Time : "+resultSet.getString(4)+" \nEnd Time : "+resultSet.getString(5)+" \nShift Day : "+resultSet.getDate(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void displayByEmployeeId(Statement statement, String id) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shifttable WHERE EmployeeId = '"+id+"'");
            while(resultSet.next()){
                System.out.println("Shift Id : "+resultSet.getString(1) + " \nEmployee Id : "+resultSet.getString(2)+" \nEmployee Name : "+resultSet.getString(3)+" \nStart Time : "+resultSet.getString(4)+" \nEnd Time : "+resultSet.getString(5)+" \nShift Day : "+resultSet.getDate(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void displayByEmployeeName(Statement statement, String name) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shifttable WHERE EmployeeName = '"+name+"'");
            while(resultSet.next()){
                System.out.println("Shift Id : "+resultSet.getString(1) + " \nEmployee Id : "+resultSet.getString(2)+" \nEmployee Name : "+resultSet.getString(3)+" \nStart Time : "+resultSet.getString(4)+" \nEnd Time : "+resultSet.getString(5)+" \nShift Day : "+resultSet.getDate(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void createShift(Statement statement, String shiftId, String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd) {
        try {
            boolean isAdded = statement.execute("INSERT INTO `shifttable` (`ShiftId`, `EmployeeId`, `EmployeeName`, `TimeOfStart`, `TimeOfEnd`, `ShiftDate`) VALUES ('"+shiftId+"', '"+employeeId+"', '"+employeeName+"', '"+timeOfStart+"', '"+timeOfEnd+"', '"+shiftDay+"')");
            if(isAdded){
                System.out.println("Shift can not be added.");

            }
            else{
                System.out.println("Shift is added.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
