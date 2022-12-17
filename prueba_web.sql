CREATE DATABASE  IF NOT EXISTS `prueba_web` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `prueba_web`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: prueba_web
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
-- Table structure for table `accesos_usuario`
--

DROP TABLE IF EXISTS `accesos_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accesos_usuario` (
  `idacc` int NOT NULL AUTO_INCREMENT,
  `idopc` int DEFAULT NULL,
  `idusr` int DEFAULT NULL,
  PRIMARY KEY (`idacc`),
  KEY `idopcc_idx` (`idopc`),
  KEY `idusr_idx` (`idusr`),
  CONSTRAINT `idopcc` FOREIGN KEY (`idopc`) REFERENCES `opciones_menu` (`idopc`),
  CONSTRAINT `idusr` FOREIGN KEY (`idusr`) REFERENCES `usuarios` (`idusr`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accesos_usuario`
--

LOCK TABLES `accesos_usuario` WRITE;
/*!40000 ALTER TABLE `accesos_usuario` DISABLE KEYS */;
INSERT INTO `accesos_usuario` VALUES (1,1,1),(2,2,1),(3,4,1),(4,1,2),(5,3,2);
/*!40000 ALTER TABLE `accesos_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opciones_menu`
--

DROP TABLE IF EXISTS `opciones_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opciones_menu` (
  `idopc` int NOT NULL AUTO_INCREMENT,
  `etiqueta` varchar(100) DEFAULT NULL,
  `comando` varchar(500) DEFAULT NULL,
  `estado` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`idopc`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opciones_menu`
--

LOCK TABLES `opciones_menu` WRITE;
/*!40000 ALTER TABLE `opciones_menu` DISABLE KEYS */;
INSERT INTO `opciones_menu` VALUES (1,'Mantenimiento de Usuarios','...','ACT'),(2,'Mantenimiento de Opciones','...','INA'),(3,'Mantenimiento de Roles','...','ACT'),(4,'Mantenimiento de Permisos','...','ACT');
/*!40000 ALTER TABLE `opciones_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idrol` int NOT NULL AUTO_INCREMENT,
  `idusr` int DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrol`),
  KEY `id_rol_usuario_idx` (`idusr`),
  CONSTRAINT `id_rol_usuario` FOREIGN KEY (`idusr`) REFERENCES `usuarios` (`idusr`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,1,'ROLE_ADMIN'),(2,1,'ROLE_USER'),(3,2,'ROLE_USER'),(5,NULL,'ROLE_ADMIN'),(6,NULL,'ROLE_USER');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idusr` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(10) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `clave` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`idusr`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'JPEREZ','Juan Perez','$2a$10$6hQ6N9SG6Tem0AWKMv8uCOxq.SuqA5r3z9UAvGsX1Orkg0a3IP/CS'),(2,'MRECINOS','Monica Recinos','$2a$10$6hQ6N9SG6Tem0AWKMv8uCOxq.SuqA5r3z9UAvGsX1Orkg0a3IP/CS'),(5,'katy','Kathy','$2a$10$u01wrXtdZxYEU47XWW6Tqu6wPhC8SantlwRt/WOJXj0gnQFW3ufri'),(6,'edwin','Edwin','$2a$10$ZeZ.Hfs4kOhIUr0FC9kcEOxqJS0NRYxPEA22WYVPPvaUCijL.TXIO');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'prueba_web'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-16 23:16:59
