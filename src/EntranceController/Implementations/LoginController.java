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
    public boolean employeeLogin(String employeeId, String employeePassword) {
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
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean ownerLogin(String ownerId, String ownerPassword) {
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
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean adminLogin(String adminId, String adminPassword) {
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
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void printLoginMenu() {
        System.out.println("Welcome to Market System");
        System.out.println("\n--------- Login Menu -----------");
        System.out.println("1)Employee Portal\n2)Owner Portal\n3)Admin Portal\n4)Turn off the system");
    }

    @Override
    public void programRunner(IUserInterfaceController userInterfaceController) {
        Scanner inputScanner = new Scanner(System.in);
        int menuChoice;
        while(true){
            while(true) {
                printLoginMenu();
                menuChoice = inputScanner.nextInt();
                if (menuChoice == 1){
                    System.out.println("Enter employee id : ");
                    String employeeId = inputScanner.next();
                    System.out.println("Enter employee name : ");
                    String employeeName = inputScanner.next();
                    System.out.println("Enter employee password : ");
                    String employeePassword = inputScanner.next();
                    if (employeeLogin(employeeId,employeePassword)){
                        userInterfaceController.createEmployeeInterface(new EmployeeInterface(),getConnection(),employeeId,employeeName);
                    }
                    else {
                        System.err.println("Check your credentials and try to log in again...");
                    }
                }
                else if (menuChoice == 2){
                    System.out.println("Enter owner id : ");
                    String ownerId = inputScanner.next();
                    System.out.println("Enter owner name : ");
                    String ownerName = inputScanner.next();
                    System.out.println("Enter owner password : ");
                    String ownerPassword = inputScanner.next();
                    if(ownerLogin(ownerId,ownerPassword)){
                        userInterfaceController.createOwnerInterface(new OwnerInterface(), getConnection(), ownerId,ownerName);
                    }
                    else {
                        System.err.println("Check your credentials and try to log in again...");
                    }

                }
                else if (menuChoice == 3){
                    System.out.println("Enter admin id : ");
                    String adminId = inputScanner.next();
                    System.out.println("Enter admin password : ");
                    String adminPassword = inputScanner.next();
                    if(adminLogin(adminId,adminPassword)){
                        userInterfaceController.createAdminInterface(new AdminInterface(),getConnection());
                    }
                    else {
                        System.err.println("Check your credentials and try to log in again...");
                    }
                }
                else if (menuChoice == 4){
                    System.out.println("System is terminated...");
                    System.exit(0);
                }
                else {
                    System.err.println("Check your choice...");
                }
            }
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
