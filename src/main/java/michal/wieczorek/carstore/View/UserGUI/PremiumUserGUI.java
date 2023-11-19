/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View.UserGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import michal.wieczorek.carstore.Controller.AppController;
import michal.wieczorek.carstore.Model.Car.Car;
import michal.wieczorek.carstore.Model.Car.CarA;
import michal.wieczorek.carstore.Model.Car.CarB;
import michal.wieczorek.carstore.Model.Car.CarC;
import michal.wieczorek.carstore.View.ButtonColumn.ButtonColumn;

/**
 * A graphical user interface for premium users to reserve cars.
 * @author Michał Wieczorek
 * @version 1.0
 */
public class PremiumUserGUI extends JFrame{
    
    /**
    * The application controller responsible for managing user interactions.
    */
    private AppController appController;
    /**
     * Label indicating car reservation for A-class cars.
     */
    private JLabel infoLabelA = new JLabel("RESERVE CAR A-CLASS:");

    /**
     * Label indicating car reservation for B-class cars.
     */
    private JLabel infoLabelB = new JLabel("RESERVE CAR B-CLASS:");

    /**
     * Label indicating car reservation for C-class cars.
     */
    private JLabel infoLabelC = new JLabel("RESERVE CAR C-CLASS:");

    /**
     * Label displaying the current user's session information.
     */
    private JLabel sessionInfo = new JLabel("Logged as Premium User : ");

    /**
     * Label displaying the username of the current user.
     */
    private JLabel userInfo = new JLabel("");

    /**
     * Button for logging out from the premium user session.
     */
    private JButton logoutButton = new JButton("LOGOUT");

    /**
     * Scroll pane for displaying the table of available A-class cars.
     */
    private JScrollPane scrollPaneA;

    /**
     * Scroll pane for displaying the table of available B-class cars.
     */
    private JScrollPane scrollPaneB;

    /**
     * Scroll pane for displaying the table of available C-class cars.
     */
    private JScrollPane scrollPaneC;
    
