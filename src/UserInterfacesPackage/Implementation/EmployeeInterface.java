package UserInterfacesPackage.Implementation;

import BusinessLayer.Interfaces.IProductManager;
import BusinessLayer.Interfaces.ISalesManager;
import BusinessLayer.Interfaces.IShiftManager;
import DataAccessLayerPackage.Interfaces.IProductDAL;
import DataAccessLayerPackage.Interfaces.IShiftDAL;
import UserInterfacesPackage.Interfaces.IUserInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class EmployeeInterface implements IUserInterface {

    @Override
    public void printWelcomeMessage() {
        System.out.println("Welcome to the employee system\nYou are logged in and you're shift has started.");
    }

    @Override
    public void printMainMenu() {
        System.out.println("\n--------- Main Menu -----------");
        System.out.println("1)Cashier Menu\n2)Product Menu\n3)Log out");
    }

    @Override
    public void printLogoutMessage() {
        System.out.println("Good bye..\nYou are logged out and you're shift has finished.");
    }

    @Override
    public void printCashierMenu() {
        System.out.println("\n--------- Cashier Menu -----------");
        System.out.println("1)Sell product by Id\n2)Refund product by Id\n3)Previous menu");
    }

    @Override
    public void printProductMenu() {
        System.out.println("\n--------- Product Menu -----------");
        System.out.println("1)Display product by Id\n2)Display product by name\n3)Display all products\n4)Display product by category\n5)Previous menu");
    }

    public void programRunner(Statement statement, String employeeId, String employeeName, IShiftManager shiftManager, IShiftDAL shiftDal, ISalesManager salesManager, IProductManager productManager, IProductDAL productDal) throws SQLException {
        printWelcomeMessage();
        ResultSet rs = statement.executeQuery("select count(*) from shifttable");
        rs.next();
        int count = rs.getInt(1);
        shiftManager.addNewShift(shiftDal, statement, String.valueOf(count+1), employeeId, employeeName, new java.sql.Date(new Date().getTime()), String.valueOf(LocalDateTime.now().getHour())+"."+String.valueOf(LocalDateTime.now().getMinute()),"");
        Scanner imputScanner = new Scanner(System.in);
        int menuChoice;
        int inMenuChoice;
        while(true){
            while(true){
                printMainMenu();
                menuChoice = imputScanner.nextInt();
                if(menuChoice == 1){
                    printCashierMenu();
                    inMenuChoice = imputScanner.nextInt();
                    if(inMenuChoice == 1){
                        System.out.println("Enter product id");
                        String productId = imputScanner.next();
                        productManager.sellProductById(productDal,statement,productId);
                    } else if (inMenuChoice == 2) {
                        System.out.println("Enter product id");
                        String productId = imputScanner.next();
                        productManager.refundProductById(productDal,statement,productId);
                    } else if (inMenuChoice == 3) {
                        break;
                    }
                    else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                } else if (menuChoice == 2) {
                    printProductMenu();
                    inMenuChoice = imputScanner.nextInt();
                    if(inMenuChoice == 1){
                        System.out.println("Enter product id");
                        String productId = imputScanner.next();
                        productManager.displayProductById(productDal, statement, productId);
                    } else if (inMenuChoice == 2) {
                        System.out.println("Enter product name");
                        String productName = imputScanner.next();
                        productManager.displayProductById(productDal, statement, productName);
                    } else if (inMenuChoice == 3) {
                        productManager.displayAllProducts(productDal,statement);
                    }
                    else if (inMenuChoice == 4) {
                        System.out.println("Enter product category");
                        String productCategory = imputScanner.next();
                        productManager.displayProductByCategory(productDal,statement,productCategory);
                    }
                    else if (inMenuChoice == 5) {
                        break;
                    }
                    else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                } else if (menuChoice == 3) {
                    shiftManager.closeShiftsById(shiftDal,statement,String.valueOf(count+1));
                    printLogoutMessage();
                    System.exit(0);
                }
                else{
                    System.err.println("Choose valid functionality;");
                    break;
                }
            }
        }
    }
}
