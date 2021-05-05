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
public class Order implements Serializable{
    private int staffID;
    private int paymentID;
    private int deviceID;
    private String status;
    private int invoiceID;
    private String deliveryDate;

    public Order(int staffID, int paymentID, int deviceID, String status, int invoiceID, String deliveryDate) {
        this.staffID = staffID;
        this.paymentID = paymentID;
        this.deviceID = deviceID;
        this.status = status;
        this.invoiceID = invoiceID;
        this.deliveryDate = deliveryDate;
    }

    public int getStaffID() {
        return staffID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public String getStatus() {
        return status;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
        
}
