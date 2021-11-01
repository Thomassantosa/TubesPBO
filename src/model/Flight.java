package model;

public class Flight extends Trip {
<<<<<<< HEAD
    private String flighNumber;
    private String airplaneModel;
    private String departureAirport;
    private String destinationAirport;
    private String airline;
    private Seat seat;

    public Flight(String flighNumber, String airplaneModel, String departureAirport, String destinationAirport, String airline, Seat seat, int tripID, String trip, TripType TripType, String origin, String destination, int departureTime, int arrivalTime, String date, int tripTime) {
        super(tripID, trip, TripType, origin, destination, departureTime, arrivalTime, date, tripTime);
        this.flighNumber = flighNumber;
        this.airplaneModel = airplaneModel;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.airline = airline;
        this.seat = seat;
    }

    public String getFlighNumber() {
        return flighNumber;
    }

    public void setFlighNumber(String flighNumber) {
        this.flighNumber = flighNumber;
    }

    public String getAirplaneModel() {
        return airplaneModel;
=======
    private String flightNumber;
    private String airplaneModel;
    private String derpatureAirport;
    private String destinationAirport;
    private String airline;

    // masih bingung cara declare
    //private   Seat choosenSeat = new Seat();


    public Flight() {
    }

    public Flight(String flightNumber, String airplaneModel, String derpatureAirport, String destinationAirport,
            String airline) {
        this.flightNumber = flightNumber;
        this.airplaneModel = airplaneModel;
        this.derpatureAirport = derpatureAirport;
        this.destinationAirport = destinationAirport;
        this.airline = airline;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirplaneModel() {
        return this.airplaneModel;
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

<<<<<<< HEAD
    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
=======
    public String getDerpatureAirport() {
        return this.derpatureAirport;
    }

    public void setDerpatureAirport(String derpatureAirport) {
        this.derpatureAirport = derpatureAirport;
    }

    public String getDestinationAirport() {
        return this.destinationAirport;
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getAirline() {
<<<<<<< HEAD
        return airline;
=======
        return this.airline;
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

<<<<<<< HEAD
    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Flight{" + "flighNumber=" + flighNumber + ", airplaneModel=" + airplaneModel + ", departureAirport=" + departureAirport + ", destinationAirport=" + destinationAirport + ", airline=" + airline + ", seat=" + seat + '}';
    }
    
=======
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
}
