/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View.MainGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import michal.wieczorek.carstore.Controller.AppController;

/**
 * Represents a graphical user interface (GUI) for user login and sign-up in the application.
 * @author Michał Wieczorek
 * @version 1.0
 */
public class LoginGUI extends JFrame {
    /**
    * The application controller responsible for managing user interactions.
    */
   private AppController appController;

   /**
    * A label indicating the "Login" input field.
    */
   private JLabel loginLabel = new JLabel("Login:");

   /**
    * A label indicating the "Password" input field.
    */
   private JLabel passwordLabel = new JLabel("Password:");

   /**
    * The text field for entering the user's login credentials.
    */
   private JTextField loginTextField = new JTextField(10);

   /**
    * The password field for entering the user's password.
    */
   private JPasswordField passwordTextField = new JPasswordField(10);

   /**
    * The button used to initiate the login process.
    */
   private JButton loginButton = new JButton("SIGN IN");

   /**
    * The button used to navigate to the sign-up interface.
    */
   private JButton signingButton = new JButton("SIGN UP");

    
    /**
     * Initializes a LoginGUI with the specified application controller.
     *
     * @param appController The application controller for handling user interactions.
     */
    public LoginGUI(AppController appController) {
        this.appController = appController;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 150);

        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(loginLabel);
        panel.add(loginTextField);
        panel.add(passwordLabel);
        panel.add(passwordTextField);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(loginButton);
        buttonPanel.add(signingButton);

        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        loginButton.addActionListener(this::validateLogin);
        KeyStroke enterKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        loginButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enterKeyStroke, "enter");
        loginButton.getActionMap().put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> loginData = new ArrayList<>();
                loginData.add(loginTextField.getText());
                loginData.add(new String(passwordTextField.getPassword()));
                appController.handleLogin(loginData);
            }
        });
        loginButton.setToolTipText("Login to Store or Admin Panel.");
        signingButton.addActionListener(this::validateSign);
        KeyStroke ctrlSKeyStroke = KeyStroke.getKeyStroke("control S");
        loginButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ctrlSKeyStroke, "ctrlS");
        loginButton.getActionMap().put("ctrlS", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                cleanTextFields();
                appController.handleSigningUp();
            }
        });
        signingButton.setToolTipText("Create new Customer account.");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /**
     * Validates user login credentials and triggers the login process.
     *
     * @param e The ActionEvent representing the login button click.
     */
    private void validateLogin(ActionEvent e) {
        ArrayList<String> loginData = new ArrayList<>();
        loginData.add(loginTextField.getText());
        loginData.add(new String(passwordTextField.getPassword()));
        appController.handleLogin(loginData);
    }
    
    /**
     * Switches to the sign-up interface when the "Sign Up" button is clicked.
     *
     * @param e The ActionEvent representing the sign-up button click.
     */
    private void validateSign(ActionEvent e) {
        setVisible(false);
        cleanTextFields();
        appController.handleSigningUp();
    }
    
    /**
     * Clears the text fields for login and password.
     */
    public void cleanTextFields() {
        loginTextField.setText("");
        passwordTextField.setText("");
    }
}

