-- MySQL dump 10.13  Distrib 8.0.31, for Linux (x86_64)
--
-- Host: localhost    Database: Universita
-- ------------------------------------------------------
-- Server version	8.0.31-0ubuntu0.20.04.2

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
-- Table structure for table `Corso`
--

DROP TABLE IF EXISTS `Corso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Corso` (
  `Codice` char(10) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Facolta` varchar(50) NOT NULL,
  `CFU` int NOT NULL,
  `Docenti` int DEFAULT '0',
  PRIMARY KEY (`Codice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Corso`
--

LOCK TABLES `Corso` WRITE;
/*!40000 ALTER TABLE `Corso` DISABLE KEYS */;
INSERT INTO `Corso` VALUES ('0312600006','Filologia Italiana','Lettere',6,1),('0312600010','Geografia','Lettere',12,1),('0512100008','Basi di Dati','Informatica',9,1),('0512100053','Programmazione Object Oriented','Informatica',9,1),('0512400005','Chimica Generale e Inorganica','Chimica',12,1),('0512400006','Chimica Inorganica I','Chimica',12,1),('0512400026','Chimica Forense','Chimica',6,1),('0512700003','Botanica','Scienze Ambientali',8,1),('0512700011','Biochimica e Microbiologia','Scienze Ambientali',12,1),('0522500029','Intelligent Web','Informatica',6,1),('0522500072','Reti Sociali','Computer Science',9,1),('0522500075','Cybersecurity','Computer Science',9,1),('0522500093','Intelligenza Artificiale','Computer Science',9,1),('0612100005','Disegno','Ingegneria Civile',9,1),('0612100007','Architettura Tecnica','Ingegneria Civile',12,1),('0622100011','Riabilitazione Strutturale','Ingegneria Civile',6,1),('0660100002','Geometria','Ingegneria Edile-Architettura',6,1),('0660100005','Architettura e Composizione Architettonica I','Ingegneria Edile-Architettura',12,1),('0712100020','Chimica Degli Alimenti','Tecniche Erboristiche',10,1),('0712100038','Biochimica e Genetica Agraria','Tecniche Erboristiche',9,1),('0760100018','Biochimica Applicata','Farmacia',5,1),('0760100023','Chimica Farmaceutica II','Farmacia',10,1),('0760200032','Biologia Molecolare','Chimica e Tecnologia Farmaceutiche',5,1),('0760200055','Chimica Analitica e Chimica Fisica','Chimica e Tecnologia Farmaceutiche',9,1),('4312200008','Letteratura Inglese I','Lingue e Culture Straniere',9,1),('4312200035','Storia Contemporanea','Lingue e Culture Straniere',6,1),('4312200049','Filologia Germanica','Lingue e Culture Straniere',9,1);
/*!40000 ALTER TABLE `Corso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Dipartimento`
--

DROP TABLE IF EXISTS `Dipartimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Dipartimento` (
  `Nome` varchar(50) NOT NULL,
  `Citta` varchar(50) DEFAULT NULL,
  `Via` varchar(50) DEFAULT NULL,
  `Civico` char(5) DEFAULT NULL,
  `CAP` char(5) DEFAULT NULL,
  `Provincia` varchar(5) DEFAULT NULL,
  `Docenti` int DEFAULT '0',
  PRIMARY KEY (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Dipartimento`
--

LOCK TABLES `Dipartimento` WRITE;
/*!40000 ALTER TABLE `Dipartimento` DISABLE KEYS */;
INSERT INTO `Dipartimento` VALUES ('Chimica e Biologia','Fisciano','Via Giovanni Paolo II','132','84084','SA',5),('Farmacia','Fisciano','Via Giovanni Paolo II','132','84084','SA',5),('Informatica','Fisciano','Via Giovanni Paolo II','132','84084','SA',4),('Ingegneria Civile','Fisciano','Via Giovanni Paolo II','132','84084','SA',5),('Studi Umanistici','Fisciano','Via Giovanni Paolo II','132','84084','SA',5);
/*!40000 ALTER TABLE `Dipartimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Direzione`
--

DROP TABLE IF EXISTS `Direzione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Direzione` (
  `Docente` char(10) NOT NULL,
  `Dipartimento` char(50) DEFAULT NULL,
  `DataInizio` date NOT NULL,
  PRIMARY KEY (`Docente`),
  CONSTRAINT `Direzione_ibfk_1` FOREIGN KEY (`Docente`) REFERENCES `Docente` (`Matricola`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Direzione`
--

LOCK TABLES `Direzione` WRITE;
/*!40000 ALTER TABLE `Direzione` DISABLE KEYS */;
INSERT INTO `Direzione` VALUES ('0512100002','Informatica','2021-09-01'),('0512410293','Chimica e Biologia','2020-09-01'),('0622111045','Ingegneria Civile','2018-09-01'),('0760112785','Farmacia','2020-09-01'),('4312201023','Studi Umanistici','2018-09-01');
/*!40000 ALTER TABLE `Direzione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Docente`
--

DROP TABLE IF EXISTS `Docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Docente` (
  `Matricola` char(10) NOT NULL,
  `CF` char(16) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Cognome` varchar(50) NOT NULL,
  `Nascita` date DEFAULT NULL,
  `Citta` varchar(50) DEFAULT NULL,
  `Via` varchar(50) DEFAULT NULL,
  `Civico` char(5) DEFAULT NULL,
  `CAP` char(5) DEFAULT NULL,
  `Provincia` varchar(5) DEFAULT NULL,
  `Sesso` varchar(5) NOT NULL,
  `Stipendio` float DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `InizioCarriera` date NOT NULL,
  `DataAssunzione` date DEFAULT NULL,
  `MaxOre` int DEFAULT NULL,
  `Dipartimento` varchar(50) NOT NULL,
  PRIMARY KEY (`Matricola`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Docente`
--

LOCK TABLES `Docente` WRITE;
/*!40000 ALTER TABLE `Docente` DISABLE KEYS */;
INSERT INTO `Docente` VALUES ('0312613246','SNGNTFDRC0B43514','Federico','Sanguineti',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',1850,'fsanguineti@unisa.it','2018-09-01','2019-09-01',NULL,'Studi Umanistici'),('0312654321','DFLCPRLG67V74321','Pierluigi','De Felice',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',1900,'pdefelice@unisa.it','2016-09-01',NULL,NULL,'Studi Umanistici'),('0512100000','SBLMML0011B96700','Maria Monica Lucia','Sebillo',NULL,NULL,NULL,NULL,NULL,NULL,'Donna',2000,'msebillo@unisa.it','2014-09-01',NULL,100,'Informatica'),('0512100001','DFMVNCZ0156B9710','Vincenzo','Deufemia',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',2000,'deufemia@unisa.it','2016-09-01',NULL,100,'Informatica'),('0512100002','GRGLS05VTR235FGV','Luisa','Gargano',NULL,NULL,NULL,NULL,NULL,NULL,'Donna',2500,'lgargano@unisa.it','2015-09-01','2020-09-01',NULL,'Informatica'),('0512409113','CSTBLCHR00Z43XV9','Chiara','Costabile',NULL,NULL,NULL,NULL,NULL,NULL,'Donna',2200,'ccostabile@unisa.it','2017-09-01',NULL,120,'Chimica e Biologia'),('0512410293','LNGPSQL89BF34HG5','Pasquale','Longo',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',2500,'plongo@unisa.it','2014-09-01','2018-09-01',NULL,'Chimica e Biologia'),('0512413557','VGLTTGVNN03X78V2','Giovanni','Vigliotta',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',1870,'gvigliotta@unisa.it','2012-09-01',NULL,90,'Chimica e Biologia'),('0512498677','PRGLOLSTFN78GX35','Stefania','Pragliola',NULL,NULL,NULL,NULL,NULL,NULL,'Donna',2100,'spragliola@unisa.it','2017-09-01',NULL,NULL,'Chimica e Biologia'),('0522512345','PLMRFRNCS0832100','Francesco','Palmieri',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',2100,'fpalmieri@unisa.it','2017-09-01','2018-09-01',NULL,'Informatica'),('0612112345','FRPRFRNCSC89B34G','PierFrancesco','Fiore',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',1900,'pfiore@unisa.it','2013-09-01',NULL,100,'Ingegneria Civile'),('0612113245','MSSNBRBR89BSC43G','Barbara','Messina',NULL,NULL,NULL,NULL,NULL,NULL,'Donna',1720,'bmessina@unisa.it','2018-09-01',NULL,90,'Ingegneria Civile'),('0622111045','RZZNGNVTTR78GH34','Gianvittorio','Rizzano',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',2500,'g.rizzano@unisa.it','2014-09-01','2015-09-01',NULL,'Ingegneria Civile'),('0660123121','CMLSSNDR98B34XS','Alessandra','Como',NULL,NULL,NULL,NULL,NULL,NULL,'Donna',1890,'acomo@unisa.it','2014-09-01',NULL,100,'Ingegneria Civile'),('0712109165','TSCLSSNDR78X32BN','Alessandra','Tosco',NULL,NULL,NULL,NULL,NULL,NULL,'Donna',1800,'tosco@unisa.it','2016-09-01',NULL,90,'Farmacia'),('0712177911','AMBSNALFRD78X274','Alfredo','Ambrosone',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',1800,'aambrosone@unisa.it','2014-09-01',NULL,90,'Farmacia'),('0712187654','CRSCNZCRL78VSB23','Carlo','Crescenzi',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',2100,'carlo.crescenzi@unisa.it','2017-09-01',NULL,120,'Farmacia'),('0760112785','CMPGLPTR78BF34HG','Pietro','Campiglia',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',2500,'pcampiglia@unisa.it','2013-09-01','2017-09-01',NULL,'Farmacia'),('4312201023','PNTCRMN78BD345HG','Carmine','Pinto',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',2500,'cpinto@unisa.it','2016-09-01','2017-09-01',NULL,'Studi Umanistici'),('4312201835','DGNVNNFLR67C2397','Flora','De Giovanni',NULL,NULL,NULL,NULL,NULL,NULL,'Donna',1950,'fdegiovanni@unisa.it','2014-09-01','2015-09-01',NULL,'Studi Umanistici'),('4312218403','SNTRVR03B6743G45','Verio','Santoro',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo',1900,'verios@unisa.it','2017-09-01','2018-09-01',NULL,'Studi Umanistici');
/*!40000 ALTER TABLE `Docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Esame`
--

DROP TABLE IF EXISTS `Esame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Esame` (
  `Corso` char(10) NOT NULL,
  `Studente` char(10) NOT NULL,
  `Data` date NOT NULL,
  `Voto` int NOT NULL,
  `Lode` char(2) DEFAULT NULL,
  PRIMARY KEY (`Corso`,`Studente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Esame`
--

LOCK TABLES `Esame` WRITE;
/*!40000 ALTER TABLE `Esame` DISABLE KEYS */;
INSERT INTO `Esame` VALUES ('0312600010','0312610000','2019-03-10',28,'No'),('0512100008','0512101928','2022-02-01',30,'Si'),('0512400006','0512411995','2020-12-22',25,'No'),('0512700003','0512701929','2016-02-22',30,'No'),('0522500075','0522519562','2022-10-10',26,'No'),('0612100007','0622156562','2016-02-15',26,'No'),('0660100005','0660100223','2021-01-11',30,'Si'),('0712100038','0712100002','2018-01-13',24,'No'),('0760100018','0760161616','2021-12-21',27,'No'),('0760200032','0760211112','2021-02-01',30,'Si'),('4312200049','4312222289','2021-01-21',18,'No');
/*!40000 ALTER TABLE `Esame` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Facolta`
--

DROP TABLE IF EXISTS `Facolta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Facolta` (
  `Nome` varchar(50) NOT NULL,
  `Dipartimento` varchar(50) NOT NULL,
  PRIMARY KEY (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Facolta`
--

LOCK TABLES `Facolta` WRITE;
/*!40000 ALTER TABLE `Facolta` DISABLE KEYS */;
INSERT INTO `Facolta` VALUES ('Chimica','Chimica e Biologia'),('Chimica e Tecnologia Farmaceutiche','Farmacia'),('Computer Science','Informatica'),('Farmacia','Farmacia'),('Informatica','Informatica'),('Ingegneria Civile','Ingegneria Civile'),('Ingegneria Edile-Architettura','Ingegneria Civile'),('Lettere','Studi Umanistici'),('Lingue e Culture Straniere','Studi Umanistici'),('Scienze Ambientali','Chimica e biologia'),('Tecniche Erboristiche','Farmacia');
/*!40000 ALTER TABLE `Facolta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Frequenza`
--

DROP TABLE IF EXISTS `Frequenza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Frequenza` (
  `Corso` char(10) NOT NULL,
  `Studente` char(10) NOT NULL,
  PRIMARY KEY (`Corso`,`Studente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Frequenza`
--

LOCK TABLES `Frequenza` WRITE;
/*!40000 ALTER TABLE `Frequenza` DISABLE KEYS */;
INSERT INTO `Frequenza` VALUES ('0312600006','0312610000'),('0312600010','0312610000'),('0512100008','0512101928'),('0512100053','0512101928'),('0512400006','0512411995'),('0512700003','0512701929'),('0522500029','0512101928'),('0522500075','0522519562'),('0612100007','0622156562'),('0660100005','0660100223'),('0712100038','0712100002'),('0760100018','0760161616'),('0760200032','0760211112'),('4312200049','4312222289');
/*!40000 ALTER TABLE `Frequenza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Insegnamento`
--

DROP TABLE IF EXISTS `Insegnamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Insegnamento` (
  `Corso` char(10) NOT NULL,
  `Docente` char(10) NOT NULL,
  PRIMARY KEY (`Corso`,`Docente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Insegnamento`
--

LOCK TABLES `Insegnamento` WRITE;
/*!40000 ALTER TABLE `Insegnamento` DISABLE KEYS */;
INSERT INTO `Insegnamento` VALUES ('0312600006','0312613246'),('0312600010','0312654321'),('0512100008','0512100000'),('0512100053','0512100001'),('0512400005','0512410293'),('0512400006','0512409113'),('0512400026','0512498677'),('0512700011','0512413557'),('0522500029','0512100000'),('0522500072','0512100002'),('0522500075','0522512345'),('0522500093','0512100001'),('0612100005','0612113245'),('0612100007','0612112345'),('0660100002','0622111045'),('0660100005','0660123121'),('0712100038','0712177911'),('0760100023','0760112785'),('0760200032','0712109165'),('0760200055','0712187654'),('4312200008','4312201835'),('4312200035','4312201023'),('4312200049','4312218403');
/*!40000 ALTER TABLE `Insegnamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Partecipare`
--

DROP TABLE IF EXISTS `Partecipare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Partecipare` (
  `Docente` char(10) DEFAULT NULL,
  `Progetto` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partecipare`
--

LOCK TABLES `Partecipare` WRITE;
/*!40000 ALTER TABLE `Partecipare` DISABLE KEYS */;
INSERT INTO `Partecipare` VALUES ('0312654321','A10B2'),('0512498677','A10B2'),('0312654321','C27N9'),('0512498677','C27N9');
/*!40000 ALTER TABLE `Partecipare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Progetto`
--

DROP TABLE IF EXISTS `Progetto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Progetto` (
  `Sigla` char(5) NOT NULL,
  `Nome` char(100) DEFAULT NULL,
  `Budget` float DEFAULT NULL,
  PRIMARY KEY (`Sigla`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Progetto`
--

LOCK TABLES `Progetto` WRITE;
/*!40000 ALTER TABLE `Progetto` DISABLE KEYS */;
INSERT INTO `Progetto` VALUES ('A10B2','Le recenti trasformazioni dei sistemi agricoli italiani tra concentrazine fondiaria e resilienza',19000),('C27N9','Sintesi e caratterizzazione di polimeri anfifilici per la formazione di nanoaggregati',31250);
/*!40000 ALTER TABLE `Progetto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Studente`
--

DROP TABLE IF EXISTS `Studente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Studente` (
  `Matricola` char(10) NOT NULL,
  `CF` char(16) DEFAULT NULL,
  `Nome` varchar(50) NOT NULL,
  `Cognome` varchar(50) NOT NULL,
  `Nascita` date DEFAULT NULL,
  `Citta` varchar(50) DEFAULT NULL,
  `Via` varchar(50) DEFAULT NULL,
  `Civico` char(5) DEFAULT NULL,
  `CAP` char(5) DEFAULT NULL,
  `Provincia` varchar(5) DEFAULT NULL,
  `Sesso` varchar(5) NOT NULL,
  `Immatricolazione` date DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Facolta` varchar(50) NOT NULL,
  PRIMARY KEY (`Matricola`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Studente`
--

LOCK TABLES `Studente` WRITE;
/*!40000 ALTER TABLE `Studente` DISABLE KEYS */;
INSERT INTO `Studente` VALUES ('0312601455','CPNSTLL35X35HL0H','Stella','Capuana',NULL,NULL,NULL,NULL,NULL,NULL,'Donna','2017-09-28','s.capuana@studenti.unisa.it','Lettere'),('0312610000','RSSMR01B7834G54','Mario','Rossi',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo','2018-09-10','m.rossi@studenti.unisa.it','Lettere'),('0512101928','FNTNCNCTT35C35H9','Concetta','Fantini','1999-04-01','Pozzuoli','Via Luciano','10','8078','NA','Donna','2021-09-01','c.fantini@studenti.unisa.it','Informatica'),('0512112110','RNLCMN00P05B963G','Carmine','Renella',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo','2020-09-28','c.renella@studenti.unisa.it','Informatica'),('0512411995','MNDZZMRC78G43H7J','Mirco','Monduzzi',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo','2020-09-03','m.monduzzi@studenti.unisa.it','Chimica'),('0512489347','DDLGN2G89SCVHIO2','Luigina','Duodo',NULL,NULL,NULL,NULL,NULL,NULL,'Donna','2015-09-03','l.duodo@studenti.unisa.it','Chimica'),('0512701929','SPNVLLGCM0IO25DS','Giacomo','Spanevello',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo','2014-09-01','g.spanevello@studenti.unisa.it','Scienze Ambientali'),('0512723322','CHGADL34H89HS53X','Adele','Chigi',NULL,NULL,NULL,NULL,NULL,NULL,'Donna','2016-09-30','a.chigi@studenti.unisa.it','Scienze Ambientali'),('0522519562','VRDGSPP08B25F346','Giuseppe','Verdi',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo','2020-09-03','g.verdi@studenti.unisa.it','Computer Science'),('0522578934','CMLC78C34H23Z7DD','Lucia','Combi',NULL,NULL,NULL,NULL,NULL,NULL,'Donna','2018-09-09','l.combi@studenti.unisa.it','Computer Science'),('0622156561','MLCRNLMBRTC78D2G','Lamberto','Malacarne','2001-12-28','Caserta','Via Roma','5A','81100','CE','Uomo','2016-09-10','l.malacarne@studenti.unisa.it','Ingegneria Civile'),('0622156562','SLGRADLS78C534H5','Adelasia','Salgari',NULL,NULL,NULL,NULL,NULL,NULL,'Donna','2014-09-01','a.salgari@studenti.unisa.it','Ingegneria Civile'),('0660100223','BRRAMC78GH547F3G','Amico','Berrè',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo','2020-09-10','a.berrè@studenti.unisa.it','Ingegneria Edile-Architettura'),('0660112000','TRVHLSLVTR78GF54','Salvatore','Travaglio',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo','2017-09-03','s.travaglio@studenti.unisa.it','Ingegneria Edile-Architettura'),('0712100001','NGLILLASSA984B76','Alessia','Angiolello','1998-03-08','Maddaloni','Via Cucciarella','8','81024','CE','Donna','2021-09-03','a.angiolello@studenti.unisa.it','Tecniche Erboristiche'),('0712100002','RMGNLNN08GE25H8S','Nino','Romagnoli',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo','2017-09-23','n.romagnoli@studenti.unisa.it','Tecniche Erboristiche'),('0760113131','LBNLSA9C79BSG3G8','Elisa','Alboni','1997-05-13','Castellammare di Stabia','Via Nocera','4','80053','NA','Donna','2018-09-22','e.alboni@studenti.unisa.it','Farmacia'),('0760161616','FGGNGCBB87B45HX4','Giacobbe','Faggiani',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo','2021-09-28','g.faggiani@studenti.unisa.it','Farmacia'),('0760211111','VGDRLF0B353BJSV7','Alfio','Avogadro','2002-06-01','Afragola','Via Cirillo','27','80021','NA','Uomo','2017-09-05','a.avogadro@studenti.unisa.it','Chimica e Tecnologia Farmaceutiche'),('0760211112','RCCTCSSNDR825DHJ','Cassandra','Riccati',NULL,NULL,NULL,NULL,NULL,NULL,'Donna','2020-09-25','@studenti.unisa.it','Chimica e Tecnologia Farmaceutiche'),('4312222289','MRPRGMLSS35DCG89','Melissa','Morpurgo',NULL,NULL,NULL,NULL,NULL,NULL,'Donna','2021-09-11','m.morpurgo@studenti.unisa.it','Lingue e Culture Straniere'),('4312298633','FVTCLCC86SG35D2','Coluccio','Favata',NULL,NULL,NULL,NULL,NULL,NULL,'Uomo','2019-09-02','c.favata@studenti.unisa.it','Lingue e Culture Straniere');
/*!40000 ALTER TABLE `Studente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TelDocenti`
--

DROP TABLE IF EXISTS `TelDocenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TelDocenti` (
  `Numero` char(10) NOT NULL,
  `Docente` char(10) DEFAULT NULL,
  PRIMARY KEY (`Numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TelDocenti`
--

LOCK TABLES `TelDocenti` WRITE;
/*!40000 ALTER TABLE `TelDocenti` DISABLE KEYS */;
INSERT INTO `TelDocenti` VALUES ('0512100002','3216349576'),('0512410293','3467763546'),('0622111045','3331827467'),('0760112785','3470019274'),('4312201023','3133765477');
/*!40000 ALTER TABLE `TelDocenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TelStudenti`
--

DROP TABLE IF EXISTS `TelStudenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TelStudenti` (
  `Numero` char(10) NOT NULL,
  `Studente` char(10) DEFAULT NULL,
  PRIMARY KEY (`Numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TelStudenti`
--

LOCK TABLES `TelStudenti` WRITE;
/*!40000 ALTER TABLE `TelStudenti` DISABLE KEYS */;
INSERT INTO `TelStudenti` VALUES ('0512101928','3482394650'),('0622156561','3444537453'),('0712100001','3347364508'),('0760113131','3382749573'),('0760211111','3018453682');
/*!40000 ALTER TABLE `TelStudenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-12 16:07:53
