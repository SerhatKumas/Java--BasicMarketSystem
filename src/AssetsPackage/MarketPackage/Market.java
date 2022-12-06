package AssetsPackage.MarketPackage;

public class Market {
    private String marketId;
    private String name;
    private String location;
    private String ownerId;

    public Market() {
        this.marketId = "";
        this.name = "";
        this.location = "";
        this.ownerId = "";
    }

    public Market(String marketId, String name, String location, String ownerId) {
        this.marketId = marketId;
        this.name = name;
        this.location = location;
        this.ownerId = ownerId;
    }

    public Market(Market market) {
        this.marketId = market.marketId;
        this.name = market.name;
        this.location = market.location;
        this.ownerId = market.ownerId;
    }
}
