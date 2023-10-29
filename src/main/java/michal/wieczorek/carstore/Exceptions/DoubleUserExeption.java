/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Exceptions;

/**
 * Custom exception class for handling cases where duplicate user accounts cannot be created.
 * This exception is thrown when an attempt is made to create duplicate accounts.
 * @author Michał Wieczorek
 * @version 1.0
 */
public class DoubleUserExeption extends Exception{
    /**
     * Constructor of custom exception.
     */
    public DoubleUserExeption() {
        super("Can not create duplicated accounts.");
    }
}
