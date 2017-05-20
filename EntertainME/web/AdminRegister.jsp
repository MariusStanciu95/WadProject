<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <div id="content">
            <div class="header">
                <img src="./img/companyLogo.jpg" width="100px"  />
                <span class="header-text">Area 52[ADMIN POWER 3000]</span>
            </div>
            <nav>
                <ul>
                    <li><a href="Admin.jsp">Admin Home</a></li>
                    <li><a href="AddFood.jsp">Add Food</a></li>
                    <li><a href="DeleteFood.jsp">Delete Food</a></li>
                    <li><a href="AddLocation.jsp">Add Restaurant Location</a></li>
                    <li><a href="AddTables.jsp">Add restaurant table</a></li>
                    <li><a href="LogOutController">Logout</a></li>
                </ul>
            </nav>
            <h2>Registration form</h2>   
            <form method="post" action="AdminRegisterController">
                <div class="form-element">
                    <label for="username">Username:</label>
                    <input type="text" name="uname" id="uname" required>
                </div>
                <div class="form-element">
                    <label for="password">Password:</label>
                    <input type="password" name="password" id="password" required>
                </div>
                <div class="form-element">
                    <label for="rPassword">Repeat password:</label>
                    <input type="password" id="rPassword" required>
                </div>
		<div class="form-element">
                    <label for="firstname">First Name:</label>
                    <input type="text" name="fname" id="fname" required>
                </div>
		<div class="form-element">
                    <label for="lastname">Last Name:</label>
                    <input type="text" name="lname" id="lname" required>
                </div>
		<div class="form-element">
                    <label for="phone">Phone No.:</label>
                    <input type="text" name="phone" id="phone" required>
                </div>
                <div class="form-element">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-element">
                    <label for="gender">Gender:</label>
                    Male<input type="radio" name="gender" value="male" checked> 
                    Female<input type="radio" name="gender" value="female"> 
                </div>
                
                <div class="form-element">
                    <label for="spam">Subscribe to Newsletter?</label>
                    <input type="checkbox" name="spam" id="spam">
                </div> 
                <div class="form-element">
                    <input type="submit" value="Submit">
                    <input type="reset" value="Reset">
                </div>                 
                
            </form>
             
        </div>
    </body>
</html>
