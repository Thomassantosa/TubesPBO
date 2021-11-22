package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Flight;
import model.Partner;
import model.User;

public class QueryController {

    DatabaseHandler conn = new DatabaseHandler();
    
    public User selectUserByEmail(String email, String password) {
        conn.connect();
        String query = "SELECT `user_id`, `fullname`, `username`, `email`, `password`, `address`, `user_type`, `company_name` FROM `users` WHERE email='" + email + "' AND password='" + password + "'";
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
        String query = "SELECT `user_id`, `fullname`, `username`, `email`, `password`, `address`, `user_type`, `company_name` FROM `users` WHERE username='" + username + "' AND password='" + password + "'";
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

    public boolean insertUser(User user) {
        conn.connect();
        String query = "INSERT INTO `users`(`fullname`, `username`, `email`, `password`, `address`, `user_type`, `date_created`) VALUES  (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setString(1, user.getFullname());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getAddress());
            stmt.setString(6, user.getUserType());

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String currentDate = dtf.format(now);
            stmt.setString(7, currentDate);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean insertPartner(Partner user) {
        conn.connect();
        String query = "INSERT INTO `users`(`fullname`, `username`, `email`, `password`, `address`, `user_type`, `partner_type`, `company_name`, `date_created`) VALUES  (?,?,?,?,?,?,?,?,?)";
        try {   
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setString(1, user.getFullname());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getAddress());
            stmt.setString(6, user.getUserType());
            stmt.setString(7, user.getPartnerType());
            stmt.setString(8, user.getCompanyName());

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String currentDate = dtf.format(now);
            stmt.setString(9, currentDate);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public int isEmailTaken(String email) {
        conn.connect();
        String query = "SELECT `user_id` FROM `users` WHERE email='" + email + "'";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            int userId = 0;
            
            while (result.next()) {
                userId = result.getInt("user_id");
            }

            if (userId == 0) {
                return 0;
            } else {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int isUsernameTaken(String username) {
        conn.connect();
        String query = "SELECT `user_id` FROM `users` WHERE username='" + username + "'";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            int userId = 0;
            
            while (result.next()) {
                userId = result.getInt("user_id");
            }

            if (userId == 0) {
                return 0;
            } else {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getTotalUser() {
        conn.connect();
        String query = "SELECT COUNT(user_id) FROM users WHERE user_type='User'";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            int userCount = 0;
            
            while (result.next()) {
                userCount = result.getInt("COUNT(user_id)");
            }
            return userCount;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getTotalPartner() {
        conn.connect();
        String query = "SELECT COUNT(user_id) FROM users WHERE user_type='Partner'";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            int userCount = 0;
            
            while (result.next()) {
                userCount = result.getInt("COUNT(user_id)");
            }
            return userCount;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getNewUser() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);

        conn.connect();
        String query = "SELECT COUNT(user_id) FROM users WHERE user_type='User' AND date_created='" + currentDate + "'";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            
            int userCount = 0;
            
            while (result.next()) {
                userCount = result.getInt("COUNT(user_id)");
            }
            return userCount;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getNewPartner() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);

        conn.connect();
        String query = "SELECT COUNT(user_id) FROM users WHERE user_type='Partner' AND date_created='" + currentDate + "'";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            
            int userCount = 0;
            
            while (result.next()) {
                userCount = result.getInt("COUNT(user_id)");
            }
            return userCount;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getNewTransaction() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);

        conn.connect();
        String query = "SELECT COUNT(order_id) FROM orders WHERE order_date='" + currentDate + "'";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            
            int orderCount = 0;
            
            while (result.next()) {
                orderCount = result.getInt("COUNT(order_id)");
            }
            return orderCount;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // public int getTodayIncome() {
    //     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //     LocalDateTime now = LocalDateTime.now();
    //     String currentDate = dtf.format(now);

    //     conn.connect();
    //     String query = "SELECT COUNT(order_id) FROM orders WHERE order_date='" + currentDate + "'";
    //     try {
    //         Statement stmt = conn.conn.createStatement();
    //         ResultSet result = stmt.executeQuery(query);
            
    //         int orderCount = 0;
            
    //         while (result.next()) {
    //             orderCount = result.getInt("COUNT(order_id)");
    //         }
    //         return orderCount;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return -1;
    //     }
    // }

    public ArrayList<Flight> selectAllFlight() {
        conn.connect();

        String query = "SELECT `flight_id`, `airplane_id`, `departure_airport`, `destination_airport`, `flight_type`, `flight_number`, `departure_time`, `arrival_time`, `departure_date`, `arrival_date`, `travel_time` FROM `flights` WHERE 1 ORDER BY flight_id Desc";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<Flight> flights = new ArrayList<>();

            while (result.next()) {
                Flight flight = new Flight();
                user.setIdUser(result.getInt("id_user"));
                flight.setFl

                flights.add(flight);
            }

            return flights;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
