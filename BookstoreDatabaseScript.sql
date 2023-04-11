DROP DATABASE IF EXISTS `sql_bookinventory`;
CREATE DATABASE `sql_bookinventory`;
USE `sql_bookinventory`;

SET NAMES utf8 ;
SET character_set_client = utf8mb4 ;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `home_address` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `users` VALUES ('bubblegum', 'passwword','Justin K Cromwelly','ADC@gmail.com','123 sw 80 st');
INSERT INTO `users` VALUES ('astRAL', 'passwword','Justin A Cromwelly','AbC@gmail.com','124 sw 80 st');
INSERT INTO `users` VALUES ('you', 'passwword','Justin B Cromwelly','ADf@gmail.com','125 sw 80 st');
INSERT INTO `users` VALUES ('guy', 'passwword','Justin D Cromwelly','ADe@gmail.com','126 sw 80 st');
INSERT INTO `users` VALUES ('two', 'passwword','Justin F Cromwelly','ADg@gmail.com','127 sw 80 st');

CREATE TABLE `books` (
  `id` int NOT NULL,
  `isbn` varchar(13) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(200) NOT NULL,
  `price` decimal(9,2) NOT NULL,
  `author` varchar(50) NOT NULL,
  `genre` varchar(500) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `year_published` date DEFAULT NULL,
  `copies_sold` int NOT NULL,

  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `books` VALUES (1,'9781974700301','Kaguya-sam Love is war','manga about love',9.99,'Aka Akasaka','Psychological,Romantic comedy,Slice of life','Viz Media','1998-11-11',100);
INSERT INTO `books` VALUES (2,'9781974700321','Kaguya-sam Love is not war','manga about not war',9.99,'Aka Akasaka','Psychological,Romantic comedy,Slice of life','Viz Media','1998-12-12',100);
INSERT INTO `books` VALUES (3,'9781974700331','Kaguya-sam Love is for sure war','manga about war',9.99,'Aka Akasaka','Psychological,Romantic comedy,Slice of life','Viz Media','1998-07-08',100);

CREATE TABLE `credit_card` (
  `username` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `credit_card_number` varchar(16) NOT NULL,
  `expiration` date NOT NULL,
  `security_code` int NOT NULL,

  PRIMARY KEY (`credit_card_number`),
  CONSTRAINT `fk_credit_card_user` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `credit_card` VALUES ('bubblegum','ayy lmao','1234123412341234','2019-02-12',234);
INSERT INTO `credit_card` VALUES ('you','leaf green','4321432143214321','2018-02-12',789);
INSERT INTO `credit_card` VALUES ('guy','firered','1919191919191919','2019-12-12',012);

CREATE TABLE `author` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `author` VALUES (1,'Aka Akasaka');





