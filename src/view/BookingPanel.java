package view;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.QueryController;
import controller.SingletonManager;
import model.Order;
import model.TripTypesEnum;

public class BookingPanel extends JPanel implements ActionListener {
    
    // Declaring variable
    JLabel lTitle, lContact, lContactInfo, lFullname, lEmail, lPhone, lPrice, lTransaction, lPayment;
    JTextField tfFullname, tfEmail, tfPhone;
    JButton btnBooking, btnBack;
    JPanel container;
    JComboBox<String> cbPayment;
    QueryController queryController;

    int id;
    TripTypesEnum type;
    int price;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();


    public BookingPanel() {
    }

    public BookingPanel(int id, TripTypesEnum type, int price) {

        queryController = new QueryController();
        
        setValueToGlobal(id, type, price);

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Booking Menu");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);
        
        container = new RoundedPanel(20, ConstColor.PURPLE2);
        container.setBounds(20, 100, width-270, height-200);
        container.setLayout(null);
        container.setOpaque(false);
        
        lContact = new JLabel("Contact Details");
        lContact.setForeground(ConstColor.WHITE);
        lContact.setFont(new Font("Arial", Font.BOLD, 20));
        lContact.setBounds(20, 20, 200, 20);

        lContactInfo = new JLabel("(for E-Ticket/Voucher)");
        lContactInfo.setForeground(ConstColor.WHITE);
        lContactInfo.setFont(new Font("Arial", Font.PLAIN, 12));
        lContactInfo.setBounds(lContact.getX(), lContact.getY() + lContact.getHeight(), 200, 40);

        lFullname = new JLabel("Fullname");
        lFullname.setForeground(ConstColor.WHITE);
        lFullname.setFont(new Font("Arial", Font.PLAIN, 16));
        lFullname.setBounds(lContactInfo.getX(), lContactInfo.getY() + 40, 150, 40);

        tfFullname = new JTextField();
        tfFullname.setForeground(ConstColor.WHITE);
        tfFullname.setBackground(ConstColor.PURPLE3);
        tfFullname.setBounds(lFullname.getX() + lFullname.getWidth() + 40, lFullname.getY(), 200, 40);
        tfFullname.setMargin(new Insets(0, 10, 0, 0));

        lEmail = new JLabel("Email");
        lEmail.setForeground(ConstColor.WHITE);
        lEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        lEmail.setBounds(lFullname.getX(), lFullname.getY() + lFullname.getHeight() + 20, 150, 40);

        tfEmail = new JTextField();
        tfEmail.setForeground(ConstColor.WHITE);
        tfEmail.setBackground(ConstColor.PURPLE3);
        tfEmail.setBounds(tfFullname.getX(), lEmail.getY(), 200, 40);
        tfEmail.setMargin(new Insets(0, 10, 0, 0));

        lPhone = new JLabel("Phone Number");
        lPhone.setForeground(ConstColor.WHITE);
        lPhone.setFont(new Font("Arial", Font.PLAIN, 16));
        lPhone.setBounds(lEmail.getX(), lEmail.getY() + lEmail.getHeight() + 20, 150, 40);

        tfPhone = new JTextField();
        tfPhone.setForeground(ConstColor.WHITE);
        tfPhone.setBackground(ConstColor.PURPLE3);
        tfPhone.setBounds(tfEmail.getX(), lPhone.getY(), 200, 40);
        tfPhone.setMargin(new Insets(0, 10, 0, 0));

        lTransaction = new JLabel("Transaction");
        lTransaction.setForeground(ConstColor.WHITE);
        lTransaction.setFont(new Font("Arial", Font.BOLD, 20));
        lTransaction.setBounds(lPhone.getX(), lPhone.getY() + lPhone.getHeight() + 40, 150, 20);

        lPrice = new JLabel();
        lPrice.setForeground(ConstColor.WHITE);
        lPrice.setFont(new Font("Arial", Font.PLAIN, 16));
        lPrice.setBounds(lTransaction.getX(), lTransaction.getY() + lTransaction.getHeight(), 300, 40);
        lPrice.setText("Transaction Price : Rp " + String.valueOf(price));

        lPayment = new JLabel("Payment Method");
        lPayment.setForeground(ConstColor.WHITE);
        lPayment.setFont(new Font("Arial", Font.PLAIN, 16));
        lPayment.setBounds(lPrice.getX(), lPrice.getY() + lPrice.getHeight() + 20, 150, 40);
        
        String[] transactionList = {"BCA", "BRI", "Gopay", "OVO", "Bitcoin"};
        cbPayment = new JComboBox<>(transactionList);
        cbPayment.setBounds(tfPhone.getX(), lPayment.getY(), 200, 40);

        btnBooking = new JButton("Book");
        btnBooking.setBounds(lTransaction.getX(), container.getHeight() - 100, 150, 40);
        btnBooking.setBackground(ConstColor.PURPLE4);
        btnBooking.setForeground(ConstColor.WHITE);
        btnBooking.setFont(new Font("Arial", Font.PLAIN, 20));
        btnBooking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBooking.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setBounds(btnBooking.getX() + btnBooking.getWidth() + 40, btnBooking.getY(), 150, 40);
        btnBack.setBackground(ConstColor.PURPLE4);
        btnBack.setForeground(ConstColor.WHITE);
        btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(this);

        // Adding components
        this.add(lTitle);

        container.add(lContact);
        container.add(lContactInfo);
        container.add(lFullname);
        container.add(tfFullname);
        container.add(lEmail);
        container.add(tfEmail);
        container.add(lPhone);
        container.add(tfPhone);
        container.add(lTransaction);
        container.add(lPrice);
        container.add(lPayment);
        container.add(cbPayment);
        container.add(btnBooking);
        container.add(btnBack);
        this.add(container);

        // Set visibility
        this.setVisible(true);
    }

    public void setValueToGlobal(int id, TripTypesEnum type, int price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();

        switch (name) {
            case "Book":
                
                // Get value
                String fullname = tfFullname.getText();
                String email = tfEmail.getText();
                String phone = tfPhone.getText();
                String payment = cbPayment.getSelectedItem().toString();

                if (fullname.equals("") || email.equals("") || phone.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all field !");
                } else {
                    
                    // Get current date
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDateTime now = LocalDateTime.now();
                    String currentTime = dtf.format(now);

                    System.out.println(currentTime);
                    System.out.println(fullname);
                    System.out.println(phone);
                    System.out.println(email);
                    System.out.println(payment);
                    System.out.println(type);
                    System.out.println(SingletonManager.getInstance().getUser().getUserID());
                    System.out.println(id);

                    Order newOrder = new Order(currentTime, fullname, phone, email, payment, type);
                    boolean success = queryController.insertNewOrder(SingletonManager.getInstance().getUser().getUserID(), newOrder, id);
                
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Booking Success");
                    } else {
                        JOptionPane.showMessageDialog(null, "Booking Failed");
                    }
                }
                break;
            case "Back":
                MainFrame.cardLayout.show(MainFrame.cardPanelUser, "searchFlightPanel");
                break;
            default:
                break;
        }
    }
    
}
