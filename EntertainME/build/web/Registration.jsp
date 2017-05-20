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
        <div id ="left">
            

        </div>


        <div id="content">
            <div class="header">
                <img id="logoImg" src="http://www.bureauofbetterment.com/wp-content/uploads/2015/03/entertain-me-retro.jpg" width="100px"  />
                
            </div>
            <nav>
                <%if (request.getSession().getAttribute("user") != null) {%>

                <ul>
                    <li><a href="Home.jsp">Home</a></li>
                    <li><a href="Products.jsp">Products</a></li>
                    <li><a href="Contact.jsp">Contact</a></li>
                    <li><a href="Profile.jsp">Profile</a></li>
                    <li id = "tail"><a href="LogOutController">Logout</a></li>
                </ul>
                <%} else {%>
                <ul>
                    <li><a href="Home.jsp">Home</a></li>
                    <li><a href="Products.jsp">Products</a></li>
                    <li><a href="Contact.jsp">Contact</a></li>
                    <li id = "tail" ><a href="Login.jsp">Log In</a></li>
                    <li id = "tail" ><a href="Registration.jsp">Register</a></li>
                </ul>
                <%}%>
            </nav>
            
            <div id="center">
            <h2>Registration form</h2>   
            <form method="post" action="RegisterController">
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
            <div id="footer">Web Application Development Project</div>
        </div>
        <div id="right">
                 
        </div>
        

    </body>

</html>