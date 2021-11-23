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
    JLabel lTitle, lAddHotel, lDelete, lHotelName, lroomName, lHotelType, lHotelNumber,
            lderpatureTime, larrivalTime, lcheckin, lcheckout, ltravelTime, lDeletebyID;

    JScrollPane scrollpane;
    DefaultTableModel model;
    JTextField HotelNumber, derpatureTime, arrivalTime, travelTime, delete;
    JComboBox<String> cbHotelName, cbroomName, cbdestinationHotelStation;
    JDatePanelImpl checkin, checkout;

    ArrayList<String> HotelName = queryController.selectHotelName();
    ArrayList<String> RoomName = queryController.SelectRoomName();

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
        String[] columnData = { "Hotel Name",  "Room Name","Checkin","Checkout" };

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

            // label for adding a Hotel
            lAddHotel = new JLabel("Add Hotel");
            lAddHotel.setForeground(Color.white);
            lAddHotel.setFont(new Font("Tahoma", Font.BOLD, 40));
            lAddHotel.setBounds((int) width / 2 - 200, (int) height / 60, 500, 50);

            lHotelName = new JLabel("Hotel Name");
            lHotelName.setBounds(panelMenu.getX() + panelMenu.getWidth() - 50, lAddHotel.getY() + lAddHotel.getHeight() + 50,
                    250, 33);
            lHotelName.setForeground(Color.white);
            lHotelName.setFont(new Font("Tahoma", Font.PLAIN, 30));

            // cb Hotel
            String[] HotelNameList = new String[HotelName.size()];
            for (int i = 0; i < HotelName.size(); i++) {
                HotelNameList[i] = HotelName.get(i);
            }

            cbHotelName = new JComboBox<>(HotelNameList);
            cbHotelName.setBackground(new Color(100, 88, 110));
            cbHotelName.setForeground(Color.white);
            cbHotelName.setBounds(lHotelName.getX(), lHotelName.getY() + lHotelName.getHeight() + 30, 200, 33);

            //cb room 
            lroomName = new JLabel("Room Name");
            lroomName.setForeground(Color.white);
            lroomName.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lroomName.setBounds(cbHotelName.getX(), cbHotelName.getY() + cbHotelName.getHeight() + 80, 250, 33);

            String[] roomName = new String[RoomName.size()];
            for (int i = 0; i < RoomName.size(); i++) {
                roomName[i] = RoomName.get(i);
            }

            cbroomName = new JComboBox<>(roomName);
            cbroomName.setForeground(Color.white);
            cbroomName.setBackground(new Color(100, 88, 110));
            cbroomName.setBounds(lroomName.getX(), lroomName.getY() + lroomName.getHeight() + 30, 200, 33);

            // checkin
            lcheckin = new JLabel("Checkin");
            lcheckin.setForeground(Color.white);
            lcheckin.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lcheckin.setBounds(arrivalTime.getX(), arrivalTime.getY() + arrivalTime.getHeight() + 30, 250, 33);

            // datepicker
            Properties p = new Properties();
            SqlDateModel model = new SqlDateModel();
            p.put("text.day", "Day");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
            checkin = new JDatePanelImpl(model, p);
            checkin.setBounds(lcheckin.getX(), lcheckin.getY() + lcheckin.getHeight() + 50, 200,
                    200);


            // checkout
            lcheckout = new JLabel("Checkout");
            lcheckout.setForeground(Color.white);
            lcheckout.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lcheckout.setBounds(lcheckin.getX() + lcheckin.getWidth() + 20, lcheckin.getY(), 250,
                    33);

            Properties prop = new Properties();
            SqlDateModel model2 = new SqlDateModel();
            prop.put("text.day", "Day");
            prop.put("text.month", "Month");
            prop.put("text.year", "Year");
            checkout = new JDatePanelImpl(model2, p);
            checkout.setBounds(lcheckout.getX(), lcheckout.getY() + lcheckout.getHeight() + 50, 200, 200);

            // btn Save
            btnSave = new JButton("Save");
            btnSave.setForeground(Color.white);
            btnSave.setBackground(new Color(100, 88, 110));
            btnSave.setBounds(lHotelName.getX(), panelShowData.getHeight() - 200, 200, 50);
            btnSave.setFont(new Font("Tahoma", Font.BOLD, 30));
            btnSave.addMouseListener(this);

            panelAdd.add(lAddHotel);
            panelAdd.add(lHotelName);
            panelAdd.add(lroomName);
            panelAdd.add(lcheckin);
            panelAdd.add(lcheckout);

            panelAdd.add(checkout);
            panelAdd.add(checkin);
            panelAdd.add(cbHotelName);
            panelAdd.add(cbroomName);
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
