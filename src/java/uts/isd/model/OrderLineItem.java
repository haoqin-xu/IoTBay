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
public class OrderLineItem implements Serializable{
    private int deviceID;
    private int orderID;
    private int count;

    public OrderLineItem(int deviceID, int orderID, int count) {
        this.deviceID = deviceID;
        this.orderID = orderID;
        this.count = count;
    }

    public int getDeviceID() {
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
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
