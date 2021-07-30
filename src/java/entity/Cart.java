/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Riel
 */
public class Cart {

    private int oid;
    private Date date;
    private Account account;
    private List<Item> items;

    public Cart() {
    }

    public Cart(int oid, Date date, Account account, List<Item> items) {
        this.oid = oid;
        this.date = date;
        this.account = account;
        this.items = items;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public int getNumProduct(){
        return items.size();
    }
    
}
