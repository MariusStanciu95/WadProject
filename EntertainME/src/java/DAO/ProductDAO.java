/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connection.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import domain.Product;

/**
 *
 * @author Shoby
 */
public class ProductDAO {
    private Connection conn;
    private static ProductDAO instance;
    
    public static ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }
    
    public ProductDAO(){
        
    };
    
    public boolean insertProduct(String name, String type, String description, int quantity, int unitPrice){
        conn = DataBase.getConnection();
        try {
            PreparedStatement statement = conn.prepareStatement("insert into foods values (default, ?, ?, ?, ? ,?)");
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setString(3, description);
            statement.setInt(4, quantity);
            statement.setInt(5, unitPrice);
          
            if(!productExists(name)){
                statement.executeUpdate();
                conn.commit();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return false;
    }
    
    public boolean productExists(String name) throws SQLException{
    conn=DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM products where name = ?");
        statement.setString(1,name);
        ResultSet rs = statement.executeQuery();
        if (rs.next()){
            rs.close();
            return true;
        }
        return false;
    }
    
    public int getProductId(String name) throws SQLException{
        conn=DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM products where name = ?");
        statement.setString(1,name);
        ResultSet rs = statement.executeQuery();
        if (rs.next()){
            return rs.getInt("id");
        }
        rs.close();
        return -1;
    }
    
    public ArrayList<Product> getProducts() {
        conn=DataBase.getConnection();
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement prepStmt = conn.prepareStatement("select  * from products");
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getString("name"), rs.getString("type"), rs.getString("description"), Integer.parseInt(rs.getString("unitPrice")),  Integer.parseInt(rs.getString("quantity"))));
            }
            prepStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return products;
    }
    
    public ArrayList<Product> getProductsByType(String type) {
        conn=DataBase.getConnection();
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM products WHERE type = ?");
            prepStmt.setString(1, type);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                products.add(new Product(rs.getString("name"), rs.getString("type"), rs.getString("description"), Integer.parseInt(rs.getString("unitPrice")),  Integer.parseInt(rs.getString("quantity"))));
            }
            prepStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return products;
    }
    
    public void deleteProduct(String name) throws SQLException{
        conn=DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM products WHERE name = ?");
        statement.setString(1,name);
        statement.executeUpdate();
        conn.commit();
    }
}
