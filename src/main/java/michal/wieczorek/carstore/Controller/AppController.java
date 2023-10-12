/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Controller;

import java.util.ArrayList;
import michal.wieczorek.carstore.Model.Car.CarA;
import michal.wieczorek.carstore.Model.Car.CarB;
import michal.wieczorek.carstore.Model.Car.CarC;
import michal.wieczorek.carstore.Model.User.Admin;
import michal.wieczorek.carstore.Model.User.PremiumUser;
import michal.wieczorek.carstore.Model.User.StandardUser;
import michal.wieczorek.carstore.View.LoginGUI;
import michal.wieczorek.carstore.View.SigningGUI;

/**
 *
 * @author Michał
 */
public class AppController {
    ArrayList<CarA> CarsA = new ArrayList<CarA>();
    ArrayList<CarB> CarsB = new ArrayList<CarB>();
    ArrayList<CarC> CarsC = new ArrayList<CarC>();
    
    Admin AppAdmin = new Admin("Password");
    ArrayList<StandardUser> standardUsers = new ArrayList<StandardUser>();
    ArrayList<PremiumUser> premiumUsers = new ArrayList<PremiumUser>();
    
    
    public AppController() {
        LoginGUI loginGUI = new LoginGUI();
        //SigningGUI gui = new SigningGUI();
    }
}
