package DataAccessLayerPackage.Interfaces;
import AssetsPackage.SalesPackage.Sales;

import java.sql.Statement;
import java.util.Date;

public interface ISalesDAL {
    void displaySaleByID(Statement statement, String id);
    void displaySalesByShiftId(Statement statement, String shiftId);
    void displaySalesByWorkerId(Statement statement, String workerId);
    void displaySalesByProductId(Statement statement, String productId);

    void deleteSalesById(Statement statement, String id);

    void updateSalesById(Statement statement, String id);

    Sales createSales(Statement statement, String salesId, String shiftId, String workerId, String productId);

    void addSales(Statement statement, String salesId, String shiftId, String workerId, String productId);

    void printSales(Sales sales);
}
