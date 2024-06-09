<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Message Profile</title>
</head>
<body>
    <h1>Message Profile</h1>
    <form action="sendMessageController" method="post">
        <input type="hidden" name="idProfile" value="<%= request.getAttribute("idProfile") %>">
        <input type="hidden" name="username" value="<%= request.getAttribute("username") %>">
        <textarea name="message" placeholder="Type your message here..."></textarea>
        <input type="submit" value="Send Message">
    </form>
</body>
</html>
