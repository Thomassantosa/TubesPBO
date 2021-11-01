package model;

public class Seat {
    private int seatID;
    private SeatType seatType;
    private int baggageCapacity;
    private int price;

    public Seat(int seatID, SeatType seatType, int baggageCapacity, int price) {
        this.seatID = seatID;
        this.seatType = seatType;
        this.baggageCapacity = baggageCapacity;
        this.price = price;
    }

    public int getSeatID() {
        return this.seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public SeatType getSeatType() {
        return this.seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
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
            ", baggageCapacity='" + getBaggageCapacity() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

}