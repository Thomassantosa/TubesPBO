package model;

import java.sql.Date;

public class TrainTrip extends Trip{
    private String trainTripNumber;
    private Vehicle train;
    private Station departureStation;
    private Station destinationStation;


    public TrainTrip() {
    }

    public TrainTrip(TripTypesEnum TripTypes, String departureTime, String arrivalTime, String departureDate, String arrivalDate, int tripTime, String trainTripNumber, Vehicle train, Station departureStation, Station destinationStation) {
        super(TripTypes, departureTime, arrivalTime, departureDate, arrivalDate, tripTime);
        this.trainTripNumber = trainTripNumber;
        this.train = train;
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
    }

    public TrainTrip(int tripID, TripTypesEnum TripTypes, String departureTime, String arrivalTime, String departureDate, String arrivalDate, int tripTime, String trainTripNumber, Vehicle train, Station departureStation, Station destinationStation) {
        super(tripID, TripTypes, departureTime, arrivalTime, departureDate, arrivalDate, tripTime);
        this.trainTripNumber = trainTripNumber;
        this.train = train;
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
    }

    public String getTrainTripNumber() {
        return this.trainTripNumber;
    }

    public void setTrainTripNumber(String trainTripNumber) {
        this.trainTripNumber = trainTripNumber;
    }

    public Vehicle getTrain() {
        return this.train;
    }

    public void setTrain(Vehicle train) {
        this.train = train;
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

    @Override
    public String toString() {
        return "{" +
            " trainTripNumber='" + getTrainTripNumber() + "'" +
            ", train='" + getTrain() + "'" +
            ", departureStation='" + getDepartureStation() + "'" +
            ", destinationStation='" + getDestinationStation() + "'" +
            "}";
    }
}
