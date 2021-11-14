package model;

import java.sql.Date;

public abstract class Trip {
    private int tripID;
    private TripTypesEnum TripTypes;
    private int departureTime;
    private int arrivalTime;
    private Date departureDate;
    private Date arrivalDate;
    private int tripTime;

    public Trip() {
    }

    public Trip(TripTypesEnum TripTypes, int departureTime, int arrivalTime, Date departureDate, Date arrivalDate, int tripTime) {
        this.TripTypes = TripTypes;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.tripTime = tripTime;
    }

    public Trip(int tripID, TripTypesEnum TripTypes, int departureTime, int arrivalTime, Date departureDate, Date arrivalDate, int tripTime) {
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

    public Date getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return this.arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
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