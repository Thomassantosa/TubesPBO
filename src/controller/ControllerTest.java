// package controller;

// import java.sql.PreparedStatement;
// import java.sql.SQLException;

// import javax.swing.JOptionPane;

// import model.Airlines;
// import model.Vehicle;
// import model.Airport;
// import model.BusCompany;
// import model.BusTrip;
// import model.Flight;
// import model.Hotel;
// import model.Seat;
// import model.Station;
// import model.TrainTrip;

// public class ControllerTest {

//     DatabaseHandler conn = new DatabaseHandler();
    
//     public boolean insertAirline(Airlines airline) {
//         conn.connect();
//         String query = "INSERT INTO `airlines`(`airline_name`, `airline_cantact`) VALUES (?,?)";
//         try {
//             PreparedStatement stmt = conn.conn.prepareStatement(query);
//             stmt.setString(1, airline.getName());
//             stmt.setString(2, airline.getContact());
//             stmt.executeUpdate();
//             return (true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return (false);
//         }
//     }

//     public boolean insertAirplane(Vehicle Vehicle) {
//         conn.connect();
//         String query = "INSERT INTO `airplanes`(`airplane_model`) VALUES (?)";
//         try {
//             PreparedStatement stmt = conn.conn.prepareStatement(query);
//             stmt.setString(1, Vehicle.getModel());
//             stmt.executeUpdate();
//             return (true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return (false);
//         }
//     }
    
//     public boolean insertAirport(Airport airport) {
//         conn.connect();
//         String query = "INSERT INTO `airports`(`airport_code`, `airport_name`, `airport_city`, `airport_country`) VALUES (?,?,?,?)";
//         try {
//             PreparedStatement stmt = conn.conn.prepareStatement(query);
//             stmt.setString(1, airport.getCode());
//             stmt.setString(2, airport.getName());
//             stmt.setString(3, airport.getCity());
//             stmt.setString(4, airport.getCountry());
//             stmt.executeUpdate();
//             return (true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return (false);
//         }
//     }
        
//     public boolean insertBusCompany(BusCompany busCompany) {
//         conn.connect();
//         String query = "INSERT INTO `buscompanies`(`buscompany_name`, `buscompany_contact`, `buscompany_address`) VALUES (?,?,?)";
//         try {
//             PreparedStatement stmt = conn.conn.prepareStatement(query);
//             stmt.setString(1, busCompany.getName());
//             stmt.setString(2, busCompany.getContact());
//             stmt.setString(3, busCompany.getAddress());
//             stmt.executeUpdate();
//             return (true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return (false);
//         }
//     }
    
//     public boolean insertBusStation(Station station) {
//         conn.connect();
//         String query = "INSERT INTO `busstations`(`busstation_code`, `busstation_name`, `busstation_city`) VALUES (?,?,?)";
//         try {
//             PreparedStatement stmt = conn.conn.prepareStatement(query);
//             stmt.setString(1, station.getCode());
//             stmt.setString(2, station.getName());
//             stmt.setString(3, station.getCity());
//             stmt.executeUpdate();
//             return (true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return (false);
//         }
//     }
    
//     public boolean insertBusTrip(BusTrip busTrip) {
//         conn.connect();
//         String query = "INSERT INTO `busstations`(`bus_id`, `departure_busstation`, `destination_busstation`, `busTrip_number`, `departure_time`, `arrival_time`, `daparture_date`, `arrival_date`, `travel_time`) VALUES (?,?,?,?,?,?,?,?,?)";
//         try {
//             PreparedStatement stmt = conn.conn.prepareStatement(query);
//             stmt.setInt(1, busTrip.getBus().getVehicleID());
//             stmt.setInt(2, busTrip.getDepartureStation().getStationID());
//             stmt.setInt(3, busTrip.getDestinationStation().getStationID());
//             stmt.setString(4, busTrip.getBusTripNumber());
//             stmt.setInt(5, busTrip.getDepartureTime());
//             stmt.setInt(6, busTrip.getArrivalTime());
//             stmt.setDate(7, busTrip.getDepartureDate());
//             stmt.setDate(8, busTrip.getArrivalDate());
//             stmt.setInt(9, busTrip.getTripTime());
//             stmt.executeUpdate();
//             return (true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return (false);
//         }
//     }
    
//     public boolean insertBus(Vehicle vehicle) {
//         conn.connect();
//         String query = "INSERT INTO `buses`(`bus_model`) VALUES (?)";
//         try {
//             PreparedStatement stmt = conn.conn.prepareStatement(query);
//             stmt.setString(1, vehicle.getModel());
//             stmt.executeUpdate();
//             return (true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return (false);
//         }
//     }
    
