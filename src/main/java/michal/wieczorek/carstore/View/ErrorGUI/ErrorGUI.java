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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import michal.wieczorek.carstore.Controller.AppController;
import michal.wieczorek.carstore.Model.Raport.Raport;
import michal.wieczorek.carstore.Model.User.User;
import michal.wieczorek.carstore.Model.User.UserEnum;

/**
 * Represents a graphical user interface (GUI) for displaying error messages in the application.
 * @author Michał Wieczorek
 * @version 1.0
*/
public class ErrorGUI extends JFrame{
    /**
    * A label for displaying an error message to the user.
    */
   private JLabel errorInfo = new JLabel("Bad Credentials, try again.");

   /**
    * A button used to acknowledge and close the error message dialog.
    */
   private JButton okButton = new JButton("OK");

    
    /**
     * Initializes a default error GUI with a fixed size.
     */
    public ErrorGUI(){
        this.setSize(200, 125);
    }
    
    /**
     * Initializes an error GUI with a custom error message and a fixed size.
     *
     * @param Message The custom error message to be displayed.
     */
    public ErrorGUI(String Message){
        errorInfo.setText(Message);
        this.setSize(200, 125);
    }
    
    /**
     * Sets the size of the error GUI to custom dimensions.
     *
     * @param width  The width of the GUI.
     * @param height The height of the GUI.
     */
    public void setWindowSize(int width, int height){
        this.setSize(width, height);
    }
    
