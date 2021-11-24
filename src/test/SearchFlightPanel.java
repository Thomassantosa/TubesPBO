package test;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.QueryController;
import model.Flight;

public class SearchFlightPanel extends JPanel implements ActionListener {

    // Declaring variable
    JLabel lTitle, lOrder, lDeparture, lDestination, lDate, lNoPassengers, lSeatClass;
    QueryController queryController;
    JPanel container;
    JTable dataTable;
    DefaultTableModel model;
    JScrollPane scrollpane;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();
    
    public SearchFlightPanel() {
    }
    
    public SearchFlightPanel(String departureCity, String destinationCity, String noPassenger, String departureDate, String seatClass) {
        
        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Flight Menu TEST");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);
        
        container = new RoundedPanel(20, ConstColor.PURPLE2);
        container.setBounds(20, 100, width-270, height-200);
        container.setLayout(null);
        container.setOpaque(false);

        // System.out.println(flightList.toString());

        // Set JTable
        dataTable = new JTable();
        dataTable.setBounds(20, 80, width-270, height-200);
        String[] columnData = {"Airline", "Departure City", "Departure Airport", "Destination City", "Destination Airport", "Flight Time", "Seat Type", "Price"};
        model = new DefaultTableModel(columnData, 0);
        
        ArrayList<Flight> flightList = queryController.selectFlight(departureCity, destinationCity, noPassenger, departureDate, seatClass);
        for (int i = 0; i < flightList.size(); i++) {
            String[] newModel = new String[8];

            Flight currentFlight = flightList.get(i);
            newModel[0] = currentFlight.getAirline().getName();
            newModel[1] = currentFlight.getDepartureAirport().getCity();
            newModel[2] = currentFlight.getDepartureAirport().getName();
            newModel[3] = currentFlight.getDestinationAirport().getCity();
            newModel[4] = currentFlight.getDestinationAirport().getName();
            newModel[5] = String.valueOf(currentFlight.getTripTime());
            newModel[6] = currentFlight.getAirplane().getSeatList().get(0).getSeatType();
            newModel[7] = String.valueOf(currentFlight.getAirplane().getSeatList().get(0).getPrice());
            model.addRow(newModel);
        }
        dataTable.setModel(model);

        // Set JScrollPane
        scrollpane = new JScrollPane(dataTable); 
        scrollpane.setBounds(20, 80, width-270, height-200);

        // Adding components
        this.add(lTitle);
        // this.add(container);
        this.add(scrollpane);

        // Set vicibility
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
