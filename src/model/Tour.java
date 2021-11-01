package model;
import java.util.ArrayList;
public class Tour {
    private int tourID;
    private String name;
    private String desc;
    private int price;
    private Schedule schedule;
    private ArrayList <Image> orderList = new ArrayList<>();

    public Tour(int tourID, String name, String desc, int price, Schedule schedule, ArrayList<Image> orderList) {
        this.tourID = tourID;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.schedule = schedule;
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

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Schedule getSchedule() {
        return this.schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
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
            " tourID='" + getTourID() + "'" +
            ", name='" + getName() + "'" +
            ", desc='" + getDesc() + "'" +
            ", price='" + getPrice() + "'" +
            ", schedule='" + getSchedule() + "'" +
            ", orderList='" + getOrderList() + "'" +
            "}";
    }

}
