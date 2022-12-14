package DataAccessLayerPackage.Interfaces;

import AssetsPackage.ShiftPackage.Shift;

import java.sql.Statement;
import java.util.Date;

public interface IShiftDAL {
    void displayByDate(Statement statement, Date date);
    void displayByTimeRange(Statement statement, String startTime, String endTime);
    void displayByEmployeeId(Statement statement, String id);
    void displayByEmployeeName(Statement statement, String name);

    Shift createShift(Statement statement, String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd);

    void addShift(Statement statement, String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd);

    void printShift(Shift shift);
}
