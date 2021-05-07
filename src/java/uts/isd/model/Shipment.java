/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author 61452
 */
public class Shipment implements Serializable{
    private int orderID;
    private String shippingdate;
    private String status;
    private String shippingaddress;

    public Shipment(int orderID, String shippingdate, String status, String shippingaddress) {
        this.orderID = orderID;
        this.shippingdate = shippingdate;
        this.status = status;
        this.shippingaddress = shippingaddress;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getShippingdate() {
        return shippingdate;
    }

    public String getStatus() {
        return status;
    }

    public String getShippingaddress() {
        return shippingaddress;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setShippingdate(String shippingdate) {
        this.shippingdate = shippingdate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
    }
    
}
