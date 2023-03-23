-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jpagrade
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `degree`
--

DROP TABLE IF EXISTS `degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `degree` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `degree`
--

LOCK TABLES `degree` WRITE;
/*!40000 ALTER TABLE `degree` DISABLE KEYS */;
INSERT INTO `degree` VALUES (1,'2023-03-15 20:31:49.808500',NULL,'english',1),(2,'2023-03-15 20:32:09.788850',NULL,'english_ielts_5.',1.1),(3,'2023-03-15 20:32:19.887050',NULL,'english_ielts_6.5',1.2),(4,'2023-03-15 20:32:38.527055',NULL,'english_ielts_8.',1.3),(5,'2023-03-15 20:32:52.644632',NULL,'Chinese',2),(6,'2023-03-15 20:33:02.117933',NULL,'japan',3),(7,'2023-03-15 20:33:11.758724',NULL,'japan_N1',3.1),(8,'2023-03-15 20:33:17.333894',NULL,'japan_N2',3.2),(9,'2023-03-15 20:33:22.065097',NULL,'japan_N3',3.3),(10,'2023-03-15 21:13:37.895446',NULL,'other languages',4),(11,'2023-03-15 21:15:35.793642',NULL,'Chinese_hsk1',2.1),(12,'2023-03-15 21:15:40.591984',NULL,'Chinese_hsk2',2.2),(13,'2023-03-15 21:15:45.182150',NULL,'Chinese_hsk3',2.3),(14,'2023-03-15 21:16:24.725558',NULL,'do not have',5);
/*!40000 ALTER TABLE `degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'2023-03-15 20:32:09.788850',NULL,'technique',1),(2,'2023-03-15 20:35:09.788850',NULL,'personnel',2),(3,'2023-03-14 20:32:09.788850',NULL,'managing director',0),(4,'2023-03-15 10:32:09.788850',NULL,'leader_HR',6),(5,'2023-03-15 21:32:09.788850',NULL,'HR',6.1),(6,'2023-03-12 20:30:09.788850',NULL,'admin',6.2),(7,'2023-03-11 20:32:09.788850',NULL,'java',1.1),(8,'2023-02-15 20:32:09.788850',NULL,'PhP',1.2),(9,'2023-03-10 20:32:09.788850',NULL,'C#',1.3),(10,'2023-01-15 20:32:09.788850',NULL,'Python',1.4),(11,'2023-03-15 01:32:09.788850',NULL,'PM',3.2),(12,'2023-03-15 09:32:09.788850',NULL,'techleader',3.1),(13,'2023-03-15 07:32:09.788850',NULL,'senior',3.3),(14,'2023-03-15 20:02:09.788850',NULL,'middle',3.4),(15,'2023-03-15 20:12:09.788850',NULL,'junior',3.5),(16,'2023-03-12 22:32:09.788850',NULL,'fresher',3.6),(17,'2023-03-03 20:32:09.788850',NULL,'intern',3.7),(18,'2023-03-08 20:32:09.788850',NULL,'dev',7.1),(19,'2023-02-15 20:32:09.788850',NULL,'tester',7.2),(20,'2023-03-11 20:32:09.788850',NULL,'BA',7.3),(21,'2023-03-15 12:32:09.788850',NULL,'Comter',7.4),(22,'2023-03-15 15:32:09.788850',NULL,'accountant',9),(23,'2023-03-17 15:32:09.788850',NULL,'other task',11);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `tax_code` varchar(255) DEFAULT NULL,
  `user_code` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2023-03-18 14:43:29.923722',NULL,'9092u9898sa','VU NGOC HOAN','Nam Định',NULL,'agribank','2000-06-22','vuhoan485@gmail.com','Vũ','Ngọc Hoan','0988971325','776616','SN0001'),(2,'2023-03-18 15:14:48.310529',NULL,'0892u8898sa','LE THI THU HANG','Hà Nam ',NULL,'vietcombank','2000-12-14','lehanghanam@gmail.com','Lê','Thu Hằng','0911971325','556616','CP0001');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_degree`
--

DROP TABLE IF EXISTS `user_degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_degree` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_degree_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhj9d777g75s7aa7ohvx38krci` (`type_degree_id`),
  KEY `FKtngg2al78cbckdfgxbvk0ln56` (`user_id`),
  CONSTRAINT `FKhj9d777g75s7aa7ohvx38krci` FOREIGN KEY (`type_degree_id`) REFERENCES `degree` (`id`),
  CONSTRAINT `FKtngg2al78cbckdfgxbvk0ln56` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_degree`
--

LOCK TABLES `user_degree` WRITE;
/*!40000 ALTER TABLE `user_degree` DISABLE KEYS */;
INSERT INTO `user_degree` VALUES (1,'2023-03-20 22:13:00.370002',NULL,'english',1,1),(2,'2023-03-20 22:13:15.461346','2023-03-21 20:43:06.966141','english_ielts_6.5',3,1);
/*!40000 ALTER TABLE `user_degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_department`
--

DROP TABLE IF EXISTS `user_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_department_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbncyxn0bwscpeq9qsbtewwuvq` (`type_department_id`),
  KEY `FK1alh47saqbwnimxd9o564o4vm` (`user_id`),
  CONSTRAINT `FK1alh47saqbwnimxd9o564o4vm` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKbncyxn0bwscpeq9qsbtewwuvq` FOREIGN KEY (`type_department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_department`
--

LOCK TABLES `user_department` WRITE;
/*!40000 ALTER TABLE `user_department` DISABLE KEYS */;
INSERT INTO `user_department` VALUES (3,'2023-03-20 20:12:25.089793',NULL,'technique',1,1),(4,'2023-03-20 20:14:04.060429',NULL,'java',7,1),(5,'2023-03-20 20:14:04.060429','2023-03-21 20:40:05.912456','junior',15,1);
/*!40000 ALTER TABLE `user_department` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-23 21:53:03
