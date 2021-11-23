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
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabExpander;

import controller.QueryController;
import model.*;
import java.awt.Toolkit;
import java.awt.Image;

public class MainMenu implements MouseInputListener {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    JFrame fMainMenu;
    JPanel panelMenu, panelHome, panelProfile, panelFlight, panelTrain, panelBus, panelHotel, panelXtourience;
    JButton btnSearchTrain, btnSave, btnHome, btnProfile, btnFlight, btnTrain, btnBus, btnHotel, btnXtourience,
            btnLogOut, btnSearch, btnSearchXtour, btnSearchFlight, btnSearchBus, btnSearchHotel;
    JLabel lFullName, lProfile, lTitleHome, lCity, lTitleHotel, lTitleFlight, lDeparture, lDestination, lDate,
            lSeatClass, lNoPassengers, lTitleTrain, lTitleBus, lNight, lUsername, lEmail, lPassword, lAddress,
            lBirthdate, lTitleXtour, lMoto;
    JComboBox cbDeparture, cbDestination, cbSeatClass, cbPassengers, cbCity, cbCityXtour;
    JDatePanelImpl jdPick;
    JTextField tfFullName, tfUsername, tfAddress, tfEmail;
    JPasswordField pfPassword;
    JTextArea taAddress;
    String seatClass[] = { "Economy", "Business", "First Class" };
    String number[] = { "1", "2", "3", "4", "5", "6", "7" };
    String City[] = { "Solo", "Bandung", "Jakarta", "Bali", "Yogyakarta" };
    JDatePanelImpl date;
    JScrollPane scrollPane;
    DefaultTableModel model;
    QueryController queryController = new QueryController();
    ArrayList<Airport> cityFLight = queryController.showCityFlight();
    ArrayList<Station> cityTrain = queryController.showCityTrain();

    public MainMenu() {

        // frame Main Menu
        fMainMenu = new JFrame("Travelokay");
        fMainMenu.setSize((int) width, (int) height);
        fMainMenu.setLayout(null);
        fMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fMainMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Panel Menu
        panelMenu = new JPanel();
        panelMenu.setBackground(new Color(100, 88, 110));
        panelMenu.setBounds(0, 0, (int) width / 10, (int) height);
        panelMenu.setLayout(null);

        // Panel Home
        panelHome = new JPanel();
        panelHome.setBackground(new Color(40, 25, 54));
        panelHome.setBounds((int) width / 10, 0, (int) width, (int) height);
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
        btnXtourience = new JButton("XTourience");
        btnXtourience.setBounds(0, btnHome.getVerticalAlignment() + 250, 195, 50);
        btnXtourience.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnXtourience.setBackground(new Color(100, 88, 110));
        btnXtourience.setForeground(Color.white);
        btnXtourience.addMouseListener(this);
        btnXtourience.setHorizontalAlignment(SwingConstants.LEFT);

        // Button Profile
        btnProfile = new JButton("Profile");
        btnProfile.setBounds(0, btnHome.getVerticalAlignment() + 920, 195, 50);
        btnProfile.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnProfile.setBackground(new Color(100, 88, 110));
        btnProfile.setForeground(Color.white);
        btnProfile.addMouseListener(this);
        btnProfile.setHorizontalAlignment(SwingConstants.LEFT);

        // Button LogOut
        btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(0, btnHome.getVerticalAlignment() + 970, 195, 50);
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnLogOut.setBackground(new Color(100, 88, 110));
        btnLogOut.setForeground(new Color(255, 55, 58));
        btnLogOut.addMouseListener(this);
        btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);

        // Panel Pesawat
        panelFlight = new JPanel();
        panelFlight.setBackground(new Color(40, 25, 54));
        panelFlight.setBounds((int) width / 10, 0, (int) width, (int) height);
        panelFlight.setLayout(null);

        // Panel Train
        panelTrain = new JPanel();
        panelTrain.setBackground(new Color(40, 25, 54));
        panelTrain.setBounds((int) width / 10, 0, (int) width, (int) height);
        panelTrain.setLayout(null);

