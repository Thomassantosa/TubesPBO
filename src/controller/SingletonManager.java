package controller;

import model.Partner;
import model.User;

public class SingletonManager {
    
    // Instantiation
    private static SingletonManager instance;
    private User user;
    private Partner partner;
    
    private SingletonManager() {
    }

    public static SingletonManager getInstance() {
        if (instance == null) {
            instance = new SingletonManager();
        }
        return instance;
    }
    
    public User getUser() {
        System.out.println("GET USER");
        if (user == null) {
            setUser(new User());
        }
        return user;
    }

    public void setUser(User user) {
        System.out.println("SET USER");
        this.user = user;
    }

    public Partner getPartner() {
        return this.partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}