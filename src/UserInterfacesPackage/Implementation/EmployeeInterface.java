package UserInterfacesPackage.Implementation;

import BusinessLayer.Implementations.ProductManager;
import BusinessLayer.Implementations.SalesManager;
import BusinessLayer.Implementations.ShiftManager;
import BusinessLayer.Interfaces.IProductManager;
import BusinessLayer.Interfaces.ISalesManager;
import BusinessLayer.Interfaces.IShiftManager;
import UserInterfacesPackage.Interfaces.IUserInterface;

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

    public void programRunner(IShiftManager shiftManager, ISalesManager salesManager, IProductManager productManager) {
    printWelcomeMessage();
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
                        //Product selling - > add purchase date to  product by id from database
                        //display all product ozelligine where sonuna purchase date null degilken ile degistir
                    } else if (inMenuChoice == 2) {
                        // refund product by Id or delete update purchase date null by id from database
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
                        //print product by Id
                    } else if (inMenuChoice == 2) {
                        //print product by name
                    } else if (inMenuChoice == 3) {
                        //print all products
                    }
                    else if (inMenuChoice == 4) {
                        //print product by category
                    }
                    else if (inMenuChoice == 5) {
                        break;
                    }
                    else {
                        System.err.println("Choose valid functionality;");
                        break;
                    }
                } else if (menuChoice == 3) {
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

    public static void main(String[] args) {
        EmployeeInterface employeeInterface = new EmployeeInterface();
        employeeInterface.programRunner(new ShiftManager(),new SalesManager(), new ProductManager());
    }
}
