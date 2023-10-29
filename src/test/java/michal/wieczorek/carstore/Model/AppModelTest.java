/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package michal.wieczorek.carstore.Model;

import java.util.ArrayList;
import michal.wieczorek.carstore.Model.Car.CarA;
import michal.wieczorek.carstore.Model.Car.CarB;
import michal.wieczorek.carstore.Model.Car.CarC;
import michal.wieczorek.carstore.Model.Raport.Raport;
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
public class AppModelTest {
    
    public AppModelTest() {
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
     * Test of getCarsA method, of class AppModel.
     */
    @Test
    public void testGetCarsA() {
        System.out.println("getCarsA");
        AppModel instance = new AppModel();
        ArrayList<CarA> expResult = null;
        ArrayList<CarA> result = instance.getCarsA();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarsB method, of class AppModel.
     */
    @Test
    public void testGetCarsB() {
        System.out.println("getCarsB");
        AppModel instance = new AppModel();
        ArrayList<CarB> expResult = null;
        ArrayList<CarB> result = instance.getCarsB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarsC method, of class AppModel.
     */
    @Test
    public void testGetCarsC() {
        System.out.println("getCarsC");
        AppModel instance = new AppModel();
        ArrayList<CarC> expResult = null;
        ArrayList<CarC> result = instance.getCarsC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleLogin method, of class AppModel.
     */
    @Test
    public void testHandleLogin() {
        System.out.println("handleLogin");
        ArrayList<String> loginData = null;
        AppModel instance = new AppModel();
        int expResult = 0;
        int result = instance.handleLogin(loginData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewUser method, of class AppModel.
     */
    @Test
    public void testCreateNewUser() {
        System.out.println("createNewUser");
        ArrayList<String> userAttributes = null;
        boolean isUser = false;
        AppModel instance = new AppModel();
        instance.createNewUser(userAttributes, isUser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reserveCarA method, of class AppModel.
     */
    @Test
    public void testReserveCarA() {
        System.out.println("reserveCarA");
        int index = 0;
        AppModel instance = new AppModel();
        instance.reserveCarA(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnCarA method, of class AppModel.
     */
    @Test
    public void testReturnCarA() {
        System.out.println("returnCarA");
        int index = 0;
        AppModel instance = new AppModel();
        instance.returnCarA(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reserveCarB method, of class AppModel.
     */
    @Test
    public void testReserveCarB() {
        System.out.println("reserveCarB");
        int index = 0;
        AppModel instance = new AppModel();
        instance.reserveCarB(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnCarB method, of class AppModel.
     */
    @Test
    public void testReturnCarB() {
        System.out.println("returnCarB");
        int index = 0;
        AppModel instance = new AppModel();
        instance.returnCarB(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reserveCarC method, of class AppModel.
     */
    @Test
    public void testReserveCarC() {
        System.out.println("reserveCarC");
        int index = 0;
        AppModel instance = new AppModel();
        instance.reserveCarC(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnCarC method, of class AppModel.
     */
    @Test
    public void testReturnCarC() {
        System.out.println("returnCarC");
        int index = 0;
        AppModel instance = new AppModel();
        instance.returnCarC(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentUser method, of class AppModel.
     */
    @Test
    public void testGetCurrentUser() {
        System.out.println("getCurrentUser");
        AppModel instance = new AppModel();
        User expResult = null;
        User result = instance.getCurrentUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCustomerToRaport method, of class AppModel.
     */
    @Test
    public void testAddCustomerToRaport() {
        System.out.println("addCustomerToRaport");
        User customer = null;
        AppModel instance = new AppModel();
        instance.addCustomerToRaport(customer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCustomerFromRaport method, of class AppModel.
     */
    @Test
    public void testRemoveCustomerFromRaport() {
        System.out.println("removeCustomerFromRaport");
        User customer = null;
        AppModel instance = new AppModel();
        instance.removeCustomerFromRaport(customer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateRaport method, of class AppModel.
     */
    @Test
    public void testGenerateRaport() {
        System.out.println("generateRaport");
        AppModel instance = new AppModel();
        instance.generateRaport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRaportsList method, of class AppModel.
     */
    @Test
    public void testGetRaportsList() {
        System.out.println("getRaportsList");
        AppModel instance = new AppModel();
        ArrayList<Raport> expResult = null;
        ArrayList<Raport> result = instance.getRaportsList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
