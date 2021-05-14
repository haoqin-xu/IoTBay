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
        DeviceManager devicemanager = (DeviceManager) session.getAttribute("devicemanager");
        
         
        Validator validator = new Validator();
        
        
        Customer customerObj = (Customer) session.getAttribute("user");
        // retrieving anonymous user
        int customerid = customerObj.getID();
       // int customerid = Integer.parseInt(request.getParameter("customerid"));
        
       // retrieving anonymous payment
        int paymentid = Integer.parseInt(session.getAttribute("randompaymentid").toString());
       
        //int paymentid = Integer.parseInt(request.getParameter("paymentid"));
        
        
        int deviceid = Integer.parseInt(request.getParameter("deviceid"));
        
        int invoiceid = Integer.parseInt(session.getAttribute("invoiceid").toString());
        
        String date = session.getAttribute("date").toString();
        int count = Integer.parseInt(request.getParameter("count"));
        validator.clear(session);
        //5- retrieve the manager instance from session
       
        PrintWriter ps = response.getWriter();
        ps.print(customerid);
     
        try {
            devicemanager.updateDeviceCount(deviceid,count);
            manager.createOrder(customerid, paymentid, deviceid, invoiceid, date);
            orderlinemanager.addOrderline(deviceid,count);
            
           
           
         
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("CreateOrder.jsp").include(request, response);
        
        
        
            
        
    }
}
    
