
<%@page import="domain.Product"%>
<%@page import="domain.Order"%>
<%@page import="DAO.OrderDAO"%>
<%@page import="DAO.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    OrderDAO orderDAO = OrderDAO.getInstance();
    UserDAO userDAO = UserDAO.getInstance();
    domain.User u = userDAO.getUserInfo((String) request.getSession().getAttribute("user"));
    ArrayList<Order> orders = orderDAO.getUserOrders(userDAO.getUserId((String) request.getSession().getAttribute("user")));
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Profile</title>
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
                <h1>User Info:</h1>
                <form method="post">

                    <div class="form-element">
                        <label>Username:</label>
                    </div>
                    <div class="form-element">
                        <label><%= u.getUsername()%></label>
                    </div>

                    <div class="form-element">
                        <label>First Name:</label>
                    </div>
                    <div class="form-element">
                        <label><%= u.getFname()%></label>
                    </div>

                    <div class="form-element">
                        <label>Last Name:</label>
                    </div>
                    <div class="form-element">
                        <label><%= u.getLname()%></label>
                    </div>

                    <div class="form-element">
                        <label>Phone number:</label>
                    </div>
                    <div class="form-element">
                        <label><%= u.getPhone()%></label>
                    </div>

                    <div class="form-element">
                        <label>Email:</label>
                    </div>
                    <div class="form-element">
                        <label><%= u.getEmail()%></label>
                    </div>
                </form>  
               
                <%if (orders.size() > 0) {%>
                <div>
                    <h1>Order History:</h1>
                    <div>
                        <% for (Order o : orders) {
                                ArrayList<Product> products = o.getProducts();                              
                                int totalPrice = o.getTotalPrice();
                                for (Product p : products) {%>
                        <label><%=p.getName()%>, <%=p.getQuantity()%>, Price: <%=p.getUnitPrice()%></label><br>
                        <%}%>
                        <label><b>Total Price:</b> <%=totalPrice%></label>                       

                        <%}%>
                        <%}%>



                    </div>


                </div>
            </div>
            <div id="footer">Web Application Development Project</div>
        </div>
        <div id="right">

        </div>


    </body>

</html>