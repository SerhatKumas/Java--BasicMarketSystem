package UserInterfacesPackage.Implementation;

import UserInterfacesPackage.Interfaces.IAdminInterface;

public class AdminInterface implements IAdminInterface {
    @Override
    public void printMarketMenu() {
        System.out.println("\n--------- Employee Menu -----------");
        System.out.println("1)Display market by Id\n2)Display market by name\n3)Display all markets\n4)Display markets by location\n5)Display markets by owner id\n6)Add employee\n7)Delete markets by id\n8)Previous menu");
    }

    @Override
    public void printOwnerMenu() {
        System.out.println("\n--------- Owner Menu -----------");
        System.out.println("1)Display owner by Id\n2)Display owner by name\n3)Display all owners\n4)Display owner by ssn\n5)Add owner\n6)Delete owner by id\n7)Delete owner by ssn\n8)Previous menu");
    }

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
        System.out.println("1)Display shift by Id\n2)Display shift by employee id\n3)Display all shifts\n4)Display shift by employee id\n5)Display shift by employee name\n6)Display shift by time range\n7)Previous menu");
    }

    @Override
    public void printSalesMenu() {
        System.out.println("\n--------- Sales Menu -----------");
        System.out.println("1)Display sales by idd\n2)Display sales by employee id\n3)Display all sales\n4)Display sales by shift id\n5)Display sales by product id\n6)Delete sales by id\n7)Previous menu");
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Welcome to the admin system");
    }

    @Override
    public void printMainMenu() {
        System.out.println("\n--------- Main Menu -----------");
        System.out.println("1)Cashier Menu\n2)Product Menu\n3)Sales Menu\n4)Shift Menu\n5)Employee Menu\n6)Owner Menu\n7)Market Menu\n8)Log out");
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

    public void adminProgramRunner() {

    }
}
