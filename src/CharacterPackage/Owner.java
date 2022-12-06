package CharacterPackage;

import java.util.Date;

public class Owner extends Worker{
    private float sharePercentage;

    public Owner() {
        this.sharePercentage = 0;
    }

    public Owner(String name, String phone, Date dateOfBirth, String ssn, String address, String workerId, String marketId, String workerPassword, float sharePercentage) {
        super(name, phone, dateOfBirth, ssn, address, workerId, marketId, workerPassword);
        this.sharePercentage = sharePercentage;
    }

    public Owner(Owner owner) {
        super(owner);
        this.sharePercentage = owner.sharePercentage;
    }
}
