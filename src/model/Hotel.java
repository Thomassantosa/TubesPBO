package model;

public class Hotel {
    private int hotelID;
    private String name;
    private int rating;
    private String desc;
    private String address;
    private Room room;

    public Hotel(int hotelID, String name, int rating, String desc, String address, Room room) {
        this.hotelID = hotelID;
        this.name = name;
        this.rating = rating;
        this.desc = desc;
        this.address = address;
        this.room = room;
    }

    public int getHotelID() {
        return this.hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "{" +
            " hotelID='" + getHotelID() + "'" +
            ", name='" + getName() + "'" +
            ", rating='" + getRating() + "'" +
            ", desc='" + getDesc() + "'" +
            ", address='" + getAddress() + "'" +
            ", room='" + getRoom() + "'" +
            "}";
    }

}