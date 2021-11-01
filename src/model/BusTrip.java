package model;

public class BusTrip {
    private int busTripNumber;
    private String busModel;
    private String departureStation;
    private String destinationStation;

    public BusTrip(int busTripNumber, String busModel, String departureStation, String destinationStation) {
        this.busTripNumber = busTripNumber;
        this.busModel = busModel;
        this.departureStation = departureStation;
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

    public String getDepartureStation() {
        return this.departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getDestinationStation() {
        return this.destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    @Override
    public String toString() {
        return "{" +
            " busTripNumber='" + getBusTripNumber() + "'" +
            ", busModel='" + getBusModel() + "'" +
            ", departureStation='" + getDepartureStation() + "'" +
            ", destinationStation='" + getDestinationStation() + "'" +
            "}";
    }

}