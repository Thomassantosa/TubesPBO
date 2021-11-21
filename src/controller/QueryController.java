package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Airlines;
import model.Vehicle;
import model.Airport;
import model.BusCompany;
import model.BusTrip;
import model.Station;

public class QueryController {

    DatabaseHandler conn = new DatabaseHandler();
    
    public boolean insertAirline(Airlines airline) {
        conn.connect();
        String query = "INSERT INTO `airlines`(`airline_name`, `airline_cantact`) VALUES ('?','?')";
        try {
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setString(1, airline.getName());
            stmt.setString(2, airline.getContact());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean insertAirplane(Vehicle Vehicle) {
        conn.connect();
        String query = "INSERT INTO `airplanes`(`airplane_model`) VALUES ('?')";
        try {
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setString(1, Vehicle.getModel());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public boolean insertAirport(Airport airport) {
        conn.connect();
        String query = "INSERT INTO `airports`(`airport_code`, `airport_name`, `airport_city`, `airport_country`) VALUES ('?','?','?','?')";
        try {
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setString(1, airport.getCode());
            stmt.setString(2, airport.getName());
            stmt.setString(3, airport.getCity());
            stmt.setString(4, airport.getCountry());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
        
    public boolean insertBusCompany(BusCompany busCompany) {
        conn.connect();
        String query = "INSERT INTO `buscompanies`(`buscompany_name`, `buscompany_contact`, `buscompany_address`) VALUES ('?','?','?')";
        try {
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setString(1, busCompany.getName());
            stmt.setString(2, busCompany.getContact());
            stmt.setString(3, busCompany.getAddress());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public boolean insertBusStation(Station station) {
        conn.connect();
        String query = "INSERT INTO `busstations`(`busstation_code`, `busstation_name`, `busstation_city`) VALUES ('?','?','?')";
        try {
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setString(1, station.getCode());
            stmt.setString(2, station.getName());
            stmt.setString(3, station.getCity());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public boolean insertBusTrip(BusTrip busTrip) {
        conn.connect();
        String query = "INSERT INTO `busstations`(`bus_id`, `departure_busstation`, `destination_busstation`, `busTrip_number`, `departure_time`, `arrival_time`, `daparture_date`, `arrival_date`, `travel_time`) VALUES ('?','?','?','?','?','?','?','?','?')";
        try {
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setInt(1, busTrip.getBus().getVehicleID());
            stmt.setInt(2, busTrip.getDepartureStation().getStationID());
            stmt.setInt(3, busTrip.getDepartureStation().getStationID());
            stmt.setString(4, busTrip.getBusTripNumber());
            stmt.setInt(5, busTrip.getDepartureTime());
            stmt.setInt(6, busTrip.getArrivalTime());
            stmt.setDate(7, busTrip.getDepartureDate());
            stmt.setDate(8, busTrip.getArrivalDate());
            stmt.setInt(9, busTrip.getTripTime());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public boolean insertBus(Vehicle vehicle) {
        conn.connect();
        String query = "INSERT INTO `buses`(`bus_model`) VALUES ('?')";
        try {
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setString(1, vehicle.getModel());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
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

    public boolean insertTrain() {

    }
    
    public boolean insertTour() {

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