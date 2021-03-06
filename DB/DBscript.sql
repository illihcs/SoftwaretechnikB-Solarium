CREATE DATABASE  IF NOT EXISTS `solardb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `solardb`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: solardb
-- ------------------------------------------------------
-- Server version	5.6.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `applicationuser`
--

DROP TABLE IF EXISTS `applicationuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicationuser` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Vorname` varchar(45) DEFAULT NULL,
  `Nachname` varchar(45) DEFAULT NULL,
  `Geburtstag` date DEFAULT NULL,
  `EMail` varchar(45) DEFAULT NULL,
  `Passwort` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicationuser`
--

LOCK TABLES `applicationuser` WRITE;
/*!40000 ALTER TABLE `applicationuser` DISABLE KEYS */;
INSERT INTO `applicationuser` VALUES (1,'Peter','Müller','1987-05-09','peter@gmx.de','peter'),(6,'Lisa','Maier','1987-08-08','lisa@gmx.de','lisa'),(7,'Sarah','Johnes','1988-09-15','sarah@gmx.de','sarah');
/*!40000 ALTER TABLE `applicationuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sonnenbank`
--

DROP TABLE IF EXISTS `sonnenbank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sonnenbank` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Kabine` varchar(45) DEFAULT NULL,
  `Leistung` varchar(45) DEFAULT NULL,
  `Wartungstermin` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sonnenbank`
--

LOCK TABLES `sonnenbank` WRITE;
/*!40000 ALTER TABLE `sonnenbank` DISABLE KEYS */;
INSERT INTO `sonnenbank` VALUES (1,'09','2500 W','2015-08-15'),(2,'04','1750 W','2015-06-03'),(3,'03','3200 W','2015-04-09');
/*!40000 ALTER TABLE `sonnenbank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `termin`
--

DROP TABLE IF EXISTS `termin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `termin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Datum` date DEFAULT NULL,
  `Uhrzeitvon` time DEFAULT NULL,
  `UhrzeitBis` time DEFAULT NULL,
  `Sonnenbank` varchar(45) DEFAULT NULL,
  `Kunde` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `termin`
--

LOCK TABLES `termin` WRITE;
/*!40000 ALTER TABLE `termin` DISABLE KEYS */;
INSERT INTO `termin` VALUES (1,'2015-05-16','12:18:00','13:29:15','09','1'),(4,'2012-12-12','16:45:00','17:00:00','04','2'),(7,'2015-06-16','12:15:00','15:45:30','03','3');
/*!40000 ALTER TABLE `termin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'solardb'
--

--
-- Dumping routines for database 'solardb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-09 21:32:32
