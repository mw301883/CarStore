/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.User;

import java.util.ArrayList;
import java.util.HashSet;
import michal.wieczorek.carstore.Model.Car.CarA;
import michal.wieczorek.carstore.Model.Car.CarB;
import michal.wieczorek.carstore.Model.Car.CarC;
import michal.wieczorek.carstore.Model.User.UserEnum.UserType;

/**
 *
 * @author Michał
 */
public class User {
    private String name;
    private String surname;
    private String address;
    private String email;
    private String login;
    private String password;
    private HashSet<Integer> reservedCarsA = new HashSet<>();
    private HashSet<Integer> reservedCarsB = new HashSet<>();
    private HashSet<Integer> reservedCarsC = new HashSet<>();
    private double payment = 0.0;
    private UserType userType;
    
    
    public User(String name, String surname, String address, String email, String login, String password, UserType userType){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.login = login;
        this.password = password;
        this.userType = userType;
    }
    
    public ArrayList<String> getUserData(){
        ArrayList<String> UserData = new ArrayList<>();
        UserData.add(this.name);
        UserData.add(this.surname);
        UserData.add(this.address);
        UserData.add(this.email);
        UserData.add(this.login);
        return UserData;
    }
    
    public String getUserName(){
        return this.name;
    }
    
    public String getUserSurname(){
        return this.surname;
    }
    
    public String getUserAddress(){
        return this.address;
    }
    
    public String getUserEmail(){
        return this.email;
    }
    
    public String getUserLogin(){
        return this.login;
    }
    
    public String getUserPassword(){
        return this.password;
    }
    
    public void addCarAtoOrder(int index){
        this.reservedCarsA.add(index);
        this.payment += CarA.getPrice();
    }
    
    public void removeCarAfromOrder(int index){
        this.reservedCarsA.remove(index);
        this.payment -= CarA.getPrice();
    }
    
    public void addCarBtoOrder(int index){
        this.reservedCarsB.add(index);
        this.payment += CarB.getPrice();
    }
    
    public void removeCarBfromOrder(int index){
        this.reservedCarsB.remove(index);
        this.payment -= CarB.getPrice();
    }
    
    public void addCarCtoOrder(int index){
        this.reservedCarsC.add(index);
        this.payment += CarC.getPrice();
    }
    
    public void removeCarCfromOrder(int index){
        this.reservedCarsC.remove(index);
        this.payment -= CarA.getPrice();
    }
    
    public HashSet<Integer> getReservedCarsA(){
        return this.reservedCarsA;
    }
    
    public HashSet<Integer> getReservedCarsB(){
        return this.reservedCarsB;
    }
    
    public HashSet<Integer> getReservedCarsC(){
        return this.reservedCarsC;
    }
    
    public double getPayment(){
        return this.payment;
    }
    
    public boolean areCarListsEmpty(){
        if(this.reservedCarsA.isEmpty()){
            if(this.reservedCarsB.isEmpty()){
                if(this.reservedCarsC.isEmpty()){
                    return true;
                }
            }
        }
        return false;
    }
    
    public UserType getUserType(){
        return this.userType;
    }
}
