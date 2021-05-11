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
        String fetch = "SELECT \"ORDER\".ORDERID, DEVICE.DEVICEID\n" +"FROM \"ORDER\", DEVICE WHERE \"ORDER\".DEVICEID = DEVICE.DEVICEID";
        ResultSet rs = st.executeQuery(fetch); 
        
        while(rs.next()) {

            int deviceID = deviceid;
            
            if ((deviceID == deviceid)) {
                String columns = "INSERT INTO ORDERLINEITEM(DEVICEID, ORDERID,\"COUNT\")";
                String values = "VALUES("+deviceID+", "+rs.getInt(2)+", "+count+")";
                st.executeUpdate(columns+values);
                
            }
        }
    }
   

}

