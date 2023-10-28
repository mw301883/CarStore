/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.Car;

/**
 * An abstract class representing a general concept of a car.
 * @author Michał Wieczorek
 * @version 1.0
 */
public abstract class Car {
    /**
    * The brand or manufacturer of the car.
    */
    private final String mark;
    /**
    * The name or model of the car.
    */
    private final String name;
    /**
    * A flag indicating whether the car is available for rent.
    */
    boolean isAvaible;
    
    /**
     * Constructs a new Car object with the specified brand and name.
     *
     * @param mark The brand or manufacturer of the car.
     * @param name The name or model of the car.
     */
    public Car(String mark, String name) {
        this.mark = mark;
        this.name = name;
        this.isAvaible = true;
    }

    /**
     * Rents the car, marking it as unavailable for rent.
     */
    public void rentCar() {
        this.isAvaible = false;
    }

    /**
     * Returns the car, marking it as available for rent.
     */
    public void returnCar() {
        this.isAvaible = true;
    }

    /**
     * Gets the name or model of the car.
     *
     * @return The name or model of the car.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the brand or manufacturer of the car.
     *
     * @return The brand or manufacturer of the car.
     */
    public String getMark() {
        return this.mark;
    }

    /**
     * Checks if the car is available for rent.
     *
     * @return true if the car is available; false if it is already rented.
     */
    public boolean getIsAvaible() {
        return this.isAvaible;
    }
}
