package Model;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lex
 */
public class Product implements Serializable {
    String name, type, description, imgPath, imgName;
    int id,unitPrice;

    public Product(int id, String name, String type, String description, int unitPrice, String imgPath, String imgName) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.imgPath = imgPath;
        this.imgName = imgName;
        this.id = id;
        this.unitPrice = unitPrice;
    }
    

    public Product( String name, String type, String description, int unitPrice, String imgPath, String imgName) {
        
        this.name = name;
        this.type = type;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imgPath = imgPath;
        this.imgName = imgName;
        
        
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getImgName() {
        return imgName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.imgPath);
        hash = 97 * hash + Objects.hashCode(this.imgName);
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.unitPrice;
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.unitPrice != other.unitPrice) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.imgPath, other.imgPath)) {
            return false;
        }
        if (!Objects.equals(this.imgName, other.imgName)) {
            return false;
        }
        return true;
    }


    public HashMap getProducts() throws ClassNotFoundException, SQLException {
        HashMap<Integer, Product> productsList = new HashMap();
        
        try {    
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("jdbc/myDatasource");
            Connection con = ds.getConnection();
            
            Statement instr = con.createStatement();
            String sql = "SELECT * FROM PRODUCTS p;";
            ResultSet rs = instr.executeQuery(sql);
            
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("type"),
                        rs.getString("description"), rs.getInt("unit_price"), rs.getString("img_path"), 
                        rs.getString("img_name"));
                productsList.put(p.getId(), p);
            }
            
            rs.close();
            instr.close();
            con.close();
        } catch (NamingException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }

        return productsList;
    }
    
    public int getPrice(int id) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost:3306/wasLab2";
        Connection con = DriverManager.getConnection(url,  "lex", "lex");
        Statement instr = con.createStatement();
        String sql = "SELECT unit_price FROM PRODUCTS p WHERE p.id='"+id+"';";

        ResultSet rs = instr.executeQuery(sql);
        int val = 0;
        rs.next();
        val = rs.getInt("unit_price");

        rs.close(); 
        instr.close();
        con.close(); 

        return val;
    }
    
    public void saveToDb(){
        try {
            try { 
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        String url = "jdbc:mysql://localhost:3306/wasLab2";
        Connection con = DriverManager.getConnection(url,  "lex", "lex");
            Statement instr = con.createStatement();
            String sql = "INSERT INTO PRODUCTS VALUES(NULL,'" + this.name + 
                    "','" + this.type + "','" + this.description + "','" + this.unitPrice +
                    "','" + this.imgPath + "','" + this.imgName + "');";
            
            System.out.println("TEEEEST");
            System.out.println(sql);
            instr.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
