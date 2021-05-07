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
public class OrderLineItem implements Serializable{
    private int deviceID;
    private int orderID;
    private int count;

    public OrderLineItem(int deviceID, int orderID, int count) {
        this.deviceID = deviceID;
        this.orderID = orderID;
=======
/**
 *
 * @author Alec
 */
public class OrderLineItem {
    private int DeviceID;
    private int OrderID;
    private int count;

    public OrderLineItem(int DeviceID, int OrderID, int count) {
        this.DeviceID = DeviceID;
        this.OrderID = OrderID;
>>>>>>> e87842fbae36e822a7bd3a4d7db7b8bb594fea70
        this.count = count;
    }

    public int getDeviceID() {
<<<<<<< HEAD
        return deviceID;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getCount() {
        return count;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
=======
        return DeviceID;
    }

    public void setDeviceID(int DeviceID) {
        this.DeviceID = DeviceID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getCount() {
        return count;
>>>>>>> e87842fbae36e822a7bd3a4d7db7b8bb594fea70
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
