package model;

import java.util.ArrayList;

public abstract class User {
    private int userID;
    private String fulName;
    private String username;
    private String email;
    private String password;
    private String addresString;
    private userType typeUser;
    private ArrayList <Order> orderList = new ArrayList<>();


    public User(int userID, String fulName, String username, String email, String password, String addresString, userType typeUser, ArrayList<Order> orderList) {
        this.userID = userID;
        this.fulName = fulName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.addresString = addresString;
        this.typeUser = typeUser;
        this.orderList = orderList;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFulName() {
        return this.fulName;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
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

    public String getAddresString() {
        return this.addresString;
    }

    public void setAddresString(String addresString) {
        this.addresString = addresString;
    }

    public userType getTypeUser() {
        return this.typeUser;
    }

    public void setTypeUser(userType typeUser) {
        this.typeUser = typeUser;
    }

    public ArrayList<Order> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "{" +
            " userID='" + getUserID() + "'" +
            ", fulName='" + getFulName() + "'" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", addresString='" + getAddresString() + "'" +
            ", typeUser='" + getTypeUser() + "'" +
            ", orderList='" + getOrderList() + "'" +
            "}";
    }

}