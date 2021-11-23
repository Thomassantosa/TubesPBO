package model;

public class Flight extends Trip {

    private String flightType;
    private String flightNumber;
    private Vehicle airplane;
    private Airport departureAirport;
    private Airport destinationAirport;
    private Airlines airline;

    public Flight() {
    }

    public Flight(TripTypesEnum TripTypes, String departureTime, String arrivalTime, String departureDate, String arrivalDate, int tripTime, String flightType, String flightNumber, Vehicle airplane, Airport departureAirport, Airport destinationAirport, Airlines airline) {
        super(TripTypes, departureTime, arrivalTime, departureDate, arrivalDate, tripTime);
        this.flightType = flightType;
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.airline = airline;
    }

    public Flight(int tripID, TripTypesEnum TripTypes, String departureTime, String arrivalTime, String departureDate, String arrivalDate, int tripTime, String flightType, String flightNumber, Vehicle airplane, Airport departureAirport, Airport destinationAirport, Airlines airline) {
        super(tripID, TripTypes, departureTime, arrivalTime, departureDate, arrivalDate, tripTime);
        this.flightType = flightType;
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.airline = airline;
    }

    public String getFlightType() {
        return this.flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Vehicle getAirplane() {
        return this.airplane;
    }

    public void setAirplane(Vehicle airplane) {
        this.airplane = airplane;
    }

    public Airport getDepartureAirport() {
        return this.departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getDestinationAirport() {
        return this.destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public Airlines getAirline() {
        return this.airline;
    }

    public void setAirline(Airlines airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "{" +
            " flightType='" + getFlightType() + "'" +
            ", flightNumber='" + getFlightNumber() + "'" +
            ", airplane='" + getAirplane() + "'" +
            ", departureAirport='" + getDepartureAirport() + "'" +
            ", destinationAirport='" + getDestinationAirport() + "'" +
            ", airline='" + getAirline() + "'" +
            "}";
    }
}

