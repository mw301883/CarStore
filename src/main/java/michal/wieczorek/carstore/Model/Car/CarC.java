/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.Car;

/**
 * Represents a specific type of car, Car C, which is a subclass of the general Car class.
 * @author Michał Wieczorek
 * @version 1.0
 */
public class CarC extends Car {
    /**
     * The rental price for Car C.
     */
    private static double price;

    /**
     * Constructs a new CarC object with the specified name and brand.
     *
     * @param name The name or model of the car.
     * @param mark The brand or manufacturer of the car.
     */
    public CarC(String name, String mark) {
        super(name, mark);
    }

    /**
     * Gets the rental price for Car C.
     *
     * @return The rental price for Car C.
     */
    public static double getPrice() {
        return CarC.price;
    }

    /**
     * Sets the rental price for Car C.
     *
     * @param price The new rental price for Car C.
     */
    public static void setPrice(double price) {
        CarC.price = price;
    }
}

