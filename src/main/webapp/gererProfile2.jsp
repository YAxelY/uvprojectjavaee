<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.entities.Profile" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="java.io.IOException" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gérer Profil</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <h1>Gérer Profil</h1>
        
        <div class="profile-section">
            <h2>Mettre à Jour Profil</h2>
            <%
                HttpSession session = request.getSession(false);
                Profile profile = (Profile) session.getAttribute("profile");
                
                if (profile == null) {
                    response.sendRedirect("login.jsp");
                    return;
                }
            %>
            <form action="updateProfile" method="post">
                <label for="nomProfil">Nom:</label>
                <input type="text" id="nomProfil" name="nomProfil" value="<%= profile.getNomProfile() %>"><br><br>
                
                <label for="prenomProfil">Prénom:</label>
                <input type="text" id="prenomProfil" name="prenomProfil" value="<%= profile.getPrenomProfile() %>"><br><br>
                
                <label for="emailProfil">Email:</label>
                <input type="email" id="emailProfil" name="emailProfil" value="<%= profile.getEmailProfile() %>"><br><br>
                
                <label for="telephoneProfil">Téléphone:</label>
                <input type="text" id="telephoneProfil" name="telephoneProfil" value="<%= profile.getTelephoneProfile() %>"><br><br>
                
                <label for="photoProfil">Photo:</label>
                <input type="text" id="photoProfil" name="photoProfil" value="<%= profile.getPhotoProfile() %>"><br><br>
                
                <input type="hidden" name="idProfile" value="<%= profile.getIdProfile() %>">
                
                <input type="submit" value="Mettre à jour" class="btn">
            </form>
        </div>
        
        <div class="blogs-section">
            <h2>Blogs</h2>
            <table>
                <tr>
                    <th>ID Blog</th>
                    <th>Contenu</th>
                    <th>Actions</th>
                </tr>
                <!-- Assuming you have logic to fetch and display blogs -->
            </table>
            <br>
            <button class="btn" onclick="location.href='createBlog.jsp'">Créer un Blog</button>
        </div>
    </div>
</body>
</html>
