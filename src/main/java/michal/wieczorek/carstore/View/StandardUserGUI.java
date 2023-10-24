/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View;

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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import michal.wieczorek.carstore.Controller.AppController;
import michal.wieczorek.carstore.Model.AppModel;
import michal.wieczorek.carstore.Model.Car.Car;
import michal.wieczorek.carstore.Model.Car.CarA;
import michal.wieczorek.carstore.Model.Car.CarB;
import michal.wieczorek.carstore.Model.Car.CarC;
import michal.wieczorek.carstore.View.ButtonColumn.ButtonColumn;

/**
 *
 * @author Michał
 */
public class StandardUserGUI extends JFrame{
    
    private final AppController appController;
    private final AppModel appModel;
    private final JLabel infoLabelA = new JLabel("RESERVE CAR A-CLASS:");
    private final JLabel infoLabelB = new JLabel("RESERVE CAR B-CLASS:");
    private final JLabel infoLabelC = new JLabel("RESERVE CAR C-CLASS:");
    private final JLabel sessionInfo = new JLabel("Logged as Standard User : ");
    private final JLabel userInfo = new JLabel("");
    private final JButton logoutButton = new JButton("LOGOUT");
    //private boolean isPremium = false;
    
    private JScrollPane scrollPaneA;  
    private JScrollPane scrollPaneB;      
    private JScrollPane scrollPaneC;
    
    //private double priceRate = 1.0;

    public StandardUserGUI(AppController appController, AppModel appModel){
        this.appController = appController;
        this.appModel = appModel;
        
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
    }
    
    private JScrollPane fillCarsATable(){
        DefaultTableModel modelCarA = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 4 && validateCarAccess(appModel.getCarsA().get(row), row,
                        appModel.getCurrentUser().getReservedCarsA().isEmpty(), appModel.getCurrentUser().getReservedCarsA())){
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
        
        for(CarA car : this.appModel.getCarsA()){
            Action buttonAction = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
                            JTable table = (JTable)e.getSource();
                            int modelRow = Integer.valueOf( e.getActionCommand());
                            if( "Rent".equals((String)table.getModel().getValueAt(modelRow, 4))){
                                table.getModel().setValueAt("Cancel", modelRow, 4);
                                table.getModel().setValueAt("Not Avaible", modelRow, 2);
                                appModel.getCurrentUser().addCarAtoOrder(modelRow);
                                appModel.reserveCarA(modelRow);
                            }
                            else{
                                table.getModel().setValueAt("Rent", modelRow, 4);
                                table.getModel().setValueAt("Avaible", modelRow, 2);
                                appModel.getCurrentUser().removeCarAfromOrder(modelRow);
                                appModel.returnCarA(modelRow);
                            }
			}
		};
            modelCarA.addRow(new Object[]{car.getName(), car.getMark(), isAvaibleCar(car.getIsAvaible()), CarA.getPrice(), "Rent"});
            ButtonColumn buttonColumn = new ButtonColumn(carsATable, buttonAction, 4);
        }  
        return new JScrollPane(carsATable);
    }
    
    private JScrollPane fillCarsBTable(){
        DefaultTableModel modelCarB = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 4 && validateCarAccess(appModel.getCarsB().get(row), row, 
                        appModel.getCurrentUser().getReservedCarsB().isEmpty(), appModel.getCurrentUser().getReservedCarsB())){
                    return true;
                }
                else{
                    this.setValueAt("", row, column); //TODO
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
        
        for(CarB car : this.appModel.getCarsB()){
            Action buttonAction = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
                            JTable table = (JTable)e.getSource();
                            int modelRow = Integer.valueOf( e.getActionCommand() );
                            if( "Rent".equals((String)table.getModel().getValueAt(modelRow, 4))){
                                table.getModel().setValueAt("Cancel", modelRow, 4);
                                table.getModel().setValueAt("Not Avaible", modelRow, 2);
                                appModel.getCurrentUser().addCarBtoOrder(modelRow);
                                appModel.reserveCarB(modelRow);
                            }
                            else{
                                table.getModel().setValueAt("Rent", modelRow, 4);
                                table.getModel().setValueAt("Avaible", modelRow, 2);
                                appModel.getCurrentUser().removeCarBfromOrder(modelRow);
                                appModel.returnCarB(modelRow);
                            }
			}
		};
            modelCarB.addRow(new Object[]{car.getName(), car.getMark(), isAvaibleCar(car.getIsAvaible()), CarB.getPrice(), "Rent"});
            ButtonColumn buttonColumn = new ButtonColumn(carsBTable, buttonAction, 4);
        }      
        return new JScrollPane(carsBTable);
    }
    
    private JScrollPane fillCarsCTable(){
        DefaultTableModel modelCarC = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 4 && validateCarAccess(appModel.getCarsC().get(row), row, 
                        appModel.getCurrentUser().getReservedCarsC().isEmpty(), appModel.getCurrentUser().getReservedCarsC())){
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
        //int table_row = 0;
        for(CarC car : this.appModel.getCarsC()){
            Action buttonAction = new AbstractAction()
		{
                    public void actionPerformed(ActionEvent e)
                    {
                        JTable table = (JTable)e.getSource();
                        int modelRow = Integer.valueOf( e.getActionCommand() );
                        if( "Rent".equals((String)table.getModel().getValueAt(modelRow, 4))){
                            table.getModel().setValueAt("Cancel", modelRow, 4);
                            table.getModel().setValueAt("Not Avaible", modelRow, 2);
                            appModel.getCurrentUser().addCarCtoOrder(modelRow);
                            appModel.reserveCarC(modelRow);
                        }
                        else{
                            table.getModel().setValueAt("Rent", modelRow, 4);
                            table.getModel().setValueAt("Avaible", modelRow, 2);
                            appModel.getCurrentUser().removeCarCfromOrder(modelRow);
                            appModel.returnCarC(modelRow);
                        }
                    }
		};
            
            modelCarC.addRow(new Object[]{car.getName(), car.getMark(), isAvaibleCar(car.getIsAvaible()), CarC.getPrice(), "Rent"});
            ButtonColumn buttonColumn = new ButtonColumn(carsCTable, buttonAction, 4);
            //++table_row;
        } 
        return new JScrollPane(carsCTable);
    }
    
    private void handleLogoutButtonClick(ActionEvent e){
        this.setVisible(false);
        this.appController.restoreLoginPage();
    }
    
    private String isAvaibleCar(boolean isAvaible){
        return isAvaible ? "Avaible" : "Not Avaible";
    }
    
    public void setActualUserDisplay(){
        this.userInfo.setText(this.appModel.getCurrentUser().getUserLogin());
        this.scrollPaneA = fillCarsATable();
        this.scrollPaneB = fillCarsBTable();
        this.scrollPaneC = fillCarsCTable();
    }
    
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
    
//    private String checkIfCellIsBlock(boolean isEditable){
//        return isEditable ? "Rent" : "";
//    }
}
