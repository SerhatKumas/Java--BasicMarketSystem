package DataAccessLayerPackage.Interfaces;

import AssetsPackage.CharacterPackage.Worker;

import java.sql.Statement;

public interface ICharacterDAL {
    void displayById(Statement statement, String id);
    void displayByName(Statement statement, String name);
    void displayBySsn(Statement statement, String ssn);

    void deleteById(Statement statement, String id);
    void deleteBySsn(Statement statement, String ssn);
}
