  SET time_zone = "+00:00";

  DROP DATABASE IF EXISTS `hartigehap`;

  CREATE DATABASE `hartigehap` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
  USE `hartigehap`;

  --Table Bestelling
  CREATE TABLE IF NOT EXISTS `bestelling` (
    `bestelId` int(10) NOT NULL AUTO_INCREMENT,
    `tafelId` int(10) NOT NULL,
    PRIMARY KEY (`bestelId`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  --Table Simpleorder
  CREATE TABLE IF NOT EXISTS `simpleorder`(
    `ID` int(4) NOT NULL AUTO_INCREMENT,
    `ItemID` int(12) NOT NULL,
    `TafelID` int(12) NOT NULL,
  PRIMARY KEY (`ID`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  --Table Drank
  CREATE TABLE IF NOT EXISTS `drank` (
    `DrankID` int(5) NOT NULL,
    `DrankNaam` varchar(20) NOT NULL,
    `Voorraad` int(10) NOT NULL,
    `prijs` double(5,2) NOT NULL,
    PRIMARY KEY (`DrankID`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  --Table Drank_bestelling
  CREATE TABLE IF NOT EXISTS `drank_bestelling` (
    `DrankID` int(5) NOT NULL,
    `BestelID` int(10) NOT NULL,
    `hoeveelheid` int(10) NOT NULL,
    PRIMARY KEY (`DrankID`,`BestelId`),
    KEY `Drank1` (`BestelId`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  --Table gebruiker
  CREATE TABLE IF NOT EXISTS `gebruiker` (
    `GebruikerID` int(5) NOT NULL,
    `GebruikersNaam` varchar(15) NOT NULL,
    `Wachtwoord` varchar(20) NOT NULL,
    PRIMARY KEY (`GebruikerID`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  --Table gerecht
  CREATE TABLE IF NOT EXISTS `gerecht` (
    `GerechtID` int(5) NOT NULL,
    `GerechtNaam` varchar(20) NOT NULL,
    `GerechtGegevens` varchar(20) NOT NULL,
    `Prijs` double(5,2) NOT NULL,
    PRIMARY KEY (`GerechtID`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  --Tabel gerecht_bestelling
  CREATE TABLE IF NOT EXISTS `gerecht_bestelling` (
    `GerechtID` int(5) NOT NULL,
    `BestelId` int(10) NOT NULL,
    `hoeveelheid` int(2) NOT NULL,
    PRIMARY KEY (`GerechtID`,`BestelId`),
    KEY `Ger_Ger` (`BestelId`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  --Tabel ingredient
  CREATE TABLE IF NOT EXISTS `ingredient` (
    `ingredientID` int(10) NOT NULL,
    `ingredientnaam` varchar(25) NOT NULL,
    `voorraad` int(15) NOT NULL,
    PRIMARY KEY (`ingredientID`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  --Table ingredient_gerecht
  CREATE TABLE IF NOT EXISTS `ingredient_gerecht` (
    `ingredientID` int(10) NOT NULL,
    `gerechtID` int(5) NOT NULL,
    PRIMARY KEY (`ingredientID`,`gerechtID`),
    KEY `Ing_Ger` (`gerechtID`)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;


  --
  -- Beperkingen voor gedumpte tabellen
  --

  ALTER TABLE `drank_bestelling`
    ADD CONSTRAINT `Drank1` FOREIGN KEY (`BestelID`) REFERENCES `bestelling` (`BestelID`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `Bestel2` FOREIGN KEY (`DrankID`) REFERENCES `drank` (`DrankID`) ON DELETE CASCADE ON UPDATE CASCADE;

  --
  -- Beperkingen voor tabel `gerecht_bestelling`
  --
  ALTER TABLE `gerecht_bestelling`
    ADD CONSTRAINT `Ger_Ger` FOREIGN KEY (`BestelID`) REFERENCES `bestelling` (`BestelID`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `Ger_bestel` FOREIGN KEY (`GerechtID`) REFERENCES `gerecht` (`GerechtID`) ON DELETE CASCADE ON UPDATE CASCADE;

  --
  -- Beperkingen voor tabel `ingredient_gerecht`
  --
  ALTER TABLE `ingredient_gerecht`
    ADD CONSTRAINT `Ing_Ger` FOREIGN KEY (`gerechtID`) REFERENCES `gerecht` (`GerechtID`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `ing_ing` FOREIGN KEY (`ingredientID`) REFERENCES `ingredient` (`ingredientID`) ON DELETE CASCADE ON UPDATE CASCADE;
