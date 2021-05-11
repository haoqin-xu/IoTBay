/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.SQLException;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import uts.isd.model.*;

import uts.isd.model.dao.*;

public class OrderController extends HttpServlet {
        
           
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //1- retrieve the current session
        HttpSession session = request.getSession();
        OrderLineManager orderlinemanager = (OrderLineManager)session.getAttribute("orderlinemanager");
        OrderManager manager = (OrderManager) session.getAttribute("ordermanager");
        //2- create an instance of the Validator class 
        Validator validator = new Validator();
        Order order = null;
        //3- capture the posted email
        
        int customerid = Integer.parseInt(request.getParameter("customerid"));
        int paymentid = Integer.parseInt(request.getParameter("paymentid"));
        int deviceid = Integer.parseInt(request.getParameter("deviceid"));
        
        String status = request.getParameter("status");
        int invoiceid = Integer.parseInt(request.getParameter("invoiceid"));
        String date = request.getParameter("date");
        int count = Integer.parseInt(request.getParameter("count"));
        validator.clear(session);
        //5- retrieve the manager instance from session
       
        PrintWriter ps = response.getWriter();
        ps.print(customerid);
        
     
        try {
         
            manager.createOrder(customerid, paymentid, deviceid, status, invoiceid, date);
            orderlinemanager.addOrderline(deviceid,count);
       
           
         
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("CreateOrder.jsp").include(request, response);
        
        
        
            
        
    }
}
    
