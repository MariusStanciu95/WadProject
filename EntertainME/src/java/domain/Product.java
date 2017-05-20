/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Shoby
 */
public class Product {
    
    private int id;
    private String name;
    private String type;
    private String description;
    private int unitPrice;
    private int quantity;
    private String imgName;
    private String imgPath;

    public Product(String name, String type, String description, int unitPrice, int quantity, String imgName, String imgPath) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.imgName = imgName;
        this.imgPath = imgPath;
    }

    public Product(int id, String name, String type, int unitPrice, int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Product(String name, String type, int unitPrice, int quantity) {
        this.name = name;
        this.type = type;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Product(String name, String type, String description, int unitPrice, int quantity) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }


    public Product(String name, int unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", quantity=" + quantity + '}';
    }
    
    
    
}
