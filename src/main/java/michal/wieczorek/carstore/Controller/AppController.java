/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Controller;

import michal.wieczorek.carstore.Model.AppModel;
import java.util.ArrayList;
import michal.wieczorek.carstore.Model.Car.CarA;
import michal.wieczorek.carstore.Model.Car.CarB;
import michal.wieczorek.carstore.Model.Car.CarC;
import michal.wieczorek.carstore.Model.Raport.Raport;
import michal.wieczorek.carstore.Model.User.User;
import michal.wieczorek.carstore.View.AdminGUI.AdminGUI;
import michal.wieczorek.carstore.View.ErrorGUI.ErrorGUI;
import michal.wieczorek.carstore.View.MainGUI.LoginGUI;
import michal.wieczorek.carstore.View.UserGUI.PremiumUserGUI;
import michal.wieczorek.carstore.View.AdminGUI.RaportsDisplayGUI;
import michal.wieczorek.carstore.View.MainGUI.SigningGUI;
import michal.wieczorek.carstore.View.UserGUI.StandardUserGUI;

/**
 * Controller class which link main Model class with all Views class. 
 * @author Michał Wieczorek
 * @version 1.0
 */
public class AppController {
    
     /**
    * Represents the application model, which contains the data and business logic of the application.
    */
   private final AppModel appModel;

   /**
    * User Interface (GUI) for logging in, used in the application.
    * 
    * @see LoginGUI
    */
   private final LoginGUI loginGUI = new LoginGUI(this);

   /**
    * User Interface (GUI) for signing up, used in the application.
    * 
    * @see SigningGUI
    */
   private final SigningGUI signingGUI = new SigningGUI(this);

   /**
    * User Interface (GUI) for the application's administrator.
    * 
    * @see AdminGUI
    */
   private final AdminGUI adminGUI;


    
    /**
     * Constructor of Controller, it poseses Model as reference. 
     * @param appModel 
     */
    public AppController(AppModel appModel) {
        this.appModel = appModel;
        this.adminGUI = new AdminGUI(this);
        this.loginGUI.setVisible(true);
    }
    
    /**
     * Method which handle login case when user tries to log in. It checks if acconunt exists and 
     * also checks type of user - Premium or Standard. 
     * @param loginData array of Strings which contains login data which user enter in form - all User class atributes.
     */
    public void handleLogin(ArrayList<String> loginData){
        int loginChoice = appModel.handleLogin(loginData);
        switch (loginChoice) {
            case 1:
                this.loginGUI.setVisible(false);
                this.adminGUI.setVisible(true);
                break;
            case 2:
                this.loginGUI.setVisible(false);
                StandardUserGUI standardUserGUI = new StandardUserGUI(this);
                break;
            case 3:
                this.loginGUI.setVisible(false);
                PremiumUserGUI premiumUserGUI = new PremiumUserGUI(this);
                break;
            default:
                ErrorGUI errorMessage = new ErrorGUI();
                errorMessage.display();
        }
    }
    
    /**
     * Method which handel sign up case, it displays signing GUI.
     */
    public void handleSigningUp(){
        this.signingGUI.setVisible(true);
    }
    
    /**
     * This method handle create user case and inform about it main Model class.
     * @param userAttributes Array of Stings which contains all User class atributes.
     * @param isUser Boolean variable which informs if user data is unique in order to create new account.
     */
    public void createNewUser(ArrayList<String> userAttributes, boolean isUser){
        this.appModel.createNewUser(userAttributes, isUser);
        this.loginGUI.setVisible(true);
    }
    
    /**
     * This method clear login form and display it.
     */
    public void restoreLoginPage(){
        this.loginGUI.cleanTextFields();
        this.loginGUI.setVisible(true);
    }
    
    /**
     * This method display raports GUI after admin click button "Raports Display".
     */
    public void displayReports(){
        this.adminGUI.setVisible(false);
        RaportsDisplayGUI raportsDisplayGUI = new RaportsDisplayGUI(this);
    }
    
    /**
     * This method display again admin GUI page.
     */
    public void restoreAdminPage(){
        this.adminGUI.setVisible(true);
    }
    
    /**
     * Method which set new price of all Cars A-class objects.
     * @param NewPrice New price of all Cars A-class objects.
     */
    public void setCarAPrice(double NewPrice){
        CarA.setPrice(NewPrice);
    }
    
