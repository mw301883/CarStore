/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.Raport;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import michal.wieczorek.carstore.Model.User.User;
import michal.wieczorek.carstore.Model.User.UserEnum;

/**
 *
 * @author Michał
 */
public class Raport {
    private double totalPrice = 0.0;
    private Calendar date;
    private ArrayList<User> customerList = new ArrayList<>();
    private int customerCount = 0;

    public Raport(){
        
    }
    
    public Raport(Raport raport) {
        this.totalPrice = raport.totalPrice;
        this.date = raport.date;
        this.customerList = raport.customerList;
        this.customerCount = raport.customerList.size();
    }
    
    public void calculateTotalPrice(){
        for(User user : this.customerList){
            if(user.getUserType().equals(UserEnum.UserType.PREMIUM)){
                this.totalPrice += user.getPayment()*0.7;
            }
            else{
                this.totalPrice += user.getPayment();
            }
        }
    }
    
    public void calculateDate(){
        this.date = Calendar.getInstance();
    }
    
    public void addCustomer(User customer){
        this.customerList.add(customer);
    }
    
    public void removeCustomer(User user){
        int idx = 0;
        for(User customer : this.customerList){
            if(customer.getUserName().equals(user.getUserName()) &&
               customer.getUserSurname().equals(user.getUserSurname()) &&
               customer.getUserAddress().equals(user.getUserAddress()) &&
               customer.getUserEmail().equals(user.getUserEmail()) &&
               customer.getUserLogin().equals(user.getUserLogin())){
                this.customerList.remove(idx);
                return;
            }
            ++idx;
        }
    }
    
    public int getCustomerCount(){
        return this.customerCount;
    }
    
    public Date getDate(){
        return this.date.getTime();
    }
    
    public double getTotalPrice(){
        return this.totalPrice;
    }
}
