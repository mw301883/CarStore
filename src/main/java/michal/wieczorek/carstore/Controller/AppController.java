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
        //Basic car's initialisation
        CarsA.add(new CarA("Mercedes-Benz", "C-Class"));
        CarsA.add(new CarA("Audi", "A4"));
        CarsA.add(new CarA("BMW", "3 Series"));
        
        CarsB.add(new CarB("Mercedes-Benz", "C-Class"));
        CarsB.add(new CarB("BMW", "3 Series"));
        CarsB.add(new CarB("Audi", "A4"));
        
        CarsC.add(new CarC("Volkswagen", "Golf"));
        CarsC.add(new CarC("Ford", "Focus"));
        CarsC.add(new CarC("Honda", "Civic"));
        
        //Basic car's price
        CarA.setPrice(1000.0);
        CarB.setPrice(750.0);
        CarC.setPrice(400.0);
        
        loginGUI.setVisible(true);
    }
    
    public void handleLogin(ArrayList<String> loginData){
        if(loginData.get(0).equals("admin")){
            if(loginData.get(1).equals(this.AppAdmin.getPassword())){
                //TODO admin view
            }
        }
        else{
            for(StandardUser StdUsr : standardUsers){
                if(loginData.get(0).equals(StdUsr.getUserLogin())){
                    if(loginData.get(0).equals(StdUsr.getUserLogin())){
                        //TODO Standard User view
                        return;
                    }
                }
            }
            
            for(PremiumUser StdUsr : premiumUsers){
                if(loginData.get(0).equals(StdUsr.getUserLogin())){
                    if(loginData.get(0).equals(StdUsr.getUserLogin())){
                        //TODO Premium User view
                    }
                }
            }
        }
    }
    
    public void handleSigningUp(){
        signingGUI.setVisible(true);
    }
    
    public void createNewUser(ArrayList<String> userAttributes, boolean isUser){
        if(isUser){
            standardUsers.add(new StandardUser(userAttributes.get(0), userAttributes.get(1),
                    userAttributes.get(2), userAttributes.get(3),
                    userAttributes.get(4), userAttributes.get(5)));
        }
        else{
            premiumUsers.add(new PremiumUser(userAttributes.get(0), userAttributes.get(1),
                    userAttributes.get(2), userAttributes.get(3),
                    userAttributes.get(4), userAttributes.get(5)));
        }
        loginGUI.setVisible(true);
    }
}
