package test;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.QueryController;
import model.Flight;
import model.TripTypesEnum;

public class SearchFlightPanel extends JPanel implements ActionListener {

    // Declaring variable
    JLabel lTitle, lOrder, lDeparture, lDestination, lDate, lNoPassengers, lSeatClass, lBooking;
    QueryController queryController;
    JPanel container;
    JTable dataTable;
    DefaultTableModel model;
    JScrollPane scrollpane;
    JTextField tfFlightID;
    JButton btnChoose;
    ArrayList<Flight> flightList;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();
    
    public SearchFlightPanel() {
    }
    
    public SearchFlightPanel(String departureCity, String destinationCity, String departureDate, String seatClass) {
        
        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Flight Menu");
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
        String[] columnData = {"Flight ID", "Airline", "Departure City", "Departure Airport", "Destination City", "Destination Airport", "Flight Time", "Seat Type", "Price"};
        model = new DefaultTableModel(columnData, 0);
        
        flightList = queryController.selectFlight(departureCity, destinationCity, departureDate, seatClass);
        for (int i = 0; i < flightList.size(); i++) {
            String[] newModel = new String[9];

            Flight currentFlight = flightList.get(i);
            newModel[0] = String.valueOf(currentFlight.getTripID());
            newModel[1] = currentFlight.getAirline().getName();
            newModel[2] = currentFlight.getDepartureAirport().getCity();
            newModel[3] = currentFlight.getDepartureAirport().getName();
            newModel[4] = currentFlight.getDestinationAirport().getCity();
            newModel[5] = currentFlight.getDestinationAirport().getName();
            newModel[6] = String.valueOf(currentFlight.getTripTime());
            newModel[7] = currentFlight.getAirplane().getSeatList().get(0).getSeatType();
            newModel[8] = String.valueOf(currentFlight.getAirplane().getSeatList().get(0).getPrice());
            model.addRow(newModel);
        }
        dataTable.setModel(model);

        // Set JScrollPane
        scrollpane = new JScrollPane(dataTable); 
        scrollpane.setBounds(20, 80, width-270, height-400);


        lBooking = new JLabel("Select Flight ID to Book");
        lBooking.setForeground(ConstColor.WHITE);
        lBooking.setFont(new Font("Arial", Font.PLAIN, 20));
        lBooking.setBounds(scrollpane.getX(), scrollpane.getY() + scrollpane.getHeight() + 60, 300, 20);

        tfFlightID = new JTextField();
        tfFlightID.setForeground(ConstColor.WHITE);
        tfFlightID.setBackground(ConstColor.PURPLE3);
        tfFlightID.setBounds(lBooking.getX(), lBooking.getY() + 30, 200, 40);
        tfFlightID.setMargin(new Insets(0, 10, 0, 0));

        btnChoose = new JButton("Choose");
        btnChoose.setBounds(tfFlightID.getX() + tfFlightID.getWidth() + 40, tfFlightID.getY(), 150, 40);
        btnChoose.setBackground(ConstColor.PURPLE4);
        btnChoose.setForeground(ConstColor.WHITE);
        btnChoose.setFont(new Font("Arial", Font.PLAIN, 20));
        btnChoose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnChoose.addActionListener(this);

        // Adding components
        this.add(lTitle);
        this.add(scrollpane);
        this.add(lBooking);
        this.add(tfFlightID);
        this.add(btnChoose);

        // Set vicibility
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String flightID = tfFlightID.getText();

        if (!flightID.equals("")) {

            // Check if flightID valid
            boolean valid = false;
            for (int i = 0; i < flightList.size(); i++) {
                if (String.valueOf(flightList.get(i).getTripID()).equals(flightID)){
                    
                    valid = true;

                    int id = flightList.get(i).getTripID();
                    TripTypesEnum type = TripTypesEnum.FLIGHT;
                    int price = flightList.get(i).getAirplane().getSeatList().get(0).getPrice();
                    
                    MainFrame.setBookingPanel(id, type, price);
                    MainFrame.cardLayout.show(MainFrame.cardPanelUser, "bookingPanel");
                }
            }
            if (!valid) {
                JOptionPane.showMessageDialog(null, "Flight ID not found");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose Flight ID to booking !");
        }
    }
}
