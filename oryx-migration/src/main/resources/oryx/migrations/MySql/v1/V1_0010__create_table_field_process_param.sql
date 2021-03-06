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
-- Table structure for table `t_field_process_param`
--

DROP TABLE IF EXISTS `t_field_process_param`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_field_process_param` (
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
  `DESCRIPTION` varchar(128) DEFAULT NULL,
  `FIELD_CODE` varchar(32) NOT NULL,
  `PROCESS_CODE` varchar(10) NOT NULL,
  `PROCESS_REF` varchar(10) DEFAULT NULL,
  `PROCESS_RESULT` varchar(10) DEFAULT NULL,
  `PROCESS_TYPE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UC_FPP_CODE_FIELD_REF_TYPE` (`PROCESS_CODE`,`FIELD_CODE`,`PROCESS_REF`,`PROCESS_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_field_process_param`
--
-- ORDER BY:  `ID`

LOCK TABLES `t_field_process_param` WRITE;
/*!40000 ALTER TABLE `t_field_process_param` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_field_process_param` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-25 14:39:48
