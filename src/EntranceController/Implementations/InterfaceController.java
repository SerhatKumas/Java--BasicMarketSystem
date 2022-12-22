package EntranceController.Implementations;

import BusinessLayer.Implementations.*;
import DataAccessLayerPackage.Implementations.*;
import EntranceController.Interface.IUserInterfaceController;
import UserInterfacesPackage.Implementation.AdminInterface;
import UserInterfacesPackage.Implementation.EmployeeInterface;
import UserInterfacesPackage.Implementation.OwnerInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class InterfaceController implements IUserInterfaceController {
    @Override
    public void createOwnerInterface(OwnerInterface ownerInterface, Statement statement, String ownerId, String ownerName) {
        ownerInterface.programRunner(statement,ownerId,ownerName,new EmployeeManager(), new EmployeeDAL(), new ShiftManager(), new ShiftDAL(), new SalesManager(), new SalesDAL(), new ProductManager(), new ProductDAL());
    }

    @Override
    public void createEmployeeInterface(EmployeeInterface employeeInterface, Statement statement, String employeeId, String employeeName) {
        employeeInterface.programRunner(statement,employeeId,employeeName, new ShiftManager(), new ShiftDAL(), new SalesManager(), new SalesDAL(), new ProductManager(), new ProductDAL());
    }

    @Override
    public void createAdminInterface(AdminInterface adminInterface,Statement statement) {
        adminInterface.programRunner(statement,new OwnerManager(), new OwnerDAL(), new EmployeeManager(), new EmployeeDAL(), new ShiftManager(), new ShiftDAL(), new SalesManager(), new SalesDAL(), new ProductManager(), new ProductDAL(),new MarketManager(), new MarketDAL());
    }
}
