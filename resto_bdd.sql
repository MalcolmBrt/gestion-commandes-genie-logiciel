-- Création de la base de données (si nécessaire)
CREATE DATABASE
IF NOT EXISTS resto_bdd;
USE resto_bdd;

-- Création de la table menu
CREATE TABLE menu
(
    numero INT PRIMARY KEY AUTO_INCREMENT numero,
    nom VARCHAR(100) NOT NULL,
    prix INT(5) NOT NULL
);

-- Insertion de quelques exemples de repas dans la table menu
INSERT INTO menu
    (nom, prix)
VALUES
    ('Spaghetti Bolognese', 1250),
    ('Salade César', 890),
    ('Pizza Margherita', 1100),
    ('Burger Classic', 1050),
    ('Soupe du jour', 500);

-- Sélection des données pour vérifier l'insertion
SELECT *
FROM menu;