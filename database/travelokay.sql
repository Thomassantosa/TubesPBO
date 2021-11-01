-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 01, 2021 at 03:15 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travelokay`
--

-- --------------------------------------------------------

--
-- Table structure for table `airlines`
--

CREATE TABLE `airlines` (
  `airline_id` int(10) NOT NULL,
  `airline_name` varchar(20) NOT NULL,
  `airline_cantact` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `airplanes`
--

CREATE TABLE `airplanes` (
  `airplane_id` int(10) NOT NULL,
  `airline_id` int(10) NOT NULL,
  `airplane_model` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `airports`
--

CREATE TABLE `airports` (
  `airport_id` int(10) NOT NULL,
  `airport_name` int(50) NOT NULL,
  `airport_address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `buscompanies`
--

CREATE TABLE `buscompanies` (
  `buscompany_id` int(10) NOT NULL,
  `buscompany_name` varchar(20) NOT NULL,
  `buscompany_contact` varchar(15) NOT NULL,
  `buscompany_address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `buses`
--

CREATE TABLE `buses` (
  `bus_id` int(10) NOT NULL,
  `buscompany_id` int(10) NOT NULL,
  `bus_model` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `busstations`
--

CREATE TABLE `busstations` (
  `busstation_id` int(10) NOT NULL,
  `busstation_name` varchar(20) NOT NULL,
  `busstation_address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bustrips`
--

CREATE TABLE `bustrips` (
  `bustrip_id` int(10) NOT NULL,
  `bus_id` int(10) NOT NULL,
  `departure_busstation` int(10) NOT NULL,
  `destination_busstation` int(10) NOT NULL,
  `bus_number` varchar(20) NOT NULL,
  `bus_origin` varchar(20) NOT NULL,
  `bus_destination` varchar(20) NOT NULL,
  `departure_time` datetime NOT NULL,
  `arrival_time` datetime NOT NULL,
  `travel_date` date NOT NULL,
  `travel_time` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `flights`
--

CREATE TABLE `flights` (
  `flight_id` int(10) NOT NULL,
  `airplane_id` int(10) NOT NULL,
  `departure_airport` int(10) NOT NULL,
  `destination_airport` int(10) NOT NULL,
  `flight_type` varchar(15) NOT NULL,
  `flight_number` varchar(20) NOT NULL,
  `flight_origin` varchar(20) NOT NULL,
  `flight_destination` varchar(20) NOT NULL,
  `departure_time` datetime NOT NULL,
  `arrival_time` datetime NOT NULL,
  `travel_date` date NOT NULL,
  `travel_time` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `hotels`
--

CREATE TABLE `hotels` (
  `hotel_id` int(10) NOT NULL,
  `hotel_name` varchar(20) NOT NULL,
  `hotel_rating` int(1) NOT NULL,
  `hotel_desc` text NOT NULL,
  `hotel_address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `imagelist`
--

CREATE TABLE `imagelist` (
  `image_id` int(10) NOT NULL,
  `room_id` int(10) NOT NULL,
  `tour_id` int(10) NOT NULL,
  `image_path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `flight_id` int(10) DEFAULT NULL,
  `traintrip_id` int(10) DEFAULT NULL,
  `bustrip_id` int(10) DEFAULT NULL,
  `hotel_id` int(10) DEFAULT NULL,
  `tour_id` int(10) DEFAULT NULL,
  `order_date` date NOT NULL,
  `order_status` varchar(10) NOT NULL,
  `transaction_type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `room_id` int(10) NOT NULL,
  `hotel_id` int(10) NOT NULL,
  `roomtype_id` int(10) NOT NULL,
  `room_price` int(10) NOT NULL,
  `room_facility` text NOT NULL,
  `room_amount` int(2) NOT NULL,
  `room_status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `roomtypes`
--

CREATE TABLE `roomtypes` (
  `roomtype_id` int(11) NOT NULL,
  `roomtype_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `schedules`
--

CREATE TABLE `schedules` (
  `schedule_id` int(10) NOT NULL,
  `tour_id` int(10) NOT NULL,
  `schedule_day` varchar(10) NOT NULL,
  `opentime` time NOT NULL,
  `closetime` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `seats`
--

CREATE TABLE `seats` (
  `seat_id` int(10) NOT NULL,
  `airplane_id` int(10) NOT NULL,
  `train_id` int(10) NOT NULL,
  `bus_id` int(10) NOT NULL,
  `seat_type` varchar(10) NOT NULL,
  `seat_capacity` int(3) NOT NULL,
  `baggage_capacity` int(3) NOT NULL,
  `seat_price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `stations`
--

CREATE TABLE `stations` (
  `station_id` int(10) NOT NULL,
  `station_name` varchar(20) NOT NULL,
  `station_address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tours`
--

CREATE TABLE `tours` (
  `tour_id` int(10) NOT NULL,
  `tour_name` varchar(30) NOT NULL,
  `tour_desc` text NOT NULL,
  `tour_address` varchar(255) NOT NULL,
  `tour_price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `trains`
--

CREATE TABLE `trains` (
  `train_id` int(10) NOT NULL,
  `train_model` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `traintrips`
--

CREATE TABLE `traintrips` (
  `traintrip_id` int(10) NOT NULL,
  `train_id` int(10) NOT NULL,
  `departure_station` int(10) NOT NULL,
  `destination_station` int(10) NOT NULL,
  `train_number` varchar(20) NOT NULL,
  `train_origin` varchar(20) NOT NULL,
  `train_destination` varchar(20) NOT NULL,
  `departure_time` datetime NOT NULL,
  `arrival_time` datetime NOT NULL,
  `travel_date` date NOT NULL,
  `travel_time` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(10) NOT NULL,
  `fullname` varchar(40) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `address` text NOT NULL,
  `user_type` varchar(10) NOT NULL,
  `company_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `airlines`
--
ALTER TABLE `airlines`
  ADD PRIMARY KEY (`airline_id`);

--
-- Indexes for table `airplanes`
--
ALTER TABLE `airplanes`
  ADD PRIMARY KEY (`airplane_id`),
  ADD KEY `airline_id` (`airline_id`);

--
-- Indexes for table `airports`
--
ALTER TABLE `airports`
  ADD PRIMARY KEY (`airport_id`);

--
-- Indexes for table `buscompanies`
--
ALTER TABLE `buscompanies`
  ADD PRIMARY KEY (`buscompany_id`);

--
-- Indexes for table `buses`
--
ALTER TABLE `buses`
  ADD PRIMARY KEY (`bus_id`),
  ADD KEY `buscompany_id` (`buscompany_id`);

--
-- Indexes for table `busstations`
--
ALTER TABLE `busstations`
  ADD PRIMARY KEY (`busstation_id`);

--
-- Indexes for table `bustrips`
--
ALTER TABLE `bustrips`
  ADD PRIMARY KEY (`bustrip_id`),
  ADD KEY `bus_id` (`bus_id`),
  ADD KEY `departure_busstation` (`departure_busstation`),
  ADD KEY `destination_busstation` (`destination_busstation`);

--
-- Indexes for table `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`flight_id`),
  ADD KEY `airplane_id` (`airplane_id`),
  ADD KEY `departure_airport` (`departure_airport`),
  ADD KEY `destination_airport` (`destination_airport`);

--
-- Indexes for table `hotels`
--
ALTER TABLE `hotels`
  ADD PRIMARY KEY (`hotel_id`);

--
-- Indexes for table `imagelist`
--
ALTER TABLE `imagelist`
  ADD PRIMARY KEY (`image_id`),
  ADD KEY `room_id` (`room_id`),
  ADD KEY `tour_id` (`tour_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `flight_id` (`flight_id`),
  ADD KEY `traintrip_id` (`traintrip_id`),
  ADD KEY `bustrip_id` (`bustrip_id`),
  ADD KEY `hotel_id` (`hotel_id`),
  ADD KEY `tour_id` (`tour_id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`room_id`),
  ADD KEY `roomtype_id` (`roomtype_id`),
  ADD KEY `hotel_id` (`hotel_id`);

--
-- Indexes for table `roomtypes`
--
ALTER TABLE `roomtypes`
  ADD PRIMARY KEY (`roomtype_id`);

--
-- Indexes for table `schedules`
--
ALTER TABLE `schedules`
  ADD PRIMARY KEY (`schedule_id`),
  ADD KEY `tour_id` (`tour_id`);

--
-- Indexes for table `seats`
--
ALTER TABLE `seats`
  ADD PRIMARY KEY (`seat_id`),
  ADD KEY `airplane_id` (`airplane_id`),
  ADD KEY `bus_id` (`bus_id`),
  ADD KEY `train_id` (`train_id`);

--
-- Indexes for table `stations`
--
ALTER TABLE `stations`
  ADD PRIMARY KEY (`station_id`);

--
-- Indexes for table `tours`
--
ALTER TABLE `tours`
  ADD PRIMARY KEY (`tour_id`);

--
-- Indexes for table `trains`
--
ALTER TABLE `trains`
  ADD PRIMARY KEY (`train_id`);

--
-- Indexes for table `traintrips`
--
ALTER TABLE `traintrips`
  ADD PRIMARY KEY (`traintrip_id`),
  ADD KEY `train_id` (`train_id`),
  ADD KEY `departure_station` (`departure_station`),
  ADD KEY `destination_station` (`destination_station`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `airlines`
--
ALTER TABLE `airlines`
  MODIFY `airline_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `airplanes`
--
ALTER TABLE `airplanes`
  MODIFY `airplane_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `airports`
--
ALTER TABLE `airports`
  MODIFY `airport_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `buscompanies`
--
ALTER TABLE `buscompanies`
  MODIFY `buscompany_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `buses`
--
ALTER TABLE `buses`
  MODIFY `bus_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `busstations`
--
ALTER TABLE `busstations`
  MODIFY `busstation_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bustrips`
--
ALTER TABLE `bustrips`
  MODIFY `bustrip_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `flights`
--
ALTER TABLE `flights`
  MODIFY `flight_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hotels`
--
ALTER TABLE `hotels`
  MODIFY `hotel_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `imagelist`
--
ALTER TABLE `imagelist`
  MODIFY `image_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `room_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roomtypes`
--
ALTER TABLE `roomtypes`
  MODIFY `roomtype_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `schedules`
--
ALTER TABLE `schedules`
  MODIFY `schedule_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `seats`
--
ALTER TABLE `seats`
  MODIFY `seat_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `stations`
--
ALTER TABLE `stations`
  MODIFY `station_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tours`
--
ALTER TABLE `tours`
  MODIFY `tour_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `trains`
--
ALTER TABLE `trains`
  MODIFY `train_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `traintrips`
--
ALTER TABLE `traintrips`
  MODIFY `traintrip_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `airplanes`
--
ALTER TABLE `airplanes`
  ADD CONSTRAINT `airplanes_ibfk_1` FOREIGN KEY (`airline_id`) REFERENCES `airlines` (`airline_id`);

--
-- Constraints for table `buses`
--
ALTER TABLE `buses`
  ADD CONSTRAINT `buses_ibfk_1` FOREIGN KEY (`buscompany_id`) REFERENCES `buscompanies` (`buscompany_id`);

--
-- Constraints for table `bustrips`
--
ALTER TABLE `bustrips`
  ADD CONSTRAINT `bustrips_ibfk_1` FOREIGN KEY (`bus_id`) REFERENCES `buses` (`bus_id`),
  ADD CONSTRAINT `bustrips_ibfk_2` FOREIGN KEY (`departure_busstation`) REFERENCES `busstations` (`busstation_id`),
  ADD CONSTRAINT `bustrips_ibfk_3` FOREIGN KEY (`destination_busstation`) REFERENCES `busstations` (`busstation_id`);

--
-- Constraints for table `flights`
--
ALTER TABLE `flights`
  ADD CONSTRAINT `flights_ibfk_1` FOREIGN KEY (`airplane_id`) REFERENCES `airplanes` (`airplane_id`),
  ADD CONSTRAINT `flights_ibfk_2` FOREIGN KEY (`departure_airport`) REFERENCES `airports` (`airport_id`),
  ADD CONSTRAINT `flights_ibfk_3` FOREIGN KEY (`destination_airport`) REFERENCES `airports` (`airport_id`);

--
-- Constraints for table `imagelist`
--
ALTER TABLE `imagelist`
  ADD CONSTRAINT `imagelist_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`),
  ADD CONSTRAINT `imagelist_ibfk_2` FOREIGN KEY (`tour_id`) REFERENCES `tours` (`tour_id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`flight_id`),
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`traintrip_id`) REFERENCES `traintrips` (`traintrip_id`),
  ADD CONSTRAINT `orders_ibfk_4` FOREIGN KEY (`bustrip_id`) REFERENCES `bustrips` (`bustrip_id`),
  ADD CONSTRAINT `orders_ibfk_5` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`hotel_id`),
  ADD CONSTRAINT `orders_ibfk_6` FOREIGN KEY (`tour_id`) REFERENCES `tours` (`tour_id`);

--
-- Constraints for table `rooms`
--
ALTER TABLE `rooms`
  ADD CONSTRAINT `rooms_ibfk_1` FOREIGN KEY (`roomtype_id`) REFERENCES `roomtypes` (`roomtype_id`),
  ADD CONSTRAINT `rooms_ibfk_2` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`hotel_id`);

--
-- Constraints for table `schedules`
--
ALTER TABLE `schedules`
  ADD CONSTRAINT `schedules_ibfk_1` FOREIGN KEY (`tour_id`) REFERENCES `tours` (`tour_id`);

--
-- Constraints for table `seats`
--
ALTER TABLE `seats`
  ADD CONSTRAINT `seats_ibfk_1` FOREIGN KEY (`airplane_id`) REFERENCES `airplanes` (`airplane_id`),
  ADD CONSTRAINT `seats_ibfk_2` FOREIGN KEY (`bus_id`) REFERENCES `buses` (`bus_id`),
  ADD CONSTRAINT `seats_ibfk_3` FOREIGN KEY (`train_id`) REFERENCES `trains` (`train_id`);

--
-- Constraints for table `traintrips`
--
ALTER TABLE `traintrips`
  ADD CONSTRAINT `traintrips_ibfk_1` FOREIGN KEY (`train_id`) REFERENCES `trains` (`train_id`),
  ADD CONSTRAINT `traintrips_ibfk_2` FOREIGN KEY (`departure_station`) REFERENCES `stations` (`station_id`),
  ADD CONSTRAINT `traintrips_ibfk_3` FOREIGN KEY (`destination_station`) REFERENCES `stations` (`station_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
