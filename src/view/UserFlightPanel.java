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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.QueryController;

public class UserFlightPanel extends JPanel implements ActionListener {
    
    // Declaring variable
    JLabel lTitle, lOrder, lDeparture, lDestination, lDate, lSeatClass;
    QueryController queryController;
    JPanel container;
    JComboBox<String> cbDeparture, cbDestination, cbSeatClass;
    UtilDateModel dateModel;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePickerDeparture;
    JButton btnSearch;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public UserFlightPanel() {

        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Flight Menu");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);
        
        container = new RoundedPanel(20, ConstColor.PURPLE2);
        container.setBounds(20, 100, width-270, height-200);
        container.setLayout(null);
        container.setOpaque(false);
        
        lOrder = new JLabel("Order ticket");
        lOrder.setForeground(ConstColor.WHITE);
        lOrder.setFont(new Font("Arial", Font.BOLD, 20));
        lOrder.setBounds(20, 20, 450, 40);

        lDeparture = new JLabel("Departure");
        lDeparture.setForeground(ConstColor.WHITE);
        lDeparture.setFont(new Font("Arial", Font.PLAIN, 16));
        lDeparture.setBounds(lOrder.getX(), lOrder.getY() + 80, 200, 20);

        ArrayList<String> cityList = queryController.selectAirportCity();
        String[] cityListName = new String[cityList.size()];
        for (int i = 0; i < cityList.size(); i++) {
            cityListName[i] = cityList.get(i);
        }
        cbDeparture = new JComboBox<>(cityListName);
        cbDeparture.setBounds(lDeparture.getX(), lDeparture.getY() + 30, 200, 40);

        lDestination = new JLabel("Destination");
        lDestination.setForeground(ConstColor.WHITE);
        lDestination.setFont(new Font("Arial", Font.PLAIN, 16));
        lDestination.setBounds(lDeparture.getX() + lDeparture.getWidth() + 40, lDeparture.getY(), 200, 20);

        cbDestination = new JComboBox<>(cityListName);
        cbDestination.setBounds(lDestination.getX(), lDestination.getY() + 30, 200, 40);

        lDate = new JLabel("Departure Date");
        lDate.setForeground(ConstColor.WHITE);
        lDate.setFont(new Font("Arial", Font.PLAIN, 16));
        lDate.setBounds(lDeparture.getX(), cbDeparture.getY() + 80, 200, 20);

        dateModel = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(dateModel, p);
        datePickerDeparture = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePickerDeparture.setBounds(lDate.getX(), lDate.getY() + 30, 200, 40);

        lSeatClass = new JLabel("Seat Class");
        lSeatClass.setForeground(ConstColor.WHITE);
        lSeatClass.setFont(new Font("Arial", Font.PLAIN, 16));
        lSeatClass.setBounds(cbDestination.getX() + cbDestination.getWidth() + 40, lDestination.getY(), 200, 20);

        ArrayList<String> seatList = queryController.selectSeatName();
        String[] seatClassName = new String[seatList.size()];
        for (int i = 0; i < seatList.size(); i++) {
            seatClassName[i] = seatList.get(i);
        }
        cbSeatClass = new JComboBox<>(seatClassName);
        cbSeatClass.setBounds(lSeatClass.getX(), cbDestination.getY(), 200, 40);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(lOrder.getX(), container.getHeight() - 200, 200, 40);
        btnSearch.setBackground(ConstColor.PURPLE4);
        btnSearch.setForeground(ConstColor.WHITE);
        btnSearch.setFont(new Font("Arial", Font.PLAIN, 20));
        btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSearch.addActionListener(this);

        // Adding components
        this.add(lTitle);

        container.add(lOrder);
        container.add(lDeparture);
        container.add(cbDeparture);
        container.add(lDestination);
        container.add(cbDestination);
        container.add(lDate);
        container.add(datePickerDeparture);
        container.add(lSeatClass);
        container.add(cbSeatClass);
        container.add(btnSearch);
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
        String departureCity = cbDeparture.getSelectedItem().toString();
        String destinationCity = cbDestination.getSelectedItem().toString();
        String departureDate = datePickerDeparture.getJFormattedTextField().getText();
        String seatClass = cbSeatClass.getSelectedItem().toString();

        if (departureDate.equals(null)) {
            JOptionPane.showMessageDialog(null, "Please fill all field !");
        } else {
            System.out.println(departureDate.toString());
            MainFrame.setSearchFlight(departureCity, destinationCity, departureDate, seatClass);
            MainFrame.cardLayout.show(MainFrame.cardPanelUser, "searchFlightPanel");
        }
    }
}
