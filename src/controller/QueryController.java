package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Airlines;

public class QueryController {

    DatabaseHandler conn = new DatabaseHandler();
    
    public boolean insertAirline(Airlines airline) {
        conn.connect();
        String query = "INSERT INTO `airlines`(`airline_name`, `airline_cantact`) VALUES ('?','?')";
        try {
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setString(1, airline.getAirlineName());
            stmt.setString(2, airline.getAirlineContact());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean insertAirplane() {

    }
    
    public boolean insertAirport() {

    }
        
    public boolean insertBusCompany() {
        
    }
    
    public boolean insertBus() {
        
    }
    
    public boolean insertBusStation() {
        
    }
    
    public boolean insertBusTrip() {
        
    }
    
    public boolean insertFlight() {

    }
    
    public boolean insertHotel() {

    }
    
    public boolean insertImageList() {

    }
    
    public boolean insertOrder() {

    }
    
    public boolean insertRoom() {

    }
    
    public boolean insertRoomType() {

    }
    
    public boolean insertSchedule() {

    }
    
    public boolean insertSeat() {

    }
    
    public boolean insertStation() {

    }
    
    public boolean insertTour() {

    }
    
    public boolean insertTrain() {

    }
    
    public boolean insertTrainTrip() {

    }
    
    public boolean insertUser() {

    }
    
    public boolean CheckLogin(String jtUsername, String jPassword) {
        boolean result = false;
        if (!jtUsername.equals("")) {
            if (!jPassword.equals("")) {
                result = true;
            }
        }
        return result;
    }

    public void insertData(){
        JOptionPane.showMessageDialog(null, "You Have been Registered!");
    }

    public boolean CheckRegistration(){
        return true;
    }
}
