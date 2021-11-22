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
import model.Hotel;
import model.Trip;

public class AdminHotelPanel extends JPanel {
    
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

    public AdminHotelPanel() {

        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Admin Menu (Hotel Data)");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);

        // Set JTable
        dataTable = new JTable();
        dataTable.setBounds(20, 80, width-270, height-200);
        String[] columnData = {"Hotel_id", "Hotel Name", "Hotel Star", "Rating", "Number of Review", "Hotel Facility" ,"Address", "City", "Country"};
        model = new DefaultTableModel(columnData, 0);
        
        ArrayList<Hotel> hotels = queryController.selectAllHotel();
        for (int i = 0; i < hotels.size(); i++) {
            String[] newModel = new String[9];

            Hotel currentHotel = hotels.get(i);
            newModel[0] = String.valueOf(currentHotel.getHotelID());
            newModel[1] = currentHotel.getName();
            newModel[2] = String.valueOf(currentHotel.getStar());
            newModel[3] = String.valueOf(currentHotel.getRating());
            newModel[4] = String.valueOf(currentHotel.getReview());
            newModel[5] = currentHotel.getFacility();
            newModel[6] = currentHotel.getAddress();
            newModel[7] = currentHotel.getCity();
            newModel[8] = currentHotel.getCountry();
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
