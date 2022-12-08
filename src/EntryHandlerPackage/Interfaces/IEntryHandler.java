package EntryHandlerPackage.Interfaces;

import AssetsPackage.CharacterPackage.Worker;
import UserInterfacesPackage.Interfaces.IUserInterface;

public interface IEntryHandler {

    void logIn(String id, String password);

    void logOut(String id, String password);

    IUserInterface createUiType(Worker worker);


}
