package model;

public abstract class User {
    private int userID;
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
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
}