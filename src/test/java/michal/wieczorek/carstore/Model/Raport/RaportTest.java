/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package michal.wieczorek.carstore.Model.Raport;

import michal.wieczorek.carstore.Model.User.User;
import michal.wieczorek.carstore.Model.User.UserEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Michał
 */
public class RaportTest {
    
    public RaportTest() {
    }

    /**
     * Test of calculateTotalPrice method, of class Raport.
     */
    @Test
    public void testCalculateTotalPrice() {
        System.out.println("calculateTotalPrice");
        Raport instance = new Raport();
        instance.calculateTotalPrice();
        
        User stdUsr = new User(" ", " ", " ", " ", " ", " ", UserEnum.UserType.STANDARD);
        stdUsr.setPayment(50.0);
        instance.addCustomer(stdUsr);
        instance.addCustomer(stdUsr);
        
        instance.calculateTotalPrice();
        assertEquals(100.0, instance.getTotalPrice(), "Unable to calculate Standard Users in total price.");
        
        User prmUsr = new User(" ", " ", " ", " ", " ", " ", UserEnum.UserType.PREMIUM);
        prmUsr.setPayment(100.0);
        instance.addCustomer(prmUsr);
        
        instance.calculateTotalPrice();
        assertEquals(170.0, instance.getTotalPrice(), "Unable to calculate Premium Users in total price");
    }

    /**
     * Test of removeCustomer method, of class Raport.
     */
    @Test
    public void testRemoveCustomer() {
        System.out.println("removeCustomer");
        User stdUsr = new User(" ", " ", " ", " ", " ", " ", UserEnum.UserType.STANDARD);
        User prmUsr = new User(" ", " ", " ", " ", " ", " ", UserEnum.UserType.PREMIUM);
        Raport instance = new Raport();
        
        instance.addCustomer(stdUsr);
        instance.removeCustomer(prmUsr);
        assertEquals(1, instance.getCustomerCount(), "Customer removing algorithm doesn't work corectly - removes wrong customers.");
        
        instance.removeCustomer(stdUsr);
        assertEquals(0, instance.getCustomerCount(), "Unable to remove Standard User.");
        
        instance.removeCustomer(prmUsr);
        assertEquals(0, instance.getCustomerCount(), "Remove wrong Users.");
        
        instance.addCustomer(prmUsr);
        instance.removeCustomer(prmUsr);
        assertEquals(0, instance.getCustomerCount(), "Unable to remove Premium User.");
    }
    
}
