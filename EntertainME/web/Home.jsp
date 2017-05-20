<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Home</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script >
            var i = 0;
              function changeImg(){
                  i++;
                var img = ["http://www.geforce.com/sites/default/files-world/attachments/gametiles.jpg",
                "http://www.ptmusicboosters.com/wp-content/uploads/2017/04/clipartbest-com-2JDmK0-clipart.jpeg",
                "http://cdn.hercampus.com/s3fs-public/2016/12/12/books_0.jpg"];
                  $("#slider").fadeOut(800, function() {
                $("#slider").attr('src',img[i%4]);}).fadeIn(800); 
               setTimeout(function(){
                    changeImg();},3000); 
            }   
        </script>
    </head>
    <body onload="changeImg()">
        
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
                <img id="slider" src="http://www.designboom.com/wp-content/uploads/2016/02/serrano-baquero-arquitectos-raccoon-games-shop-interior-seville-designboom-02.jpg">
                
            </div>
            <div id="footer">Web Application Development Project</div>
        </div>
        <div id="right">
                 
        </div>
        

    </body>

</html>