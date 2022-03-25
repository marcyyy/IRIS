-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2020 at 05:56 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `irisdbms`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `item_id` int(50) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `item_description` varchar(50) NOT NULL,
  `item_status` varchar(50) NOT NULL,
  `item_source` varchar(50) NOT NULL,
  `item_availability` varchar(50) NOT NULL,
  `item_officer` varchar(50) NOT NULL,
  `item_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`item_id`, `item_name`, `item_description`, `item_status`, `item_source`, `item_availability`, `item_officer`, `item_date`) VALUES
(5, 'TV', 'Sony Bravia 32 inches', 'Good Condition', 'Donated', 'In Stock', 'Mira Estigoy', '2020-04-25'),
(8, 'HDMI', '2 meters', 'Brand New', 'Bought', 'In Stock', 'Zyrah Avila', '2020-04-25'),
(9, 'VGA', '1 meter', 'Brand New', 'Bought', 'In Stock', 'Zyrah Avila', '2020-04-25'),
(10, 'VGA', '1 meter', 'Damaged', 'Donated', 'Unavailable', 'Raven Nicolas', '2020-04-24'),
(13, 'HDMI', '2 meters', 'Good Condition', 'Bought', 'In Stock', 'Ivan Clifford Dolotina', '2020-04-26'),
(14, 'TV', 'Samsung 40 inches', 'Good Condition', 'Donated', 'Under Rent', 'Zyrah Avila', '2020-04-24'),
(16, 'VGA', '1 meter', 'Good Condition', 'Bought', 'In Stock', 'Raven Nicolas', '2020-04-24'),
(19, 'TV', 'Sony Smart TV 43 inches', 'Good Condition', 'Bought', 'Under Rent', 'Zyrah Avila', '2020-04-24'),
(20, 'TV', 'LG TV 32 inches', 'Good Condition', 'Bought', 'In Stock', 'Zyrah Avila', '2020-04-24'),
(21, 'Extension', '5 meters', 'Good Condition', 'Bought', 'In Stock', 'Raven Nicolas', '2020-04-24'),
(22, 'Damath', 'Board Game', 'Good Condition', 'Bought', 'In Stock', 'Raven Nicolas', '2020-04-24'),
(24, 'Scrabble', 'Board Game', 'Good Condition', 'Bought', 'In Stock', 'Raven Nicolas', '2020-04-24'),
(25, 'TV', 'Hisense Smart TV 40 inch', 'Good Condition', 'Bought', 'In Stock', 'Raven Nicolas', '2020-04-24'),
(26, 'Equalizer', 'Board Game', 'Good Condition', 'Bought', 'In Stock', 'Marielle Veneracion', '2020-04-24'),
(27, 'Chess', 'Board Game', 'Good Condition', 'Bought', 'In Stock', 'Marielle Veneracion', '2020-04-24'),
(28, 'Game of the Generals', 'Board Game', 'Good Condition', 'Bought', 'In Stock', 'Marielle Veneracion', '2020-04-24'),
(31, 'TV', 'ASDA', 'Good Condition', 'Bought', 'In Stock', 'Zyrah Avila', '2020-04-25'),
(32, 'Extension', '5 meters', 'Good Condition', 'Bought', 'In Stock', 'Zyrah Avila', '2020-04-25'),
(33, 'HDMI', '2 meters', 'Good Condition', 'Bought', 'In Stock', 'Zyrah Avila', '2020-04-25'),
(34, 'Extension', '5 meters', 'Good Condition', 'Bought', 'In Stock', 'Zyrah Avila', '2020-04-25'),
(35, 'Extension', '5 meters', 'Good Condition', 'Donated', 'In Stock', 'Zyrah Avila', '2020-04-25'),
(36, 'HDMI', '2 meters', 'Good Condition', 'Donated', 'In Stock', 'Zyrah Avila', '2020-04-25'),
(38, 'VGA', '2 meters', 'Good Condition', 'Donated', 'In Stock', 'Zyrah Avila', '2020-04-25'),
(39, 'HDMI', '2 meters', 'Good Condition', 'Bought', 'In Stock', 'Zyrah Avila', '2020-04-25'),
(40, 'HDMI', '2 meters', 'Good Condition', 'Bought', 'In Stock', 'Mira Estigoy', '2020-04-25'),
(41, 'TV', 'Sony Bravia 52 inch', 'Good Condition', 'Donated', 'In Stock', 'Ivan Clifford Dolotina', '2020-04-26'),
(42, 'Speaker', 'loud', 'Good Condition', 'Bought', 'In Stock', 'Ivan Clifford Dolotina', '2020-04-26');

-- --------------------------------------------------------

--
-- Table structure for table `inventory_dump`
--

CREATE TABLE `inventory_dump` (
  `idump_id` int(50) NOT NULL,
  `item_id` int(50) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `item_description` varchar(50) NOT NULL,
  `item_status` varchar(50) NOT NULL,
  `item_source` varchar(50) NOT NULL,
  `item_availability` varchar(50) NOT NULL,
  `item_officer` varchar(50) NOT NULL,
  `item_date` date NOT NULL,
  `dump_type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory_dump`
--

INSERT INTO `inventory_dump` (`idump_id`, `item_id`, `item_name`, `item_description`, `item_status`, `item_source`, `item_availability`, `item_officer`, `item_date`, `dump_type`) VALUES
(1, 5, 'TV', 'Sony Bravia 32 inches', 'Good Condition', 'Donated', 'In Stock', 'Zyrah Avila', '2020-04-24', 'Updated'),
(2, 30, 'TV', 'sad', 'Good Condition', 'Bought', 'In Stock', '', '2020-04-25', 'Deleted'),
(6, 8, 'HDMI', '2 meters', 'Brand New', 'Bought', 'In Stock', 'Zyrah Avila', '2020-04-24', 'Updated'),
(9, 9, 'VGA', '1 meter', 'Brand New', 'Bought', 'In Stock', 'Raven Nicolas', '2020-04-24', 'Updated'),
(10, 29, 'HDMI', '2 meters', 'Good Condition', 'Bought', 'In Stock', '', '2020-04-24', 'Deleted'),
(15, 5, 'TV', 'Sony Bravia 32 inches', 'Good Condition', 'Bought', 'In Stock', 'Zyrah Avila', '2020-04-25', 'Updated'),
(16, 5, 'TV', 'Sony Bravia 32 inches', 'Good Condition', 'Bought', 'In Stock', '', '2020-04-25', 'Updated'),
(17, 37, 'TV', 'Samsung Smart TV 40 inch', 'Under Repair', 'Bought', 'Unavailable', 'Zyrah Avila', '2020-04-25', 'Updated'),
(18, 31, 'TV', 'ASDA', 'Good Condition', 'Bought', 'In Stock', '', '2020-04-25', 'Updated'),
(19, 5, 'TV', 'Sony Bravia 32 inches', 'Good Condition', 'Bought', 'Under Rent', 'Zyrah Avila', '2020-04-25', 'Updated'),
(20, 13, 'HDMI', '2 meters', 'Damaged', 'Bought', 'Unavailable', 'Zyrah Avila', '2020-04-24', 'Updated'),
(21, 37, 'TV', 'Samsung Smart TV 40 inch', 'Under Repair', 'Donated', 'Unavailable', 'Zyrah Avila', '2020-04-25', 'Deleted');

-- --------------------------------------------------------

--
-- Table structure for table `inventory_item`
--

CREATE TABLE `inventory_item` (
  `id` int(50) NOT NULL,
  `item_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory_item`
--

INSERT INTO `inventory_item` (`id`, `item_name`) VALUES
(2, 'HDMI'),
(3, 'Extension'),
(4, 'VGA'),
(5, 'Damath'),
(6, 'Equalizer'),
(7, 'Chess'),
(8, 'Scrabble'),
(9, 'Game of the Generals'),
(10, 'Projector'),
(11, 'Speaker');

-- --------------------------------------------------------

--
-- Table structure for table `login_admin`
--

CREATE TABLE `login_admin` (
  `acc_id` int(11) NOT NULL,
  `acc_name` varchar(30) NOT NULL,
  `yearsection` varchar(20) NOT NULL,
  `schoolyear` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `authority` varchar(30) NOT NULL,
  `reg_admin` varchar(30) NOT NULL,
  `reg_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login_admin`
--

INSERT INTO `login_admin` (`acc_id`, `acc_name`, `yearsection`, `schoolyear`, `password`, `authority`, `reg_admin`, `reg_date`) VALUES
(1, 'Zyrah Avila', 'BSIT2-1N', '2019-2020', '123', 'Admin', 'Raven', '2020-04-24'),
(2, 'Raven Nicolas', 'BSIT2-1N', '2019-2020', '123', 'Officer', 'Raven', '2020-04-24'),
(3, 'Arkin Ocampo', 'BSIT2-3', '2019-2020', '123', 'Officer', 'Raven', '2020-04-24'),
(5, 'Jesus Lopez', 'BSIT2-1N', '2020-2021', '123', 'Officer', 'Raven', '2020-04-24'),
(6, 'Marielle Veneracion', 'BSIT2-1N', '2020-2021', '123', 'Officer', 'Raven', '2020-04-24'),
(12, 'Hann Geronimo', 'BSIT2-1N', '2020-2021', '123', 'Officer', 'Zyrah Avila', '2020-04-25'),
(21, 'Mira Estigoy', 'BSIT2-2N', '2019-2020', '123', 'Officer', 'Zyrah Avila', '2020-04-25'),
(22, 'Ivan Clifford Dolotina', 'BSIT2-1N', '2020-2021', '123', 'Officer', 'Zyrah Avila', '2020-04-26'),
(23, 'Gerard Way', 'BSIT2-P', '2020-2021', '123', 'Officer', 'Zyrah Avila', '2020-04-26');

-- --------------------------------------------------------

--
-- Table structure for table `rental`
--

CREATE TABLE `rental` (
  `rn_id` int(50) NOT NULL,
  `rn_stuno` varchar(50) NOT NULL,
  `rn_stuname` varchar(50) NOT NULL,
  `rn_section` varchar(50) NOT NULL,
  `rn_dtr` date NOT NULL,
  `rn_room` varchar(50) NOT NULL,
  `rn_tmin` varchar(5) NOT NULL,
  `rn_tmout` varchar(5) NOT NULL,
  `rn_itemid` int(50) NOT NULL,
  `rn_itemname` varchar(50) NOT NULL,
  `rn_itemdesc` varchar(50) NOT NULL,
  `rn_fee` int(50) NOT NULL,
  `rn_oic` varchar(50) NOT NULL,
  `rn_cdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rental`
--

INSERT INTO `rental` (`rn_id`, `rn_stuno`, `rn_stuname`, `rn_section`, `rn_dtr`, `rn_room`, `rn_tmin`, `rn_tmout`, `rn_itemid`, `rn_itemname`, `rn_itemdesc`, `rn_fee`, `rn_oic`, `rn_cdate`) VALUES
(129, 'asd', 'Juan Carlos Miralles', 'asd', '2020-04-30', 'S502', '16:00', '18:00', 1, 'Extension', '5 meters', 0, 'Zyrah Avila', '2020-04-25'),
(130, 'asd', 'Anielle Del Valle', 'asd', '2020-04-30', 'E501', '07:30', '08:30', 1, 'HDMI', '2 meters', 0, 'Zyrah Avila', '2020-04-25'),
(131, '2018-02240-MN-0', 'Zyrah Avila', '123', '2020-04-25', 'E401', '21:42', '23:00', 0, 'TV', 'Samsung 40 inches', 50, 'Zyrah Avila', '2020-04-25'),
(132, 'asasd', 'Anielle Del Valle', 'asdas', '2020-04-30', 'S510', '07:00', '09:00', 14, 'TV', 'Sony Bravia 32 inches', 0, 'Zyrah Avila', '2020-04-25'),
(133, 'asdas', 'Arianne Dumanais', 'dasdas', '2020-04-30', 'E402', '07:30', '08:30', 19, 'TV', 'Sony Bravia 32 inches', 0, 'Zyrah Avila', '2020-04-25'),
(134, 'asd', 'Anielle Del Valle', 'asd', '2020-04-25', 'E416', '21:45', '22:30', 0, 'HDMI', '2 meters', 0, 'Zyrah Avila', '2020-04-25'),
(135, '2018-02240-MN-0', 'Ivan Clifford Dolotina', 'BSIT2-1N', '2020-04-25', 'E501', '08:00', '09:00', 1, 'TV', 'Sony Bravia 32 inches', 50, 'Zyrah Avila', '2020-04-25'),
(136, '2018-02240-MN-0', 'Clei Atud', 'BSIT2-1N', '2020-04-25', 'E414', '09:00', '12:00', 1, 'TV', 'Sony Bravia 32 inches', 50, 'Zyrah Avila', '2020-04-25'),
(137, '2018-02240-MN-0', 'Clei Atud', 'BSIT2-1N', '2020-04-25', 'E414', '09:00', '12:00', 1, 'HDMI', '2 meters', 0, 'Zyrah Avila', '2020-04-25'),
(138, '2018-02240-MN-0', 'Clei Atud', 'BSIT2-1N', '2020-04-25', 'E414', '09:00', '12:00', 1, 'Extension', '5 meters', 0, 'Zyrah Avila', '2020-04-25'),
(139, '2018-02240-MN-0', 'Vince Recto', 'BSIT2-1N', '2020-04-28', 'E404', '13:30', '18:00', 20, 'TV', 'LG TV 32 inches', 0, 'Zyrah Avila', '2020-04-25'),
(140, '2018-02240-MN-0', 'Vince Recto', 'BSIT2-1N', '2020-04-28', 'E404', '13:30', '18:00', 13, 'HDMI', '2 meters', 0, 'Zyrah Avila', '2020-04-25'),
(141, '2018-02240-MN-0', 'Jeffrey Baluyot', 'BSIT2-1N', '2020-04-25', 'E416', '09:00', '12:00', 1, 'TV', 'LG TV 32 inches', 50, 'Mira Estigoy', '2020-04-25'),
(142, '2018-02240-MN-0', 'Jeffrey Baluyot', 'BSIT2-1N', '2020-04-25', 'E416', '09:00', '12:00', 1, 'VGA', '1 meter', 0, 'Mira Estigoy', '2020-04-25'),
(143, '2018-02240-MN-0', 'Zyrah Kae Avila', 'BSIT2-1N', '2020-04-26', 'E416', '12:00', '15:00', 1, 'TV', 'LG TV 32 inches', 50, 'Ivan Clifford Dolotina', '2020-04-26'),
(144, '2018-02240-MN-0', 'Zyrah Kae Avila', 'BSIT2-1N', '2020-04-26', 'E416', '12:00', '15:00', 1, 'HDMI', '2 meters', 0, 'Ivan Clifford Dolotina', '2020-04-26'),
(146, '2018-02240-MN-0', 'Raven Nicolas', 'BSIT2-1N', '2020-04-30', 'S503', '16:00', '20:00', 0, 'Damath', 'Board Game', 0, 'Ivan Clifford Dolotina', '2020-04-26'),
(147, '2018-02240-MN-0', 'Marielle Veneracion', 'BSIT2-1N', '2020-04-27', 'E416', '07:00', '10:00', 20, 'TV', 'LG TV 32 inches', 0, 'Zyrah Avila', '2020-04-26');

-- --------------------------------------------------------

--
-- Table structure for table `rental_dump`
--

CREATE TABLE `rental_dump` (
  `rdump_id` int(50) NOT NULL,
  `rn_id` int(50) NOT NULL,
  `rn_stuno` varchar(50) NOT NULL,
  `rn_stuname` varchar(50) NOT NULL,
  `rn_section` varchar(50) NOT NULL,
  `rn_dtr` date NOT NULL,
  `rn_room` varchar(50) NOT NULL,
  `rn_tmin` varchar(5) NOT NULL,
  `rn_tmout` varchar(5) NOT NULL,
  `rn_itemid` int(50) NOT NULL,
  `rn_itemname` varchar(50) NOT NULL,
  `rn_itemdesc` varchar(50) NOT NULL,
  `rn_fee` int(50) NOT NULL,
  `rn_oic` varchar(50) NOT NULL,
  `rn_cdate` date NOT NULL,
  `rn_type` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rental_dump`
