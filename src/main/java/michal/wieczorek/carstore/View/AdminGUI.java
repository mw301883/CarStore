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
    private AppController appController;
    private JLabel InfoLabel = new JLabel("Set price of particular car classes :");
    private JLabel CarAPriceLabel = new JLabel();
    private JLabel CarBPriceLabel = new JLabel();
    private JLabel CarCPriceLabel = new JLabel();
    
    private JTextField CarAJTextField = new JTextField(5);
    private JTextField CarBJTextField = new JTextField(5);
    private JTextField CarCJTextField = new JTextField(5);
    
    private JButton CarAButton = new JButton("SET PRICE");
    private JButton CarBButton = new JButton("SET PRICE");
    private JButton CarCButton = new JButton("SET PRICE");
    private JButton GenerateRaportButton = new JButton("GENERATE RAPORT");
    private JButton DisplayRaportsButton = new JButton("DISPLAY RAPORTS");
    private JButton LogoutButton = new JButton("LOGOUT");
    
    public AdminGUI(AppController appController){
        this.appController = appController;
        
        CarAPriceLabel = new JLabel("A-class Cars price : " + CarA.getPrice());
        CarBPriceLabel = new JLabel("B-class Cars price : " + CarB.getPrice());
        CarCPriceLabel = new JLabel("C-class Cars price : " + CarC.getPrice());
        
        JPanel InfoPanel = new JPanel();
        InfoPanel.add(InfoLabel);
        
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(3, 3));
        Panel.add(CarAPriceLabel);
        Panel.add(CarAJTextField);
        Panel.add(CarAButton);
        
        Panel.add(CarBPriceLabel);
        Panel.add(CarBJTextField);
        Panel.add(CarBButton);
        
        Panel.add(CarCPriceLabel);
        Panel.add(CarCJTextField);
        Panel.add(CarCButton);
        
        Panel.setBorder(new EmptyBorder(50, 10, 50, 10));
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonPanel.add(GenerateRaportButton);
        ButtonPanel.add(DisplayRaportsButton);
        ButtonPanel.add(LogoutButton);
        
        this.setSize(500, 300);
        this.setLayout(new BorderLayout());
        this.add(ButtonPanel, BorderLayout.SOUTH);
        this.add(Panel, BorderLayout.CENTER);
        this.add(InfoPanel, BorderLayout.NORTH);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        CarAButton.addActionListener(this::handleCarAButton);
        CarBButton.addActionListener(this::handleCarBButton);
        CarCButton.addActionListener(this::handleCarCButton);
        GenerateRaportButton.addActionListener(this::handleGenerateRaport);
        DisplayRaportsButton.addActionListener(this::handleDisplayRaports);
        LogoutButton.addActionListener(this::handleLogoutButton);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    private void handleCarAButton(ActionEvent e){
        double newPrice = Double.parseDouble(CarAJTextField.getText());
        appController.setCarAPrice(newPrice);
        CarAPriceLabel.setText("A-class Cars price : " + Double.toString(newPrice));
        ErrorGUI Message = new ErrorGUI("New A-class Car price is set.");
        cleanTextFields();
        repaint();
    }
    
    private void handleCarBButton(ActionEvent e){
        double newPrice = Double.parseDouble(CarBJTextField.getText());
        appController.setCarAPrice(newPrice);
        CarBPriceLabel.setText("B-class Cars price : " + Double.toString(newPrice));
        ErrorGUI Message = new ErrorGUI("New B-class Car price is set.");
        cleanTextFields();
        repaint();
    }
    
    private void handleCarCButton(ActionEvent e){
        double newPrice = Double.parseDouble(CarCJTextField.getText());
        appController.setCarAPrice(newPrice);
        CarCPriceLabel.setText("C-class Cars price : " + Double.toString(newPrice));
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
        CarAJTextField.setText("");
        CarBJTextField.setText("");
        CarCJTextField.setText("");
    }
}
