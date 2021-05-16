/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Briana Margetts
 */
public class PaymentMethodTest {
    
    public PaymentMethodTest() {
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
     * Test of getCustomerid method, of class PaymentMethod.
     */
    @Test
    public void testGetCustomerid() {
        System.out.println("getCustomerid");
        PaymentMethod instance = new PaymentMethod();
        int expResult = 0;
        int result = instance.getCustomerid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerid method, of class PaymentMethod.
     */
    @Test
    public void testSetCustomerid() {
        System.out.println("setCustomerid");
        int customerid = 0;
        PaymentMethod instance = new PaymentMethod();
        instance.setCustomerid(customerid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaymenttype method, of class PaymentMethod.
     */
    @Test
    public void testGetPaymenttype() {
        System.out.println("getPaymenttype");
        PaymentMethod instance = new PaymentMethod();
        String expResult = "";
        String result = instance.getPaymenttype();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaymenttype method, of class PaymentMethod.
     */
    @Test
    public void testSetPaymenttype() {
        System.out.println("setPaymenttype");
        String paymenttype = "";
        PaymentMethod instance = new PaymentMethod();
        instance.setPaymenttype(paymenttype);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountnumber method, of class PaymentMethod.
     */
    @Test
    public void testGetAccountnumber() {
        System.out.println("getAccountnumber");
        PaymentMethod instance = new PaymentMethod();
        int expResult = 0;
        int result = instance.getAccountnumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccountnumber method, of class PaymentMethod.
     */
    @Test
    public void testSetAccountnumber() {
        System.out.println("setAccountnumber");
        int accountnumberl = 0;
        PaymentMethod instance = new PaymentMethod();
        instance.setAccountnumber(accountnumberl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCcv method, of class PaymentMethod.
     */
    @Test
    public void testGetCcv() {
        System.out.println("getCcv");
        PaymentMethod instance = new PaymentMethod();
        int expResult = 0;
        int result = instance.getCcv();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCcv method, of class PaymentMethod.
     */
    @Test
    public void testSetCcv() {
        System.out.println("setCcv");
        int ccv = 0;
        PaymentMethod instance = new PaymentMethod();
        instance.setCcv(ccv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
