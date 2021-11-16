package view;

import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import org.jdatepicker.impl.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Date;
import java.util.Properties;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.tools.Tool;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MainMenu implements MouseInputListener {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();

    JFrame fMainMenu;
    JPanel panelMenu, panelHome, panelProfile, panelFlight, panelTrain, panelBus, panelHotel, panelXtourience;
    JButton btnHome, btnProfile, btnFlight, btnTrain, btnBus, btnHotel, btnXtourience, btnLogOut, btnSearch;
    JLabel lTitlePesawat, lDeparture, lDestination, lDate, lSeatClass;
    JComboBox cbDeparture, cbDestination, cbSeatClass;
    JDatePanelImpl jdPick;
    String country[] = { "Surabaya", "Bandung", "Singapore", "Bali", "Raja Ampat" };
    String seatClass[] = { "Economy", "Business", "First Class" };

    public MainMenu() {

        // frame Main Menu
        fMainMenu = new JFrame("Travelokay");
        fMainMenu.setSize((int) width - 100, (int) height - 100);
        fMainMenu.setLayout(null);

        fMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel Menu
        panelMenu = new JPanel();
        panelMenu.setBackground(new Color(100, 88, 110));
        panelMenu.setBounds(0, 0, (int) width / 10, (int) height - 100);
        panelMenu.setLayout(null);

        // Panel Home
        panelHome = new JPanel();
        panelHome.setBackground(new Color(40, 25, 54));
        panelHome.setBounds((int) width / 10, 0, (int) width - 100, (int) height - 100);
        panelHome.setLayout(null);

        // Button Home
        btnHome = new JButton("Home");
        btnHome.setBounds(0, 0, 195, 50);
        btnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnHome.setBackground(new Color(100, 88, 110));
        btnHome.setForeground(Color.white);
        btnHome.addMouseListener(this);
        btnHome.setHorizontalAlignment(SwingConstants.LEFT);

        // Button Flight
        btnFlight = new JButton("Flight");
        btnFlight.setBounds(0, btnHome.getVerticalAlignment() + 50, 195, 50);
        btnFlight.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnFlight.setBackground(new Color(100, 88, 110));
        btnFlight.setForeground(Color.white);
        btnFlight.addMouseListener(this);
        btnFlight.setHorizontalAlignment(SwingConstants.LEFT);

        // Button Train
        btnTrain = new JButton("Train");
        btnTrain.setBounds(0, btnHome.getVerticalAlignment() + 100, 195, 50);
        btnTrain.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnTrain.setBackground(new Color(100, 88, 110));
        btnTrain.setForeground(Color.white);
        btnTrain.addMouseListener(this);
        btnTrain.setHorizontalAlignment(SwingConstants.LEFT);

        // Button Bus
        btnBus = new JButton("Bus");
        btnBus.setBounds(0, btnHome.getVerticalAlignment() + 150, 195, 50);
        btnBus.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnBus.setBackground(new Color(100, 88, 110));
        btnBus.setForeground(Color.white);
        btnBus.addMouseListener(this);
        btnBus.setHorizontalAlignment(SwingConstants.LEFT);

        // Button Hotel
        btnHotel = new JButton("Hotel");
        btnHotel.setBounds(0, btnHome.getVerticalAlignment() + 200, 195, 50);
        btnHotel.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnHotel.setBackground(new Color(100, 88, 110));
        btnHotel.setForeground(Color.white);
        btnHotel.addMouseListener(this);
        btnHotel.setHorizontalAlignment(SwingConstants.LEFT);

        // Button Xtourience
        btnXtourience = new JButton("Xtourience");
        btnXtourience.setBounds(0, btnHome.getVerticalAlignment() + 250, 195, 50);
        btnXtourience.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnXtourience.setBackground(new Color(100, 88, 110));
        btnXtourience.setForeground(Color.white);
        btnXtourience.addMouseListener(this);
        btnXtourience.setHorizontalAlignment(SwingConstants.LEFT);

        // Panel Pesawat
        panelFlight = new JPanel();
        panelFlight.setBackground(Color.BLUE);
        panelFlight.setBounds((int) width / 10, 0, (int) width - 100, (int) height - 100);
        panelFlight.setLayout(null);

        // Panel Train
        panelTrain = new JPanel();
        panelTrain.setBackground(Color.yellow);
        panelTrain.setBounds((int) width / 10, 0, (int) width - 100, (int) height - 100);
        panelTrain.setLayout(null);

        // Panel Bus
        panelBus = new JPanel();
        panelBus.setBackground(Color.red);
        panelBus.setBounds((int) width / 10, 0, (int) width - 100, (int) height - 100);
        panelBus.setLayout(null);

        // Panel Hotel
        panelHotel = new JPanel();
        panelHotel.setBackground(Color.white);
        panelHotel.setBounds((int) width / 10, 0, (int) width - 100, (int) height - 100);
        panelHotel.setLayout(null);

        // Panel Xtourience
        panelXtourience = new JPanel();
        panelXtourience.setBackground(Color.black);
        panelXtourience.setBounds((int) width / 10, 0, (int) width - 100, (int) height - 100);
        panelXtourience.setLayout(null);

        panelMenu.add(btnXtourience);
        panelMenu.add(btnHotel);
        panelMenu.add(btnBus);
        panelMenu.add(btnTrain);
        panelMenu.add(btnFlight);
        panelMenu.add(btnHome);
        panelMenu.add(btnHotel);
        fMainMenu.add(panelMenu);
        fMainMenu.add(panelHome);
        fMainMenu.add(panelFlight);
        fMainMenu.add(panelTrain);
        fMainMenu.add(panelBus);
        fMainMenu.add(panelHotel);
        fMainMenu.add(panelXtourience);

        // panelHome.setVisible(true);
        // panelBus.setVisible(false);
        // panelTrain.setVisible(false);
        // panelFlight.setVisible(false);
        // panelHotel.setVisible(false);
        // panelXtourience.setVisible(false);
        fMainMenu.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(new Color(100, 88, 110));
        JButton button = (JButton) e.getSource();
        String name = button.getText();
        switch (name) {
        case "Home":
            panelHome.setVisible(true);
            panelProfile.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(false);
            break;
        case "Flight":
            panelHome.setVisible(false);
            panelProfile.setVisible(false);
            panelFlight.setVisible(true);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(false);
            break;
        case "Train":
            panelHome.setVisible(false);
            panelProfile.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(true);
            panelBus.setVisible(false);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(false);
            break;
        case "Bus":
            panelHome.setVisible(false);
            panelProfile.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(true);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(false);
            break;
        case "Hotel":
            panelHome.setVisible(false);
            panelProfile.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(true);
            panelXtourience.setVisible(false);
            break;
        case "Xtourience":
            panelHome.setVisible(false);
            panelProfile.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(true);
            break;
        default:
            break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
