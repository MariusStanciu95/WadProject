/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Shoby
 */
public class DataBase {

    private static Connection conn;
    public static Connection getConnection() {
        if (conn == null) {
            try {
            String url = "jdbc:mysql://localhost/project";
            String user = "root";
            String password = "123456";
            String driver="com.mysql.jdbc.Driver";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
        }  catch (ClassNotFoundException e) {
            System.err.println("Could not load db driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Could not open db connction");
            e.printStackTrace();
        }
        }
        return conn;
    }
}


