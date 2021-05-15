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
        
         
        OrderValidator validator = new OrderValidator();
        validator.clear(session);
        
        
        Customer customerObj = (Customer) session.getAttribute("user");
        
        int customerid = customerObj.getID();
       
        int paymentid = Integer.parseInt(session.getAttribute("randompaymentid").toString());
       
        
        
        
        int deviceid;
        int count;
        int invoiceid = Integer.parseInt(session.getAttribute("invoiceid").toString());
        
        String date = session.getAttribute("date").toString();
        
        validator.clear(session);
        //5- retrieve the manager instance from session
       
        PrintWriter ps = response.getWriter();
        ps.print(customerid);
     
        try {
            deviceid = Integer.parseInt(request.getParameter("deviceid"));
            count = Integer.parseInt(request.getParameter("count"));
            session.setAttribute("successful", "Order successful");
            devicemanager.updateDeviceCount(deviceid,count);
            manager.createOrder(customerid, paymentid, deviceid, invoiceid, date);
            orderlinemanager.addOrderline(deviceid,count);
            
            
           
         
            
        } catch(NumberFormatException exd){
            //catch numberformat exception when user inputs string or blank
            session.setAttribute("notint", "Error: format incorrect");
            request.getRequestDispatcher("CreateOrder.jsp").include(request, response);
        } 
        catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("CreateOrder.jsp").forward(request, response);
        
        
        
            
        
    }
}
    
