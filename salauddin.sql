-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2018 at 07:19 AM
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
(1, '1', '1', '09/01/2018 15:12 PM', '1', '1', '1', '1', '1'),
(2, '1', '1', '09/01/2018 23:53 PM', '1', '1', '1asd456', '1', '1');

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
(3, '10/01/2018 01:15 AM', '2222', '234234'),
(4, '09/01/2018 15:15 PM', '123', '123123'),
(5, '10/01/2018 01:50 AM', 'icu7', 'title_description'),
(6, '09/01/2018 21:20 PM', 'title_catagory', 'title_description'),
(7, '09/01/2018 21:28 PM', 'title_catagory', 'title_description'),
(8, '09/01/2018 21:29 PM', 'title_catagory', 'title_description'),
(9, '09/01/2018 21:36 PM', 'title_catagory', 'title_description'),
(10, '09/01/2018 22:01 PM', 'wer', 'werwr'),
(12, '09/01/2018 22:06 PM', 'title_catagory', 'title_description'),
(13, '09/01/2018 22:07 PM', 'title_catagory', 'title_description'),
(14, '09/01/2018 22:20 PM', 'title_catagory', 'title_description'),
(15, '09/01/2018 22:32 PM', 'title_catagory', 'title_description'),
(16, '09/01/2018 22:32 PM', 'title_catagory', 'title_description'),
(17, '10/01/2018 01:09 AM', 'title_catagory17++>>>>----', 'title_description'),
(18, '09/01/2018 22:43 PM', '111111', '111111111'),
(19, '09/01/2018 22:46 PM', '234', '234'),
(20, '09/01/2018 22:47 PM', '34345345', '345345345'),
(21, '09/01/2018 22:53 PM', '567', '567'),
(22, '09/01/2018 23:06 PM', 'sdf', 'sdfsdf'),
(23, '09/01/2018 23:50 PM', 'Updated', '234234'),
(24, '09/01/2018 23:50 PM', '234', 'sfsd'),
(25, '09/01/2018 23:51 PM', 'aaaaa', '234234'),
(26, '09/01/2018 23:51 PM', 'wwwww', 'sfsd'),
(27, '10/01/2018 00:51 AM', 'sdfsdf', 'sfsd'),
(28, '10/01/2018 00:52 AM', '123', 'sfsd'),
(30, '10/01/2018 00:56 AM', 'title_catagory17**', 'title_description'),
(31, '10/01/2018 00:57 AM', 'title_catagory17**', 'title_description'),
(32, '10/01/2018 01:14 AM', '11111', 'sfsd'),
(33, '10/01/2018 01:14 AM', '11111', 'sfsd'),
(34, '10/01/2018 01:14 AM', '11111', 'sfsd'),
(35, '10/01/2018 01:16 AM', '355555', 'sfsd'),
(36, '10/01/2018 01:50 AM', '234', '234');

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
-- AUTO_INCREMENT for table `title`
--
ALTER TABLE `title`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
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
