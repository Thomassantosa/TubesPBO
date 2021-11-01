package model;

public class Seat {
<<<<<<< HEAD
    private int seatID;
    private SeatType seatType;
    private int baggageCapacity;
    private int price;

    public Seat(int seatID, SeatType seatType, int baggageCapacity, int price) {
        this.seatID = seatID;
        this.seatType = seatType;
=======
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
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
        this.baggageCapacity = baggageCapacity;
        this.price = price;
    }

<<<<<<< HEAD
    public int getSeatID() {
        return this.seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
=======
    public int getSeatId() {
        return this.seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
    }

    public SeatType getSeatType() {
        return this.seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

<<<<<<< HEAD
=======
    public int getSeatCapacity() {
        return this.seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
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

<<<<<<< HEAD
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
=======
}
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
