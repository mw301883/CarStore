/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Michał
 */
public class ErrorGUI extends JFrame{
    private JLabel errorInfo = new JLabel("Bad Credentials, try again.");
    private JButton okButton = new JButton("OK");

    public ErrorGUI(){
    }
    
    public ErrorGUI(String Message){
        errorInfo.setText(Message);
    }
    
    public void display(){
        JPanel Panel = new JPanel();
        Panel.add(errorInfo);
        Panel.setBorder(new EmptyBorder(10, 30, 10, 30));
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.add(okButton);
        this.setLayout(new BorderLayout());
        this.add(ButtonPanel, BorderLayout.SOUTH);
        this.add(Panel, BorderLayout.CENTER);
        this.setSize(200, 125);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        okButton.addActionListener(e -> dispose());
    }
}