        // Panel Bus
        panelBus = new JPanel();
        panelBus.setBackground(new Color(40, 25, 54));
        panelBus.setBounds((int) width / 10, 0, (int) width, (int) height);
        panelBus.setLayout(null);

        // Panel Hotel
        panelHotel = new JPanel();
        panelHotel.setBackground(new Color(40, 25, 54));
        panelHotel.setBounds((int) width / 10, 0, (int) width, (int) height);
        panelHotel.setLayout(null);

        // Panel Xtourience
        panelXtourience = new JPanel();
        panelXtourience.setBackground(new Color(40, 25, 54));
        panelXtourience.setBounds((int) width / 10, 0, (int) width, (int) height);
        panelXtourience.setLayout(null);

        // Panel Profile
        panelProfile = new JPanel();
        panelProfile.setBackground(new Color(40, 25, 54));
        panelProfile.setBounds((int) width / 10, 0, (int) width, (int) height);
        panelProfile.setLayout(null);

        // add to panel
        // panelMenu.add(btnXtourience);
        panelMenu.add(btnHotel);
        panelMenu.add(btnBus);
        panelMenu.add(btnTrain);
        panelMenu.add(btnFlight);
        panelMenu.add(btnHome);
        panelMenu.add(btnHotel);
        panelMenu.add(btnProfile);
        panelMenu.add(btnLogOut);

        // add to frame main menu
        fMainMenu.add(panelMenu);
        fMainMenu.add(panelHome);
        fMainMenu.add(panelFlight);
        fMainMenu.add(panelTrain);
        fMainMenu.add(panelBus);
        fMainMenu.add(panelHotel);
        fMainMenu.add(panelXtourience);
        fMainMenu.add(panelProfile);

        panelHome.setVisible(true);
        fMainMenu.setVisible(true);
        panelHome.setVisible(true);
        panelFlight.setVisible(false);
        panelTrain.setVisible(false);
        panelBus.setVisible(false);
        panelHotel.setVisible(false);
        panelXtourience.setVisible(false);
        panelProfile.setVisible(false);

        lTitleHome = new JLabel("Let's Explore The World");
        lTitleHome.setForeground(Color.white);
        lTitleHome.setFont(new Font("Tahoma", Font.BOLD, 40));
        lTitleHome.setBounds((int) width / 2 - 350, (int) height / 60, 500, 50);

        lUsername = new JLabel("Hello User");
        lUsername.setBounds(panelHome.getX(), lTitleHome.getY() + lTitleHome.getHeight() + 100, 500, 50);
        lUsername.setForeground(Color.white);
        lUsername.setFont(new Font("Tahoma", Font.BOLD, 35));

        btnFlight = new JButton("Flight");
        btnFlight.setBounds(lUsername.getX(), lUsername.getY() + lUsername.getHeight() + 150, 300, 300);
        ImageIcon logoFlight = new ImageIcon("src\\source\\Flight Icon.png");
        Image imgFlight = logoFlight.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        btnFlight.setBackground(new Color(41, 77, 126));
        btnFlight.setForeground(Color.white);
        btnFlight.addMouseListener(this);
        btnFlight.setIcon(new ImageIcon(imgFlight));
        btnFlight.setHorizontalTextPosition(JButton.CENTER);
        btnFlight.setVerticalTextPosition(JButton.BOTTOM);

        btnTrain = new JButton("Train");
        btnTrain.setBounds(btnFlight.getX() + btnFlight.getWidth() + 50, btnFlight.getY(), 300, 300);
        ImageIcon logoTrain = new ImageIcon("src\\source\\Train Icon.png");
        Image imgTrain = logoTrain.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        btnTrain.setBackground(new Color(42, 81, 114));
        btnTrain.setForeground(Color.white);
        btnTrain.addMouseListener(this);
        btnTrain.setIcon(new ImageIcon(imgTrain));
        btnTrain.setHorizontalTextPosition(JButton.CENTER);
        btnTrain.setVerticalTextPosition(JButton.BOTTOM);

