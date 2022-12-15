package DataAccessLayerPackage.Interfaces;

import AssetsPackage.MarketPackage.Market;

import java.sql.Statement;

public interface IMarketDAL {

    void displayAllMarkets(Statement statement);
    void displayMarketsByName(Statement statement, String name);
    void displayMarketsByLocation(Statement statement, String location);
    void displayMarketByMarketId(Statement statement, String id);
    void displayMarketsByOwnerId(Statement statement, String id);

    void deleteMarketByMarketId(Statement statement, String id);

    void createMarket(Statement statement, String marketId, String name, String location, String ownerId);

}
