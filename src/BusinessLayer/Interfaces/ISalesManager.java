package BusinessLayer.Interfaces;

import DataAccessLayerPackage.Interfaces.ISalesDAL;

import java.sql.Statement;

public interface ISalesManager {
    void displayAllSales(ISalesDAL salesDal, Statement statement);
    void displaySaleById(ISalesDAL salesDal, Statement statement, String salesId);
    void displaySalesByShiftId(ISalesDAL salesDal, Statement statement, String shiftId);
    void displaySalesByWorkerId(ISalesDAL salesDal, Statement statement, String workerId);
    void displaySalesByProductId(ISalesDAL salesDal, Statement statement, String productId);
    void deleteSalesBySalesId(ISalesDAL salesDal, Statement statement, String salesId);
    void addNewSales(ISalesDAL salesDal, Statement statement, String salesId, String shiftId, String workerId, String productId);
}
