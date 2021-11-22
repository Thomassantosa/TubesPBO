package model;

public class Airport {
    private int airportID;
    private String code;
    private String name;
    private String city;
    private String country;

    public Airport() {
    }

    public Airport(String code, String name, String city, String country) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public Airport(int airportID, String code, String name, String city, String country) {
        this.airportID = airportID;
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public int getAirportID() {
        return this.airportID;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
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

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "{" +
            " airportID='" + getAirportID() + "'" +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }
}
