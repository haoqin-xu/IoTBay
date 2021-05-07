/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

<<<<<<< HEAD
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
        
=======
/**
 *
 * @author Alec
 */
public class Order {
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
    
>>>>>>> e87842fbae36e822a7bd3a4d7db7b8bb594fea70
}
