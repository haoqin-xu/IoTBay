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
/**
 *
 * @author 61452
 */
public class DeviceManager {
    private Statement st;
    
    public DeviceManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /*
        CREATE OPERATION: Create DEVICE & initialize all fields except for ID
    
        ID is initialised from the SQL side. All other fields are filled in by the user or backend.
    */
    public void createDevice(String name, String manufacturer, String origin, String type, String instock, double priceperunit, int numberinstock) throws SQLException {
        String columns = "INSERT INTO iotdb.DEVICE(\"NAME\",MANUFACTURER,ORIGIN,\"TYPE\",INSTOCK,PRICEPERUNIT,STOCK_NUM)";
        String values = "VALUES('"+name+"', "+manufacturer+", "+origin+", '"+type+"', "+instock+", "+priceperunit+", "+numberinstock+")";
        
        st.executeUpdate(columns+values);
    }
    
    /*
        RETRIEVE OPERATION: Find DEVICE by device name and type in the database
  
        Assignment suggests using name and type of device to find devices in the database
    */
    public Device findDevice(String Name, String Type) throws SQLException {
        //setup the select sql query string  
        String fetch = "SELECT * FROM IOTDB.DEVICE WHERE \"NAME\"='"+Name+"' AND \"TYPE\"='"+Type+"'";
        //execute this query using the statement field      
        //add the results to a ResultSet      
        ResultSet rs = st.executeQuery(fetch);
        //search the ResultSet for a specific device using the parameters               
        while(rs.next()) {
            String devicename = rs.getString(2);
            String devicetype = rs.getString(5);
            
            if (devicename.equals(Name) && devicetype.equals(Type)) {
                String Manufacturer = rs.getString(3);
                String Origin = rs.getString(4);
                String Instock = rs.getString(6);
                double PricePerUnit = rs.getDouble(7);
                int NumberInStock = rs.getInt(8);
                
                return new Device(Name, Manufacturer, Origin, Type, Instock, PricePerUnit, NumberInStock); // return admin user object to view (to be stored in session)
            }
        }
        return null;
    }
    
    /*
        UPDATE OPERATION: Update all fields of DEVICE based on ID
    */    
    public void updateDevice(int deviceID, String name, String manufacturer, String origin, String type, String instock, double priceperunit, int numberinstock) throws SQLException {       
        //code for update-operation   
        String update = "UPDATE iotdb.DEVICE SET \"NAME\"='"+name+"', MANUFACTURER="+manufacturer+", ORIGIN="+origin+", TYPE='"+type+"', INSTOCK="+instock+", PRICEPERUNIT='"+priceperunit+"', STOCK_NUM="+numberinstock+"";
        String where = "where DEVICEID="+deviceID+"";
        st.executeUpdate(update+where); 
    }       
    
    public void updateDeviceCount(int deviceID, int stocknum) throws SQLException {       
        //code for ORDER MANAGEMENT
        String update = "UPDATE iotdb.DEVICE SET STOCK_NUM = STOCK_NUM - "+stocknum+"";
        String where = "WHERE DEVICEID="+deviceID+"";
        st.executeUpdate(update+where); 
        
    }
    public void updateDeviceCountP(int deviceID, int stocknum) throws SQLException {       
        //code for ORDER MANAGEMENT
        String update = "UPDATE iotdb.DEVICE SET STOCK_NUM = STOCK_NUM + "+stocknum+"";
        String where = "WHERE DEVICEID="+deviceID+"";
        st.executeUpdate(update+where); 
        
    }
    public void updateDeleteOrder(int orderid) throws SQLException {       
        //code for ORDER MANAGEMENT
        String delete = "SELECT \"ORDER\".ORDERID, DEVICE.DEVICEID, ORDERLINEITEM.\"COUNT\"\n" +
        "FROM \"ORDER\", DEVICE, ORDERLINEITEM\n" +
        "WHERE \"ORDER\".DEVICEID = DEVICE.DEVICEID \n" +
        "AND \"ORDER\".STATUS = 'Cancelled'\n" +
        "AND \"ORDER\".ORDERID = ORDERLINEITEM.ORDERID";
        
        ResultSet rs = st.executeQuery(delete); 
        
        while(rs.next()) { 
            
            if ((rs.getInt(1) == orderid)) {
                String columns = "UPDATE IOTDB.DEVICE SET STOCK_NUM = STOCK_NUM + "+rs.getInt(3)+"";
                String values = "WHERE DEVICEID = "+rs.getInt(2)+"";
                st.executeUpdate(columns+values);
                
            }
        }
        
    }  
    
    /*
        DELETE OPERATION: Delete DEVICE based on DEVICEID
    */
    public void deleteDevice(int DeviceID) throws SQLException{       
       //code for delete-operation   
       String delete = "DELETE FROM iotdb.DEVICE where DEVICEID="+DeviceID+"";
       st.executeUpdate(delete);
    }
}
