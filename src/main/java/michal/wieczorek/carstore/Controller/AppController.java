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
import michal.wieczorek.carstore.View.AdminGUI;
import michal.wieczorek.carstore.View.ErrorGUI;
import michal.wieczorek.carstore.View.LoginGUI;
import michal.wieczorek.carstore.View.PremiumUserGUI;
import michal.wieczorek.carstore.View.SigningGUI;
import michal.wieczorek.carstore.View.StandardUserGUI;

/**
 *
 * @author Michał
 */
public class AppController {
    
    private final AppModel appModel;
    
    private final LoginGUI loginGUI = new LoginGUI(this);
    private final SigningGUI signingGUI = new SigningGUI(this);
    private final AdminGUI adminGUI;
    private final StandardUserGUI standardUserGUI;
    private final PremiumUserGUI premiumUserGUI;
    
    public AppController(AppModel appModel) {
        this.appModel = appModel;
        this.adminGUI = new AdminGUI(this);
        this.standardUserGUI = new StandardUserGUI(this, appModel);
        this.premiumUserGUI = new PremiumUserGUI(this, appModel);
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
                this.standardUserGUI.setActualUserDisplay();
                this.standardUserGUI.setVisible(true);
                break;
            case 3:
                this.loginGUI.setVisible(false);
                this.premiumUserGUI.setActualUserDisplay();
                this.premiumUserGUI.setVisible(true);
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
    
    public void setCarAPrice(double NewPrice){
        CarA.setPrice(NewPrice);
    }
    
    public void setCarBPrice(double NewPrice){
        CarB.setPrice(NewPrice);
    }
    
    public void setCarCPrice(double NewPrice){
        CarC.setPrice(NewPrice);
    }
}
