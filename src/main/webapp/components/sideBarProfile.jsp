<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <div id ="sidebar" class="sidebar">
 <a href="javascript:void(0)" class="closebtn" onclick="toggleSidebar()">×</a>
        <form id="profilePictureForm" method="post" enctype="multipart/form-data" action="uploadProfilePicture.jsp">
            <div class="profile-picture">
                <label for="profilePictureInput">
                    <img src="img/woman.png" alt="Profile Picture" id="profilePicture" class="profile-picture-img">
                </label>
                <input type="file" id="profilePictureInput" name="profilePicture" accept="image/*" style="display:none;" onchange="document.getElementById('profilePictureForm').submit();">
            </div>
        </form>
        <button class="btn" onclick="location.href='protected/gererProfile.jsp'">Gérer Profil</button>
       
       
        <button class="btn" href="logout">Sign Out</button>
        <div class="separator"></div>
        <a href="accueil.jsp" class="menu-item">Accueil</a>
        <a href="communications.jsp" class="menu-item">Communications</a>
 </div>