package BusinessLayer.Implementations;

import BusinessLayer.Interfaces.IProductManager;
import DataAccessLayerPackage.Interfaces.IProductDAL;

import java.sql.Statement;
import java.util.Date;

public class ProductManager implements IProductManager {

    //Business Layer for Data access layer
    //Rules can be setup here before displaying, creating or deleting data in database

    @Override
    public void displayAllProducts(IProductDAL productDal, Statement statement) {
        productDal.displayAllProducts(statement);
    }

    @Override
    public void displayProductById(IProductDAL productDal, Statement statement, String productId) {
        productDal.displayProductById(statement, productId);
    }

    @Override
    public void displayProductByName(IProductDAL productDal, Statement statement, String productName) {
        productDal.displayProductsByName(statement, productName);
    }

    @Override
    public void displayProductByCategory(IProductDAL productDal, Statement statement, String productCategory) {
        productDal.displayProductsByCategory(statement, productCategory);
    }

    @Override
    public void sellProductById(IProductDAL productDal, Statement statement, String id) {
        productDal.sellProductById(statement, id);
    }

    @Override
    public void refundProductById(IProductDAL productDal, Statement statement, String id) {
        productDal.refundProductById(statement, id);
    }

    @Override
    public void deleteProductById(IProductDAL productDal, Statement statement, String productId) {
        productDal.deleteProductById(statement, productId);
    }

    @Override
    public void addNewProduct(IProductDAL productDal, Statement statement, String name, String productId, String marketId, String productCategory, Date dateOfProduction, Date dateOfRecommendedLastConsumption, Date dateOfRegisteredInMarket, Date dateOfPurchase) {
        productDal.createProduct(statement, name, productId, marketId, productCategory, dateOfProduction, dateOfRecommendedLastConsumption, dateOfRegisteredInMarket, dateOfPurchase);
    }
}
