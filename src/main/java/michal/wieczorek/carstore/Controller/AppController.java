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
 *
 * @author Michał
 */
public class AppController {
    
    private final AppModel appModel;
    
    private final LoginGUI loginGUI = new LoginGUI(this);
    private final SigningGUI signingGUI = new SigningGUI(this);
    private final AdminGUI adminGUI;
    
    public AppController(AppModel appModel) {
        this.appModel = appModel;
        this.adminGUI = new AdminGUI(this);
        this.loginGUI.setVisible(true);
    }
    
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
    
    public void handleSigningUp(){
        this.signingGUI.setVisible(true);
    }
    
    public void createNewUser(ArrayList<String> userAttributes, boolean isUser){
        this.appModel.createNewUser(userAttributes, isUser);
        this.loginGUI.setVisible(true);
    }
    
    public void restoreLoginPage(){
        this.loginGUI.cleanTextFields();
        this.loginGUI.setVisible(true);
    }
    
    public void displayReports(){
        this.adminGUI.setVisible(false);
        RaportsDisplayGUI raportsDisplayGUI = new RaportsDisplayGUI(this);
    }
    
    public void restoreAdminPage(){
        this.adminGUI.setVisible(true);
    }
    
    public void setCarAPrice(double NewPrice){
        CarA.setPrice(NewPrice);
    }
    
    public void setCarBPrice(double NewPrice){
        CarB.setPrice(NewPrice);
    }
    
    public void setCarCPrice(double NewPrice){
        CarC.setPrice(NewPrice);
    }
    
    public void reserveCurrentUserCarA(int index){
        addCustomerToRaport();
        this.appModel.getCurrentUser().addCarAtoOrder(index);
        this.appModel.reserveCarA(index);
    }
    
    public void removeCurrentUserCarA(int index){
        this.appModel.getCurrentUser().removeCarAfromOrder(index);
        this.appModel.returnCarA(index);
        actualiseRaport();
    }
    
    public void reserveCurrentUserCarB(int index){
        addCustomerToRaport();
        this.appModel.getCurrentUser().addCarBtoOrder(index);
        this.appModel.reserveCarB(index);
    }
    
    public void removeCurrentUserCarB(int index){
        this.appModel.getCurrentUser().removeCarBfromOrder(index);
        this.appModel.returnCarB(index);
        actualiseRaport();
    }
    
    public void reserveCurrentUserCarC(int index){
        addCustomerToRaport();
        this.appModel.getCurrentUser().addCarCtoOrder(index);
        this.appModel.reserveCarC(index);
    }
    
    public void removeCurrentUserCarC(int index){
        this.appModel.getCurrentUser().removeCarCfromOrder(index);
        this.appModel.returnCarC(index);
        actualiseRaport();
    }
    
    private void addCustomerToRaport(){
        User user = this.appModel.getCurrentUser();
        if(user.getPayment() >= 0){
            this.appModel.removeCustomerFromRaport(user);
            this.appModel.addCustomerToRaport(user);
        }
    }
    //TODO set discount to Premium User and fix display "avaible" in premium gui
    private void actualiseRaport(){
        User user = this.appModel.getCurrentUser();
        this.appModel.removeCustomerFromRaport(user);
        if(user.getPayment() > 0){
            this.appModel.addCustomerToRaport(user);
        }
    }
    
    public ArrayList<CarA> getCarsA(){
        return this.appModel.getCarsA();
    }
    
    public ArrayList<CarB> getCarsB(){
        return this.appModel.getCarsB();
    }
    
    public ArrayList<CarC> getCarsC(){
        return this.appModel.getCarsC();
    }
    
    public User getCurrentUser(){
        return this.appModel.getCurrentUser();
    }
    
    public void generateRaport(){
        this.appModel.generateRaport();
    }
    
    public ArrayList<Raport> getRaportsList(){
        return this.appModel.getRaportsList();
    }
}
