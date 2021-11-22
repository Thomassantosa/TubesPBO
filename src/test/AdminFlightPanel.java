package test;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.QueryController;
import model.Flight;

public class AdminFlightPanel extends JPanel {
    
    // Declaring variable
    JLabel lTitle;
    QueryController queryController;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();
    JTable dataTable;
    DefaultTableModel model;
    JScrollPane scrollpane;

    public AdminFlightPanel() {

        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
         // Set JLabel (title)
         lTitle = new JLabel("Admin Menu");
         lTitle.setForeground(ConstColor.WHITE);
         lTitle.setFont(new Font("Arial", Font.BOLD, 30));
         lTitle.setBounds(20, 20, 450, 40);

        // Adding components
        // Set JTable
        dataTable = new JTable();
        dataTable.setBounds(85, 120, 715, 350);    
        String[] columnData = {"Flight_id", "Airplane", "Departure Airport", "Destination Airport", "Flight_Type", "Flight Number", "Departure Time", "Arrival Time", "Departure Date", "Arrival Date", "Travel Time"};
        model = new DefaultTableModel(columnData, 0);
        
        ArrayList<Flight> flight = queryController.selectAllFlight();
        for (int i = 0; i < users.size(); i++) {
            String[] newModel = new String[5];
            newModel[0] = String.valueOf(users.get(i).getIdUser());
            newModel[1] = users.get(i).getName();
            newModel[2] = users.get(i).getEmail();
            newModel[3] = users.get(i).getPassword();
            newModel[4] = String.valueOf(users.get(i).getIdCategory());
            model.addRow(newModel);
        }
        dataTable.setModel(model);

        // Set JScrollPane
        scrollpane = new JScrollPane(dataTable); 
        scrollpane.setBounds(85, 120, 715, 350);
        
        // Set vicibility

    }
}
