package BusinessLayer.Implementations;

import BusinessLayer.Interfaces.ISalesManager;
import DataAccessLayerPackage.Interfaces.ISalesDAL;

import java.sql.Statement;

public class SalesManager implements ISalesManager {

    //Business Layer for Data access layer
    //Rules can be setup here before displaying, creating or deleting data in database

    @Override
    public void displayAllSales(ISalesDAL salesDal, Statement statement) {
        salesDal.displayAllSales(statement);
    }

    @Override
    public void displaySaleById(ISalesDAL salesDal, Statement statement, String salesId) {
        salesDal.displaySaleByID(statement, salesId);
    }

    @Override
    public void displaySalesByShiftId(ISalesDAL salesDal, Statement statement, String shiftId) {
        salesDal.displaySalesByShiftId(statement, shiftId);
    }

    @Override
    public void displaySalesByWorkerId(ISalesDAL salesDal, Statement statement, String workerId) {
        salesDal.displaySalesByWorkerId(statement, workerId);
    }

    @Override
    public void displaySalesByProductId(ISalesDAL salesDal, Statement statement, String productId) {
        salesDal.displaySalesByProductId(statement, productId);
    }

    @Override
    public void deleteSalesBySalesId(ISalesDAL salesDal, Statement statement, String salesId) {
        salesDal.deleteSalesById(statement, salesId);
    }

    @Override
    public void addNewSales(ISalesDAL salesDal, Statement statement, String salesId, String shiftId, String workerId, String productId) {
        salesDal.createSales(statement, salesId, shiftId, workerId, productId);
    }
}
