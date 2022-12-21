package UserInterfacesPackage.Implementation;

import BusinessLayer.Interfaces.IEmployeeManager;
import BusinessLayer.Interfaces.IProductManager;
import BusinessLayer.Interfaces.ISalesManager;
import BusinessLayer.Interfaces.IShiftManager;
import DataAccessLayerPackage.Implementations.EmployeeDAL;
import DataAccessLayerPackage.Interfaces.IProductDAL;
import DataAccessLayerPackage.Interfaces.ISalesDAL;
import DataAccessLayerPackage.Interfaces.IShiftDAL;
import UserInterfacesPackage.Interfaces.IOwnerInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class OwnerInterface implements IOwnerInterface {
    @Override
    public void printEmployeeMenu() {
        System.out.println("\n--------- Employee Menu -----------");
        System.out.println("1)Display employee by Id\n2)Display employee by name\n3)Display all employees\n4)Display employee by ssn\n5)Add employee\n6)Delete employee by id\n7)Delete employee by ssn\n8)Previous menu");
    }

    @Override
    public void printProductMenu() {
        System.out.println("\n--------- Product Menu -----------");
        System.out.println("1)Display product by Id\n2)Display product by name\n3)Display all products\n4)Display product by category\n5)Add product\n6)Delete product by product id\n7)Previous menu");
    }

    @Override
    public void printShiftMenu() {
        System.out.println("\n--------- Shift Menu -----------");
        System.out.println("1)Display shift by Id\n2)Display shift by employee id\n3)Display all shifts\n4)Display shift by employee name\n5)Display shift by employee rime range\n6)Display shift by date\n7)Previous menu");
    }

    @Override
    public void printSalesMenu() {
        System.out.println("\n--------- Sales Menu -----------");
        System.out.println("1)Display sales by idd\n2)Display sales by employee id\n3)Display all sales\n4)Display sales by shift id\n5)Display sales by product id\n6)Delete sales by id\n7)Previous menu");
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Welcome to the owner system");
    }

    @Override
    public void printMainMenu() {
        System.out.println("\n--------- Main Menu -----------");
        System.out.println("1)Cashier Menu\n2)Product Menu\n3)Sales Menu\n4)Shift Menu\n5)Employee Menu\n6)Log out");
    }

    @Override
    public void printLogoutMessage() {
        System.out.println("Good bye..\nYou are logged out");
    }

    @Override
    public void printCashierMenu() {
        System.out.println("\n--------- Cashier Menu -----------");
        System.out.println("1)Sell product by Id\n2)Refund product by Id\n3)Previous menu");
    }

    public void programRunner(Statement statement, String ownerId, IEmployeeManager employeeManager, EmployeeDAL employeeDal, IShiftManager shiftManager, IShiftDAL shiftDal, ISalesManager salesManager, ISalesDAL salesDal, IProductManager productManager, IProductDAL productDal) throws ParseException {
        printWelcomeMessage();
        int shiftCount = 0;
        int salesCount = 0;
        int employeeCount = 0;
        try {
            ResultSet rs = statement.executeQuery("select count(*) from shifttable");
            rs.next();
            shiftCount = rs.getInt(1);
            rs = statement.executeQuery("select count(*) from salestable");
            rs.next();
            salesCount = rs.getInt(1);
            rs = statement.executeQuery("select count(*) from employeetable");
            rs.next();
            employeeCount = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
                        salesManager.addNewSales(salesDal,statement,String.valueOf(salesCount+1), String.valueOf(shiftCount+1),ownerId,productId);
                        salesCount++;
                    } else if (inMenuChoice == 2) {
                        System.out.println("Enter product id");
                        String productId = imputScanner.next();
                        productManager.refundProductById(productDal,statement,productId);
                        salesManager.deleteSalesBySalesId(salesDal,statement,String.valueOf(salesCount+1));
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
                }

                else if(menuChoice == 3){
                    printSalesMenu();
                    inMenuChoice = imputScanner.nextInt();
                    if(inMenuChoice == 1){
                        System.out.println("Enter sales id");
                        String salesId = imputScanner.next();
                        salesManager.displaySaleById(salesDal, statement, salesId);
                    } else if (inMenuChoice == 2) {
                        System.out.println("Enter employee id");
                        String employeeId = imputScanner.next();
                        salesManager.displaySalesByWorkerId(salesDal, statement, employeeId);
                    } else if (inMenuChoice == 3) {
                        salesManager.displayAllSales(salesDal,statement);
                    }
                    else if (inMenuChoice == 4) {
                        System.out.println("Enter shift id");
                        String shiftId = imputScanner.next();
                        salesManager.displaySalesByShiftId(salesDal,statement,shiftId);
                    }
                    else if (inMenuChoice == 5) {
                        System.out.println("Enter product id");
                        String productId = imputScanner.next();
                        salesManager.displaySalesByProductId(salesDal,statement,productId);
                    }
                    else if (inMenuChoice == 6) {
                        System.out.println("Enter sales id");
                        String salesId = imputScanner.next();
                        salesManager.deleteSalesBySalesId(salesDal,statement,salesId);
                    }
                    else if (inMenuChoice == 7) {
                        break;
                    }
                    else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                }
                else if(menuChoice == 4){
                    printShiftMenu();
                    inMenuChoice = imputScanner.nextInt();
                    if(inMenuChoice == 1){
                        System.out.println("Enter shift id");
                        String shiftId = imputScanner.next();
                        shiftManager.displayShiftByShiftId(shiftDal, statement, shiftId);
                    } else if (inMenuChoice == 2) {
                        System.out.println("Enter employee id");
                        String employeeId = imputScanner.next();
                        shiftManager.displayShiftsByWorkerId(shiftDal, statement, employeeId);
                    } else if (inMenuChoice == 3) {
                        shiftManager.displayAllShifts(shiftDal,statement);
                    }
                    else if (inMenuChoice == 4) {
                        System.out.println("Enter employee name");
                        String employeeName = imputScanner.next();
                        shiftManager.displayShiftsByWorkerName(shiftDal,statement,employeeName);
                    }
                    else if (inMenuChoice == 5) {
                        System.out.println("Enter start time");
                        String startTime = imputScanner.next();
                        System.out.println("Enter end time");
                        String endTime = imputScanner.next();
                        shiftManager.displayShiftsByTimeRange(shiftDal,statement,startTime,endTime);
                    }
                    else if (inMenuChoice == 6) {
                        System.out.println("Enter date");
                        String date = imputScanner.next();
                        shiftManager.displayShiftsByDate(shiftDal,statement,date);
                    }
                    else if (inMenuChoice == 7) {
                        break;
                    }
                    else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                }
                else if(menuChoice == 5){
                    printEmployeeMenu();
                    inMenuChoice = imputScanner.nextInt();
                    if(inMenuChoice == 1){
                        System.out.println("Enter employee id");
                        String employeeId = imputScanner.next();
                        employeeManager.displayEmployeeById(employeeDal, statement, employeeId);
                    } else if (inMenuChoice == 2) {
                        System.out.println("Enter employee name");
                        String employeeName = imputScanner.next();
                        employeeManager.displayEmployeesByName(employeeDal, statement, employeeName);
                    } else if (inMenuChoice == 3) {
                        employeeManager.displayAllEmployees(employeeDal,statement);
                    }
                    else if (inMenuChoice == 4) {
                        System.out.println("Enter employee ssn");
                        String employeeSsn = imputScanner.next();
                        employeeManager.displayEmployeeBySsn(employeeDal,statement,employeeSsn);
                    }
                    else if (inMenuChoice == 5) {
                        System.out.println("Enter employee full name");
                        String fullname = imputScanner.next();
                        System.out.println("Enter employee phone");
                        String phone = imputScanner.next();
                        System.out.println("Enter employee ssn");
                        String ssn = imputScanner.next();
                        System.out.println("Enter employee address");
                        String address = imputScanner.next();
                        System.out.println("Enter employee market id");
                        String marketId = imputScanner.next();
                        System.out.println("Enter employee birth date yyyy-mm-dd");
                        String birthDate = imputScanner.next();
                        System.out.println("Enter employee title");
                        String title = imputScanner.next();
                        System.out.println("Enter employee password");
                        String password = imputScanner.next();


                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                        java.util.Date date = sdf.parse(birthDate);
                        java.util.Date dateNull = sdf.parse("0000-00-00");
                        java.sql.Date sqlDate = new java.sql.Date(Long.valueOf(date.getTime()));
                        java.sql.Date sqlDateNull = new java.sql.Date(Long.valueOf(dateNull.getTime()));

                        employeeManager.addNewEmployee(employeeDal,statement,("Emp"+String.valueOf(employeeCount+1)),fullname,phone,ssn,address,marketId,sqlDate,title,new java.sql.Date(new Date().getTime()),sqlDateNull,password);
                        employeeCount++;
                    }
                    else if (inMenuChoice == 6) {
                        System.out.println("Enter emloyee id");
                        String employeeId = imputScanner.next();
                        employeeManager.deleteEmployeeById(employeeDal,statement,employeeId);
                    }
                    else if (inMenuChoice == 7) {
                        System.out.println("Enter employee ssn");
                        String employeeSsn = imputScanner.next();
                        employeeManager.deleteEmployeeBySsn(employeeDal,statement,employeeSsn);
                    }
                    else if (inMenuChoice == 8) {
                        break;
                    }
                    else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                }
                else if (menuChoice == 6) {
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
