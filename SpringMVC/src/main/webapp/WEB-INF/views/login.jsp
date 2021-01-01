<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

  <div align="center">
            <h1>Login</h1>
            <form id="login" action="login">
                
                <label for="username">User ID:</label>
                <input type="text" placeholder="Enter Username" name="username" id="username">
                
                <br><br>
                
                <label for="password">Password:</label>
                <input type="password" placeholder="Enter Password" name="password" id="password">
                
                <br><br>
                
                <input type="submit" value="Login">
               
                
            </form>
            <br><br>
            
            <label>Do not have an account? Register Here.</label>
            <a href="register-user.jsp"><button>Register</button></a>
        </div>
</body>
</html>