package DataAccessLayerPackage.Implementations;

import AssetsPackage.SalesPackage.Sales;
import DataAccessLayerPackage.Interfaces.ISalesDAL;

import java.sql.ResultSet;
import java.sql.Statement;

public class SalesDAL implements ISalesDAL {

    //Displays all sales in sales table
    @Override
    public void displayAllSales(Statement statement) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM salestable");
            while (resultSet.next()) {
                System.out.println("Sales Id : " + resultSet.getString(1) + " \nShift Id : " + resultSet.getString(2) + " \nWorker Id : " + resultSet.getString(3) + " \nProduct Id : " + resultSet.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays sales by sales id in sales table
    @Override
    public void displaySaleByID(Statement statement, String id) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM salestable WHERE SalesId = '" + id + "'");
            while (resultSet.next()) {
                System.out.println("Sales Id : " + resultSet.getString(1) + " \nShift Id : " + resultSet.getString(2) + " \nWorker Id : " + resultSet.getString(3) + " \nProduct Id : " + resultSet.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays sales by shift id in sales table
    @Override
    public void displaySalesByShiftId(Statement statement, String shiftId) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM salestable WHERE ShiftId = '" + shiftId + "'");
            while (resultSet.next()) {
                System.out.println("Sales Id : " + resultSet.getString(1) + " \nShift Id : " + resultSet.getString(2) + " \nWorker Id : " + resultSet.getString(3) + " \nProduct Id : " + resultSet.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays sales by employee id in sales table
    @Override
    public void displaySalesByWorkerId(Statement statement, String workerId) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM salestable WHERE WorkerId = '" + workerId + "'");
            while (resultSet.next()) {
                System.out.println("Sales Id : " + resultSet.getString(1) + " \nShift Id : " + resultSet.getString(2) + " \nWorker Id : " + resultSet.getString(3) + " \nProduct Id : " + resultSet.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays sales by product id in sales table
    @Override
    public void displaySalesByProductId(Statement statement, String productId) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM salestable WHERE ProductId = '" + productId + "'");
            while (resultSet.next()) {
                System.out.println("Sales Id : " + resultSet.getString(1) + " \nShift Id : " + resultSet.getString(2) + " \nWorker Id : " + resultSet.getString(3) + " \nProduct Id : " + resultSet.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Deletes sales by sales id in sales table
    @Override
    public void deleteSalesById(Statement statement, String id) {
        try {
            boolean isDeleted = statement.execute("DELETE FROM salestable WHERE SalesId = '" + id + "'");
            if (isDeleted) {
                System.out.println("Sales can not be deleted.");
            } else {
                System.out.println("Sales with " + id + " id is deleted.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Creates sale in sales table
    @Override
    public void createSales(Statement statement, String salesId, String shiftId, String workerId, String productId) {
        try {
            boolean isAdded = statement.execute("INSERT INTO `salestable` (`SalesId`, `ShiftId`, `WorkerId`, `ProductId`) VALUES ('" + salesId + "', '" + shiftId + "', '" + workerId + "', '" + productId + "')");
            if (isAdded) {
                System.out.println("Sales can not be added.");

            } else {
                System.out.println("Sales is added.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
