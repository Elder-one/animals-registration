-- MySQL dump 10.13  Distrib 8.0.35, for Linux (x86_64)
--
-- Host: localhost    Database: Humans_friends
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Animal_groups`
--

DROP TABLE IF EXISTS `Animal_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Animal_groups` (
  `gr_id` int NOT NULL AUTO_INCREMENT,
  `gr_name` varchar(50) NOT NULL,
  PRIMARY KEY (`gr_id`),
  UNIQUE KEY `gr_name` (`gr_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Animal_groups`
--

LOCK TABLES `Animal_groups` WRITE;
/*!40000 ALTER TABLE `Animal_groups` DISABLE KEYS */;
INSERT INTO `Animal_groups` VALUES (2,'Draft animals'),(1,'Pets');
/*!40000 ALTER TABLE `Animal_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Animals`
--

DROP TABLE IF EXISTS `Animals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Animals` (
  `animal_id` int NOT NULL AUTO_INCREMENT,
  `sp_id` int NOT NULL,
  PRIMARY KEY (`animal_id`),
  KEY `sp_id` (`sp_id`),
  CONSTRAINT `Animals_ibfk_1` FOREIGN KEY (`sp_id`) REFERENCES `Species` (`sp_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Animals`
--

LOCK TABLES `Animals` WRITE;
/*!40000 ALTER TABLE `Animals` DISABLE KEYS */;
INSERT INTO `Animals` VALUES (1,1),(2,1),(3,2),(4,2),(5,3),(6,3),(7,4),(8,4),(11,6),(12,6);
/*!40000 ALTER TABLE `Animals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Camels`
--

DROP TABLE IF EXISTS `Camels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Camels` (
  `animal_id` int NOT NULL,
  `animal_name` varchar(25) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `birth_date` date NOT NULL,
  PRIMARY KEY (`animal_id`),
  CONSTRAINT `Camels_ibfk_1` FOREIGN KEY (`animal_id`) REFERENCES `Animals` (`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Camels`
--

LOCK TABLES `Camels` WRITE;
/*!40000 ALTER TABLE `Camels` DISABLE KEYS */;
/*!40000 ALTER TABLE `Camels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cats`
--

DROP TABLE IF EXISTS `Cats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cats` (
  `animal_id` int NOT NULL,
  `animal_name` varchar(25) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `birth_date` date NOT NULL,
  PRIMARY KEY (`animal_id`),
  CONSTRAINT `Cats_ibfk_1` FOREIGN KEY (`animal_id`) REFERENCES `Animals` (`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cats`
--

LOCK TABLES `Cats` WRITE;
/*!40000 ALTER TABLE `Cats` DISABLE KEYS */;
INSERT INTO `Cats` VALUES (1,'Cat1','female','2022-01-01'),(2,'Cat2','male','2018-07-20');
/*!40000 ALTER TABLE `Cats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Dogs`
--

DROP TABLE IF EXISTS `Dogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Dogs` (
  `animal_id` int NOT NULL,
  `animal_name` varchar(25) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `birth_date` date NOT NULL,
  PRIMARY KEY (`animal_id`),
  CONSTRAINT `Dogs_ibfk_1` FOREIGN KEY (`animal_id`) REFERENCES `Animals` (`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Dogs`
--

LOCK TABLES `Dogs` WRITE;
/*!40000 ALTER TABLE `Dogs` DISABLE KEYS */;
INSERT INTO `Dogs` VALUES (3,'Dog1','female','2022-05-15'),(4,'Dog2','male','2018-09-06');
/*!40000 ALTER TABLE `Dogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hamsters`
--

DROP TABLE IF EXISTS `Hamsters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Hamsters` (
  `animal_id` int NOT NULL,
  `animal_name` varchar(25) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `birth_date` date NOT NULL,
  PRIMARY KEY (`animal_id`),
  CONSTRAINT `Hamsters_ibfk_1` FOREIGN KEY (`animal_id`) REFERENCES `Animals` (`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hamsters`
--

LOCK TABLES `Hamsters` WRITE;
/*!40000 ALTER TABLE `Hamsters` DISABLE KEYS */;
INSERT INTO `Hamsters` VALUES (5,'Hamster1','female','2022-03-12'),(6,'Hamster2','male','2018-11-28');
/*!40000 ALTER TABLE `Hamsters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Horses_and_donkeys`
--

DROP TABLE IF EXISTS `Horses_and_donkeys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Horses_and_donkeys` (
  `animal_id` int NOT NULL DEFAULT '0',
  `animal_name` varchar(25) NOT NULL DEFAULT '',
  `gender` varchar(10) NOT NULL DEFAULT '',
  `birth_date` date NOT NULL,
  KEY `animals_fk` (`animal_id`),
  CONSTRAINT `animals_fk` FOREIGN KEY (`animal_id`) REFERENCES `Animals` (`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Horses_and_donkeys`
--

LOCK TABLES `Horses_and_donkeys` WRITE;
/*!40000 ALTER TABLE `Horses_and_donkeys` DISABLE KEYS */;
INSERT INTO `Horses_and_donkeys` VALUES (7,'Horse1','female','2022-02-22'),(8,'Horse2','male','2018-03-14'),(11,'Donkey1','female','2022-08-21'),(12,'Donkey2','male','2018-12-31');
/*!40000 ALTER TABLE `Horses_and_donkeys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Really_big_table`
--

DROP TABLE IF EXISTS `Really_big_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Really_big_table` (
  `an_id` int NOT NULL DEFAULT '0',
  `a_sp_id` int NOT NULL,
  `s_sp_id` int DEFAULT '0',
  `sp_name` varchar(50),
  `s_gr_id` int,
  `gr_id` int DEFAULT '0',
  `gr_name` varchar(50),
  `l_an_id` int DEFAULT '0',
  `animal_name` varchar(25) DEFAULT '',
  `gender` varchar(10) DEFAULT '',
  `birth_date` date,
  `y_an_id` int DEFAULT '0',
  `y_an_name` varchar(25) DEFAULT '',
  `y_gender` varchar(10) DEFAULT '',
  `y_b_date` date,
  `age_months` int DEFAULT NULL,
  `tr_id` int DEFAULT '0',
  `t_an_id` int,
  `tr_name` varchar(30),
  `tr_desc` varchar(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Really_big_table`
