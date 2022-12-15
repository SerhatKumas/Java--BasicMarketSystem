package DataAccessLayerPackage.Implementations;

import DataAccessLayerPackage.Interfaces.IProductDAL;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class ProductDAL implements IProductDAL {


    @Override
    public void displayProductsByName(Statement statement, String name) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM producttable WHERE ProductName = '"+name+"'");
            while(resultSet.next()){
                System.out.println("Product Id : "+resultSet.getString(1) + " \nProduct Name : "+resultSet.getString(2)+" \nProduct Category : "+resultSet.getString(3)+" \nMarket Id : "+resultSet.getString(4)+" \nDate Of Production: "+resultSet.getDate(5)+" \nDate Of Recommendation Consumption : "+resultSet.getDate(6)+" \nDate Of Registered In Market : "+resultSet.getDate(7)+"\n Date Of Purchase : "+resultSet.getDate(8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void displayProductsByCategory(Statement statement, String category) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM producttable WHERE ProductCategory = '"+category+"'");
            while(resultSet.next()){
                System.out.println("Product Id : "+resultSet.getString(1) + " \nProduct Name : "+resultSet.getString(2)+" \nProduct Category : "+resultSet.getString(3)+" \nMarket Id : "+resultSet.getString(4)+" \nDate Of Production: "+resultSet.getDate(5)+" \nDate Of Recommendation Consumption : "+resultSet.getDate(6)+" \nDate Of Registered In Market : "+resultSet.getDate(7)+"\n Date Of Purchase : "+resultSet.getDate(8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void displayProductById(Statement statement, String id) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM producttable WHERE ProductId = '"+id+"'");
            while(resultSet.next()){
                System.out.println("Product Id : "+resultSet.getString(1) + " \nProduct Name : "+resultSet.getString(2)+" \nProduct Category : "+resultSet.getString(3)+" \nMarket Id : "+resultSet.getString(4)+" \nDate Of Production: "+resultSet.getDate(5)+" \nDate Of Recommendation Consumption : "+resultSet.getDate(6)+" \nDate Of Registered In Market : "+resultSet.getDate(7)+"\n Date Of Purchase : "+resultSet.getDate(8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteProductById(Statement statement, String id) {
        try {
            boolean isDeleted = statement.execute("DELETE FROM producttable WHERE ProductId = '"+id+"'");
            if(isDeleted){
                System.out.println("Product can not be deleted.");
            }
            else{
                System.out.println("Product with "+id+" id is deleted.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void createProduct(Statement statement, String name, String productId, String marketId, String productCategory, Date dateOfProduction, Date dateOfRecommendedLastConsumption, Date dateOfRegisteredInMarket, Date dateOfPurchase) {
        try {
            boolean isAdded = statement.execute("INSERT INTO `producttable` (`ProductId`, `ProductName`, `ProductCategory`, `MarketId`, `DateOfProduction`, `DateOfRecommendedConsumption`, `DateOfRegisteredInMarket`, `DateOfPurchase`) VALUES ('"+productId+"', '"+name+"', '"+productCategory+"', '"+marketId+"', '"+dateOfProduction+"', '"+dateOfRecommendedLastConsumption+"', '"+dateOfRegisteredInMarket+"', '"+dateOfPurchase+"')");
            if(isAdded){
                System.out.println("Product can not be added.");

            }
            else{
                System.out.println("Product with is added.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}