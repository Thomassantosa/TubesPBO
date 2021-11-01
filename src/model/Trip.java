package model;

<<<<<<< HEAD
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
=======
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
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
        this.arrivalTime = arrivalTime;
        this.date = date;
        this.tripTime = tripTime;
    }

<<<<<<< HEAD
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
=======
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
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
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

<<<<<<< HEAD
    public int getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
=======
    public int getDerpatureTime() {
        return this.derpatureTime;
    }

    public void setDerpatureTime(int derpatureTime) {
        this.derpatureTime = derpatureTime;
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

<<<<<<< HEAD
    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
=======
    public int getDate() {
        return this.date;
    }

    public void setDate(int date) {
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
        this.date = date;
    }

    public int getTripTime() {
        return this.tripTime;
    }

    public void setTripTime(int tripTime) {
        this.tripTime = tripTime;
    }
<<<<<<< HEAD

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
=======
}
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
