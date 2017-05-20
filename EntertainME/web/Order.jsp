<%@page import="domain.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int totalPrice = 0;
%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Order</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

        <script>
            $(document).ready(function () {
                $("#addrButton").click(function () {
                    if ($("#formNew").css("display") == "none") {
                        $("#formNew").css("display", "block");
                        $("#formExisting").css("display", "none");
                        $("#addrButton").attr("value", "Choose existing address");
                    } else {
                        $("#formNew").css("display", "none");
                        $("#formExisting").css("display", "block");
                        $("#addrButton").attr("value", "Add new address");
                    }
                });
                $(".del").click(function () {
                    $(".onDeletion").css("display", "none");
                    $("#formDeletion").css("display", "block");
                })
            });

        </script>
    </head>
    <body>
        <div id ="left">


        </div>


        <div id="content">
            <div class="header">
                <img id="logoImg" src="https://dl.dropboxusercontent.com/s/xriiowug7kbfc7d/AREA52logo.png?dl=0" width="100px"  />

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
                <h1 class="onDeletion"> Your Order: </h1> </br>

                <form class="onDeletion" id="formExisting" method="post" action="OrderExistingController">
                    <%if (request.getAttribute("products") != null) {
                        ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");%>
                    <ol>
                        <%totalPrice = 0;
                            for (int i = 0; i < products.size(); i++) {
                                totalPrice += products.get(i).getUnitPrice();
                        %>
                        <li><%=products.get(i).getName() + ", " + products.get(i).getQuantity() + "g, " + products.get(i).getUnitPrice() + "€"%></li><br>

                        <%}%>
                    </ol>
                        <h3>Total Price: </h3><%=totalPrice%><br>
                    <% request.getSession().setAttribute("totalPrice", totalPrice);%>
                    <%}%>
                    <br>
                    <input class = "del" type ="button" value="Delete items">                 
                    <div class="form-element">
                        <input class="dis1" type="submit" value="Submit">
                        <input class="dis1" type="reset" value="Reset">
                    </div>
                </form>

                <form class="onDeletion" id="formNew" method="post" action="AddressController">
                    <%if (request.getAttribute("products") != null) {
                        ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");%>
                    <ol>
                        <%totalPrice = 0;
                            for (int i = 0; i < products.size(); i++) {
                                totalPrice += products.get(i).getUnitPrice();
                        %>
                        <li><%=products.get(i).getName() + ", " + products.get(i).getQuantity() + "g, " + products.get(i).getUnitPrice() + "€"%></li>

                        <%}%>
                    </ol>
                    <h3>Total Price: </h3><%=totalPrice %>
                    <%}%>
                    <br>
                    <input class="del" type ="button" value="Delete items">
                    
                </form>

                <form id="formDeletion" method="post" action="DeleteSelectionsController">
                    <%if (request.getAttribute("products") != null) {
                        ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");%>
                    <%for (int i = 0; i < products.size(); i++) {%>
                    <input type="checkbox" name="check" value="<%=products.get(i).getName() + "#" + products.get(i).getQuantity() + "#" + products.get(i).getUnitPrice()%>" checked/>
                    <%= products.get(i).getName() + ", " + products.get(i).getQuantity() + "g, " + products.get(i).getUnitPrice()%>
                    <br>  
                    <%}%>
                    <%}%>

                    <div class="form-element">
                        <input class="dis1" type="submit" value="Delete Selected">
                    </div>
                </form>

                <div class="onDeletion">
                    <input id="addrButton" type="button" value = "Add new address">
                </div>
            </div>
            <div id="footer">Web Application Development Project</div>
        </div>
        <div id="right">

        </div>


    </body>

</html>