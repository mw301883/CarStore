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
    private JLabel ErrorInfo = new JLabel("Bad Credentials, try again.");
    private JButton OKButton = new JButton("OK");

    public ErrorGUI(){
        JPanel Panel = new JPanel();
        Panel.add(ErrorInfo);
        Panel.setBorder(new EmptyBorder(10, 30, 10, 30));
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.add(OKButton);
        this.setLayout(new BorderLayout());
        this.add(ButtonPanel, BorderLayout.SOUTH);
        this.add(Panel, BorderLayout.CENTER);
        this.setSize(200, 125);
        this.setResizable(false);
        this.setVisible(true);
        
        OKButton.addActionListener(e -> dispose());
    }
    
    public ErrorGUI(String Message){
        ErrorInfo.setText(Message);
        JPanel Panel = new JPanel();
        Panel.add(ErrorInfo);
        Panel.setBorder(new EmptyBorder(10, 30, 10, 30));
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.add(OKButton);
        
        this.setLayout(new BorderLayout());
        this.add(ButtonPanel, BorderLayout.SOUTH);
        this.add(Panel, BorderLayout.CENTER);
        this.setSize(200, 125);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        OKButton.addActionListener(e -> dispose());
    }
}
