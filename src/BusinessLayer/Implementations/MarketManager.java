package BusinessLayer.Implementations;

import BusinessLayer.Interfaces.IMarketManager;
import DataAccessLayerPackage.Interfaces.IMarketDAL;

import java.sql.Statement;

public class MarketManager implements IMarketManager {
    @Override
    public void displayAllMarkets(IMarketDAL marketDal, Statement statement) {
    marketDal.displayAllMarkets(statement);
    }

    @Override
    public void displayMarketByMarketId(IMarketDAL marketDal, Statement statement, String marketId) {
    marketDal.displayMarketByMarketId(statement,marketId);
    }

    @Override
    public void displayMarketsByLocation(IMarketDAL marketDal, Statement statement, String marketLocation) {
    marketDal.displayMarketsByLocation(statement,marketLocation);
    }

    @Override
    public void displayMarketsByName(IMarketDAL marketDal, Statement statement, String marketName) {
    marketDal.displayMarketsByName(statement,marketName);
    }

    @Override
    public void displayMarketsByOwnerId(IMarketDAL marketDal, Statement statement, String ownerId) {
    marketDal.displayMarketsByOwnerId(statement,ownerId);
    }

    @Override
    public void deleteMarketByMarketId(IMarketDAL marketDal, Statement statement, String marketId) {
    marketDal.deleteMarketByMarketId(statement,marketId);
    }

    @Override
    public void addNewMarket(IMarketDAL marketDal, Statement statement, String marketId, String name, String location, String ownerId) {
    marketDal.createMarket(statement, marketId, name, location, ownerId);
    }
}
