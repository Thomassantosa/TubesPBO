package model;
import java.util.ArrayList;
public class Order {
    private int orderID;
    private String orderDate;
    private String orderStatus;
    private String transactionType;
    private ArrayList <Trip> tripList = new ArrayList<>();
    private ArrayList <Hotel> hotelList = new ArrayList<>();
    private ArrayList <Tour> tourList = new ArrayList<>();


    public Order(int orderID, String orderDate, String orderStatus, String transactionType, ArrayList<Trip> tripList, ArrayList<Hotel> hotelList, ArrayList<Tour> tourList) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.transactionType = transactionType;
        this.tripList = tripList;
        this.hotelList = hotelList;
        this.tourList = tourList;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public ArrayList<Trip> getTripList() {
        return this.tripList;
    }

    public void setTripList(ArrayList<Trip> tripList) {
        this.tripList = tripList;
    }

    public ArrayList<Hotel> getHotelList() {
        return this.hotelList;
    }

    public void setHotelList(ArrayList<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public ArrayList<Tour> getTourList() {
        return this.tourList;
    }

    public void setTourList(ArrayList<Tour> tourList) {
        this.tourList = tourList;
    }

    @Override
    public String toString() {
        return "{" +
            " orderID='" + getOrderID() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            ", orderStatus='" + getOrderStatus() + "'" +
            ", transactionType='" + getTransactionType() + "'" +
            ", tripList='" + getTripList() + "'" +
            ", hotelList='" + getHotelList() + "'" +
            ", tourList='" + getTourList() + "'" +
            "}";
    }

}