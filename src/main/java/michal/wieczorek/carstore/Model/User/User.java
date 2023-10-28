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
 * Represents a user in the application, including personal information, rental orders, and payment data.
 * @author Michał
 * @version 1.0
 */
public class User {
    /**
     * The user's first name.
     */
    private String name;
    /**
     * The user's last name.
     */
    private String surname;
    /**
     * The user's address.
     */
    private String address;
    /**
     * The user's email address.
     */
    private String email;
    /**
     * The user's login name.
     */
    private String login;
    /**
     * The user's password.
     */
    private String password;
    /**
     * The set of reserved Car A indices.
     */
    private HashSet<Integer> reservedCarsA = new HashSet<>();
    /**
     * The set of reserved Car B indices.
     */
    private HashSet<Integer> reservedCarsB = new HashSet<>();
    /**
     * The set of reserved Car C indices.
     */
    private HashSet<Integer> reservedCarsC = new HashSet<>();
    /**
     * The total payment made by the user.
     */
    private double payment = 0.0;
    /**
     * The user's type (e.g., STANDARD or PREMIUM).
     */
    private UserType userType;
    
    /**
     * Constructs a new User object with the specified user information and user type.
     *
     * @param name The user's first name.
     * @param surname The user's last name.
     * @param address The user's address.
     * @param email The user's email address.
     * @param login The user's login name.
     * @param password The user's password.
     * @param userType The user's type (e.g., STANDARD or PREMIUM).
     */
    public User(String name, String surname, String address, String email, String login, String password, UserType userType){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.login = login;
        this.password = password;
        this.userType = userType;
    }
    
    /**
     * Copy constructor to create a new User object based on an existing user.
     *
     * @param user The existing user to use as a template.
     */
    public User(User user){
        this.name = user.name;
        this.surname = user.surname;
        this.address = user.address;
        this.email = user.email;
        this.login = user.login;
        this.password = user.password;
        this.userType = user.userType;
        this.reservedCarsA = new HashSet<>(user.reservedCarsA);
        this.reservedCarsB = new HashSet<>(user.reservedCarsB);
        this.reservedCarsC = new HashSet<>(user.reservedCarsC);
        this.payment = user.payment;
    }
    
    /**
     * Get the user's personal data.
     *
     * @return An ArrayList containing the user's name, surname, address, email, and login.
     */
    public ArrayList<String> getUserData(){
        ArrayList<String> UserData = new ArrayList<>();
        UserData.add(this.name);
        UserData.add(this.surname);
        UserData.add(this.address);
        UserData.add(this.email);
        UserData.add(this.login);
        return UserData;
    }
    
    /**
     * Get the user's first name.
     *
     * @return The user's first name.
     */
    public String getUserName(){
        return this.name;
    }
    
    /**
     * Get the user's last name.
     *
     * @return The user's last name.
     */
    public String getUserSurname(){
        return this.surname;
    }
    
    /**
     * Get the user's address.
     *
     * @return The user's address.
     */
    public String getUserAddress(){
        return this.address;
    }
    
    /**
     * Get the user's email address.
     *
     * @return The user's email address.
     */
    public String getUserEmail(){
        return this.email;
    }
    
    /**
     * Get the user's login name.
     *
     * @return The user's login name.
     */
    public String getUserLogin(){
        return this.login;
    }
    
    /**
     * Get the user's password.
     *
     * @return The user's password.
     */
    public String getUserPassword(){
        return this.password;
    }
    
    /**
     * Add Car A to the user's rental order based on the index of the car.
     *
     * @param index The index of the Car A to add to the user's order.
     */
    public void addCarAtoOrder(int index){
        this.reservedCarsA.add(index);
        this.payment += CarA.getPrice();
    }
    
    /**
     * Remove Car A from the user's rental order based on the index of the car.
     *
     * @param index The index of the Car A to remove from the user's order.
     */
    public void removeCarAfromOrder(int index){
        this.reservedCarsA.remove(index);
        this.payment -= CarA.getPrice();
    }
    
    /**
     * Add Car B to the user's rental order based on the index of the car.
     *
     * @param index The index of the Car B to add to the user's order.
     */
    public void addCarBtoOrder(int index){
        this.reservedCarsB.add(index);
        this.payment += CarB.getPrice();
    }
    
    /**
     * Remove Car B from the user's rental order based on the index of the car.
     *
     * @param index The index of the Car B to remove from the user's order.
     */
    public void removeCarBfromOrder(int index){
        this.reservedCarsB.remove(index);
        this.payment -= CarB.getPrice();
    }
    
    /**
     * Add Car C to the user's rental order based on the index of the car.
     *
     * @param index The index of the Car C to add to the user's order.
     */
    public void addCarCtoOrder(int index){
        this.reservedCarsC.add(index);
        this.payment += CarC.getPrice();
    }
    
    /**
     * Remove Car C from the user's rental order based on the index of the car.
     *
     * @param index The index of the Car C to remove from the user's order.
     */
    public void removeCarCfromOrder(int index){
        this.reservedCarsC.remove(index);
        this.payment -= CarA.getPrice();
    }
    
    /**
     * Get the set of reserved Car A indices in the user's order.
     *
     * @return A HashSet containing the indices of reserved Car A.
     */
    public HashSet<Integer> getReservedCarsA(){
        return this.reservedCarsA;
    }
    
    /**
     * Get the set of reserved Car B indices in the user's order.
     *
     * @return A HashSet containing the indices of reserved Car B.
     */
    public HashSet<Integer> getReservedCarsB(){
        return this.reservedCarsB;
    }
    
    /**
     * Get the set of reserved Car C indices in the user's order.
     *
     * @return A HashSet containing the indices of reserved Car C.
     */
    public HashSet<Integer> getReservedCarsC(){
        return this.reservedCarsC;
    }
    
    /**
     * Get the total payment made by the user.
     *
     * @return The total payment made by the user.
     */
    public double getPayment(){
        return this.payment;
    }
    
    /**
     * Check if the user's rental order lists for all car types are empty.
     *
     * @return true if all rental order lists are empty, false otherwise.
     */
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
    
    /**
     * Get the user's type (e.g., STANDARD or PREMIUM).
     *
     * @return The user's type.
     */
    public UserType getUserType(){
        return this.userType;
    }
    
    /**
     * Set the total payment made by the user.
     *
     * @param payment The new total payment for the user.
     */
    public void setPayment(double payment){
        this.payment = payment;
    }
}


