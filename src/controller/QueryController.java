package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Partner;
import model.User;

public class QueryController {

    DatabaseHandler conn = new DatabaseHandler();
    
    public User selectUserByEmail(String email, String password) {
        conn.connect();
        String query = "SELECT `user_id`, `fullname`, `username`, `email`, `password`, `address`, `birthdate`, `user_type`, `company_name` FROM `users` WHERE email='" + email + "' AND password='" + password + "'";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result1 = stmt.executeQuery(query);
            
            int id = 0;
            String companyName = "";
            while (result1.next()) {
                id = result1.getInt("user_id");
                companyName = result1.getString("company_name");
            }

            // Check if user found
            if (id != 0) {
                
                // Check selected query is user or partner
                if (companyName == null) {

                    System.out.println("TEST1");
                    User user = new User();
                    ResultSet result2 = stmt.executeQuery(query);
                    while (result2.next()) {
                        user.setUserID(result2.getInt("user_id"));
                        user.setFullname(result2.getString("fullname"));
                        user.setUsername(result2.getString("username"));
                        user.setEmail(result2.getString("email"));
                        user.setPassword(result2.getString("password"));
                        user.setAddress(result2.getString("address"));
                        user.setBirthdate(result2.getDate("birthdate"));
                        user.setUserType(result2.getString("user_type"));
                    }

                    return user;
                } else {

                    System.out.println("TEST2");
                    Partner partner = new Partner();
                    ResultSet result3 = stmt.executeQuery(query);
                    while (result3.next()) {
                        partner.setUserID(result3.getInt("user_id"));
                        partner.setFullname(result3.getString("fullname"));
                        partner.setUsername(result3.getString("username"));
                        partner.setEmail(result3.getString("email"));
                        partner.setPassword(result3.getString("password"));
                        partner.setAddress(result3.getString("address"));
                        partner.setBirthdate(result3.getDate("birthdate"));
                        partner.setUserType(result3.getString("user_type"));
                        partner.setCompanyName(result3.getString("company_name"));
                    }
                    return partner;
                }

            // If user not found, then try select by username
            } else {
                return selectUserByUsername(email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public User selectUserByUsername(String username, String password) {
        conn.connect();
        String query = "SELECT `user_id`, `fullname`, `username`, `email`, `password`, `address`, `birthdate`, `user_type`, `company_name` FROM `users` WHERE username='" + username + "' AND password='" + password + "'";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result1 = stmt.executeQuery(query);
            
            int id = 0;
            String companyName = "";
            while (result1.next()) {
                id = result1.getInt("user_id");
                companyName = result1.getString("company_name");
            }
            
            // Check if user found
            if (id != 0) {

                // Check selected query is user or partner
                if (companyName == null) {
                    
                    User user = new User();
                    ResultSet result2 = stmt.executeQuery(query);
                    while (result2.next()) {
                        user.setUserID(result2.getInt("user_id"));
                        user.setFullname(result2.getString("fullname"));
                        user.setUsername(result2.getString("username"));
                        user.setEmail(result2.getString("email"));
                        user.setPassword(result2.getString("password"));
                        user.setAddress(result2.getString("address"));
                        user.setBirthdate(result2.getDate("birthdate"));
                        user.setUserType(result2.getString("user_type"));
                    }

                    return user;
                } else {
                    
                    Partner partner = new Partner();
                    ResultSet result3 = stmt.executeQuery(query);
                    while (result3.next()) {
                        partner.setUserID(result3.getInt("user_id"));
                        partner.setFullname(result3.getString("fullname"));
                        partner.setUsername(result3.getString("username"));
                        partner.setEmail(result3.getString("email"));
                        partner.setPassword(result3.getString("password"));
                        partner.setAddress(result3.getString("address"));
                        partner.setBirthdate(result3.getDate("birthdate"));
                        partner.setUserType(result3.getString("user_type"));
                        partner.setCompanyName(result3.getString("company_name"));
                    }
                    return partner;
                }

            // If user not found, then return null
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
