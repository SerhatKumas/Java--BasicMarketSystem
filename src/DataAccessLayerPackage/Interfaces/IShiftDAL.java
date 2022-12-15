package DataAccessLayerPackage.Interfaces;

import AssetsPackage.ShiftPackage.Shift;

import java.sql.Statement;
import java.util.Date;

public interface IShiftDAL {
    void displayAllShifts(Statement statement);
    void displayByDate(Statement statement, String date);
    void displayByTimeRange(Statement statement, String startTime, String endTime);
    void displayByEmployeeId(Statement statement, String id);
    void displayByEmployeeName(Statement statement, String name);

    void createShift(Statement statement, String shiftId, String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd);
}
