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
DROP DATABASE IF EXISTS `mariopizza`;
CREATE DATABASE IF NOT EXISTS `mariopizza` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mariopizza`;

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

-- Dumping data for table mariopizza.activeorders: ~11 rows (approximately)
/*!40000 ALTER TABLE `activeorders` DISABLE KEYS */;
/*!40000 ALTER TABLE `activeorders` ENABLE KEYS */;

-- Dumping structure for tabel mariopizza.orderhistory
DROP TABLE IF EXISTS `orderhistory`;
CREATE TABLE IF NOT EXISTS `orderhistory` (
  `OrderId` int(11) NOT NULL DEFAULT '0',
  `Pizzaname` varchar(255) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mariopizza.orderhistory: ~2 rows (approximately)
/*!40000 ALTER TABLE `orderhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderhistory` ENABLE KEYS */;

-- Dumping structure for tabel mariopizza.orders
DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `OrderID` int(11) NOT NULL DEFAULT '0',
  `Ordering` int(11) NOT NULL DEFAULT '0',
  `Pizzaname` varchar(255) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `PickupTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`OrderID`,`Ordering`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mariopizza.orders: ~4 rows (approximately)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Dumping structure for tabel mariopizza.products
DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `ProductID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(255) DEFAULT NULL,
  `Topping` varchar(255) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- Dumping data for table mariopizza.products: ~32 rows (approximately)
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`ProductID`, `ProductName`, `Topping`, `Price`) VALUES
	(1, 'Vesuvio', 'tomatsauce, ost, skinke og oregano', 57),
	(2, 'Amerikaner', 'tomatsauce, ost, oksefars og oregano', 53),
	(3, 'Cacciatore', 'tomatsauce, ost, pepperoni og oregano', 57),
	(4, 'Carbona', 'tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano', 63),
	(5, 'Dennis', 'tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano', 65),
	(6, 'Bertil', 'tomatsauce, ost, bacon og oregano', 57),
	(7, 'Silvia', 'tomatsauce, ost, pepperoni, rød peber, løg og oregano', 61),
	(8, 'Victoria', 'tomatsauce, ost, skinke, ananas, champignon, løg og oregano', 61),
	(9, 'Toronfo', 'tomatsauce, ost, skinke, bacon, kebab, chili og oregano', 61),
	(10, 'Capricciosa', 'tomatsauce, ost, skinke, champignon og oregano', 61),
	(11, 'Hawaii', 'tomatsauce, ost, skinke, ananas og oregano', 61),
	(12, 'Le Blissola', 'tomatsauce, ost, skinke, rejer og oregano', 61),
	(13, 'Venezia', 'tomatsauce, ost, skinke, bacon og oregano', 61),
	(14, 'Mafia', 'tomatsauce, ost, pepperoni, bacon, løg og oregano', 61),
	(15, 'Danala', 'tomatsauce, ost, kylling, bacon, løg og oregano', 61),
	(16, 'Mexicano', 'tomatsauce, ost, kødsauce, chili, løg, majs og oregano', 65),
	(17, 'Harry Potter', 'tomatsauce, ost, kylling, bearnaise, hvidløg og oregano', 70),
	(18, 'Terminator', 'tomatsauce, ost, kylling, creme fraiche , hvidløg og oregano', 72),
	(19, 'Jackson', 'tomatsauce, ost, kylling, oksekød, paprika og oregano', 64),
	(20, 'Voldamort', 'tomatsauce, ost, kylling, creme fraiche , hvidløg og chili', 66),
	(21, 'Løkke', 'tomatsauce, ost, kylling, bearnaise, hvidløg og oregano', 69),
	(22, 'DC', 'tomatsauce, ost, kylling, bearnaise, Kødsauce og oregano', 65),
	(23, 'Marvel', 'tomatsauce, ost, kylling, bearnaise, hvidløg og creme fraiche', 70),
	(24, 'Chicago', 'tomatsauce, ost, kylling, bearnaise, hvidløg og Kødsauce', 70),
	(25, 'Bae', 'tomatsauce, ost, kylling, bearnaise, creme fraiche  og oregano', 70),
	(26, 'Margrethe', 'tomatsauce, ost, kylling, bacon, hvidløg og oregano', 70),
	(27, 'København', 'tomatsauce, ost, kylling, bearnaise, hvidløg og ananas', 70),
	(28, 'Daniela', 'tomatsauce, ost, kylling, bacon, løg, creme fraiche og oregano', 65),
	(29, 'SoHype', 'tomatsauce, ost, kylling, ananas, hvidløg, oksekød og oregano', 70),
	(30, 'GitEmil', 'tomatsauce, ost, kylling, bearnaise, hvidløg og oregano', 68),
	(31, 'Jimmay', 'tomatsauce, ost, kylling, bearnaise, creme fraiche og oregano', 75),
	(32, 'Tullebob', 'tomatsauce, ost, kylling, bearnaise, hvidløg og oregano', 80);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
