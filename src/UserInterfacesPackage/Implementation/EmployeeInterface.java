package UserInterfacesPackage.Implementation;

import BusinessLayer.Interfaces.IProductManager;
import BusinessLayer.Interfaces.ISalesManager;
import BusinessLayer.Interfaces.IShiftManager;
import DataAccessLayerPackage.Interfaces.IProductDAL;
import DataAccessLayerPackage.Interfaces.ISalesDAL;
import DataAccessLayerPackage.Interfaces.IShiftDAL;
import UserInterfacesPackage.Interfaces.IUserInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.SplittableRandom;

public class EmployeeInterface implements IUserInterface {

    //This class is written to test system to manually, it is not constructed as a part of system

    //Welcome message
    @Override
    public void printWelcomeMessage() {
        System.out.println("Welcome to the employee system\nYou are logged in and you're shift has started.");
    }

    //Main menu options
    @Override
    public void printMainMenu() {
        System.out.println("\n--------- Main Menu -----------");
        System.out.println("1)Cashier Menu\n2)Product Menu\n3)Log out");
    }

    //Logout message
    @Override
    public void printLogoutMessage() {
        System.out.println("Good bye..\nYou are logged out and you're shift has finished.");
    }

    //Cashier menu options
    public void printCashierMenu() {
        System.out.println("\n--------- Cashier Menu -----------");
        System.out.println("1)Sell product by Id\n2)Refund product by Id\n3)Previous menu");
    }

    //Product menu options
    @Override
    public void printProductMenu() {
        System.out.println("\n--------- Product Menu -----------");
        System.out.println("1)Display product by Id\n2)Display product by name\n3)Display all products\n4)Display product by category\n5)Previous menu");
    }

    //Unique program runner method for employee portal
    public void programRunner(Statement statement, String employeeId, String employeeName, IShiftManager shiftManager, IShiftDAL shiftDal, ISalesManager salesManager, ISalesDAL salesDal, IProductManager productManager, IProductDAL productDal) {
        printWelcomeMessage();
        int shiftCount = 0;
        int salesCount = 0;
        try {
            ResultSet rs = statement.executeQuery("select count(*) from shifttable");
            rs.next();
            shiftCount = rs.getInt(1);
            rs = statement.executeQuery("select count(*) from salesTable");
            rs.next();
            salesCount = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        shiftManager.addNewShift(shiftDal, statement, String.valueOf(shiftCount + 1), employeeId, employeeName, new java.sql.Date(new Date().getTime()), String.valueOf(LocalDateTime.now().getHour()) + "." + String.valueOf(LocalDateTime.now().getMinute()), "");
        Scanner imputScanner = new Scanner(System.in);
        int menuChoice;
        int inMenuChoice;
        while (true) {
            while (true) {
                printMainMenu();
                menuChoice = imputScanner.nextInt();
                //Cashier menu option
                if (menuChoice == 1) {
                    printCashierMenu();
                    inMenuChoice = imputScanner.nextInt();
                    //Selling product by product id
                    if (inMenuChoice == 1) {
                        System.out.println("Enter product id");
                        String productId = imputScanner.next();
                        productManager.sellProductById(productDal, statement, productId);
                        salesManager.addNewSales(salesDal, statement, String.valueOf(salesCount + 1), String.valueOf(shiftCount + 1), employeeId, productId);
                    }
                    //Refunding product by product id
                    else if (inMenuChoice == 2) {
                        System.out.println("Enter product id");
                        String productId = imputScanner.next();
                        productManager.refundProductById(productDal, statement, productId);
                        salesManager.deleteSalesBySalesId(salesDal, statement, String.valueOf(salesCount + 1));
                    }
                    //Previous menu option
                    else if (inMenuChoice == 3) {
                        break;
                    } else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                }
                //Product menu option
                else if (menuChoice == 2) {
                    printProductMenu();
                    inMenuChoice = imputScanner.nextInt();
                    //Display product by product id
                    if (inMenuChoice == 1) {
                        System.out.println("Enter product id");
                        String productId = imputScanner.next();
                        productManager.displayProductById(productDal, statement, productId);
                    }
                    //Display product by product name
                    else if (inMenuChoice == 2) {
                        System.out.println("Enter product name");
                        String productName = imputScanner.next();
                        productManager.displayProductByName(productDal, statement, productName);
                    }
                    //Display all products
                    else if (inMenuChoice == 3) {
                        productManager.displayAllProducts(productDal, statement);
                    }
                    //Display product by product category
                    else if (inMenuChoice == 4) {
                        System.out.println("Enter product category");
                        String productCategory = imputScanner.next();
                        productManager.displayProductByCategory(productDal, statement, productCategory);
                    }
                    //Previous menu option
                    else if (inMenuChoice == 5) {
                        break;
                    } else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                }
                //Logout option
                else if (menuChoice == 3) {
                    shiftManager.closeShiftsById(shiftDal, statement, String.valueOf(shiftCount + 1));
                    printLogoutMessage();
                    System.exit(0);
                } else {
                    System.err.println("Choose valid functionality;");
                    break;
                }
            }
        }
    }
}
