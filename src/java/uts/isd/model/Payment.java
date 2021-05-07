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
public class Payment implements Serializable{
    private int customerID;
    private String paymentmethod;
    private String accountnumber;
    private int ccv;

    public Payment(int customerID, String paymentmethod, String accountnumber, int ccv) {
        this.customerID = customerID;
        this.paymentmethod = paymentmethod;
        this.accountnumber = accountnumber;
        this.ccv = ccv;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }
    
}
