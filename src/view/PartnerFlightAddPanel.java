package view;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.QueryController;
import controller.SingletonManager;
import model.Flight;
import model.TripTypesEnum;
import model.Vehicle;

public class PartnerFlightAddPanel extends JPanel implements ActionListener {
    
    // Declaring variable
    JLabel lTitle, lTitle2, lAirplane, lDeparture, lDestination, lFlightNumber, lDepartureTime, lArrivalTime, lDepartureDate, lArrivalDate, lTravelTime, lFlightType;
    QueryController queryController;
    JPanel container;
    JComboBox<String> cbAirplane, cbDeparture, cbDestination;
    UtilDateModel dateModel;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePickerDeparture, datePickerArrival;
    JTextField tfFlightNumber, tfDepartureTime, tfArrivalTime, tfTravelTime, tfFlightType;
    JButton btnAdd;
    ArrayList<Vehicle> airplaneList;
    ArrayList<String> airportCodeList;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public PartnerFlightAddPanel() {

        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Add Flight");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);
        
        container = new RoundedPanel(20, ConstColor.PURPLE2);
        container.setBounds(20, 100, width-270, height-200);
        container.setLayout(null);
        container.setOpaque(false);
        
        lTitle2 = new JLabel("Add New Flight Data");
        lTitle2.setForeground(ConstColor.WHITE);
        lTitle2.setFont(new Font("Arial", Font.BOLD, 20));
        lTitle2.setBounds(20, 20, 450, 40);

        lAirplane = new JLabel("Airplane");
        lAirplane.setForeground(ConstColor.WHITE);
        lAirplane.setFont(new Font("Arial", Font.PLAIN, 16));
        lAirplane.setBounds(lTitle2.getX(), lTitle2.getY() + lTitle2.getHeight() + 20, 200, 40);

        airplaneList = queryController.selectAirplanesModel(SingletonManager.getInstance().getPartner().getCompanyName());
        String[] airplaneListName = new String[airplaneList.size()];
        for (int i = 0; i < airplaneList.size(); i++) {
            airplaneListName[i] = airplaneList.get(i).getModel();
        }
        cbAirplane = new JComboBox<>(airplaneListName);
        cbAirplane.setBounds(lAirplane.getX(), lAirplane.getY() + lAirplane.getHeight() + 20, 200, 40);

        lDeparture = new JLabel("Departure");
        lDeparture.setForeground(ConstColor.WHITE);
        lDeparture.setFont(new Font("Arial", Font.PLAIN, 16));
        lDeparture.setBounds(lAirplane.getX() + lAirplane.getWidth() + 40, lAirplane.getY(), 200, 40);

        airportCodeList = queryController.selectAirportCode();
        String[] airportCode = new String[airportCodeList.size()];
        for (int i = 0; i < airportCodeList.size(); i++) {
            airportCode[i] = airportCodeList.get(i);
        }
        cbDeparture = new JComboBox<>(airportCode);
        cbDeparture.setBounds(lDeparture.getX(), cbAirplane.getY(), 200, 40);

        lDestination = new JLabel("Destination");
        lDestination.setForeground(ConstColor.WHITE);
        lDestination.setFont(new Font("Arial", Font.PLAIN, 16));
        lDestination.setBounds(lDeparture.getX() + lDeparture.getWidth() + 40, lDeparture.getY(), 200, 40);

        cbDestination = new JComboBox<>(airportCode);
        cbDestination.setBounds(lDestination.getX(), cbDeparture.getY(), 200, 40);

        lFlightType = new JLabel("Flight Type");
        lFlightType.setForeground(ConstColor.WHITE);
        lFlightType.setFont(new Font("Arial", Font.PLAIN, 16));
        lFlightType.setBounds(lDestination.getX() + lDestination.getWidth() + 40, lDestination.getY(), 200, 40);

        tfFlightType = new JTextField();
        tfFlightType.setBackground(ConstColor.PURPLE3);
        tfFlightType.setForeground(ConstColor.WHITE);
        tfFlightType.setBounds(lFlightType.getX(), lFlightType.getY() + lFlightType.getHeight() + 20, 200, 40);
        tfFlightType.setMargin(new Insets(0, 10, 0, 0));

        lFlightNumber = new JLabel("Flight Number");
        lFlightNumber.setForeground(ConstColor.WHITE);
        lFlightNumber.setFont(new Font("Arial", Font.PLAIN, 16));
        lFlightNumber.setBounds(lAirplane.getX(), cbAirplane.getY() + cbAirplane.getHeight() + 40, 200, 20);

        tfFlightNumber = new JTextField();
        tfFlightNumber.setBackground(ConstColor.PURPLE3);
        tfFlightNumber.setForeground(ConstColor.WHITE);
        tfFlightNumber.setBounds(lFlightNumber.getX(), lFlightNumber.getY() + lFlightNumber.getHeight() + 20, 200, 40);
        tfFlightNumber.setMargin(new Insets(0, 10, 0, 0));

        lDepartureTime = new JLabel("Departure Time");
        lDepartureTime.setForeground(ConstColor.WHITE);
        lDepartureTime.setFont(new Font("Arial", Font.PLAIN, 16));
        lDepartureTime.setBounds(lDeparture.getX(), lFlightNumber.getY(), 200, 20);

        tfDepartureTime = new JTextField();
        tfDepartureTime.setBackground(ConstColor.PURPLE3);
        tfDepartureTime.setForeground(ConstColor.WHITE);
        tfDepartureTime.setBounds(lDepartureTime.getX(), tfFlightNumber.getY(), 200, 40);
        tfDepartureTime.setMargin(new Insets(0, 10, 0, 0));

        lArrivalTime = new JLabel("Arrival Time");
        lArrivalTime.setForeground(ConstColor.WHITE);
        lArrivalTime.setFont(new Font("Arial", Font.PLAIN, 16));
        lArrivalTime.setBounds(lDestination.getX(), lDepartureTime.getY(), 200, 20);

        tfArrivalTime = new JTextField();
        tfArrivalTime.setBackground(ConstColor.PURPLE3);
        tfArrivalTime.setForeground(ConstColor.WHITE);
        tfArrivalTime.setBounds(lArrivalTime.getX(), tfDepartureTime.getY(), 200, 40);
        tfArrivalTime.setMargin(new Insets(0, 10, 0, 0));

        lDepartureDate = new JLabel("Departure Date");
        lDepartureDate.setForeground(ConstColor.WHITE);
        lDepartureDate.setFont(new Font("Arial", Font.PLAIN, 16));
        lDepartureDate.setBounds(lFlightNumber.getX(), tfFlightNumber.getY() + tfFlightNumber.getHeight() + 40, 200, 20);

        dateModel = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(dateModel, p);
        datePickerDeparture = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePickerDeparture.setBounds(lDepartureDate.getX(), lDepartureDate.getY() + lDepartureDate.getHeight() + 20, 200, 40);

        lArrivalDate = new JLabel("Arrival Date");
        lArrivalDate.setForeground(ConstColor.WHITE);
        lArrivalDate.setFont(new Font("Arial", Font.PLAIN, 16));
        lArrivalDate.setBounds(lDepartureTime.getX(), lDepartureDate.getY(), 200, 20);

        dateModel = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        datePanel = new JDatePanelImpl(dateModel, p2);
        datePickerArrival = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePickerArrival.setBounds(lArrivalDate.getX(), datePickerDeparture.getY(), 200, 40);

        lTravelTime = new JLabel("Travel Time");
        lTravelTime.setForeground(ConstColor.WHITE);
        lTravelTime.setFont(new Font("Arial", Font.PLAIN, 16));
        lTravelTime.setBounds(lArrivalTime.getX(), lArrivalDate.getY(), 200, 20);

        tfTravelTime = new JTextField();
        tfTravelTime.setBackground(ConstColor.PURPLE3);
        tfTravelTime.setForeground(ConstColor.WHITE);
        tfTravelTime.setBounds(lTravelTime.getX(), datePickerArrival.getY(), 200, 40);
        tfTravelTime.setMargin(new Insets(0, 10, 0, 0));

        btnAdd = new JButton("Add Data");
        btnAdd.setBounds(lTitle2.getX(), container.getHeight() - 70, 200, 40);
        btnAdd.setBackground(ConstColor.PURPLE4);
        btnAdd.setForeground(ConstColor.WHITE);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 20));
        btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAdd.addActionListener(this);

        // Adding components
        this.add(lTitle);

        container.add(lTitle2);
        container.add(lAirplane);
        container.add(cbAirplane);
        container.add(lDeparture);
        container.add(cbDeparture);
        container.add(lDestination);
        container.add(cbDestination);
        container.add(lFlightNumber);
        container.add(tfFlightNumber);
        container.add(lDepartureTime);
        container.add(tfDepartureTime);
        container.add(lArrivalTime);
        container.add(tfArrivalTime);
        container.add(lDepartureDate);
        container.add(datePickerDeparture);
        container.add(lArrivalDate);
        container.add(datePickerArrival);
        container.add(lTravelTime);
        container.add(tfTravelTime);
        container.add(lFlightType);
        container.add(tfFlightType);
        container.add(btnAdd);
        
        this.add(container);

        // Set vicibility
        this.setVisible(true);
    }

    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException
        {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException
        {
            if (value != null)
            {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Get value
        String airplaneModel = cbAirplane.getSelectedItem().toString();
        String departureAirport = cbDeparture.getSelectedItem().toString();
        String destinationAirport = cbDestination.getSelectedItem().toString();
        String flightType = tfFlightType.getText();

        String flightNumber = tfFlightNumber.getText();
        String departureTime = tfDepartureTime.getText();
        String arrivalTime = tfArrivalTime.getText();
        
        String departureDate = datePickerDeparture.getJFormattedTextField().getText();
        String arrivalDate = datePickerArrival.getJFormattedTextField().getText();
        String travelTime = tfTravelTime.getText();

        boolean empty = flightNumber.equals("") || departureTime.equals("") || departureTime.equals("") ||
        arrivalTime.equals("") || travelTime.equals("") ||
        departureDate.equals(null) || arrivalDate.equals(null);
        
        if (empty) {
            JOptionPane.showMessageDialog(null, "Please fill all field !");
        } else {
            
            Flight flight = new Flight();
            flight.setFlightType(flightType);
            flight.setFlightNumber(flightNumber);
            flight.setDepartureTime(departureTime);
            flight.setArrivalTime(arrivalTime);
            flight.setDepartureDate(departureDate);
            flight.setArrivalDate(arrivalDate);
            flight.setTripTime(Integer.parseInt(travelTime));

            int airplaneID = 0;
            for (int i = 0; i < airplaneList.size(); i++) {
                if(airplaneList.get(i).getModel().equals(airplaneModel)) {
                    airplaneID = airplaneList.get(i).getVehicleID();
                }
            }

            int departureAirportID = 0;
            for (int i = 0; i < airportCodeList.size(); i++) {
                if(airportCodeList.get(i).equals(departureAirport)) {
                    departureAirportID = queryController.getAiportIDByCode(airportCodeList.get(i));
                }
            }

            int destinationAirportID = 0;
            for (int i = 0; i < airportCodeList.size(); i++) {
                if(airportCodeList.get(i).equals(destinationAirport)) {
                    destinationAirportID = queryController.getAiportIDByCode(airportCodeList.get(i));
                }
            }

            boolean success = queryController.insertNewFlight(airplaneID, departureAirportID, destinationAirportID, flight);
            if (success) {
                JOptionPane.showMessageDialog(null, "Add New Flight Success");
            } else {
                JOptionPane.showMessageDialog(null, "Add New Flight Failed");
            }
        }
    }
}
