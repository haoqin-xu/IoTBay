/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.*;
import java.util.ArrayList;
import uts.isd.model.Staff;

/**
 *
 * @author 61452
 */
public class StaffManager {
    private Statement st;
    
    public StaffManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /*
        CREATE OPERATION: Create staff user & initialize all fields except for ID
    
        ID is initialised from the SQL side. All other fields are filled in by the user or backend.
    */
    public void addUser(String email, String name, String password, String dob, String phone, String address, String role) throws SQLException {
        String columns = "insert into iotdb.STAFF(EMAIL,\"NAME\",PASSWORD,DOB,PHONE,ADDRESS,ROLE)";
        String values = "VALUES('"+email+"', '"+name+"', '"+password+"', '"+dob+"', '"+phone+"', '"+address+"', '"+role+"')";
        
        st.executeUpdate(columns+values);
    }
    
    /*
        RETRIEVE OPERATION: Find staff user by email and password in the database
  
        Email is used here for login purposes; while it isn't the primary key,
        it is more reasonable for users to remember their email than  a randomly
        generated integer ID.
    */
    public Staff findUser(String email, String password) throws SQLException {
        //setup the select sql query string  
        String fetch = "SELECT * FROM IOTDB.STAFF WHERE EMAIL='"+email+"' AND PASSWORD='"+password+"'";// read from where email = and password =
        //execute this query using the statement field      
        //add the results to a ResultSet      
        ResultSet rs = st.executeQuery(fetch);
        
        //search the ResultSet for a user using the parameters               
        while(rs.next()) {
            String userEmail = rs.getString(2);
            String userPass = rs.getString(4);
            
            if (userEmail.equals(email) && userPass.equals(password)) {
                int ID = rs.getInt(1);
                String name = rs.getString(3);
                String phone = rs.getString(5);
                String address = rs.getString(6);
                String dob = rs.getString(7);
                String role = rs.getString(8);
                
                return new Staff(email, name, password, dob, phone, address, role); // return admin user object to view (to be stored in session)
            }
        }
        return null;
    }
    
    /*
        UPDATE OPERATION: Update all fields of staff user based on ID
    */    
    public void updateUser(int ID, String email, String name, String password, String dob, String phone, String address, String role) throws SQLException {       
        //code for update-operation   
        String update = "update iotdb.STAFF set EMAIL='"+email+"', NAME='"+name+"', PASSWORD='"+password+"', DOB='"+dob+"', PHONE='"+phone+"', ADDRESS='"+address+"', ROLE='"+role+"'";
        String where = "where ID="+ID+"";

        st.executeUpdate(update+where); 
    }       

    /*
        DELETE OPERATION: Delete staff user based on ID
    */
    public void deleteUser(int ID) throws SQLException{       
       //code for delete-operation   
       String delete = "delete from iotdb.STAFF where ID="+ID+"";
       
       st.executeUpdate(delete);
    }
    
    /*
        SEARCH OPERATION: Search staff users based on ID and return it as arraylist
    */
    public ArrayList<Staff> searchUser(String name, String role) throws SQLException {
        //setup the select sql query string  
        String fetch = "SELECT * FROM IOTDB.STAFF WHERE NAME LIKE '%";// read from where email = and password =
        String fetch2 = "%' AND ROLE LIKE '%";
        String fetch3 = "%'";
        //execute this query using the statement field      
        //add the results to a ResultSet      
        ResultSet rs = st.executeQuery(fetch+name+fetch2+role+fetch3);
        
        // init arraylist of staff objects to store results returned by sql search
        // arraylist is used instead of linkedlist as the results shouldn't be modified, only read
        ArrayList<Staff> resultArr = new ArrayList<Staff>(); 
        
        while(rs.next()) { // for each result obtained by the search...
            int ID = rs.getInt(1);
            String email = rs.getString(2);
            String userName = rs.getString(3);
            String pass = rs.getString(4);
            String phone = rs.getString(5);
            String address = rs.getString(6);
            String dob = rs.getString(7);
            String userRole = rs.getString(8);
            
            resultArr.add(new Staff(ID, email, userName, pass, dob, phone, address, userRole)); // push the staff object into the results arraylist.
        }
        
        if (resultArr.size() > 0) // if results are not empty, return them
            return resultArr;
        else // otherwise return nothing
            return null;
    }
}