        btnBus = new JButton("Bus");
        btnBus.setBounds(btnTrain.getX() + btnTrain.getWidth() + 50, btnFlight.getY(), 300, 300);
        ImageIcon logoBus = new ImageIcon("src\\source\\Bus Icon.png");
        Image imgBus = logoBus.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        btnBus.setBackground(new Color(42, 87, 108));
        btnBus.setForeground(Color.white);
        btnBus.addMouseListener(this);
        btnBus.setIcon(new ImageIcon(imgBus));
        btnBus.setHorizontalTextPosition(JButton.CENTER);
        btnBus.setVerticalTextPosition(JButton.BOTTOM);

        btnHotel = new JButton("Hotel");
        btnHotel.setBounds(btnBus.getX() + btnBus.getWidth() + 50, btnFlight.getY(), 300, 300);
        ImageIcon logoHotel = new ImageIcon("src\\source\\Hotel Icon.png");
        Image imgHotel = logoHotel.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        btnHotel.setBackground(new Color(43, 93, 94));
        btnHotel.setForeground(Color.white);
        btnHotel.addMouseListener(this);
        btnHotel.setIcon(new ImageIcon(imgHotel));
        btnHotel.setHorizontalTextPosition(JButton.CENTER);
        btnHotel.setVerticalTextPosition(JButton.BOTTOM);

        btnXtourience = new JButton("Xtourience");
        btnXtourience.setBounds((int) width - 1400, (int) height / 6, 70, 70);
        ImageIcon logoXtourience = new ImageIcon("src\\source\\Xtourience Icon.png");
        Image imgXtourince = logoXtourience.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        btnXtourience.setBackground(new Color(43, 93, 94));
        btnXtourience.setForeground(Color.white);
        btnXtourience.addMouseListener(this);
        btnXtourience.setFont(new Font("Plain", Font.PLAIN, 10));
        btnXtourience.setIcon(new ImageIcon(imgXtourince));
        btnXtourience.setHorizontalTextPosition(JButton.CENTER);
        btnXtourience.setVerticalTextPosition(JButton.BOTTOM);

        panelHome.add(lUsername);
        // panelHome.add(btnXtourience);
        panelHome.add(btnHotel);
        panelHome.add(btnBus);
        panelHome.add(btnTrain);
        panelHome.add(btnFlight);
        panelHome.add(lTitleHome);

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
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(false);
            panelProfile.setVisible(false);

            break;
        case "Flight":

            panelHome.setVisible(false);
            panelFlight.setVisible(true);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(false);
            panelProfile.setVisible(false);

            // Label Title
            lTitleFlight = new JLabel("FLIGHT");
            lTitleFlight.setForeground(Color.white);
            lTitleFlight.setFont(new Font("Tahoma", Font.BOLD, 26));
            lTitleFlight.setBounds((int) width / 2 - 200, (int) height / 60, 500, 50);

            // Label Departure
            lDeparture = new JLabel("Departure");
            lDeparture.setForeground(Color.white);
            lDeparture.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDeparture.setBounds((int) width - 1800, (int) height / 15, 500, 20);

            String[] showCityFlight = new String[cityFLight.size()];
            for (int i = 0; i < cityFLight.size(); i++) {
                showCityFlight[i] = cityFLight.get(i).getCity();
            }
            cbDeparture = new JComboBox<>(showCityFlight);
            cbDeparture.setBounds((int) width - 1800, (int) height / 10, 200, 20);

            // Label Destination
            lDestination = new JLabel("Destination");
            lDestination.setForeground(Color.white);
            lDestination.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDestination.setBounds((int) width - 1300, (int) height / 15, 500, 20);

            // Combobox Destination
            cbDestination = new JComboBox<>(showCityFlight);
            cbDestination.setBounds((int) width - 1300, (int) height / 10, 200, 20);

            // Label Date
            lDate = new JLabel("Choose Date");
            lDate.setForeground(Color.white);
            lDate.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDate.setBounds((int) width - 1800, (int) height / 6, 500, 20);

