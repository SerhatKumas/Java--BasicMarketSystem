package ShiftPackage;

import java.util.Date;

public class Shift {
    private String employeeId;
    private String employeeName;
    private Date shiftDay;
    private String timeOfStart;
    private String timeOfEnd;

    public Shift() {
        this.employeeId = "";
        this.employeeName = "";
        this.shiftDay = null;
        this.timeOfStart = "";
        this.timeOfEnd = "";
    }

    public Shift(String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.shiftDay = shiftDay;
        this.timeOfStart = timeOfStart;
        this.timeOfEnd = timeOfEnd;
    }

    public Shift(Shift shift) {
        this.employeeId = shift.employeeId;
        this.employeeName = shift.employeeName;
        this.shiftDay = shift.shiftDay;
        this.timeOfStart = shift.timeOfStart;
        this.timeOfEnd = shift.timeOfEnd;
    }
}
