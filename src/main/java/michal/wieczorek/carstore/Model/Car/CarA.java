/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.Car;

/**
 * Represents a specific type of car, Car A, which is a subclass of the general Car class.
 * @author Michał Wieczorek
 * @version 1.0
 */
public class CarA extends Car {
    /**
     * The rental price for Car A.
     */
    private static double price;

    /**
     * Constructs a new CarA object with the specified name and brand.
     *
     * @param name The name or model of the car.
     * @param mark The brand or manufacturer of the car.
     */
    public CarA(String name, String mark) {
        super(name, mark);
    }

    /**
     * Gets the rental price for Car A.
     *
     * @return The rental price for Car A.
     */
    public static double getPrice() {
        return CarA.price;
    }

    /**
     * Sets the rental price for Car A.
     *
     * @param price The new rental price for Car A.
     */
    public static void setPrice(double price) {
        CarA.price = price;
    }
}
