package BusinessLayer.Implementations;

import BusinessLayer.Interfaces.IOwnerManager;
import DataAccessLayerPackage.Implementations.OwnerDAL;

import java.sql.Statement;
import java.util.Date;

public class OwnerManager implements IOwnerManager {

    //Business Layer for Data access layer
    //Rules can be setup here before displaying, creating or deleting data in database

    @Override
    public void displayAllOwners(OwnerDAL ownerDal, Statement statement) {
        ownerDal.displayAll(statement);
    }

    @Override
    public void displayOwnerById(OwnerDAL ownerDal, Statement statement, String ownerId) {
        ownerDal.displayById(statement, ownerId);
    }

    @Override
    public void displayOwnersByName(OwnerDAL ownerDal, Statement statement, String ownerName) {
        ownerDal.displayByName(statement, ownerName);
    }

    @Override
    public void displayOwnerBySsn(OwnerDAL ownerDal, Statement statement, String ownerSsn) {
        ownerDal.displayBySsn(statement, ownerSsn);
    }

    @Override
    public void deleteOwnerById(OwnerDAL ownerDal, Statement statement, String ownerId) {
        ownerDal.deleteById(statement, ownerId);
    }

    @Override
    public void deleteOwnerBySsn(OwnerDAL ownerDal, Statement statement, String ownerSsn) {
        ownerDal.deleteBySsn(statement, ownerSsn);
    }

    @Override
    public void addNewOwner(OwnerDAL ownerDal, Statement statement, String name, String phone, Date dateOfBirth, String ssn, String address, String workerId, String marketId, String workerPassword, float sharePercentage) {
        ownerDal.createNewOwner(statement, name, phone, dateOfBirth, ssn, address, workerId, marketId, workerPassword, sharePercentage);
    }
}