--

LOCK TABLES `Really_big_table` WRITE;
/*!40000 ALTER TABLE `Really_big_table` DISABLE KEYS */;
INSERT INTO `Really_big_table` VALUES (1,1,1,'Cat',1,1,'Pets',1,'Cat1','female','2022-01-01',1,'Cat1','female','2022-01-01',22,1,1,'wait','Cat waits for approval to eat'),(1,1,1,'Cat',1,1,'Pets',1,'Cat1','female','2022-01-01',1,'Cat1','female','2022-01-01',22,2,1,'snake','Cats walking between your legs each time you make a step'),(2,1,1,'Cat',1,1,'Pets',2,'Cat2','male','2018-07-20',NULL,NULL,NULL,NULL,NULL,3,2,'high-five','Cat gives you a high-five with its paw'),(3,2,2,'Dog',1,1,'Pets',3,'Dog1','female','2022-05-15',3,'Dog1','female','2022-05-15',18,4,3,'sit','Dog sits down as you command'),(3,2,2,'Dog',1,1,'Pets',3,'Dog1','female','2022-05-15',3,'Dog1','female','2022-05-15',18,5,3,'come close','Dog comes close to you'),(4,2,2,'Dog',1,1,'Pets',4,'Dog2','male','2018-09-06',NULL,NULL,NULL,NULL,NULL,6,4,'lay down','Dog lays down as you command'),(5,3,3,'Hamster',1,1,'Pets',5,'Hamster1','female','2022-03-12',5,'Hamster1','female','2022-03-12',20,7,5,'exist','Hamster performs a trick of existense in the universe'),(6,3,3,'Hamster',1,1,'Pets',6,'Hamster2','male','2018-11-28',NULL,NULL,NULL,NULL,NULL,8,6,'die','Hamster acts dead until you feed it'),(7,4,4,'Horse',2,2,'Draft animals',7,'Horse1','female','2022-02-22',7,'Horse1','female','2022-02-22',21,NULL,NULL,NULL,NULL),(8,4,4,'Horse',2,2,'Draft animals',8,'Horse2','male','2018-03-14',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,6,6,'Donkey',2,2,'Draft animals',11,'Donkey1','female','2022-08-21',11,'Donkey1','female','2022-08-21',15,NULL,NULL,NULL,NULL),(12,6,6,'Donkey',2,2,'Draft animals',12,'Donkey2','male','2018-12-31',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `Really_big_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Species`
--

DROP TABLE IF EXISTS `Species`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Species` (
  `sp_id` int NOT NULL AUTO_INCREMENT,
  `sp_name` varchar(50) NOT NULL,
  `gr_id` int NOT NULL,
  PRIMARY KEY (`sp_id`),
  UNIQUE KEY `sp_name` (`sp_name`),
  KEY `gr_id` (`gr_id`),
  CONSTRAINT `Species_ibfk_1` FOREIGN KEY (`gr_id`) REFERENCES `Animal_groups` (`gr_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Species`
--

LOCK TABLES `Species` WRITE;
/*!40000 ALTER TABLE `Species` DISABLE KEYS */;
INSERT INTO `Species` VALUES (1,'Cat',1),(2,'Dog',1),(3,'Hamster',1),(4,'Horse',2),(6,'Donkey',2);
/*!40000 ALTER TABLE `Species` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tricks`
--

DROP TABLE IF EXISTS `Tricks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tricks` (
  `tr_id` int NOT NULL AUTO_INCREMENT,
  `animal_id` int NOT NULL,
  `tr_name` varchar(30) NOT NULL,
  `tr_desc` varchar(100) NOT NULL,
  PRIMARY KEY (`tr_id`),
  KEY `animal_id` (`animal_id`),
  CONSTRAINT `Tricks_ibfk_1` FOREIGN KEY (`animal_id`) REFERENCES `Animals` (`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tricks`
--

LOCK TABLES `Tricks` WRITE;
/*!40000 ALTER TABLE `Tricks` DISABLE KEYS */;
INSERT INTO `Tricks` VALUES (1,1,'wait','Cat waits for approval to eat'),(2,1,'snake','Cats walking between your legs each time you make a step'),(3,2,'high-five','Cat gives you a high-five with its paw'),(4,3,'sit','Dog sits down as you command'),(5,3,'come close','Dog comes close to you'),(6,4,'lay down','Dog lays down as you command'),(7,5,'exist','Hamster performs a trick of existense in the universe'),(8,6,'die','Hamster acts dead until you feed it');
/*!40000 ALTER TABLE `Tricks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Young_animals`
--

DROP TABLE IF EXISTS `Young_animals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Young_animals` (
  `animal_id` int NOT NULL DEFAULT '0',
  `animal_name` varchar(25) NOT NULL DEFAULT '',
  `gender` varchar(10) NOT NULL DEFAULT '',
  `birth_date` date NOT NULL,
  `age` int DEFAULT NULL,
  KEY `an_id_fk` (`animal_id`),
  CONSTRAINT `an_id_fk` FOREIGN KEY (`animal_id`) REFERENCES `Animals` (`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Young_animals`
--

LOCK TABLES `Young_animals` WRITE;
/*!40000 ALTER TABLE `Young_animals` DISABLE KEYS */;
INSERT INTO `Young_animals` VALUES (1,'Cat1','female','2022-01-01',22),(3,'Dog1','female','2022-05-15',18),(5,'Hamster1','female','2022-03-12',20),(7,'Horse1','female','2022-02-22',21),(11,'Donkey1','female','2022-08-21',15);
/*!40000 ALTER TABLE `Young_animals` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-29 23:50:18
