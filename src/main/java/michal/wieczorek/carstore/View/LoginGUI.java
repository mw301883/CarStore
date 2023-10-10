/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Michał
 */
public class LoginGUI extends JFrame{
    private JLabel LoginLabel = new JLabel("Login:");
    private JLabel PasswordLabel = new JLabel("Password:");
    private JTextField LoginTextField = new JTextField(10);
    private JPasswordField PasswordTextField = new JPasswordField(10);
    private JButton LoginButton = new JButton("SIGN IN");
    private JButton SigningButton = new JButton("SIGN UP");

    public LoginGUI(){
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(2, 2));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 150);
        
        Panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        Panel.add(LoginLabel);
        Panel.add(LoginTextField);
        Panel.add(PasswordLabel);
        Panel.add(PasswordTextField);
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonPanel.add(LoginButton);
        ButtonPanel.add(SigningButton);
        
        this.setLayout(new BorderLayout());
        this.add(ButtonPanel, BorderLayout.SOUTH);
        this.add(Panel, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
    }
}