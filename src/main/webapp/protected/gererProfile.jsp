<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gérer Profil</title>
    <link rel="stylesheet" type="text/css" href="../styles/gererProfile.css">
    <script>
        function previewImage(event) {
            var reader = new FileReader();
            reader.onload = function(){
                var output = document.getElementById('profilePhoto');
                output.src = reader.result;
            };
            reader.readAsDataURL(event.target.files[0]);
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Gérer Profil</h1>
        
        <div class="profile-section">
            <img id="profilePhoto" alt="photoProfile" src="img/woman.png">
            <form action="../updateProfile" method="post" enctype="multipart/form-data">
                <label for="photoProfile">Photo:</label>
                <input type="file" id="photoProfile" name="photoProfile" accept="image/*" onchange="previewImage(event)"><br><br>
                
                <label for="nomProfile">Nom:</label>
                <input type="text" id="nomProfile" name="nomProfile"><br><br>
                
                <label for="prenomProfile">Prénom:</label>
                <input type="text" id="prenomProfile" name="prenomProfile"><br><br>
                
                <label for="emailProfile">Email:</label>
                <input type="email" id="emailProfile" name="emailProfile"><br><br>
                
                <label for="passwordProfile">Password:</label>
                <input type="password" id="passwordProfile" name="passwordProfile"><br><br>
                
                <label for="telephoneProfile">Téléphone:</label>
                <input type="text" id="telephoneProfile" name="telephoneProfile"><br><br>
                
                <input type="submit" value="Mettre à jour" class="btn">
            </form>
        </div>
    </div>
</body>
</html>