    /**
     * Method which set new price of all Cars B-class objects.
     * @param NewPrice New price of all Cars B-class objects.
     */
    public void setCarBPrice(double NewPrice){
        CarB.setPrice(NewPrice);
    }
    
    /**
     * Method which set new price of all Cars C-class objects.
     * @param NewPrice New price of all Cars C-class objects.
     */
    public void setCarCPrice(double NewPrice){
        CarC.setPrice(NewPrice);
    }
    
    /**
    * Reserves a Car A for the currently logged-in user.
    *
    * @param index The index of the Car A to be reserved.
    */
    public void reserveCurrentUserCarA(int index){
        addCustomerToRaport();
        this.appModel.getCurrentUser().addCarAtoOrder(index);
        this.appModel.reserveCarA(index);
    }
    
    /**
    * Removes the reservation of Car A for the currently logged-in user.
    *
    * @param index The index of the Car A to be removed from the reservation.
    */
    public void removeCurrentUserCarA(int index){
        this.appModel.getCurrentUser().removeCarAfromOrder(index);
        this.appModel.returnCarA(index);
        actualiseRaport();
    }
    
    /**
    * Reserves a Car B for the currently logged-in user.
    *
    * @param index The index of the Car B to be reserved.
    */
    public void reserveCurrentUserCarB(int index){
        addCustomerToRaport();
        this.appModel.getCurrentUser().addCarBtoOrder(index);
        this.appModel.reserveCarB(index);
    }
    
    
    /**
     * Removes the reservation of Car B for the currently logged-in user.
     *
     * @param index The index of the Car B to be removed from the reservation.
     */
    public void removeCurrentUserCarB(int index){
        this.appModel.getCurrentUser().removeCarBfromOrder(index);
        this.appModel.returnCarB(index);
        actualiseRaport();
    }
    /**
    * Reserves a Car C for the currently logged-in user.
    *
    * @param index The index of the Car C to be reserved.
    */
    public void reserveCurrentUserCarC(int index){
        addCustomerToRaport();
        this.appModel.getCurrentUser().addCarCtoOrder(index);
        this.appModel.reserveCarC(index);
    }
    
    /**
    * Removes the reservation of Car C for the currently logged-in user.
    *
    * @param index The index of the Car C to be removed from the reservation.
    */
    public void removeCurrentUserCarC(int index){
        this.appModel.getCurrentUser().removeCarCfromOrder(index);
        this.appModel.returnCarC(index);
        actualiseRaport();
    }
    
    /**
    * Adds a customer to the report if they have a positive balance.
    */
    private void addCustomerToRaport(){
        User user = this.appModel.getCurrentUser();
        if(user.getPayment() >= 0){
            this.appModel.removeCustomerFromRaport(user);
            this.appModel.addCustomerToRaport(user);
        }
    }
    
    /**
     * Updates the customer's report based on their payment status.
     */
    private void actualiseRaport(){
        User user = this.appModel.getCurrentUser();
        this.appModel.removeCustomerFromRaport(user);
        if(user.getPayment() > 0){
            this.appModel.addCustomerToRaport(user);
        }
    }
    
    /**
    * Gets the list of Car A.
    *
    * @return The list of Car A.
    */
    public ArrayList<CarA> getCarsA(){
        return this.appModel.getCarsA();
    }
    
    /**
    * Gets the list of Car B.
    *
    * @return The list of Car B.
    */
    public ArrayList<CarB> getCarsB(){
        return this.appModel.getCarsB();
    }
    
    /**
    * Gets the list of Car C.
    *
    * @return The list of Car C.
    */
    public ArrayList<CarC> getCarsC(){
        return this.appModel.getCarsC();
    }
    
    
    /**
    * Gets the currently logged-in user.
    *
    * @return The currently logged-in user.
    */
    public User getCurrentUser(){
        return this.appModel.getCurrentUser();
    }
    
    /**
     * Generates a report based on the application model's data.
     */
    public void generateRaport(){
        this.appModel.generateRaport();
    }
    
    /**
    * Gets the list of reports.
    *
    * @return The list of reports.
    */
    public ArrayList<Raport> getRaportsList(){
        return this.appModel.getRaportsList();
    }
}
