/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;
import java.io.Serializable;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Briana Margetts
 */
public class PaymentValidator implements Serializable{

    public PaymentValidator() {
    }
    
    public void clear(HttpSession session){
        session.setAttribute("customerID","");
        session.setAttribute("paymentmethod","");
        session.setAttribute("accountnumber","");
        session.setAttribute("ccv","");
        session.setAttribute("ammount","");
        session.setAttribute("date","");
    }
    
    
}
