/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Riel
 */
public class Account {
    private int aid;
    private String email;
    private String password;
    private boolean is_admin;
    private String name;
    private String phone;
    private String address;

    public Account() {
    }

    public Account(String email, String password, boolean is_admin, String name, String phone, String address) {
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Account(String email, String password, boolean is_admin, String name) {
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
        this.name = name;
    }
    
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" + "aid=" + aid + ", email=" + email + ", password=" + password + ", is_admin=" + is_admin + ", name=" + name + ", phone=" + phone + ", address=" + address + '}';
    }

    
}
