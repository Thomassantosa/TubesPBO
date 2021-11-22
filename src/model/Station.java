package model;

public class Station {
    private int stationID;
    private String code;
    private String name;
    private String city;

    public Station() {
    }

    public Station(String code, String name, String city) {
        this.code = code;
        this.name = name;
        this.city = city;
    }

    public Station(int stationID, String code, String name, String city) {
        this.stationID = stationID;
        this.code = code;
        this.name = name;
        this.city = city;
    }

    public int getStationID() {
        return this.stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{" +
            " stationID='" + getStationID() + "'" +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }
}
