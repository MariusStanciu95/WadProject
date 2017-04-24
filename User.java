package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lex
 */
public class User {
    
    String username, password, type, email, country;
    char gender;
    int id, tel;
    boolean subscribed;

    public User(String username, String password, String type, String email, String country, char gender, int tel, boolean subscribed) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.email = email;
        this.country = country;
        this.gender = gender;
        this.tel = tel;
        this.subscribed = subscribed;
    }
    public User(){
        
    }
    
    public int getId(){
        return this.id;
    }

    public String getType() {
        return this.type;
    }
    
    public void setIdFromDb(String Username){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:mysql://localhost:3306/wasLab2";
            Connection con = DriverManager.getConnection(url,  "lex", "lex");
            Statement instr = con.createStatement();
            String sql = "SELECT u.id FROM USERS u where u.Username='"+Username+"'";
            ResultSet rs = instr.executeQuery(sql);
            rs.next();
            int i = rs.getInt("id");
            this.id = i;
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setTypeFromDb(String Username){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:mysql://localhost:3306/wasLab2";
            Connection con = DriverManager.getConnection(url,  "lex", "lex");
            Statement instr = con.createStatement();
            String sql = "SELECT u.type FROM USERS u where u.Username='"+Username+"'";
            ResultSet rs = instr.executeQuery(sql);
            rs.next();
            String i = rs.getString("type");
            this.type = i;
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean userExists(String username) throws SQLException, ClassNotFoundException{
        
        Class.forName("com.mysql.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost:3306/wasLab2";
        Connection con = DriverManager.getConnection(url,  "lex", "lex");
        Statement instr = con.createStatement();
        String sql = "SELECT * FROM USERS u where u.Username='"+username+"'";
        ResultSet rs = instr.executeQuery(sql);
        boolean resp;
        resp = rs.next();
        
        rs.close(); 
        instr.close();
        con.close(); 
        
        return resp;
    }
    
    public boolean passwordMatch(String username, String password) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost:3306/wasLab2";
        Connection con = DriverManager.getConnection(url,  "lex", "lex");
        Statement instr = con.createStatement();
        String sql = "SELECT * FROM USERS u where u.Username='"+username+"' and u.password=md5('"+password+"');";
        ResultSet rs = instr.executeQuery(sql);
        boolean resp;
        resp = rs.next();
        
        rs.close(); 
        instr.close();
        con.close(); 

        return resp;
        
    }
    
}

