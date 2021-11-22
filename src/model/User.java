package model;

import java.util.ArrayList;

public class User {
    private int userID;
    private String fullname;
    private String username;
    private String email;
    private String password;
    private String address;
    private String userType;
    private String dateCreated;
    private ArrayList <Order> orderList = new ArrayList<>();

    public User() {
    }

    public User(int userID, String fullname, String username, String email, String password, String address, String userType) {
        this.userID = userID;
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.userType = userType;
    }

    public User(String fullname, String username, String email, String password, String address, String userType) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.userType = userType;
    }

    public User(String fullname, String username, String email, String password, String address) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.userType = ConstType.USER;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public ArrayList<Order> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public String getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "{" +
            " userID='" + getUserID() + "'" +
            ", fullname='" + getFullname() + "'" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", address='" + getAddress() + "'" +
            ", userType='" + getUserType() + "'" +
            ", orderList='" + getOrderList() + "'" +
            "}";
    }
}