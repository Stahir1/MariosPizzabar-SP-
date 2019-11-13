-- --------------------------------------------------------
-- Vært:                         127.0.0.1
-- Server-version:               8.0.18 - MySQL Community Server - GPL
-- ServerOS:                     Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for mariopizza
CREATE DATABASE IF NOT EXISTS `mariopizza` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mariopizza`;

-- Dumping structure for tabel mariopizza.products
DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `ProductID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(255) DEFAULT NULL,
  `Topping` varchar(255) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table mariopizza.products: ~2 rows (approximately)
ALTER TABLE `products` DISABLE KEYS;
INSERT INTO `products` (`ProductID`, `ProductName`, `Topping`, `Price`) VALUES
	(1, 'Vesuvio', 'tomatsauce, ost, skinke og oregano', 57),
	(2, 'test', 'testtopping', 51); 
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

-- --------------------------------------------------------
-- Vært:                         127.0.0.1
-- Server-version:               8.0.18 - MySQL Community Server - GPL
-- ServerOS:                     Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for tabel shop2.orders
-- --------------------------------------------------------
-- Vært:                         127.0.0.1
-- Server-version:               8.0.18 - MySQL Community Server - GPL
-- ServerOS:                     Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for tabel mariopizza.activeorders
DROP TABLE IF EXISTS `activeorders`;
CREATE TABLE IF NOT EXISTS `activeorders` (
  `OrderID` int(11) NOT NULL DEFAULT '0',
  `Ordering` int(11) NOT NULL DEFAULT '0',
  `Pizzaname` varchar(255) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `PickupTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`OrderID`,`Ordering`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mariopizza.orders: ~3 rows (approximately)
/*!40000 ALTER TABLE `activeorders` DISABLE KEYS */;
INSERT INTO `activeorders` (`OrderID`, `Ordering`, `Pizzaname`, `Price`, `PickupTime`) VALUES
	(1, 1, 'Vesuvio', 57, '16:30'),
	(1, 2, 'Dennis', 65, '16:30'),
	(1, 3, 'Silvia', 61, '16:30'),
	(1, 4, 'Toronfo', 61, '16:30'),
	(2, 1, 'Hawaii', 61, '11:30'),
	(2, 2, 'Danala', 61, '11:30'),
	(3, 1, 'Mexicano', 65, '18:20');
/*!40000 ALTER TABLE `activeorders` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;


-- Dumping structure for tabel shop2.order_details
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE IF NOT EXISTS `order_details` (
  `OrderDetailsID` int(11) NOT NULL AUTO_INCREMENT,
  `OrderID` int(11) DEFAULT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderDetailsID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;


DROP TABLE IF EXISTS `orderhistory`;
CREATE TABLE IF NOT EXISTS `orderhistory` (
  `OrderID` int(11) NOT NULL DEFAULT '0',
  `Ordering` int(11) NOT NULL DEFAULT '0',
  `Pizzaname` varchar(255) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderID`,`Ordering`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
