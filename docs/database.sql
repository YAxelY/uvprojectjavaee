CREATE DATABASE IF NOT EXISTS blogDataBase;

USE blogDataBase;

CREATE TABLE Producteur (
    id_producteur INT PRIMARY KEY AUTO_INCREMENT,
    nom_producteur VARCHAR(255) NOT NULL,
   	password_utilisateur VARCHAR(255) NOT NULL

);

CREATE TABLE Utilisateur (
    id_utilisateur INT PRIMARY KEY AUTO_INCREMENT,
    nom_utilisateur VARCHAR(255) NOT NULL
);

CREATE TABLE Profile (
    id_profile INT PRIMARY KEY AUTO_INCREMENT,
    nom_profile VARCHAR(100) NOT NULL,
    prenom_profile VARCHAR(100) NOT NULL,
    email_profile VARCHAR(100) NOT NULL,
    password_profile VARCHAR(255) NOT NULL,
    telephone_profile VARCHAR(15) NOT NULL,
    id_producteur INT,
    FOREIGN KEY (id_producteur) REFERENCES Producteur(id_producteur)
);

CREATE TABLE Message (
    id_message INT PRIMARY KEY AUTO_INCREMENT,
    contenu_message TEXT NOT NULL,
    id_profile INT,
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_utilisateur INT,
    type ENUM('ENV', 'REC') NOT NULL,
    FOREIGN KEY (id_profile) REFERENCES Profile(id_profile),
    FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE NotifProfile (
    id_notif INT PRIMARY KEY AUTO_INCREMENT,
    contenu_notif_profile TEXT NOT NULL,
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_profile INT,
    FOREIGN KEY (id_profile) REFERENCES Profile(id_profile)
);

CREATE TABLE NotifUtilisateur (
    id_notif INT PRIMARY KEY AUTO_INCREMENT,
    contenu_notif_utilisateur TEXT NOT NULL,
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_utilisateur INT,
    FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);

CREATE TABLE Blog (
    id_blog INT PRIMARY KEY AUTO_INCREMENT,
    contenu_blog TEXT NOT NULL,
    id_profile INT,
    FOREIGN KEY (id_profile) REFERENCES Profile(id_profile)
);

CREATE TABLE Interagir (
    id_blog INT,
    id_utilisateur INT,
    commentaire_interaction TEXT,
    interaction ENUM('LIKE', 'DISLIKE', 'NEUTRAL') NOT NULL,
    PRIMARY KEY (id_blog, id_utilisateur),
    FOREIGN KEY (id_blog) REFERENCES Blog(id_blog),
    FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
);
