/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View.ErrorGUI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import michal.wieczorek.carstore.Model.Raport.Raport;

/**
 *
 * @author Michał
 */
public class ErrorGUI extends JFrame{
    private JLabel errorInfo = new JLabel("Bad Credentials, try again.");
    private JButton okButton = new JButton("OK");

    public ErrorGUI(){
        this.setSize(200, 125);
    }
    
    public ErrorGUI(String Message){
        errorInfo.setText(Message);
        this.setSize(200, 125);
    }
    
    public void setWindowSize(int width, int height){
        this.setSize(width, height);
    }
    
    public void DetailsRaportDisplay(Raport raport){
        JLabel customerCountInfo = new JLabel("Customer count : " + Integer.toString(raport.getCustomerCount()));
        
        DefaultTableModel modelCustomerTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable customerTable = new JTable(modelCustomerTable);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        customerTable.setDefaultRenderer(Object.class, renderer);
        
        customerTable.setRowSelectionAllowed(true);
        customerTable.setColumnSelectionAllowed(true);
        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        customerTable.setFocusable(false);
        
        modelCustomerTable.addColumn("Name");
        modelCustomerTable.addColumn("Surname");
        modelCustomerTable.addColumn("Address");
        modelCustomerTable.addColumn("Email");
        modelCustomerTable.addColumn("Login");
        modelCustomerTable.addColumn("User Type");
        
        JLabel DateInfo = new JLabel("Date : " + raport.getDate());
        JLabel TotalPaymentInfo = new JLabel("Total payment : " + Double.toString(raport.getTotalPrice()));
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
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        okButton.addActionListener(e -> dispose());
    }
}
