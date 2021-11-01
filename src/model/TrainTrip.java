package model;

<<<<<<< HEAD
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
=======
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
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
        this.trainTripNumber = trainTripNumber;
    }

    public String getTrainModel() {
        return this.trainModel;
    }

    public void setTrainModel(String trainModel) {
        this.trainModel = trainModel;
    }

<<<<<<< HEAD
    public String getDepartureStation() {
        return this.departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
=======
    public String getDerpatureStation() {
        return this.derpatureStation;
    }

    public void setDerpatureStation(String derpatureStation) {
        this.derpatureStation = derpatureStation;
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
    }

    public String getDestinationStation() {
        return this.destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

<<<<<<< HEAD
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
=======

>>>>>>> 2f46109763e3002969092934e4099c581bf472ce

}
