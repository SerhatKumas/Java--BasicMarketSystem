package DataAccessLayerPackage.Interfaces;

import AssetsPackage.ProductPackage.Product;

import java.util.Date;

public interface IProductDAL {
    void displayProductsByName(String name);
    void displayProductsByCategory(String category);
    void displayProductById(String id);
    void displayByDateOfRegisteredInMarket(Date date);

    void deleteProductById(String id);

    void updateProductById(String id);

    Product createProduct(String name, String productId, String marketId, String productCategory, Date dateOfProduction, Date dateOfRecommendedLastConsumption, Date dateOfRegisteredInMarket, Date dateOfPurchase);

    void addProduct(String name, String productId, String marketId, String productCategory, Date dateOfProduction, Date dateOfRecommendedLastConsumption, Date dateOfRegisteredInMarket, Date dateOfPurchase);

    void printProduct(Product product);
}
