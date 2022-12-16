package BusinessLayer.Interfaces;

public interface IEmployeeManager {
    void displayAllEmployees();
    void displayEmployeeById();
    void displayEmployeesByName();
    void displayEmployeeBySsn();
    void deleteEmployeeById();
    void deleteEmployeeBySsn();
    void addNewEmployee();
}
