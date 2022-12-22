import EntranceController.Implementations.InterfaceController;
import EntranceController.Implementations.LoginController;

public class Main {
    public static void main(String[] args) {
        //Login class controller
        LoginController loginController = new LoginController();
        //Main program runner method
        loginController.programRunner(new InterfaceController());
    }
}