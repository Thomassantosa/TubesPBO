package model;

public class Flight extends Trip {
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
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    public String getDerpatureAirport() {
        return this.derpatureAirport;
    }

    public void setDerpatureAirport(String derpatureAirport) {
        this.derpatureAirport = derpatureAirport;
    }

    public String getDestinationAirport() {
        return this.destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getAirline() {
        return this.airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

}
