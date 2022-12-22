import EntranceController.Implementations.InterfaceController;
import EntranceController.Implementations.LoginController;

public class Main {
    public static void main(String[] args) {
        LoginController loginController = new LoginController();
        loginController.programRunner(new InterfaceController());
    }
}