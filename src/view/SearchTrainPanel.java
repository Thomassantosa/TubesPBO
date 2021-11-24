package view;

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
import model.TrainTrip;
import model.TripTypesEnum;

public class SearchTrainPanel extends JPanel implements ActionListener {

    // Declaring variable
    JLabel lTitle, lOrder, lDeparture, lDestination, lDate, lNoPassengers, lSeatClass, lBooking;
    QueryController queryController;
    JPanel container;
    JTable dataTable;
    DefaultTableModel model;
    JScrollPane scrollpane;
    JTextField tfTrainTripID;
    JButton btnChoose;
    ArrayList<TrainTrip> TrainTripList;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();
    
    public SearchTrainPanel() {
    }
    
    public SearchTrainPanel(String departureCity, String destinationCity, String departureDate, String seatClass) {
        
        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Train Menu");
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
        String[] columnData = {"TrainTrip ID", "Departure City", "Departure Station", "Destination City", "Destination Station", "Travel Time", "Seat Type", "Price"};
        model = new DefaultTableModel(columnData, 0);
        
        TrainTripList = queryController.selectTrainTrip(departureCity, destinationCity, departureDate, seatClass);
        for (int i = 0; i < TrainTripList.size(); i++) {
            String[] newModel = new String[8];

            TrainTrip currentTrainTrip = TrainTripList.get(i);
            newModel[0] = String.valueOf(currentTrainTrip.getTripID());
            newModel[1] = currentTrainTrip.getDepartureStation().getCity();
            newModel[2] = currentTrainTrip.getDepartureStation().getName();
            newModel[3] = currentTrainTrip.getDestinationStation().getCity();
            newModel[4] = currentTrainTrip.getDestinationStation().getName();
            newModel[5] = String.valueOf(currentTrainTrip.getTripTime());
            newModel[6] = currentTrainTrip.getTrain().getSeatList().get(0).getSeatType();
            newModel[7] = String.valueOf(currentTrainTrip.getTrain().getSeatList().get(0).getPrice());
            model.addRow(newModel);
        }
        dataTable.setModel(model);

        // Set JScrollPane
        scrollpane = new JScrollPane(dataTable); 
        scrollpane.setBounds(20, 80, width-270, height-400);


        lBooking = new JLabel("Select Train Trip ID to Book");
        lBooking.setForeground(ConstColor.WHITE);
        lBooking.setFont(new Font("Arial", Font.PLAIN, 20));
        lBooking.setBounds(scrollpane.getX(), scrollpane.getY() + scrollpane.getHeight() + 60, 300, 20);

        tfTrainTripID = new JTextField();
        tfTrainTripID.setForeground(ConstColor.WHITE);
        tfTrainTripID.setBackground(ConstColor.PURPLE3);
        tfTrainTripID.setBounds(lBooking.getX(), lBooking.getY() + 30, 200, 40);
        tfTrainTripID.setMargin(new Insets(0, 10, 0, 0));

        btnChoose = new JButton("Choose");
        btnChoose.setBounds(tfTrainTripID.getX() + tfTrainTripID.getWidth() + 40, tfTrainTripID.getY(), 150, 40);
        btnChoose.setBackground(ConstColor.PURPLE4);
        btnChoose.setForeground(ConstColor.WHITE);
        btnChoose.setFont(new Font("Arial", Font.PLAIN, 20));
        btnChoose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnChoose.addActionListener(this);

        // Adding components
        this.add(lTitle);
        this.add(scrollpane);
        this.add(lBooking);
        this.add(tfTrainTripID);
        this.add(btnChoose);

        // Set vicibility
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String trainTripID = tfTrainTripID.getText();

        if (!trainTripID.equals("")) {

            // Check if trainTripID valid
            boolean valid = false;
            for (int i = 0; i < TrainTripList.size(); i++) {
                if (String.valueOf(TrainTripList.get(i).getTripID()).equals(trainTripID)){
                    
                    valid = true;

                    int id = TrainTripList.get(i).getTripID();
                    TripTypesEnum type = TripTypesEnum.TRAIN;
                    int price = TrainTripList.get(i).getTrain().getSeatList().get(0).getPrice();
                    
                    MainFrame.setBookingPanel(id, type, price);
                    MainFrame.cardLayout.show(MainFrame.cardPanelUser, "bookingPanel");
                }
            }
            if (!valid) {
                JOptionPane.showMessageDialog(null, "Train Trip ID not found");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose Train Trip ID to booking !");
        }
    }
}
