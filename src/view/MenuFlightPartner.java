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

public class MenuFlightPartner implements MouseInputListener {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    JFrame fMainMenuFlight;
    JPanel panelMenu, panelShowData, panelDelete, panelAdd;
    JButton btnShow, btnAdd, btnDelete, btnSave, btnLogout;
    JTable dataTable;
    JLabel lTitle;
    JScrollPane scrollpane;
    DefaultTableModel model;

    MenuFlightPartner() {

        // frame
        fMainMenuFlight = new JFrame("Travelokay");
        fMainMenuFlight.setSize((int) width, (int) height);
        fMainMenuFlight.setLayout(null);
        fMainMenuFlight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fMainMenuFlight.setExtendedState(JFrame.MAXIMIZED_BOTH);

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

        lTitle = new JLabel("Flights Data ");
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
        String[] columnData = { "Airplane Name", "Derparture Airport ", "Destination Airport", "Flight type",
                "Flight Number", "Departure Time", "Arrival Time", "Derpature Date", "Arrival Date", "Travel Time" };
        model = new DefaultTableModel(columnData, 0);

        dataTable.setModel(model);

        // button add Data
        // nama pesawat , statisun brangkat tujuan , flight type (hardcode),
        // flightnumber (text), departure time arrival time (String), departure date
        // arrival date (String),travel time
        btnShow = new JButton("Show Flights Data");
        btnShow.setBounds(panelMenu.getX(), panelMenu.getY(), panelMenu.getWidth(), panelMenu.getHeight() / 4);
        btnShow.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnShow.setBackground(new Color(100, 88, 110));
        btnShow.setForeground(Color.white);
        btnShow.addMouseListener(this);
        btnShow.setHorizontalAlignment(SwingConstants.LEFT);

        btnAdd = new JButton("Add Flights Data");
        btnAdd.setBounds(btnShow.getX(), btnShow.getY()+btnShow.getHeight(), btnShow.getWidth(), panelMenu.getHeight() / 4);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAdd.setBackground(new Color(100, 88, 110));
        btnAdd.setForeground(Color.white);
        btnAdd.addMouseListener(this);
        btnAdd.setHorizontalAlignment(SwingConstants.LEFT);

        // delete button
        btnDelete = new JButton("Delete Flight Data");
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

        fMainMenuFlight.add(panelMenu);
        fMainMenuFlight.add(panelShowData);
        fMainMenuFlight.add(panelAdd);
        fMainMenuFlight.add(panelDelete);

        scrollpane.setVisible(true);
        panelMenu.setVisible(true);
        panelShowData.setVisible(true);
        panelAdd.setVisible(false);
        panelDelete.setVisible(false);

        fMainMenuFlight.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(new Color(100, 88, 110));
        JButton button = (JButton) e.getSource();
        String name = button.getText();

        switch (name) {

        case "Show Flights Data":

            scrollpane.setVisible(true);
            panelMenu.setVisible(true);
            panelShowData.setVisible(true);
            panelAdd.setVisible(false);
            panelDelete.setVisible(false);

            break;
        case "Add Flights Data":

            scrollpane.setVisible(false);
            panelMenu.setVisible(true);
            panelShowData.setVisible(false);
            panelAdd.setVisible(true);
            panelDelete.setVisible(false);

            break;
        case "Delete Flight Data":
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
        new MenuFlightPartner();
    }
}
