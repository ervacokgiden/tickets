-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2024 at 04:32 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tickets`
--

-- --------------------------------------------------------

--
-- Table structure for table `matches`
--

CREATE TABLE `matches` (
  `match_id` int(100) NOT NULL,
  `match_name` varchar(50) DEFAULT NULL,
  `match_date` datetime DEFAULT NULL,
  `home_team` varchar(50) DEFAULT NULL,
  `away_team` varchar(50) DEFAULT NULL,
  `stadium` varchar(100) DEFAULT NULL,
  `ticket_packages` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `matches`
--

INSERT INTO `matches` (`match_id`, `match_name`, `match_date`, `home_team`, `away_team`, `stadium`, `ticket_packages`) VALUES
(1, 'Luton Town-Everton', '2024-05-03 22:00:00', 'Luton Town', 'Everton', 'Kenilwoeth Road', 'yes'),
(2, 'Arsenal-Bournemouth', '2024-05-04 14:30:00', 'Arsenal', 'Bournemouth', 'Emirates Stadium', 'yes'),
(3, 'Brentford-Fulham', '2024-05-04 17:00:00', 'Brentford', 'Fulham', 'Gtech Community Stadium', 'yes'),
(4, 'Burnley-Newcastle United', '2024-05-04 17:00:00', 'Burnley', 'Newcastle United', 'Turf Moor', 'no'),
(5, 'Sheffield United-Nottingham Forrest', '2024-05-04 17:00:00', 'Sheffield United', 'Nottingham Forrest', 'Bramall Lane', 'no'),
(6, 'Manchester City-Wolverhampton', '2024-05-04 19:30:00', 'Manchester City', 'Wolverhampton', 'Ethiad Stadium', 'yes'),
(7, 'Brighton-Aston Villa', '2024-05-05 16:00:00', 'Brighton', 'Aston Villa', 'American Express Stadium', 'no'),
(8, 'Chelsea-West Ham United', '2024-05-05 16:00:00', 'Chelsea', 'West Ham United', 'Stamford Bridge', 'yes'),
(9, 'Liverpool-Tottenham', '2024-05-05 18:30:00', 'Liverpool', 'Tottenham', 'Anfield', 'yes'),
(10, 'Crystal Palace-Manchester United', '2024-05-06 22:00:00', 'Crystal Palace', 'Manchester United', 'Selhurst Park', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `reservationss`
--

CREATE TABLE `reservationss` (
  `reservationId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `matchId` int(11) NOT NULL,
  `ticketPackage` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `totalPrice` int(11) NOT NULL,
  `reservationDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservationss`
--

