/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View.MainGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import michal.wieczorek.carstore.Controller.AppController;
import michal.wieczorek.carstore.View.ErrorGUI.ErrorGUI;

/**
 *
 * @author Michał
 */
public class SigningGUI extends JFrame {
    /**
    * The application controller responsible for managing user interactions.
    */
    private AppController appController;
    
    /**
     * Label displaying registration information.
     */
    private JLabel infoLabel = new JLabel("Please fill the form in order to create a new account:");

    /**
     * Label for the user's name.
     */
    private JLabel nameLabel = new JLabel("Name:");

    /**
     * Label for the user's surname.
     */
    private JLabel surnameLabel = new JLabel("Surname:");

    /**
     * Label for the user's address.
     */
    private JLabel addressLabel = new JLabel("Address:");

    /**
     * Label for the user's email.
     */
    private JLabel emailLabel = new JLabel("E-mail:");

    /**
     * Label for the user's login.
     */
    private JLabel loginLabel = new JLabel("Login:");

    /**
     * Label for the user's password.
     */
    private JLabel passwordLabel = new JLabel("Password:");

    /**
     * Label for repeating the user's password.
     */
    private JLabel passwordLabelRepeat = new JLabel("Repeat Password:");

    /**
     * Text field for entering the user's name.
     */
    private JTextField nameTextField = new JTextField(10);

    /**
     * Text field for entering the user's surname.
     */
    private JTextField surnameTextField = new JTextField(10);

    /**
     * Text field for entering the user's address.
     */
    private JTextField addressTextField = new JTextField(20);

    /**
     * Text field for entering the user's email.
     */
    private JTextField emailTextField = new JTextField(10);

    /**
     * Text field for entering the user's login.
     */
    private JTextField loginTextField = new JTextField(10);

    /**
     * Password field for entering the user's password.
     */
    private JPasswordField passwordTextField = new JPasswordField(10);

    /**
     * Password field for entering the user's password (repeated).
     */
    private JPasswordField passwordTextFieldRepeat = new JPasswordField(10);

    /**
     * Checkbox for selecting regular user type.
     */
    private JCheckBox userCheckbox = new JCheckBox("User");

    /**
     * Checkbox for selecting premium user type.
     */
    private JCheckBox premiumUserCheckbox = new JCheckBox("Premium User");

    /**
     * Button for initiating user registration.
     */
    private JButton createButton = new JButton("CREATE");

    /**
     * Button group for managing user type checkboxes.
     */
    private ButtonGroup buttonGroup = new ButtonGroup();
    
    /**
     * Constructs a SigningGUI with the specified AppController.
     *
     * @param appController The application controller for handling registration.
     */
    public SigningGUI(AppController appController) {
        this.appController = appController;
        
        JPanel infoPanel = new JPanel();
        infoPanel.add(infoLabel);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));
        this.setSize(400, 300);
        
        panel.setBorder(new EmptyBorder(10, 30, 10, 30));
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(surnameLabel);
        panel.add(surnameTextField);
        panel.add(addressLabel);
        panel.add(addressTextField);
        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(loginLabel);
        panel.add(loginTextField);
        panel.add(passwordLabel);
        panel.add(passwordTextField);
        panel.add(passwordLabelRepeat);
        panel.add(passwordTextFieldRepeat);
        panel.add(userCheckbox);
        panel.add(premiumUserCheckbox);
        
        buttonGroup.add(userCheckbox);
        buttonGroup.add(premiumUserCheckbox);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(createButton);
        
        createButton.addActionListener(this::handleCreateButtonClick);
        createButton.setToolTipText("Create new Customer account.");
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                appController.restoreLoginPage();
                cleanTextFields();
            }
        });
        
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.NORTH);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    /**
     * Handles the action of clicking the "CREATE" button.
     *
     * @param e The ActionEvent object representing the button click.
     */
    private void handleCreateButtonClick(ActionEvent e) {
        String name = nameTextField.getText();
        String surname = surnameTextField.getText();
        String address = addressTextField.getText();
        String email = emailTextField.getText();
        String login = loginTextField.getText();
        String password = new String(passwordTextField.getPassword());
        String passwordRepeat = new String(passwordTextFieldRepeat.getPassword());
        boolean isUser = userCheckbox.isSelected();
        boolean isPremiumUser = premiumUserCheckbox.isSelected();
        
        if (validateForm(name, surname, address, login, password, isUser, isPremiumUser)) {
            if (password.equals(passwordRepeat)) {
                setVisible(false);
                ArrayList<String> userAttributes = new ArrayList<>();
                userAttributes.add(name);
                userAttributes.add(surname);
                userAttributes.add(address);
                userAttributes.add(email);
                userAttributes.add(login);
                userAttributes.add(password);
                appController.createNewUser(userAttributes, isUser);
                cleanTextFields();
            } else {
                ErrorGUI errorMessage = new ErrorGUI("Different passwords, try again.");
                errorMessage.display();
            }
        } else {
            ErrorGUI errorMessage = new ErrorGUI();
            errorMessage.display();
        }
    }
    
    /**
     * Validates the registration form fields and user type selection.
     *
     * @param name          The user's name.
     * @param surname       The user's surname.
     * @param address       The user's address.
     * @param login         The user's login.
     * @param password      The user's password.
     * @param isUser        True if the user type is regular; false otherwise.
     * @param isPremiumUser True if the user type is premium; false otherwise.
     * @return True if the form is valid; false otherwise.
     */
    private boolean validateForm(String name, String surname, String address, 
            String login, String password, boolean isUser, boolean isPremiumUser) {
        if (!name.isBlank() && !surname.isBlank() && !address.isBlank() && !login.isBlank() && !password.isBlank()) {
            if (isUser || isPremiumUser) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Clears text fields and resets user type selection.
     */
    private void cleanTextFields() {
        nameTextField.setText("");
        surnameTextField.setText("");
        addressTextField.setText("");
        emailTextField.setText("");
        loginTextField.setText("");
        passwordTextField.setText("");
        passwordTextFieldRepeat.setText("");
        buttonGroup.clearSelection();
    }
}

