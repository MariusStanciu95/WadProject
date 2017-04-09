/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lex
 */
public class Order {
    int id;
    int userId;
    int totalPrice;
    int noItems;
    Date date;

    public Order(int userId, int totalPrice, int noItems, Date date) {
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.noItems = noItems;
        this.date = date;
    }

    public Order(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getNoItems() {
        return noItems;
    }

    public int getUserId() {
        return userId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void saveToDb(){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:mysql://localhost:3306/wasLab2";
            Connection con = DriverManager.getConnection(url, "lex", "lex");
            Statement instr = con.createStatement();
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String sql = "INSERT INTO ORDERS VALUES(NULL,'" + this.userId + "','" + this.totalPrice + "','" + this.noItems + "','" + dateFormat.format(this.date) + "');";
            System.out.println(sql);
            instr.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Order> getUserOrders(){

        ArrayList ordersList = new ArrayList();
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:mysql://localhost:3306/wasLab2";
            Connection con = DriverManager.getConnection(url, "lex", "lex");
            Statement instr = con.createStatement();
            String sql = "SELECT * FROM ORDERS WHERE userId = " + this.userId + ";";
            ResultSet rs = instr.executeQuery(sql);

            while (rs.next()) {
                Order p = new Order(rs.getInt("id"), rs.getInt("userId"), rs.getInt("totalPrice"), rs.getInt("noItems"), rs.getDate("date"));
                ordersList.add(p);
            }

            rs.close(); 
            instr.close();
            con.close(); 
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ordersList;
    }

    public Order(int id, int userId, int totalPrice, int noItems, Date date) {
        this.id = id;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.noItems = noItems;
        this.date = date;
    }
    
}
