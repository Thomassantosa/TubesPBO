package model;
import java.util.ArrayList;
public class Room {
    private int roomID;
    private int price;
    private int facility;
    private String amount;
    private String roomType;
    private ArrayList <Image> orderList = new ArrayList<>();

    public Room(int roomID, int price, int facility, String amount, String roomType, ArrayList<Image> orderList) {
        this.roomID = roomID;
        this.price = price;
        this.facility = facility;
        this.amount = amount;
        this.roomType = roomType;
        this.orderList = orderList;
    }

    public int getRoomID() {
        return this.roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFacility() {
        return this.facility;
    }

    public void setFacility(int facility) {
        this.facility = facility;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public ArrayList<Image> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(ArrayList<Image> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "{" +
            " roomID='" + getRoomID() + "'" +
            ", price='" + getPrice() + "'" +
            ", facility='" + getFacility() + "'" +
            ", amount='" + getAmount() + "'" +
            ", roomType='" + getRoomType() + "'" +
            ", orderList='" + getOrderList() + "'" +
            "}";
    }

}
