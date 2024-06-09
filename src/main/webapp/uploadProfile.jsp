
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creer un profile</title>
<link rel="stylesheet" href="./../styles/creerProfile.css">
<style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            max-width: 500px;
            margin: auto;
            padding: 1em;
            border: 1px solid #ccc;
            border-radius: 1em;
        }
        div + div {
            margin-top: 1em;
        }
        label {
            display: block;
            margin-bottom: .5em;
            color: #333333;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="file"],
        button {
            width: 100%;
            padding: .5em;
            border: 1px solid #ccc;
            border-radius: 1em;
            box-sizing: border-box;
            font-size: 1em;
        }
        button {
            background: #007BFF;
            color: white;
            border: none;
            padding: 0.7em;
            font-size: 1em;
            border-radius: 1em;
            cursor: pointer;
        }
        button:hover {
            background: #009579;
        }
    </style>

	
</head>
<body>
        <h1>Créer un Profile</h1>

        <form action="uploadProfile" method="post" enctype="multipart/form-data">
            <div>
                <label for="photoProfile">Photo de Profile:</label>
                <input type="file" name="photoProfile" id="photoProfile">
            </div>
            <div>
                <label for="nomProfile">Nom Profil:</label>
                <input type="text" id="nomProfile" name="nomProfile" placeholder="nom profile">
            </div>
            <div>
                <label for="prenomProfile">Prenom Profil:</label>
                <input type="text" id="prenomProfile" name="prenomProfile" placeholder="Prenom profile">
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" name="emailProfile" placeholder="Email du Profile">
            </div>
            <div>
                <label for="password">Mot de passe:</label>
                <input type="password" id="password" name="passwordProfile" placeholder="Mot de passe">
            </div>
            <div>
                <label for="phone">Numéro de téléphone:</label>
                <input type="tel" id="phone" name="telephoneProfile" placeholder="Numero de téléphone">
            </div>
            
            <div>
                <button type="submit">Enrégistrer</button>
            </div>

        </form>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
    <title>Profile Form</title>
    <head>
    <link rel="stylesheet" type="text/css" href="styles/uploadprofile.css">
</head>
    
</head>
<body>
    <h2>Profile Form</h2>
    <form action="uploadProfile" method="post" enctype="multipart/form-data">
        <label for="nomProfile">Nom:</label><br>
        <input type="text" id="nomProfile" name="nomProfile" required><br>
        <label for="prenomProfile">Prenom:</label><br>
        <input type="text" id="prenomProfile" name="prenomProfile"><br>
        <label for="emailProfile">Email:</label><br>
        <input type="email" id="emailProfile" name="emailProfile" required><br>
        <label for="passwordProfile">Password:</label><br>
        <input type="password" id="passwordProfile" name="passwordProfile" required><br>
        <label for="telephoneProfile">Telephone:</label><br>
        <input type="tel" id="telephoneProfile" name="telephoneProfile"><br>
        <label for="photoProfile">Photo:</label><br>
        <input type="file" id="photoProfile" name="photoProfile"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
