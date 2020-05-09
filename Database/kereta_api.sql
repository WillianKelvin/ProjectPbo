-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2020 at 06:13 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kereta_api`
--

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `no_ka` varchar(20) NOT NULL,
  `nama_kereta` varchar(30) NOT NULL,
  `kelas` varchar(30) NOT NULL,
  `tujuan` varchar(30) NOT NULL,
  `berangkat` varchar(20) NOT NULL,
  `tiba` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`no_ka`, `nama_kereta`, `kelas`, `tujuan`, `berangkat`, `tiba`) VALUES
('KA 06', 'Argo Wilis', 'Eksekutif', 'Bandung', '23.00', '05.00'),
('KA 100', 'Malabar', 'Ekonomi', 'Bandung', '23.45', '09.00'),
('KA 80', 'Lodaya', 'Bisnis', 'Bandung', '22.00', '06.00'),
('KA 106', 'Bengawan', 'Ekonomi', 'Jakarta', '11.20', '20.00'),
('KA 107', 'Gaya Baru Malam', 'Bisnis', 'Jakarta', '20.00', '03.00'),
('KA 108', 'Bogowonto', 'Eksekutif', 'Jakarta', '09.30', '21.00'),
('KA 98', 'Malioboro Ekspress', 'Eksekutif', 'Malang', '07.45', '15.00'),
('KA 95', 'Malioboro Ekspress', 'Bisnis', 'Malang', '08.25', '16.30'),
('KA 94', 'Malioboro Ekspress', 'Ekonomi', 'Malang', '10.00', '20.15'),
('KA 345', 'Logawa', 'Eksekutif', 'Surabaya', '16.30', '21.00'),
('KA 554', 'Mutiara Selatan', 'Bisnis', 'Surabaya', '17.00', '22.30'),
('KA 787', 'Turangga', 'Ekonomi', 'Surabaya', '07.30', '12.30');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `nama` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`nama`, `email`, `username`, `password`) VALUES
('willlian kelvin', 'williankvn2008@gmail.com', 'williankelvin', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `perjalanan`
--

CREATE TABLE `perjalanan` (
  `asal` varchar(30) NOT NULL,
  `tujuan` varchar(30) NOT NULL,
  `kelas` varchar(30) NOT NULL,
  `tanggal` varchar(30) NOT NULL,
  `harga` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perjalanan`
--

INSERT INTO `perjalanan` (`asal`, `tujuan`, `kelas`, `tanggal`, `harga`) VALUES
('YOGYAKARTA', 'Bandung', 'Ekonomi', '3Februari2020', 'Rp. 400.000,-'),
('YOGYAKARTA', 'Jakarta', 'Ekonomi', '3Maret2020', 'Rp. 320.000,-'),
('YOGYAKARTA', 'Bandung', 'Ekonomi', '7Juli2020', 'Rp. 400.000,-'),
('YOGYAKARTA', 'Jakarta', 'Ekonomi', '6Maret2020', 'Rp. 320.000,-'),
('YOGYAKARTA', 'Jakarta', 'Ekonomi', '4April2020', 'Rp. 250.000,-'),
('YOGYAKARTA', 'Surabaya', 'Ekonomi', '24Agustus2020', 'Rp. 500.000,-'),
('YOGYAKARTA', 'Jakarta', 'Ekonomi', '6Mei2020', 'Rp. 320.000,-'),
('YOGYAKARTA', 'Jakarta', 'Ekonomi', '26Mei2020', 'Rp. 470.000,-'),
('YOGYAKARTA', 'Jakarta', 'Ekonomi', '16Juli2020', 'Rp. 470.000,-');

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `nama` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telepon` varchar(20) NOT NULL,
  `id` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`nama`, `email`, `telepon`, `id`) VALUES
('wilyean kelven', '082177665544', 'will@gmail.com', '2343425352');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
