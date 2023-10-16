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
import michal.wieczorek.carstore.View.SigningGUI;

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
        adminGUI = new AdminGUI(this);
        
        loginGUI.setVisible(true);
    }
    
    public void handleLogin(ArrayList<String> loginData){
        int loginChoice = appModel.handleLogin(loginData);
        switch (loginChoice) {
            case 1:
                loginGUI.setVisible(false);
                adminGUI.setVisible(true);
                break;
            case 2:
                //loginGUI.setVisible(false);
                //adminGUI.setVisible(true);
                break;
            case 3:
                //loginGUI.setVisible(false);
                //adminGUI.setVisible(true);
                break;
            default:
                ErrorGUI ErrorMessage = new ErrorGUI();
        }
    }
    
    public void handleSigningUp(){
        signingGUI.setVisible(true);
    }
    
    public void createNewUser(ArrayList<String> userAttributes, boolean isUser){
        appModel.createNewUser(userAttributes, isUser);
        loginGUI.setVisible(true);
    }
    
    public void restoreLoginPage(){
        loginGUI.cleanTextFields();
        loginGUI.setVisible(true);
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
