package model;

public abstract class Trip {
    private int tripID;
    private String trip;
    private TripType TripType;
    private String origin;
    private String destination;
    private int departureTime;
    private int arrivalTime;
    private String date;
    private int tripTime;

    public Trip(int tripID, String trip, TripType TripType, String origin, String destination, int departureTime, int arrivalTime, String date, int tripTime) {
        this.tripID = tripID;
        this.trip = trip;
        this.TripType = TripType;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.date = date;
        this.tripTime = tripTime;
    }

    public int getTripID() {
        return this.tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public String getTrip() {
        return this.trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public TripType getTripType() {
        return this.TripType;
    }

    public void setTripType(TripType TripType) {
        this.TripType = TripType;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTripTime() {
        return this.tripTime;
    }

    public void setTripTime(int tripTime) {
        this.tripTime = tripTime;
    }

    @Override
    public String toString() {
        return "{" +
            " tripID='" + getTripID() + "'" +
            ", trip='" + getTrip() + "'" +
            ", TripType='" + getTripType() + "'" +
            ", origin='" + getOrigin() + "'" +
            ", destination='" + getDestination() + "'" +
            ", departureTime='" + getDepartureTime() + "'" +
            ", arrivalTime='" + getArrivalTime() + "'" +
            ", date='" + getDate() + "'" +
            ", tripTime='" + getTripTime() + "'" +
            "}";
    }

}
