#
# Hartige Hap DB
#

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS `hartigehap`;

CREATE DATABASE `hartigehap` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `hartigehap`;

#Table Bestelling
CREATE TABLE IF NOT EXISTS `bestelling` (
  `bestelId` int(10) NOT NULL AUTO_INCREMENT,
  `tafelId` int(10) NOT NULL,

  CONSTRAINT
    PRIMARY KEY (`bestelId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#Table Simpleorder
#May not be necessary to have this table!?
CREATE TABLE IF NOT EXISTS `simpleorder`(
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `ItemID` int(12) NOT NULL,
  `TafelID` int(12) NOT NULL,

  CONSTRAINT
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#Table Drank
CREATE TABLE IF NOT EXISTS `drank` (
  `DrankID` int(5) NOT NULL,
  `DrankNaam` varchar(20) NOT NULL,
  `Voorraad` int(10) NOT NULL,
  `prijs` double(5,2) NOT NULL,

  CONSTRAINT
    PRIMARY KEY (`DrankID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#Table Drank_bestelling #This is a temporary table that only stores items
#while there are people sitting there, record gets emptied when they pay.
CREATE TABLE IF NOT EXISTS `drank_order` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `TafelID` int(5) NOT NULL,
  `DrankID` int(5) NOT NULL,

  CONSTRAINT
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  #Tabel gerecht_bestelling #This is a temporary table that only stores items
  #while there are people sitting there, record gets emptied when they pay.
  CREATE TABLE IF NOT EXISTS `gerecht_order` (
    `ID` int(5) NOT NULL AUTO_INCREMENT,
    `TafelID` int(5) NOT NULL,
    `GerechtID` int(5) NOT NULL,

    CONSTRAINT
      PRIMARY KEY (`ID`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#Table gebruiker
CREATE TABLE IF NOT EXISTS `gebruiker` (
  `GebruikerID` int(5) NOT NULL,
  `GebruikersNaam` varchar(15) NOT NULL,
  `Wachtwoord` varchar(20) NOT NULL,

  CONSTRAINT
    PRIMARY KEY (`GebruikerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#Table gerecht
CREATE TABLE IF NOT EXISTS `gerecht` (
  `GerechtID` int(5) NOT NULL,
  `GerechtNaam` varchar(20) NOT NULL,
  `GerechtGegevens` varchar(20) NOT NULL,
  `Prijs` double(5,2) NOT NULL,

  CONSTRAINT
    PRIMARY KEY (`GerechtID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#Tabel ingredient
CREATE TABLE IF NOT EXISTS `ingredient` (
  `ingredientID` int(10) NOT NULL,
  `ingredientnaam` varchar(25) NOT NULL,
  `voorraad` int(15) NOT NULL,

  CONSTRAINT
    PRIMARY KEY (`ingredientID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#Table ingredient_gerecht
CREATE TABLE IF NOT EXISTS `ingredient_gerecht` (
  `ingredientID` int(10) NOT NULL,
  `gerechtID` int(5) NOT NULL,

  CONSTRAINT
    PRIMARY KEY (`ingredientID`,`gerechtID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