            // Jdate panel
            Properties p = new Properties();
            SqlDateModel model = new SqlDateModel();
            p.put("text.day", "Day");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
            date = new JDatePanelImpl(model, p);
            date.setBounds((int) width - 1800, (int) height / 5, 200, 200);

            // Label Class
            lSeatClass = new JLabel("Seat Class");
            lSeatClass.setForeground(Color.white);
            lSeatClass.setFont(new Font("Tahoma", Font.BOLD, 20));
            lSeatClass.setBounds((int) width - 1300, (int) height / 6, 500, 20);

            // Combo Box Seat Class
            cbSeatClass = new JComboBox<>(seatClass);
            cbSeatClass.setBounds((int) width - 1300, (int) height / 5, 200, 20);

            // Label Passengers
            lNoPassengers = new JLabel("No Passengers");
            lNoPassengers.setForeground(Color.white);
            lNoPassengers.setFont(new Font("Tahoma", Font.BOLD, 20));
            lNoPassengers.setBounds((int) width - 1300, (int) height / 4, 500, 20);

            // Combo Box Passengers
            cbPassengers = new JComboBox<>(number);
            cbPassengers.setBounds((int) width - 1300, (int) height / 4 + 50, 200, 20);

            // Button Search
            btnSearchFlight = new JButton("Search Flight");
            btnSearchFlight.setBounds((int) width - 1800, (int) height / 2, 230, 50);
            btnSearchFlight.setBackground(Color.orange);
            btnSearchFlight.addMouseListener(this);

            panelFlight.add(cbPassengers);
            panelFlight.add(lNoPassengers);
            panelFlight.add(btnSearchFlight);
            panelFlight.add(cbSeatClass);
            panelFlight.add(lSeatClass);
            panelFlight.add(date);
            panelFlight.add(lDate);
            panelFlight.add(cbDestination);
            panelFlight.add(lDestination);
            panelFlight.add(cbDeparture);
            panelFlight.add(lDeparture);
            panelFlight.add(lTitleFlight);
            break;
        case "Train":
            panelHome.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(true);
            panelBus.setVisible(false);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(false);
            panelProfile.setVisible(false);

            // Label Title
            lTitleTrain = new JLabel("TRAIN");
            lTitleTrain.setForeground(Color.white);
            lTitleTrain.setFont(new Font("Tahoma", Font.BOLD, 26));
            lTitleTrain.setBounds((int) width / 2 - 200, (int) height / 60, 500, 50);

            // Label Departure
            lDeparture = new JLabel("Departure");
            lDeparture.setForeground(Color.white);
            lDeparture.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDeparture.setBounds((int) width - 1800, (int) height / 15, 500, 20);

            // ComboBox Departure
            String[] showCityTrain = new String[cityTrain.size()];
            for (int i = 0; i < cityTrain.size(); i++) {
                showCityTrain[i] = cityTrain.get(i).getCity();
            }
            cbDeparture = new JComboBox<>(showCityTrain);
            cbDeparture.setBounds((int) width - 1800, (int) height / 10, 200, 20);

            // Label Destination
            lDestination = new JLabel("Destination");
            lDestination.setForeground(Color.white);
            lDestination.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDestination.setBounds((int) width - 1300, (int) height / 15, 500, 20);

            // Combobox Destination
            cbDestination = new JComboBox<>(showCityTrain);
            cbDestination.setBounds((int) width - 1300, (int) height / 10, 200, 20);

            // Label Date
            lDate = new JLabel("Choose Date");
            lDate.setForeground(Color.white);
            lDate.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDate.setBounds((int) width - 1800, (int) height / 6, 500, 20);

            // Jdate panel
            Properties p1 = new Properties();
            SqlDateModel model1 = new SqlDateModel();
            p1.put("text.day", "Day");
            p1.put("text.month", "Month");
            p1.put("text.year", "Year");
            date = new JDatePanelImpl(model1, p1);
            date.setBounds((int) width - 1800, (int) height / 5, 200, 200);

