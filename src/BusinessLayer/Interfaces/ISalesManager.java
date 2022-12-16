package BusinessLayer.Interfaces;

public interface ISalesManager {
    void displayAllSales();
    void displaySaleById();
    void displaySalesByShiftId();
    void displaySalesByWorkerId();
    void displaySalesByProductId();
    void deleteSalesBySalesId();
    void addNewSales();
}
