package DataAccessLayerPackage.Implementations;

import AssetsPackage.ShiftPackage.Shift;
import DataAccessLayerPackage.Interfaces.IShiftDAL;

import java.util.Date;

public class ShiftDAL implements IShiftDAL {
    @Override
    public void displayByDate(Date date) {

    }

    @Override
    public void displayByTimeRange(String startTime, String endTime) {

    }

    @Override
    public void displayByEmployeeId(String id) {

    }

    @Override
    public void displayByEmployeeName(String name) {

    }

    @Override
    public Shift createShift(String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd) {
        return null;
    }

    @Override
    public void addShift(String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd) {

    }

    @Override
    public void printShift(Shift shift) {

    }
}
