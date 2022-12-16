package BusinessLayer.Interfaces;

public interface IOwnerManager {

    void displayAllEmployees();
    void displayOwnerById();
    void displayOwnersByName();
    void displayOwnerBySsn();
    void deleteOwnerById();
    void deleteOwnerBySsn();
    void addNewOwner();
}

