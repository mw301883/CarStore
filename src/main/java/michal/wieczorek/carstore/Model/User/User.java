/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.User;

/**
 *
 * @author Michał
 */
public abstract class User {
    private String name;
    private String surname;
    private String address;
    private String email;
    private String login;
    private String password;
    
    User(String name, String surname, String address, String email){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
    }
}
