CREATE DATABASE  IF NOT EXISTS `db_agenda_curso` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `db_agenda_curso`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_agenda_curso
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
-- Table structure for table `cadastro_equipe_treinamento`
--

DROP TABLE IF EXISTS `cadastro_equipe_treinamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadastro_equipe_treinamento` (
  `id_cadastro` int(11) NOT NULL AUTO_INCREMENT,
  `id_equipe` int(11) DEFAULT NULL,
  `id_treinamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_cadastro`),
  KEY `id_equipe` (`id_equipe`),
  KEY `id_treinamento` (`id_treinamento`),
  CONSTRAINT `cadastro_equipe_treinamento_ibfk_1` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id_equipe`),
  CONSTRAINT `cadastro_equipe_treinamento_ibfk_2` FOREIGN KEY (`id_treinamento`) REFERENCES `treinamento` (`id_treinamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastro_equipe_treinamento`
--

LOCK TABLES `cadastro_equipe_treinamento` WRITE;
/*!40000 ALTER TABLE `cadastro_equipe_treinamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `cadastro_equipe_treinamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadastro_funcionario_equipe`
--

DROP TABLE IF EXISTS `cadastro_funcionario_equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadastro_funcionario_equipe` (
  `id_cadastro` int(11) NOT NULL AUTO_INCREMENT,
  `id_funcionario` int(11) DEFAULT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_cadastro`),
  KEY `id_funcionario` (`id_funcionario`),
  KEY `id_equipe` (`id_equipe`),
  CONSTRAINT `cadastro_funcionario_equipe_ibfk_1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`),
  CONSTRAINT `cadastro_funcionario_equipe_ibfk_2` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id_equipe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastro_funcionario_equipe`
--

LOCK TABLES `cadastro_funcionario_equipe` WRITE;
/*!40000 ALTER TABLE `cadastro_funcionario_equipe` DISABLE KEYS */;
/*!40000 ALTER TABLE `cadastro_funcionario_equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipe` (
  `id_equipe` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(15) DEFAULT NULL,
  `dt_criacao` date DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `setor` enum('ADM','RH','ATM','ESC') DEFAULT NULL,
  `id_instrutor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_equipe`),
  KEY `id_instrutor` (`id_instrutor`),
  CONSTRAINT `equipe_ibfk_1` FOREIGN KEY (`id_instrutor`) REFERENCES `funcionario` (`id_funcionario`)
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
  `id_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `CPF` varchar(11) DEFAULT NULL,
  `nome` varchar(20) DEFAULT NULL,
  `sobrenome` varchar(30) DEFAULT NULL,
  `Telefone` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `setor` enum('ADM','RH','ATM','ESC') DEFAULT NULL,
  `turno` enum('matutino','vespertino','noturno') DEFAULT NULL,
  `data_adimissao` date DEFAULT current_timestamp(),
  `cargo` enum('supervisor','funcionario','instrutor') DEFAULT NULL,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `email` (`email`)
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
-- Table structure for table `treinamento`
--

DROP TABLE IF EXISTS `treinamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treinamento` (
  `id_treinamento` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `carga_Horaria` time DEFAULT NULL,
  `duracao` int(3) DEFAULT NULL,
  `formato` enum('Presencial','Online','Hibrido') DEFAULT NULL,
  `localidade` enum('1','2','3','4','5') DEFAULT NULL,
  `prev_comeco` date DEFAULT NULL,
  `prev_fim` date DEFAULT NULL,
  PRIMARY KEY (`id_treinamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treinamento`
--

LOCK TABLES `treinamento` WRITE;
/*!40000 ALTER TABLE `treinamento` DISABLE KEYS */;
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

-- Dump completed on 2024-11-01 19:03:22
