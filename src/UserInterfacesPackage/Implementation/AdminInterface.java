package UserInterfacesPackage.Implementation;

import BusinessLayer.Interfaces.*;
import DataAccessLayerPackage.Implementations.EmployeeDAL;
import DataAccessLayerPackage.Implementations.OwnerDAL;
import DataAccessLayerPackage.Interfaces.IMarketDAL;
import DataAccessLayerPackage.Interfaces.IProductDAL;
import DataAccessLayerPackage.Interfaces.ISalesDAL;
import DataAccessLayerPackage.Interfaces.IShiftDAL;
import UserInterfacesPackage.Interfaces.IAdminInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AdminInterface implements IAdminInterface {

    //This class is written to test system to manually, it is not constructed as a part of system

    //Market menu options
    @Override
    public void printMarketMenu() {
        System.out.println("\n--------- Market Menu -----------");
        System.out.println("1)Display market by Id\n2)Display market by name\n3)Display all markets\n4)Display markets by location\n5)Display markets by owner id\n6)Add employee\n7)Delete markets by id\n8)Previous menu");
    }

    //Owner menu options
    @Override
    public void printOwnerMenu() {
        System.out.println("\n--------- Owner Menu -----------");
        System.out.println("1)Display owner by Id\n2)Display owner by name\n3)Display all owners\n4)Display owner by ssn\n5)Add owner\n6)Delete owner by id\n7)Delete owner by ssn\n8)Previous menu");
    }

    //Employee menu options
    @Override
    public void printEmployeeMenu() {
        System.out.println("\n--------- Employee Menu -----------");
        System.out.println("1)Display employee by Id\n2)Display employee by name\n3)Display all employees\n4)Display employee by ssn\n5)Add employee\n6)Delete employee by id\n7)Delete employee by ssn\n8)Previous menu");
    }

    //Production menu options
    @Override
    public void printProductMenu() {
        System.out.println("\n--------- Product Menu -----------");
        System.out.println("1)Display product by Id\n2)Display product by name\n3)Display all products\n4)Display product by category\n5)Add product\n6)Delete product by product id\n7)Previous menu");
    }

    //Shift menu options
    @Override
    public void printShiftMenu() {
        System.out.println("\n--------- Shift Menu -----------");
        System.out.println("1)Display shift by Id\n2)Display shift by employee id\n3)Display all shifts\n4)Display shift by employee id\n5)Display shift by employee name\n6)Display shift by time range\n7)Previous menu");
    }

    //Sales menu options
    @Override
    public void printSalesMenu() {
        System.out.println("\n--------- Sales Menu -----------");
        System.out.println("1)Display sales by idd\n2)Display sales by employee id\n3)Display all sales\n4)Display sales by shift id\n5)Display sales by product id\n6)Delete sales by id\n7)Previous menu");
    }

    //Welcome message method
    @Override
    public void printWelcomeMessage() {
        System.out.println("Welcome to the admin system");
    }

    //Main menu options
    @Override
    public void printMainMenu() {
        System.out.println("\n--------- Main Menu -----------");
        System.out.println("1)Product Menu\n2)Sales Menu\n3)Shift Menu\n4)Employee Menu\n5)Owner Menu\n6)Market Menu\n7)Log out");
    }

    //Logout message method
    @Override
    public void printLogoutMessage() {
        System.out.println("Good bye..\nYou are logged out");
    }

    //Unique program runner method for admin portal
    public void programRunner(Statement statement, IOwnerManager ownerManager, OwnerDAL ownerDal, IEmployeeManager employeeManager, EmployeeDAL employeeDal, IShiftManager shiftManager, IShiftDAL shiftDal, ISalesManager salesManager, ISalesDAL salesDal, IProductManager productManager, IProductDAL productDal, IMarketManager marketManager, IMarketDAL marketDal) {
        printWelcomeMessage();
        //Counters for creation of object
        int ownerCount = 0;
        int employeeCount = 0;
        int marketCount = 0;
        int productCount = 0;
        try {
            ResultSet rs = statement.executeQuery("select count(*) from ownertable");
            rs.next();
            ownerCount = rs.getInt(1);
            rs = statement.executeQuery("select count(*) from employeetable");
            rs.next();
            employeeCount = rs.getInt(1);
            rs = statement.executeQuery("select count(*) from markettable");
            rs.next();
            marketCount = rs.getInt(1);
            rs = statement.executeQuery("select count(*) from producttable");
            rs.next();
            productCount = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Scanner imputScanner = new Scanner(System.in);
        int menuChoice;
        int inMenuChoice;
        while (true) {
            while (true) {
                printMainMenu();
                menuChoice = imputScanner.nextInt();
                //Product options runner
                if (menuChoice == 1) {
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
                        productManager.displayProductById(productDal, statement, productName);
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
                    //Create product
                    else if (inMenuChoice == 5) {
                        System.out.println("Enter product name");
                        String productName = imputScanner.next();
                        System.out.println("Enter product market id");
                        String productId = imputScanner.next();
                        System.out.println("Enter product category");
                        String category = imputScanner.next();
                        System.out.println("Enter production date yyyy-mm-dd");
                        String productionDate = imputScanner.next();
                        System.out.println("Enter recommended consumption date yyyy-mm-dd");
                        String recommendedDate = imputScanner.next();


                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                        Date date = null;
                        Date dateRecommended = null;
                        Date dateNull = null;
                        try {
                            date = sdf.parse(productionDate);
                            dateRecommended = sdf.parse(recommendedDate);
                            dateNull = sdf.parse("0000-00-00");
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }

                        java.sql.Date productionSqlDate = new java.sql.Date(Long.valueOf(date.getTime()));
                        java.sql.Date recommendedSqlDate = new java.sql.Date(Long.valueOf(dateRecommended.getTime()));
                        java.sql.Date nullSqlDate = new java.sql.Date(Long.valueOf(dateNull.getTime()));

                        productManager.addNewProduct(productDal, statement, productName, String.valueOf(productCount + 1), productId, category, productionSqlDate, recommendedSqlDate, new java.sql.Date(new Date().getTime()), nullSqlDate);
                        productCount++;
                    }
                    //Delete product by product id
                    else if (inMenuChoice == 6) {
                        System.out.println("Enter product id");
                        String productId = imputScanner.next();
                        productManager.deleteProductById(productDal, statement, productId);
                    }
                    //Previous menu option
                    else if (inMenuChoice == 7) {
                        break;
                    }
                }
                //Sales options runner
                else if (menuChoice == 2) {
                    printSalesMenu();
                    inMenuChoice = imputScanner.nextInt();
                    //Display sales by sales id
                    if (inMenuChoice == 1) {
                        System.out.println("Enter sales id");
                        String salesId = imputScanner.next();
                        salesManager.displaySaleById(salesDal, statement, salesId);
                    }
                    //Display sales by employee id
                    else if (inMenuChoice == 2) {
                        System.out.println("Enter employee id");
                        String employeeId = imputScanner.next();
                        salesManager.displaySalesByWorkerId(salesDal, statement, employeeId);
                    }
                    //Display all sales
                    else if (inMenuChoice == 3) {
                        salesManager.displayAllSales(salesDal, statement);
                    }
                    //Display sales by shift id
                    else if (inMenuChoice == 4) {
                        System.out.println("Enter shift id");
                        String shiftId = imputScanner.next();
                        salesManager.displaySalesByShiftId(salesDal, statement, shiftId);
                    }
                    //Display sales by product id
                    else if (inMenuChoice == 5) {
                        System.out.println("Enter product id");
                        String productId = imputScanner.next();
                        salesManager.displaySalesByProductId(salesDal, statement, productId);
                    }
                    //Delete sales by sales id
                    else if (inMenuChoice == 6) {
                        System.out.println("Enter sales id");
                        String salesId = imputScanner.next();
                        salesManager.deleteSalesBySalesId(salesDal, statement, salesId);
                    }
                    //Previous menu option
                    else if (inMenuChoice == 7) {
                        break;
                    } else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                }
                //Shift options runner
                else if (menuChoice == 3) {
                    printShiftMenu();
                    inMenuChoice = imputScanner.nextInt();
                    //Display shift by shift id
                    if (inMenuChoice == 1) {
                        System.out.println("Enter shift id");
                        String shiftId = imputScanner.next();
                        shiftManager.displayShiftByShiftId(shiftDal, statement, shiftId);
                    }
                    //Display shift by employee id
                    else if (inMenuChoice == 2) {
                        System.out.println("Enter employee id");
                        String employeeId = imputScanner.next();
                        shiftManager.displayShiftsByWorkerId(shiftDal, statement, employeeId);
                    }
                    //Display all shifts
                    else if (inMenuChoice == 3) {
                        shiftManager.displayAllShifts(shiftDal, statement);
                    }
                    //Display shift by employee name
                    else if (inMenuChoice == 4) {
                        System.out.println("Enter employee name");
                        String employeeName = imputScanner.next();
                        shiftManager.displayShiftsByWorkerName(shiftDal, statement, employeeName);
                    }
                    //Display shift by time range
                    else if (inMenuChoice == 5) {
                        System.out.println("Enter start time");
                        String startTime = imputScanner.next();
                        System.out.println("Enter end time");
                        String endTime = imputScanner.next();
                        shiftManager.displayShiftsByTimeRange(shiftDal, statement, startTime, endTime);
                    }
                    //Display shift by date
                    else if (inMenuChoice == 6) {
                        System.out.println("Enter date");
                        String date = imputScanner.next();
                        shiftManager.displayShiftsByDate(shiftDal, statement, date);
                    }
                    //Previous menu option
                    else if (inMenuChoice == 7) {
                        break;
                    } else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                }
                //Employee options runner
                else if (menuChoice == 4) {
                    printEmployeeMenu();
                    inMenuChoice = imputScanner.nextInt();
                    //Display employee by employee id
                    if (inMenuChoice == 1) {
                        System.out.println("Enter employee id");
                        String employeeId = imputScanner.next();
                        employeeManager.displayEmployeeById(employeeDal, statement, employeeId);
                    }
                    //Display employee by employee name
                    else if (inMenuChoice == 2) {
                        System.out.println("Enter employee name");
                        String employeeName = imputScanner.next();
                        employeeManager.displayEmployeesByName(employeeDal, statement, employeeName);
                    }
                    //Display all employee
                    else if (inMenuChoice == 3) {
                        employeeManager.displayAllEmployees(employeeDal, statement);
                    }
                    //Display employee by employee ssn
                    else if (inMenuChoice == 4) {
                        System.out.println("Enter employee ssn");
                        String employeeSsn = imputScanner.next();
                        employeeManager.displayEmployeeBySsn(employeeDal, statement, employeeSsn);
                    }
                    //Create employee
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
                        Date date = null;
                        Date dateNull = null;
                        try {
                            date = sdf.parse(birthDate);
                            dateNull = sdf.parse("0000-00-00");
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        java.sql.Date sqlDate = new java.sql.Date(Long.valueOf(date.getTime()));
                        java.sql.Date sqlDateNull = new java.sql.Date(Long.valueOf(dateNull.getTime()));

                        employeeManager.addNewEmployee(employeeDal, statement, ("Emp" + String.valueOf(employeeCount + 1)), fullname, phone, ssn, address, marketId, sqlDate, title, new java.sql.Date(new Date().getTime()), sqlDateNull, password);
                        employeeCount++;
                    }
                    //Delete employee by employee id
                    else if (inMenuChoice == 6) {
                        System.out.println("Enter employee id");
                        String employeeId = imputScanner.next();
                        employeeManager.deleteEmployeeById(employeeDal, statement, employeeId);
                    }
                    //Delete employee by employee ssn
                    else if (inMenuChoice == 7) {
                        System.out.println("Enter employee ssn");
                        String employeeSsn = imputScanner.next();
                        employeeManager.deleteEmployeeBySsn(employeeDal, statement, employeeSsn);
                    }
                    //Previous menu option
                    else if (inMenuChoice == 8) {
                        break;
                    } else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                }
                //Owner options runner
                else if (menuChoice == 5) {
                    printOwnerMenu();
                    inMenuChoice = imputScanner.nextInt();
                    //Display owner by owner id
                    if (inMenuChoice == 1) {
                        System.out.println("Enter owner id");
                        String ownerId = imputScanner.next();
                        ownerManager.displayOwnerById(ownerDal, statement, ownerId);
                    }
                    //Display owner by owner name
                    else if (inMenuChoice == 2) {
                        System.out.println("Enter owner name");
                        String ownerName = imputScanner.next();
                        ownerManager.displayOwnersByName(ownerDal, statement, ownerName);
                    }
                    //Display all owners
                    else if (inMenuChoice == 3) {
                        ownerManager.displayAllOwners(ownerDal, statement);
                    }
                    //Display owner by owner ssn
                    else if (inMenuChoice == 4) {
                        System.out.println("Enter owner ssn");
                        String ownerSsn = imputScanner.next();
                        ownerManager.displayOwnerById(ownerDal, statement, ownerSsn);
                    }
                    //Create owner
                    else if (inMenuChoice == 5) {
                        System.out.println("Enter owner full name");
                        String fullName = imputScanner.next();
                        System.out.println("Enter owner phone");
                        String phone = imputScanner.next();
                        System.out.println("Enter owner ssn");
                        String ssn = imputScanner.next();
                        System.out.println("Enter owner address");
                        String address = imputScanner.next();
                        System.out.println("Enter owner market id");
                        String marketId = imputScanner.next();
                        System.out.println("Enter owner birth date yyyy-mm-dd");
                        String birthDate = imputScanner.next();
                        System.out.println("Enter owner password");
                        String password = imputScanner.next();
                        System.out.println("Enter owner percentage over ownership of market");
                        Float percentage = Float.valueOf(imputScanner.next());


                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                        Date date = null;
                        try {
                            date = sdf.parse(birthDate);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        java.sql.Date sqlDate = new java.sql.Date(Long.valueOf(date.getTime()));

                        ownerManager.addNewOwner(ownerDal, statement, fullName, phone, sqlDate, ssn, address, ("Own" + String.valueOf(ownerCount + 1)), marketId, password, percentage);
                        ownerCount++;
                    }
                    //Delete owner by owner id
                    else if (inMenuChoice == 6) {
                        System.out.println("Enter owner id");
                        String ownerId = imputScanner.next();
                        ownerManager.deleteOwnerById(ownerDal, statement, ownerId);
                    }
                    //Display owner by owner ssn
                    else if (inMenuChoice == 7) {
                        System.out.println("Enter owner ssn");
                        String ownerSsn = imputScanner.next();
                        ownerManager.deleteOwnerBySsn(ownerDal, statement, ownerSsn);
                    }
                    //Previous menu option
                    else if (inMenuChoice == 8) {
                        break;
                    } else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                }
                //Market options runner
                else if (menuChoice == 6) {
                    printMarketMenu();
                    inMenuChoice = imputScanner.nextInt();
                    //Display market by market id
                    if (inMenuChoice == 1) {
                        System.out.println("Enter market id");
                        String marketId = imputScanner.next();
                        marketManager.displayMarketByMarketId(marketDal, statement, marketId);
                    }
                    //Display market by market name
                    else if (inMenuChoice == 2) {
                        System.out.println("Enter market name");
                        String marketName = imputScanner.next();
                        marketManager.displayMarketsByName(marketDal, statement, marketName);
                    }
                    //Display all markets
                    else if (inMenuChoice == 3) {
                        marketManager.displayAllMarkets(marketDal, statement);
                    }
                    //Display market by market location
                    else if (inMenuChoice == 4) {
                        System.out.println("Enter market location");
                        String marketLocation = imputScanner.next();
                        marketManager.displayMarketsByLocation(marketDal, statement, marketLocation);
                    }
                    //Display market by owner id
                    else if (inMenuChoice == 5) {
                        System.out.println("Enter owner id");
                        String ownerId = imputScanner.next();
                        marketManager.displayMarketsByOwnerId(marketDal, statement, ownerId);
                    }
                    //Create market
                    else if (inMenuChoice == 6) {
                        System.out.println("Enter market name");
                        String marketName = imputScanner.next();
                        System.out.println("Enter market location");
                        String marketLocation = imputScanner.next();
                        System.out.println("Enter owner id");
                        String ownerId = imputScanner.next();
                        marketManager.addNewMarket(marketDal, statement, String.valueOf(marketCount + 1), marketName, marketLocation, ownerId);
                    }
                    //Delete market by market id
                    else if (inMenuChoice == 7) {
                        System.out.println("Enter market id");
                        String marketId = imputScanner.next();
                        marketManager.deleteMarketByMarketId(marketDal, statement, marketId);
                    }
                    //Previous menu option
                    else if (inMenuChoice == 8) {
                        break;
                    } else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                }
                //Logout option
                else if (menuChoice == 7) {
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
