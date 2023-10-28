/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.Car;

/**
 * Represents a specific type of car, Car B, which is a subclass of the general Car class.
 * @author Michał Wieczorek
 * @version 1.0
 */
public class CarB extends Car {
    /**
     * The rental price for Car B.
     */
    private static double price;

    /**
     * Constructs a new CarB object with the specified name and brand.
     *
     * @param name The name or model of the car.
     * @param mark The brand or manufacturer of the car.
     */
    public CarB(String name, String mark) {
        super(name, mark);
    }

    /**
     * Gets the rental price for Car B.
     *
     * @return The rental price for Car B.
     */
    public static double getPrice() {
        return CarB.price;
    }

    /**
     * Sets the rental price for Car B.
     *
     * @param price The new rental price for Car B.
     */
    public static void setPrice(double price) {
        CarB.price = price;
    }
}

