package model;

public class Schedule {
    private int scheduleID;
    private String day;
    private int openTime;
    private int closeTime;

    public Schedule(int scheduleID, String day, int openTime, int closeTime) {
        this.scheduleID = scheduleID;
        this.day = day;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public int getScheduleID() {
        return this.scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getOpenTime() {
        return this.openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public int getCloseTime() {
        return this.closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public String toString() {
        return "{" +
            " scheduleID='" + getScheduleID() + "'" +
            ", day='" + getDay() + "'" +
            ", openTime='" + getOpenTime() + "'" +
            ", closeTime='" + getCloseTime() + "'" +
            "}";
    }

}
