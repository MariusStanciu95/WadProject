/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import connection.DataBase;
import connection.Hash;
import domain.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shoby
 */
public class UserDAO {

    private Connection conn;
    private static UserDAO instance;

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public UserDAO() {

    }

    ;
    
    public boolean insertUser(String uname, String password, String fname, String lname, String phone, String email, char gender, int subs, int admin) {
        conn = DataBase.getConnection();
        try {
            PreparedStatement statement = conn.prepareStatement("insert into users values (default, ?, ?, ?, ? ,?, ?, ?, ?, ?)");
            statement.setString(1, uname);
            statement.setString(2, Hash.getHash(password));
            statement.setString(3, fname);
            statement.setString(4, lname);
            statement.setString(5, phone);
            statement.setString(6, email);
            statement.setString(7, Character.toString(gender));
            statement.setString(8, Integer.toString(subs));
            statement.setString(9, Integer.toString(admin));
            statement.executeUpdate();
            conn.commit();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean checkPassword(String uname, String pass) {
        conn = DataBase.getConnection();
        try {
            PreparedStatement prepStmt
                    = conn.prepareStatement("select * from users u where u.username = ? and u.password = ?");
            prepStmt.setString(1, uname);
            prepStmt.setString(2, Hash.getHash(pass));
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                rs.close();
                System.out.println("true");
                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("false");
        return false;
    }

    public boolean userExists(String uname) throws SQLException {
        conn = DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM users where username = ?");
        statement.setString(1, uname);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            rs.close();
            return true;
        }
        return false;
    }

    public Integer getUserId(String name) throws SQLException {
        int id = -1;
        conn = DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM users where username = ?");
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id");
        }

        return id;
    }

    public boolean isAdmin(String uname) throws SQLException {
        conn = DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM users where username = ? AND admin=1");
        statement.setString(1, uname);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            rs.close();
            return true;
        }
        return false;
    }

    public User getUserInfo(String uname) throws SQLException {
        User u = new User();
        conn = DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM users where username = ?");
        statement.setString(1, uname);
        ResultSet rs = statement.executeQuery();
        if (rs.next()){
            u.setUsername(uname);
            u.setPassword("--Confidential Info--");
            u.setFname(rs.getString("fname"));
            u.setLname(rs.getString("lname"));
            u.setPhone(rs.getString("phone"));
            u.setEmail(rs.getString("email"));
        }
        return u;
    }
}
