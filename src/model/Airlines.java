package model;

public class Airlines {
    private int airlineID;
    private String name;
    private String contact;

    public Airlines() {
    }

    public Airlines(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public Airlines(int airlineID, String name, String contact) {
        this.airlineID = airlineID;
        this.name = name;
        this.contact = contact;
    }

    public int getAirlineID() {
        return this.airlineID;
    }

    public void setAirlineID(int airlineID) {
        this.airlineID = airlineID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "{" +
            " airlineID='" + getAirlineID() + "'" +
            ", name='" + getName() + "'" +
            ", contact='" + getContact() + "'" +
            "}";
    }
}
