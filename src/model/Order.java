package model;

public class Order {
    private int orderID;
    private String orderDate;
    private String personName;
    private String phoneNumber;
    private String email;
    private String orderStatus;
    private String transactionType;
    private TripTypesEnum orderType;

    public Order() {
    }


    public Order(int orderID, String orderDate, String personName, String phoneNumber, String email, String transactionType, TripTypesEnum orderType) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.personName = personName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.transactionType = transactionType;
        this.orderType = orderType;
    }

    public Order(String orderDate, String personName, String phoneNumber, String email, String transactionType, TripTypesEnum orderType) {
        this.orderDate = orderDate;
        this.personName = personName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.transactionType = transactionType;
        this.orderType = orderType;
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

    public String getPersonName() {
        return this.personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public TripTypesEnum getOrderType() {
        return this.orderType;
    }

    public void setOrderType(TripTypesEnum orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "{" +
            " orderID='" + getOrderID() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            ", personName='" + getPersonName() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", orderStatus='" + getOrderStatus() + "'" +
            ", transactionType='" + getTransactionType() + "'" +
            ", orderType='" + getOrderType() + "'" +
            "}";
    }
    
}