--

INSERT INTO `rental_dump` (`rdump_id`, `rn_id`, `rn_stuno`, `rn_stuname`, `rn_section`, `rn_dtr`, `rn_room`, `rn_tmin`, `rn_tmout`, `rn_itemid`, `rn_itemname`, `rn_itemdesc`, `rn_fee`, `rn_oic`, `rn_cdate`, `rn_type`) VALUES
(1, 118, '2018-02240-MN-0', 'Zyrah Avila', 'BSIT2-1N', '2020-04-24', 'E416', '07:00', '09:30', 13, 'HDMI', '2 meters', 0, '', '2020-04-25', 'Deleted'),
(2, 119, 'ASD', 'Zyrah Avila', 'ASD', '2020-04-25', 'E413', '07:00', '08:00', 19, 'TV', 'Sony Bravia 32 inches', 0, '', '2020-04-24', 'Deleted'),
(4, 119, 'ASD', 'Zyrah Avila', 'ASD', '2020-04-25', 'E413', '07:00', '08:00', 1, 'VGA', '1 meter', 0, '', '2020-04-25', 'Deleted'),
(5, 120, 'asd', 'Zyrah Avila', 'asd', '2020-04-29', 'E501', '07:00', '09:00', 9, 'VGA', '1 meter', 0, 'Marielle Veneracion', '2020-04-24', 'Updated'),
(6, 120, 'asd', 'Zyrah Avila', 'asd', '2020-04-29', 'E501', '07:00', '09:00', 27, 'Chess', 'Board Game', 0, '', '2020-04-25', 'Deleted'),
(7, 124, '2018-02240-MN-0', 'Zyrah Avila', 'BSIT2-1N', '2020-04-24', 'E416', '19:00', '20:30', 5, 'TV', 'Sony Bravia 32 inches', 50, 'Marielle Veneracion', '2020-04-24', 'Updated'),
(8, 124, '2018-02240-MN-0', 'Zyrah Avila', 'BSIT2-1N', '2020-04-24', 'E416', '19:00', '20:30', 26, 'Equalizer', 'Board Game', 0, '', '2020-04-25', 'Deleted'),
(9, 125, '2018-02240-MN-0', 'Zyrah Avila', 'BSIT2-1N', '2020-04-24', 'E416', '19:00', '20:30', 21, 'Extension', '5 meters', 0, 'Marielle Veneracion', '2020-04-24', 'Updated'),
(10, 125, '2018-02240-MN-0', 'Zyrah Avila', 'BSIT2-1N', '2020-04-24', 'E416', '19:00', '20:30', 24, 'Scrabble', 'Board Game', 0, '', '2020-04-25', 'Deleted'),
(11, 126, '2018-02240-MN-0', 'Zyrah Avila', 'BSIT2-1N', '2020-04-24', 'E416', '19:00', '20:30', 8, 'HDMI', '2 meters', 0, 'Marielle Veneracion', '2020-04-24', 'Deleted'),
(12, 127, '2018-02240-MN-0', 'Jesus Lopez', 'BSIT 2-1N', '2020-04-25', 'S510', '13:00', '17:00', 14, 'TV', 'Samsung 40 inches', 0, 'Zyrah Avila', '2020-04-24', 'Updated'),
(13, 127, '2018-02240-MN-0', 'Jesus Lopez', 'BSIT 2-1N', '2020-04-25', 'S510', '13:00', '17:00', 26, 'Equalizer', 'Board Game', 0, '', '2020-04-25', 'Deleted'),
(14, 128, 'asd', 'asd', 'dasd', '2020-04-30', 'asd', '07:00', '07:00', 5, 'TV', 'Sony Bravia 32 inches', 0, '', '2020-04-25', 'Updated'),
(15, 128, 'asd', 'asd', 'dasd', '2020-04-30', 'asd', '07:00', '07:00', 21, 'Extension', '5 meters', 0, '', '2020-04-25', 'Cancelled'),
(16, 128, 'asd', 'asd', 'dasd', '2020-04-30', 'asd', '07:00', '07:00', 0, 'Extension', '5 meters', 0, '', '2020-04-25', 'Deleted'),
(17, 129, 'asd', 'asd', 'asd', '2020-04-25', 'sad', '07:00', '07:15', 22, 'Damath', 'Board Game', 0, '', '2020-04-25', 'Updated'),
(18, 129, 'asd', 'asd', 'asd', '2020-04-25', 'sad', '07:00', '07:15', 9, 'VGA', '1 meter', 0, '', '2020-04-25', 'Updated'),
(19, 129, 'asd', 'asd', 'asd', '2020-04-25', 'sad', '07:00', '07:15', 21, 'Extension', '5 meters', 0, '', '2020-04-25', 'Rent Done'),
(20, 130, 'asd', 'asd', 'asd', '2020-04-25', 'asd', '07:30', '08:30', 5, 'TV', 'Sony Bravia 32 inches', 50, '', '2020-04-25', 'Updated'),
(21, 130, 'asd', 'asd', 'asd', '2020-04-30', 'asd', '07:30', '08:30', 8, 'HDMI', '2 meters', 0, '', '2020-04-25', 'Rent Done'),
(22, 131, '2018-02240-MN-0', 'Zyrah Avila', '123', '2020-04-25', 'E401', '21:42', '23:00', 14, 'TV', 'Samsung 40 inches', 50, 'Zyrah Avila', '2020-04-25', 'Cancelled'),
(23, 134, 'asd', 'asd', 'asd', '2020-04-25', 'asd', '21:45', '22:30', 8, 'HDMI', '2 meters', 0, '', '2020-04-25', 'Rent Done'),
(24, 134, 'asd', 'asd', 'asd', '2020-04-25', 'asd', '21:45', '22:30', 1, 'HDMI', '2 meters', 0, '', '2020-04-25', 'Updated'),
(25, 134, 'asd', 'Anielle Del Valle', 'asd', '2020-04-25', 'asd', '21:45', '22:30', 8, 'HDMI', '2 meters', 0, 'Zyrah Avila', '2020-04-25', 'Cancelled'),
(26, 133, 'asdas', 'asdas', 'dasdas', '2020-04-30', '123', '07:30', '07:00', 5, 'TV', 'Sony Bravia 32 inches', 0, '', '2020-04-25', 'Updated'),
(27, 132, 'asasd', 'asdas', 'asdas', '2020-04-30', 'asd', '07:00', '07:00', 5, 'TV', 'Sony Bravia 32 inches', 0, 'Zyrah Avila', '2020-04-25', 'Updated'),
(28, 130, 'asd', 'asd', 'asd', '2020-04-30', 'asd', '07:30', '08:30', 1, 'HDMI', '2 meters', 0, '', '2020-04-25', 'Updated'),
(29, 134, 'asd', 'Anielle Del Valle', 'asd', '2020-04-25', 'asd', '21:45', '22:30', 0, 'HDMI', '2 meters', 0, 'Zyrah Avila', '2020-04-25', 'Updated'),
(30, 134, 'asd', 'Anielle Del Valle', 'asd', '2020-04-25', 'E416', '21:45', '22:30', 13, 'HDMI', '2 meters', 0, 'Zyrah Avila', '2020-04-25', 'Cancelled'),
(31, 133, 'asdas', 'Arianne Dumanais', 'dasdas', '2020-04-30', '123', '07:30', '08:30', 14, 'TV', 'Sony Bravia 32 inches', 0, 'Zyrah Avila', '2020-04-25', 'Updated'),
(32, 132, 'asasd', 'Anielle Del Valle', 'asdas', '2020-04-30', 'asd', '07:00', '09:00', 5, 'TV', 'Sony Bravia 32 inches', 0, 'Zyrah Avila', '2020-04-25', 'Updated'),
(33, 129, 'asd', 'asd', 'asd', '2020-04-25', 'sad', '07:00', '07:15', 1, 'Extension', '5 meters', 0, '', '2020-04-25', 'Updated'),
(34, 142, '2018-02240-MN-0', 'Jeffrey Baluyot', 'BSIT2-1N', '2020-04-25', 'E416', '09:00', '12:00', 13, 'HDMI', '2 meters', 0, 'Mira Estigoy', '2020-04-25', 'Updated'),
(35, 146, '2018-02240-MN-0', 'Raven Nicolas', 'BSIT2-1N', '2020-04-30', 'S503', '16:00', '20:00', 25, 'TV', 'Hisense Smart TV 40 inch', 0, 'Ivan Clifford Dolotina', '2020-04-26', 'Updated'),
(36, 146, '2018-02240-MN-0', 'Raven Nicolas', 'BSIT2-1N', '2020-04-30', 'S503', '16:00', '20:00', 22, 'Damath', 'Board Game', 0, 'Ivan Clifford Dolotina', '2020-04-26', 'Cancelled'),
(37, 145, '2018-02240-MN-0', 'Zyrah Kae Avila', 'BSIT2-1N', '2020-04-26', 'E416', '12:00', '15:00', 32, 'Extension', '5 meters', 0, 'Ivan Clifford Dolotina', '2020-04-26', 'Deleted');

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `request_id` int(11) NOT NULL,
  `acc_name` varchar(30) NOT NULL,
  `yearsection` varchar(20) NOT NULL,
  `schoolyear` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`request_id`, `acc_name`, `yearsection`, `schoolyear`, `password`) VALUES
