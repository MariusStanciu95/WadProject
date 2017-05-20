/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;


import DAO.ProductDAO;
import domain.Product;
import java.util.ArrayList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Shoby
 */
public class ContextListener implements ServletContextListener {
    ProductDAO productDAO = ProductDAO.getInstance();
       
    @Override
    public void contextInitialized(ServletContextEvent sce) {
           
    ArrayList <Product> books = productDAO.getProductsByType("books");
    sce.getServletContext().setAttribute("books", books);
    
    ArrayList <Product> games = productDAO.getProductsByType("games");
    sce.getServletContext().setAttribute("games", games);
    
    ArrayList <Product> movies = productDAO.getProductsByType("movies");
    sce.getServletContext().setAttribute("movies", movies);
    
   
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
