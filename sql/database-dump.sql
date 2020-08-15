-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 14, 2020 at 10:47 PM
-- Server version: 10.3.15-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cr7_aleksovski`
--

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`class_id`, `class_name`) VALUES
(1, '1A'),
(2, '1B'),
(3, '1C'),
(4, '1D'),
(5, '2A'),
(6, '2B'),
(7, '2C'),
(8, '3A'),
(9, '3B'),
(10, '3C');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `student_id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL,
  `email` varchar(55) DEFAULT NULL,
  `fk_class_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`student_id`, `name`, `surname`, `email`, `fk_class_id`) VALUES
(1, 'Aidan', 'Collings', 'AidanCollings@rhyta.com', 1),
(32, 'Magnus', 'Skaug', 'MagnusSkaug@rhyta.com', 1),
(33, 'Patrick', 'Aas', 'PatrickAas@armyspy.com', 3),
(34, 'Vincent', 'Karstensen', 'VincentKarstensen@teleworm.us', 4),
(35, 'Herman', 'Høiby', 'HermanHoiby@dayrep.com', 6),
(36, 'Nikolai', ' Oftedal', 'NikolaiOftedal@jourrapide.com', 5),
(37, 'Tina', 'Brænd', 'TinaBraend@jourrapide.com', 4),
(38, 'Amelia', 'Lund', 'AmeliaLund@teleworm.us', 7),
(39, 'Sebastian', 'Pedersen', 'SebastianPedersen@rhyta.com', 8),
(40, 'Marius', 'Andersen', 'MariusAndersen@rhyta.com', 1),
(41, 'Amalie', 'Knutsen', 'AmalieKnutsen@teleworm.us', 2),
(42, 'Ludvig', 'Aase', 'LudvigAase@dayrep.com', 3),
(43, 'Hanna', 'Roksvag', 'HannaRoksvag@armyspy.com', 4),
(44, 'Sigrid', 'Svendsen', 'SigridSvendsen@teleworm.us', 5),
(45, 'Amalie', 'Nordal', 'AmalieNordal@armyspy.com', 6),
(46, 'Victor', 'Holland', 'VictorHolland@jourrapide.com', 7),
(47, 'Kristian', 'Bakken', 'KristianBakken@teleworm.us', 7),
(48, 'William', 'Jordal', 'WilliamJordal@armyspy.com', 8),
(49, 'Daniel', 'Bjorlo', ' DanielBjorlo@rhyta.com', 8),
(50, 'Elisabeth', 'Solheim', 'ElisabethSolheim@dayrep.com', 9),
(51, 'Fatima', 'Espenes', 'FatimaEspenes@rhyta.com', 10),
(52, 'Alvilde', 'Heldal', 'AlvildeHeldal@armyspy.com', 1),
(53, 'Mikael', 'Horpestad', 'MikaelHorpestad@armyspy.com', 2),
(54, 'Kornelia', 'Rohde', ' KorneliaRohde@teleworm.us', 3),
(55, 'Eline', 'Mortensen', 'ElineMortensen@teleworm.us', 4),
(56, 'Henrik', 'Solbakken', 'HenrikSolbakken@jourrapide.com', 5),
(57, 'Sander', 'Nikolaisen', 'SanderNikolaisen@jourrapide.com', 5),
(58, 'Sofie', 'Einarsen', ' SofieEinarsen@rhyta.com', 6),
(59, 'Karine', 'Birkeland', ' KarineBirkeland@armyspy.com', 7),
(60, 'Charlotte', 'Heltne', ' CharlotteHeltne@dayrep.com', 8),
(61, 'Sofia', 'Bjelland', 'SofiaBjelland@armyspy.com', 8),
(62, 'Gabriel', 'Malmin', 'GabrielMalmin@rhyta.com', 9),
(63, 'Arin', 'Gaustad', 'ArinGaustad@jourrapide.com', 9),
(64, 'Jakob', 'Karlsen', 'JakobKarlsen@armyspy.com', 10),
(65, 'Agnes', 'Olsen', 'AgnesOlsen@dayrep.com', 1),
(66, 'Ida', 'Steen', 'IdaSteen@armyspy.com', 2),
(67, 'Gustav', 'Jahr', 'GustavJahr@dayrep.com', 3),
(68, 'Gaute', 'Johansen', 'GauteJohansen@rhyta.com', 4),
(69, 'Oscar', 'Opsahl', 'OscarOpsahl@armyspy.com', 5),
(70, 'Martine', 'Berg', 'MartineBerg@teleworm.us', 6),
(71, 'Sophia', 'Weberg', 'SophiaWeberg@armyspy.com', 7),
(72, 'Hannah', 'Larssen', 'HannahLarssen@teleworm.us', 8),
(73, 'Markus', 'Rasmussen', 'MarkusRasmussen@dayrep.com', 9),
(74, 'Elias', 'Skjerve', 'EliasSkjerve@dayrep.com', 10);

-- --------------------------------------------------------

--
-- Table structure for table `teach`
--

CREATE TABLE `teach` (
  `fk_teacher_id` int(11) DEFAULT NULL,
  `fk_class_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teach`
--

INSERT INTO `teach` (`fk_teacher_id`, `fk_class_id`) VALUES
(6, 1),
(6, 2),
(6, 5),
(6, 7),
(6, 8),
(5, 2),
(5, 5),
(5, 9),
(5, 10),
(1, 1),
(1, 3),
(1, 4),
(1, 7),
(4, 7),
(4, 8),
(4, 9),
(4, 10),
(2, 1),
(2, 3),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(3, 7),
(3, 8);

-- --------------------------------------------------------

--
-- Table structure for table `teachers`
--

CREATE TABLE `teachers` (
  `teacher_id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `email` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teachers`
--

INSERT INTO `teachers` (`teacher_id`, `name`, `surname`, `email`) VALUES
(1, 'Erik', 'Ray', ' ErikHRay@teleworm.us'),
(2, 'Joshua', 'Danglow', 'JoshuaDanglow@dayrep.com'),
(3, 'Lachlan', 'Kermadec', 'LachlanHuonDeKermadec@teleworm.us'),
(4, 'Joel', 'Collings', 'JoelCollings@rhyta.com'),
(5, 'Dean', 'Nickel', 'DeanNickel@jourrapide.com'),
(6, 'Alexandra', 'Lawton', 'AlexandraLawton@armyspy.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`class_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `fk_class_id` (`fk_class_id`);

--
-- Indexes for table `teach`
--
ALTER TABLE `teach`
  ADD KEY `fk_teacher_id` (`fk_teacher_id`),
  ADD KEY `fk_class_id` (`fk_class_id`);

--
-- Indexes for table `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`teacher_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `classes`
--
ALTER TABLE `classes`
  MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT for table `teachers`
--
ALTER TABLE `teachers`
  MODIFY `teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`fk_class_id`) REFERENCES `classes` (`class_id`);

--
-- Constraints for table `teach`
--
ALTER TABLE `teach`
  ADD CONSTRAINT `teach_ibfk_1` FOREIGN KEY (`fk_teacher_id`) REFERENCES `teachers` (`teacher_id`),
  ADD CONSTRAINT `teach_ibfk_2` FOREIGN KEY (`fk_class_id`) REFERENCES `classes` (`class_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
