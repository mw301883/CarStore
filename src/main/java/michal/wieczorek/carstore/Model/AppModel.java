/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model;

import java.util.ArrayList;
import michal.wieczorek.carstore.Model.Car.CarA;
import michal.wieczorek.carstore.Model.Car.CarB;
import michal.wieczorek.carstore.Model.Car.CarC;
import michal.wieczorek.carstore.Model.Raport.Raport;
import michal.wieczorek.carstore.Model.User.Admin;
import michal.wieczorek.carstore.Model.User.PremiumUser;
import michal.wieczorek.carstore.Model.User.StandardUser;
import michal.wieczorek.carstore.Model.User.User;

/**
 *
 * @author Michał
 */
public class AppModel {
    ArrayList<CarA> carsA = new ArrayList<>();
    ArrayList<CarB> carsB = new ArrayList<>();
    ArrayList<CarC> carsC = new ArrayList<>();
    
    Admin AppAdmin = new Admin("password");
    ArrayList<StandardUser> standardUsers = new ArrayList<>();
    ArrayList<PremiumUser> premiumUsers = new ArrayList<>();
    
    private User currentUser = new StandardUser("", "", "", "", "", "");
    private Raport currentRaport = new Raport();
    private ArrayList<Raport> raportsList = new ArrayList<>();
    
    public AppModel() {
        //Basic car's initialisation
        carsA.add(new CarA("Mercedes-Benz", "C-Class"));
        carsA.add(new CarA("Audi", "A4"));
        carsA.add(new CarA("BMW", "3 Series"));
        
        carsB.add(new CarB("Mercedes-Benz", "A-Class"));
        carsB.add(new CarB("BMW", "4 Series"));
        carsB.add(new CarB("Audi", "A3"));
        
        carsC.add(new CarC("Volkswagen", "Golf"));
        carsC.add(new CarC("Ford", "Focus"));
        carsC.add(new CarC("Honda", "Civic"));
        
        //Basic car's price
        CarA.setPrice(1000.0);
        CarB.setPrice(750.0);
        CarC.setPrice(400.0);
    }
    
    public ArrayList<CarA> getCarsA(){
        return this.carsA;
    }
    
    public ArrayList<CarB> getCarsB(){
        return this.carsB;
    }
    
    public ArrayList<CarC> getCarsC(){
        return this.carsC;
    }
    
    public int handleLogin(ArrayList<String> loginData){
        if(loginData.get(0).equals("admin")){
            if(loginData.get(1).equals(this.AppAdmin.getPassword())){
                //TODO return int and switch case in controller
                return 1;
            }
        }
        else{
            for(StandardUser stdUsr : standardUsers){
                if(loginData.get(0).equals(stdUsr.getUserLogin())){
                    if(loginData.get(1).equals(stdUsr.getUserPassword())){
                        //TODO Standard User view
                        this.currentUser = stdUsr;
                        return 2;
                    }
                }
            }
            for(PremiumUser prmUsr : premiumUsers){
                if(loginData.get(0).equals(prmUsr.getUserLogin())){
                    if(loginData.get(1).equals(prmUsr.getUserPassword())){
                        //TODO Premium User view
                        this.currentUser = prmUsr;
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
    
    public void reserveCarA(int index){
        this.carsA.get(index).rentCar();
    }
    
    public void returnCarA(int index){
        this.carsA.get(index).returnCar();
    }
    
    public void reserveCarB(int index){
        this.carsB.get(index).rentCar();
    }
    
    public void returnCarB(int index){
        this.carsB.get(index).returnCar();
    }
    
    public void reserveCarC(int index){
        this.carsC.get(index).rentCar();
    }
    
    public void returnCarC(int index){
        this.carsC.get(index).returnCar();
    }
    
    public User getCurrentUser(){
        return this.currentUser;
    }
    
    public void addCustomerToRaport(User customer){
        this.currentRaport.addCustomer(customer);
    }
    
    public void removeCustomerFromRaport(User customer){
        this.currentRaport.removeCustomer(customer);
    }
    
    public void generateRaport(){
        this.raportsList.add(this.currentRaport);
    }
}
