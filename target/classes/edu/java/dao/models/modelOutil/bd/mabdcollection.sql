--
-- Base de datos: `mabdcollection`
--
CREATE DATABASE IF NOT EXISTS `mabdcollection` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `mabdcollection`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `outils`
--

CREATE TABLE `outils` (
  `idref` int(11) NOT NULL,
  `appelation` varchar(80) NOT NULL,
  `qualification_forme` varchar(50) DEFAULT NULL,
  `forme_typ` varchar(30) DEFAULT NULL,
  `forme_atyp` varchar(10) DEFAULT NULL,
  `obs_aspect` varchar(30) DEFAULT NULL,
  `etat_conservation` varchar(40) DEFAULT NULL,
  `ro_naturel` varchar(10) DEFAULT NULL,
  `ro_amenage` varchar(10) DEFAULT NULL,
  `hauteur_reel_mm` int(11) NOT NULL,
  `hauteur_suppose_mm` int(11) DEFAULT NULL,
  `largeur_mm` int(11) DEFAULT NULL,
  `epaisseur_mm` int(11) DEFAULT NULL,
  `masse_gr` int(11) NOT NULL,
  `matiere` varchar(30) NOT NULL,
  `couleur_int` varchar(20) DEFAULT NULL,
  `intensite_pat` varchar(20) NOT NULL,
  `ref_couleur_pat` varchar(20) NOT NULL,
  `couleur_patref` varchar(20) DEFAULT NULL,
  `ret_sigmoidales` varchar(11) DEFAULT NULL,
  `ret_cotefine` varchar(11) DEFAULT NULL,
  `date_decouv` date NOT NULL,
  `info_secondaire` varchar(50) DEFAULT NULL,
  `zone_ramassage` varchar(20) NOT NULL,
  `remarquable` varchar(10) DEFAULT NULL,
  CONSTRAINT outils_idref_PK PRIMARY KEY(idref)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `outils`
--

INSERT INTO `outils` (`idref`, `appelation`, `qualification_forme`, `forme_typ`, `forme_atyp`, `obs_aspect`, `etat_conservation`, `ro_naturel`, `ro_amenage`, `hauteur_reel_mm`, `hauteur_suppose_mm`, `largeur_mm`, `epaisseur_mm`, `masse_gr`, `matiere`, `couleur_int`, `intensite_pat`, `ref_couleur_pat`, `couleur_patref`, `ret_sigmoidales`, `ret_cotefine`, `date_decouv`, `info_secondaire`, `zone_ramassage`, `remarquable`) VALUES
(1, 'Pointe Levallois', 'déjetée à dtoite', NULL, NULL, 'pointe cassée', NULL, NULL, NULL, 58, NULL, NULL, NULL, 25, 'Silex', 'miel', 'patine', '1000', 'e3c58e', NULL, NULL, '1998-11-02', NULL, 'zone B', NULL),
(2, 'Couteau', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 61, NULL, NULL, NULL, 28, 'Silex', NULL, 'patine', '1014', 'efcf95', NULL, NULL, '1998-11-02', NULL, 'Zone B', NULL),
(3, 'Couteau', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 65, NULL, NULL, NULL, 28, 'Silex', NULL, 'patine', '1000', 'efcf95', NULL, NULL, '1998-11-02', NULL, 'Zone B', NULL),
(4, 'Grattoir', '', '', '', '', '', ' ', ' ', 51, 0, 0, 0, 24, 'Silex', '0', 'très forte', '1034', '', '0', '0', '1998-11-02', '', 'zone B', ''),
(5, 'Grattoir', '', '', '', '', '', ' ', ' ', 58, 0, 0, 0, 58, 'Silex', '0', '0', '1014', '', '0', '0', '1998-11-02', ' ', 'zone B', ''),
(6, 'Biface', 'O', 'O', 'O', ' ', 'Fragm, Pointe Proximale', 'O', 'O', 101, 0, 0, 0, 101, 'Silex', '0', '0', '1014', '', '0', '0', '1998-11-02', ' ', 'zone B', ''),
(7, 'Grattoir circulaire', '', 'typique', '', '', '', ' ', ' ', 60, 0, 0, 0, 97, 'Silex', '0', '0', '1000', '', '0', '0', '1998-11-02', 'études Mornand F 2040', 'zone A', ''),
(8, 'Grattoir sur éclat long ', '', '', '', '', '', ' ', ' ', 82, 0, 0, 0, 83, 'Silex', '0', '0', '7008', '', '0', '0', '1998-11-09', '', 'zone A', ''),
(9, 'Biface ', 'Discoïdale', 'typique', 'O', ' ', 'Entier', 'O', 'O', 66, 0, 28, 30, 50, 'Silex', '0', '0', '1014', '', '0', '0', '1998-11-09', 'études Mornand F 2040', 'zone A', ''),
(10, 'Biface', 'Discoïdale', 'typique', 'O', '', 'Entier', 'O', 'O', 72, 0, 29, 35, 225, 'Silex', '0', '0', '1014', '', '0', '0', '1998-11-09', '', 'zone A', ''),
(11, 'Biface', 'Discoïdale', 'typique', 'O', ' ', 'Entier', 'O', 'O', 89, 0, 44, 50, 370, 'Silex', '0', '0', '1014', '', '0', '0', '1998-11-09', 'bulletin sesa n°10', 'zone A', ''),
(12, 'Biface', 'Discoïdale', 'typique', 'O', '', 'Entier', 'O', 'O', 95, 0, 36, 50, 370, 'Silex', '0', '0', '1014', '', '0', '0', '0000-00-00', '', 'zone A', ''),
(13, 'Biface', 'Ovalaire', 'typique', 'O', 'partie distale cassée', 'Fragm, Pointe Proximale', 'O', 'O', 102, 0, 48, 40, 210, 'Poudingue siliceux', '0', '0', '1020', '', '0', '0', '0000-00-00', '', 'zone A', ''),
(14, 'Biface', 'Ovalaire', 'typique', 'O', ' ', 'Entier', 'O', 'r.o.a', 121, 0, 55, 37, 350, 'Poudingue siliceux', '0', '0', '1020', '', '0', '0', '0000-00-00', '', 'zone A', 'R '),
(15, 'Biface', 'Amygdaloïde court', 'typique', 'O', ' ', 'Entier', 'O', 'r.o.a', 131, 0, 42, 47, 460, 'Poudingue siliceux', '0', '0', '1020', '', '0', '0', '0000-00-00', 'bulletin sesa n° 05', 'zone A', 'R'),
(16, 'Racloir double allongé', '', '', '', ' ', ' ', ' ', ' ', 110, 0, 0, 0, 150, 'Poudingue siliceux', '0', '0', '1000', '', '0', '0', '0000-00-00', 'études Mornand F 2042.b sesa 14', 'zone A', 'R'),
(17, 'Pointe déjetée', '', '', '', '', '', ' ', ' ', 81, 0, 0, 0, 40, 'Silex', '0', '0', '1021', '', '0', '0', '0000-00-00', 'études Mornand F 2041', 'zone A', ''),
(18, 'Lame polie de Hache', '', '', '', '', '', ' ', ' ', 81, 0, 0, 0, 105, 'Roche divers', '0', '0', '7034', '', '0', '0', '0000-00-00', 'Néolithique', 'hors zone', ''),
(19, 'Biface', 'O', '', 'O', ' ', 'Fragm, Pointe Proximale', 'O', 'O', 46, 0, 0, 0, 30, 'Silex', '0', '0', '1017', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(20, 'Pic', '', '', '', ' ', '', ' ', ' ', 111, 0, 0, 0, 83, 'Silex', '0', '0', '1014', '', '0', '0', '0000-00-00', 'études Mornand F 2042.b sesa 16', 'zone B', ''),
(21, 'Couteau', '', '', '', '', '', ' ', ' ', 67, 0, 0, 0, 81, 'Silex', '0', '0', '1020', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(22, 'Racloir', '', '', '', '', '', ' ', ' ', 92, 0, 0, 0, 130, 'Poudingue siliceux', '0', '0', '1014', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(23, 'Biface ', 'O', '', 'O', ' ', 'Ebauche', 'O', 'r.o.a', 86, 0, 0, 0, 372, 'Silex', '0', '0', '1002', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(24, 'Racloir double', '', '', '', ' ', '', ' ', ' ', 80, 0, 0, 0, 130, 'Silex', '0', '0', '1017', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(25, 'Couteau', '', '', '', '', '', ' ', ' ', 94, 0, 0, 0, 82, 'Silex', '0', '0', '1017', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(26, 'Couteau', '', '', '', '', '', ' ', ' ', 88, 0, 0, 0, 143, 'Silex', '0', '0', '1014', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(27, 'Couteau', '', '', '', '', '', ' ', ' ', 68, 0, 0, 0, 60, 'Silex', '0', '0', '1014', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(28, 'Racloir transversale', '', '', '', '', '', ' ', ' ', 76, 0, 0, 0, 72, 'Silex meuliére', '0', '0', '1014', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(29, 'Couteau', '', '', '', '', '', ' ', ' ', 80, 0, 0, 0, 81, 'Silex', '0', '0', '3012', '', '0', '0', '0000-00-00', 'études Mornand F 2044', 'zone B', ''),
(30, 'Racloir double', '', '', '', 'pointe cassée', '', ' ', ' ', 98, 0, 0, 0, 168, 'silex', '0', '0', '1013', '', '0', '0', '0000-00-00', 'études Mornand F 2043', 'zone B', ''),
(31, 'Pointe droite ', '', '', '', '', '', ' ', ' ', 80, 0, 0, 0, 50, 'Silex', '0', '0', '1014', '', '0', '0', '0000-00-00', 'études Mornand F 2041', 'zone B', ''),
(32, 'Pic', '', '', '', ' ', '', ' ', ' ', 93, 0, 0, 0, 122, 'Silex', '0', '0', '1014', '', '0', '0', '0000-00-00', 'études mornand F 2037', 'zone B', ''),
(33, 'Biface', 'Cordiforme allongé', ' typique', 'O', ' ', 'Entier', 'r.o.n', 'O', 126, 0, 40, 24, 130, 'Ignimbrite', '0', '0', '7044', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(34, 'Biface', 'Triangulaire', 'O', 'O', 'pointe cassée', 'Entier', 'O', 'O', 68, 0, 66, 21, 78, 'Silex', '0', '0', '1021', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(35, 'Racloir ', '', '', '', '', '', ' ', ' ', 90, 0, 0, 0, 195, 'silex', '0', '0', '1013', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(36, 'Biface', 'Sub-Triangulaire', 'O', 'O', '', 'Entier', 'O', 'O', 111, 0, 30, 33, 40, 'Poudingue siliceux', '0', '0', '1017', ' ', '0', '0', '0000-00-00', ' don CATTO', 'zone B', ''),
(37, 'Racloir', ' ', '', '', 'Grand', ' ', ' ', ' ', 142, 0, 0, 0, 480, 'Poudingue siliceux', '0', '0', '1002', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(38, 'Biface', 'Amygdaloïde', 'O', 'O', 'partie distale cassée', 'O', 'O', 'r.o.a', 88, 0, 0, 0, 65, 'Grès jaune', '0', '0', '1020', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(39, 'Biface', 'Ovalaire', 'O', 'O', ' ', 'Entier', 'O', 'O', 90, 0, 39, 35, 105, 'Silex', '0', '0', '1013', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(40, 'Biface', 'Ovalaire', 'O', 'O', '', 'Entier', 'O', 'O', 85, 0, 42, 35, 95, 'Silex', '0', '0', '1017', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(41, 'Biface', 'Triangulaire', 'O', 'O', '', 'Entier', 'r.o.n', 'O', 106, 0, 36, 26, 90, 'Silex', '0', '0', '1020', '', '0', '0', '0000-00-00', '', 'zone B', 'R'),
(42, 'Biface', 'Ovalaire', 'O', 'O', '', 'Entier', 'O', 'r.o.a', 100, 0, 44, 35, 50, 'Silex', '0', '0', '1034', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(43, 'Biface', 'Ovalaire', 'O', 'O', '', 'Entier', 'r.o.n', 'O', 151, 0, 66, 46, 225, 'Poudingue siliceux', '0', '0', '1002', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(44, 'Biface', 'Ovalaire', 'O', 'O', '', 'Entier', 'O', 'r.o.a', 122, 0, 46, 42, 370, 'Poudingue siliceux', '0', '0', '3022', '', '0', '0', '0000-00-00', 'études Mornand F 2014', 'zone B', ''),
(45, 'Biface', 'Sub-Triangulaire', 'O', 'O', '', 'Entier', 'r.o.n', 'O', 98, 0, 22, 40, 370, 'Poudingue siliceux', '0', '0', '1020', '', '0', '0', '0000-00-00', 'bulletin sesa n° 04', 'zone B', 'R'),
(46, 'Biface', 'O', 'O', 'O', 'partie proximale cassée', '.1 / 2', 'O', 'O', 138, 0, 0, 0, 688, 'Poudingue siliceux', '0', '0', '1020', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(47, 'Biface', 'Discoïdale', 'O', 'O', 'petits éclats', 'Entier', 'r.o.n', 'O', 72, 0, 36, 34, 155, 'Silex', '0', '0', '1017', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(48, 'Biface', 'Limande', 'O', 'O', 'petits éclats', 'Entier', 'r.o.n', 'O', 113, 0, 56, 38, 300, 'Grés férugineux', '0', '0', '8016', '', '0', '0', '0000-00-00', '', 'zone B', ''),
(49, 'Biface', 'O', 'O', 'O', ' ', 'Fragment, P Proximale', 'O', 'O', 59, 0, 0, 0, 83, 'Silex', '0', '0', '1021', '', '0', '0', '0000-00-00', '', 'zone B', '');

--