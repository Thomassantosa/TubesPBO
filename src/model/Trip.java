package model;

public abstract class Trip {
    private int tripID;
    private String trip;
    private TripTypes TripTypes;
    private String origin;
    private String destination;
    private int departureTime;
    private int arrivalTime;
    private String date;
    private int tripTime;

    public Trip(int tripID, String trip, TripTypes TripType, String origin, String destination, int departureTime, int arrivalTime, String date, int tripTime) {
        this.tripID = tripID;
        this.trip = trip;
        this.TripTypes = TripType;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
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

    public TripTypes getTripType() {
        return this.TripTypes;
    }

    public void setTripType(TripTypes TripType) {
        this.TripTypes = TripType;
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