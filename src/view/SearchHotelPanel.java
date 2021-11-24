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
import model.Hotel;
import model.Room;
import model.TripTypesEnum;

public class SearchHotelPanel extends JPanel implements ActionListener {

    // Declaring variable
    JLabel lTitle, lOrder, lDeparture, lDestination, lDate, lNoPassengers, lSeatClass, lBooking;
    QueryController queryController;
    JPanel container;
    JTable dataTable;
    DefaultTableModel model;
    JScrollPane scrollpane;
    JTextField tfRoomID;
    JButton btnChoose;
    ArrayList<Room> roomList;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();
    
    public SearchHotelPanel() {
    }
    
    public SearchHotelPanel(String city, String noGuest, String checkIn, String checkOut) {
        
        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Hotel Menu");
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
        String[] columnData = {"Room ID", "Hotel Name", "Star", "Rating", "Room Name", "Room Type", "Facility", "Room Capacity", "Price"};
        model = new DefaultTableModel(columnData, 0);
        
        roomList = queryController.selectRoom(city, noGuest, checkIn, checkOut);
        for (int i = 0; i < roomList.size(); i++) {
            String[] newModel = new String[10];

            Room currentRoom = roomList.get(i);
            Hotel currentHotel = queryController.getHotelByRoom(currentRoom.getRoomID());

            newModel[0] = String.valueOf(currentRoom.getRoomID());
            newModel[1] = currentHotel.getName();
            newModel[2] = String.valueOf(currentHotel.getStar());
            newModel[3] = String.valueOf(currentHotel.getRating());
            newModel[4] = currentRoom.getName();
            newModel[5] = currentRoom.getRoomType();
            newModel[6] = currentRoom.getFacility();
            newModel[7] = String.valueOf(currentRoom.getCapacity());
            newModel[8] = String.valueOf(currentRoom.getPrice());
            model.addRow(newModel);
        }
        dataTable.setModel(model);

        // Set JScrollPane
        scrollpane = new JScrollPane(dataTable); 
        scrollpane.setBounds(20, 80, width-270, height-400);

        lBooking = new JLabel("Select Room ID to Book");
        lBooking.setForeground(ConstColor.WHITE);
        lBooking.setFont(new Font("Arial", Font.PLAIN, 20));
        lBooking.setBounds(scrollpane.getX(), scrollpane.getY() + scrollpane.getHeight() + 60, 300, 20);

        tfRoomID = new JTextField();
        tfRoomID.setForeground(ConstColor.WHITE);
        tfRoomID.setBackground(ConstColor.PURPLE3);
        tfRoomID.setBounds(lBooking.getX(), lBooking.getY() + 30, 200, 40);
        tfRoomID.setMargin(new Insets(0, 10, 0, 0));

        btnChoose = new JButton("Choose");
        btnChoose.setBounds(tfRoomID.getX() + tfRoomID.getWidth() + 40, tfRoomID.getY(), 150, 40);
        btnChoose.setBackground(ConstColor.PURPLE4);
        btnChoose.setForeground(ConstColor.WHITE);
        btnChoose.setFont(new Font("Arial", Font.PLAIN, 20));
        btnChoose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnChoose.addActionListener(this);

        // Adding components
        this.add(lTitle);
        this.add(scrollpane);
        this.add(lBooking);
        this.add(tfRoomID);
        this.add(btnChoose);

        // Set vicibility
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String roomID = tfRoomID.getText();

        if (!roomID.equals("")) {

            // Check if flightID valid
            boolean valid = false;
            for (int i = 0; i < roomList.size(); i++) {
                if (String.valueOf(roomList.get(i).getRoomID()).equals(roomID)){
                    
                    valid = true;

                    int id = roomList.get(i).getRoomID();
                    TripTypesEnum type = TripTypesEnum.HOTEL;
                    int price = roomList.get(i).getPrice();
                    
                    MainFrame.setBookingPanel(id, type, price);
                    MainFrame.cardLayout.show(MainFrame.cardPanelUser, "bookingPanel");
                }
            }
            if (!valid) {
                JOptionPane.showMessageDialog(null, "Hotel ID not found");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose Hotel ID to booking !");
        }
    }
}
