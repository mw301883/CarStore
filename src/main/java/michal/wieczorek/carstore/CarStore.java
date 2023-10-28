package michal.wieczorek.carstore;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import michal.wieczorek.carstore.Model.AppModel;
import michal.wieczorek.carstore.Controller.AppController;

/**
 * Main class from which program begins.
 * @author Michał
 * @version 1.0
 */
public class CarStore {
    /**
     *  Main method which starts program. It takes start parameters from console. 
     * @param args array of console start parameters
     */
    public static void main(String[] args) {
       AppModel appModel = new AppModel();
       AppController appController = new AppController(appModel);
    }
}
