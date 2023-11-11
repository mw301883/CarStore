/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package michal.wieczorek.carstore.Model;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Michał
 */
public class AppModelTest {
    
    public AppModelTest() {
    }

    /**
     * Test of handleLogin method, of class AppModel.
     */
    @Test
    public void testHandleLogin() {
        System.out.println("handleLogin");
        ArrayList<String> loginDataAdmin = new ArrayList<>();
        loginDataAdmin.add("admin");
        loginDataAdmin.add("password");
        ArrayList<String> loginDataStdUsr = new ArrayList<>();
        loginDataStdUsr.add("StdUsr");
        loginDataStdUsr.add("password");
        ArrayList<String> loginDataPrmUsr = new ArrayList<>();
        loginDataPrmUsr.add("PrmUsr");
        loginDataPrmUsr.add("password");
        
        AppModel instance = new AppModel();
        
        ArrayList<String> newStdUserAtr = new ArrayList<>();
        newStdUserAtr.add(" ");
        newStdUserAtr.add(" ");
        newStdUserAtr.add(" ");
        newStdUserAtr.add(" ");
        newStdUserAtr.add("StdUsr");
        newStdUserAtr.add("password");
        instance.createNewUser(newStdUserAtr, true);
        
        ArrayList<String> newPrmUserAtr = new ArrayList<>();
        newPrmUserAtr.add(" ");
        newPrmUserAtr.add(" ");
        newPrmUserAtr.add(" ");
        newPrmUserAtr.add(" ");
        newPrmUserAtr.add("PrmUsr");
        newPrmUserAtr.add("password");
        instance.createNewUser(newPrmUserAtr, false);
        
        int result = instance.handleLogin(loginDataAdmin);
        assertEquals(1, result, "Admin detection doesn't work.");
        result = instance.handleLogin(loginDataStdUsr);
        assertEquals(2, result, "Standard User detection doesn't work.");
        result = instance.handleLogin(loginDataPrmUsr);
        assertEquals(3, result, "Premium User detection doesn't work.");
    }

    /**
     * Test of createNewUser method, of class AppModel.
     */
    @Test
    public void testCreateNewUser() {
        System.out.println("createNewUser");
        ArrayList<String> stdUserAttributes = new ArrayList<>();
        stdUserAttributes.add(" ");
        stdUserAttributes.add(" ");
        stdUserAttributes.add(" ");
        stdUserAttributes.add(" ");
        stdUserAttributes.add("StdUsr");
        stdUserAttributes.add("password");
        
        ArrayList<String> prmUserAttributes = new ArrayList<>();
        prmUserAttributes.add(" ");
        prmUserAttributes.add(" ");
        prmUserAttributes.add(" ");
        prmUserAttributes.add(" ");
        prmUserAttributes.add("PrmUsr");
        prmUserAttributes.add("password");
        
        ArrayList<String> loginDataStdUsr = new ArrayList<>();
        loginDataStdUsr.add("StdUsr");
        loginDataStdUsr.add("password");
        ArrayList<String> loginDataPrmUsr = new ArrayList<>();
        loginDataPrmUsr.add("PrmUsr");
        loginDataPrmUsr.add("password");
        
        AppModel instance = new AppModel();
        
        instance.createNewUser(stdUserAttributes, true);
        assertEquals(2, instance.handleLogin(loginDataStdUsr), "Unable to create new Standard User account.");
        
        instance.createNewUser(prmUserAttributes, false);
        assertEquals(3, instance.handleLogin(loginDataPrmUsr), "Unable to create new Premium User account.");
    }

    /**
     * Test of generateRaport method, of class AppModel.
     */
    @Test
    public void testGenerateRaport() {
        System.out.println("generateRaport");
        AppModel instance = new AppModel();
        instance.generateRaport();
        int raportsCount = instance.getRaportsList().size();
        assertEquals(1, raportsCount, "Unable to generate new raport.");
    }
    
}
