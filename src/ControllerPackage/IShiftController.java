package ControllerPackage;

import ShiftPackage.Shift;

import java.util.Date;

public interface IShiftController {
    void displayByDate(Date date);
    void displayByTimeRange(String startTime, String endTime);
    void displayByEmployeeId(String id);
    void displayByEmployeeName(String name);

    Shift createShift(String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd);

    void addShift(String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd);

    void printShift(Shift shift);
}
