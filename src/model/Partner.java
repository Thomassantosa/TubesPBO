package model;

public class Partner extends User{
    private String partnerType;
    private String companyName;

    public Partner() {
    }

    public Partner(int userID, String fullname, String username, String email, String password, String address, String userType, String partnerType, String companyName) {
        super(userID, fullname, username, email, password, address, userType);
        this.partnerType = partnerType;
        this.companyName = companyName;
    }

    public Partner(String fullname, String username, String email, String password, String address, String userType, String partnerType, String companyName) {
        super(fullname, username, email, password, address, userType);
        this.partnerType = partnerType;
        this.companyName = companyName;
    }

    public String getPartnerType() {
        return this.partnerType;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType;
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
