package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import model.Airlines;
import model.Airport;
import model.BusCompany;
import model.BusTrip;
import model.Flight;
import model.Hotel;
import model.Order;
import model.Partner;
import model.Seat;
import model.Station;
import model.TrainTrip;
import model.Trip;
import model.TripTypesEnum;
import model.User;
import model.Vehicle;

public class QueryController {

    DatabaseHandler conn = new DatabaseHandler();
    
    public User selectUserByEmail(String email, String password) {
        conn.connect();
        String query = "SELECT `user_id`, `fullname`, `username`, `email`, `password`, `address`, `user_type`, `partner_type`, `company_name` FROM `users` WHERE email='" + email + "' AND password='" + password + "'";
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
                        partner.setPartnerType(result3.getString("partner_type"));
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
        String query = "SELECT `user_id`, `fullname`, `username`, `email`, `password`, `address`, `user_type`, `partner_type`, `company_name` FROM `users` WHERE username='" + username + "' AND password='" + password + "'";
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
                        partner.setPartnerType(result3.getString("partner_type"));
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

    public ArrayList<Trip> selectAllFlight() {
        conn.connect();

        String query = "SELECT a.flight_id, " +
        "a.flight_type, " +
        "a.flight_number, " +
        "a.departure_time, " +
        "a.arrival_time, " +
        "a.departure_date, " +
        "a.arrival_date, " +
        "a.travel_time, " +
        
        "b.airplane_id, " +
        "b.airplane_model, " +
        
        "e.airline_id, " +
        "e.airline_name, " +
        "e.airline_contact, " +
        
        "c.airport_id AS departure_airport_id, " +
        "c.airport_code AS departure_airport_code, " +
        "c.airport_name AS departure_airport_name, " +
        "c.airport_city AS departure_airport_city, " +
        "c.airport_country AS departure_airport_country, " +
        
        "d.airport_id AS destination_airport_id, " +
        "d.airport_code AS destination_airport_code, " +
        "d.airport_name AS destination_airport_name, " +
        "d.airport_city AS destination_airport_city, " +
        "d.airport_country AS destination_airport_country " +
        
        "FROM flights a " +
        "JOIN airplanes b " +
        "ON a.flight_id = b.airplane_id " +
        "JOIN airports c " +
        "ON a.departure_airport = c.airport_id " +
        "JOIN airports d " +
        "ON a.destination_airport = d.airport_id " +
        "JOIN airlines e " +
        "ON b.airline_id = e.airline_id " +
        "WHERE 1 " +
        "ORDER BY flight_id Desc";

        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<Trip> flights = new ArrayList<>();

            while (result.next()) {
                Flight flight = new Flight();
                Vehicle airplane = new Vehicle();
                Airport departureAirport = new Airport();
                Airport destinationAirport = new Airport();
                Airlines airline = new Airlines();

                flight.setTripID(result.getInt("flight_id"));
                flight.setFlightType(result.getString("flight_type"));
                flight.setFlightNumber(result.getString("flight_number"));
                flight.setTripTypes(TripTypesEnum.FLIGHT);
                flight.setDepartureTime(result.getString("departure_time"));
                flight.setArrivalTime(result.getString("arrival_time"));
                flight.setDepartureDate(result.getString("departure_date"));
                flight.setArrivalDate(result.getString("arrival_date"));
                flight.setTripTime(result.getInt("travel_time"));

                airplane.setVehicleID(result.getInt("airplane_id"));
                airplane.setModel(result.getString("airplane_model"));

                departureAirport.setAirportID(result.getInt("departure_airport_id"));
                departureAirport.setName(result.getString("departure_airport_name"));
                departureAirport.setCode(result.getString("departure_airport_code"));
                departureAirport.setCity(result.getString("departure_airport_city"));
                departureAirport.setCountry(result.getString("departure_airport_country"));

                destinationAirport.setAirportID(result.getInt("destination_airport_id"));
                destinationAirport.setName(result.getString("destination_airport_name"));
                destinationAirport.setCode(result.getString("destination_airport_code"));
                destinationAirport.setCity(result.getString("destination_airport_city"));
                destinationAirport.setCountry(result.getString("destination_airport_country"));

                airline.setAirlineID(result.getInt("airline_id"));
                airline.setName(result.getString("airline_name"));
                airline.setContact(result.getString("airline_contact"));

                flight.setAirplane(airplane);
                flight.setDepartureAirport(departureAirport);
                flight.setDestinationAirport(destinationAirport);
                flight.setAirline(airline);
                
                flights.add(flight);
            }

            return flights;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Trip> selectAllTrainTrip() {
        conn.connect();

        String query = "SELECT a.traintrip_id, " +
        "a.traintrip_number, " +
        "a.departure_time, " +
        "a.arrival_time, " +
        "a.departure_date, " +
        "a.arrival_date, " +
        "a.travel_time, " +
        
        "b.train_id, " +
        "b.train_model, " +
        
        "c.station_id AS departure_station_id, " +
        "c.station_code AS departure_station_code, " +
        "c.station_name AS departure_station_name, " +
        "c.station_city AS departure_station_city, " +
        
        "d.station_id AS destination_station_id, " +
        "d.station_code AS destination_station_code, " +
        "d.station_name AS destination_station_name, " +
        "d.station_city AS destination_station_city " +
        
        "FROM traintrips a " +
        "JOIN trains b " +
        "ON a.traintrip_id = b.train_id " +
        "JOIN stations c " +
        "ON a.departure_station = c.station_id " +
        "JOIN stations d " +
        "ON a.destination_station = d.station_id " +
        "WHERE 1 " +
        "ORDER BY traintrip_id Desc";

        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<Trip> trainTrips = new ArrayList<>();

            while (result.next()) {
                TrainTrip trainTrip = new TrainTrip();
                Vehicle train = new Vehicle();
                Station departureStation = new Station();
                Station destinationStation = new Station();

                trainTrip.setTripID(result.getInt("traintrip_id"));
                trainTrip.setTrainTripNumber(result.getString("traintrip_number"));
                trainTrip.setTripTypes(TripTypesEnum.TRAIN);
                trainTrip.setDepartureTime(result.getString("departure_time"));
                trainTrip.setArrivalTime(result.getString("arrival_time"));
                trainTrip.setDepartureDate(result.getString("departure_date"));
                trainTrip.setArrivalDate(result.getString("arrival_date"));
                trainTrip.setTripTime(result.getInt("travel_time"));

                train.setVehicleID(result.getInt("train_id"));
                train.setModel(result.getString("train_model"));

                departureStation.setStationID(result.getInt("departure_station_id"));
                departureStation.setName(result.getString("departure_station_name"));
                departureStation.setCode(result.getString("departure_station_code"));
                departureStation.setCity(result.getString("departure_station_city"));

                destinationStation.setStationID(result.getInt("destination_station_id"));
                destinationStation.setName(result.getString("destination_station_name"));
                destinationStation.setCode(result.getString("destination_station_code"));
                destinationStation.setCity(result.getString("destination_station_city"));

                trainTrip.setTrain(train);
                trainTrip.setDepartureStation(departureStation);
                trainTrip.setDestinationStation(destinationStation);
                
                trainTrips.add(trainTrip);
            }

            return trainTrips;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Trip> selectAllBusTrip() {
        conn.connect();

        String query = "SELECT a.bustrip_id, " +
        "a.bustrip_number, " +
        "a.departure_time, " +
        "a.arrival_time, " +
        "a.departure_date, " +
        "a.arrival_date, " +
        "a.travel_time, " +
        
        "b.bus_id, " +
        "b.bus_model, " +
        
        "e.buscompany_id, " +
        "e.buscompany_name, " +
        "e.buscompany_contact, " +
        "e.buscompany_address, " +
        
        "c.busstation_id AS departure_busstation_id, " +
        "c.busstation_code AS departure_busstation_code, " +
        "c.busstation_name AS departure_busstation_name, " +
        "c.busstation_city AS departure_busstation_city, " +
        
        "d.busstation_id AS destination_busstation_id, " +
        "d.busstation_code AS destination_busstation_code, " +
        "d.busstation_name AS destination_busstation_name, " +
        "d.busstation_city AS destination_busstation_city " +
        
        "FROM bustrips a " +
        "JOIN buses b " +
        "ON a.bustrip_id = b.bus_id " +
        "JOIN busstations c " +
        "ON a.departure_busstation = c.busstation_id " +
        "JOIN busstations d " +
        "ON a.destination_busstation = d.busstation_id " +
        "JOIN buscompanies e " +
        "ON b.buscompany_id = e.buscompany_id " +
        "WHERE 1 " +
        "ORDER BY bustrip_id Desc";

        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<Trip> busTrips = new ArrayList<>();

            while (result.next()) {
                BusTrip busTrip = new BusTrip();
                Vehicle bus = new Vehicle();
                Station departureStation = new Station();
                Station destinationStation = new Station();
                BusCompany busCompany = new BusCompany();

                busTrip.setTripID(result.getInt("bustrip_id"));
                busTrip.setBusTripNumber(result.getString("bustrip_number"));
                busTrip.setTripTypes(TripTypesEnum.BUS);
                busTrip.setDepartureTime(result.getString("departure_time"));
                busTrip.setArrivalTime(result.getString("arrival_time"));
                busTrip.setDepartureDate(result.getString("departure_date"));
                busTrip.setArrivalDate(result.getString("arrival_date"));
                busTrip.setTripTime(result.getInt("travel_time"));

                bus.setVehicleID(result.getInt("bus_id"));
                bus.setModel(result.getString("bus_model"));

                departureStation.setStationID(result.getInt("departure_busstation_id"));
                departureStation.setName(result.getString("departure_busstation_name"));
                departureStation.setCode(result.getString("departure_busstation_code"));
                departureStation.setCity(result.getString("departure_busstation_city"));

                destinationStation.setStationID(result.getInt("destination_busstation_id"));
                destinationStation.setName(result.getString("destination_busstation_name"));
                destinationStation.setCode(result.getString("destination_busstation_code"));
                destinationStation.setCity(result.getString("destination_busstation_city"));

                busCompany.setBusCompanyID(result.getInt("buscompany_id"));
                busCompany.setName(result.getString("buscompany_name"));
                busCompany.setContact(result.getString("buscompany_contact"));
                busCompany.setAddress(result.getString("buscompany_address"));

                busTrip.setBus(bus);
                busTrip.setDepartureStation(departureStation);
                busTrip.setDestinationStation(destinationStation);
                busTrip.setBusCompany(busCompany);
                
                busTrips.add(busTrip);
            }

            return busTrips;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Hotel> selectAllHotel() {
        conn.connect();
        String query = "SELECT hotel_id, " +
        "hotel_name, " +
        "hotel_star, " +
        "hotel_rating, " +
        "hotel_review, " +
        "hotel_facility, " +
        "hotel_address, " +
        "hotel_city, " +
        "hotel_country " +
        "FROM `hotels` " +
        "WHERE 1 " +
        "ORDER BY hotel_id DESC";

        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            ArrayList<Hotel> hotels = new ArrayList<>();
            while (result.next()) {
                Hotel currentHotel = new Hotel();

                currentHotel.setHotelID(result.getInt("hotel_id"));
                currentHotel.setName(result.getString("hotel_name"));
                currentHotel.setStar(result.getInt("hotel_star"));
                currentHotel.setRating(result.getDouble("hotel_rating"));
                currentHotel.setReview(result.getInt("hotel_review"));
                currentHotel.setFacility(result.getString("hotel_facility"));
                currentHotel.setAddress(result.getString("hotel_address"));
                currentHotel.setCity(result.getString("hotel_city"));
                currentHotel.setCountry(result.getString("hotel_country"));
                hotels.add(currentHotel);
            }
            return hotels;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<User> selectAllTraveller() {
        conn.connect();
        String query = "SELECT user_id, " +
        "fullname, " +
        "username, " +
        "email, " +
        "address, " +
        "date_created " +
        "FROM users " +
        "WHERE user_type = 'User' " +
        "ORDER BY user_id DESC";

        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            ArrayList<User> users = new ArrayList<>();
            while (result.next()) {
                User currentUser = new User();

                currentUser.setUserID(result.getInt("user_id"));
                currentUser.setFullname(result.getString("fullname"));
                currentUser.setUsername(result.getString("username"));
                currentUser.setEmail(result.getString("email"));
                currentUser.setAddress(result.getString("address"));
                currentUser.setDateCreated(result.getString("date_created"));
                users.add(currentUser);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Partner> selectAllPartner() {
        conn.connect();
        String query = "SELECT user_id, " +
        "fullname, " +
        "username, " +
        "email, " +
        "address, " +
        "partner_type, " +
        "company_name, " +
        "date_created " +
        "FROM users " +
        "WHERE user_type = 'Partner' " +
        "ORDER BY user_id DESC";

        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            ArrayList<Partner> partners = new ArrayList<>();
            while (result.next()) {
                Partner currentPartner = new Partner();

                currentPartner.setUserID(result.getInt("user_id"));
                currentPartner.setFullname(result.getString("fullname"));
                currentPartner.setUsername(result.getString("username"));
                currentPartner.setEmail(result.getString("email"));
                currentPartner.setAddress(result.getString("address"));
                currentPartner.setPartnerType(result.getString("partner_type"));
                currentPartner.setCompanyName(result.getString("company_name"));
                currentPartner.setDateCreated(result.getString("date_created"));
                partners.add(currentPartner);
            }
            return partners;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateUser(int idUser, User user) {
        conn.connect();
        String query = "UPDATE `users` " +
        "SET `fullname`= ?, " +
        "`username`= ?, " +
        "`email`= ?, " +
        "`password`= ?, " +
        "`address`= ?  " +
        "WHERE user_id = ?";
        try {
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setString(1, user.getFullname());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getAddress());
            stmt.setInt(6, idUser);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public ArrayList<String> selectAirportCity() {
        conn.connect();
        String query = "SELECT DISTINCT `airport_city` FROM `airports` ORDER BY airport_city ASC";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> city = new ArrayList<>();

            while (result.next()) {
                city.add(result.getString("airport_city"));
            }

            return city;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> selectStationCity() {
        conn.connect();
        String query = "SELECT DISTINCT `station_city` FROM `stations` ORDER BY station_city ASC";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> city = new ArrayList<>();

            while (result.next()) {
                city.add(result.getString("station_city"));
            }

            return city;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> selectBusStationCity() {
        conn.connect();
        String query = "SELECT DISTINCT `busstation_city` FROM `busstations` ORDER BY busstation_city ASC";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> city = new ArrayList<>();

            while (result.next()) {
                city.add(result.getString("busstation_city"));
            }

            return city;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> selectHotelCity() {
        conn.connect();
        String query = "SELECT DISTINCT `hotel_city` FROM `hotels` ORDER BY hotel_city ASC";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> city = new ArrayList<>();

            while (result.next()) {
                city.add(result.getString("hotel_city"));
            }

            return city;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> selectSeatName() {
        conn.connect();
        String query = "SELECT DISTINCT `seat_type` FROM `seats` ORDER BY seat_type ASC";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> seatName = new ArrayList<>();

            while (result.next()) {
                seatName.add(result.getString("seat_type"));
            }

            return seatName;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Order> selectUserOrder(int userID) {
        conn.connect();

        String query = "SELECT `order_id`, " +
        "`user_id`, " +
        "`flight_id`, " +
        "`traintrip_id`, " +
        "`bustrip_id`, " +
        "`hotel_id`, " +
        "`order_date`, " +
        "`person_name`, " +
        "`phone_number`, " +
        "`email`, " +
        "`transaction_type` " +
        "FROM `orders` " +
        "WHERE user_id = " + String.valueOf(userID) + " " +
        "ORDER BY order_id DESC";

        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<Order> orders = new ArrayList<>();

            while (result.next()) {
                Order currentOrder = new Order();

                currentOrder.setOrderID(result.getInt("user_id"));
                currentOrder.setOrderDate(result.getString("order_Date"));
                currentOrder.setPhoneNumber(result.getString("phone_number"));
                currentOrder.setPersonName(result.getString("person_name"));
                currentOrder.setEmail(result.getString("email"));
                currentOrder.setTransactionType(result.getString("transaction_type"));

                if (result.getString("flight_id") != null) {
                    currentOrder.setOrderType(TripTypesEnum.FLIGHT);
                } else if (result.getString("traintrip_id") != null) {
                    currentOrder.setOrderType(TripTypesEnum.TRAIN);
                } else if (result.getString("bustrip_id") != null) {
                    currentOrder.setOrderType(TripTypesEnum.BUS);
                } else if (result.getString("hotel_id") != null) {
                    currentOrder.setOrderType(TripTypesEnum.HOTEL);
                }
                orders.add(currentOrder);
            }

            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Flight> selectFlight(String departureCity, String destinationCity, String departureDate, String seatClass) {
        conn.connect();

        String query = "SELECT a.flight_id, " +
        "a.flight_type, " +
        "a.flight_number, " +
        "a.departure_time, " +
        "a.arrival_time, " +
        "a.departure_date, " +
        "a.arrival_date, " +
        "a.travel_time, " +
        
        "b.airplane_id, " +
        "b.airplane_model, " +
        
        "e.airline_id, " +
        "e.airline_name, " +
        "e.airline_contact, " +
        
        "c.airport_id AS departure_airport_id, " +
        "c.airport_code AS departure_airport_code, " +
        "c.airport_name AS departure_airport_name, " +
        "c.airport_city AS departure_airport_city, " +
        "c.airport_country AS departure_airport_country, " +
        
        "d.airport_id AS destination_airport_id, " +
        "d.airport_code AS destination_airport_code, " +
        "d.airport_name AS destination_airport_name, " +
        "d.airport_city AS destination_airport_city, " +
        "d.airport_country AS destination_airport_country, " +
        
        "f.seat_price AS seat_price, " +
        "f.seat_type AS seat_type " +

        "FROM flights a " +
        "JOIN airplanes b " +
        "ON a.airplane_id = b.airplane_id " +
        "JOIN airports c " +
        "ON a.departure_airport = c.airport_id " +
        "JOIN airports d " +
        "ON a.destination_airport = d.airport_id " +
        "JOIN airlines e " +
        "ON b.airline_id = e.airline_id " +
        "JOIN seats f " +
        "ON b.airplane_id = f.airplane_id " +
        "WHERE c.airport_city = '" + departureCity + "' " +
        "AND d.airport_city = '" + destinationCity + "' " +
        "AND f.seat_avaliable > 0 " +
        "AND a.departure_date = '" + departureDate + "' " + 
        "AND f.seat_type = '" + seatClass + "' " +
        "ORDER BY flight_id Desc";

        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<Flight> flights = new ArrayList<>();

            while (result.next()) {
                Flight flight = new Flight();
                Vehicle airplane = new Vehicle();
                Airport departureAirport = new Airport();
                Airport destinationAirport = new Airport();
                Airlines airline = new Airlines();
                Seat seat = new Seat();

                flight.setTripID(result.getInt("flight_id"));
                flight.setFlightType(result.getString("flight_type"));
                flight.setFlightNumber(result.getString("flight_number"));
                flight.setTripTypes(TripTypesEnum.FLIGHT);
                flight.setDepartureTime(result.getString("departure_time"));
                flight.setArrivalTime(result.getString("arrival_time"));
                flight.setDepartureDate(result.getString("departure_date"));
                flight.setArrivalDate(result.getString("arrival_date"));
                flight.setTripTime(result.getInt("travel_time"));

                seat.setPrice(result.getInt("seat_price"));
                seat.setSeatType(result.getString("seat_type"));

                airplane.setVehicleID(result.getInt("airplane_id"));
                airplane.setModel(result.getString("airplane_model"));
                airplane.addSeat(seat);

                departureAirport.setAirportID(result.getInt("departure_airport_id"));
                departureAirport.setName(result.getString("departure_airport_name"));
                departureAirport.setCode(result.getString("departure_airport_code"));
                departureAirport.setCity(result.getString("departure_airport_city"));
                departureAirport.setCountry(result.getString("departure_airport_country"));

                destinationAirport.setAirportID(result.getInt("destination_airport_id"));
                destinationAirport.setName(result.getString("destination_airport_name"));
                destinationAirport.setCode(result.getString("destination_airport_code"));
                destinationAirport.setCity(result.getString("destination_airport_city"));
                destinationAirport.setCountry(result.getString("destination_airport_country"));

                airline.setAirlineID(result.getInt("airline_id"));
                airline.setName(result.getString("airline_name"));
                airline.setContact(result.getString("airline_contact"));

                flight.setAirplane(airplane);
                flight.setDepartureAirport(departureAirport);
                flight.setDestinationAirport(destinationAirport);
                flight.setAirline(airline);
                
                flights.add(flight);
            }

            return flights;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertNewOrder(int userID, Order newOrder, int selectedID) {
        // Get type
        if (newOrder.getOrderType() == TripTypesEnum.FLIGHT) {
            conn.connect();
            String query = "INSERT INTO `orders`(`user_id`, `flight_id`, `order_date`, `person_name`, `phone_number`, `email`, `transaction_type`) VALUES (?,?,?,?,?,?,?)";
            try {
                PreparedStatement stmt = conn.conn.prepareStatement(query);
                stmt.setInt(1, userID);
                stmt.setInt(2, selectedID);
                stmt.setString(3, newOrder.getOrderDate());
                stmt.setString(4, newOrder.getPersonName());
                stmt.setString(5, newOrder.getPhoneNumber());
                stmt.setString(6, newOrder.getEmail());
                stmt.setString(7, newOrder.getTransactionType());
                stmt.executeUpdate();
                return (true);
            } catch (SQLException e) {
                e.printStackTrace();
                return (false);
            }
        } else if (newOrder.getOrderType() == TripTypesEnum.TRAIN) {
            conn.connect();
            String query = "INSERT INTO `orders`(`user_id`, `traintrip_id`, `order_date`, `person_name`, `phone_number`, `email`, `transaction_type`) VALUES (?,?,?,?,?,?,?)";
            try {
                PreparedStatement stmt = conn.conn.prepareStatement(query);
                stmt.setInt(1, userID);
                stmt.setInt(2, selectedID);
                stmt.setString(3, newOrder.getOrderDate());
                stmt.setString(4, newOrder.getPersonName());
                stmt.setString(5, newOrder.getPhoneNumber());
                stmt.setString(6, newOrder.getEmail());
                stmt.setString(7, newOrder.getTransactionType());
                stmt.executeUpdate();
                return (true);
            } catch (SQLException e) {
                e.printStackTrace();
                return (false);
            }
        } else if (newOrder.getOrderType() == TripTypesEnum.BUS) {
            conn.connect();
            String query = "INSERT INTO `orders`(`user_id`, `bustrip_id`, `order_date`, `person_name`, `phone_number`, `email`, `transaction_type`) VALUES (?,?,?,?,?,?,?)";
            try {
                PreparedStatement stmt = conn.conn.prepareStatement(query);
                stmt.setInt(1, userID);
                stmt.setInt(2, selectedID);
                stmt.setString(3, newOrder.getOrderDate());
                stmt.setString(4, newOrder.getPersonName());
                stmt.setString(5, newOrder.getPhoneNumber());
                stmt.setString(6, newOrder.getEmail());
                stmt.setString(7, newOrder.getTransactionType());
                stmt.executeUpdate();
                return (true);
            } catch (SQLException e) {
                e.printStackTrace();
                return (false);
            }
        } else if (newOrder.getOrderType() == TripTypesEnum.HOTEL) {
            conn.connect();
            String query = "INSERT INTO `orders`(`user_id`, `hotel_id`, `order_date`, `person_name`, `phone_number`, `email`, `transaction_type`) VALUES (?,?,?,?,?,?,?)";
            try {
                PreparedStatement stmt = conn.conn.prepareStatement(query);
                stmt.setInt(1, userID);
                stmt.setInt(2, selectedID);
                stmt.setString(3, newOrder.getOrderDate());
                stmt.setString(4, newOrder.getPersonName());
                stmt.setString(5, newOrder.getPhoneNumber());
                stmt.setString(6, newOrder.getEmail());
                stmt.setString(7, newOrder.getTransactionType());
                stmt.executeUpdate();
                return (true);
            } catch (SQLException e) {
                e.printStackTrace();
                return (false);
            }
        }
        return false;
    }
    public ArrayList<BusTrip> selectBusTrip (String departureCity, String destinationCity, String departureDate, String seatClass) {
        conn.connect();

        String query = "SELECT a.bustrip_id,"+
        "a.busTrip_number,"+
        "a.departure_date," +
        "a.departure_time, "+
        "a.arrival_date, " +
        "a.arrival_time, "+
        "a.travel_time, "+
        "b.bus_model," +
        "e.buscompany_id,"+
        "e.buscompany_name,"+
        "e.buscompany_contact," +
        "c.busstation_id AS departure_busstation_id,"+
        "c.busstation_code AS departure_busstation_code,"+
        "c.busstation_name AS departure_busstation_name,"+
        "c.busstation_city AS departure_busstation_city,"+
        "d.busstation_id AS destination_busstation_id,"+
        "d.busstation_code AS destination_busstation_code,"+
        "d.busstation_name AS destination_busstation_name,"+
        "d.busstation_city AS destination_busstation_city,"+
        "f.seat_price AS seat_price, " +
        "f.seat_type AS seat_type " + 
        "FROM bustrips a " +
        "JOIN buses b "+
        "on a.bus_id = b.bus_id"+
        "JOIN busstations c "+
        "on a.departure_busstation = c.busstation_id"+
        "JOIN busstations d "+
        "on a.destination_busstation = d.busstation_id"+
        "JOIN buscompanies e "+
        "on b.buscompany_id = e.buscompany_id"+
        "JOIN seats f "+
        "on b.bus_id = f.bus_id"+
        "WHERE c.busstation_city ='" + departureCity + "' "+
        "AND d.busstation_city ='" + destinationCity + "' "+
        "AND f.seat_avaliable > 0 " +
        "AND a.departure_date = '" + departureDate + "' " + 
        "AND f.seat_type = '" + seatClass + "' " +
        "ORDER BY bustrip_id DESC";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<BusTrip> bus = new ArrayList<>();
            while (result.next()) {
                
            }
            return bus;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
