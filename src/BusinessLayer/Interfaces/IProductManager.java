package BusinessLayer.Interfaces;

import DataAccessLayerPackage.Interfaces.IProductDAL;

import java.sql.Statement;
import java.util.Date;

public interface IProductManager {

    void displayAllProducts(IProductDAL productDal, Statement statement);
    void displayProductById(IProductDAL productDal, Statement statement, String productId);
    void displayProductByName(IProductDAL productDal, Statement statement, String productName);
    void displayProductByCategory(IProductDAL productDal, Statement statement, String productCategory);
    void sellProductById(IProductDAL productDal, Statement statement, String id);
    void refundProductById(IProductDAL productDal, Statement statement, String id);
    void deleteProductById(IProductDAL productDal, Statement statement, String productId);
    void addNewProduct(IProductDAL productDal, Statement statement, String name, String productId, String marketId, String productCategory, Date dateOfProduction, Date dateOfRecommendedLastConsumption, Date dateOfRegisteredInMarket, Date dateOfPurchase);
}
