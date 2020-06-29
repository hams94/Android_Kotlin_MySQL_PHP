-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 28 Juin 2020 à 20:32
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gandhi`
--

-- --------------------------------------------------------

--
-- Structure de la table `matieres`
--

CREATE TABLE `matieres` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `departement` varchar(50) NOT NULL,
  `image` varchar(100) NOT NULL DEFAULT 'kotlin.jpg',
  `status` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `matieres`
--

INSERT INTO `matieres` (`id`, `nom`, `departement`, `image`, `status`) VALUES
(1, 'android', 'Miage', 'kotlin.jpg', 0),
(3, 'php', 'Genie info', 'php.jpg', 0),
(4, 'html css', 'Genie', 'html.jpg', 0),
(5, 'python', 'Miage', 'python.jpg', 0),
(6, 'oracle', 'Miage', 'oracle.jpg', 0),
(7, 'java', 'telecom', 'java.jpg', 0),
(8, 'merise', 'genieinfo', 'uml.jpg', 0),
(9, 'kotlin', 'Genie Miage', 'kotlin.jpg', 0);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `matieres`
--
ALTER TABLE `matieres`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `matieres`
--
ALTER TABLE `matieres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
