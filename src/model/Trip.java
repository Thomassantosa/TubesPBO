package model;

public class Trip {
    private int tripId;
    private Triptype tripType;
    private String origin;
    private String destination;
    private int derpatureTime;
    private int arrivalTime;
    private int date;
    private int tripTime;

    public Trip() {
    }

    public Trip(int tripId, Triptype tripType, String origin, String destination, int derpatureTime, int arrivalTime,
            int date, int tripTime) {
        this.tripId = tripId;
        this.tripType = tripType;
        this.origin = origin;
        this.destination = destination;
        this.derpatureTime = derpatureTime;
        this.arrivalTime = arrivalTime;
        this.date = date;
        this.tripTime = tripTime;
    }

    public int getTripId() {
        return this.tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public Triptype getTripType() {
        return this.tripType;
    }

    public void setTripType(Triptype tripType) {
        this.tripType = tripType;
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

    public int getDerpatureTime() {
        return this.derpatureTime;
    }

    public void setDerpatureTime(int derpatureTime) {
        this.derpatureTime = derpatureTime;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDate() {
        return this.date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTripTime() {
        return this.tripTime;
    }

    public void setTripTime(int tripTime) {
        this.tripTime = tripTime;
    }
}