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
import model.TrainTrip;
import model.Trip;

public class AdminTrainPanel extends JPanel {
    
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

    public AdminTrainPanel() {

        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Admin Menu (Train Data)");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);

        // Set JTable
        dataTable = new JTable();
        dataTable.setBounds(20, 80, width-270, height-200);
        String[] columnData = {"Traintrip_id", "Train", "Departure Station", "Destination Station", "Traintrip Number", "Departure Time", "Arrival Time", "Departure Date", "Arrival Date", "Travel Time"};
        model = new DefaultTableModel(columnData, 0);
        
        ArrayList<Trip> traintrips = queryController.selectAllTrainTrip();
        for (int i = 0; i < traintrips.size(); i++) {
            String[] newModel = new String[11];

            Trip currentTrip = traintrips.get(i);
            if(currentTrip instanceof TrainTrip) {
                TrainTrip trainTrip = (TrainTrip) currentTrip;
                newModel[0] = String.valueOf(trainTrip.getTripID());
                newModel[1] = trainTrip.getTrain().getModel();
                newModel[2] = trainTrip.getDepartureStation().getName();
                newModel[3] = trainTrip.getDestinationStation().getName();
                newModel[4] = trainTrip.getTrainTripNumber();
                newModel[5] = trainTrip.getDepartureTime();
                newModel[6] = trainTrip.getArrivalTime();
                newModel[7] = trainTrip.getDepartureDate();
                newModel[8] = trainTrip.getArrivalDate();
                newModel[9] = String.valueOf(trainTrip.getTripTime());
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
