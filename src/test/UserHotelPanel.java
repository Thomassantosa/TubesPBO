package test;

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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.QueryController;

public class UserHotelPanel extends JPanel implements ActionListener {
    
    // Declaring variable
    JLabel lTitle, lOrder, lCity, lDateCheckin, lDateCheckout, lNoGuest;
    QueryController queryController;
    JPanel container;
    JComboBox<String> cbCity;
    UtilDateModel dateModel, dateModel2;
    JDatePanelImpl datePanel, datePanel2;
    JDatePickerImpl datePickerCheckin, datePickerCheckout;
    JTextField tfNoPassengers;
    JButton btnSearch;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public UserHotelPanel() {

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

        lOrder = new JLabel("Order ticket");
        lOrder.setForeground(ConstColor.WHITE);
        lOrder.setFont(new Font("Arial", Font.BOLD, 20));
        lOrder.setBounds(20, 20, 450, 40);

        lCity = new JLabel("City");
        lCity.setForeground(ConstColor.WHITE);
        lCity.setFont(new Font("Arial", Font.PLAIN, 16));
        lCity.setBounds(lOrder.getX(), lOrder.getY() + 80, 200, 20);

        ArrayList<String> cityList = queryController.selectHotelCity();
        String[] cityListName = new String[cityList.size()];
        for (int i = 0; i < cityList.size(); i++) {
            cityListName[i] = cityList.get(i);
        }
        cbCity = new JComboBox<>(cityListName);
        cbCity.setBounds(lCity.getX(), lCity.getY() + 30, 200, 40);

        lDateCheckin = new JLabel("Check-in");
        lDateCheckin.setForeground(ConstColor.WHITE);
        lDateCheckin.setFont(new Font("Arial", Font.PLAIN, 16));
        lDateCheckin.setBounds(lCity.getX(), cbCity.getY() + 80, 200, 20);

        dateModel = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(dateModel, p);
        datePickerCheckin = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePickerCheckin.setBounds(lDateCheckin.getX(), lDateCheckin.getY() + 30, 200, 40);

        lDateCheckout = new JLabel("Check-out");
        lDateCheckout.setForeground(ConstColor.WHITE);
        lDateCheckout.setFont(new Font("Arial", Font.PLAIN, 16));
        lDateCheckout.setBounds(lDateCheckin.getX() + lDateCheckin.getWidth() + 40, lDateCheckin.getY(), 200, 20);

        dateModel2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        datePanel2 = new JDatePanelImpl(dateModel2, p2);
        datePickerCheckout = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        datePickerCheckout.setBounds(lDateCheckout.getX(), datePickerCheckin.getY(), 200, 40);
        
        lNoGuest = new JLabel("No Guest");
        lNoGuest.setForeground(ConstColor.WHITE);
        lNoGuest.setFont(new Font("Arial", Font.PLAIN, 16));
        lNoGuest.setBounds(lDateCheckin.getX(), datePickerCheckin.getY() + 80, 200, 20);

        tfNoPassengers = new JTextField();
        tfNoPassengers.setForeground(ConstColor.WHITE);
        tfNoPassengers.setBackground(ConstColor.PURPLE3);
        tfNoPassengers.setBounds(lNoGuest.getX(), lNoGuest.getY() + 30, 200, 40);
        tfNoPassengers.setMargin(new Insets(0, 10, 0, 0));

        btnSearch = new JButton("Search");
        btnSearch.setBounds(lNoGuest.getX(), container.getHeight() - 100, 200, 40);
        btnSearch.setBackground(ConstColor.PURPLE4);
        btnSearch.setForeground(ConstColor.WHITE);
        btnSearch.setFont(new Font("Arial", Font.PLAIN, 20));
        btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSearch.addActionListener(this);

        // Adding components
        this.add(lTitle);

        container.add(lOrder);
        container.add(lCity);
        container.add(cbCity);
        container.add(lDateCheckin);
        container.add(datePickerCheckin);
        container.add(lDateCheckout);
        container.add(datePickerCheckout);
        container.add(lNoGuest);
        container.add(tfNoPassengers);
        container.add(btnSearch);
        this.add(container);

        // Set vicibility
        this.setVisible(true);
        // Adding components
        this.add(lTitle);

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
        String city = cbCity.getSelectedItem().toString();
        String noPassenger = tfNoPassengers.getText();
        String checkin = datePickerCheckin.getJFormattedTextField().getText();
        String checkout = datePickerCheckout.getJFormattedTextField().getText();

        if (noPassenger.equals("") || checkin.equals(null) || checkout.equals(null)) {
            JOptionPane.showMessageDialog(null, "Please fill all field !");
        } else {
            // JOptionPane.showMessageDialog(null, "ON PROGRESS");
            MainFrame.setSearchHotel(city, noPassenger, checkin, checkout);
            MainFrame.cardLayout.show(MainFrame.cardPanelUser, "searchHotelPanel");
        }
    }
}
