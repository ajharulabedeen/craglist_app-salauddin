-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2018 at 01:49 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `salauddin`
--

-- --------------------------------------------------------

--
-- Table structure for table `advertisement`
--

CREATE TABLE `advertisement` (
  `id` bigint(20) NOT NULL,
  `catagory` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `program` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `advertisement`
--

INSERT INTO `advertisement` (`id`, `catagory`, `city`, `date`, `phone`, `program`, `state`, `url`, `zipcode`) VALUES
(28, 'event/class', 'Bakersfield', '12/01/2018 18:30 PM', '(661) 490-9311', 'Dental Assisting', 'CA', '', '93301'),
(29, 'writing', 'Bakersfield', '12/01/2018 18:34 PM', '(661) 490-9311', 'Dental Assisting', 'CA', '', '93301'),
(52, 'event/class', 'daytona beach', '12/01/2018 18:31 PM', '(386) 267-6842', 'Medical Coding', 'FL', '', '32114'),
(53, 'writing', 'daytona beach', '12/01/2018 18:33 PM', '(386) 267-6842', 'Medical Coding', 'FL', '', '32114');

-- --------------------------------------------------------

--
-- Table structure for table `advertisement_advertisement_details`
--

CREATE TABLE `advertisement_advertisement_details` (
  `Advertisement_id` bigint(20) NOT NULL,
  `advertisement_Detailses_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `advertisement_details`
--

CREATE TABLE `advertisement_details` (
  `id` bigint(20) NOT NULL,
  `body_id` bigint(20) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `title_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `body`
--

CREATE TABLE `body` (
  `id` bigint(20) NOT NULL,
  `body_catagory` varchar(255) DEFAULT NULL,
  `body_description` longtext,
  `date` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `body`
--

INSERT INTO `body` (`id`, `body_catagory`, `body_description`, `date`) VALUES
(1, 'event/class', 'Which career field shows the most job stability? How much money do you want to make?\n\nDon''t wait, call our admissions staff right now\n\n(661) 490-9311', '12/01/2018 19:20 PM'),
(2, 'writing', 'Which career field shows the most job stability? How much money do you want to make?\n\nDon''t wait, call our admissions staff right now\n\n(661) 490-9311', '12/01/2018 19:20 PM'),
(3, 'writing', 'Which career field will give me good money and great enjoyment? How much money do you want to make?\n\nLet us help, call our support staff\n\n(661) 490-9311', '12/01/2018 19:21 PM'),
(4, 'event/class', 'Which career field will give me good money and great enjoyment? How much money do you want to make?\n\nLet us help, call our support staff\n\n(661) 490-9311', '12/01/2018 19:21 PM'),
(5, 'event/class', 'Which career field shows the most job stability? If I do need to increase my skills for the job I want, where shall I go, what shaill I do, who can guide me?\n\nCall now & speak to someone now\n\n(661) 490-9311', '12/01/2018 19:22 PM'),
(6, 'writing', 'Which career field shows the most job stability? If I do need to increase my skills for the job I want, where shall I go, what shaill I do, who can guide me?\n\nCall now & speak to someone now\n\n(661) 490-9311', '12/01/2018 19:22 PM'),
(7, 'writing', 'Which career field will allow me to work from home? Should I supplement my skills with some training?\n\nDon''t wait, call a specialist today\n\n(661) 490-9311\n', '12/01/2018 19:22 PM'),
(8, 'event/class', 'Which career field will allow me to work from home? Should I supplement my skills with some training?\n\nDon''t wait, call a specialist today\n\n(661) 490-9311\n', '12/01/2018 19:22 PM'),
(9, 'event/class', 'Which career field will allow me to work from home? Should I supplement my skills with some training?\n\nDon''t wait, call a specialist today\n\n(661) 490-9311\n', '12/01/2018 19:22 PM'),
(10, 'writing', 'Which career field will allow me to work from home? Should I supplement my skills with some training?\n\nDon''t wait, call a specialist today\n\n(661) 490-9311\n', '12/01/2018 19:22 PM'),
(11, 'writing', 'What should I look for in a training program? How much money do you want to make?\n\nCall now & speak to our support staff now\n\n(661) 490-9311', '12/01/2018 19:23 PM'),
(12, 'event/class', 'What should I look for in a training program? How much money do you want to make?\n\nCall now & speak to our support staff now\n\n(661) 490-9311', '12/01/2018 19:23 PM');

-- --------------------------------------------------------

--
-- Table structure for table `title`
--

CREATE TABLE `title` (
  `id` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `title_catagory` varchar(255) DEFAULT NULL,
  `title_description` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `title`
--

INSERT INTO `title` (`id`, `date`, `title_catagory`, `title_description`) VALUES
(1, '12/01/2018 18:38 PM', 'writing', 'Dental Assisting Classes'),
(2, '12/01/2018 18:38 PM', 'writing', 'Dental Assisting Classes - Starting Soon'),
(4, '12/01/2018 18:39 PM', 'writing', 'Dental Assisting Classes - Enrolling Now '),
(5, '12/01/2018 18:40 PM', 'writing', 'Dental Assisting Classes - Enrolling Today'),
(6, '12/01/2018 18:40 PM', 'writing', 'Dental Assisting Classes - Get Started Now'),
(7, '12/01/2018 18:40 PM', 'writing', 'Dental Assisting Classes - Take The First Step'),
(8, '12/01/2018 18:40 PM', 'event/class', 'Dental Assisting Classes - Take The First Step'),
(9, '12/01/2018 18:40 PM', 'event/class', 'Dental Assisting Classes - Get Started Now'),
(10, '12/01/2018 18:41 PM', 'event/class', 'Dental Assisting Classes - Enrolling Today'),
(11, '12/01/2018 18:41 PM', 'event/class', 'Dental Assisting Classes - Enrolling Now'),
(12, '12/01/2018 18:41 PM', 'event/class', 'Dental Assisting Classes - Starting Soon'),
(13, '12/01/2018 18:41 PM', 'event/class', 'Dental Assisting Classes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advertisement`
--
ALTER TABLE `advertisement`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `advertisement_advertisement_details`
--
ALTER TABLE `advertisement_advertisement_details`
  ADD UNIQUE KEY `UK_c5a4bmo7nxf3jo6mml71kgqal` (`advertisement_Detailses_id`),
  ADD KEY `FK_77r54ohm68nxrh4xmihxpmc6u` (`Advertisement_id`);

--
-- Indexes for table `advertisement_details`
--
ALTER TABLE `advertisement_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `body`
--
ALTER TABLE `body`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `title`
--
ALTER TABLE `title`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `body`
--
ALTER TABLE `body`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `title`
--
ALTER TABLE `title`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `advertisement_advertisement_details`
--
ALTER TABLE `advertisement_advertisement_details`
  ADD CONSTRAINT `FK_77r54ohm68nxrh4xmihxpmc6u` FOREIGN KEY (`Advertisement_id`) REFERENCES `advertisement` (`id`),
  ADD CONSTRAINT `FK_c5a4bmo7nxf3jo6mml71kgqal` FOREIGN KEY (`advertisement_Detailses_id`) REFERENCES `advertisement_details` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
