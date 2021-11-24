package controller;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import model.*;

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

    public ArrayList<Airport> showCityFlight() {
        conn.connect();
        String query = "Select `airport_city` FROM `airports`";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<Airport> airport = new ArrayList<>();

            while (result.next()) {
                Airport city = new Airport();
                city.setCity(result.getString("airport_city"));
                airport.add(city);
            }

            return airport;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Station> showCityTrain() {
        conn.connect();
        String query = "SELECT DISTINCT `station_city` FROM `stations`";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<Station> bus = new ArrayList<>();

            while (result.next()) {
                Station city = new Station();
                city.setCity(result.getString("station_city"));
                bus.add(city);
            }

            return bus;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<String> selectAirplanesModel(){
        conn.connect();
        String query = "SELECT `airplane_model` FROM `airplanes` ORDER BY `airplane_id` ASC;";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> airplaneName = new ArrayList<>();

            while (result.next()) {
                airplaneName.add(result.getString("airplane_model"));
            }
            return airplaneName;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> selectAirportsName(){
        conn.connect();
        String query = "SELECT `airport_name` FROM `airports` GROUP BY airport_id ASC;";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> airportName = new ArrayList<>();

            while (result.next()) {
                airportName.add(result.getString("airport_name"));
            }
            return airportName;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<String> selectBusesModel(){
        conn.connect();
        String query = "SELECT bus_model FROM `buses` group By bus_id ASC;";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> busModel = new ArrayList<>();

            while (result.next()) {
                busModel.add(result.getString("bus_model"));
            }
            return busModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

      
    public ArrayList<String> selectBusStations(){
        conn.connect();
        String query = "SELECT busstation_name FROM `busstations` GROUP By busstation_id ASC;";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> busStations = new ArrayList<>();

            while (result.next()) {
                busStations.add(result.getString("busstation_name"));
            }
            return busStations;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

          
    public ArrayList<String> selectTrainModels (){
        conn.connect();
        String query = "SELECT train_model FROM `trains`GROUP by train_id asc;";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> trainModel = new ArrayList<>();

            while (result.next()) {
                trainModel.add(result.getString("train_model"));
            }
            return trainModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
          
    public ArrayList<String> selectTrainStations(){
        conn.connect();
        String query = "SELECT station_name FROM `stations` group by station_id asc;";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> trainStations = new ArrayList<>();

            while (result.next()) {
                trainStations.add(result.getString("station_name"));
            }
            return trainStations;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
  
    // public boolean insertFlight() {

    // }

    // public boolean insertHotel() {

    // }

    // public boolean insertImageList() {

    // }

    // public boolean insertOrder() {

    // }

    // public boolean insertRoom() {

    // }

    public ArrayList<String> selectRoomType(){
        conn.connect();
        String query = "SELECT `room_type` FROM `rooms` ORDER BY `room_id` ASC;";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> RoomType = new ArrayList<>();

            while (result.next()) {
                RoomType.add(result.getString("room_type"));
            }
            return RoomType;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // public boolean insertSchedule() {

    // }

    // public boolean insertSeat() {

    // }

    // public boolean insertStation() {

    // }

    // public boolean insertTrain() {

    // }

    // public boolean insertTour() {

    // }

    // public boolean insertTrainTrip() {

    // }

    // public boolean insertUser() {

    // }

    public boolean CheckLogin(String jtUsername, String jPassword) {
        boolean result = false;
        if (!jtUsername.equals("")) {
            if (!jPassword.equals("")) {
                result = true;
            }
        }
        return result;
    }

    public void insertData() {
        JOptionPane.showMessageDialog(null, "You Have been Registered!");
    }

    public boolean CheckRegistration() {
        return true;
    }

    
}
