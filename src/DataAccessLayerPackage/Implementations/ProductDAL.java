package DataAccessLayerPackage.Implementations;

import DataAccessLayerPackage.Interfaces.IProductDAL;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class ProductDAL implements IProductDAL {

    //Displays all products in product table
    @Override
    public void displayAllProducts(Statement statement) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM producttable Where dateOfPurchase = '0000-00-00'");
            while (resultSet.next()) {
                System.out.println("Product Id : " + resultSet.getString(1) + " \nProduct Name : " + resultSet.getString(2) + " \nProduct Category : " + resultSet.getString(3) + " \nMarket Id : " + resultSet.getString(4) + " \nDate Of Production: " + resultSet.getDate(5) + " \nDate Of Recommendation Consumption : " + resultSet.getDate(6) + " \nDate Of Registered In Market : " + resultSet.getDate(7));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays product by product name in product table
    @Override
    public void displayProductsByName(Statement statement, String name) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM producttable WHERE ProductName = '" + name + "' AND dateOfPurchase = '0000-00-00'");
            while (resultSet.next()) {
                System.out.println("Product Id : " + resultSet.getString(1) + " \nProduct Name : " + resultSet.getString(2) + " \nProduct Category : " + resultSet.getString(3) + " \nMarket Id : " + resultSet.getString(4) + " \nDate Of Production: " + resultSet.getDate(5) + " \nDate Of Recommendation Consumption : " + resultSet.getDate(6) + " \nDate Of Registered In Market : " + resultSet.getDate(7));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays product by product category in product table
    @Override
    public void displayProductsByCategory(Statement statement, String category) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM producttable WHERE ProductCategory = '" + category + "'");
            while (resultSet.next()) {
                System.out.println("Product Id : " + resultSet.getString(1) + " \nProduct Name : " + resultSet.getString(2) + " \nProduct Category : " + resultSet.getString(3) + " \nMarket Id : " + resultSet.getString(4) + " \nDate Of Production: " + resultSet.getDate(5) + " \nDate Of Recommendation Consumption : " + resultSet.getDate(6) + " \nDate Of Registered In Market : " + resultSet.getDate(7));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays product by product id in product table
    @Override
    public void displayProductById(Statement statement, String id) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM producttable WHERE ProductId = '" + id + "'");
            while (resultSet.next()) {
                System.out.println("Product Id : " + resultSet.getString(1) + " \nProduct Name : " + resultSet.getString(2) + " \nProduct Category : " + resultSet.getString(3) + " \nMarket Id : " + resultSet.getString(4) + " \nDate Of Production: " + resultSet.getDate(5) + " \nDate Of Recommendation Consumption : " + resultSet.getDate(6) + " \nDate Of Registered In Market : " + resultSet.getDate(7));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Updates purchase date of product when any product is sold in product table
    @Override
    public void sellProductById(Statement statement, String id) {
        try {
            boolean isAdded = statement.execute("UPDATE producttable SET DateOfPurchase = '" + new java.sql.Date(new Date().getTime()) + "' WHERE ProductId = '" + id + "'");
            if (isAdded) {
                System.out.println("Item can not be sold.");

            } else {
                System.out.println("Item with id " + id + " is sold.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Updates purchase date of product when any product is refunded in product table
    @Override
    public void refundProductById(Statement statement, String id) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date date = sdf.parse("0000-00-00");

            java.sql.Date sqlDate = new java.sql.Date(Long.valueOf(date.getTime()));
            boolean isAdded = statement.execute("UPDATE producttable SET DateOfPurchase = '" + sqlDate + "' WHERE ProductId = '" + id + "'");
            if (isAdded) {
                System.out.println("Item can not be refunded.");

            } else {
                System.out.println("Item with id " + id + " is refunded.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Deletes product in product table
    @Override
    public void deleteProductById(Statement statement, String id) {
        try {
            boolean isDeleted = statement.execute("DELETE FROM producttable WHERE ProductId = '" + id + "'");
            if (isDeleted) {
                System.out.println("Product can not be deleted.");
            } else {
                System.out.println("Product with " + id + " id is deleted.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Creates product in product table
    @Override
    public void createProduct(Statement statement, String name, String productId, String marketId, String productCategory, Date dateOfProduction, Date dateOfRecommendedLastConsumption, Date dateOfRegisteredInMarket, Date dateOfPurchase) {
        try {
            boolean isAdded = statement.execute("INSERT INTO `producttable` (`ProductId`, `ProductName`, `ProductCategory`, `MarketId`, `DateOfProduction`, `DateOfRecommendedConsumption`, `DateOfRegisteredInMarket`, `DateOfPurchase`) VALUES ('" + productId + "', '" + name + "', '" + productCategory + "', '" + marketId + "', '" + dateOfProduction + "', '" + dateOfRecommendedLastConsumption + "', '" + dateOfRegisteredInMarket + "', '" + dateOfPurchase + "')");
            if (isAdded) {
                System.out.println("Product can not be added.");

            } else {
                System.out.println("Product is added.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}