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
  `id_instrutor` int(11) DEFAULT NULL,
  `prev_fim` date DEFAULT NULL,
  `prev_comeco` date DEFAULT NULL,
  `formato` enum('Presencial','Online','Hibrido') DEFAULT NULL,
  PRIMARY KEY (`id_cadastro`),
  KEY `FK_EquipeTreinoCad` (`id_equipe`),
  KEY `FK_TreinoEquipeCad` (`id_treinamento`),
  KEY `FK_InstrutorCad` (`id_instrutor`),
  CONSTRAINT `FK_EquipeTreinoCad` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id_equipe`),
  CONSTRAINT `FK_InstrutorCad` FOREIGN KEY (`id_instrutor`) REFERENCES `funcionario` (`id_funcionario`),
  CONSTRAINT `FK_TreinoEquipeCad` FOREIGN KEY (`id_treinamento`) REFERENCES `treinamento` (`id_treinamento`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastro_equipe_treinamento`
--

LOCK TABLES `cadastro_equipe_treinamento` WRITE;
/*!40000 ALTER TABLE `cadastro_equipe_treinamento` DISABLE KEYS */;
INSERT INTO `cadastro_equipe_treinamento` VALUES (48,8,5,15,'2024-11-30','2024-11-10','Presencial');
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
  KEY `FK_FuncionarioCad` (`id_funcionario`),
  KEY `FK_EquipeCad` (`id_equipe`),
  CONSTRAINT `FK_EquipeCad` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id_equipe`),
  CONSTRAINT `FK_FuncionarioCad` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastro_funcionario_equipe`
--

