package model;

public class BusTrip extends Trip{
    private String busTripNumber;
    private Vehicle bus;
    private Station departureStation;
    private Station destinationStation;
    private BusCompany busCompany;

    public BusTrip() {
    }

    public BusTrip(TripTypesEnum TripTypes, String departureTime, String arrivalTime, String departureDate, String arrivalDate, int tripTime, String busTripNumber, Vehicle bus, Station departureStation, Station destinationStation, BusCompany busCompany) {
        super(TripTypes, departureTime, arrivalTime, departureDate, arrivalDate, tripTime);
        this.busTripNumber = busTripNumber;
        this.bus = bus;
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
    }

    public BusTrip(int tripID, TripTypesEnum TripTypes, String departureTime, String arrivalTime, String departureDate, String arrivalDate, int tripTime, String busTripNumber, Vehicle bus, Station departureStation, Station destinationStation, BusCompany busCompany) {
        super(tripID, TripTypes, departureTime, arrivalTime, departureDate, arrivalDate, tripTime);
        this.busTripNumber = busTripNumber;
        this.bus = bus;
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
    }

    public String getBusTripNumber() {
        return this.busTripNumber;
    }

    public void setBusTripNumber(String busTripNumber) {
        this.busTripNumber = busTripNumber;
    }

    public Vehicle getBus() {
        return this.bus;
    }

    public void setBus(Vehicle bus) {
        this.bus = bus;
    }

    public Station getDepartureStation() {
        return this.departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public Station getDestinationStation() {
        return this.destinationStation;
    }

    public void setDestinationStation(Station destinationStation) {
        this.destinationStation = destinationStation;
    }

    public BusCompany getBusCompany() {
        return this.busCompany;
    }

    public void setBusCompany(BusCompany busCompany) {
        this.busCompany = busCompany;
    }

    @Override
    public String toString() {
        return "{" +
            " busTripNumber='" + getBusTripNumber() + "'" +
            ", bus='" + getBus() + "'" +
            ", departureStation='" + getDepartureStation() + "'" +
            ", destinationStation='" + getDestinationStation() + "'" +
            ", busCompany='" + getBusCompany() + "'" +
            "}";
    }
}