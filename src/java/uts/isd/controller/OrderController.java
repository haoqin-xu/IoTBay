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
        
        //retrieve the current session
        HttpSession session = request.getSession();
        // initialise DAO connection
        OrderLineManager orderlinemanager = (OrderLineManager)session.getAttribute("orderlinemanager");
        OrderManager manager = (OrderManager) session.getAttribute("ordermanager");
        DeviceManager devicemanager = (DeviceManager) session.getAttribute("devicemanager");
        
        //create order validator to validate inputs
        OrderValidator validator = new OrderValidator();
        
        // retrieve customer object from session
        Customer customerObj = (Customer) session.getAttribute("user");
        // retrieve customerid from customer object
        int customerid = customerObj.getID();
        // retrieve payment id from session
        int paymentid = Integer.parseInt(session.getAttribute("randompaymentid").toString());
        // initialise deviceid and count variable
        int deviceid;
        int count;
        // retrieve invoice from session
        int invoiceid = Integer.parseInt(session.getAttribute("invoiceid").toString());
        // retrieve date from session
        String date = session.getAttribute("date").toString();
        // clear all the validation inputs for new inputs
        validator.clear(session);
        
        try {
            // check the inputs and catch if incorrect format in numberformatexception catch
            deviceid = Integer.parseInt(request.getParameter("deviceid"));
            count = Integer.parseInt(request.getParameter("count"));
            // if input passes then set attribute to order is successful
            session.setAttribute("successful", "Order successful");
            // update devicecount,createorder,addorderline updates the order, orderline and device tables
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
        // if try statement works, forwards back to create order to choose to create more orders or view orders
        request.getRequestDispatcher("CreateOrder.jsp").forward(request, response);
        
        
        
            
        
    }
}
    
