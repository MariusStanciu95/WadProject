
<%@page import="DAO.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    ProductDAO productDao = ProductDAO.getInstance();
    ArrayList<domain.Product> products = productDao.getProducts();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="style1.css" type="text/css"/>
        <title>Delete Product [Admin]</title>
    </head>
    <body>
            <header >
                    <div class="row">
                        <div class="col-md-8 col-md-offset-3 col-sm-8 col-sm-offset-1 col-xs-10 col-xs-offset-1">
                            <span class="text-muted">
                                <h1 id="head-text">EntertainMe [ADMIN] </h1>
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
        
               
            <form method="post" action="DeleteProductsController">
                <h1>Select a product item to delete:</h1>
                <div class="form-element">
                    <label for="name">Products</label>
                </div>
                <div id="nav">
                <%for (Product prod : products) {%>
                <div class="form-element">
                    <input type="radio" name="food" value="<%=prod.getName()%>"><%=prod.getName()+" Quantity:"+prod.getQuantity() +"Price:"+prod.getUnitPrice()%><br>
                </div>
                <%}%>
                </div>
                <div class="form-element">
                    <input type="submit" value="Remove Product">
                </div>
                <%if (request.getAttribute("del") != null) {%>
            <label> <%=request.getAttribute("del")%></label>
            <%}%>

            </form>
            
           
    </body>
</html>