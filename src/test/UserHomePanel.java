package test;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import controller.QueryController;
import controller.SingletonManager;

public class UserHomePanel extends JPanel implements MouseInputListener {
    
    // Declaring variable
    JLabel lWelcome, lTitle;
    JPanel container;
    QueryController queryController;
    JButton btnFlight, btnTrain, btnBus, btnHotel;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public UserHomePanel() {

        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);
        
        // Set components
        // Set JLabel
        lWelcome = new JLabel();
        lWelcome.setForeground(ConstColor.WHITE);
        lWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
        lWelcome.setBounds(20, 20, 450, 20);
        lWelcome.setText("Welcome " + SingletonManager.getInstance().getUser().getUsername() + ",");

        lTitle = new JLabel("Let's Explore The World");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, lWelcome.getY() + 25, 500, 40);
        
        container = new RoundedPanel(20, ConstColor.PURPLE2);
        container.setBounds(20, 100, width-270, height-200);
        container.setLayout(null);
        container.setOpaque(false);

        // Set JButton
        btnFlight = new JButton("Flight");
        btnFlight.setBounds(20, 20, container.getWidth()/2 - 40, container.getHeight()/2 - 40);
        ImageIcon logoFlight = new ImageIcon("src\\source\\Flight Icon.png");
        btnFlight.setBackground(ConstColor.BLUE1);
        btnFlight.setForeground(ConstColor.WHITE);
        btnFlight.setIcon(logoFlight);
        btnFlight.setHorizontalTextPosition(JButton.CENTER);
        btnFlight.setVerticalTextPosition(JButton.BOTTOM);
        btnFlight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnFlight.addMouseListener(this);

        btnTrain = new JButton("Train");
        btnTrain.setBounds(btnFlight.getX() + btnFlight.getWidth() + 40, btnFlight.getY(), btnFlight.getWidth(), btnFlight.getHeight());
        ImageIcon logoTrain = new ImageIcon("src\\source\\Train Icon.png");
        btnTrain.setBackground(ConstColor.BLUE3);
        btnTrain.setForeground(ConstColor.WHITE);
        btnTrain.setIcon(logoTrain);
        btnTrain.setHorizontalTextPosition(JButton.CENTER);
        btnTrain.setVerticalTextPosition(JButton.BOTTOM);
        btnTrain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnTrain.addMouseListener(this);

        btnBus = new JButton("Bus");
        btnBus.setBounds(btnFlight.getX(), btnFlight.getY() + btnFlight.getHeight() + 40, btnFlight.getWidth(), btnFlight.getHeight());
        ImageIcon logoBus = new ImageIcon("src\\source\\Bus Icon.png");
        btnBus.setBackground(ConstColor.BLUE5);
        btnBus.setForeground(ConstColor.WHITE);
        btnBus.setIcon(logoBus);
        btnBus.setHorizontalTextPosition(JButton.CENTER);
        btnBus.setVerticalTextPosition(JButton.BOTTOM);
        btnBus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBus.addMouseListener(this);

        btnHotel = new JButton("Hotel");
        btnHotel.setBounds(btnTrain.getX(), btnBus.getY(), btnFlight.getWidth(), btnFlight.getHeight());
        ImageIcon logoHotel = new ImageIcon("src\\source\\Hotel Icon.png");
        btnHotel.setBackground(ConstColor.GREEN1);
        btnHotel.setForeground(ConstColor.WHITE);
        btnHotel.setIcon(logoHotel);
        btnHotel.setHorizontalTextPosition(JButton.CENTER);
        btnHotel.setVerticalTextPosition(JButton.BOTTOM);
        btnHotel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnHotel.addMouseListener(this);

        // Adding components
        this.add(lWelcome);
        this.add(lTitle);

        container.add(btnFlight);
        container.add(btnTrain);
        container.add(btnBus);
        container.add(btnHotel);
        this.add(container);

        // Set vicibility
        lWelcome.setVisible(true);
        lTitle.setVisible(true);
        container.setVisible(true);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();

        switch(name) {
            case "Flight":
                MainFrame.cardLayout.show(MainFrame.cardPanelUser, "userFlightPanel");
                break;
            case "Train":
                MainFrame.cardLayout.show(MainFrame.cardPanelUser, "userTrainPanel");
                break;
            case "Bus":
                MainFrame.cardLayout.show(MainFrame.cardPanelUser, "userBusPanel");
                break;
            case "Hotel":
                MainFrame.cardLayout.show(MainFrame.cardPanelUser, "userHotelPanel");
                break;
            default: 
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Not implemented
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Not implemented
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();
        
        ImageIcon hoverIcon = new ImageIcon();
        switch(name) {
            case "Flight":
                hoverIcon = new ImageIcon("src\\source\\Flight Icon_Hover.png");
                button.setBackground(ConstColor.BLUE2);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Train":
                hoverIcon = new ImageIcon("src\\source\\Train Icon_Hover.png");
                button.setBackground(ConstColor.BLUE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Bus":
                hoverIcon = new ImageIcon("src\\source\\Bus Icon_Hover.png");
                button.setBackground(ConstColor.BLUE6);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Hotel":
                hoverIcon = new ImageIcon("src\\source\\Hotel Icon_Hover.png");
                button.setBackground(ConstColor.GREEN2);
                button.setForeground(ConstColor.WHITE);
                break;
            default: 
                break;
        }
        button.setIcon(hoverIcon);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();
        
        ImageIcon hoverIcon = new ImageIcon();
        switch(name) {
            case "Flight":
                hoverIcon = new ImageIcon("src\\source\\Flight Icon.png");
                button.setBackground(ConstColor.BLUE1);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Train":
                hoverIcon = new ImageIcon("src\\source\\Train Icon.png");
                button.setBackground(ConstColor.BLUE3);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Bus":
                hoverIcon = new ImageIcon("src\\source\\Bus Icon.png");
                button.setBackground(ConstColor.BLUE5);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Hotel":
                hoverIcon = new ImageIcon("src\\source\\Hotel Icon.png");
                button.setBackground(ConstColor.GREEN1);
                button.setForeground(ConstColor.WHITE);
                break;
            default: 
                break;
        }
        button.setIcon(hoverIcon);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Not implemented
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Not implemented
    }
}
