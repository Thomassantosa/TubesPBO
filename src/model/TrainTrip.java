package model;


public class TrainTrip {
    private int trainTripNumber;
    private String trainModel;
    private String departureStation;
    private String destinationStation;
    private Seat seat;

    public TrainTrip(int trainTripNumber, String trainModel, String departureStation, String destinationStation, Seat seat) {
        this.trainTripNumber = trainTripNumber;
        this.trainModel = trainModel;
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
        this.seat = seat;
    }


    public int getTrainTripNumber() {
        return this.trainTripNumber;
    }

    public void setTrainTripNumber(int trainTripNumber) {
        this.trainTripNumber = trainTripNumber;
    }

    public String getTrainModel() {
        return this.trainModel;
    }

    public void setTrainModel(String trainModel) {
        this.trainModel = trainModel;
    }

    public String getDepartureStation() {
        return this.departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getDestinationStation() {
        return this.destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public Seat getSeat() {
        return this.seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "{" +
            " trainTripNumber='" + getTrainTripNumber() + "'" +
            ", trainModel='" + getTrainModel() + "'" +
            ", departureStation='" + getDepartureStation() + "'" +
            ", destinationStation='" + getDestinationStation() + "'" +
            ", seat='" + getSeat() + "'" +
            "}";
    }
    
}