LOCK TABLES `cadastro_funcionario_equipe` WRITE;
/*!40000 ALTER TABLE `cadastro_funcionario_equipe` DISABLE KEYS */;
INSERT INTO `cadastro_funcionario_equipe` VALUES (40,12,8),(41,13,8),(42,15,8);
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
  `nome_eqp` varchar(30) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `turno` enum('matutino','vespertino','noturno') DEFAULT NULL,
  PRIMARY KEY (`id_equipe`),
  UNIQUE KEY `nome` (`nome_eqp`),
  UNIQUE KEY `nome_eqp` (`nome_eqp`),
  UNIQUE KEY `nome_eqp_2` (`nome_eqp`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES (8,'Patrulha Falta d\'água 01','Equipe do matutino','matutino'),(9,'Patrulha Falta d\'água 02','Equipe do vespertino','vespertino'),(10,'Patrulha Falta d\'água 03','Equipe do noturno','noturno');
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
  `CPF` varchar(14) DEFAULT NULL,
  `nome_func` varchar(20) DEFAULT NULL,
  `sobrenome` varchar(30) DEFAULT NULL,
  `Telefone` varchar(15) DEFAULT NULL,
  `email` varchar(320) DEFAULT NULL,
  `turno` enum('matutino','vespertino','noturno') DEFAULT NULL,
  `data_adimissao` date DEFAULT current_timestamp(),
  `cargo` enum('supervisor','instrutor','operador') DEFAULT NULL,
  `id_setor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `email` (`email`),
  KEY `FK_SetorFuncionario` (`id_setor`),
  CONSTRAINT `FK_SetorFuncionario` FOREIGN KEY (`id_setor`) REFERENCES `setor` (`id_setor`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (12,'123.456.789-98','Claudio','Roberto','(27) 99999-9999','emaildele','noturno','2024-11-18','operador',4),(13,'987.987.789-98','Cleberson','Moura','(78) 97897-8978','emaiclebin','noturno','2024-11-18','operador',4),(14,'123.456.789-10','Erivelton','Silva','(27) 94002-8922','veltin@gmail.com','matutino','2024-11-18','supervisor',3),(15,'889.564.851-32','Sergio','Silva','(85) 85258-6455','Sergio@gmail.com','matutino','2024-11-18','instrutor',3),(16,'784.545.121-24','Thiago','Alamon','(35) 79518-6421','Thiago@gmail.com','vespertino','2024-11-18','instrutor',4);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setor`
--

DROP TABLE IF EXISTS `setor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setor` (
  `id_setor` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) DEFAULT NULL,
  `sigla` char(3) DEFAULT NULL,
  PRIMARY KEY (`id_setor`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setor`
--

LOCK TABLES `setor` WRITE;
/*!40000 ALTER TABLE `setor` DISABLE KEYS */;
INSERT INTO `setor` VALUES (1,'Recursos Humanos','RH'),(2,'Administração','ADM'),(3,'Automação','ATM'),(4,'teleatendimento','TLA'),(6,'VENDAS','VND'),(7,'Financeiro','FNC'),(8,'MARKETING','MTK');
/*!40000 ALTER TABLE `setor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treinamento`
--

DROP TABLE IF EXISTS `treinamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treinamento` (
  `id_treinamento` int(11) NOT NULL AUTO_INCREMENT,
  `nome_treino` varchar(30) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `carga_Horaria` int(11) DEFAULT NULL,
  `validade` int(3) DEFAULT NULL,
  PRIMARY KEY (`id_treinamento`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treinamento`
--

LOCK TABLES `treinamento` WRITE;
/*!40000 ALTER TABLE `treinamento` DISABLE KEYS */;
INSERT INTO `treinamento` VALUES (5,'Falta d\'água','Ensinamentos falta de água',1,80),(7,'Manutençao da rb prafus','Rebimboca da parafuseta',40,2);
/*!40000 ALTER TABLE `treinamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `tipo_usuario` enum('admin','operador','supervisor') DEFAULT 'operador',
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'login','login','admin');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vw_cadeqptreino`
--

DROP TABLE IF EXISTS `vw_cadeqptreino`;
/*!50001 DROP VIEW IF EXISTS `vw_cadeqptreino`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_cadeqptreino` AS SELECT 
 1 AS `id_equipe`,
 1 AS `id_treinamento`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_cadfunceqp`
--

DROP TABLE IF EXISTS `vw_cadfunceqp`;
/*!50001 DROP VIEW IF EXISTS `vw_cadfunceqp`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_cadfunceqp` AS SELECT 
 1 AS `id_equipe`,
 1 AS `id_funcionario`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_dadosfuncionario`
--

DROP TABLE IF EXISTS `vw_dadosfuncionario`;
/*!50001 DROP VIEW IF EXISTS `vw_dadosfuncionario`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_dadosfuncionario` AS SELECT 
 1 AS `id_funcionario`,
 1 AS `cpf`,
 1 AS `nome_func`,
 1 AS `sobrenome`,
 1 AS `telefone`,
 1 AS `email`,
 1 AS `turno`,
 1 AS `cargo`,
 1 AS `setor`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_equipe`
--

DROP TABLE IF EXISTS `vw_equipe`;
/*!50001 DROP VIEW IF EXISTS `vw_equipe`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_equipe` AS SELECT 
 1 AS `id_equipe`,
 1 AS `nome_eqp`,
 1 AS `turno`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_funcionario`
--

DROP TABLE IF EXISTS `vw_funcionario`;
/*!50001 DROP VIEW IF EXISTS `vw_funcionario`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_funcionario` AS SELECT 
 1 AS `id_funcionario`,
 1 AS `cpf`,
 1 AS `nome_completo`,
 1 AS `telefone`,
 1 AS `email`,
 1 AS `turno`,
 1 AS `cargo`,
 1 AS `setor`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_getid_instrutor`
--

DROP TABLE IF EXISTS `vw_getid_instrutor`;
/*!50001 DROP VIEW IF EXISTS `vw_getid_instrutor`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_getid_instrutor` AS SELECT 
 1 AS `id_instrutor`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_getid_setor`
--

DROP TABLE IF EXISTS `vw_getid_setor`;
/*!50001 DROP VIEW IF EXISTS `vw_getid_setor`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_getid_setor` AS SELECT 
 1 AS `id_setor`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_nomeinst`
--

DROP TABLE IF EXISTS `vw_nomeinst`;
/*!50001 DROP VIEW IF EXISTS `vw_nomeinst`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_nomeinst` AS SELECT 
 1 AS `nome_completo`,
 1 AS `id_inst`,
 1 AS `treino_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_setor`
--

DROP TABLE IF EXISTS `vw_setor`;
/*!50001 DROP VIEW IF EXISTS `vw_setor`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_setor` AS SELECT 
 1 AS `sigla`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_treinamento`
--

DROP TABLE IF EXISTS `vw_treinamento`;
/*!50001 DROP VIEW IF EXISTS `vw_treinamento`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_treinamento` AS SELECT 
 1 AS `id_treino`,
 1 AS `nome`,
 1 AS `carga_horaria`,
 1 AS `validade`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_treinofunc`
--

DROP TABLE IF EXISTS `vw_treinofunc`;
/*!50001 DROP VIEW IF EXISTS `vw_treinofunc`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_treinofunc` AS SELECT 
 1 AS `id_treino`,
 1 AS `nome`,
 1 AS `id_funcionario`,
 1 AS `nome_completo`,
 1 AS `prev_fim`,
 1 AS `validade`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vw_cadeqptreino`
--

/*!50001 DROP VIEW IF EXISTS `vw_cadeqptreino`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_cadeqptreino` AS select `equipe`.`id_equipe` AS `id_equipe`,`treinamento`.`id_treinamento` AS `id_treinamento` from (`equipe` left join (`cadastro_equipe_treinamento` left join `treinamento` on(`cadastro_equipe_treinamento`.`id_treinamento` = `treinamento`.`id_treinamento`)) on(`cadastro_equipe_treinamento`.`id_equipe` = `equipe`.`id_equipe`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_cadfunceqp`
--

/*!50001 DROP VIEW IF EXISTS `vw_cadfunceqp`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_cadfunceqp` AS select `equipe`.`id_equipe` AS `id_equipe`,`funcionario`.`id_funcionario` AS `id_funcionario` from ((`equipe` left join `cadastro_funcionario_equipe` on(`cadastro_funcionario_equipe`.`id_equipe` = `equipe`.`id_equipe`)) left join `funcionario` on(`cadastro_funcionario_equipe`.`id_funcionario` = `funcionario`.`id_funcionario`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_dadosfuncionario`
--

/*!50001 DROP VIEW IF EXISTS `vw_dadosfuncionario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_dadosfuncionario` AS select `funcionario`.`id_funcionario` AS `id_funcionario`,`funcionario`.`CPF` AS `cpf`,`funcionario`.`nome_func` AS `nome_func`,`funcionario`.`sobrenome` AS `sobrenome`,`funcionario`.`Telefone` AS `telefone`,`funcionario`.`email` AS `email`,`funcionario`.`turno` AS `turno`,`funcionario`.`cargo` AS `cargo`,`setor`.`sigla` AS `setor` from (`funcionario` join `setor` on(`funcionario`.`id_setor` = `setor`.`id_setor`)) */
/*!50002 WITH CASCADED CHECK OPTION */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_equipe`
--

/*!50001 DROP VIEW IF EXISTS `vw_equipe`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_equipe` AS select `equipe`.`id_equipe` AS `id_equipe`,`equipe`.`nome_eqp` AS `nome_eqp`,`equipe`.`turno` AS `turno` from `equipe` */
/*!50002 WITH CASCADED CHECK OPTION */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_funcionario`
--

/*!50001 DROP VIEW IF EXISTS `vw_funcionario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_funcionario` AS select `funcionario`.`id_funcionario` AS `id_funcionario`,`funcionario`.`CPF` AS `cpf`,concat(`funcionario`.`nome_func`,' ',`funcionario`.`sobrenome`) AS `nome_completo`,`funcionario`.`Telefone` AS `telefone`,`funcionario`.`email` AS `email`,`funcionario`.`turno` AS `turno`,`funcionario`.`cargo` AS `cargo`,`setor`.`sigla` AS `setor` from (`funcionario` join `setor` on(`funcionario`.`id_setor` = `setor`.`id_setor`)) */
/*!50002 WITH CASCADED CHECK OPTION */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_getid_instrutor`
--

/*!50001 DROP VIEW IF EXISTS `vw_getid_instrutor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_getid_instrutor` AS select `funcionario`.`id_funcionario` AS `id_instrutor` from `funcionario` where `funcionario`.`cargo` like 'instrutor' */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_getid_setor`
--

/*!50001 DROP VIEW IF EXISTS `vw_getid_setor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_getid_setor` AS select `setor`.`id_setor` AS `id_setor` from `setor` */
/*!50002 WITH CASCADED CHECK OPTION */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_nomeinst`
--

/*!50001 DROP VIEW IF EXISTS `vw_nomeinst`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_nomeinst` AS select `vw_funcionario`.`nome_completo` AS `nome_completo`,`vw_funcionario`.`id_funcionario` AS `id_inst`,`cadastro_equipe_treinamento`.`id_treinamento` AS `treino_id` from (`cadastro_equipe_treinamento` join `vw_funcionario` on(`vw_funcionario`.`id_funcionario` = `cadastro_equipe_treinamento`.`id_instrutor`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_setor`
--

/*!50001 DROP VIEW IF EXISTS `vw_setor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_setor` AS select `setor`.`sigla` AS `sigla` from `setor` */
/*!50002 WITH CASCADED CHECK OPTION */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_treinamento`
--

/*!50001 DROP VIEW IF EXISTS `vw_treinamento`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_treinamento` AS select `treinamento`.`id_treinamento` AS `id_treino`,`treinamento`.`nome_treino` AS `nome`,`treinamento`.`carga_Horaria` AS `carga_horaria`,`treinamento`.`validade` AS `validade` from `treinamento` */
/*!50002 WITH CASCADED CHECK OPTION */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_treinofunc`
--

/*!50001 DROP VIEW IF EXISTS `vw_treinofunc`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_treinofunc` AS select `vw_treinamento`.`id_treino` AS `id_treino`,`vw_treinamento`.`nome` AS `nome`,`vw_cadfunceqp`.`id_funcionario` AS `id_funcionario`,`vw_nomeinst`.`nome_completo` AS `nome_completo`,`cadastro_equipe_treinamento`.`prev_fim` AS `prev_fim`,`vw_treinamento`.`validade` AS `validade` from ((`vw_cadfunceqp` left join (`cadastro_equipe_treinamento` left join `vw_treinamento` on(`cadastro_equipe_treinamento`.`id_treinamento` = `vw_treinamento`.`id_treino`)) on(`cadastro_equipe_treinamento`.`id_equipe` = `vw_cadfunceqp`.`id_equipe`)) join `vw_nomeinst` on(`cadastro_equipe_treinamento`.`id_treinamento` = `vw_nomeinst`.`treino_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-18 14:16:11
