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
    public ArrayList<String> showCityBus(){
        conn.connect();
        String query = "SELECT DISTINCT `busstation_city` FROM `busstasions`";
        return null;
    }
    public ArrayList<Flight> showFlights(Airport departureAirport,Airport destinationAirport){
        conn.connect();
        String query = "SELECT b.airport_name AS airport_name_departure,c.airport_name AS aiport_name_destination,a.flight_number,a.departure_time,a.departure_date,a.arrival_time,a.arrival_date,a.travel_time,d.seat_price,d.seat_avaliable, d.seat_type FROM flights a JOIN airports b on a.departure_airport = b.airport_id JOIN airports c on a.destination_airport = c.airport_id JOIN seats d on a.airplane_id = d.airplane_id WHERE b.airport_city = `"+departureAirport+"` AND c.airport_city = `"+destinationAirport+"`;";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<Flight> flights = new ArrayList<>();

            while (result.next()) {
                Flight showFlights = new Flight();
            }

            return flights;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<TrainTrip> showTrainTrip(String departureStation,String destinationStation ){
        conn.connect();
        String query = "SELECT d.train_model,a.departure_station,b.station_name AS station_name_departure,a.destination_station,c.station_name AS station_name_destination,a.trainTrip_number,a.departure_time,a.arrival_time,a.departure_date,a.arrival_date, a.travel_time,e.seat_price,e.seat_avaliable,e.seat_type FROM traintrips a JOIN stations b on a.departure_station = b.station_id JOIN stations c on a.destination_station = c.station_id JOIN trains d on a.train_id = d.train_id JOIN seats e on d.train_id = e.train_id WHERE b.station_city = `"+departureStation +"` AND c.station_city=`"+destinationStation+"`;";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<TrainTrip> trains = new ArrayList<>();

            while (result.next()) {
                // TrainTrip showTrip = new TrainTrip();
            }

            return trains;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<BusTrip> showBusTrip(Station departureStation, Station destinationStation){
        String query = "SELECT e.buscompany_name, d.bus_model, a.departure_busstation, b.busstation_name AS busstations_departure, a.destination_busstation, c.busstation_name AS busstations_destination, a.busTrip_number, a.departure_time, a.arrival_time, a.departure_date, a.arrival_date, a.travel_time, f.seat_price, f.seat_avaliable, f.seat_type FROM bustrips a JOIN busstations b on a.departure_busstation = b.busstation_id JOIN busstations c on a.destination_busstation = c.busstation_id JOIN buses d on a.bus_id = d.bus_id JOIN buscompanies e on d.buscompany_id = e.buscompany_id JOIN seats f on d.bus_id = f.bus_id WHERE b.busstation_city = `"+departureStation+"` AND c.busstation_city = `"+destinationStation+"`;";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<BusTrip> bus = new ArrayList<>();

            while (result.next()) {
                BusTrip showTrip = new BusTrip();
            }

            return bus;

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

    // public boolean insertRoomType() {

    // }

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
