package BusinessLayer.Implementations;

import BusinessLayer.Interfaces.IEmployeeManager;
import DataAccessLayerPackage.Implementations.EmployeeDAL;

import java.sql.Statement;
import java.util.Date;

public class EmployeeManager implements IEmployeeManager {

    //Business Layer for Data access layer
    //Rules can be setup here before displaying, creating or deleting data in database

    @Override
    public void displayAllEmployees(EmployeeDAL employeeDal, Statement statement) {
        employeeDal.displayAll(statement);
    }

    @Override
    public void displayEmployeeById(EmployeeDAL employeeDal, Statement statement, String EmployeeId) {
        employeeDal.displayById(statement, EmployeeId);
    }

    @Override
    public void displayEmployeesByName(EmployeeDAL employeeDal, Statement statement, String EmployeeName) {
        employeeDal.displayByName(statement, EmployeeName);
    }

    @Override
    public void displayEmployeeBySsn(EmployeeDAL employeeDal, Statement statement, String EmployeeSsn) {
        employeeDal.displayBySsn(statement, EmployeeSsn);
    }

    @Override
    public void deleteEmployeeById(EmployeeDAL employeeDal, Statement statement, String EmployeeId) {
        employeeDal.deleteById(statement, EmployeeId);
    }

    @Override
    public void deleteEmployeeBySsn(EmployeeDAL employeeDal, Statement statement, String EmployeeSsn) {
        employeeDal.deleteBySsn(statement, EmployeeSsn);
    }

    @Override
    public void addNewEmployee(EmployeeDAL employeeDal, Statement statement, String workerId, String name, String phone, String ssn, String address, String marketId, Date dateOfBirth, String title, Date startDate, Date endDate, String workerPassword) {
        employeeDal.createNewEmployee(statement, workerId, name, phone, ssn, address, marketId, dateOfBirth, title, startDate, endDate, workerPassword);
    }
}
