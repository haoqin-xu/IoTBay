/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uts.isd.model.*;
 
public class OrderLineManager {
    private Statement st;
    public OrderLineManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /*
        CREATE OPERATION: Create Order & initialize all fields except for ID
    
        ID is initialised from the SQL side. All other fields are filled in by the user or backend.
    */
    public void addOrderline(int deviceid, int count) throws SQLException {
        String fetch = "SELECT \"ORDER\".ORDERID, DEVICE.DEVICEID\n" +"FROM \"ORDER\", DEVICE WHERE \"ORDER\".DEVICEID = DEVICE.DEVICEID\n" + "ORDER BY ORDERID DESC";
        ResultSet rs = st.executeQuery(fetch); 
        
        while(rs.next()) {
                
            
            if ((rs.getInt(2) == deviceid)) {
                String columns = "INSERT INTO ORDERLINEITEM(DEVICEID, ORDERID,\"COUNT\")";
                String values = "VALUES("+rs.getInt(2)+", "+rs.getInt(1)+", "+count+")";
                st.executeUpdate(columns+values);
                
            }
        }
    }  
    
    public OrderLineItem findOrderLine(int OrderID) throws SQLException {
        //setup the select sql query string  
        String fetch = "SELECT * FROM IOTDB.ORDERLINEITEM WHERE ORDERID="+OrderID+"";
        //execute this query using the statement field      
        //add the results to a ResultSet      
        ResultSet rs = st.executeQuery(fetch);
        //search the ResultSet for a specific order using the parameters               
        while(rs.next()) {
            int orderID = rs.getInt(2);
            
            if ((orderID == OrderID)) {
                int deviceid = rs.getInt(1);
                int count = rs.getInt(3);
                return new OrderLineItem(deviceid,orderID,count); // return admin user object to view (to be stored in session)
            }
        }
        return null;
    }

}

