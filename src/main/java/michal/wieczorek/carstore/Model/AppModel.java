/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model;

import java.util.ArrayList;
import michal.wieczorek.carstore.Model.Car.CarA;
import michal.wieczorek.carstore.Model.Car.CarB;
import michal.wieczorek.carstore.Model.Car.CarC;
import michal.wieczorek.carstore.Model.User.Admin;
import michal.wieczorek.carstore.Model.User.PremiumUser;
import michal.wieczorek.carstore.Model.User.StandardUser;

/**
 *
 * @author Michał
 */
public class AppModel {
    ArrayList<CarA> CarsA = new ArrayList<>();
    ArrayList<CarB> CarsB = new ArrayList<>();
    ArrayList<CarC> CarsC = new ArrayList<>();
    
    Admin AppAdmin = new Admin("password");
    ArrayList<StandardUser> standardUsers = new ArrayList<>();
    ArrayList<PremiumUser> premiumUsers = new ArrayList<>();

    public AppModel() {
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
    }
    
    public int handleLogin(ArrayList<String> loginData){
        if(loginData.get(0).equals("admin")){
            if(loginData.get(1).equals(this.AppAdmin.getPassword())){
                //TODO return int and switch case in controller
                return 1;
            }
        }
        else{
            for(StandardUser StdUsr : standardUsers){
                if(loginData.get(0).equals(StdUsr.getUserLogin())){
                    if(loginData.get(0).equals(StdUsr.getUserLogin())){
                        //TODO Standard User view
                        return 2;
                    }
                }
            }
            
            for(PremiumUser StdUsr : premiumUsers){
                if(loginData.get(0).equals(StdUsr.getUserLogin())){
                    if(loginData.get(0).equals(StdUsr.getUserLogin())){
                        //TODO Premium User view
                        return 3;
                    }
                }
            }
        }
        return 4;
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
    }
    
}
