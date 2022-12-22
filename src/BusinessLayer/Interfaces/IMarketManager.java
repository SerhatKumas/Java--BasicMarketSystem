package BusinessLayer.Interfaces;

import DataAccessLayerPackage.Interfaces.IMarketDAL;

import java.sql.Statement;

public interface IMarketManager {
    void displayAllMarkets(IMarketDAL marketDal, Statement statement);

    void displayMarketByMarketId(IMarketDAL marketDal, Statement statement, String marketId);

    void displayMarketsByLocation(IMarketDAL marketDal, Statement statement, String marketLocation);

    void displayMarketsByName(IMarketDAL marketDal, Statement statement, String marketName);

    void displayMarketsByOwnerId(IMarketDAL marketDal, Statement statement, String ownerId);

    void deleteMarketByMarketId(IMarketDAL marketDal, Statement statement, String marketId);

    void addNewMarket(IMarketDAL marketDal, Statement statement, String marketId, String name, String location, String ownerId);
}
