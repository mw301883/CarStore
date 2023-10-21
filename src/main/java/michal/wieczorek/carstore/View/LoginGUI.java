/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import michal.wieczorek.carstore.Controller.AppController;

/**
 *
 * @author Michał
 */
public class LoginGUI extends JFrame {
    private AppController appController;
    private JLabel loginLabel = new JLabel("Login:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JTextField loginTextField = new JTextField(10);
    private JPasswordField passwordTextField = new JPasswordField(10);
    private JButton loginButton = new JButton("SIGN IN");
    private JButton signingButton = new JButton("SIGN UP");

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
        signingButton.addActionListener(this::validateSign);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void validateLogin(ActionEvent e) {
        ArrayList<String> loginData = new ArrayList<>();
        loginData.add(loginTextField.getText());
        loginData.add(new String(passwordTextField.getPassword()));
        appController.handleLogin(loginData);
    }

    private void validateSign(ActionEvent e) {
        setVisible(false);
        cleanTextFields();
        appController.handleSigningUp();
    }

    public void cleanTextFields() {
        loginTextField.setText("");
        passwordTextField.setText("");
    }
}

