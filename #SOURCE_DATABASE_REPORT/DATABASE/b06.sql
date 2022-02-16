-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2019 at 12:51 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `b06`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `CarID` varchar(15) NOT NULL,
  `Brand` varchar(10) NOT NULL,
  `CarLience` varchar(15) DEFAULT NULL,
  `ReservationStatus` varchar(15) NOT NULL DEFAULT 'not book',
  `CarType` varchar(10) NOT NULL,
  `NumberOfSeat` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`CarID`, `Brand`, `CarLience`, `ReservationStatus`, `CarType`, `NumberOfSeat`) VALUES
('c10000', 'Datsun', 'BGHYT8', 'not book', 'MPV', 8),
('c10001', 'Corolla', 'DFGYR8', 'not book', 'Sedan', 4),
('c10002', 'Ford', 'DFRTH4', 'not book', 'minibus', 14),
('c10003', 'Maruti', 'KJUHI2', 'not book', 'Hatchback', 6),
('c10004', 'Hyundai', 'KUYH90', 'not book', 'minibus', 16),
('c10005', 'Alion', 'SSRTY8', 'not book', 'Sedan', 4);

-- --------------------------------------------------------

--
-- Table structure for table `clerk`
--

CREATE TABLE `clerk` (
  `ClerkId` varchar(15) NOT NULL,
  `ClerkName` varchar(10) DEFAULT NULL,
  `ClerkSalary` float DEFAULT NULL,
  `JoinDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clerk`
--

INSERT INTO `clerk` (`ClerkId`, `ClerkName`, `ClerkSalary`, `JoinDate`) VALUES
('e10000', 'John', 28000, '2003-06-05'),
('e10001', 'Ron', 28000, '2003-08-06');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `DriverId` varchar(10) NOT NULL,
  `DriverName` varchar(10) NOT NULL,
  `DriverSalary` float NOT NULL,
  `Phone` int(20) NOT NULL,
  `Join Date` date NOT NULL,
  `DrivingLicence` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`DriverId`, `DriverName`, `DriverSalary`, `Phone`, `Join Date`, `DrivingLicence`) VALUES
('d30001', 'Kodaline', 9999.99, 1111111111, '2009-03-04', 'GXXXX01'),
('d30002', 'Wattson', 9999.99, 1212121212, '2009-03-05', 'HUXCVG2'),
('d30003', 'Devid', 9999.99, 1313131313, '2010-02-01', 'UYTGHB9'),
('d30004', 'Young', 9999.99, 1414141414, '2010-03-02', 'JKHYGF6'),
('d30005', 'Reed', 9999.99, 1515151515, '2010-07-08', 'LKJBHJ8'),
('d30006', 'Gourt', 9999.99, 1616161616, '2011-02-03', 'CVBFYH4');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmployeeID` varchar(10) NOT NULL,
  `EmployeeName` varchar(15) DEFAULT NULL,
  `EmployeeSalary` float DEFAULT NULL,
  `JobType` varchar(15) DEFAULT NULL,
  `JoinDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeID`, `EmployeeName`, `EmployeeSalary`, `JobType`, `JoinDate`) VALUES
('e10000', 'John', 28000, 'clerk', '2003-06-05'),
('e10001', 'Ron', 28000, 'clerk', '2003-08-06'),
('m10000', 'Steven', 40000, 'manger', '2003-03-01'),
('mc10000', 'Aron', 25000, 'mechanic', '2008-05-04'),
('r10000', 'Jerry', 20000, 'receptionist', '2004-02-03'),
('r10001', 'Fury', 20000, 'receptionist', '2004-09-12'),
('w10000', 'Rosy', 15000, 'worker', '2005-02-01'),
('w10001', 'Eillish', 15000, 'worker', '2005-07-08');

-- --------------------------------------------------------

--
-- Table structure for table `logindata`
--

CREATE TABLE `logindata` (
  `UserID` varchar(10) NOT NULL,
  `PassWord` varchar(15) DEFAULT NULL,
  `Status` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logindata`
--

INSERT INTO `logindata` (`UserID`, `PassWord`, `Status`) VALUES
('e10000', '1234', 2),
('e10001', NULL, 2),
('m10000', '2222', 1),
('mc10000', NULL, 0),
('r10000', NULL, 3),
('r10001', NULL, 3),
('w10000', NULL, 0),
('w10001', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `ManagerID` varchar(10) NOT NULL,
  `ManagerName` varchar(15) DEFAULT NULL,
  `ManagerSalary` float DEFAULT NULL,
  `JoinDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`ManagerID`, `ManagerName`, `ManagerSalary`, `JoinDate`) VALUES
('m10000', 'Steven', 40000, '2003-03-01');

-- --------------------------------------------------------

--
-- Table structure for table `mechanic`
--

CREATE TABLE `mechanic` (
  `MechanicId` varchar(10) NOT NULL,
  `MechanicName` varchar(15) DEFAULT NULL,
  `MechanicSalary` float DEFAULT NULL,
  `JoinDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mechanic`
--

INSERT INTO `mechanic` (`MechanicId`, `MechanicName`, `MechanicSalary`, `JoinDate`) VALUES
('mc10000', 'Aron', 25000, '2008-05-04');

-- --------------------------------------------------------

--
-- Table structure for table `reciptionist`
--

CREATE TABLE `reciptionist` (
  `ReceptionistID` varchar(15) NOT NULL,
  `ReceptionistName` varchar(10) DEFAULT NULL,
  `ReceptionistSalary` float DEFAULT NULL,
  `JoinDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reciptionist`
--

INSERT INTO `reciptionist` (`ReceptionistID`, `ReceptionistName`, `ReceptionistSalary`, `JoinDate`) VALUES
('r10000', 'Jerry', 20000, '2004-02-03'),
('r10001', 'Fury', 20000, '2004-09-12');

-- --------------------------------------------------------

--
-- Table structure for table `worker`
--

CREATE TABLE `worker` (
  `WorkerID` varchar(10) NOT NULL,
  `WorkerName` varchar(15) DEFAULT NULL,
  `WorkerSalary` float DEFAULT NULL,
  `JoinDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `worker`
--

INSERT INTO `worker` (`WorkerID`, `WorkerName`, `WorkerSalary`, `JoinDate`) VALUES
('w10000', 'Rosy', 15000, '2005-02-01'),
('w10001', 'Eillish', 15000, '2005-07-08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`CarID`);

--
-- Indexes for table `clerk`
--
ALTER TABLE `clerk`
  ADD PRIMARY KEY (`ClerkId`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`DriverId`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmployeeID`);

--
-- Indexes for table `logindata`
--
ALTER TABLE `logindata`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`ManagerID`);

--
-- Indexes for table `mechanic`
--
ALTER TABLE `mechanic`
  ADD PRIMARY KEY (`MechanicId`);

--
-- Indexes for table `reciptionist`
--
ALTER TABLE `reciptionist`
  ADD PRIMARY KEY (`ReceptionistID`);

--
-- Indexes for table `worker`
--
ALTER TABLE `worker`
  ADD PRIMARY KEY (`WorkerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
