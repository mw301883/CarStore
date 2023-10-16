package michal.wieczorek.carstore;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import michal.wieczorek.carstore.Model.AppModel;
import michal.wieczorek.carstore.Controller.AppController;
import michal.wieczorek.carstore.View.AdminGUI;

/**
 *
 * @author Michał
 */
public class CarStore {

    public static void main(String[] args) {
        AppModel appModel = new AppModel();
        AppController appController = new AppController(appModel);
    }
}
