-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2021 at 02:22 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `football`
--

-- --------------------------------------------------------

--
-- Table structure for table `coaches`
--

CREATE TABLE `coaches` (
  `ID` int(20) NOT NULL,
  `Name` varchar(225) NOT NULL,
  `Designation` varchar(225) NOT NULL,
  `Address` varchar(225) NOT NULL,
  `ContactNo` int(10) NOT NULL,
  `Email` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coaches`
--

INSERT INTO `coaches` (`ID`, `Name`, `Designation`, `Address`, `ContactNo`, `Email`) VALUES
(2, 'joey', 'Head coach', 'No 3,Autumn Street, Colombo', 115694564, 'joey@gmail.com'),
(6, 'Chandler Bing', 'Assistant Coach', 'Main Street, Colombo', 365526598, 'chandler@gmail.com'),
(1, 'Joey Bing', 'Head Coach', '280 Foster Street\r\nChelsea, MA 02150', 112365498, 'joey@gmail.com'),
(5, 'Pheobe buffey', 'Coach', '133 Woodland Ave.\r\nWyoming, MI 49509', 445698236, 'pheobe2gmail.com'),
(8, 'Rachel Green', 'Assistant coach', '8876 Coffee Road\r\nOld Bridge, NJ 08857.', 115632569, 'Rachel@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `injury`
--

CREATE TABLE `injury` (
  `Player Number` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Injury Type` text NOT NULL,
  `Recovery Time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `injury`
--

INSERT INTO `injury` (`Player Number`, `Name`, `Injury Type`, `Recovery Time`) VALUES
(11, 'Ousmane Dembele', 'Sprained Ankle', '01 month'),
(17, 'Gavi', 'Groin Injury', '02 motnhs'),
(23, 'Sergi Roberto', 'Knee Injury', '04 months');

-- --------------------------------------------------------

--
-- Table structure for table `matches`
--

CREATE TABLE `matches` (
  `match_num` int(11) NOT NULL,
  `date` text NOT NULL,
  `team_1` text NOT NULL,
  `result_team_1` text NOT NULL,
  `goals_team_1` int(11) NOT NULL,
  `team_2` text NOT NULL,
  `result_team_2` text NOT NULL,
  `goals_team_2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `matches`
--

INSERT INTO `matches` (`match_num`, `date`, `team_1`, `result_team_1`, `goals_team_1`, `team_2`, `result_team_2`, `goals_team_2`) VALUES
(1, 'Fri Oct 15 02:31:49 IST 2021', 'Fighting Crusaders', 'Won', 6, 'Razorbacks', 'Lost', 3),
(2, 'Sat Oct 16 02:31:49 IST 2021', 'Razorbacks', 'Draw ', 0, 'Fighting Crusaders', 'Draw ', 0),
(2, 'Sun Oct 17 02:31:49 IST 2021', 'Fighting Crusaders', 'Won', 2, 'Avengers', 'Lost', 0),
(7, 'Tue Oct 19 02:31:49 IST 2021', 'Continentals', 'Won', 5, 'Rebels', 'Lost', 0),
(5, 'Fri Oct 22 02:31:49 IST 2021', 'Commodores', 'Lost', 2, 'Avengers', 'Won', 3);

-- --------------------------------------------------------

--
-- Table structure for table `medical`
--

CREATE TABLE `medical` (
  `ID` int(20) NOT NULL,
  `Name` varchar(225) NOT NULL,
  `Designation` varchar(225) NOT NULL,
  `Address` varchar(225) NOT NULL,
  `ContactNo` int(10) NOT NULL,
  `Email` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medical`
--

INSERT INTO `medical` (`ID`, `Name`, `Designation`, `Address`, `ContactNo`, `Email`) VALUES
(7, 'Haiden clark', 'Doctor', 'Po Box 380671\r\nClinton Township, Michigan(MI), 48038', 225689789, 'haiden@gmail.com'),
(21, 'Chandler Bing', 'Assistant Doctor', '3346 Knolls Pky\r\nIjamsville, Maryland(MD), 21754', 114564589, 'chandler@gmail.com'),
(31, 'Ross clark', 'Nurse', '860 S Biron Dr\r\nWisconsin Rapids, Wisconsin(WI), 54494.', 789635651, 'Ross@gmail'),
(41, 'Mike fallon', 'Doctor', '8208 Appennies St #APT B\r\nFort Irwin, California(CA), 92310.', 213654895, 'Mike@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `otherstaff`
--

CREATE TABLE `otherstaff` (
  `ID` int(20) NOT NULL,
  `Name` varchar(225) NOT NULL,
  `Designation` varchar(225) NOT NULL,
  `Address` varchar(225) NOT NULL,
  `ContactNo` int(10) NOT NULL,
  `Email` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `otherstaff`
--

INSERT INTO `otherstaff` (`ID`, `Name`, `Designation`, `Address`, `ContactNo`, `Email`) VALUES
(9, 'Jimminy clark', ' General Manager', '5231 Marlboro Pike #APT 203\r\nCapitol Heights, Maryland(MD), 20743.', 112569865, 'Jimmimy@gmail.com'),
(56, 'Monica Galler', 'Assistant Manager', '23726 50th Hwy W\r\nMaben, Mississippi(MS), 39750', 225698654, 'Monica@gmail.com'),
(65, 'coner doil', 'Team Manager', '1200 N Country Club Rd\r\nEl Reno, Oklahoma(OK),', 563214789, 'Renold@gmail.com'),
(82, 'Ryan Reynolds', 'Assistant Manager', 'Po Box 7404\r\nTahoe City, California(CA), ', 543269871, 'REynolds@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `player details`
--

CREATE TABLE `player details` (
  `Jersey Number` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Age` int(11) NOT NULL,
  `Preffered Foot` text NOT NULL,
  `Height` double NOT NULL,
  `Weight` double NOT NULL,
  `Salary` int(11) NOT NULL,
  `Contracted Till` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `player details`
--

INSERT INTO `player details` (`Jersey Number`, `Name`, `Age`, `Preffered Foot`, `Height`, `Weight`, `Salary`, `Contracted Till`) VALUES
(10, 'Lionel Messi', 34, 'Left', 168, 72, 400000, 2023),
(11, 'Dembz', 25, 'Both', 179, 69, 230000, 2026),
(9, 'Depay', 28, 'Right', 176, 84, 200000, 2025),
(7, 'Coutinho', 28, 'Right', 172, 73, 200000, 2023),
(1, 'Stegen', 26, 'Right', 171, 76, 220000, 2026);

-- --------------------------------------------------------

--
-- Table structure for table `player ratings`
--

CREATE TABLE `player ratings` (
  `Ranking` int(11) NOT NULL,
  `Player Number` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Matches Played` int(11) NOT NULL,
  `Goals` int(11) NOT NULL,
  `Assists` int(11) NOT NULL,
  `Clean Sheets` int(11) NOT NULL,
  `Ratings` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `player ratings`
--

INSERT INTO `player ratings` (`Ranking`, `Player Number`, `Name`, `Matches Played`, `Goals`, `Assists`, `Clean Sheets`, `Ratings`) VALUES
(1, 10, 'Lionel Messi', 5, 4, 1, 1, 9.1),
(2, 9, 'Depay', 5, 3, 0, 1, 8.9),
(3, 7, 'Coutinho', 4, 2, 1, 1, 8.6);

-- --------------------------------------------------------

--
-- Table structure for table `schedules`
--

CREATE TABLE `schedules` (
  `Match Number` int(11) NOT NULL,
  `Date` text NOT NULL,
  `Team 1` text NOT NULL,
  `Team 2` text NOT NULL,
  `Time` varchar(25) NOT NULL,
  `Venue` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `schedules`
--

INSERT INTO `schedules` (`Match Number`, `Date`, `Team 1`, `Team 2`, `Time`, `Venue`) VALUES
(7, 'Fri Oct 15 02:29:31 IST 2021', 'Razorbacks', 'The Predators', '3.00 p.m. onwards', 'Oakwell Stadium'),
(6, 'Fri Oct 22 02:29:31 IST 2021', 'Avengers', 'The Predators', '3.00 p.m. onwards', 'Oakwell Stadium'),
(6, 'Sun Oct 24 02:29:31 IST 2021', 'Razorbacks', 'Avengers', '9.00 a.m. onwards', 'Old Trafford'),
(8, 'Fri Oct 29 02:29:31 IST 2021', 'Razorbacks', 'Bonnies', '9.00 a.m. onwards', 'Old Trafford'),
(8, 'Fri Oct 29 02:29:31 IST 2021', 'Comets', 'Commodores', '9.00 a.m. onwards', 'Oakwell Stadium');

-- --------------------------------------------------------

--
-- Table structure for table `squad`
--

CREATE TABLE `squad` (
  `Position` int(3) NOT NULL,
  `Player` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `squad`
--

INSERT INTO `squad` (`Position`, `Player`) VALUES
(1, 'Ter Stegen'),
(2, 'Dest'),
(3, 'Pique'),
(4, 'R.Araujo'),
(5, 'Sergio'),
(6, 'Riqui Puig'),
(7, 'Memphis'),
(8, 'Ansu Fati'),
(10, 'Neto'),
(11, 'Coutinho'),
(12, 'Lenglet'),
(13, 'L. de John'),
(14, 'Jordi Alba'),
(15, 'S.Roberto'),
(16, 'F. de Jong'),
(17, 'O.Mingueza'),
(18, 'Umtiti'),
(19, 'Eric'),
(20, 'Nico'),
(21, 'Gavi'),
(22, 'Inaki Pena'),
(23, 'O.Dembele'),
(27, 'Brathwaite');

-- --------------------------------------------------------

--
-- Table structure for table `suspended`
--

CREATE TABLE `suspended` (
  `Player Number` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Yellow Cards` int(11) NOT NULL,
  `Red Cards` int(11) NOT NULL,
  `Suspended Matches` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `suspended`
--

INSERT INTO `suspended` (`Player Number`, `Name`, `Yellow Cards`, `Red Cards`, `Suspended Matches`) VALUES
(4, 'Pique', 5, 0, 1),
(3, 'Araujo', 1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

CREATE TABLE `teams` (
  `Team ID` int(30) NOT NULL,
  `Name` text NOT NULL,
  `Matches` varchar(30) NOT NULL,
  `Goals` int(11) NOT NULL,
  `Wins` varchar(30) NOT NULL,
  `Losts` varchar(30) NOT NULL,
  `Draws` varchar(30) NOT NULL,
  `Points` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teams`
--

INSERT INTO `teams` (`Team ID`, `Name`, `Matches`, `Goals`, `Wins`, `Losts`, `Draws`, `Points`) VALUES
(6, 'The predators', '8', 6, '4', '2', '1', 4),
(5, 'Comets', '8', 6, '6', '1', '1', 5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
