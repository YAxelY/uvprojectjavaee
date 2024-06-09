<!DOCTYPE html>
<!---Coding By CoderGirl | www.codinglabweb.com--->
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login & Registration Form</title>
  <!---Custom CSS File--->
  <link rel="stylesheet" href="styles/login.css">
</head>
<body>
  <div class="container">
    <input type="checkbox" id="check">
    <div class="login form">
      <header>Login</header>
      <form action="login" method="post">
        <input type="text" name="username" placeholder="Enter your email or username" required>
        <input type="password" name="password" placeholder="Enter your password" required>
        <p style="color:red;">
             <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
      </p>
        <a href="#">Forgot password?</a>
        <input type="submit" class="button" value="Login">
      </form>
      <div class="signup">
        <span class="signup">Don't have an account?
         <label for="check">Signup</label>
        </span>
      </div>
    </div>
    <div class="registration form">
      <header>Signup</header>
      <form action="signup" method="post">
        <input type="text" name="username" placeholder="Enter your username" required>
        <input type="password" name="password" placeholder="Create a password" required>
        <input type="password" name ="confirmPassword" placeholder="Confirm your password" required>
        <input type="submit" class="button" value="Signup">
      </form>
      
      <% if(request.getAttribute("form") != null) { %>
    <script>
        document.getElementById("check").checked = true;
    </script>
<% } %>
  <p style="color:red;">
             <%= request.getAttribute("errorMessage1") != null ? request.getAttribute("errorMessage1") : "" %>
      </p> <div class="signup">
        <span class="signup">Already have an account?
         <label for="check">Login</label>
        </span>
      </div>
    </div>
  </div>
</body>
</html>
