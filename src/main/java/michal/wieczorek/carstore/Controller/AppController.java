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
    
    private LoginGUI loginGUI = new LoginGUI(this);
    private SigningGUI signingGUI = new SigningGUI(this);
    
    public AppController() {
        runApp();
    }
    
    public void runApp(){
        loginGUI.setVisible(true);
    }
    
    public void handleLogin(ArrayList<String> loginData){
        for(String x : loginData){
            System.out.println(x);
        }
    }
    
    public void handleSigningUp(){
        signingGUI.setVisible(true);
    }
    
    public void createNewUser(ArrayList<String> userAttributes, boolean isUser){
        if(isUser){
            //StandardUser usr = new StandardUser(userAttributes[0], userAttributes[1], userAttributes[2], userAttributes[3], userAttributes[4], userAttributes[5]);
           // standardUsers.add();
        }
        else{
        
        }
        loginGUI.setVisible(true);
    }
}
