package view;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import org.jdatepicker.impl.*;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import controller.QueryController;
import model.*;
import java.awt.Toolkit;
import java.awt.Image;

public class MenuHotelPartner implements MouseInputListener {
    QueryController queryController = new QueryController();

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    JFrame fMainMenuHotel;
    JPanel panelMenu, panelShowData, panelDelete, panelAdd;
    JButton btnShow, btnAdd, btnDelete, btnSave, btnLogout, deleteBtn;
    JTable dataTable;
    JLabel lTitle,  lAddRoom, lDelete, lRoomName, lRoomType, lRoomPrice, lRoomFacility, lRoomCapacity, lDeletebyID;

    JScrollPane scrollpane;
    DefaultTableModel model;
    JTextField RoomName, RoomPrice, RoomFacility, RoomCapacity , delete;
    JComboBox<String> cbRoomType;
    JDatePanelImpl checkin, checkout;

    ArrayList<String> RoomType = queryController.selectRoomType();

    MenuHotelPartner() {

        // frame
        fMainMenuHotel = new JFrame("Travelokay");
        fMainMenuHotel.setSize((int) width, (int) height);
        fMainMenuHotel.setLayout(null);
        fMainMenuHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fMainMenuHotel.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // panel Home
        panelShowData = new JPanel();
        panelShowData.setBackground(new Color(40, 25, 54));
        panelShowData.setBounds((int) width / 10, 0, (int) width, (int) height);
        panelShowData.setLayout(null);

        // panel add data
        panelAdd = new JPanel();
        panelAdd = new JPanel();
        panelAdd.setBackground(new Color(40, 25, 54));
        panelAdd.setBounds((int) width / 10, 0, (int) width, (int) height);
        panelAdd.setLayout(null);

        // panel delete data
        panelDelete = new JPanel();
        panelDelete = new JPanel();
        panelDelete.setBackground(new Color(40, 25, 54));
        panelDelete.setBounds((int) width / 10, 0, (int) width, (int) height);
        panelDelete.setLayout(null);

        lTitle = new JLabel("Hotel Data ");
        lTitle.setForeground(Color.white);
        lTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
        lTitle.setBounds((int) width / 2 - 200, (int) height / 60, 500, 50);

        panelMenu = new JPanel();
        panelMenu.setBackground(new Color(100, 88, 110));
        panelMenu.setBounds(0, 0, (int) width / 10, (int) height);
        panelMenu.setLayout(null);

        // set jtable
        dataTable = new JTable();
        dataTable.setBounds(panelMenu.getWidth() + 100, lTitle.getY() + lTitle.getHeight() + 50, 1200, 350);

        // Set JScrollPane
        scrollpane = new JScrollPane(dataTable);
        scrollpane.setBounds(panelMenu.getWidth() + 100, lTitle.getY() + lTitle.getHeight() + 50, 1200, 350);

        // Set value
        String[] columnData = { "Hotel Name", "Room Name", "Checkin", "Checkout" };

        model = new DefaultTableModel(columnData, 0);

        dataTable.setModel(model);

        // button add Data
        // nama Hotel , room
        // tanggal check in, check out

        btnShow = new JButton("Show Hotel Data");
        btnShow.setBounds(panelMenu.getX(), panelMenu.getY(), panelMenu.getWidth(), panelMenu.getHeight() / 4);
        btnShow.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnShow.setBackground(new Color(100, 88, 110));
        btnShow.setForeground(Color.white);
        btnShow.addMouseListener(this);
        btnShow.setHorizontalAlignment(SwingConstants.LEFT);

        btnAdd = new JButton("Add Hotel Data");
        btnAdd.setBounds(btnShow.getX(), btnShow.getY() + btnShow.getHeight(), btnShow.getWidth(),
                panelMenu.getHeight() / 4);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAdd.setBackground(new Color(100, 88, 110));
        btnAdd.setForeground(Color.white);
        btnAdd.addMouseListener(this);
        btnAdd.setHorizontalAlignment(SwingConstants.LEFT);

        // delete button
        btnDelete = new JButton("Delete Hotel Data");
        btnDelete.setBounds(btnAdd.getX(), btnAdd.getHeight() + btnAdd.getY(), btnAdd.getWidth(),
                panelMenu.getHeight() / 4);
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnDelete.setBackground(new Color(100, 88, 110));
        btnDelete.setForeground(Color.white);
        btnDelete.addMouseListener(this);
        btnDelete.setHorizontalAlignment(SwingConstants.LEFT);

        // logout button
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(btnAdd.getX(), panelMenu.getHeight() - 150, btnAdd.getWidth(), 50);
        btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnLogout.setBackground(new Color(100, 88, 110));
        btnLogout.setForeground(new Color(255, 55, 58));
        btnLogout.addMouseListener(this);
        btnLogout.setHorizontalAlignment(SwingConstants.LEFT);

        // add component
        panelMenu.add(btnShow);
        panelMenu.add(btnAdd);
        panelMenu.add(btnDelete);
        panelMenu.add(btnLogout);

        panelShowData.add(lTitle);
        panelShowData.add(scrollpane);

        fMainMenuHotel.add(panelMenu);
        fMainMenuHotel.add(panelShowData);
        fMainMenuHotel.add(panelAdd);
        fMainMenuHotel.add(panelDelete);

        scrollpane.setVisible(true);
        panelMenu.setVisible(true);
        panelShowData.setVisible(true);
        panelAdd.setVisible(false);
        panelDelete.setVisible(false);

        fMainMenuHotel.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(new Color(100, 88, 110));
        JButton button = (JButton) e.getSource();
        String name = button.getText();

        switch (name) {

        case "Show Hotel Data":

            scrollpane.setVisible(true);
            panelMenu.setVisible(true);
            panelShowData.setVisible(true);
            panelAdd.setVisible(false);
            panelDelete.setVisible(false);

            break;

        case "Add Hotel Data":

             // label for adding a Bus
             lAddRoom = new JLabel("Add Room");
             lAddRoom.setForeground(Color.white);
             lAddRoom.setFont(new Font("Tahoma", Font.BOLD, 40));
             lAddRoom.setBounds((int) width / 2 - 200, (int) height / 60, 500, 50);
 
             lRoomName = new JLabel("Room Name");
             lRoomName.setBounds(panelMenu.getX() + panelMenu.getWidth() - 50, lAddRoom.getY() + lAddRoom.getHeight() + 50,
                     250, 33);
            lRoomName.setForeground(Color.white);
            lRoomName.setFont(new Font("Tahoma", Font.PLAIN, 30));
 
            RoomName = new JTextField();
            RoomName.setForeground(Color.white);
            RoomName.setBackground(new Color(100, 88, 110));
            RoomName.setBounds(lRoomName.getX(), lRoomName.getY() + lRoomName.getHeight() + 30, 200, 33);
 
             lRoomType = new JLabel("Room Type");
             lRoomType.setForeground(Color.white);
             lRoomType.setFont(new Font("Tahoma", Font.PLAIN, 30));
             lRoomType.setBounds(RoomName.getX(),RoomName.getY() + RoomName.getHeight() + 80, 250, 33);
 
             String[] RoomTypeList = new String[RoomType.size()];
             for (int i = 0; i < RoomType.size(); i++) {
                RoomTypeList[i] = RoomType.get(i);
             }
 
             cbRoomType = new JComboBox<>(RoomTypeList);
             cbRoomType.setBackground(new Color(100, 88, 110));
             cbRoomType.setForeground(Color.white);
             cbRoomType.setBounds(lRoomType.getX(), lRoomType.getY() + lRoomType.getHeight() + 30, 200, 33);
 
             lRoomPrice = new JLabel("Room Price");
             lRoomPrice.setForeground(Color.white);
             lRoomPrice.setFont(new Font("Tahoma", Font.PLAIN, 30));
             lRoomPrice.setBounds( cbRoomType.getX(), cbRoomType.getY() +  cbRoomType.getHeight() + 80, 250, 33);
 
             RoomPrice = new JTextField();
             RoomPrice.setForeground(Color.white);
             RoomPrice.setBackground(new Color(100, 88, 110));
             RoomPrice.setBounds( lRoomPrice.getX(),  lRoomPrice.getY() +  lRoomPrice.getHeight() + 30, 200, 33);
 
            
             lRoomFacility = new JLabel("Room Facility");
             lRoomFacility.setBounds(lAddRoom.getX(), lRoomName.getY(), 250, 33);
             lRoomFacility.setForeground(Color.white);
             lRoomFacility.setFont(new Font("Tahoma", Font.PLAIN, 30));
 
             RoomFacility = new JTextField();
             RoomFacility.setForeground(Color.white);
             RoomFacility.setBackground(new Color(100, 88, 110));
             RoomFacility.setBounds(lRoomFacility.getX(), lRoomFacility.getY() + lRoomFacility.getHeight() + 30, 200, 33);
 
             lRoomCapacity = new JLabel("Room Capacity");
             lRoomCapacity.setForeground(Color.white);
             lRoomCapacity.setFont(new Font("Tahoma", Font.PLAIN, 30));
             lRoomCapacity.setBounds(RoomFacility.getX(),RoomFacility.getY() + RoomFacility.getHeight() + 80, 250, 33);
 
 
             RoomCapacity = new JTextField();
             RoomCapacity.setForeground(Color.white);
             RoomCapacity.setBackground(new Color(100, 88, 110));
             RoomCapacity.setBounds(lRoomCapacity.getX(), lRoomCapacity.getY() + lRoomCapacity.getHeight() + 30, 250,
                     33);
 
            // btn Save
            btnSave = new JButton("Save");
            btnSave.setForeground(Color.white);
            btnSave.setBackground(new Color(100, 88, 110));
            btnSave.setBounds(RoomCapacity.getX(), panelShowData.getHeight() - 200, 200, 50);
            btnSave.setFont(new Font("Tahoma", Font.BOLD, 30));
            btnSave.addMouseListener(this);

            panelAdd.add(lAddRoom);
            panelAdd.add(lRoomName);
            panelAdd.add(lRoomType);
            panelAdd.add(lRoomPrice);
            panelAdd.add(lRoomFacility);
            panelAdd.add(lRoomCapacity);

            panelAdd.add(RoomName);
            panelAdd.add(cbRoomType);
            panelAdd.add(RoomPrice);
            panelAdd.add(RoomFacility);
            panelAdd.add(RoomCapacity);

            panelAdd.add(btnSave);

            scrollpane.setVisible(false);
            panelMenu.setVisible(true);
            panelShowData.setVisible(false);
            panelAdd.setVisible(true);
            panelDelete.setVisible(false);

            break;

        case "Delete Hotel Data":

            // label title delete
            lDelete = new JLabel("Delete Hotel");
            lDelete.setForeground(Color.white);
            lDelete.setFont(new Font("Tahoma", Font.BOLD, 40));
            lDelete.setBounds((int) width / 2 - 200, (int) height / 60, 500, 50);

            // label
            lDeletebyID = new JLabel("Delete Hotel by ID");
            lDeletebyID.setBounds(panelMenu.getX() + panelMenu.getWidth() - 50,
                    lDelete.getY() + lDelete.getHeight() + 150, 300, 33);
            lDeletebyID.setForeground(Color.white);
            lDeletebyID.setFont(new Font("Tahoma", Font.BOLD, 30));

            // jtextfield
            delete = new JTextField();
            delete.setForeground(Color.white);
            delete.setBackground(new Color(100, 88, 110));
            delete.setBounds(lDeletebyID.getX(), lDeletebyID.getY() + lDeletebyID.getHeight() + 20, 300, 33);

            deleteBtn = new JButton("Delete");
            deleteBtn.setForeground(Color.white);
            deleteBtn.setBackground(new Color(100, 88, 110));
            deleteBtn.setBounds(lDeletebyID.getX(), panelDelete.getHeight() - 200, 200, 50);
            deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 30));
            deleteBtn.addMouseListener(this);

            panelDelete.add(lDelete);
            panelDelete.add(lDeletebyID);
            panelDelete.add(delete);
            panelDelete.add(deleteBtn);

            scrollpane.setVisible(false);
            panelMenu.setVisible(true);
            panelShowData.setVisible(false);
            panelAdd.setVisible(false);
            panelDelete.setVisible(true);

        default:
            break;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(new Color(136, 94, 254));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // not implemented

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(new Color(136, 94, 254));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(new Color(100, 88, 110));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // not implemented
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // not implemented
    }

    public static void main(String[] args) {
        new MenuHotelPartner();
    }
}
