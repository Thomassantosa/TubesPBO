package model;

import java.util.ArrayList;

public class Tour {
    private int tourID;
    private String name;
    private String type;
    private double rating;
    private int review;
    private String highlight;
    private String desc;
    private String facility;
    private String address;
    private String city;
    private String province;
    private String country;
    private int price;
    ArrayList <Schedule> orderList = new ArrayList<>();

    public Tour() {
    }

    public Tour(int tourID, String name, String type, double rating, int review, String highlight, String desc, String facility, String address, String city, String province, String country, int price, ArrayList<Schedule> orderList) {
        this.tourID = tourID;
        this.name = name;
        this.type = type;
        this.rating = rating;
        this.review = review;
        this.highlight = highlight;
        this.desc = desc;
        this.facility = facility;
        this.address = address;
        this.city = city;
        this.province = province;
        this.country = country;
        this.price = price;
        this.orderList = orderList;
    }

    public int getTourID() {
        return this.tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getHighlight() {
        return this.highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Schedule> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(ArrayList<Schedule> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "{" +
            " tourID='" + getTourID() + "'" +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", rating='" + getRating() + "'" +
            ", review='" + getReview() + "'" +
            ", highlight='" + getHighlight() + "'" +
            ", desc='" + getDesc() + "'" +
            ", facility='" + getFacility() + "'" +
            ", address='" + getAddress() + "'" +
            ", city='" + getCity() + "'" +
            ", province='" + getProvince() + "'" +
            ", country='" + getCountry() + "'" +
            ", price='" + getPrice() + "'" +
            ", orderList='" + getOrderList() + "'" +
            "}";
    }
}
