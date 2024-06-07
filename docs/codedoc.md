# Code Documentation

## Introduction
création d'une application de gestion de la messagerie,notification,et publication
des blogs dans le contexte d'une plateforme de mise en relation des acteurs du secteurs
agropastorale!

## Configuration de l'Environnement
Pour configurer l'environnement et utiliser ce code, assurez-vous d'avoir les paramètres suivants correctement configurés :

- Paramètre 1 : installer le serveur d'application (Apache Tomcat)
- Paramètre 2 : Ouvrir le projet dans un IDE (Eclipse)
- paramètre 3 : rajouter le driver jdbc de postgres dans le dossier lib de votre serveur
d'application 
- Paramètre 3 : Exécuter le project en tant que serveur

## Règles de nommage

1. DAO, BEANS: pascal case
2. routes, jsp pages, attributes, fonctions: camel case
3. tables, columns : snake case

## Architecture du Code
Le projet est organisé comme suit :
- `docs`: documents du code, code sql, user guide
- `readme`: rapport journalier du travail
- `src`: dossier source
	- main: dossier principale
		- java: 
			- beans: tous les beans de l'app
			- daos: tous les dao de l'app
			- servlets: tous les servlets de l'app
			
		- webapp:
			-components: composants graphiques réutilisables
			- img : images
			- protected: toutes les pages qui nécessitent une authentification
			- styles : tous les pages css du site
			- WEB-INF: dossier de conf
			

##  Classes & Méthodes 

### AuthDAO.java
contient  les fonctions nécessaires à l'authentification

#### public boolean authenticate(String username, String password)
permet de comparer le nom d'utilisateur récupérer  et mot de passe 
récupérer à partir du formulaire login.jsp


