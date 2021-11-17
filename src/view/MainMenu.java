package view;

import java.awt.event.MouseEvent;
import java.util.Properties;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import org.jdatepicker.impl.*;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.Toolkit;

public class MainMenu implements MouseInputListener {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    JFrame fMainMenu;
    JPanel panelMenu, panelHome, panelProfile, panelFlight, panelTrain, panelBus, panelHotel, panelXtourience;
    JButton btnHome, btnProfile, btnFlight, btnTrain, btnBus, btnHotel, btnXtourience, btnLogOut, btnSearch;
    JLabel lCity,lTitleHotel,lTitleFlight, lDeparture, lDestination, lDate, lSeatClass, lNoPassengers, lTitleTrain, lTitleBus;
    JComboBox cbDeparture, cbDestination, cbSeatClass, cbPassengers,cbCity;
    JDatePanelImpl jdPick;
    String country[] = { "Surabaya", "Bandung", "Singapore", "Bali", "Raja Ampat" };
    String seatClass[] = { "Economy", "Business", "First Class" };
    String number[] = { "1", "2", "3", "4", "5", "6", "7" };
    String City[] = { "Solo", "Bandung", "Jakarta", "Bali", "Yogyakarta"};
    JDatePanelImpl date;

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

        // Button Profile
        btnProfile = new JButton("Profile");
        btnProfile.setBounds(0, btnHome.getVerticalAlignment() + 830, 195, 50);
        btnProfile.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnProfile.setBackground(new Color(100, 88, 110));
        btnProfile.setForeground(Color.white);
        btnProfile.addMouseListener(this);
        btnProfile.setHorizontalAlignment(SwingConstants.LEFT);

