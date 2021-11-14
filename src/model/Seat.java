package model;

public class Seat {
    private int seatID;
    private ConstType seatType;
    private int seatAvaliable;
    private int baggageCapacity;
    private int price;

    public Seat() {
    }

    public Seat(ConstType seatType, int seatAvaliable, int baggageCapacity, int price) {
        this.seatType = seatType;
        this.seatAvaliable = seatAvaliable;
        this.baggageCapacity = baggageCapacity;
        this.price = price;
    }

    public Seat(int seatID, ConstType seatType, int seatAvaliable, int baggageCapacity, int price) {
        this.seatID = seatID;
        this.seatType = seatType;
        this.seatAvaliable = seatAvaliable;
        this.baggageCapacity = baggageCapacity;
        this.price = price;
    }

    public int getSeatID() {
        return this.seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public ConstType getSeatType() {
        return this.seatType;
    }

    public void setSeatType(ConstType seatType) {
        this.seatType = seatType;
    }

    public int getSeatAvaliable() {
        return this.seatAvaliable;
    }

    public void setSeatAvaliable(int seatAvaliable) {
        this.seatAvaliable = seatAvaliable;
    }

    public int getBaggageCapacity() {
        return this.baggageCapacity;
    }

    public void setBaggageCapacity(int baggageCapacity) {
        this.baggageCapacity = baggageCapacity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
            " seatID='" + getSeatID() + "'" +
            ", seatType='" + getSeatType() + "'" +
            ", seatAvaliable='" + getSeatAvaliable() + "'" +
            ", baggageCapacity='" + getBaggageCapacity() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }
}