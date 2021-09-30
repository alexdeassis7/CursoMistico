DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `idreview` int unsigned NOT NULL AUTO_INCREMENT,
  `rating` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `user` varchar(45) DEFAULT NULL,
  `comment` mediumtext,
  `film` tinyint DEFAULT NULL,
  PRIMARY KEY (`idreview`)
)