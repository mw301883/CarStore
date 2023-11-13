/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package michal.wieczorek.carstore.Model.User;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Michał
 */
public class UserTest {
    
    public UserTest() {
    }
    
    static Stream<Arguments> dataProvider() {
    return Stream.of(
            Arguments.of(new User(" ", " ", " ", " ", " ", " ", UserEnum.UserType.STANDARD), 
                          new User(" ", " ", " ", " ", " ", " ", UserEnum.UserType.PREMIUM))
    );
}
    
    /**
     * Test of areCarListsEmpty method, of class User.
     */
    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testAreCarListsEmpty(User usrStd, User usrPrm) {
        System.out.println("areCarListsEmpty");
        assertEquals(true, usrStd.areCarListsEmpty(), "Unable to detect if car list is empty - return that is not empty but it is.");
        usrPrm.addCarAtoOrder(0);
        assertEquals(false, usrPrm.areCarListsEmpty(), "Unable to detect if car list is empty - return that is  empty but it is not.");
    }
    
}
