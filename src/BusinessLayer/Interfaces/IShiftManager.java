package BusinessLayer.Interfaces;

import DataAccessLayerPackage.Interfaces.IShiftDAL;

import java.sql.Statement;
import java.util.Date;

public interface IShiftManager {
    void displayAllShifts(IShiftDAL shiftDal, Statement statement);

    void displayShiftByShiftId(IShiftDAL shiftDal, Statement statement, String shiftId);

    void displayShiftsByWorkerId(IShiftDAL shiftDal, Statement statement, String workerId);

    void displayShiftsByWorkerName(IShiftDAL shiftDal, Statement statement, String workerName);

    void displayShiftsByTimeRange(IShiftDAL shiftDal, Statement statement, String startTime, String endTime);

    void displayShiftsByDate(IShiftDAL shiftDal, Statement statement, String date);

    void closeShiftsById(IShiftDAL shiftDal, Statement statement, String id);

    void addNewShift(IShiftDAL shiftDal, Statement statement, String shiftId, String employeeId, String employeeName, Date shiftDay, String timeOfStart, String timeOfEnd);
}
