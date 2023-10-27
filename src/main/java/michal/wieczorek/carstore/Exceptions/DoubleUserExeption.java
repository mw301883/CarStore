/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Exceptions;

/**
 *
 * @author Michał
 */
public class DoubleUserExeption extends Exception{
    public DoubleUserExeption() {
        super("Can not create duplicated accounts.");
    }
}