(21, 'Benedict Avila', 'BSIT1-1', '2020-2021', '123');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `rn_id` int(50) NOT NULL,
  `rn_stuno` varchar(50) NOT NULL,
  `rn_stuname` varchar(50) NOT NULL,
  `rn_section` varchar(50) NOT NULL,
  `rn_dtr` date NOT NULL,
  `rn_room` varchar(50) NOT NULL,
  `rn_tmin` varchar(5) NOT NULL,
  `rn_tmout` varchar(5) NOT NULL,
  `rn_itemname` varchar(50) NOT NULL,
  `rn_itemdesc` varchar(50) NOT NULL,
  `rn_fee` int(50) NOT NULL,
  `rn_oic` varchar(50) NOT NULL,
  `rn_cdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`item_id`),
  ADD UNIQUE KEY `item_id` (`item_id`);

--
-- Indexes for table `inventory_dump`
--
ALTER TABLE `inventory_dump`
  ADD PRIMARY KEY (`idump_id`);

--
-- Indexes for table `inventory_item`
--
ALTER TABLE `inventory_item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login_admin`
--
ALTER TABLE `login_admin`
  ADD PRIMARY KEY (`acc_id`),
  ADD UNIQUE KEY `acc_name` (`acc_name`);

--
-- Indexes for table `rental`
--
ALTER TABLE `rental`
  ADD PRIMARY KEY (`rn_id`);

--
-- Indexes for table `rental_dump`
--
ALTER TABLE `rental_dump`
  ADD PRIMARY KEY (`rdump_id`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`request_id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`rn_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `item_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `inventory_dump`
--
ALTER TABLE `inventory_dump`
  MODIFY `idump_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `inventory_item`
--
ALTER TABLE `inventory_item`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `login_admin`
--
ALTER TABLE `login_admin`
  MODIFY `acc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `rental`
--
ALTER TABLE `rental`
  MODIFY `rn_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=148;

--
-- AUTO_INCREMENT for table `rental_dump`
--
ALTER TABLE `rental_dump`
  MODIFY `rdump_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `request_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `rn_id` int(50) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
