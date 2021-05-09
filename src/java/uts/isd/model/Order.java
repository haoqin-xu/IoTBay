/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author Alec
 */
public class Order implements Serializable{
    private int OrderID;
    private int CustomerID;
    private int PaymentID;
    private int DeviceID;
    private String Status;
    private int InvoiceID;
    private String Date;
    
    //object creation
    public Order(int CustomerID, int PaymentID, int DeviceID, String Status, int InvoiceID, String Date) {
        this.CustomerID = CustomerID;
        this.PaymentID = PaymentID;
        this.DeviceID = DeviceID;
        this.Status = Status;
        this.InvoiceID = InvoiceID;
        this.Date = Date;
    }
    //session storage
    public Order(int OrderID, int CustomerID, int PaymentID, int DeviceID, String Status, int InvoiceID, String Date) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.PaymentID = PaymentID;
        this.DeviceID = DeviceID;
        this.Status = Status;
        this.InvoiceID = InvoiceID;
        this.Date = Date;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int StaffID) {
        this.CustomerID = CustomerID;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public int getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(int DeviceID) {
        this.DeviceID = DeviceID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int InvoiceID) {
        this.InvoiceID = InvoiceID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
}
