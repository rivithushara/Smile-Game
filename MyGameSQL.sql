-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: gamedb
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `easymodescore`
--

DROP TABLE IF EXISTS `easymodescore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `easymodescore` (
  `score` varchar(45) DEFAULT NULL,
  `pname` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `easymodescore`
--

LOCK TABLES `easymodescore` WRITE;
/*!40000 ALTER TABLE `easymodescore` DISABLE KEYS */;
INSERT INTO `easymodescore` VALUES ('100','eeeeeeee'),('990','rivi1'),('1000','wwww'),('990','rivi'),('100','rrr');
/*!40000 ALTER TABLE `easymodescore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hardmodescore`
--

DROP TABLE IF EXISTS `hardmodescore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hardmodescore` (
  `score` varchar(45) DEFAULT NULL,
  `pname` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hardmodescore`
--

LOCK TABLES `hardmodescore` WRITE;
/*!40000 ALTER TABLE `hardmodescore` DISABLE KEYS */;
INSERT INTO `hardmodescore` VALUES ('100','7'),('100','rivi');
/*!40000 ALTER TABLE `hardmodescore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `normalmodescore`
--

DROP TABLE IF EXISTS `normalmodescore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `normalmodescore` (
  `score` varchar(45) DEFAULT NULL,
  `pname` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `normalmodescore`
--

LOCK TABLES `normalmodescore` WRITE;
/*!40000 ALTER TABLE `normalmodescore` DISABLE KEYS */;
INSERT INTO `normalmodescore` VALUES ('100','rivi'),('950','ire'),('980',''),('200','wwww'),('200','gg'),('200','m'),('200','ii'),('190','t'),('170','riveeee'),('170','riveeee'),('200','444'),('200','444'),('200','dd'),('200','dd'),('200','..'),('200','..'),('200','uuu'),('20','gg'),('190','tt'),('190','11'),('1000','whoaha'),('1000','weeeee'),('1000','yeyee'),('970','qqqqqqqq'),('990','1'),('1000','tttttt'),('980','myname'),('990','mynameisrivii'),('1000','yy'),('1000','rivi thushara'),('90','rivi'),('90','rivi'),('970','rivi2'),('985','thushara'),('985','saman'),('985','rivi'),('885','rivi'),('985','rivi thushara'),('985','mahela'),('970','Dasun'),('970','Dinesh');
/*!40000 ALTER TABLE `normalmodescore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login`
--

DROP TABLE IF EXISTS `user_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_login` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login`
--

LOCK TABLES `user_login` WRITE;
/*!40000 ALTER TABLE `user_login` DISABLE KEYS */;
INSERT INTO `user_login` VALUES (1,'r','r','r','r'),(3,'d','d','d','d'),(10,'q','q','q','q'),(12,'w','w','w','ww'),(13,'3','3','3','3'),(14,'q','q','qq','q'),(16,'z','z','z','z'),(17,'Rivi','Thushara','rivithushara','rivi123'),(19,'x','x','x','x'),(20,'Iresha ','Sewwandi','Iresha','iresha'),(21,'Uththra ','Samadhi','samadhi','uththara'),(23,'hehe','haha','heha','123'),(24,'rivi ','thushara','rivi','rivi'),(25,'rivi1','rivi1','rivi1','rivi1'),(27,'s','s','ssss','s'),(29,'ri','ri','ri','ri'),(31,'my name','my name','my name','my name'),(32,'qwe','qwe','qwerrt','1111'),(33,'12345','1234','1234','1'),(34,'rivini ','sankala','rivini','rivini'),(35,'Shameer','Dilshan','Shameer','1234'),(36,'Rivi','Mahadurage','rivimahadurage','1234'),(37,'anjani','sathsarani','anjani','1234'),(38,'Rivi','Thushara','Rivi123','1234'),(42,'sanju','sanju','sanju','sa'),(43,'Rivi','Thushara','blackdread','1234'),(44,'Kumar','Sangakkara','kumar','1234'),(45,'Mahela ','Jayawardena','mahela','1234'),(46,'Lasith','Malinga','malinga','1234'),(47,'Angelo ','Mathews','mathews','1234'),(48,'Dasun','Shanaka','dasun','dasun'),(49,'Dinesh','Chandimal','dinesh','dinesh');
/*!40000 ALTER TABLE `user_login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-09 10:43:26