INSERT INTO `reservationss` (`reservationId`, `userId`, `matchId`, `ticketPackage`, `quantity`, `totalPrice`, `reservationDate`, `Status`) VALUES
(1, 1, 1, 'yes', 3, 300, '2024-05-04 21:00:00', 'online'),
(2, 5, 8, 'yes', 1, 1500, '2024-05-01 12:20:00', 'online'),
(3, 7, 6, 'yes', 1, 1500, '2024-05-03 14:28:16', 'online'),
(4, 8, 2, 'yes', 2, 3000, '2024-05-03 14:28:38', 'online'),
(5, 6, 7, 'no', 2, 200, '2024-05-03 14:28:54', 'online'),
(6, 10, 10, 'no', 2, 3000, '2024-05-01 14:29:12', 'online'),
(7, 2, 3, 'no', 3, 6000, '2024-05-01 14:29:27', 'online'),
(8, 3, 4, 'no', 5, 10000, '2024-05-01 14:29:45', 'online'),
(9, 4, 5, 'yes', 1, 100, '2024-05-01 14:30:02', 'online'),
(10, 9, 9, 'yes', 2, 300, '2024-05-01 14:30:20', 'online');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(100) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `full_name`, `email`, `phone`, `address`, `created_at`, `updated_at`) VALUES
(1, 'willie', 'Will123', 'Will Smith', 'willsmith@gmail.com', '236547891', 'Street:  71 Broomfield Place\r\nCity/Area:  Stourton\r\nPhone number:  079 8426 6410\r\nZip code:  DY7 3JE\r\nCountry calling code:  +44\r\nState: England,\r\nCountry:  United Kingdom', '2024-05-04 14:54:24', '2024-05-04 14:55:24'),
(2, 'collleee', 'C12e2', 'Cole Black', 'coleblack@gmail.com', '079 4462 1551', 'Street:  6 Horsefair Green\r\nCity/Area:  Old Portlethen\r\nZip code:  AB1 7ZQ\r\nCountry calling code:  +44\r\nState: Scotland,\r\nCountry:  United Kingdom', '2024-05-03 14:51:44', '2024-05-03 14:58:44'),
(3, 'jackss', 'jjj111', 'Jack Melbourne', 'jackmelbourne@outlook.com', '078 8885 3855', 'Street:  75 Asfordby Rd\r\nCity/Area:  Aldford\r\nZip code:  CH3 7QG\r\nCountry calling code:  +44\r\nState: England,\r\nCountry:  United Kingdom', '2024-05-01 15:01:24', '2024-05-02 15:01:24'),
(4, 'bekiryvz', '123bekir', 'Bekir Yavuz', 'bekiryavuz@hotmail.com', '079 8722 6044', 'Street:  52 North Promenade\r\nCity/Area:  Donisthorpe\r\nZip code:  DE12 8YR\r\nCountry calling code:  +44\r\nState: England,\r\nCountry:  United Kingdom', '2024-05-02 15:03:03', '2024-05-03 15:03:03'),
(5, 'ervackgdn', 'erva18', 'Erva Çokgiden', 'ervacokgidenn@gmail.com', '077 8184 6531', 'Street:  11 Manor Way\r\nCity/Area:  Great Parndon\r\nZip code:  CM19 3ZQ\r\nCountry calling code:  +44\r\nState: England,\r\nCountry:  United Kingdom', '2024-05-01 15:04:18', '2024-05-02 15:04:18'),
(6, 'crnblt', 'cerenn11', 'Ceren Bulut', 'cerenbulut@gmail.com', '070 0907 1790', 'Street:  57 Newmarket Road\r\nCity/Area:  Headley Down\r\nZip code:  GU35 8FL\r\nCountry calling code:  +44\r\nState: England,\r\nCountry:  United Kingdom', '2024-05-01 15:05:50', '2024-05-02 11:05:50'),
(7, 'hsnckgdn', 'hasan1903', 'Hasan Çokgiden', 'hasannckgdn@outlook.com', '070 1740 7242', 'Street:  45 Holburn Lane\r\nCity/Area:  Helmsley Sproxton\r\nZip code:  YO62 3YU\r\nCountry calling code:  +44\r\nState: England,\r\nCountry:  United Kingdom', '2024-05-02 11:17:51', '2024-05-02 15:17:51'),
(8, 'emreerenn', 'emreee11111', 'Emre Eren Arpa', 'emrearpaaa@gmail.com', '077 7866 9873', 'Street:  37 Emerson Road\r\nCity/Area:  Kinrara\r\nZip code:  PH22 7GF\r\nCountry calling code:  +44\r\nState: Scotland,\r\nCountry:  United Kingdom', '2024-05-01 10:18:55', '2024-05-01 15:18:55'),
(9, 'ava28', 'avaaaa111', 'Ava Clark', 'avaclarkk@gmail.com', '078 4898 5231', 'Street:  2 West Lane\r\nCity/Area:  Danby Wiske\r\nZip code:  DL7 0BQ\r\nCountry calling code:  +44\r\nState: England,\r\nCountry:  United Kingdom', '2024-05-02 15:19:52', '2024-05-03 15:19:52'),
(10, 'nickie', 'Nickkk22', 'Nick Jason', 'nickjason@outlook.com', '070 8041 0631', 'Street:  80 Overton Circle\r\nCity/Area:  Little Stukeley\r\nZip code:  PE17 9GU\r\nCountry calling code:  +44\r\nState: England,\r\nCountry:  United Kingdom', '2024-05-04 15:20:55', '2024-05-05 15:20:55');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `matches`
--
ALTER TABLE `matches`
  ADD PRIMARY KEY (`match_id`);

--
-- Indexes for table `reservationss`
--
ALTER TABLE `reservationss`
  ADD PRIMARY KEY (`reservationId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `matches`
--
ALTER TABLE `matches`
  MODIFY `match_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `reservationss`
--
ALTER TABLE `reservationss`
  MODIFY `reservationId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
