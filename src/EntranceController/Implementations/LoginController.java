package EntranceController.Implementations;

import EntranceController.Interface.ILoginController;
import EntranceController.Interface.IUserInterfaceController;
import UserInterfacesPackage.Implementation.AdminInterface;
import UserInterfacesPackage.Implementation.EmployeeInterface;
import UserInterfacesPackage.Implementation.OwnerInterface;

import java.sql.*;
import java.util.Scanner;

public class LoginController implements ILoginController {
    @Override
    public void employeeLogin(IUserInterfaceController userInterfaceController) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter employee id : ");
        String employeeId = inputScanner.next();
        System.out.println("Enter employee name : ");
        String employeeName = inputScanner.next();
        System.out.println("Enter employee password : ");
        String employeePassword = inputScanner.next();
        Statement statement = getConnection();
        ResultSet rs = null;
        int employeeCount = 0;
        try {
            rs = statement.executeQuery("select count(*) from employeetable where EmployeeId = '"+employeeId+"' AND WorkerPassword = '"+employeePassword+"'");
            rs.next();
            employeeCount = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (employeeCount ==1){
            userInterfaceController.createEmployeeInterface(new EmployeeInterface(),statement,employeeId,employeeName);
        }
        else {
            System.err.println("Check your credentials and try to log-in again");
        }
    }

    @Override
    public void ownerLogin(IUserInterfaceController userInterfaceController) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter owner id : ");
        String ownerId = inputScanner.next();
        System.out.println("Enter owner password : ");
        String ownerPassword = inputScanner.next();
        Statement statement = getConnection();
        ResultSet rs = null;
        int ownerCount = 0;
        try {
            rs = statement.executeQuery("select count(*) from ownertable where OwnerId = '"+ownerId+"' AND WorkerPassword = '"+ownerPassword+"'");
            rs.next();
            ownerCount = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (ownerCount ==1){
            userInterfaceController.createOwnerInterface(new OwnerInterface(),statement,ownerId);
        }
        else {
            System.err.println("Check your credentials and try to log-in again");
        }
    }

    @Override
    public void adminLogin(IUserInterfaceController userInterfaceController) {
        System.out.println("Enter admin id : ");
        Scanner inputScanner = new Scanner(System.in);
        String adminId = inputScanner.next();
        System.out.println("Enter admin password : ");
        String adminPassword = inputScanner.next();

        Statement statement = getConnection();
        ResultSet rs = null;
        int adminCount = 0;
        try {
            rs = statement.executeQuery("select count(*) from employeetable where EmployeeId = '"+adminId+"' AND WorkerPassword = '"+adminPassword+"' AND EmployeeTitle = 'Admin'");
            rs.next();
            adminCount = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (adminCount ==1){
            userInterfaceController.createAdminInterface(new AdminInterface(),statement);
        }
        else {
            System.err.println("Check your credentials and try to log-in again");
        }
    }

    @Override
    public Statement getConnection() {
        String url = "jdbc:mysql://localhost:8111/marketsystem";
        String username = "root";
        String password = "";
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }

        return statement;
    }

}