    /**
     * Constructs a PremiumUserGUI with the specified AppController.
     *
     * @param appController The application controller for handling premium user interactions.
     */
    public PremiumUserGUI(AppController appController){
        this.appController = appController;
        
        JPanel infoPanelA = new JPanel();
        infoPanelA.add(infoLabelA);
        
        JPanel infoPanelB = new JPanel();
        infoPanelB.add(infoLabelB);
        
        JPanel infoPanelC = new JPanel();
        infoPanelC.add(infoLabelC);
        
        this.setSize(600, 600);
        
        this.scrollPaneA = fillCarsATable();
        
        this.scrollPaneB = fillCarsBTable();
        
        this.scrollPaneC = fillCarsCTable();  
        
        this.logoutButton.addActionListener(this::handleLogoutButtonClick);
        this.logoutButton.setToolTipText("Logout from the Store.");
        
        this.userInfo.setText(this.appController.getCurrentUser().getUserLogin());
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1));
        mainPanel.add(infoPanelA);
        mainPanel.add(scrollPaneA);
        mainPanel.add(infoPanelB);
        mainPanel.add(scrollPaneB);
        mainPanel.add(infoPanelC);
        mainPanel.add(scrollPaneC);
        
        JPanel downPanel = new JPanel();
        downPanel.setLayout(new GridLayout(1, 3));
        downPanel.setBorder(new EmptyBorder(20, 30, 10, 30));
        downPanel.add(this.sessionInfo);
        downPanel.add(this.userInfo);
        downPanel.add(this.logoutButton);
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(downPanel,BorderLayout.PAGE_END );
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    /**
     * Fills the table of available A-class cars.
     *
     * @return A JScrollPane containing the A-class cars table.
     */
    private JScrollPane fillCarsATable(){
        DefaultTableModel modelCarA = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 4 && validateCarAccess(appController.getCarsA().get(row), row,
                        appController.getCurrentUser().getReservedCarsA().isEmpty(), appController.getCurrentUser().getReservedCarsA())){
                    return true;
                }
                else{
                    return false;   
                }
            }
        };
        JTable carsATable = new JTable(modelCarA);
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        carsATable.setDefaultRenderer(Object.class, renderer);
        
        carsATable.setRowSelectionAllowed(true);
        carsATable.setColumnSelectionAllowed(true);
        carsATable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        carsATable.setFocusable(false);
        
        modelCarA.addColumn("Name");
        modelCarA.addColumn("Mark");
        modelCarA.addColumn("Avaiability");
        modelCarA.addColumn("Price");
        modelCarA.addColumn("");
        
        int table_row = 0;
        for(CarA car : this.appController.getCarsA()){
            Action buttonAction = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
                            JTable table = (JTable)e.getSource();
                            int modelRow = Integer.valueOf( e.getActionCommand());
                            if( "Rent".equals((String)table.getModel().getValueAt(modelRow, 4))){
                                table.getModel().setValueAt("Cancel", modelRow, 4);
                                table.getModel().setValueAt("Not Avaible", modelRow, 2);
                                appController.reserveCurrentUserCarA(modelRow);
                            }
                            else{
                                table.getModel().setValueAt("Rent", modelRow, 4);
                                table.getModel().setValueAt("Avaible", modelRow, 2);
                                appController.removeCurrentUserCarA(modelRow);
                            }
			}
		};
            modelCarA.addRow(new Object[]{car.getName(), car.getMark(), isAvaibleCar(car.getIsAvaible()), CarA.getPrice()*0.7,
                checkIfCellIsBlock(car.getIsAvaible(),
                        validateCarAccess(car, table_row, this.appController.getCarsA().isEmpty(),
                                this.appController.getCurrentUser().getReservedCarsA()), car.getIsAvaible())});
            
            ButtonColumn buttonColumn = new ButtonColumn(carsATable, buttonAction, 4);
            ++table_row;
        }  
        return new JScrollPane(carsATable);
    }
    
    /**
     * Fills the table of available B-class cars.
     *
     * @return A JScrollPane containing the B-class cars table.
     */
    private JScrollPane fillCarsBTable(){
        DefaultTableModel modelCarB = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 4 && validateCarAccess(appController.getCarsB().get(row), row, 
                        appController.getCurrentUser().getReservedCarsB().isEmpty(), appController.getCurrentUser().getReservedCarsB())){
                    return true;
                }
                else{
                    //this.setValueAt("", row, column); //TODO
                    return false;  
                } 
            }
        };
        JTable carsBTable = new JTable(modelCarB);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        carsBTable.setDefaultRenderer(Object.class, renderer);       
        carsBTable.setRowSelectionAllowed(true);
        carsBTable.setColumnSelectionAllowed(true);
        carsBTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        carsBTable.setFocusable(false);
        
        modelCarB.addColumn("Name");
        modelCarB.addColumn("Mark");
        modelCarB.addColumn("Avaiability");
        modelCarB.addColumn("Price");
        modelCarB.addColumn("");
        int table_row = 0;
        for(CarB car : this.appController.getCarsB()){
            Action buttonAction = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
                            JTable table = (JTable)e.getSource();
                            int modelRow = Integer.valueOf( e.getActionCommand() );
                            if( "Rent".equals((String)table.getModel().getValueAt(modelRow, 4))){
                                table.getModel().setValueAt("Cancel", modelRow, 4);
                                table.getModel().setValueAt("Not Avaible", modelRow, 2);
                                appController.reserveCurrentUserCarB(modelRow);
                            }
                            else{
                                table.getModel().setValueAt("Rent", modelRow, 4);
                                table.getModel().setValueAt("Avaible", modelRow, 2);
                                appController.removeCurrentUserCarB(modelRow);
                            }
			}
		};
             modelCarB.addRow(new Object[]{car.getName(), car.getMark(), isAvaibleCar(car.getIsAvaible()), CarB.getPrice()*0.7,
                checkIfCellIsBlock(car.getIsAvaible(),
                        validateCarAccess(car, table_row, this.appController.getCarsB().isEmpty(),
                                this.appController.getCurrentUser().getReservedCarsB()), car.getIsAvaible())});
             
            ButtonColumn buttonColumn = new ButtonColumn(carsBTable, buttonAction, 4);
            ++table_row;
        }      
        return new JScrollPane(carsBTable);
    }
    
    /**
     * Fills the table of available C-class cars.
     *
     * @return A JScrollPane containing the C-class cars table.
     */
    private JScrollPane fillCarsCTable(){
        DefaultTableModel modelCarC = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 4 && validateCarAccess(appController.getCarsC().get(row), row, 
                        appController.getCurrentUser().getReservedCarsC().isEmpty(), appController.getCurrentUser().getReservedCarsC())){
                    return true;
                }
                else{
                    return false;   
                }
            }
        };
        JTable carsCTable = new JTable(modelCarC);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        carsCTable.setDefaultRenderer(Object.class, renderer); 
        carsCTable.setRowSelectionAllowed(true);
        carsCTable.setColumnSelectionAllowed(true);
        carsCTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        carsCTable.setFocusable(false);
        
        modelCarC.addColumn("Name");
        modelCarC.addColumn("Mark");
        modelCarC.addColumn("Avaiability");
        modelCarC.addColumn("Price");
        modelCarC.addColumn("");
        int table_row = 0;
        for(CarC car : this.appController.getCarsC()){
            Action buttonAction = new AbstractAction()
		{
                    public void actionPerformed(ActionEvent e)
                    {
                        JTable table = (JTable)e.getSource();
                        int modelRow = Integer.valueOf( e.getActionCommand() );
                        if( "Rent".equals((String)table.getModel().getValueAt(modelRow, 4))){
                            table.getModel().setValueAt("Cancel", modelRow, 4);
                            table.getModel().setValueAt("Not Avaible", modelRow, 2);
                            appController.reserveCurrentUserCarC(modelRow);
                        }
                        else{
                            table.getModel().setValueAt("Rent", modelRow, 4);
                            table.getModel().setValueAt("Avaible", modelRow, 2);
                            appController.removeCurrentUserCarC(modelRow);
                        }
                    }
		};            
             modelCarC.addRow(new Object[]{car.getName(), car.getMark(), isAvaibleCar(car.getIsAvaible()), CarC.getPrice()*0.7,
                checkIfCellIsBlock(car.getIsAvaible(),
                        validateCarAccess(car, table_row, this.appController.getCarsC().isEmpty(),
                                this.appController.getCurrentUser().getReservedCarsC()), car.getIsAvaible())});
             
            ButtonColumn buttonColumn = new ButtonColumn(carsCTable, buttonAction, 4);
            ++table_row;
        } 
        return new JScrollPane(carsCTable);
    }
    
    /**
     * Handles the action of clicking the "LOGOUT" button.
     *
     * @param e The ActionEvent object representing the button click.
     */
    private void handleLogoutButtonClick(ActionEvent e){
        this.dispose();
        //this.setVisible(false);
        this.appController.restoreLoginPage();
    }
    
    /**
     * Converts car availability status to a displayable string ("Avaible" or "Not Avaible").
     *
     * @param isAvaible True if the car is available; false otherwise.
     * @return The displayable availability status.
     */
    private String isAvaibleCar(boolean isAvaible){
        return isAvaible ? "Avaible" : "Not Avaible";
    }
    
    /**
     * Validates car access for reserving a car.
     *
     * @param car                   The car to validate access for.
     * @param row                   The row index in the table.
     * @param isUserReservedListEmpty True if the user's reserved list is empty; false otherwise.
     * @param reservedCars           The set of reserved cars for the current user.
     * @return True if car access is allowed; false otherwise.
     */
    private boolean validateCarAccess(Car car, int row, boolean isUserReservedListEmpty, HashSet<Integer> reservedCars){
        if(!car.getIsAvaible()){
            if(isUserReservedListEmpty){
                return false;
            }
            for(int idx : reservedCars){
                if(idx == row){
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    /**
     * Checks if a cell should be blocked for editing based on various factors.
     *
     * @param isEditable        True if the cell should be editable; false otherwise.
     * @param accessValidation  True if car access validation allows editing; false otherwise.
     * @param isCarAvaible      True if the car is available; false otherwise.
     * @return "Cancel" if the cell should be blocked; "Rent" if it should be editable; empty string otherwise.
     */
    private String checkIfCellIsBlock(boolean isEditable, boolean accessValidation, boolean isCarAvaible){
       if(accessValidation && !isCarAvaible){
           return "Cancel";
       }
        return isEditable ? "Rent" : "";
    }
}
