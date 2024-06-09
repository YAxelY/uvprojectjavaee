<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>View Profile</title>
</head>
<body>
    <h1>Profile Details</h1>
    <p>Name: <%= ((beans.Profile) request.getAttribute("profile")).getNomProfile() %> <%= ((beans.Profile) request.getAttribute("profile")).getPrenomProfile() %></p>
    <p>Email: <%= ((beans.Profile) request.getAttribute("profile")).getEmailProfile() %></p>
    <p>Phone: <%= ((beans.Profile) request.getAttribute("profile")).getTelephoneProfile() %></p>
</body>
</html>
