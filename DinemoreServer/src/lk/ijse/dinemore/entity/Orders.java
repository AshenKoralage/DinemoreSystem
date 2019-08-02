/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Ashen Koralage
 */
@Entity
public class Orders {

    @Id
    private String orderId;
    private String receptionID;
    private String date;
    private String time;
    private String customerName;
    private String tp;
    private String qty;

    public Orders() {
    }

    public Orders(String orderId, String receptionID, String date, String time, String customerName, String tp, String qty) {
        this.orderId = orderId;
        this.receptionID = receptionID;
        this.date = date;
        this.time = time;
        this.customerName = customerName;
        this.tp = tp;
        this.qty = qty;
        
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReceptionID() {
        return receptionID;
    }

    public void setReceptionID(String receptionID) {
        this.receptionID = receptionID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

}
