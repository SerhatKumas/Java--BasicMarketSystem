package DataAccessLayerPackage.Interfaces;
import AssetsPackage.SalesPackage.Sales;

import java.util.Date;

public interface ISalesDAL {
    void displaySaleByID(String id);
    void displaySalesByShiftId(String shiftId);
    void displaySalesByWorkerId(String workerId);
    void displaySalesByProductId(String productId);

    void deleteSalesById(String id);

    void updateSalesById(String id);

    Sales createSales(String salesId, String shiftId, String workerId, String productId);

    void addSales(String salesId, String shiftId, String workerId, String productId);

    void printSales(Sales sales);
}
