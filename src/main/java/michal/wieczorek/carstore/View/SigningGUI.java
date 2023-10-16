/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View;

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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import michal.wieczorek.carstore.Controller.AppController;

/**
 *
 * @author Michał
 */
public class SigningGUI extends JFrame{
    private AppController appController;
    
    private JLabel InfoLabel = new JLabel("Please fill the form in order to create new account:");
    private JLabel NameLabel = new JLabel("Name:");
    private JLabel SurnameLabel = new JLabel("Surname:");
    private JLabel AddressLabel = new JLabel("Address:");
    private JLabel EmailLabel = new JLabel("E-mail:");
    private JLabel LoginLabel = new JLabel("Login:");
    private JLabel PasswordLabel = new JLabel("Password:");
    private JLabel PasswordLabelRepeat = new JLabel("Repeat Password:");
    
    private JTextField NameTextField = new JTextField(10);
    private JTextField SurnameTextField = new JTextField(10);
    private JTextField AddressTextField = new JTextField(20);
    private JTextField LoginTextField = new JTextField(10);
    private JTextField EmailTextField = new JTextField(10);
    private JPasswordField PasswordTextField = new JPasswordField(10);
    private JPasswordField PasswordTextFieldRepeat = new JPasswordField(10);
    
    private JCheckBox UserCheckbox = new JCheckBox("User");
    private JCheckBox PremiumUserCheckbox = new JCheckBox("Premium User");
    
    private JButton CreateButton = new JButton("CREATE");
    private ButtonGroup ButtonGroup = new ButtonGroup();

    public SigningGUI(AppController appController){
        this.appController = appController;
        
        JPanel InfoPanel = new JPanel();
        InfoPanel.add(InfoLabel);
        
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(9, 2));
        this.setSize(400, 300);
        
        Panel.setBorder(new EmptyBorder(10, 30, 10, 30));
        Panel.add(NameLabel);
        Panel.add(NameTextField);
        Panel.add(SurnameLabel);
        Panel.add(SurnameTextField);
        Panel.add(AddressLabel);
        Panel.add(AddressTextField);
        Panel.add(EmailLabel);
        Panel.add(EmailTextField);
        Panel.add(LoginLabel);
        Panel.add(LoginTextField);
        Panel.add(PasswordLabel);
        Panel.add(PasswordTextField);
        Panel.add(PasswordLabelRepeat);
        Panel.add(PasswordTextFieldRepeat);
        Panel.add(UserCheckbox);
        Panel.add(PremiumUserCheckbox);
        
        ButtonGroup.add(UserCheckbox);
        ButtonGroup.add(PremiumUserCheckbox);
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonPanel.add(CreateButton);
        
        CreateButton.addActionListener(this::handleCreateButtonClick);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                appController.restoreLoginPage();
                cleanTextFields();
            }
        });
        
        this.setLayout(new BorderLayout());
        this.add(ButtonPanel, BorderLayout.SOUTH);
        this.add(Panel, BorderLayout.CENTER);
        this.add(InfoPanel, BorderLayout.NORTH);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    private void handleCreateButtonClick(ActionEvent e) {
            String name = NameTextField.getText();
            String surname = SurnameTextField.getText();
            String address = AddressTextField.getText();
            String email = EmailTextField.getText();
            String login = LoginTextField.getText();
            String password = PasswordTextField.getText();
            String passwordRepeat = PasswordTextFieldRepeat.getText();
            boolean isUser = UserCheckbox.isSelected();
            boolean isPremiumUser = PremiumUserCheckbox.isSelected();
            
            if(validateForm(name, surname, address, login,
                    password, isUser, isPremiumUser)){
               if(password.equals(passwordRepeat)){
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
                }
               else{
                   ErrorGUI ErrorMessage = new ErrorGUI("Different passwords, try again.");
               }
            }
            else{
                ErrorGUI ErrorMessage = new ErrorGUI();
            }
    }
    
    private boolean validateForm(String Name, String Surname, String Address, 
            String Login, String Password, boolean isUser, boolean isPremiumUser){
        if(!Name.isBlank() && !Surname.isBlank() && !Address.isBlank() && !Login.isBlank() && !Password.isBlank()){
                if(isUser || isPremiumUser){
                    return true;
                }
            }
        return false;
    }
    
    private void cleanTextFields(){
        NameTextField.setText("");
        SurnameTextField.setText("");
        AddressTextField.setText("");
        EmailTextField.setText("");
        LoginTextField.setText("");
        PasswordTextField.setText("");
        PasswordTextFieldRepeat.setText("");
        ButtonGroup.clearSelection();
    }
}
