package controllers;

import DAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Checks if the username already exists. If exists the login page is reloaded.
 * If not the user is added in the database and the home page is reloaded
 */
//@WebServlet(name = "registrationController")
public class RegisterController extends HttpServlet {
    UserDAO userDAO=UserDAO.getInstance();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        RequestDispatcher rd;
            String error ="";
            boolean hasErrors=false;
            String username=request.getParameter("uname");
            String password=request.getParameter("password");
            String fname=request.getParameter("fname");
            String lname=request.getParameter("lname");
            String phone=request.getParameter("phone");
            String email=request.getParameter("email");
            char gender=request.getParameter("gender").substring(0, 1).toCharArray()[0];
      
            
            boolean spam=request.getParameter("spam")!=null && 
                    request.getParameter("spam").equals("on");
            if(userDAO.userExists(username)){
                hasErrors=true;
                error="Username already exists";
            }
            if(hasErrors){
            request.setAttribute("ERRORS", error);
            rd = request.getRequestDispatcher("/Register.jsp");
            rd.forward(request, response);
            }
            else{
            userDAO.insertUser(username, password,fname, lname, phone, email, gender, spam ? 1:0, 0);
            rd = request.getRequestDispatcher("/Home.jsp");
            rd.forward(request, response);
            }
                


        
    }
}
