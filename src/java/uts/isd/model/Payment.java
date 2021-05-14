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
public class Payment implements Serializable{
    private int paymentid;
    private int methodid;
    private double ammount;
    private String date;
    
        public Payment(){
        
        }
        public Payment(int paymentid, int methodid, double ammount, String date) {
        this.paymentid = paymentid;
        this.methodid = methodid;
        this.ammount = ammount;
        this.date = date;
        }

        public int getPaymentid() {
            return paymentid;
        }

        public void setPaymentid(int paymentid) {
            this.paymentid = paymentid;
        }

        public int getMethodid() {
            return methodid;
        }

        public void setMethodid(int methodid) {
            this.methodid = methodid;
        }

        public double getAmmount() {
            return ammount;
        }

        public void setAmmount(double ammount) {
            this.ammount = ammount;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
}
    

