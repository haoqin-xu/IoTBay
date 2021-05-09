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
public class OrderLineItem implements Serializable{
    private int DeviceID;
    private int OrderID;
    private int count;

    public OrderLineItem(int DeviceID, int OrderID, int count) {
        this.DeviceID = DeviceID;
        this.OrderID = OrderID;
        this.count = count;
    }

    public int getDeviceID() {
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
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
