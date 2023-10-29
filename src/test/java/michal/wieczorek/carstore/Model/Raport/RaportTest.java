/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package michal.wieczorek.carstore.Model.Raport;

import java.util.ArrayList;
import java.util.Date;
import michal.wieczorek.carstore.Model.User.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Michał
 */
public class RaportTest {
    
    public RaportTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calculateTotalPrice method, of class Raport.
     */
    @Test
    public void testCalculateTotalPrice() {
        System.out.println("calculateTotalPrice");
        Raport instance = new Raport();
        instance.calculateTotalPrice();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateDate method, of class Raport.
     */
    @Test
    public void testCalculateDate() {
        System.out.println("calculateDate");
        Raport instance = new Raport();
        instance.calculateDate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCustomer method, of class Raport.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        User customer = null;
        Raport instance = new Raport();
        instance.addCustomer(customer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCustomer method, of class Raport.
     */
    @Test
    public void testRemoveCustomer() {
        System.out.println("removeCustomer");
        User user = null;
        Raport instance = new Raport();
        instance.removeCustomer(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerCount method, of class Raport.
     */
    @Test
    public void testGetCustomerCount() {
        System.out.println("getCustomerCount");
        Raport instance = new Raport();
        int expResult = 0;
        int result = instance.getCustomerCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Raport.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Raport instance = new Raport();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalPrice method, of class Raport.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        Raport instance = new Raport();
        double expResult = 0.0;
        double result = instance.getTotalPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerList method, of class Raport.
     */
    @Test
    public void testGetCustomerList() {
        System.out.println("getCustomerList");
        Raport instance = new Raport();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getCustomerList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
