package UserInterfacesPackage.Interfaces;

public interface IAdminInterface extends  IUserInterface,IOwnerInterface{
    void printMarketMenu();
    void printOwnerMenu();
}
