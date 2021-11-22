package model;

public class Seat {
    private SeatType seatType;
    private int seatCapacity;
    private int baggageCapacity;
    private int price;

    public Seat() {
    }

    public Seat(SeatType seatType, int seatCapacity, int baggageCapacity, int price) {
        this.seatType = seatType;
        this.seatCapacity = seatCapacity;
        this.baggageCapacity = baggageCapacity;
        this.price = price;
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

    @Override
    public String toString() {
        return "{" +
            " seatType='" + getSeatType() + "'" +
            ", seatCapacity='" + getSeatCapacity() + "'" +
            ", baggageCapacity='" + getBaggageCapacity() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }
}