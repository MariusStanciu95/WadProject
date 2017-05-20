
<%@page import="java.util.ArrayList"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Contact</title>
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
                <h1>Location:</h1>
            
            <div id="location">
                <h3>Entertain Me</h3>
                <h4>Address</h4>
                <label>City: Bucharest</label><br>
                <label>Street: Everywhere</label><br>
                <label>Number: oo</label><br>
                <label>Phone: 0712345678</label><br>
                <label>Description: Best Shop Ever</label><br>
                
            </div>
            
            

        

            <%if (request.getSession().getAttribute("user") != null) {%>
            <a href="Booking.jsp">Get a Booking!<a> <%}%>
            
        </div>
            <div id="footer">Web Application Development Project</div>
        </div>
        <div id="right">
                 
        </div>
        

    </body>

</html>