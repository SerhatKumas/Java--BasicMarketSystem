package BusinessLayer.Interfaces;

import DataAccessLayerPackage.Implementations.EmployeeDAL;

import java.sql.Statement;
import java.util.Date;

public interface IEmployeeManager {
    void displayAllEmployees(EmployeeDAL employeeDal, Statement statement);
    void displayEmployeeById(EmployeeDAL employeeDal, Statement statement, String EmployeeId);
    void displayEmployeesByName(EmployeeDAL employeeDal, Statement statement, String EmployeeName);
    void displayEmployeeBySsn(EmployeeDAL employeeDal, Statement statement, String EmployeeSsn);
    void deleteEmployeeById(EmployeeDAL employeeDal, Statement statement, String EmployeeId);
    void deleteEmployeeBySsn(EmployeeDAL employeeDal, Statement statement, String EmployeeSsn);
    void addNewEmployee(EmployeeDAL employeeDal, Statement statement, String workerId, String name, String phone, String ssn, String address, String marketId, Date dateOfBirth, String title, Date startDate, Date endDate, String workerPassword);
}
