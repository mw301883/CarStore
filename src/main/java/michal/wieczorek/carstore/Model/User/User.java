/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.User;

import java.util.ArrayList;

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
    
    User(String name, String surname, String address, String email, String login, String password){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.login = login;
        this.password = password;
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
    
    public String getUserLogin(){
        return this.login;
    }
    
    public String getUserPassword(){
        return this.password;
    }
}
