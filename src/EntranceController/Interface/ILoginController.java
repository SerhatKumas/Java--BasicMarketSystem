package EntranceController.Interface;

import java.sql.Statement;

public interface ILoginController {

    boolean employeeLogin(String id, String password);
    boolean ownerLogin(String id, String password);
    boolean adminLogin(String id, String password);
    void printLoginMenu();
    void programRunner(IUserInterfaceController userInterfaceController);
    Statement getConnection();

}
