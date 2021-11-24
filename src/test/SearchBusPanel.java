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
import model.BusTrip;
import model.TrainTrip;
import model.TripTypesEnum;

public class SearchBusPanel extends JPanel implements ActionListener {

    // Declaring variable
    JLabel lTitle, lOrder, lDeparture, lDestination, lDate, lNoPassengers, lSeatClass, lBooking;
    QueryController queryController;
    JPanel container;
    JTable dataTable;
    DefaultTableModel model;
    JScrollPane scrollpane;
    JTextField tfBusTripID;
    JButton btnChoose;
    ArrayList<BusTrip> BusTripList;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();
    
    public SearchBusPanel() {
    }
    
    public SearchBusPanel(String departureCity, String destinationCity, String departureDate, String seatClass) {
        
        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Bus Menu");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);
        
        container = new RoundedPanel(20, ConstColor.PURPLE2);
        container.setBounds(20, 100, width-270, height-200);
        container.setLayout(null);
        container.setOpaque(false);

        // Set JTable
        dataTable = new JTable();
        dataTable.setBounds(20, 80, width-270, height-200);
        String[] columnData = {"BusTrip ID", "Bus Company", "Departure City", "Departure Station", "Destination City", "Destination Station", "Travel Time", "Seat Type", "Price"};
        model = new DefaultTableModel(columnData, 0);
        
        BusTripList = queryController.selectBusTrip(departureCity, destinationCity, departureDate, seatClass);
        for (int i = 0; i < BusTripList.size(); i++) {
            String[] newModel = new String[9];

            BusTrip currentBusTrip = BusTripList.get(i);
            newModel[0] = String.valueOf(currentBusTrip.getTripID());
            newModel[1] = currentBusTrip.getBusCompany().getName();
            newModel[2] = currentBusTrip.getDepartureStation().getCity();
            newModel[3] = currentBusTrip.getDepartureStation().getName();
            newModel[4] = currentBusTrip.getDestinationStation().getCity();
            newModel[5] = currentBusTrip.getDestinationStation().getName();
            newModel[6] = String.valueOf(currentBusTrip.getTripTime());
            newModel[7] = currentBusTrip.getBus().getSeatList().get(0).getSeatType();
            newModel[8] = String.valueOf(currentBusTrip.getBus().getSeatList().get(0).getPrice());
            model.addRow(newModel);
        }
        dataTable.setModel(model);

        // Set JScrollPane
        scrollpane = new JScrollPane(dataTable); 
        scrollpane.setBounds(20, 80, width-270, height-400);


        lBooking = new JLabel("Select Bus Trip ID to Book");
        lBooking.setForeground(ConstColor.WHITE);
        lBooking.setFont(new Font("Arial", Font.PLAIN, 20));
        lBooking.setBounds(scrollpane.getX(), scrollpane.getY() + scrollpane.getHeight() + 60, 300, 20);

        tfBusTripID = new JTextField();
        tfBusTripID.setForeground(ConstColor.WHITE);
        tfBusTripID.setBackground(ConstColor.PURPLE3);
        tfBusTripID.setBounds(lBooking.getX(), lBooking.getY() + 30, 200, 40);
        tfBusTripID.setMargin(new Insets(0, 10, 0, 0));

        btnChoose = new JButton("Choose");
        btnChoose.setBounds(tfBusTripID.getX() + tfBusTripID.getWidth() + 40, tfBusTripID.getY(), 150, 40);
        btnChoose.setBackground(ConstColor.PURPLE4);
        btnChoose.setForeground(ConstColor.WHITE);
        btnChoose.setFont(new Font("Arial", Font.PLAIN, 20));
        btnChoose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnChoose.addActionListener(this);

        // Adding components
        this.add(lTitle);
        this.add(scrollpane);
        this.add(lBooking);
        this.add(tfBusTripID);
        this.add(btnChoose);

        // Set vicibility
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String busTripID = tfBusTripID.getText();

        if (!busTripID.equals("")) {

            // Check if busTripID valid
            boolean valid = false;
            for (int i = 0; i < BusTripList.size(); i++) {
                if (String.valueOf(BusTripList.get(i).getTripID()).equals(busTripID)){
                    
                    valid = true;

                    int id = BusTripList.get(i).getTripID();
                    TripTypesEnum type = TripTypesEnum.BUS;
                    int price = BusTripList.get(i).getBus().getSeatList().get(0).getPrice();
                    
                    MainFrame.setBookingPanel(id, type, price);
                    MainFrame.cardLayout.show(MainFrame.cardPanelUser, "bookingPanel");
                }
            }
            if (!valid) {
                JOptionPane.showMessageDialog(null, "Bus Trip ID not found");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose Bus Trip ID to booking !");
        }
    }
}
