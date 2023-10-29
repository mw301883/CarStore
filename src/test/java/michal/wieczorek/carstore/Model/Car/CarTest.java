/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package michal.wieczorek.carstore.Model.Car;

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
public class CarTest {
    
    public CarTest() {
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
     * Test of rentCar method, of class Car.
     */
    @Test
    public void testRentCar() {
        System.out.println("rentCar");
        Car instance = null;
        instance.rentCar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnCar method, of class Car.
     */
    @Test
    public void testReturnCar() {
        System.out.println("returnCar");
        Car instance = null;
        instance.returnCar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Car.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Car instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMark method, of class Car.
     */
    @Test
    public void testGetMark() {
        System.out.println("getMark");
        Car instance = null;
        String expResult = "";
        String result = instance.getMark();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsAvaible method, of class Car.
     */
    @Test
    public void testGetIsAvaible() {
        System.out.println("getIsAvaible");
        Car instance = null;
        boolean expResult = false;
        boolean result = instance.getIsAvaible();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class CarImpl extends Car {

        public CarImpl() {
            super("", "");
        }
    }
    
}
