package DataAccessLayerPackage.Implementations;

import AssetsPackage.ProductPackage.Product;
import DataAccessLayerPackage.Interfaces.IProductDAL;

import java.util.Date;

public class ProductDAL implements IProductDAL {

    @Override
    public void displayProductsByName(String name) {

    }

    @Override
    public void displayProductsByCategory(String category) {

    }

    @Override
    public void displayProductById(String id) {

    }

    @Override
    public void displayByDateOfRegisteredInMarket(Date date) {

    }

    @Override
    public void deleteProductById(String id) {

    }

    @Override
    public void updateProductById(String id) {

    }

    @Override
    public Product createProduct(String name, String productId, String marketId, String productCategory, Date dateOfProduction, Date dateOfRecommendedLastConsumption, Date dateOfRegisteredInMarket, Date dateOfPurchase) {
        return null;
    }

    @Override
    public void addProduct(String name, String productId, String marketId, String productCategory, Date dateOfProduction, Date dateOfRecommendedLastConsumption, Date dateOfRegisteredInMarket, Date dateOfPurchase) {

    }

    @Override
    public void printProduct(Product product) {

    }
}