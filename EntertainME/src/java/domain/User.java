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
public class User {
    private String username, password, fname, lname, phone, email;
    private char gender;
    private boolean newsletter, admin;

    public User() {
    }
    
    public User(String username, String password, String fname, String lname, String phone, String email, char gender, boolean newsletter, boolean admin) {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.newsletter = newsletter;
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + ", email=" + email + ", gender=" + gender + ", newsletter=" + newsletter + ", admin=" + admin + '}';
    }

    
    
}
