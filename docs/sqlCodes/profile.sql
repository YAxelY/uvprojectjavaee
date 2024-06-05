CREATE TABLE Profile (
    id_profile INT PRIMARY KEY AUTO_INCREMENT,
    nom_profile VARCHAR(100) ,
    prenom_profile VARCHAR(100) ,
    email_profile VARCHAR(100) NOT NULL,
    password_profile VARCHAR(255) NOT NULL,
    telephone_profile VARCHAR(15) ,
    photo_profile VARCHAR(255),
    id_producteur INT,
    FOREIGN KEY (id_producteur) REFERENCES Producteur(id_producteur)
);

CREATE TABLE Profile (
    id_profile SERIAL PRIMARY KEY,
    nom_profile VARCHAR(100),
    prenom_profile VARCHAR(100),
    email_profile VARCHAR(100) NOT NULL,
    password_profile VARCHAR(255) NOT NULL,
    telephone_profile VARCHAR(15),
    photo_profile VARCHAR(255)
);

