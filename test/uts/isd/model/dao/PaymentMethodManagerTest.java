/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uts.isd.model.PaymentMethod;

/**
 *
 * @author Briana Margetts
 */
public class PaymentMethodManagerTest {
    
    public PaymentMethodManagerTest() {
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
     * Test of createPaymentMethod method, of class PaymentMethodManager.
     */
    @Test
    public void testCreatePaymentMethod() throws Exception {
        System.out.println("createPaymentMethod");
        int customerid = 0;
        String paymenttype = "";
        int accountnumber = 0;
        int ccv = 0;
        PaymentMethodManager instance = null;
        instance.createPaymentMethod(customerid, paymenttype, accountnumber, ccv);   
    }

    /**
     * Test of findPaymentMethodID method, of class PaymentMethodManager.
     */
    @Test
    public void testFindPaymentMethodID() throws Exception {
        System.out.println("findPaymentMethodID");
        int methodid = 0;
        PaymentMethodManager instance = null;
        PaymentMethod expResult = null;
        PaymentMethod result = instance.findPaymentMethodID(methodid);
        assertEquals(expResult, result);
    }

    /**
     * Test of updatePaymentMethod method, of class PaymentMethodManager.
     */
    @Test
    public void testUpdatePaymentMethod() throws Exception {
        System.out.println("updatePaymentMethod");
        int methodid = 0;
        int customerid = 0;
        String paymenttype = "";
        int accountnumber = 0;
        int ccv = 0;
        PaymentMethodManager instance = null;
        instance.updatePaymentMethod(methodid, customerid, paymenttype, accountnumber, ccv);
    }

    /**
     * Test of deletePaymentMethod method, of class PaymentMethodManager.
     */
    @Test
    public void testDeletePaymentMethod() throws Exception {
        System.out.println("deletePaymentMethod");
        int accountnumber = 0;
        PaymentMethodManager instance = null;
        instance.deletePaymentMethod(accountnumber);
    }
    
}
