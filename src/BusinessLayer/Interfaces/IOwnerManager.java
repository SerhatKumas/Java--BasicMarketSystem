package BusinessLayer.Interfaces;

import DataAccessLayerPackage.Implementations.OwnerDAL;

import java.sql.Statement;
import java.util.Date;

public interface IOwnerManager {

    void displayAllOwners(OwnerDAL ownerDal, Statement statement);
    void displayOwnerById(OwnerDAL ownerDal, Statement statement, String ownerId);
    void displayOwnersByName(OwnerDAL ownerDal, Statement statement, String ownerName);
    void displayOwnerBySsn(OwnerDAL ownerDal, Statement statement, String ownerSsn);
    void deleteOwnerById(OwnerDAL ownerDal, Statement statement, String ownerId);
    void deleteOwnerBySsn(OwnerDAL ownerDal, Statement statement, String ownerSsn);
    void addNewOwner(OwnerDAL ownerDal, Statement statement, String name, String phone, Date dateOfBirth, String ssn, String address, String workerId, String marketId, String workerPassword, float sharePercentage);
}

