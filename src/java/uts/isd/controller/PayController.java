/**
 *
 * @author Briana Margetts
 */
package uts.isd.controller;

import uts.isd.model.Payment;

import uts.isd.model.dao.PaymentManager;

import java.io.IOException;

import java.sql.SQLException;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



public class PayController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
                                       throws ServletException, java.io.IOException {

      /*  try
        {	    

             int CustomerID = Integer.parseInt(request.getParameter("un"));
             String Paymentmethod = (request.getParameter("un"));
             String Accountnumber = (request.getParameter("un"));
             int Ccv= Integer.parseInt(request.getParameter("un"));
             double Ammount= Double.parseDouble(request.getParameter(""));
             String Date = (request.getParameter("un"));
             
             Payment payment = new Payment(CustomerID,Paymentmethod,Accountnumber,Ccv,Ammount,Date);


             if (payment.isValid())
             {

                  HttpSession session = request.getSession(true);	    
                  session.setAttribute("currentSessionPayment",payment); 
                  response.sendRedirect("payview.jsp");       		
             }

             else 
                 // an error messgage saying "incorrect information" pops up for paycreate.jsp
                  request.setAttribute("error","error"); 

        } 


        catch (Throwable theException) 	    
        {
             System.out.println(theException);     
        }*/
    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // retrieve the current session
        HttpSession session = request.getSession();
        
             int CustomerID = Integer.parseInt(request.getParameter("un"));
             String Paymentmethod = (request.getParameter("un"));
             String Accountnumber = (request.getParameter("un"));
             int Ccv= Integer.parseInt(request.getParameter("un"));
             double Ammount= Double.parseDouble(request.getParameter(""));
             String Date = (request.getParameter("un"));
             
        
        PaymentManager payment = (PaymentManager) session.getAttribute("manager");

        try{
            //Payment payment = new Payment(CustomerID,Paymentmethod,Accountnumber,Ccv,Ammount,Date);

        }
        
        catch (Throwable theException) 	    
        {
             System.out.println(theException);     
        }
         payment = null; 
    }
}


    

