/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View.AdminGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import michal.wieczorek.carstore.Controller.AppController;
import michal.wieczorek.carstore.Model.Raport.Raport;
import michal.wieczorek.carstore.View.ButtonColumn.ButtonColumn;
import michal.wieczorek.carstore.View.ErrorGUI.ErrorGUI;

/**
 * Represents the GUI for displaying a list of all reports in the application.
 * @author Michał Wieczorek
 * @version 1.0
 */
public class RaportsDisplayGUI extends JFrame{
    
    /**
    * Represents the graphical user interface (GUI) for displaying a list of all reports in the application.
    */
   private final AppController appController;

   /**
    * Label indicating the purpose of the GUI, which is to show a list of all reports.
    */
   private final JLabel infoLabel = new JLabel("List of all reports:");

   /**
    * Scroll pane used to display the list of reports in a scrollable view.
    */
   private JScrollPane scrollPaneRaports;

   /**
    * Button to cancel and close the GUI for displaying reports.
    */
   private final JButton cancelButton = new JButton("CANCEL");

    /**
     * Initializes the RaportsDisplayGUI with the provided AppController.
     * Sets up the GUI components for displaying the list of reports.
     *
     * @param appController The AppController used for handling actions and data.
     */
    public RaportsDisplayGUI(AppController appController){
        this.appController = appController;
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setSize(500, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel();
        mainPanel.add(infoLabel);
        
        JPanel raportsTablePanel = new JPanel();
        raportsTablePanel.setLayout(new GridLayout(1, 1));
        this.scrollPaneRaports = fillRaportsTable();
        raportsTablePanel.add(this.scrollPaneRaports);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(this.cancelButton);
        
        this.cancelButton.addActionListener(this::handleCancelButtonClick);
        this.cancelButton.setToolTipText("Back to main page.");
        
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(raportsTablePanel, BorderLayout.CENTER);
        this.add(mainPanel, BorderLayout.NORTH);
        
        this.setVisible(true);
    }
    
    /**
     * Fills and configures the table with a list of reports.
     *
     * @return A JScrollPane containing the table of reports.
     */
    private JScrollPane fillRaportsTable(){
        DefaultTableModel modelRaportsTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 4){
                    return true;
                }
                return false;
            }
        };
        JTable raportsTable = new JTable(modelRaportsTable);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        raportsTable.setDefaultRenderer(Object.class, renderer);
        
        raportsTable.setRowSelectionAllowed(true);
        raportsTable.setColumnSelectionAllowed(true);
        raportsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        raportsTable.setFocusable(true);
        
        modelRaportsTable.addColumn("");
        modelRaportsTable.addColumn("Customer Number");
        modelRaportsTable.addColumn("Date");
        modelRaportsTable.addColumn("Total payment");
        modelRaportsTable.addColumn("");
        
        int index = 1;
        for(Raport raport : this.appController.getRaportsList()){
            Action buttonAction = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
                            JTable table = (JTable)e.getSource();
                            int modelRow = Integer.valueOf( e.getActionCommand());
                            ErrorGUI detailsGUI = new ErrorGUI();
                            detailsGUI.setWindowSize(800, 200);
                            detailsGUI.DetailsRaportDisplay(appController.getRaportsList().get(modelRow), appController);
			}
		};
            modelRaportsTable.addRow(new Object[]{index, raport.getCustomerCount(), raport.getDate(), raport.getTotalPrice(), "DETAILS"});
            ButtonColumn buttonColumn = new ButtonColumn(raportsTable, buttonAction, 4);
            ++index;
        }
        return new JScrollPane(raportsTable);
    }
    
    /**
     * Handles the "CANCEL" button click event by disposing the GUI and restoring the admin page.
     *
     * @param e The ActionEvent triggered by the button click.
     */
    private void handleCancelButtonClick(ActionEvent e){
        this.dispose();
        this.appController.restoreAdminPage();
    }
}
