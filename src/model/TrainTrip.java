package model;

public class TrainTrip  extends Trip{
    private int trainTripNumber;
    private String trainModel;
    private String derpatureStation;
    private String destinationStation;
    
    //private Seat choosenSeat = new Seat();


    public TrainTrip() {
    }

    public TrainTrip(int trainTripNumber, String trainModel, String derpatureStation, String destinationStation) {
        this.trainTripNumber = trainTripNumber;
        this.trainModel = trainModel;
        this.derpatureStation = derpatureStation;
        this.destinationStation = destinationStation;
    }

    public int gettrainTripNumber() {
        return this.trainTripNumber;
    }

    public void settrainTripNumber(int trainTripNumber) {
        this.trainTripNumber = trainTripNumber;
    }

    public String getTrainModel() {
        return this.trainModel;
    }

    public void setTrainModel(String trainModel) {
        this.trainModel = trainModel;
    }

    public String getDerpatureStation() {
        return this.derpatureStation;
    }

    public void setDerpatureStation(String derpatureStation) {
        this.derpatureStation = derpatureStation;
    }

    public String getDestinationStation() {
        return this.destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }



}
