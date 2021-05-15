/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Order;
import uts.isd.model.dao.DeviceManager;
import uts.isd.model.dao.OrderLineManager;
import uts.isd.model.dao.OrderManager;

/**
 *
 * @author Alec
 */
public class UpdateOrderController extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // retrieve current session
        HttpSession session = request.getSession();
        // initialise DAO connection for orderlinemanager and device manager
        OrderLineManager orderlinemanager = (OrderLineManager)session.getAttribute("orderlinemanager");;
        DeviceManager devicemanager = (DeviceManager) session.getAttribute("devicemanager");
        //create validator to validate inputs
        OrderValidator validator = new OrderValidator();
        validator.clear(session);
        // get the session for current values of orderid
        int orderid = Integer.parseInt(session.getAttribute("orderid").toString());
        int deviceid = Integer.parseInt(session.getAttribute("deviceid").toString());
        int countp = Integer.parseInt(session.getAttribute("countp").toString()); //old value of count
        //count variable is the new count to update
        int count;
        try {
            // if count is correct format the execute this block or catch by numberformatexception
            count = Integer.parseInt(request.getParameter("count"));
            //update the device and orderline tables accordingly
            devicemanager.updateDeviceCountP(deviceid, countp);
            orderlinemanager.updateOrderLine(orderid,count);
            devicemanager.updateDeviceCount(deviceid, count);
            request.getRequestDispatcher("ViewOrder.jsp").include(request, response);
            
        } catch(NumberFormatException exd){
            //catch numberformat exception when user inputs string or blank
            session.setAttribute("notint", "Error: count format incorrect");
            request.getRequestDispatcher("UpdateOrder.jsp").include(request, response);
        }
        catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
  


}
