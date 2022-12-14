package DataAccessLayerPackage.Implementations;

import AssetsPackage.ProductPackage.Product;
import DataAccessLayerPackage.Interfaces.IProductDAL;

import java.sql.Statement;
import java.util.Date;

public class ProductDAL implements IProductDAL {


    @Override
    public void displayProductsByName(Statement statement, String name) {

    }

    @Override
    public void displayProductsByCategory(Statement statement, String category) {

    }

    @Override
    public void displayProductById(Statement statement, String id) {

    }

    @Override
    public void displayByDateOfRegisteredInMarket(Statement statement, Date date) {

    }

    @Override
    public void deleteProductById(Statement statement, String id) {

    }

    @Override
    public void updateProductById(Statement statement, String id) {

    }

    @Override
    public Product createProduct(Statement statement, String name, String productId, String marketId, String productCategory, Date dateOfProduction, Date dateOfRecommendedLastConsumption, Date dateOfRegisteredInMarket, Date dateOfPurchase) {
        return null;
    }

    @Override
    public void addProduct(Statement statement, String name, String productId, String marketId, String productCategory, Date dateOfProduction, Date dateOfRecommendedLastConsumption, Date dateOfRegisteredInMarket, Date dateOfPurchase) {

    }

    @Override
    public void printProduct(Product product) {

    }
}
