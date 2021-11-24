package view;

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
import model.BusTrip;
import model.Trip;

public class AdminBusPanel extends JPanel {
    
    // Declaring variable
    JLabel lTitle;
    QueryController queryController;
    JTable dataTable;
    DefaultTableModel model;
    JScrollPane scrollpane;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public AdminBusPanel() {

        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Admin Menu (Bus Data)");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);

        // Set JTable
        dataTable = new JTable();
        dataTable.setBounds(20, 80, width-270, height-200);
        String[] columnData = {"Bustrip_id", "Bus", "Departure Busstation", "Destination Busstation", "Bustrip Number", "Bus Company", "Departure Time", "Arrival Time", "Departure Date", "Arrival Date", "Travel Time"};
        model = new DefaultTableModel(columnData, 0);
        
        ArrayList<Trip> busTrips = queryController.selectAllBusTrip();
        for (int i = 0; i < busTrips.size(); i++) {
            String[] newModel = new String[11];

            Trip currentTrip = busTrips.get(i);
            if(currentTrip instanceof BusTrip) {
                BusTrip busTrip = (BusTrip) currentTrip;
                newModel[0] = String.valueOf(busTrip.getTripID());
                newModel[1] = busTrip.getBus().getModel();
                newModel[2] = busTrip.getDepartureStation().getName();
                newModel[3] = busTrip.getDestinationStation().getName();
                newModel[4] = busTrip.getBusTripNumber();
                newModel[5] = busTrip.getBusCompany().getName();
                newModel[6] = busTrip.getDepartureTime();
                newModel[7] = busTrip.getArrivalTime();
                newModel[8] = busTrip.getDepartureDate();
                newModel[9] = busTrip.getArrivalDate();
                newModel[10] = String.valueOf(busTrip.getTripTime());
            }
            model.addRow(newModel);
        }
        dataTable.setModel(model);

        // Set JScrollPane
        scrollpane = new JScrollPane(dataTable); 
        scrollpane.setBounds(20, 80, width-270, height-200);
        
        // Adding components
        this.add(lTitle);
        this.add(scrollpane);

        // Set vicibility
        this.setVisible(true);
    }
}
