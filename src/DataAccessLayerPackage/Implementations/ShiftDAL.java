package DataAccessLayerPackage.Implementations;

import AssetsPackage.ShiftPackage.Shift;
import DataAccessLayerPackage.Interfaces.IShiftDAL;

import java.sql.Statement;
import java.util.Date;

public class ShiftDAL implements IShiftDAL {

    @Override
    public void displayByDate(Statement statement, Date date) {

    }

    @Override
    public void displayByTimeRange(Statement statement, String startTime, String endTime) {

    }

    @Override
    public void displayByEmployeeId(Statement statement, String id) {

    }

    @Override
    public void displayByEmployeeName(Statement statement, String name) {

    }

    @Override
    public Shift createShift(Statement statement, String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd) {
        return null;
    }

    @Override
    public void addShift(Statement statement, String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd) {

    }

    @Override
    public void printShift(Shift shift) {

    }
}