            // Label Passengers
            lNoPassengers = new JLabel("No Passengers");
            lNoPassengers.setForeground(Color.white);
            lNoPassengers.setFont(new Font("Tahoma", Font.BOLD, 20));
            lNoPassengers.setBounds((int) width - 1300, (int) height / 6, 500, 20);

            // Combo Box Passengers
            cbPassengers = new JComboBox<>(number);
            cbPassengers.setBounds((int) width - 1300, (int) height / 5, 200, 20);

            // Button Search
            btnSearchTrain = new JButton("Search Train");
            btnSearchTrain.setBounds((int) width - 1800, (int) height / 2, 230, 50);
            btnSearchTrain.setBackground(Color.orange);
            btnSearchTrain.addMouseListener(this);

            panelTrain.add(lTitleTrain);
            panelTrain.add(lDeparture);
            panelTrain.add(cbDeparture);
            panelTrain.add(lDestination);
            panelTrain.add(cbDestination);
            panelTrain.add(lDate);
            panelTrain.add(date);
            panelTrain.add(lNoPassengers);
            panelTrain.add(cbPassengers);
            panelTrain.add(btnSearchTrain);
            break;
        case "Bus":
            panelHome.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(true);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(false);
            panelProfile.setVisible(false);

            // Label Title
            lTitleBus = new JLabel("BUS");
            lTitleBus.setForeground(Color.white);
            lTitleBus.setFont(new Font("Tahoma", Font.BOLD, 26));
            lTitleBus.setBounds((int) width / 2 - 200, (int) height / 60, 500, 50);

            // Label Departure
            lDeparture = new JLabel("Departure");
            lDeparture.setForeground(Color.white);
            lDeparture.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDeparture.setBounds((int) width - 1800, (int) height / 15, 500, 20);

            // ComboBox Departure
            // cbDeparture = new JComboBox<>(country);
            cbDeparture.setBounds((int) width - 1800, (int) height / 10, 200, 20);

            // Label Destination
            lDestination = new JLabel("Destination");
            lDestination.setForeground(Color.white);
            lDestination.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDestination.setBounds((int) width - 1300, (int) height / 15, 500, 20);

            // Combobox Destination
            // cbDestination = new JComboBox<>(country);
            cbDestination.setBounds((int) width - 1300, (int) height / 10, 200, 20);

            // Label Date
            lDate = new JLabel("Choose Date");
            lDate.setForeground(Color.white);
            lDate.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDate.setBounds((int) width - 1800, (int) height / 6, 500, 20);

            // Jdate panel
            Properties p2 = new Properties();
            SqlDateModel model2 = new SqlDateModel();
            p2.put("text.day", "Day");
            p2.put("text.month", "Month");
            p2.put("text.year", "Year");
            date = new JDatePanelImpl(model2, p2);
            date.setBounds((int) width - 1800, (int) height / 5, 200, 200);

            // Label Passengers
            lNoPassengers = new JLabel("No Passengers");
            lNoPassengers.setForeground(Color.white);
            lNoPassengers.setFont(new Font("Tahoma", Font.BOLD, 20));
            lNoPassengers.setBounds((int) width - 1300, (int) height / 6, 500, 20);

            // Combo Box Passengers
            cbPassengers = new JComboBox<>(number);
            cbPassengers.setBounds((int) width - 1300, (int) height / 5, 200, 20);

            // Button Search
            btnSearchBus = new JButton("Search Bus");
            btnSearchBus.setBounds((int) width - 1800, (int) height / 2, 230, 50);
            btnSearchBus.setBackground(Color.orange);
            btnSearchBus.addMouseListener(this);

            panelBus.add(lTitleBus);
            panelBus.add(lDeparture);
            panelBus.add(cbDeparture);
            panelBus.add(lDestination);
            panelBus.add(cbDestination);
            panelBus.add(lDate);
            panelBus.add(date);
            panelBus.add(lNoPassengers);
            panelBus.add(cbPassengers);
            panelBus.add(btnSearchBus);
            break;
        case "Hotel":
            panelHome.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(true);
            panelXtourience.setVisible(false);
            panelProfile.setVisible(false);

