package DataAccessLayerPackage.Implementations;

import AssetsPackage.MarketPackage.Market;
import DataAccessLayerPackage.Interfaces.IMarketDAL;

import java.sql.ResultSet;
import java.sql.Statement;

public class MarketDAL implements IMarketDAL {

    //Displays all markets in market table
    @Override
    public void displayAllMarkets(Statement statement) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM markettable");
            while (resultSet.next()) {
                System.out.println("Market Id : " + resultSet.getString(1) + " \nMarket Name : " + resultSet.getString(2) + " \nMarket Location : " + resultSet.getString(3) + " \nOwner Id : " + resultSet.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays markets by market name in market table
    @Override
    public void displayMarketsByName(Statement statement, String name) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM markettable WHERE MarketName = '" + name + "'");
            while (resultSet.next()) {
                System.out.println("Market Id : " + resultSet.getString(1) + " \nMarket Name : " + resultSet.getString(2) + " \nMarket Location : " + resultSet.getString(3) + " \nOwner Id : " + resultSet.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays markets by market location in market table
    @Override
    public void displayMarketsByLocation(Statement statement, String location) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM markettable WHERE MarketLocation = '" + location + "'");
            while (resultSet.next()) {
                System.out.println("Market Id : " + resultSet.getString(1) + " \nMarket Name : " + resultSet.getString(2) + " \nMarket Location : " + resultSet.getString(3) + " \nOwner Id : " + resultSet.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays markets by market id in market table
    @Override
    public void displayMarketByMarketId(Statement statement, String id) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM markettable WHERE MarketId = '" + id + "'");
            while (resultSet.next()) {
                System.out.println("Market Id : " + resultSet.getString(1) + " \nMarket Name : " + resultSet.getString(2) + " \nMarket Location : " + resultSet.getString(3) + " \nOwner Id : " + resultSet.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Displays markets by owner id in market table
    @Override
    public void displayMarketsByOwnerId(Statement statement, String id) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM markettable WHERE OwnerId = '" + id + "'");
            while (resultSet.next()) {
                System.out.println("Market Id : " + resultSet.getString(1) + " \nMarket Name : " + resultSet.getString(2) + " \nMarket Location : " + resultSet.getString(3) + " \nOwner Id : " + resultSet.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Deletes markets by market id in market table
    @Override
    public void deleteMarketByMarketId(Statement statement, String id) {
        try {
            boolean isDeleted = statement.execute("DELETE FROM markettable WHERE MarketId = '" + id + "'");
            if (isDeleted) {
                System.out.println("Market can not be deleted.");

            } else {
                System.out.println("Market with " + id + " id is deleted.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Creates markets in market table
    @Override
    public void createMarket(Statement statement, String marketId, String name, String location, String ownerId) {
        try {
            boolean isAdded = statement.execute("INSERT INTO `markettable` (`MarketId`, `MarketName`, `MarketLocation`, `OwnerId`) VALUES ('" + marketId + "', '" + name + "', '" + location + "', '" + ownerId + "');");
            if (isAdded) {
                System.out.println("Employee can not be added.");

            } else {
                System.out.println("Employee is added.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
