package EntranceController.Interface;

import java.sql.Statement;

public interface ILoginController {

    void employeeLogin(IUserInterfaceController userInterfaceController);
    void ownerLogin(IUserInterfaceController userInterfaceController);
    void adminLogin(IUserInterfaceController userInterfaceController);
    Statement getConnection();

}
