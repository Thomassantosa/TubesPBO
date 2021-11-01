package model;
import java.util.ArrayList;
public class Mitra extends User{
    private String companyName;
    private int fullName;
    public Mitra(String companyName, int fullName, int userID, String fulName, String username, String email, String password, String addresString, userType typeUser, ArrayList<Order> orderList) {
        super(userID, fulName, username, email, password, addresString, typeUser, orderList);
        this.companyName = companyName;
        this.fullName = fullName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getFullName() {
        return this.fullName;
    }

    public void setFullName(int fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "{" +
            " companyName='" + getCompanyName() + "'" +
            ", fullName='" + getFullName() + "'" +
            "}";
    }
    
}
