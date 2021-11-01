package model;

import java.util.ArrayList;

public abstract class User {
    private int userID;
<<<<<<< HEAD
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
=======
    private String name;
    private String username;
    private String email;
    private String password;
    private String Address;
    private UserStatusEnum status;

    public User() {
    }

    public User(int userID, String name, String username, String email, String password, UserStatusEnum status, String Address) {
        this.userID = userID;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.Address = Address;
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

<<<<<<< HEAD
    public String getFulName() {
        return this.fulName;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
=======
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
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

<<<<<<< HEAD
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
    
=======
    public UserStatusEnum getStatus() {
        return this.status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
>>>>>>> 2f46109763e3002969092934e4099c581bf472ce
}