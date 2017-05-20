<%@page import="DAO.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ProductDAO productDAO = ProductDAO.getInstance();
    ArrayList<domain.Product> books = (ArrayList<domain.Product>)request.getServletContext().getAttribute("Books");
    ArrayList<domain.Product> games = (ArrayList<domain.Product>)request.getServletContext().getAttribute("Games");
    ArrayList<domain.Product> movies = (ArrayList<domain.Product>)request.getServletContext().getAttribute("Movies");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Products</title>
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
            <h1>Products</h1>
            <%if(request.getSession().getAttribute("user")!=null){%>
            <form method="post" action="CheckoutController">
                <div class="form-element">
                    <h3>Books:</h3>
                </div>
                   
                    <%for (int i = 0; i < books.size(); i++) {%>
                    <div class="form-element">
                    <input type="checkbox" name="check" value="<%=books.get(i).getName()+"#"+books.get(i).getQuantity() +"#"+books.get(i).getUnitPrice()%>"/>
                    <label> <%=books.get(i).getName()+" Quantity:"+books.get(i).getQuantity() +"g Price:"+books.get(i).getUnitPrice()%></label><br>
                    <label><%=" Description:"+books.get(i).getDescription() +"."%></label>
                    </div>
                    <%}%>
                
                <div class="form-element">
                    <h3>Movies:</h3>
                </div>
                
                    <%for (int i = 0; i < movies.size(); i++) {%>
                    <div class="form-element">
                    <input type="checkbox" name="check" value="<%=movies.get(i).getName()+"#"+movies.get(i).getQuantity() +"#"+movies.get(i).getUnitPrice()%>"/>
                    <label> <%=movies.get(i).getName()+" Quantity:"+movies.get(i).getQuantity() +"g Price:"+movies.get(i).getUnitPrice()%></label><br>
                    <label><%=" Description:"+movies.get(i).getDescription() +"."%></label>
                    </div>
                    <%}%>    
                
                <div class="form-element">
                    <h3>Games:</h3>
                </div>
                
                    <%for (int i = 0; i < games.size(); i++) {%>
                    <div class="form-element">
                    <input type="checkbox" name="check" value="<%=games.get(i).getName()+"#"+games.get(i).getQuantity() +"#"+games.get(i).getUnitPrice()%>"/>
                    <label> <%=games.get(i).getName()+" Quantity:"+games.get(i).getQuantity() +"g Price:"+games.get(i).getUnitPrice()%></label><br>
                    <label><%=" Description:"+games.get(i).getDescription() +"."%></label>
                    </div>
                    <%}%>
                    
               
                    
                <div class="form-element">
                    <input type="submit" value="Checkout">
                    <input type="reset" value="Cancel">
                </div>                 

            </form>
                    <%}else {%>
                    <div class="form-element">
                    <h3>Books: </h3>
                </div>
            
                    <%for (int i = 0; i < books.size(); i++) {%>
                    <div class="form-element">
                    <label> <%=books.get(i).getName()+" Quantity:"+books.get(i).getQuantity() +"g Price:"+books.get(i).getUnitPrice()%></label><br>
                    <label><%=" Description:"+books.get(i).getDescription() +"."%></label>
                    </div>
                    <%}%>
                
                <div class="form-element">
                    <h3>Movies:</h3>
                </div>
                
                    <%for (int i = 0; i < movies.size(); i++) {%>
                    <div class="form-element">
                    <label> <%=movies.get(i).getName()+" Quantity:"+movies.get(i).getQuantity() +"g Price:"+movies.get(i).getUnitPrice()%></label><br>
                    <label><%=" Description:"+movies.get(i).getDescription() +"."%></label>
                    </div>
                    <%}%>    
                
                <div class="form-element">
                    <h3>Games:</h3>
                </div>
                
                    <%for (int i = 0; i < games.size(); i++) {%>
                    <div class="form-element">
                    <label> <%=games.get(i).getName()+" Quantity:"+games.get(i).getQuantity() +"g Price:"+games.get(i).getUnitPrice()%></label><br>
                    <label><%=" Description:"+games.get(i).getDescription() +"."%></label>
                    </div>
                    <%}%>
                    
                
                    
               
                    <%}%>

           </div>
            <div id="footer">Web Application Development Project</div>
        </div>
        <div id="right">
                 
        </div>
        

    </body>

</html>