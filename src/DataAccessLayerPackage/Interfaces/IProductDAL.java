package DataAccessLayerPackage.Interfaces;

import AssetsPackage.ProductPackage.Product;

import java.sql.Statement;
import java.util.Date;

public interface IProductDAL {
    void displayProductsByName(Statement statement, String name);
    void displayProductsByCategory(Statement statement, String category);
    void displayProductById(Statement statement, String id);

    void deleteProductById(Statement statement, String id);

    void createProduct(Statement statement, String name, String productId, String marketId, String productCategory, Date dateOfProduction, Date dateOfRecommendedLastConsumption, Date dateOfRegisteredInMarket, Date dateOfPurchase);

}
