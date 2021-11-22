package model;

public class BusCompany {
    private int busCompanyID;
    private String name;
    private String contact;
    private String address;

    public BusCompany() {
    }

    public BusCompany(String name, String contact, String address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public BusCompany(int busCompanyID, String name, String contact, String address) {
        this.busCompanyID = busCompanyID;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public int getBusCompanyID() {
        return this.busCompanyID;
    }

    public void setBusCompanyID(int busCompanyID) {
        this.busCompanyID = busCompanyID;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
            " busCompanyID='" + getBusCompanyID() + "'" +
            ", name='" + getName() + "'" +
            ", contact='" + getContact() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }
}
