package EntranceController.Interface;

import UserInterfacesPackage.Implementation.AdminInterface;
import UserInterfacesPackage.Implementation.EmployeeInterface;
import UserInterfacesPackage.Implementation.OwnerInterface;

import java.sql.Statement;

public interface IUserInterfaceController {
    void createOwnerInterface(OwnerInterface ownerInterface, Statement statement, String ownerId);
    void createEmployeeInterface(EmployeeInterface employeeInterface, Statement statement, String employeeId, String employeeName);
    void createAdminInterface(AdminInterface adminInterface, Statement statement);
}
