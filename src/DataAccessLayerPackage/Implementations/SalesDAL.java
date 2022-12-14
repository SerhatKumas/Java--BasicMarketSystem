package DataAccessLayerPackage.Implementations;

import AssetsPackage.SalesPackage.Sales;
import DataAccessLayerPackage.Interfaces.ISalesDAL;

import java.sql.Statement;

public class SalesDAL implements ISalesDAL {

    @Override
    public void displaySaleByID(Statement statement, String id) {

    }

    @Override
    public void displaySalesByShiftId(Statement statement, String shiftId) {

    }

    @Override
    public void displaySalesByWorkerId(Statement statement, String workerId) {

    }

    @Override
    public void displaySalesByProductId(Statement statement, String productId) {

    }

    @Override
    public void deleteSalesById(Statement statement, String id) {

    }

    @Override
    public void updateSalesById(Statement statement, String id) {

    }

    @Override
    public Sales createSales(Statement statement, String salesId, String shiftId, String workerId, String productId) {
        return null;
    }

    @Override
    public void addSales(Statement statement, String salesId, String shiftId, String workerId, String productId) {

    }

    @Override
    public void printSales(Sales sales) {

    }
}
