package model;

public class Seat {
    private int seatId;
    private SeatType seatType;
    private int seatCapacity;
    private int baggageCapacity;
    private int price;

    public Seat() {
    }

    public Seat(int seatId, SeatType seatType, int seatCapacity, int baggageCapacity, int price) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatCapacity = seatCapacity;
        this.baggageCapacity = baggageCapacity;
        this.price = price;
    }

    public int getSeatId() {
        return this.seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public SeatType getSeatType() {
        return this.seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getSeatCapacity() {
        return this.seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
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

}
