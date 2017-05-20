/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shoby
 */
public class AdminRegisterController extends HttpServlet {
        UserDAO userDAO=UserDAO.getInstance();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            rd = request.getRequestDispatcher("/AdminRegister.jsp");
            rd.forward(request, response);
            }
            else{
            userDAO.insertUser(username, password,fname, lname, phone, email, gender, spam ? 1:0, 1);
            rd = request.getRequestDispatcher("/Admin.jsp");
            rd.forward(request, response);
            }
                


        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AdminRegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AdminRegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
