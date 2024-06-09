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
