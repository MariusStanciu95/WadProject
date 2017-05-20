<%@page import="DAO.OrderDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    OrderDAO orderDao = OrderDAO.getInstance();
    ArrayList<domain.Order> orders = orderDao.getAllOrders();
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="style1.css" type="text/css"/>
        <title>[Admin]Check Orders</title>
    </head>
    <body>
            <header >
                    <div class="row">
                        <div class="col-md-8 col-md-offset-3 col-sm-8 col-sm-offset-1 col-xs-10 col-xs-offset-1">
                            <span class="text-muted">
                                <h1 id="head-text">EntertainME [ADMIN] </h1>
                            </span>
                        </div>
            </header>
            <nav role="navigation" class="nav nav-tabs" id="mynav">
                <div class="row" id="navtext">
                    <a href="AddProduct.jsp" class="col-md-2 col-sm-2  col-xs-2  ">Add Product</a>
                    <a href="DeleteProduct.jsp" class="col-md-2 col-sm-2 col-xs-2"> Delete Product </a>
                    <a href="CheckOrders.jsp" class="col-md-2 col-sm-2 col-xs-2">Check Orders</a>
                    <a href="LogOutController" class="col-md-1 col-sm-2  col-xs-2 "><p >Logout</p></a>
                   
                </div>
                     </nav>
        
               
            <form method="post" action="DeleteOrderController">
                <h1>Check and delete completed orders:</h1>
                <div class="form-element">
                    <label for="name">Orders</label>
                </div>
                <div id="nav">
                <%for (Order f : orders) {%>
                <div class="form-element">
                    <input type="radio" name="order" value="<%=f.getId()%>"><%=f.toString()%><br>
                </div>
                <%}%>
                </div>
                <div class="form-element">
                    <input type="submit" value="Remove Order">
                </div>
                <%if (request.getAttribute("del") != null) {%>
            <label> <%=request.getAttribute("del")%></label>
            <%}%>

            </form>
            
    </body>
</html>