//     public boolean insertFlight(Flight flight) {
//         conn.connect();
//         String query = "INSERT INTO `flights`(`airplane_id`, `departure_airport`, `destination_airport`, `flight_type`, `flight_number`, `departure_time`, `arrival_time`, `departure_date`, `arrival_date`, `travel_time`) VALUES (?,?,?,?,?,?,?,?,?,?)";
//         try {
//             PreparedStatement stmt = conn.conn.prepareStatement(query);
//             stmt.setInt(1, flight.getAirplane().getVehicleID());
//             stmt.setInt(2, flight.getDepartureAirport().getAirportID());
//             stmt.setInt(3, flight.getDestinationAirport().getAirportID());
//             stmt.setString(4, flight.getFlightType());
//             stmt.setString(5, flight.getFlightNumber());
//             stmt.setInt(6, flight.getDepartureTime());
//             stmt.setInt(7, flight.getArrivalTime());
//             stmt.setDate(8, flight.getDepartureDate());
//             stmt.setDate(9, flight.getArrivalDate());
//             stmt.setInt(10, flight.getTripTime());
//             stmt.executeUpdate();
//             return (true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return (false);
//         }
//     }
    
//     public boolean insertHotel(Hotel hotel) {
//         conn.connect();
//         String query = "INSERT INTO `hotels`(`hotel_name`, `hotel_star`, `hotel_rating`, `hotel_review`, `hotel_facility`, `hotel_address`, `hotel_city`, `hotel_country`) VALUES (?,?,?,?,?,?,?,?)";
//         try {
//             PreparedStatement stmt = conn.conn.prepareStatement(query);
//             stmt.setString(1, hotel.getName());
//             stmt.setInt(2, hotel.getStar());
//             stmt.setDouble(2, hotel.getRating());
//             stmt.setInt(2, hotel.getReview());
//             stmt.setString(2, hotel.getFacility());
//             stmt.setString(2, hotel.getAddress());
//             stmt.setString(2, hotel.getCity());
//             stmt.setString(2, hotel.getCountry());
//             stmt.executeUpdate();
//             return (true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return (false);
//         }
//     }
    
//     // public boolean insertImageList() {

//     // }
    
//     // public boolean insertOrder() {

//     // }
    
//     // public boolean insertRoom() {

//     // }
    
//     public boolean insertStation(Station station) {
//         conn.connect();
//         String query = "INSERT INTO `stations`(`station_code`, `station_name`, `station_city`) VALUES (?,?,?)";
//         try {
//             PreparedStatement stmt = conn.conn.prepareStatement(query);
//             stmt.setString(1, station.getCode());
//             stmt.setString(2, station.getName());
//             stmt.setString(3, station.getCity());
//             stmt.executeUpdate();
//             return (true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return (false);
//         }
//     }

//     public boolean insertTrain(Vehicle vehicle) {
//         conn.connect();
//         String query = "INSERT INTO `trains`(`train_model`) VALUES (?)";
//         try {
//             PreparedStatement stmt = conn.conn.prepareStatement(query);
//             stmt.setString(1, vehicle.getModel());
//             stmt.executeUpdate();
//             return (true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return (false);
//         }
//     }
    
//     // public boolean insertTour() {

//     // }
    
//     public boolean insertTrainTrip(TrainTrip trainTrip) {
//         conn.connect();
//         String query = "INSERT INTO `traintrips`(`train_id`, `departure_station`, `destination_station`, `trainTrip_number`, `departure_time`, `arrival_time`, `departure_date`, `arrival_date`, `travel_time`) VALUES (?,?,?,?,?,?,?,?,?)";
//         try {
//             PreparedStatement stmt = conn.conn.prepareStatement(query);
//             stmt.setInt(1, trainTrip.getTrain().getVehicleID());
//             stmt.setInt(2, trainTrip.getDepartureStation().getStationID());
//             stmt.setInt(3, trainTrip.getDestinationStation().getStationID());
//             stmt.setString(4, trainTrip.getTrainTripNumber());
//             stmt.setInt(5, trainTrip.getDepartureTime());
//             stmt.setInt(6, trainTrip.getArrivalTime());
//             stmt.setDate(7, trainTrip.getDepartureDate());
//             stmt.setDate(8, trainTrip.getArrivalDate());
//             stmt.setInt(9, trainTrip.getTripTime());
//             stmt.executeUpdate();
//             return (true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return (false);
//         }
//     }
    
//     // public boolean insertUser() {

//     // }
    
//     public boolean CheckLogin(String jtUsername, String jPassword) {
//         boolean result = false;
//         if (!jtUsername.equals("")) {
//             if (!jPassword.equals("")) {
//                 result = true;
//             }
//         }
//         return result;
//     }

//     public void insertData(){
//         JOptionPane.showMessageDialog(null, "You Have been Registered!");
//     }

//     public boolean CheckRegistration(){
//         return true;
//     }
// }
