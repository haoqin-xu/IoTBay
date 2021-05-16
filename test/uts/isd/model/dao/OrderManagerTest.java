/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uts.isd.model.Order;

/**
 *
 * @author Alec
 */
public class OrderManagerTest {
    
    public OrderManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createOrder method, of class OrderManager.
     */
    @Test
    public void testCreateOrder() throws Exception {
        System.out.println("createOrder");
        int CustomerID = 0;
        int PaymentID = 0;
        int DeviceID = 0;
        int InvoiceID = 0;
        String Date = "";
        OrderManager instance = null;
        instance.createOrder(CustomerID, PaymentID, DeviceID, InvoiceID, Date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findOrder method, of class OrderManager.
     */
    @Test
    public void testFindOrder() throws Exception {
        System.out.println("findOrder");
        int OrderID = 0;
        String Date = "";
        OrderManager instance = null;
        Order expResult = null;
        Order result = instance.findOrder(OrderID, Date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listOrder method, of class OrderManager.
     */
    @Test
    public void testListOrder() throws Exception {
        System.out.println("listOrder");
        int customerid = 0;
        OrderManager instance = null;
        ArrayList<Order> expResult = null;
        ArrayList<Order> result = instance.listOrder(customerid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOrder method, of class OrderManager.
     */
    @Test
    public void testUpdateOrder() throws Exception {
        System.out.println("updateOrder");
        int OrderID = 0;
        int CustomerID = 0;
        int PaymentID = 0;
        int DeviceID = 0;
        int InvoiceID = 0;
        String Date = "";
        OrderManager instance = null;
        instance.updateOrder(OrderID, CustomerID, PaymentID, DeviceID, InvoiceID, Date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteOrder method, of class OrderManager.
     */
    @Test
    public void testDeleteOrder() throws Exception {
        System.out.println("deleteOrder");
        int OrderID = 0;
        OrderManager instance = null;
        instance.deleteOrder(OrderID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
