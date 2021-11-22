package model;

public abstract class Trip {
    private int tripID;
    private TripTypesEnum TripTypes;
    private String departureTime;
    private String arrivalTime;
    private String departureDate;
    private String arrivalDate;
    private int tripTime;

    public Trip() {
    }

    public Trip(TripTypesEnum TripTypes, String departureTime, String arrivalTime, String departureDate, String arrivalDate, int tripTime) {
        this.TripTypes = TripTypes;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.tripTime = tripTime;
    }

    public Trip(int tripID, TripTypesEnum TripTypes, String departureTime, String arrivalTime, String departureDate, String arrivalDate, int tripTime) {
        this.tripID = tripID;
        this.TripTypes = TripTypes;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.tripTime = tripTime;
    }

    public int getTripID() {
        return this.tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public TripTypesEnum getTripTypes() {
        return this.TripTypes;
    }

    public void setTripTypes(TripTypesEnum TripTypes) {
        this.TripTypes = TripTypes;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return this.arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
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
            ", TripTypes='" + getTripTypes() + "'" +
            ", departureTime='" + getDepartureTime() + "'" +
            ", arrivalTime='" + getArrivalTime() + "'" +
            ", departureDate='" + getDepartureDate() + "'" +
            ", arrivalDate='" + getArrivalDate() + "'" +
            ", tripTime='" + getTripTime() + "'" +
            "}";
    }
}