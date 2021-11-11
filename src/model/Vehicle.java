package model;

import java.util.ArrayList;

public class Vehicle {
    private int vehicleID;
    private String model;
    private ArrayList<Seat> seatList = new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(String model) {
        this.model = model;
    }

    public Vehicle(int vehicleID, String model) {
        this.vehicleID = vehicleID;
        this.model = model;
    }

    public Vehicle(String model, ArrayList<Seat> seatList) {
        this.seatList = seatList;
        this.model = model;
    }

    public int getVehicleID() {
        return this.vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ArrayList<Seat> getSeatList() {
        return this.seatList;
    }

    public void setSeatList(ArrayList<Seat> seatList) {
        this.seatList = seatList;
    }

    public void addSeat(Seat seat) {
        this.seatList.add(seat);
    }

    @Override
    public String toString() {
        return "{" +
            " vehicleID='" + getVehicleID() + "'" +
            ", model='" + getModel() + "'" +
            ", seatList='" + getSeatList() + "'" +
            "}";
    }
}
