/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.Model.User;

/**
 * Represents an administrator of the application, responsible for managing system access.
 * @author Michał Wieczorek
 * @version 1.0
 */
public class Admin {
    
    private String Password;  // The password of the administrator.

    /**
     * Constructs a new Admin object with the specified password.
     *
     * @param Password The password of the administrator.
     */
    public Admin(String Password) {
        this.Password = Password;
    }

    /**
     * Gets the password of the administrator.
     *
     * @return The password of the administrator.
     */
    public String getPassword() {
        return this.Password;
    }

    /**
     * Sets the password of the administrator.
     *
     * @param Password The new password for the administrator.
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
}

