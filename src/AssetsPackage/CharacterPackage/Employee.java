package AssetsPackage.CharacterPackage;

import java.util.Date;

public class Employee extends Worker{
    private String title;
    private Date startDate;
    private Date endDate;

    public Employee() {
        this.title = "";
        this.startDate = null;
        this.endDate = null;
    }

    public Employee(String name, String phone, Date dateOfBirth, String ssn, String address, String workerId, String marketId, String workerPassword, String title, Date startDate, Date endDate) {
        super(name, phone, dateOfBirth, ssn, address, workerId, marketId, workerPassword);
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Employee(Employee employee) {
        super(employee);
        this.title = employee.title;
        this.startDate = employee.startDate;
        this.endDate = employee.endDate;
    }
}
