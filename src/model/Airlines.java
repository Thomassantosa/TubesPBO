package model;

public class Airlines {
    private String airlineName;
    private String airlineContact;

    public Airlines() {
    }

    public Airlines(String airlineName, String airlineContact) {
        this.airlineName = airlineName;
        this.airlineContact = airlineContact;
    }

    public String getAirlineName() {
        return this.airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineContact() {
        return this.airlineContact;
    }

    public void setAirlineContact(String airlineContact) {
        this.airlineContact = airlineContact;
    }

    @Override
    public String toString() {
        return "{" +
            " airlineName='" + getAirlineName() + "'" +
            ", airlineContact='" + getAirlineContact() + "'" +
            "}";
    }
}
