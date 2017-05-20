/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Shoby
 */
public class Order {
    private int id;
    private ArrayList<Product> products;
    private int totalPrice;

    public Order(ArrayList<Product> products, int totalPrice) {
        this.products = products;
        this.totalPrice = totalPrice;
    }
    public Order(ArrayList<Product> products, int totalPrice, int id) {
        this.products = products;
        this.totalPrice = totalPrice;
        this.id=id;
    }

    public Order() {
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Order{" + "products=" + products + ", totalPrice=" + totalPrice + '}';
    }
    
}
