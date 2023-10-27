/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View.ErrorGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashSet;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import michal.wieczorek.carstore.Controller.AppController;
import michal.wieczorek.carstore.Model.Car.CarA;
import michal.wieczorek.carstore.Model.Raport.Raport;
import michal.wieczorek.carstore.Model.User.User;
import michal.wieczorek.carstore.Model.User.UserEnum;

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
    
    public void DetailsRaportDisplay(Raport raport, AppController appController){
        JLabel customerCountInfo = new JLabel("Customer count : " + Integer.toString(raport.getCustomerCount()));
        
        DefaultTableModel modelCustomerTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Dostosuj, które komórki są edytowalne
                return column == 6 || column == 7 || column == 8; // Cars A, B, C kolumny
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
        modelCustomerTable.addColumn("Cars A");
        modelCustomerTable.addColumn("Cars B");
        modelCustomerTable.addColumn("Cars C");
        modelCustomerTable.addColumn("Payment");
        ///////////////////////
        DefaultComboBoxModel<String> carComboBoxModel = new DefaultComboBoxModel<>();

        // Tworzenie TableCellEditora z JComboBox
        JComboBox<String> carComboBox = new JComboBox<>(carComboBoxModel);
        DefaultCellEditor carComboBoxEditor = new DefaultCellEditor(carComboBox);

        // Dodawanie TableCellEditora do odpowiednich kolumn
        TableColumn carAColumn = customerTable.getColumnModel().getColumn(6); // Szósta kolumna to "Cars A"
        carAColumn.setCellEditor(carComboBoxEditor);

        TableColumn carBColumn = customerTable.getColumnModel().getColumn(7); // Siódma kolumna to "Cars B"
        carBColumn.setCellEditor(carComboBoxEditor);

        TableColumn carCColumn = customerTable.getColumnModel().getColumn(8); // Ósma kolumna to "Cars C"
        carCColumn.setCellEditor(carComboBoxEditor);
        ///////////////////////////////////////
        
        for(User user : raport.getCustomerList()){
            String reservedCarsA = returnCarListA(user.getReservedCarsA(), appController);
            String reservedCarsB = returnCarListB(user.getReservedCarsB(), appController);
            String reservedCarsC = returnCarListC(user.getReservedCarsC(), appController);
            
            carComboBoxModel.addElement("cos");
            carComboBoxModel.addElement("cos");
            carComboBoxModel.addElement("cos");
            modelCustomerTable.addRow(new Object[]{user.getUserName(), user.getUserSurname(), user.getUserAddress(),
                user.getUserEmail(), user.getUserLogin(),defineUserType(user.getUserType()) , user.getReservedCarsA(), user.getReservedCarsB(), 
                user.getReservedCarsC(), user.getPayment()});
        }
        
        JScrollPane tablePane = new JScrollPane(customerTable);
        
        JLabel dateInfo = new JLabel("Date : " + raport.getDate());
        JLabel totalPaymentInfo = new JLabel("Total payment : " + Double.toString(raport.getTotalPrice()));
        
        JPanel panelUp = new JPanel(new BorderLayout());
        panelUp.add(customerCountInfo, BorderLayout.NORTH);
        panelUp.add(dateInfo, BorderLayout.CENTER);
        panelUp.add(totalPaymentInfo, BorderLayout.SOUTH);
        JPanel panelTable = new JPanel(new BorderLayout());
        panelTable.add(tablePane);
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.add(okButton);
        this.setLayout(new BorderLayout());
        this.add(ButtonPanel, BorderLayout.SOUTH);
        this.add(panelTable, BorderLayout.CENTER);
        this.add(panelUp, BorderLayout.NORTH);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        okButton.addActionListener(e -> dispose());
    }
    
    private String defineUserType(UserEnum.UserType type){
        return type.equals(UserEnum.UserType.STANDARD) ? "STANDARD" : "PREMIUM";
    }
    
    private String returnCarListA(HashSet<Integer> indexList, AppController appController){
        String CarString = "";
        int index = 0;
        for(int idx : indexList){
            if(index == idx){
                CarString += appController.getCarsA().get(index);
            }
            ++index;
        }
        return  CarString;
    }
    
    private String returnCarListB(HashSet<Integer> indexList, AppController appController){
        String CarString = "";
        int index = 0;
        for(int idx : indexList){
            if(index == idx){
                CarString += appController.getCarsB().get(index);
            }
            ++index;
        }
        return  CarString;
    }
    
    private String returnCarListC(HashSet<Integer> indexList, AppController appController){
        String CarString = "";
        int index = 0;
        for(int idx : indexList){
            if(index == idx){
                CarString += appController.getCarsC().get(index);
            }
            ++index;
        }
        return  CarString;
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
