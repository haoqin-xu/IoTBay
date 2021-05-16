/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit.test;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import uts.isd.model.Staff;

/**
 *
 * @author Hao-qin Xu
 */
public class CreateStaffTest {
    private Staff staff;
    
    public CreateStaffTest() {
        staff = new Staff("test@iotbay.com", "Test", "testpass", "1990-01-01", "00000000", "1 Test Addr TEST", "TestRole");
    }
    
    @Test
    public void testGetEmail() {
        String email = staff.getEmail();
        assertEquals("test@iotbay.com", email);
    }
    
    @Test
    public void testGetName() {
        String name = staff.getName();
        assertEquals("Test", name);
    }
    
    @Test
    public void testGetPassword() {
        String password = staff.getPassword();
        assertEquals("testpass", password);
    }
}
