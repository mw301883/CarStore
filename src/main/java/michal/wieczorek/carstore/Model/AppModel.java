/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model;

import java.util.ArrayList;
import michal.wieczorek.carstore.Exceptions.DoubleUserExeption;
import michal.wieczorek.carstore.Model.Car.CarA;
import michal.wieczorek.carstore.Model.Car.CarB;
import michal.wieczorek.carstore.Model.Car.CarC;
import michal.wieczorek.carstore.Model.Raport.Raport;
import michal.wieczorek.carstore.Model.User.Admin;
import michal.wieczorek.carstore.Model.User.User;
import michal.wieczorek.carstore.Model.User.UserEnum;
import michal.wieczorek.carstore.View.ErrorGUI.ErrorGUI;

/**
 * Represents the application model, which contains the data and business logic of the application.
 * @author Michał
 * @version 1.0
 */
public class AppModel {
    /**
    * ArrayList of CarA objects representing a collection of Car A instances in the application.
    */
   private ArrayList<CarA> carsA = new ArrayList<>();

   /**
    * ArrayList of CarB objects representing a collection of Car B instances in the application.
    */
   private ArrayList<CarB> carsB = new ArrayList<>();

   /**
    * ArrayList of CarC objects representing a collection of Car C instances in the application.
    */
   private ArrayList<CarC> carsC = new ArrayList<>();

   /**
    * An instance of the Admin class representing the application's administrator.
    */
   private Admin AppAdmin = new Admin("password");

   /**
    * ArrayList of User objects representing a collection of standard users in the application.
    */
   private ArrayList<User> standardUsers = new ArrayList<>();

   /**
    * ArrayList of User objects representing a collection of premium users in the application.
    */
   private ArrayList<User> premiumUsers = new ArrayList<>();

   /**
    * An instance of the User class representing the current user of the application.
    */
   private User currentUser = new User("", "", "", "", "", "", UserEnum.UserType.STANDARD);

   /**
    * An instance of the Raport class representing the current report in the application.
    */
   private Raport currentRaport = new Raport();

   /**
    * ArrayList of Raport objects representing a collection of reports in the application.
    */
   private ArrayList<Raport> raportsList = new ArrayList<>();

    
    
    /**
     * Default constructor for the AppModel class. Initializes car lists and sets basic car prices.
     */
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
    
    /**
     * Get the list of Car A.
     *
     * @return The list of Car A.
     */
    public ArrayList<CarA> getCarsA(){
        return this.carsA;
    }
    
    /**
     * Get the list of Car B.
     *
     * @return The list of Car B.
     */
    public ArrayList<CarB> getCarsB(){
        return this.carsB;
    }
    
    /**
     * Get the list of Car C.
     *
     * @return The list of Car C.
     */
    public ArrayList<CarC> getCarsC(){
        return this.carsC;
    }
    
    /**
     * Handle user login.
     *
     * @param loginData The login data, including username and password.
     * @return An integer representing the login result:
     *   - 1: Successful login as an admin.
     *   - 2: Successful login as a standard user.
     *   - 3: Successful login as a premium user.
     *   - 4: Login failed.
     */
    public int handleLogin(ArrayList<String> loginData){
        if(loginData.get(0).equals("admin")){
            if(loginData.get(1).equals(this.AppAdmin.getPassword())){
                return 1;
            }
        }
        else{
            for(User stdUsr : standardUsers){
                if(loginData.get(0).equals(stdUsr.getUserLogin())){
                    if(loginData.get(1).equals(stdUsr.getUserPassword())){
                        this.currentUser = stdUsr;
                        return 2;
                    }
                }
            }
            for(User prmUsr : premiumUsers){
                if(loginData.get(0).equals(prmUsr.getUserLogin())){
                    if(loginData.get(1).equals(prmUsr.getUserPassword())){
                        this.currentUser = prmUsr;
                        return 3;
                    }
                }
            }
        }
        return 4;
    }
    
    /**
     * Create a new user account.
     *
     * @param userAttributes The attributes of the user, including their name, address, etc.
     * @param isUser True if the user is a standard user, false if the user is a premium user.
     */
    public void createNewUser(ArrayList<String> userAttributes, boolean isUser){
        try{
            for(User user : standardUsers){
                if(user.getUserLogin().equals(userAttributes.get(4))){
                    throw new DoubleUserExeption();
                }
            }
            for(User user : premiumUsers){
                if(user.getUserLogin().equals(userAttributes.get(4))){
                    throw new DoubleUserExeption();
                }
            }
            if(isUser){
            standardUsers.add(new User(userAttributes.get(0), userAttributes.get(1),
                    userAttributes.get(2), userAttributes.get(3),
                    userAttributes.get(4), userAttributes.get(5), UserEnum.UserType.STANDARD));
            }
            else{
                premiumUsers.add(new User(userAttributes.get(0), userAttributes.get(1),
                        userAttributes.get(2), userAttributes.get(3),
                        userAttributes.get(4), userAttributes.get(5), UserEnum.UserType.PREMIUM));
            }
        }
        catch(DoubleUserExeption e){
            ErrorGUI message = new ErrorGUI("Can not create duplicated accounts.");
            message.setSize(300, 125);
            message.display();
        }
    }
    
    /**
     * Reserve a Car A based on the specified index.
     *
     * @param index The index of the Car A to be reserved.
     */
    public void reserveCarA(int index){
        this.carsA.get(index).rentCar();
    }
    
    /**
     * Return a Car A based on the specified index.
     *
     * @param index The index of the Car A to be returned.
     */
    public void returnCarA(int index){
        this.carsA.get(index).returnCar();
    }
    
    /**
     * Reserve a Car B based on the specified index.
     *
     * @param index The index of the Car B to be reserved.
     */
    public void reserveCarB(int index){
        this.carsB.get(index).rentCar();
    }
    
    /**
     * Return a Car B based on the specified index.
     *
     * @param index The index of the Car B to be returned.
     */
    public void returnCarB(int index){
        this.carsB.get(index).returnCar();
    }
    
    /**
     * Reserve a Car C based on the specified index.
     *
     * @param index The index of the Car C to be reserved.
     */
    public void reserveCarC(int index){
        this.carsC.get(index).rentCar();
    }
    
    /**
     * Return a Car C based on the specified index.
     *
     * @param index The index of the Car C to be returned.
     */
    public void returnCarC(int index){
        this.carsC.get(index).returnCar();
    }
    
    /**
     * Get the current user.
     *
     * @return The current user.
     */
    public User getCurrentUser(){
        return this.currentUser;
    }
    
    /**
     * Add a customer to the current report.
     *
     * @param customer The customer to be added to the report.
     */
    public void addCustomerToRaport(User customer){
        this.currentRaport.addCustomer(customer);
    }
    
    /**
     * Remove a customer from the current report.
     *
     * @param customer The customer to be removed from the report.
     */
    public void removeCustomerFromRaport(User customer){
        this.currentRaport.removeCustomer(customer);
    }
    
    /**
     * Generate a report based on the application's current data and add it to the list of reports.
     */
    public void generateRaport(){
        Raport currentRaportCopy = new Raport(this.currentRaport);
        currentRaportCopy.calculateTotalPrice();
        currentRaportCopy.calculateDate();
        this.raportsList.add(currentRaportCopy);
    }
    
    /**
     * Get the list of reports.
     *
     * @return The list of reports.
     */
    public ArrayList<Raport> getRaportsList(){
        return this.raportsList;
    }
}
