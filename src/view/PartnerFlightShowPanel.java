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
import controller.SingletonManager;
import model.Flight;

public class PartnerFlightShowPanel extends JPanel {
    
    // Declaring variable
    JLabel lTitle;
    QueryController queryController;
    JPanel container;
    JTable dataTable;
    DefaultTableModel model;
    JScrollPane scrollpane;
    ArrayList<Flight> flightList;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public PartnerFlightShowPanel() {

        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Show Flight");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);

        // Set JTable
        dataTable = new JTable();
        dataTable.setBounds(20, 80, width-270, height-200);
        String[] columnData = {"Flight ID", "Flight Number", "Airline", "Departure City", "Departure Airport", "Destination City", "Destination Airport", "Flight Time", "Seat Type", "Price"};
        model = new DefaultTableModel(columnData, 0);
        
        flightList = queryController.selectFlightByPartner(SingletonManager.getInstance().getPartner().getCompanyName());
        for (int i = 0; i < flightList.size(); i++) {
            String[] newModel = new String[10];

            Flight currentFlight = flightList.get(i);
            newModel[0] = String.valueOf(currentFlight.getTripID());
            newModel[1] = currentFlight.getFlightNumber();
            newModel[2] = currentFlight.getAirline().getName();
            newModel[3] = currentFlight.getDepartureAirport().getCity();
            newModel[4] = currentFlight.getDepartureAirport().getName();
            newModel[5] = currentFlight.getDestinationAirport().getCity();
            newModel[6] = currentFlight.getDestinationAirport().getName();
            newModel[7] = String.valueOf(currentFlight.getTripTime());
            newModel[8] = currentFlight.getAirplane().getSeatList().get(0).getSeatType();
            newModel[9] = String.valueOf(currentFlight.getAirplane().getSeatList().get(0).getPrice());
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
