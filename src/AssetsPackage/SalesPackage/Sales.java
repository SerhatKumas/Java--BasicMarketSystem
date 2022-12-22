package AssetsPackage.SalesPackage;

public class Sales {

    //Sales class and properties

    private String salesId;
    private String shiftId;
    private String workerId;
    private String productId;

    public Sales() {
        this.salesId = "";
        this.shiftId = "";
        this.workerId = "";
        this.productId = "";
    }

    public Sales(String salesId, String shiftId, String workerId, String productId) {
        this.salesId = salesId;
        this.shiftId = shiftId;
        this.workerId = workerId;
        this.productId = productId;
    }

    public Sales(Sales sales) {
        this.salesId = sales.salesId;
        this.shiftId = sales.shiftId;
        this.workerId = sales.workerId;
        this.productId = sales.productId;
    }
}
