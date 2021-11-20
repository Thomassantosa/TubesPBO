package model;

import java.sql.Date;
import java.util.ArrayList;

public class Room {
    private int roomID;
    private String name;
    private ConstType roomType;
    private int price;
    private String facility;
    private int capacity;
    private boolean status;
    private Date checkin;
    private Date checkout;
    ArrayList <Image> imageList = new ArrayList<>();

    public Room() {
    }

    public Room(int roomID, String name, ConstType roomType, int price, String facility, int capacity, boolean status, Date checkin, Date checkout, ArrayList<Image> imageList) {
        this.roomID = roomID;
        this.name = name;
        this.roomType = roomType;
        this.price = price;
        this.facility = facility;
        this.capacity = capacity;
        this.status = status;
        this.checkin = checkin;
        this.checkout = checkout;
        this.imageList = imageList;
    }

    public int getRoomID() {
        return this.roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConstType getRoomType() {
        return this.roomType;
    }

    public void setRoomType(ConstType roomType) {
        this.roomType = roomType;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFacility() {
        return this.facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCheckin() {
        return this.checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return this.checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public ArrayList<Image> getImageList() {
        return this.imageList;
    }

    public void setImageList(ArrayList<Image> imageList) {
        this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "{" +
            " roomID='" + getRoomID() + "'" +
            ", name='" + getName() + "'" +
            ", roomType='" + getRoomType() + "'" +
            ", price='" + getPrice() + "'" +
            ", facility='" + getFacility() + "'" +
            ", capacity='" + getCapacity() + "'" +
            ", status='" + isStatus() + "'" +
            ", checkin='" + getCheckin() + "'" +
            ", checkout='" + getCheckout() + "'" +
            ", imageList='" + getImageList() + "'" +
            "}";
    }
}
