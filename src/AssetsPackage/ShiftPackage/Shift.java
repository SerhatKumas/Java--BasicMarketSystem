package AssetsPackage.ShiftPackage;

import java.util.Date;

public class Shift {

    //Shift class and properties

    private String shiftId;
    private String employeeId;
    private String employeeName;
    private Date shiftDay;
    private String timeOfStart;
    private String timeOfEnd;

    public Shift() {
        this.shiftId = "";
        this.employeeId = "";
        this.employeeName = "";
        this.shiftDay = null;
        this.timeOfStart = "";
        this.timeOfEnd = "";
    }

    public Shift(String shiftId, String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd) {
        this.shiftId = shiftId;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.shiftDay = shiftDay;
        this.timeOfStart = timeOfStart;
        this.timeOfEnd = timeOfEnd;
    }

    public Shift(Shift shift) {
        this.shiftId = shift.shiftId;
        this.employeeId = shift.employeeId;
        this.employeeName = shift.employeeName;
        this.shiftDay = shift.shiftDay;
        this.timeOfStart = shift.timeOfStart;
        this.timeOfEnd = shift.timeOfEnd;
    }
}
