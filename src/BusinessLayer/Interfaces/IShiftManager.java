package BusinessLayer.Interfaces;

public interface IShiftManager {
    void displayAllShifts();
    void displayShiftByShiftId();
    void displayShiftsByWorkerId();
    void displayShiftsByWorkerName();
    void displayShiftsByTimeRange();
    void displayShiftsByDate();
    void addNewShift();
}
