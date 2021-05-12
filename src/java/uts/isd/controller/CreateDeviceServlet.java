/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.DeviceManager;


/**
 *
 * @author danie
 */
public class CreateDeviceServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Retrieve the current session
        HttpSession session = request.getSession();
        //Capture the posted device information
        String deviceName = request.getParameter("deviceName");
        String manufacturer = request.getParameter("manufacturer");
        String origin = request.getParameter("origin");
        String type = request.getParameter("type");
        String inStock = request.getParameter("inStock");
        double pricePerUnit = Double.parseDouble(request.getParameter("pricePerUnit"));
        int stockNum = Integer.parseInt(request.getParameter("stockNum"));
        //Retrieve the manager instance from session
        DeviceManager manager;
        manager = (DeviceManager) session.getAttribute("devicemanager");
        
        try {
            manager.createDevice(deviceName, manufacturer, origin, type, inStock, pricePerUnit, stockNum);
        } catch (SQLException ex) {
            Logger.getLogger(CreateDeviceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
