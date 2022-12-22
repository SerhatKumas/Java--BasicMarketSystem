package AssetsPackage.CharacterPackage;

import java.util.Date;

public class Worker {

    //Base class for all type of workers and properties

    private String name;
    private String phone;
    private Date dateOfBirth;
    private String ssn;
    private String address;
    private String workerId;
    private String marketId;
    private String workerPassword;

    public Worker() {
        this.name = "";
        this.phone = "";
        this.dateOfBirth = null;
        this.ssn = "";
        this.address = "";
        this.workerId = "";
        this.marketId = "";
        this.workerPassword = "";
    }

    public Worker(String name, String phone, Date dateOfBirth, String ssn, String address, String workerId, String marketId, String workerPassword) {
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.ssn = ssn;
        this.address = address;
        this.workerId = workerId;
        this.marketId = marketId;
        this.workerPassword = workerPassword;
    }

    public Worker(Worker worker) {
        this.name = worker.name;
        this.phone = worker.phone;
        this.dateOfBirth = worker.dateOfBirth;
        this.ssn = worker.ssn;
        this.address = worker.address;
        this.workerId = worker.workerId;
        this.marketId = worker.marketId;
        this.workerPassword = worker.workerPassword;
    }
}
