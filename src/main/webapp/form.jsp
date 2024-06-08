<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Form</title>
</head>
<body>
    <h1>User Form</h1>
    <form action="userServlet" method="post">
        <input type="hidden" name="id" value="${user != null ? user.idUser : ''}" />
        
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${user != null ? user.username : ''}" required />
        </div>
        
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${user != null ? user.passwordUser : ''}" required />
        </div>
        
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user != null ? user.emailUser : ''}" required />
        </div>
        
        <div>
            <button type="submit">Save</button>
        </div>
    </form>
</body>
</html>
