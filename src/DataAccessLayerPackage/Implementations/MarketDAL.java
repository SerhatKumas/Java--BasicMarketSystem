package DataAccessLayerPackage.Implementations;

import AssetsPackage.MarketPackage.Market;
import DataAccessLayerPackage.Interfaces.IMarketDAL;

import java.sql.Statement;

public class MarketDAL implements IMarketDAL {

    @Override
    public void displayMarketsByName(Statement statement, String name) {

    }

    @Override
    public void displayMarketsByLocation(Statement statement, String location) {

    }

    @Override
    public void displayMarketByMarketId(Statement statement, String id) {

    }

    @Override
    public void displayMarketsByOwnerId(Statement statement, String id) {

    }

    @Override
    public void updateMarketByMarketId(Statement statement, String id) {

    }

    @Override
    public void deleteMarketByMarketId(Statement statement, String id) {

    }

    @Override
    public Market createMarket(Statement statement, String marketId, String name, String location, String ownerId) {
        return null;
    }

    @Override
    public void addMarket(Statement statement, String marketId, String name, String location, String ownerId) {

    }

    @Override
    public void printMarket(Market market) {

    }
}
