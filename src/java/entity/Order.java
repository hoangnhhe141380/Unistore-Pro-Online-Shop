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
public class Order {
    private int oid;
    private Date date;
    private Account account;
    private String status;
    private List<Order_Detail> listOrderDetail;

    public Order() {
    }

    public Order(Date date, Account account, String status, List<Order_Detail> listOrderDetail) {
        this.date = date;
        this.account = account;
        this.status = status;
        this.listOrderDetail = listOrderDetail;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Order_Detail> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(List<Order_Detail> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }
    
    
}
