/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package michal.wieczorek.carstore.Model.User;

import java.util.ArrayList;
import java.util.HashSet;
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
public class UserTest {
    
    public UserTest() {
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
     * Test of getUserData method, of class User.
     */
    @Test
    public void testGetUserData() {
        System.out.println("getUserData");
        User instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getUserData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class User.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        User instance = null;
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserSurname method, of class User.
     */
    @Test
    public void testGetUserSurname() {
        System.out.println("getUserSurname");
        User instance = null;
        String expResult = "";
        String result = instance.getUserSurname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserAddress method, of class User.
     */
    @Test
    public void testGetUserAddress() {
        System.out.println("getUserAddress");
        User instance = null;
        String expResult = "";
        String result = instance.getUserAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserEmail method, of class User.
     */
    @Test
    public void testGetUserEmail() {
        System.out.println("getUserEmail");
        User instance = null;
        String expResult = "";
        String result = instance.getUserEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserLogin method, of class User.
     */
    @Test
    public void testGetUserLogin() {
        System.out.println("getUserLogin");
        User instance = null;
        String expResult = "";
        String result = instance.getUserLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserPassword method, of class User.
     */
    @Test
    public void testGetUserPassword() {
        System.out.println("getUserPassword");
        User instance = null;
        String expResult = "";
        String result = instance.getUserPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCarAtoOrder method, of class User.
     */
    @Test
    public void testAddCarAtoOrder() {
        System.out.println("addCarAtoOrder");
        int index = 0;
        User instance = null;
        instance.addCarAtoOrder(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCarAfromOrder method, of class User.
     */
    @Test
    public void testRemoveCarAfromOrder() {
        System.out.println("removeCarAfromOrder");
        int index = 0;
        User instance = null;
        instance.removeCarAfromOrder(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCarBtoOrder method, of class User.
     */
    @Test
    public void testAddCarBtoOrder() {
        System.out.println("addCarBtoOrder");
        int index = 0;
        User instance = null;
        instance.addCarBtoOrder(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCarBfromOrder method, of class User.
     */
    @Test
    public void testRemoveCarBfromOrder() {
        System.out.println("removeCarBfromOrder");
        int index = 0;
        User instance = null;
        instance.removeCarBfromOrder(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCarCtoOrder method, of class User.
     */
    @Test
    public void testAddCarCtoOrder() {
        System.out.println("addCarCtoOrder");
        int index = 0;
        User instance = null;
        instance.addCarCtoOrder(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCarCfromOrder method, of class User.
     */
    @Test
    public void testRemoveCarCfromOrder() {
        System.out.println("removeCarCfromOrder");
        int index = 0;
        User instance = null;
        instance.removeCarCfromOrder(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservedCarsA method, of class User.
     */
    @Test
    public void testGetReservedCarsA() {
        System.out.println("getReservedCarsA");
        User instance = null;
        HashSet<Integer> expResult = null;
        HashSet<Integer> result = instance.getReservedCarsA();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservedCarsB method, of class User.
     */
    @Test
    public void testGetReservedCarsB() {
        System.out.println("getReservedCarsB");
        User instance = null;
        HashSet<Integer> expResult = null;
        HashSet<Integer> result = instance.getReservedCarsB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservedCarsC method, of class User.
     */
    @Test
    public void testGetReservedCarsC() {
        System.out.println("getReservedCarsC");
        User instance = null;
        HashSet<Integer> expResult = null;
        HashSet<Integer> result = instance.getReservedCarsC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPayment method, of class User.
     */
    @Test
    public void testGetPayment() {
        System.out.println("getPayment");
        User instance = null;
        double expResult = 0.0;
        double result = instance.getPayment();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of areCarListsEmpty method, of class User.
     */
    @Test
    public void testAreCarListsEmpty() {
        System.out.println("areCarListsEmpty");
        User instance = null;
        boolean expResult = false;
        boolean result = instance.areCarListsEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserType method, of class User.
     */
    @Test
    public void testGetUserType() {
        System.out.println("getUserType");
        User instance = null;
        UserEnum.UserType expResult = null;
        UserEnum.UserType result = instance.getUserType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPayment method, of class User.
     */
    @Test
    public void testSetPayment() {
        System.out.println("setPayment");
        double payment = 0.0;
        User instance = null;
        instance.setPayment(payment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
