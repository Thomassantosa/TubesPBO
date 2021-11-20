package model;

import java.sql.Date;

public class Partner extends User{
    private String companyName;

    public Partner() {
    }

    public Partner(int userID, String fullname, String username, String email, String password, String address, Date birthdate, String userType, String companyName) {
        super(userID, fullname, username, email, password, address, birthdate, userType);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return super.toString() + "{" + 
            " companyName='" + getCompanyName() + "'" +
            "}";
    }
}
