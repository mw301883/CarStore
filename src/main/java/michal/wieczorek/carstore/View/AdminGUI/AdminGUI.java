/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View.AdminGUI;

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
import michal.wieczorek.carstore.View.ErrorGUI.ErrorGUI;

/**
 * Graphical User Interface (GUI) for the administrator of the application. Allows setting car class prices,
 * generating reports, displaying reports, and logging out.
 * @author Michał Wieczorek
 * @version 1.0
 */
public class AdminGUI extends JFrame{
    /**
    * The application controller responsible for managing application functionality.
    */
   private final AppController appController;

   /**
    * Label displaying information to set the price of particular car classes.
    */
   private final JLabel infoLabel = new JLabel("Set price of particular car classes :");

   /**
    * Label displaying the price of Car A.
    */
   private JLabel carAPriceLabel = new JLabel();

   /**
    * Label displaying the price of Car B.
    */
   private JLabel carBPriceLabel = new JLabel();

   /**
    * Label displaying the price of Car C.
    */
   private JLabel carCPriceLabel = new JLabel();

   /**
    * Text field for setting the price of Car A.
    */
   private final JTextField carAJTextField = new JTextField(5);

   /**
    * Text field for setting the price of Car B.
    */
   private final JTextField carBJTextField = new JTextField(5);

   /**
    * Text field for setting the price of Car C.
    */
   private final JTextField carCJTextField = new JTextField(5);

   /**
    * Button to set the price of Car A.
    */
   private final JButton carAButton = new JButton("SET PRICE");

   /**
    * Button to set the price of Car B.
    */
   private final JButton carBButton = new JButton("SET PRICE");

   /**
    * Button to set the price of Car C.
    */
   private final JButton carCButton = new JButton("SET PRICE");

   /**
    * Button to generate a report.
    */
   private final JButton generateRaportButton = new JButton("GENERATE RAPORT");

   /**
    * Button to display reports.
    */
   private final JButton displayRaportsButton = new JButton("DISPLAY RAPORTS");

   /**
    * Button to log out from the application.
    */
   private final JButton logoutButton = new JButton("LOGOUT");

    
    /**
     * Constructs an AdminGUI with the specified AppController to handle interactions with the application.
     *
     * @param appController The application controller.
     */
    public AdminGUI(AppController appController){
        this.appController = appController;
        
        carAPriceLabel = new JLabel("A-class Cars price : " + CarA.getPrice());
        carBPriceLabel = new JLabel("B-class Cars price : " + CarB.getPrice());
        carCPriceLabel = new JLabel("C-class Cars price : " + CarC.getPrice());
        
        JPanel InfoPanel = new JPanel();
        InfoPanel.add(infoLabel);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3));
        mainPanel.add(carAPriceLabel);
        mainPanel.add(carAJTextField);
        mainPanel.add(carAButton);
        
        mainPanel.add(carBPriceLabel);
        mainPanel.add(carBJTextField);
        mainPanel.add(carBButton);
        
        mainPanel.add(carCPriceLabel);
        mainPanel.add(carCJTextField);
        mainPanel.add(carCButton);
        
        mainPanel.setBorder(new EmptyBorder(50, 10, 50, 10));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(generateRaportButton);
        buttonPanel.add(displayRaportsButton);
        buttonPanel.add(logoutButton);
        
        this.setSize(500, 300);
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(mainPanel, BorderLayout.CENTER);
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
    
    /**
    * Handles setting the price of Car A when the "SET PRICE" button for Car A is clicked.
    * 
    * @param e The ActionEvent triggered by the button click.
    */
    private void handleCarAButton(ActionEvent e){
        double newPrice = Double.parseDouble(carAJTextField.getText());
        appController.setCarAPrice(newPrice);
        carAPriceLabel.setText("A-class Cars price : " + Double.toString(newPrice));
        ErrorGUI Message = new ErrorGUI("New A-class Car price is set.");
        cleanTextFields();
        repaint();
    }
    
    /**
    * Handles setting the price of Car B when the "SET PRICE" button for Car B is clicked.
    * 
    * @param e The ActionEvent triggered by the button click.
    */
    private void handleCarBButton(ActionEvent e){
        double newPrice = Double.parseDouble(carBJTextField.getText());
        appController.setCarAPrice(newPrice);
        carBPriceLabel.setText("B-class Cars price : " + Double.toString(newPrice));
        ErrorGUI Message = new ErrorGUI("New B-class Car price is set.");
        cleanTextFields();
        repaint();
    }
    
    /**
    * Handles setting the price of Car C when the "SET PRICE" button for Car C is clicked.
    * 
    * @param e The ActionEvent triggered by the button click.
    */
    private void handleCarCButton(ActionEvent e){
        double newPrice = Double.parseDouble(carCJTextField.getText());
        appController.setCarAPrice(newPrice);
        carCPriceLabel.setText("C-class Cars price : " + Double.toString(newPrice));
        ErrorGUI Message = new ErrorGUI("New C-class Car price is set.");
        cleanTextFields();
        repaint();
    }
    /**
    * Handles generating a report when the "GENERATE RAPORT" button is clicked.
    * 
    * @param e The ActionEvent triggered by the button click.
    */
    private void handleGenerateRaport(ActionEvent e){
        this.appController.generateRaport();
    }
    
    /**
    * Handles displaying reports when the "DISPLAY RAPORTS" button is clicked.
    * 
    * @param e The ActionEvent triggered by the button click.
    */
    private void handleDisplayRaports(ActionEvent e){
        this.appController.displayReports();
    }
    
    /**
    * Handles logging out and restoring the login page when the "LOGOUT" button is clicked.
    * 
    * @param e The ActionEvent triggered by the button click.
    */
    private void handleLogoutButton(ActionEvent e){
        cleanTextFields();
        this.setVisible(false);
        appController.restoreLoginPage();
        
    }
    /**
    * Clears the text fields used for setting car prices.
    */
    private void cleanTextFields(){
        carAJTextField.setText("");
        carBJTextField.setText("");
        carCJTextField.setText("");
    }
}
