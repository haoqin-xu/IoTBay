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
import uts.isd.model.Admin;

/**
 *
 * @author TED
 */
public class AdminManager {
    private Statement st;
    
    public AdminManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
}
