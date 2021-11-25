package model;

import java.util.ArrayList;

public class Hotel {
    private int hotelID;
    private String name;
    private int star;
    private double rating;
    private int review;
    private String facility;
    private String address;
    private String city;
    private String country;
    ArrayList <Room> roomList = new ArrayList<>();
  

    public Hotel() {
    }

    public Hotel(int hotelID, String name, int star, double rating, int review, String facility, String address, String city, String country, ArrayList<Room> roomList) {
        this.hotelID = hotelID;
        this.name = name;
        this.star = star;
        this.rating = rating;
        this.review = review;
        this.facility = facility;
        this.address = address;
        this.city = city;
        this.country = country;
        this.roomList = roomList;
      
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

    public int getStar() {
        return this.star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReview() {
        return this.review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public String getFacility() {
        return this.facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Room> getRoomList() {
        return this.roomList;
    }

    public void setRoomList(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }


    @Override
    public String toString() {
        return "{" +
            " hotelID='" + getHotelID() + "'" +
            ", name='" + getName() + "'" +
            ", star='" + getStar() + "'" +
            ", rating='" + getRating() + "'" +
            ", review='" + getReview() + "'" +
            ", facility='" + getFacility() + "'" +
            ", address='" + getAddress() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            ", roomList='" + getRoomList() + "'" +
            "}";
    }
}