            // Label Title
            lTitleHotel = new JLabel("HOTEL");
            lTitleHotel.setForeground(Color.white);
            lTitleHotel.setFont(new Font("Tahoma", Font.BOLD, 26));
            lTitleHotel.setBounds((int) width / 2 - 200, (int) height / 60, 500, 50);

            // Label City
            lCity = new JLabel("City");
            lCity.setForeground(Color.white);
            lCity.setFont(new Font("Tahoma", Font.BOLD, 20));
            lCity.setBounds((int) width - 1800, (int) height / 15, 500, 20);

            // Combo Box City
            cbCity = new JComboBox<>(City);
            cbCity.setBounds((int) width - 1800, (int) height / 10, 200, 20);

            // Label Date
            lDate = new JLabel("Choose Date");
            lDate.setForeground(Color.white);
            lDate.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDate.setBounds((int) width - 1800, (int) height / 6, 500, 20);

            // Jdate panel
            Properties p3 = new Properties();
            SqlDateModel model3 = new SqlDateModel();
            p3.put("text.day", "Day");
            p3.put("text.month", "Month");
            p3.put("text.year", "Year");
            date = new JDatePanelImpl(model3, p3);
            date.setBounds((int) width - 1800, (int) height / 5, 200, 200);

            // Label Passengers
            lNight = new JLabel("Duration");
            lNight.setForeground(Color.white);
            lNight.setFont(new Font("Tahoma", Font.BOLD, 20));
            lNight.setBounds((int) width - 1300, (int) height / 6, 500, 20);

            // Combo Box Duration
            cbPassengers = new JComboBox<>(number);
            cbPassengers.setBounds((int) width - 1300, (int) height / 5, 200, 20);

            btnSearchHotel = new JButton("Search Hotel");
            btnSearchHotel.setBounds((int) width - 1800, (int) height / 2, 230, 50);
            btnSearchHotel.setBackground(Color.orange);
            btnSearchHotel.addMouseListener(this);

            panelHotel.add(lNight);
            panelHotel.add(cbPassengers);
            panelHotel.add(lDate);
            panelHotel.add(date);
            panelHotel.add(lTitleHotel);
            panelHotel.add(lCity);
            panelHotel.add(cbCity);
            panelHotel.add(btnSearchHotel);
            break;

        // case "XTourience":
        // panelHome.setVisible(false);
        // panelFlight.setVisible(false);
        // panelTrain.setVisible(false);
        // panelBus.setVisible(false);
        // panelHotel.setVisible(false);
        // panelXtourience.setVisible(true);
        // panelProfile.setVisible(false);

        // // lable title
        // lTitleXtour = new JLabel("XTourience");
        // lTitleXtour.setForeground(Color.white);
        // lTitleXtour.setFont(new Font("Tahoma", Font.BOLD, 40));
        // lTitleXtour.setBounds((int) width / 2 - 200, (int) height / 60, 500, 50);

        // // label Moto
        // lMoto = new JLabel("Berkeliling Dunia bersama Travelokay");
        // lMoto.setForeground(Color.white);
        // lMoto.setFont(new Font("Tahoma", Font.ITALIC, 16));
        // lMoto.setBounds(lTitleXtour.getX() - 20, lTitleXtour.getY() +
        // lTitleXtour.getHeight() + 20, 500, 25);

        // // label city
        // lCity = new JLabel("Choose your destination");
        // lCity.setForeground(Color.white);
        // lCity.setFont(new Font("Tahoma", Font.BOLD, 20));
        // lCity.setBounds(panelMenu.getWidth() - 120, lMoto.getY() + lMoto.getHeight()
        // + 80, 500, 20);

        // // cb City
        // cbCityXtour = new JComboBox<>(City);
        // cbCityXtour.setBounds(lCity.getX(), lCity.getY() + lCity.getHeight() + 30,
        // 200, 35);

