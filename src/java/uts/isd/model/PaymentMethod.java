/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;
import java.io.Serializable;

/**
 *
 * @author Briana Margetts
 */   
public class PaymentMethod implements Serializable{
    private int customerid;
    private String paymenttype;
    private int accountnumber;
    private int ccv;
    
        public PaymentMethod(){
        
        
        }
        
        public PaymentMethod( int customerid, String paymenttype, int accountnumber, int ccv) {
        this.customerid = customerid;
        this.paymenttype = paymenttype;
        this.accountnumber = accountnumber;
        this.ccv = ccv;
        }

        
        public int getCustomerid() {
            return customerid;
        }

        public void setCustomerid(int customerid) {
            this.customerid = customerid;
        }

        public String getPaymenttype() {
            return paymenttype;
        }

        public void setPaymenttype(String paymenttype) {
            this.paymenttype = paymenttype;
        }

        public int getAccountnumber() {
            return accountnumber;
        }

        public void setAccountnumber(int accountnumberl) {
            this.accountnumber = accountnumberl;
        }

        public int getCcv() {
            return ccv;
        }

        public void setCcv(int ccv) {
            this.ccv = ccv;
        }
}