    /**
     * Displays detailed information from a report, including customer details and reservations.
     *
     * @param raport        The report to be displayed.
     * @param appController The application controller for handling user interactions.
     */
    public void DetailsRaportDisplay(Raport raport, AppController appController){
        JLabel customerCountInfo = new JLabel("Customer count : " + Integer.toString(raport.getCustomerCount()));
        
        DefaultTableModel modelCustomerTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6 || column == 7 || column == 8;
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
        
        for(User user : raport.getCustomerList()){
            modelCustomerTable.addRow(new Object[]{user.getUserName(), user.getUserSurname(), user.getUserAddress(),
                user.getUserEmail(), user.getUserLogin(),defineUserType(user.getUserType()) , user.getReservedCarsA().size(), user.getReservedCarsB().size(), 
                user.getReservedCarsC().size(), user.getPayment()});
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
    
    /**
     * Defines the user type based on the given UserEnum.
     *
     * @param type The user type.
     * @return A string representing the user type ("STANDARD" or "PREMIUM").
     */
    private String defineUserType(UserEnum.UserType type){
        return type.equals(UserEnum.UserType.STANDARD) ? "STANDARD" : "PREMIUM";
    }
    
//Prototype    
//    private String returnCarListA(HashSet<Integer> indexList, AppController appController){
//        String CarString = "";
//        int index = 0;
//        for(int idx : indexList){
//            if(index == idx){
//                CarString += appController.getCarsA().get(index).getMark() + " " + appController.getCarsA().get(index).getName();
//            }
//            ++index;
//        }
//        return  CarString;
//    }
//    
//    private String returnCarListB(HashSet<Integer> indexList, AppController appController){
//        String CarString = "";
//        int index = 0;
//        for(int idx : indexList){
//            if(index == idx){
//                CarString += appController.getCarsB().get(index).getMark() + " " + appController.getCarsB().get(index).getName() + " ";
//            }
//            ++index;
//        }
//        return  CarString;
//    }
//    
//    private String returnCarListC(HashSet<Integer> indexList, AppController appController){
//        String CarString = "";
//        int index = 0;
//        for(int idx : indexList){
//            if(index == idx){
//                CarString += appController.getCarsC().get(index).getMark() + " " + appController.getCarsC().get(index).getName() + " ";
//            }
//            ++index;
//        }
//        return  CarString;
//    }
    
    /**
     * Displays the error message in the GUI.
     */
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




//Prototype
//public void DetailsRaportDisplay(Raport raport, AppController appController){
//        JLabel customerCountInfo = new JLabel("Customer count : " + Integer.toString(raport.getCustomerCount()));
//        
//        DefaultTableModel modelCustomerTable = new DefaultTableModel() {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                // Dostosuj, które komórki są edytowalne
//                return column == 6 || column == 7 || column == 8; // Cars A, B, C kolumny
//            }
//        };
//        JTable customerTable = new JTable(modelCustomerTable);
//        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
//        renderer.setHorizontalAlignment(SwingConstants.CENTER);
//        customerTable.setDefaultRenderer(Object.class, renderer);
//        
//        customerTable.setRowSelectionAllowed(true);
//        customerTable.setColumnSelectionAllowed(true);
//        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        customerTable.setFocusable(false);
//        
//        modelCustomerTable.addColumn("Name");
//        modelCustomerTable.addColumn("Surname");
//        modelCustomerTable.addColumn("Address");
//        modelCustomerTable.addColumn("Email");
//        modelCustomerTable.addColumn("Login");
//        modelCustomerTable.addColumn("User Type");
//        modelCustomerTable.addColumn("Cars A");
//        modelCustomerTable.addColumn("Cars B");
//        modelCustomerTable.addColumn("Cars C");
//        modelCustomerTable.addColumn("Payment");
//        ///////////////////////
//        DefaultComboBoxModel<String> carComboBoxModelA = new DefaultComboBoxModel<>();
//        DefaultComboBoxModel<String> carComboBoxModelB = new DefaultComboBoxModel<>();
//        DefaultComboBoxModel<String> carComboBoxModelC = new DefaultComboBoxModel<>();
//
//        // Tworzenie TableCellEditora z JComboBox
//        JComboBox<String> carComboBoxA = new JComboBox<>(carComboBoxModelA);
//        JComboBox<String> carComboBoxB = new JComboBox<>(carComboBoxModelB);
//        JComboBox<String> carComboBoxC = new JComboBox<>(carComboBoxModelC);
//        DefaultCellEditor carComboBoxEditorA = new DefaultCellEditor(carComboBoxA);
//        DefaultCellEditor carComboBoxEditorB = new DefaultCellEditor(carComboBoxB);
//        DefaultCellEditor carComboBoxEditorC = new DefaultCellEditor(carComboBoxC);
//
//        // Dodawanie TableCellEditora do odpowiednich kolumn
//        TableColumn carAColumn = customerTable.getColumnModel().getColumn(6); // Szósta kolumna to "Cars A"
//        carAColumn.setCellEditor(carComboBoxEditorA);
//
//        TableColumn carBColumn = customerTable.getColumnModel().getColumn(7); // Siódma kolumna to "Cars B"
//        carBColumn.setCellEditor(carComboBoxEditorB);
//
//        TableColumn carCColumn = customerTable.getColumnModel().getColumn(8); // Ósma kolumna to "Cars C"
//        carCColumn.setCellEditor(carComboBoxEditorC);
//        ///////////////////////////////////////
//        
//        for(User user : raport.getCustomerList()){
//            String reservedCarsA = returnCarListA(user.getReservedCarsA(), appController);
//            String reservedCarsB = returnCarListB(user.getReservedCarsB(), appController);
//            String reservedCarsC = returnCarListC(user.getReservedCarsC(), appController);
//            
//            carComboBoxModelA.addElement(reservedCarsA);
//            carComboBoxModelB.addElement(reservedCarsB);
//            carComboBoxModelC.addElement(reservedCarsC);
//            modelCustomerTable.addRow(new Object[]{user.getUserName(), user.getUserSurname(), user.getUserAddress(),
//                user.getUserEmail(), user.getUserLogin(),defineUserType(user.getUserType()) , user.getReservedCarsA().size(), user.getReservedCarsB().size(), 
//                user.getReservedCarsC().size(), user.getPayment()});
//        }
//        
//        JScrollPane tablePane = new JScrollPane(customerTable);
//        
//        JLabel dateInfo = new JLabel("Date : " + raport.getDate());
//        JLabel totalPaymentInfo = new JLabel("Total payment : " + Double.toString(raport.getTotalPrice()));
//        
//        JPanel panelUp = new JPanel(new BorderLayout());
//        panelUp.add(customerCountInfo, BorderLayout.NORTH);
//        panelUp.add(dateInfo, BorderLayout.CENTER);
//        panelUp.add(totalPaymentInfo, BorderLayout.SOUTH);
//        JPanel panelTable = new JPanel(new BorderLayout());
//        panelTable.add(tablePane);
//        JPanel ButtonPanel = new JPanel();
//        ButtonPanel.add(okButton);
//        this.setLayout(new BorderLayout());
//        this.add(ButtonPanel, BorderLayout.SOUTH);
//        this.add(panelTable, BorderLayout.CENTER);
//        this.add(panelUp, BorderLayout.NORTH);
//        this.setResizable(false);
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
//        
//        okButton.addActionListener(e -> dispose());
//    }
