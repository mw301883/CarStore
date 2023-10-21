/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import michal.wieczorek.carstore.Controller.AppController;
import michal.wieczorek.carstore.Model.Car.CarA;
import michal.wieczorek.carstore.Model.Car.CarB;
import michal.wieczorek.carstore.Model.Car.CarC;

/**
 *
 * @author Michał
 */
public class AdminGUI extends JFrame{
    private final AppController appController;
    private final JLabel infoLabel = new JLabel("Set price of particular car classes :");
    private JLabel carAPriceLabel = new JLabel();
    private JLabel carBPriceLabel = new JLabel();
    private JLabel carCPriceLabel = new JLabel();
    
    private final JTextField carAJTextField = new JTextField(5);
    private final JTextField carBJTextField = new JTextField(5);
    private final JTextField carCJTextField = new JTextField(5);
    
    private final JButton carAButton = new JButton("SET PRICE");
    private final JButton carBButton = new JButton("SET PRICE");
    private final JButton carCButton = new JButton("SET PRICE");
    private final JButton generateRaportButton = new JButton("GENERATE RAPORT");
    private final JButton displayRaportsButton = new JButton("DISPLAY RAPORTS");
    private final JButton logoutButton = new JButton("LOGOUT");
    
    public AdminGUI(AppController appController){
        this.appController = appController;
        
        carAPriceLabel = new JLabel("A-class Cars price : " + CarA.getPrice());
        carBPriceLabel = new JLabel("B-class Cars price : " + CarB.getPrice());
        carCPriceLabel = new JLabel("C-class Cars price : " + CarC.getPrice());
        
        JPanel InfoPanel = new JPanel();
        InfoPanel.add(infoLabel);
        
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(3, 3));
        Panel.add(carAPriceLabel);
        Panel.add(carAJTextField);
        Panel.add(carAButton);
        
        Panel.add(carBPriceLabel);
        Panel.add(carBJTextField);
        Panel.add(carBButton);
        
        Panel.add(carCPriceLabel);
        Panel.add(carCJTextField);
        Panel.add(carCButton);
        
        Panel.setBorder(new EmptyBorder(50, 10, 50, 10));
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonPanel.add(generateRaportButton);
        ButtonPanel.add(displayRaportsButton);
        ButtonPanel.add(logoutButton);
        
        this.setSize(500, 300);
        this.setLayout(new BorderLayout());
        this.add(ButtonPanel, BorderLayout.SOUTH);
        this.add(Panel, BorderLayout.CENTER);
        this.add(InfoPanel, BorderLayout.NORTH);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        carAButton.addActionListener(this::handleCarAButton);
        carBButton.addActionListener(this::handleCarBButton);
        carCButton.addActionListener(this::handleCarCButton);
        generateRaportButton.addActionListener(this::handleGenerateRaport);
        displayRaportsButton.addActionListener(this::handleDisplayRaports);
        logoutButton.addActionListener(this::handleLogoutButton);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    private void handleCarAButton(ActionEvent e){
        double newPrice = Double.parseDouble(carAJTextField.getText());
        appController.setCarAPrice(newPrice);
        carAPriceLabel.setText("A-class Cars price : " + Double.toString(newPrice));
        ErrorGUI Message = new ErrorGUI("New A-class Car price is set.");
        cleanTextFields();
        repaint();
    }
    
    private void handleCarBButton(ActionEvent e){
        double newPrice = Double.parseDouble(carBJTextField.getText());
        appController.setCarAPrice(newPrice);
        carBPriceLabel.setText("B-class Cars price : " + Double.toString(newPrice));
        ErrorGUI Message = new ErrorGUI("New B-class Car price is set.");
        cleanTextFields();
        repaint();
    }
    
    private void handleCarCButton(ActionEvent e){
        double newPrice = Double.parseDouble(carCJTextField.getText());
        appController.setCarAPrice(newPrice);
        carCPriceLabel.setText("C-class Cars price : " + Double.toString(newPrice));
        ErrorGUI Message = new ErrorGUI("New C-class Car price is set.");
        cleanTextFields();
        repaint();
    }
    
    private void handleGenerateRaport(ActionEvent e){
        
    }
    
    private void handleDisplayRaports(ActionEvent e){
        
    }
    
    private void handleLogoutButton(ActionEvent e){
        cleanTextFields();
        this.setVisible(false);
        appController.restoreLoginPage();
        
    }
    
    private void cleanTextFields(){
        carAJTextField.setText("");
        carBJTextField.setText("");
        carCJTextField.setText("");
    }
}
