-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: agenda_curso
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipe` (
  `id_equipe` int(11) NOT NULL AUTO_INCREMENT,
  `id_funcionario_equipe` int(11) DEFAULT NULL,
  `id_instrutor_equipe` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_equipe`),
  KEY `id_instrutor_equipe` (`id_instrutor_equipe`),
  KEY `id_funcionario_equipe` (`id_funcionario_equipe`),
  CONSTRAINT `equipe_ibfk_1` FOREIGN KEY (`id_instrutor_equipe`) REFERENCES `instrutor` (`id_instrutor`),
  CONSTRAINT `equipe_ibfk_2` FOREIGN KEY (`id_funcionario_equipe`) REFERENCES `funcionario` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `matricula` int(11) NOT NULL AUTO_INCREMENT,
  `nome_funcionario` varchar(50) DEFAULT NULL,
  `sobre_nome` varchar(50) DEFAULT NULL,
  `Telefone_funcionario` int(11) DEFAULT NULL,
  `Email_funcionario` varchar(50) DEFAULT NULL,
  `setor` varchar(50) DEFAULT NULL,
  `turno` enum('Matutino','Vespertino','Noturno') DEFAULT NULL,
  `data_adimissao` date DEFAULT NULL,
  `cargo_funcionario` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrutor`
--

DROP TABLE IF EXISTS `instrutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instrutor` (
  `id_instrutor` int(11) NOT NULL AUTO_INCREMENT,
  `nome_instrutor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_instrutor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrutor`
--

LOCK TABLES `instrutor` WRITE;
/*!40000 ALTER TABLE `instrutor` DISABLE KEYS */;
INSERT INTO `instrutor` VALUES (1,'Cristiano'),(2,'Ronaldo'),(3,'Cristiano'),(4,'Ronaldo');
/*!40000 ALTER TABLE `instrutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treinamento`
--

DROP TABLE IF EXISTS `treinamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treinamento` (
  `id_treinamento` int(11) NOT NULL AUTO_INCREMENT,
  `Local_treinamento` varchar(50) DEFAULT NULL,
  `Treinamento_aplicado` varchar(50) DEFAULT NULL,
  `Horario_prev_comeco` date DEFAULT NULL,
  `Horario_prev_fim` date DEFAULT NULL,
  `id_equipe_treinamento` int(11) DEFAULT NULL,
  `id_instrutor_treinamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_treinamento`),
  KEY `id_equipe_treinamento` (`id_equipe_treinamento`),
  KEY `id_instrutor_treinamento` (`id_instrutor_treinamento`),
  CONSTRAINT `treinamento_ibfk_1` FOREIGN KEY (`id_equipe_treinamento`) REFERENCES `equipe` (`id_equipe`),
  CONSTRAINT `treinamento_ibfk_2` FOREIGN KEY (`id_instrutor_treinamento`) REFERENCES `instrutor` (`id_instrutor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treinamento`
--

LOCK TABLES `treinamento` WRITE;
/*!40000 ALTER TABLE `treinamento` DISABLE KEYS */;
INSERT INTO `treinamento` VALUES (1,'Rua_travessa jose veloso','Segurança','2024-10-19','2024-10-25',NULL,NULL),(2,'Rua_travessa jose veloso','Segurança','2024-10-19','2024-10-25',NULL,NULL);
/*!40000 ALTER TABLE `treinamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-28 19:34:04
