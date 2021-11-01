package model;

<<<<<<< HEAD
public class BusTrip {
    private int busTripNumber;
    private String busModel;
    private String departureStation;
    private String destinationStation;

    public BusTrip(int busTripNumber, String busModel, String departureStation, String destinationStation) {
        this.busTripNumber = busTripNumber;
        this.busModel = busModel;
        this.departureStation = departureStation;
=======
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
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
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

<<<<<<< HEAD
    public String getDepartureStation() {
        return this.departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
=======
    public String getDerpatureStation() {
        return this.derpatureStation;
    }

    public void setDerpatureStation(String derpatureStation) {
        this.derpatureStation = derpatureStation;
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
    }

    public String getDestinationStation() {
        return this.destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }
<<<<<<< HEAD

    @Override
    public String toString() {
        return "{" +
            " busTripNumber='" + getBusTripNumber() + "'" +
            ", busModel='" + getBusModel() + "'" +
            ", departureStation='" + getDepartureStation() + "'" +
            ", destinationStation='" + getDestinationStation() + "'" +
            "}";
    }

=======
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
}