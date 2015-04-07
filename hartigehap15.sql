-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Machine: 127.0.0.1
-- Genereertijd: 07 apr 2015 om 12:32
-- Serverversie: 5.5.34
-- PHP-versie: 5.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databank: `hartigehap15`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `bestelling`
--

CREATE TABLE IF NOT EXISTS `bestelling` (
  `BestelID` int(10) NOT NULL,
  `tafelID` int(20) NOT NULL,
  PRIMARY KEY (`BestelID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `bestelling`
--

INSERT INTO `bestelling` (`BestelID`, `tafelID`) VALUES
(1, 1),
(25, 22);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `drank`
--

CREATE TABLE IF NOT EXISTS `drank` (
  `DrankID` int(5) NOT NULL,
  `DrankNaam` varchar(20) NOT NULL,
  `Voorraad` int(10) NOT NULL,
  PRIMARY KEY (`DrankID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `drank`
--

INSERT INTO `drank` (`DrankID`, `DrankNaam`, `Voorraad`) VALUES
(32, 'Cola', 100),
(256, 'Bier', 25);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `drank_bestelling`
--

CREATE TABLE IF NOT EXISTS `drank_bestelling` (
  `DrankID` int(5) NOT NULL,
  `BestelID` int(10) NOT NULL,
  `hoeveelheid` int(10) NOT NULL,
  PRIMARY KEY (`DrankID`,`BestelID`),
  KEY `Drank1` (`BestelID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `drank_bestelling`
--

INSERT INTO `drank_bestelling` (`DrankID`, `BestelID`, `hoeveelheid`) VALUES
(32, 1, 3),
(32, 25, 3);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `gerecht`
--

CREATE TABLE IF NOT EXISTS `gerecht` (
  `GerechtID` int(5) NOT NULL,
  `GerechtNaam` varchar(20) NOT NULL,
  `GerechtGegevens` varchar(20) NOT NULL,
  `Prijs` decimal(5,2) NOT NULL,
  PRIMARY KEY (`GerechtID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `gerecht`
--

INSERT INTO `gerecht` (`GerechtID`, `GerechtNaam`, `GerechtGegevens`, `Prijs`) VALUES
(58745, 'Bief', 'Koei', '12.50'),
(69697, 'Mayonaise', 'Lekker vet', '9.99'),
(79697, 'Mayonaise', 'Lekker vet', '9.99'),
(269692, 'Mayonase', 'lekker vet', '1.00');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `gerecht_bestelling`
--

CREATE TABLE IF NOT EXISTS `gerecht_bestelling` (
  `GerechtID` int(5) NOT NULL,
  `BestelID` int(10) NOT NULL,
  `hoeveelheid` int(2) NOT NULL,
  PRIMARY KEY (`GerechtID`,`BestelID`),
  KEY `Ger_Ger` (`BestelID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `ingredient`
--

CREATE TABLE IF NOT EXISTS `ingredient` (
  `ingredientID` int(10) NOT NULL,
  `ingredientnaam` varchar(25) NOT NULL,
  `voorraad` int(15) NOT NULL,
  PRIMARY KEY (`ingredientID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `ingredient`
--

INSERT INTO `ingredient` (`ingredientID`, `ingredientnaam`, `voorraad`) VALUES
(522, 'Biefstuk Koe', 200);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `ingredient_gerecht`
--

CREATE TABLE IF NOT EXISTS `ingredient_gerecht` (
  `ingredientID` int(10) NOT NULL,
  `gerechtID` int(5) NOT NULL,
  PRIMARY KEY (`ingredientID`,`gerechtID`),
  KEY `Ing_Ger` (`gerechtID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `ingredient_gerecht`
--

INSERT INTO `ingredient_gerecht` (`ingredientID`, `gerechtID`) VALUES
(522, 58745);

--
-- Beperkingen voor gedumpte tabellen
--

--
-- Beperkingen voor tabel `drank_bestelling`
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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
