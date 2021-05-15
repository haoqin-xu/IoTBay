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
import uts.isd.model.Device;
import uts.isd.model.dao.DeviceManager;

/**
 *
 * @author Alec
 */
public class ListDeviceController extends HttpServlet {

       @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //get the session from the request
        HttpSession session = request.getSession();
        //get connection with OrderManager DAO
        DeviceManager manager = (DeviceManager) session.getAttribute("devicemanager");
        
        ArrayList<Device> list = null;
        try {
            // use dao to access sql tables and store into list variable
            list = manager.listDevice();
            if(list!=null){
                // if list is not null set attribute to use in jsp
                session.setAttribute("devicelist", list);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
    }
        request.getRequestDispatcher("CreateOrder.jsp").include(request, response);
    }
}
