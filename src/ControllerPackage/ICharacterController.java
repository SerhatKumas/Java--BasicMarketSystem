package ControllerPackage;

import CharacterPackage.Worker;

public interface ICharacterController {
    void displayById(String id);
    void displayByName(String name);
    void displayBySsn(String ssn);

    void deleteById(String id);
    void deleteBySsn(String ssn);

    void updateById(String id);
    void updateBySsn(String ssn);

    void addNewCharacter(Worker worker);
}
