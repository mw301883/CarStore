/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.Raport;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;
import michal.wieczorek.carstore.Model.User.User;
import michal.wieczorek.carstore.Model.User.UserEnum;

/**
 * Represents a report that contains information about customers, their payments, and the report's total price.
 * @author Michał Wieczorek
 * @version 1.0
 */
public class Raport {
    /**
     * The total price of the report.
     */
    private double totalPrice = 0.0;  
    /**
     * The date when the report is generated.
     */
    private Calendar date;     
    /**
     * A list of customers included in the report.
     */
    private ArrayList<User> customerList = new ArrayList<>();  
    /**
     * The count of customers in the report.
     */
    private int customerCount = 0;            

    /**
     * Default constructor for the Raport class.
     */
    public Raport() {
        
    }

    /**
     * Constructor to create a new report based on an existing report.
     *
     * @param raport The existing report to use as a template.
     */
    public Raport(Raport raport) {
        this.totalPrice = new Double(raport.totalPrice);
        this.date = raport.date;

        if (raport.customerList != null) {
            ArrayList<User> customerListCopy = new ArrayList<>();
            customerListCopy = (ArrayList<User>) raport.customerList.stream().collect(Collectors.toCollection(ArrayList::new));
//            for (User user : raport.customerList) {
//                customerListCopy.add(new User(user));
//            }
            this.customerList = customerListCopy;
        }

        this.customerCount = 0;
    }

    /**
     * Calculate the total price of the report based on customer payments.
     */
    public void calculateTotalPrice() {
        for (User user : this.customerList) {
            if (user.getUserType().equals(UserEnum.UserType.PREMIUM)) {
                this.totalPrice += user.getPayment() * 0.7;
                user.setPayment(user.getPayment() * 0.7);
            } else {
                this.totalPrice += user.getPayment();
            }
        }
    }

    /**
     * Calculate the date when the report is generated.
     */
    public void calculateDate() {
        this.date = Calendar.getInstance();
    }

    /**
     * Add a customer to the report.
     *
     * @param customer The customer to be added to the report.
     */
    public void addCustomer(User customer) {
        this.customerList.add(customer);
        this.customerCount += 1;
    }

    /**
     * Remove a customer from the report based on their user information.
     *
     * @param user The user to be removed from the report.
     */
    public void removeCustomer(User user) {
        int idx = 0;
        for (User customer : this.customerList) {
            if (customer.getUserName().equals(user.getUserName()) &&
                customer.getUserSurname().equals(user.getUserSurname()) &&
                customer.getUserAddress().equals(user.getUserAddress()) &&
                customer.getUserEmail().equals(user.getUserEmail()) &&
                customer.getUserLogin().equals(user.getUserLogin()) &&
                customer.getUserType().equals(user.getUserType())) {
                this.customerList.remove(idx);
                this.customerCount -= 1;
                return;
            }
            ++idx;
        }
    }

    /**
     * Get the count of customers in the report.
     *
     * @return The count of customers in the report.
     */
    public int getCustomerCount() {
        return this.customerCount;
    }

    /**
     * Get the date when the report is generated.
     *
     * @return The date of report generation.
     */
    public Date getDate() {
        return this.date.getTime();
    }

    /**
     * Get the total price of the report.
     *
     * @return The total price of the report.
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * Get the list of customers included in the report.
     *
     * @return The list of customers in the report.
     */
    public ArrayList<User> getCustomerList() {
        return this.customerList;
    }
}

