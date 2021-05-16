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

    // create payment method
    public void createPaymentMethod(int customerid, String paymenttype, int accountnumber, int ccv) throws SQLException {
        String columns = "INSERT INTO iotdb.PAYMENTMETHOD( CUSTOMERID, PAYMENTTYPE, ACCOUNTNUMBER, CCV)";
        String values = "VALUES( " + customerid + ", '" + paymenttype + "', " + accountnumber + "," + ccv + ")";
        //both strings columns and values are sent to be execucted  
        st.executeUpdate(columns + values);
    }

    // find payment method
    public PaymentMethod findPaymentMethodID(int methodid) throws SQLException {
        //setup the select sql query string  
        String fetch = "SELECT * FROM IOTDB.PAYMENTMETHOD WHERE METHODID=" + methodid + "";
        //execute this query using the statement field      
        //add the results to a ResultSet      
        ResultSet rs = st.executeQuery(fetch);
        //search the ResultSet for a specific payment using the parameters               
        while (rs.next()) {
            int Methodid = rs.getInt(1);
            if ((Methodid == methodid)) {
                int Customerid = rs.getInt(2);
                String Paymenttype = rs.getString(3);
                int Accountnumber = rs.getInt(4);
                int Ccv = rs.getInt(5);

                // Returns found payment method
                return new PaymentMethod(Customerid, Paymenttype, Accountnumber, Ccv);
            }
        }
        return null;
    }

    // update payment method
    // this method does not work because i decided to leave method id out of the java bean as it is incrementally created in the DB
    public void updatePaymentMethod(int methodid, int customerid, String paymenttype, int accountnumber, int ccv) throws SQLException {
        String update = "UPDATE IOTDB.PAYMENTMETHOD SET METHODID=" + methodid + ", CUSTOMERID=" + customerid + ", PAYMENTTYPE=" + paymenttype + ", ACCOUNTNUMBER=" + accountnumber + ", CCV=" + ccv + "";
        String where = "where METHODID=" + methodid + "";
        //both strings columns and values are sent to be execucted  
        st.executeUpdate(update + where);
    }

    // delete payment method
    public void deletePaymentMethod(int accountnumber) throws SQLException {
        String delete = "DELETE FROM iotdb.PAYMENTMETHOD where ACCOUNTNUMBER=" + accountnumber + "";
        // string delete is sent to be execucted  
        st.executeUpdate(delete);
    }
}
