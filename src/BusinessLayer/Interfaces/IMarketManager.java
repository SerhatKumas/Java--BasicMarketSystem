package BusinessLayer.Interfaces;

public interface IMarketManager {
    void displayAllMarkets();
    void displayMarketByMarketId();
    void displayMarketsByLocation();
    void displayMarketsByName();
    void displayMarketsByOwnerId();
    void deleteMarketByMarketId();
    void addNewMarket();
}
