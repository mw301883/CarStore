/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michal.wieczorek.carstore.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.TableCellRenderer;
import michal.wieczorek.carstore.Controller.AppController;
import michal.wieczorek.carstore.Model.AppModel;

/**
 *
 * @author Michał
 */
public class StandardUserGUI extends JFrame{
    
    private AppController appController;
    private AppModel appModel;
    private JLabel infoLabel = new JLabel("Zarezerwuj auto :");

    public StandardUserGUI(){
        this.appController = appController;
        this.appModel = appModel;
        
        JPanel infoPanel = new JPanel();
        infoPanel.add(infoLabel);
        
        this.setSize(400, 300);

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable carsTable = new JTable(model);
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        carsTable.setDefaultRenderer(Object.class, renderer);
        
        carsTable.setRowSelectionAllowed(true);
        carsTable.setColumnSelectionAllowed(true);
        carsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        carsTable.setFocusable(false);
        
        model.addColumn("ID");
        model.addColumn("Imię");
        model.addColumn("Nazwisko");
        model.addColumn("Wiek");
        model.addColumn("Akcje");

        carsTable.getColumn("Akcje").setCellRenderer(new TableCellRenderer() {
            private final JButton button = new JButton();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value != null) {
                    button.setText("Click");
                } else {
                    button.setText("");
                }
                button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obsługa kliknięcia przycisku
                    // Tutaj możesz umieścić kod do obsługi akcji przycisku
                    System.out.println("cos");
                    }
                });
                return button;
            }
            
        });
        model.addRow(new Object[]{1, "John", "Doe", 30, createButton("Button 1")});
        model.addRow(new Object[]{2, "Jane", "Smith", 25, createButton("Button 2")});
        model.addRow(new Object[]{3, "Bob", "Johnson", 40, createButton("Button 3")});
        
        JScrollPane scrollPane = new JScrollPane(carsTable);
        
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.NORTH);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    private JButton createButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obsługa kliknięcia przycisku
                // Tutaj możesz umieścić kod do obsługi akcji przycisku
                System.out.println("cos");
            }
        });
        return button;
    }
}
