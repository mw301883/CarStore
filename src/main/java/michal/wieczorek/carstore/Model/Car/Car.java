/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.Car;

/**
 *
 * @author Michał
 */
public abstract class Car {
    private final String name;
    private final String mark;
    boolean isAvaible;
    
    public Car(String name, String mark){
        this.name = name;
        this.mark = mark;
        this.isAvaible = true;
    }
    
    public void rentCar(){
        this.isAvaible = false;
    }
    
    public void returnCar(){
        this.isAvaible = false;
    }
}
