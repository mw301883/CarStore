/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.Car;

/**
 *
 * @author Michał
 */
public class CarA extends Car{
    private static double price;

    public CarA(String name, String mark) {
        super(name, mark);
    }
    
    public static void setPrice(double price){
        CarA.price = price;
    }
}
