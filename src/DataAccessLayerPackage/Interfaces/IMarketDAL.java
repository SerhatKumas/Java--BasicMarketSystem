package DataAccessLayerPackage.Interfaces;

import AssetsPackage.MarketPackage.Market;

public interface IMarketDAL {
    void displayMarketsByName(String name);
    void displayMarketsByLocation(String location);
    void displayMarketByMarketId(String id);
    void displayMarketsByOwnerId(String id);

    void updateMarketByMarketId(String id);

    void deleteMarketByMarketId(String id);

    Market createMarket(String marketId, String name, String location, String ownerId);

    void addMarket(String marketId, String name, String location, String ownerId);

    void printMarket(Market market);
}