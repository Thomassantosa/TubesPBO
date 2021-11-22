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
import model.Trip;

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
        lTitle = new JLabel("Admin Menu (Flight Data)");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);

        // Set JTable
        dataTable = new JTable();
        dataTable.setBounds(20, 80, width-270, height-200);
        String[] columnData = {"Flight_id", "Airplane", "Departure Airport", "Destination Airport", "Flight_Type", "Airline", "Flight Number", "Departure Time", "Arrival Time", "Departure Date", "Arrival Date", "Travel Time"};
        model = new DefaultTableModel(columnData, 0);
        
        ArrayList<Trip> flights = queryController.selectAllFlight();
        for (int i = 0; i < flights.size(); i++) {
            String[] newModel = new String[12];

            Trip currentTrip = flights.get(i);
            if(currentTrip instanceof Flight) {
                Flight flight = (Flight) currentTrip;
                newModel[0] = String.valueOf(flight.getTripID());
                newModel[1] = flight.getAirplane().getModel();
                newModel[2] = flight.getDepartureAirport().getName();
                newModel[3] = flight.getDestinationAirport().getName();
                newModel[4] = flight.getFlightType();
                newModel[5] = flight.getAirline().getName();
                newModel[6] = flight.getFlightNumber();
                newModel[7] = flight.getDepartureTime();
                newModel[8] = flight.getArrivalTime();
                newModel[9] = flight.getDepartureDate();
                newModel[10] = flight.getArrivalDate();
                newModel[11] = String.valueOf(flight.getTripTime());
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
