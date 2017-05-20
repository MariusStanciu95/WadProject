/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connection.DataBase;
import domain.Product;
import domain.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Shoby
 */
public class OrderDAO {
     private Connection conn;
    private static OrderDAO instance;
    UserDAO userDAO = new UserDAO();
    ProductDAO productDAO = new ProductDAO();
    public static OrderDAO getInstance() {
        if (instance == null) {
            instance = new OrderDAO();
        }
        return instance;
    }
    
    public OrderDAO(){
        
    };
    
    public void insertOrder(String username, int totalPrice) throws SQLException{
        conn = DataBase.getConnection();
        int userId = userDAO.getUserId(username);
        PreparedStatement statement = conn.prepareStatement("INSERT INTO orders VALUES(default, ?, ?)");
        statement.setInt(1, userId);
        statement.setInt(2, totalPrice);
        statement.executeUpdate();
        conn.commit();
    }
    
    public void mapProduct_Order(ArrayList<Product> products) throws SQLException{
        conn=DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT id FROM orders GROUP BY id DESC LIMIT 1");
        ResultSet rs = statement.executeQuery();
        rs.next();
        int orderId = rs.getInt("id");
        rs.close();
        for(Product p : products){
            PreparedStatement s = conn.prepareStatement("SELECT id FROM products WHERE name=?");
            s.setString(1,p.getName());
            rs = s.executeQuery();
            rs.next();
            int productId = rs.getInt("id");
            rs.close();
            PreparedStatement statement1 = conn.prepareStatement("INSERT INTO product_order VALUES (default, ?, ?, ?)");
            statement1.setInt(1, orderId);
            statement1.setInt(2, productId);
            statement1.setInt(3, p.getUnitPrice());
            statement1.executeUpdate();
            conn.commit();
            
        }
    }
    
    public ArrayList<Order> getUserOrders(int userId) throws SQLException{
        conn = DataBase.getConnection();
        ArrayList<Order> orders = new ArrayList<Order>();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        PreparedStatement statement = conn.prepareStatement("SELECT id FROM orders WHERE user_id = " + userId + ";");
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            ids.add(rs.getInt("id"));
        }
        rs.close();
        
        for(int i : ids){
            ArrayList<Product> products = new ArrayList<Product>();
            int totalPrice;
                        
            statement = conn.prepareStatement("SELECT name, quantity, unitPrice FROM products WHERE id IN (SELECT product_id FROM product_order WHERE order_id = "+ i +");");
            rs = statement.executeQuery();
            while(rs.next()){
                Product p = new Product(rs.getString("name"), rs.getInt("unitPrice"), rs.getInt("quantity"));
                products.add(p);
            }
            rs.close();
            
            statement = conn.prepareStatement("SELECT total_price FROM orders WHERE id = "+i+";");
            rs = statement.executeQuery();
            rs.next();
            totalPrice = rs.getInt("total_price");
            
            orders.add(new Order(products, totalPrice));
        }
        return orders;
    }
    
    public ArrayList<Order> getAllOrders() throws SQLException{
        conn = DataBase.getConnection();
        ArrayList<Order> orders = new ArrayList<Order>();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        PreparedStatement statement = conn.prepareStatement("SELECT id FROM orders;");
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            ids.add(rs.getInt("id"));
        }
        rs.close();
        
        for(int i : ids){
            ArrayList<Product> products = new ArrayList<Product>();
            int totalPrice;
                       
            statement = conn.prepareStatement("SELECT name, quantity, unitPrice FROM foods WHERE id IN (SELECT product_id FROM product_order WHERE order_id = "+ i +");");
            rs = statement.executeQuery();
            while(rs.next()){
                Product p = new Product(rs.getString("name"), rs.getInt("unitPrice"), rs.getInt("quantity"));
                products.add(p);
            }
            rs.close();
            
            statement = conn.prepareStatement("SELECT total_price FROM orders WHERE id = "+i+";");
            rs = statement.executeQuery();
            rs.next();
            totalPrice = rs.getInt("total_price");
            
            orders.add(new Order(products, totalPrice, i));
        }
        return orders;
    }
    
    public void deleteOrder(String orderName) throws SQLException{
        conn=DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM orders WHERE id = ?");
        statement.setString(1,orderName);
        statement.executeUpdate();
        conn.commit();
    }
}