        // Button LogOut
        btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(0, btnHome.getVerticalAlignment() + 885, 195, 50);
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnLogOut.setBackground(new Color(100, 88, 110));
        btnLogOut.setForeground(new Color(255, 55, 58));
        btnLogOut.addMouseListener(this);
        btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);

        // Panel Pesawat
        panelFlight = new JPanel();
        panelFlight.setBackground(new Color(40, 25, 54));
        panelFlight.setBounds((int) width / 10, 0, (int) width - 100, (int) height - 100);
        panelFlight.setLayout(null);

        // Panel Train
        panelTrain = new JPanel();
        panelTrain.setBackground(new Color(40, 25, 54));
        panelTrain.setBounds((int) width / 10, 0, (int) width - 100, (int) height - 100);
        panelTrain.setLayout(null);

        // Panel Bus
        panelBus = new JPanel();
        panelBus.setBackground(new Color(40, 25, 54));
        panelBus.setBounds((int) width / 10, 0, (int) width - 100, (int) height - 100);
        panelBus.setLayout(null);

        // Panel Hotel
        panelHotel = new JPanel();
        panelHotel.setBackground(new Color(40, 25, 54));
        panelHotel.setBounds((int) width / 10, 0, (int) width - 100, (int) height - 100);
        panelHotel.setLayout(null);

        // Panel Xtourience
        panelXtourience = new JPanel();
        panelXtourience.setBackground(Color.black);
        panelXtourience.setBounds((int) width / 10, 0, (int) width - 100, (int) height - 100);
        panelXtourience.setLayout(null);

        // Panel Profile
        panelProfile = new JPanel();
        panelProfile.setBackground(Color.LIGHT_GRAY);
        panelProfile.setBounds((int) width / 10, 0, (int) width - 100, (int) height - 100);
        panelProfile.setLayout(null);

        panelHome.setVisible(true);
        panelMenu.add(btnXtourience);
        panelMenu.add(btnHotel);
        panelMenu.add(btnBus);
        panelMenu.add(btnTrain);
        panelMenu.add(btnFlight);
        panelMenu.add(btnHome);
        panelMenu.add(btnHotel);
        panelMenu.add(btnProfile);
        panelMenu.add(btnLogOut);
        fMainMenu.add(panelProfile);
        fMainMenu.add(panelMenu);
        fMainMenu.add(panelHome);
        fMainMenu.add(panelFlight);
        fMainMenu.add(panelTrain);
        fMainMenu.add(panelBus);
        fMainMenu.add(panelHotel);
        fMainMenu.add(panelXtourience);

        
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
            lTitleFlight.setBounds((int) width - 1500, (int) height / 60, 500, 50);

            // Label Departure
            lDeparture = new JLabel("Departure");
            lDeparture.setForeground(Color.white);
            lDeparture.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDeparture.setBounds((int) width - 1800, (int) height / 15, 500, 20);

            cbDeparture = new JComboBox<>(country);
            cbDeparture.setBounds((int) width - 1800, (int) height / 10, 200, 20);

            // Label Destination
            lDestination = new JLabel("Destination");
            lDestination.setForeground(Color.white);
            lDestination.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDestination.setBounds((int) width - 1300, (int) height / 15, 500, 20);

            // Combobox Destination
            cbDestination = new JComboBox<>(country);
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
            JDatePanelImpl date = new JDatePanelImpl(model, p);
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
            btnSearch = new JButton("Search");
            btnSearch.setBounds((int) width - 1800, (int) height / 2, 230, 50);
            btnSearch.setBackground(Color.orange);

            panelFlight.add(cbPassengers);
            panelFlight.add(lNoPassengers);
            panelFlight.add(btnSearch);
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
            lTitleTrain.setBounds((int) width - 1500, (int) height / 60, 500, 50);

            // Label Departure
            lDeparture = new JLabel("Departure");
            lDeparture.setForeground(Color.white);
            lDeparture.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDeparture.setBounds((int) width - 1800, (int) height / 15, 500, 20);

            // ComboBox Departure
            cbDeparture = new JComboBox<>(country);
            cbDeparture.setBounds((int) width - 1800, (int) height / 10, 200, 20);

            // Label Destination
            lDestination = new JLabel("Destination");
            lDestination.setForeground(Color.white);
            lDestination.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDestination.setBounds((int) width - 1300, (int) height / 15, 500, 20);

            // Combobox Destination
            cbDestination = new JComboBox<>(country);
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
            btnSearch = new JButton("Search");
            btnSearch.setBounds((int) width - 1800, (int) height / 2, 230, 50);
            btnSearch.setBackground(Color.orange);

            panelTrain.add(lTitleTrain);
            panelTrain.add(lDeparture);
            panelTrain.add(cbDeparture);
            panelTrain.add(lDestination);
            panelTrain.add(cbDestination);
            panelTrain.add(lDate);
            panelTrain.add(date);
            panelTrain.add(lNoPassengers);
            panelTrain.add(cbPassengers);
            panelTrain.add(btnSearch);
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
            lTitleBus.setBounds((int) width - 1500, (int) height / 60, 500, 50);

            // Label Departure
            lDeparture = new JLabel("Departure");
            lDeparture.setForeground(Color.white);
            lDeparture.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDeparture.setBounds((int) width - 1800, (int) height / 15, 500, 20);

            // ComboBox Departure
            cbDeparture = new JComboBox<>(country);
            cbDeparture.setBounds((int) width - 1800, (int) height / 10, 200, 20);

            // Label Destination
            lDestination = new JLabel("Destination");
            lDestination.setForeground(Color.white);
            lDestination.setFont(new Font("Tahoma", Font.BOLD, 20));
            lDestination.setBounds((int) width - 1300, (int) height / 15, 500, 20);

            // Combobox Destination
            cbDestination = new JComboBox<>(country);
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
            btnSearch = new JButton("Search");
            btnSearch.setBounds((int) width - 1800, (int) height / 2, 230, 50);
            btnSearch.setBackground(Color.orange);

            panelBus.add(lTitleBus);
            panelBus.add(lDeparture);
            panelBus.add(cbDeparture);
            panelBus.add(lDestination);
            panelBus.add(cbDestination);
            panelBus.add(lDate);
            panelBus.add(date);
            panelBus.add(lNoPassengers);
            panelBus.add(cbPassengers);
            panelBus.add(btnSearch);
            break;
        case "Hotel":
            panelHome.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(true);
            panelXtourience.setVisible(false);
            panelProfile.setVisible(false);

            //Label Title
            lTitleHotel = new JLabel("HOTEL");
            lTitleHotel.setForeground(Color.white);
            lTitleHotel.setFont(new Font("Tahoma", Font.BOLD, 26));
            lTitleHotel.setBounds((int) width - 1500, (int) height / 60, 500, 50);

            //Label City
            lCity = new JLabel("City");
            lCity.setForeground(Color.white);
            lCity.setFont(new Font("Tahoma", Font.BOLD, 20));
            lCity.setBounds((int) width - 1800, (int) height / 15, 500, 20);

            //Combo Box City
            cbCity = new JComboBox<>(City);
            cbCity.setBounds((int) width - 1800, (int) height / 10, 200, 20);

            panelHotel.add(lTitleHotel);
            panelHotel.add(lCity);
            panelHotel.add(cbCity);
            break;
        case "Xtourience":
            panelHome.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(true);
            panelProfile.setVisible(false);

            break;
        case "Profile":

            panelHome.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(false);
            panelProfile.setVisible(true);
            break;
        case "Log Out":

            panelHome.setVisible(false);
            panelFlight.setVisible(false);
            panelTrain.setVisible(false);
            panelBus.setVisible(false);
            panelHotel.setVisible(false);
            panelXtourience.setVisible(false);
            panelProfile.setVisible(false);
            JOptionPane.showMessageDialog(null, "LOGOUT");
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
