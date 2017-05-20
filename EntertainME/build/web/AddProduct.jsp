
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="style1.css" type="text/css"/>
        <title>[Admin]Add Food</title>
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
                    <a href="AddProduct.jsp" class="col-md-2 col-sm-2  col-xs-2  ">Add Products</a>
                    <a href="DeleteProduct.jsp" class="col-md-2 col-sm-2 col-xs-2"> Delete Products </a>                 
                    <a href="CheckOrders.jsp" class="col-md-2 col-sm-2 col-xs-2">Check Orders</a>
                    <a href="LogOutController" class="col-md-1 col-sm-2  col-xs-2 "><p >Logout</p></a>
                   
                </div>
                     </nav>
              
            <form method="post" action="AddProductsController">
                <h1>Add Product:</h1> 
                <div class="form-element">
                    <label for="name">Product name:</label>
                    <input type="text" name="name" id="name" required>
                </div>
                <div class="form-element">
                    <label for="type">Type of food:</label>
                    <select name="type" id="type" required>
                        <option value="books">Book</option>
                        <option value="games">Game</option>
                        <option value="movies">Movie</option>                    
                    </select>
                </div>
                <div class="form-element">
                    <label for="description">Description:</label>
                    <input type="text" name="description" id="description" required>
                </div>
                <div class="form-element">
                    <label for="quantity">Quantity:</label>
                    <input type="number" name="quantity" id="quantity" required>
                </div>
                <div class="form-element">
                    <label for="unitPrice">Unit Price:</label>
                    <input type="number"  name="price" id="price" required>
                </div>             
                <div class="form-element">
                    <input type="submit" value="Add Product">
                    <input type="reset" value="Reset">
                </div>
                <div class="form-element">
                    <%if (request.getAttribute("msg") != null) {%>
                    <label> <%=request.getAttribute("msg")%></label>
                    <%}%>

                </div>

            </form>
            

    </body>

</html>