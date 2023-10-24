/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.Raport;

import java.util.ArrayList;
import java.util.Calendar;
import michal.wieczorek.carstore.Model.User.User;

/**
 *
 * @author Michał
 */
public class Raport {
    private double totalPrice = 0.0;
    private Calendar date;
    private ArrayList<User> customerList = new ArrayList<>();
    private ArrayList<Double> paymentList = new ArrayList<>();

    public Raport() {
    }
    
    public void calculateTotalPrice(){
        for(Double price : this.paymentList){
            this.totalPrice += price;
        }
    }
    
    public void calculateDate(){
        this.date = Calendar.getInstance();
    }
}
