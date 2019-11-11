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
CREATE TABLE IF NOT EXISTS `products` (
  `ProductID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(255) DEFAULT NULL,
  `Topping` varchar(255) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table mariopizza.products: ~2 rows (approximately)
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`ProductID`, `ProductName`, `Topping`, `Price`) VALUES
	(1, 'Vesuvio', 'tomatsauce, ost, skinke og oregano', 57),
	(2, 'test', 'testtopping', 51);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
