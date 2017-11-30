-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: oryx
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `t_state`
--

DROP TABLE IF EXISTS `t_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_state` (
  `ID` binary(16) NOT NULL,
  `VERSION` int(11) DEFAULT NULL,
  `DOMAIN_CODE` varchar(10) DEFAULT NULL,
  `CREATED_BY` binary(16) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `UPDATED_BY` binary(16) DEFAULT NULL,
  `CANCEL_DATE` datetime DEFAULT NULL,
  `CANCELED_BY` binary(16) DEFAULT NULL,
  `CHECK_CANCEL` tinyint(1) NOT NULL,
  `ALTITUDE` double DEFAULT NULL,
  `COUNTRY_NAME` varchar(50) DEFAULT NULL,
  `LATITUDE` double DEFAULT NULL,
  `LONGITUDE` double DEFAULT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `POSTAL_CODE` varchar(10) DEFAULT NULL,
  `COUNTRY_ID` binary(16) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UC_STATE_NAME_CNTRY_ID` (`NAME`,`COUNTRY_ID`),
  KEY `FK_7dy1ehsl3igg0px6qhxqqoqlw` (`COUNTRY_ID`),
  CONSTRAINT `FK_7dy1ehsl3igg0px6qhxqqoqlw` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `t_country` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_state`
--
-- ORDER BY:  `ID`

LOCK TABLES `t_state` WRITE;
/*!40000 ALTER TABLE `t_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_state` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-25 14:39:49