        // btnSearchXtour = new JButton("Search City");
        // btnSearchXtour.setFont(new Font("Tahoma", Font.BOLD, 20));
        // btnSearchXtour.setBounds(panelMenu.getWidth() - 120, panelMenu.getHeight() -
        // 200, 230, 50);
        // btnSearchXtour.setForeground(Color.white);
        // btnSearchXtour.setBackground(new Color(100, 88, 110));
        // btnSearchXtour.addMouseListener(this);

        // panelXtourience.add(lTitleXtour);
        // panelXtourience.add(lMoto);
        // panelXtourience.add(lCity);
        // panelXtourience.add(cbCityXtour);
        // panelXtourience.add(btnSearchXtour);
        // break;

        case "Profile":
            panelHome.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(false);
            panelProfile.setVisible(true);

            lProfile = new JLabel("Profile");
            lProfile.setForeground(Color.white);
            lProfile.setFont(new Font("Tahoma", Font.BOLD, 26));
            lProfile.setBounds((int) width - 1500, (int) height / 60, 500, 50);

            lFullName = new JLabel("Full Name :");
            lFullName.setForeground(Color.white);
            lFullName.setFont(new Font("Tahoma", Font.BOLD, 17));
            lFullName.setBounds((int) width - 1800, (int) height / 15, 500, 50);

            tfFullName = new JTextField();
            tfFullName.setBounds((int) width - 1690, (int) height / 13, 300, 30);

            lUsername = new JLabel("Username :");
            lUsername.setForeground(Color.white);
            lUsername.setFont(new Font("Tahoma", Font.BOLD, 17));
            lUsername.setBounds((int) width - 1800, (int) height / 8, 500, 50);

            tfUsername = new JTextField();
            tfUsername.setBounds((int) width - 1690, (int) height / 7 - 10, 300, 30);

            lAddress = new JLabel("Address :");
            lAddress.setForeground(Color.white);
            lAddress.setFont(new Font("Tahoma", Font.BOLD, 17));
            lAddress.setBounds((int) width - 1800, (int) height / 7 + 45, 500, 50);

            taAddress = new JTextArea();
            taAddress.setBounds((int) width - 1700, (int) height / 5 - 5, 300, 50);

            lEmail = new JLabel("Email : ");
            lEmail.setForeground(Color.white);
            lEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
            lEmail.setBounds((int) width - 1800, (int) height / 5 + 60, 500, 50);

            tfEmail = new JTextField();
            tfEmail.setBounds((int) width - 1720, (int) height / 5 + 70, 300, 30);

            lPassword = new JLabel("Password : ");
            lPassword.setForeground(Color.white);
            lPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
            lPassword.setBounds((int) width - 1800, (int) height / 4 + 70, 500, 50);

            pfPassword = new JPasswordField();
            pfPassword.setBounds((int) width - 1700, (int) height / 4 + 80, 300, 30);

            btnSave = new JButton("Save");
            btnSave.setBounds((int) width - 1800, (int) height / 3 + 70, 200, 50);
            btnSave.setBackground(Color.orange);

            panelProfile.add(btnSave);
            panelProfile.add(pfPassword);
            panelProfile.add(lPassword);
            panelProfile.add(tfEmail);
            panelProfile.add(lEmail);
            panelProfile.add(taAddress);
            panelProfile.add(lAddress);
            panelProfile.add(tfUsername);
            panelProfile.add(lUsername);
            panelProfile.add(tfFullName);
            panelProfile.add(lFullName);
            panelProfile.add(lProfile);
            break;

        case "Log Out":
            panelHome.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(false);
            panelProfile.setVisible(false);
            new LoginForm();
            break;
        case "Search Flight":
            new ShowFlight();
            fMainMenu.dispose();
            break;
        case "Search Train":
            new ShowFlight();
            fMainMenu.dispose();
            break;
        case "Search Bus":
            new ShowFlight();
            fMainMenu.dispose();
            break;
        case "Search Hotel":
            new ShowFlight();
            fMainMenu.dispose();
            break;
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
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
