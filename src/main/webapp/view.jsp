<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>View Profile</title>
    <link rel="stylesheet" href="styles/viewProfile.css">
</head>
<body>
    <div class="profile-container">
        <h1>Profile Details</h1>
         <p class="profile-photo">
            <img src="<%= ((beans.Profile) request.getAttribute("profile")).getPhotoProfile() %>" alt="Profile Photo">
        </p>
        <p class="profile-name">Name: <%= ((beans.Profile) request.getAttribute("profile")).getNomProfile() %> <%= ((beans.Profile) request.getAttribute("profile")).getPrenomProfile() %></p>
        <p class="profile-email">Email: <%= ((beans.Profile) request.getAttribute("profile")).getEmailProfile() %></p>
        <p class="profile-phone">Phone: <%= ((beans.Profile) request.getAttribute("profile")).getTelephoneProfile() %></p>
        <hola>
    </div>
</body>
</html>
