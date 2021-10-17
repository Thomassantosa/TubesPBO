package model;

public class BusTrip extends Trip {
    private int busTripNumber;
    private String busModel;
    private String derpatureStation;
    private String destinationStation;
    //  Seat choosenSeat = new Seat();

    public BusTrip() {
    }

    public BusTrip(int busTripNumber, String busModel, String derpatureStation, String destinationStation) {
        this.busTripNumber = busTripNumber;
        this.busModel = busModel;
        this.derpatureStation = derpatureStation;
        this.destinationStation = destinationStation;
    }

    public int getBusTripNumber() {
        return this.busTripNumber;
    }

    public void setBusTripNumber(int busTripNumber) {
        this.busTripNumber = busTripNumber;
    }

    public String getBusModel() {
        return this.busModel;
    }

    public void setBusModel(String busModel) {
        this.busModel = busModel;
    }

    public String getDerpatureStation() {
        return this.derpatureStation;
    }

    public void setDerpatureStation(String derpatureStation) {
        this.derpatureStation = derpatureStation;
    }

    public String getDestinationStation() {
        return this.destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }
}