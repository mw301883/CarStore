/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package michal.wieczorek.carstore.Model.User;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Michał
 */
public class UserTest {
    
    public UserTest() {
    }

    /**
     * Test of areCarListsEmpty method, of class User.
     */
    @Test
    public void testAreCarListsEmpty() {
        System.out.println("areCarListsEmpty");
        User instance = new User(" ", " ", " ", " ", " ", " ", UserEnum.UserType.PREMIUM);
        assertEquals(true, instance.areCarListsEmpty(), "Unable to detect if car list is empty");
    }
    
}
