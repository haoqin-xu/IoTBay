/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

/**
 *
 * @author Alec
 */
public class Order {
    private int OrderID;
    private int StaffID;
    private int PaymentID;
    private int DeviceID;
    private String Status;
    private int InvoiceID;
    private String Date;
    
    //object creation
    public Order(int StaffID, int PaymentID, int DeviceID, String Status, int InvoiceID, String Date) {
        this.StaffID = StaffID;
        this.PaymentID = PaymentID;
        this.DeviceID = DeviceID;
        this.Status = Status;
        this.InvoiceID = InvoiceID;
        this.Date = Date;
    }
    //session storage
    public Order(int OrderID, int StaffID, int PaymentID, int DeviceID, String Status, int InvoiceID, String Date) {
        this.OrderID = OrderID;
        this.StaffID = StaffID;
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

    public int getStaffID() {
        return StaffID;
    }

    public void setStaffID(int StaffID) {
        this.StaffID = StaffID;
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
