package BusinessLayer.Implementations;

import BusinessLayer.Interfaces.IShiftManager;
import DataAccessLayerPackage.Interfaces.IShiftDAL;

import java.sql.Statement;
import java.util.Date;

public class ShiftManager implements IShiftManager {
    @Override
    public void displayAllShifts(IShiftDAL shiftDal, Statement statement) {
    shiftDal.displayAllShifts(statement);
    }

    @Override
    public void displayShiftByShiftId(IShiftDAL shiftDal, Statement statement, String shiftId) {
    shiftDal.displayByShiftId(statement,shiftId);
    }

    @Override
    public void displayShiftsByWorkerId(IShiftDAL shiftDal, Statement statement, String workerId) {
    shiftDal.displayByEmployeeId(statement,workerId);
    }

    @Override
    public void displayShiftsByWorkerName(IShiftDAL shiftDal, Statement statement, String workerName) {
    shiftDal.displayByEmployeeName(statement,workerName);
    }

    @Override
    public void displayShiftsByTimeRange(IShiftDAL shiftDal, Statement statement, String startTime, String endTime) {
    shiftDal.displayByTimeRange(statement,startTime,endTime);
    }

    @Override
    public void displayShiftsByDate(IShiftDAL shiftDal, Statement statement, String date) {
    shiftDal.displayByDate(statement,date);
    }

    @Override
    public void closeShiftsById(IShiftDAL shiftDal, Statement statement, String id) {
        shiftDal.closeTheShiftById(statement,id);
    }

    @Override
    public void addNewShift(IShiftDAL shiftDal, Statement statement, String shiftId, String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd) {
    shiftDal.createShift(statement, shiftId, employeeId, employeeName, shiftDay, timeOfStart, timeOfEnd);
    }
}
