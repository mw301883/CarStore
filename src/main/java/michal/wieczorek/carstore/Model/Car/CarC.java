/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.Car;

/**
 *
 * @author Michał
 */
public class CarC extends Car{
    private static double price;

    public CarC(String name, String mark) {
        super(name, mark);
    }
    
    public static void setPrice(double price){
        CarC.price = price;
    }
}
