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
    private final String mark;
    private final String name;
    boolean isAvaible;
    
    public Car(String mark, String name){
         this.mark = mark;
        this.name = name;
        this.isAvaible = true;
    }
    
    public void rentCar(){
        this.isAvaible = false;
    }
    
    public void returnCar(){
        this.isAvaible = true;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getMark(){
        return this.mark;
    }
    
    public boolean getIsAvaible(){
        return this.isAvaible;
    }
}
