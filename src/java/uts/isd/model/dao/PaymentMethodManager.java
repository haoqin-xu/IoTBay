/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;
import java.sql.*;
import uts.isd.model.PaymentMethod;
import java.sql.Statement;

/**
 *
 * @author Briana Margetts
 */
public class PaymentMethodManager {
    private Statement st;
    
    public PaymentMethodManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /*
        CREATE OPERATION: Create Payment & initialize all fields except for ID
    
        ID is initialised from the SQL side. All other fields are filled in by the user or backend.
    */
    public void createPaymentMethod( int customerid, String paymenttype, int accountnumber, int ccv) throws SQLException {
        String columns = "INSERT INTO iotdb.PAYMENTMETHOD( CUSTOMERID, PAYMENTTYPE, ACCOUNTNUMBER, CCV)";
        String values = "VALUES( "+customerid+", "+paymenttype+", "+accountnumber+","+ccv+")";
        
        st.executeUpdate(columns+values);
    }
    
    /*
        RETRIEVE OPERATION: Find payment by PAYMENTID and date in the database
  
        Assignment suggests using PaymentID and date of the payment to find payments in the database
    */
    public PaymentMethod findPaymentMethodID(int methodid) throws SQLException {
        //setup the select sql query string  
        String fetch = "SELECT * FROM IOTDB.PAYMENTMETHOD WHERE METHODID="+methodid+"";
        //execute this query using the statement field      
        //add the results to a ResultSet      
        ResultSet rs = st.executeQuery(fetch);
        //search the ResultSet for a specific payment using the parameters               
        while(rs.next()) {
            int Methodid = rs.getInt(1);            
            if ((Methodid == methodid)) {
                int Customerid = rs.getInt(2);
                String Paymenttype = rs.getString(3);
                int Accountnumber = rs.getInt(4);
                int Ccv = rs.getInt(5);

                
                return new PaymentMethod(Customerid, Paymenttype, Accountnumber, Ccv); // return admin user object to view (to be stored in session)
            }
        }
        return null;
    }
    
    
    /*
        UPDATE OPERATION: Update all fields of PAYMENT based on ID
    */    
    public void updatePaymentMethod(int methodid, int customerid, String paymenttype, int accountnumber, int ccv) throws SQLException {       
        //code for update-operation   
        String update = "UPDATE IOTDB.PAYMENTMETHOD SET METHODID="+methodid+", CUSTOMERID="+customerid+", PAYMENTTYPE="+paymenttype+", ACCOUNTNUMBER="+accountnumber+", CCV="+ccv+"";
        String where = "where METHODID="+methodid+"";
        st.executeUpdate(update+where); 
    }       

    /*
        DELETE OPERATION: Delete PAYMENT based on PAYMENTID
    */
    public void deletePaymentMethod(int methodid) throws SQLException{       
       //code for delete-operation   
       String delete = "DELETE FROM iotdb.PAYMENTMETHOD where PAYMENTID="+methodid+"";
       st.executeUpdate(delete);
    }
    
    
  
}
