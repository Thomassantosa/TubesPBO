package test;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;

import controller.SingletonManager;

public class ButtonContainerUser extends JPanel implements MouseInputListener {

    // Declaring variable
    JButton button1, button2, button3, button4, button5, button6, button7, button8;
    
    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public ButtonContainerUser() {

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE2);
        this.setSize(220, height);
        this.setLayout(null);

        // Set components
        // Set JButton
        button1 = new JButton("Home");
        button1.setBackground(ConstColor.PURPLE2);
        button1.setForeground(ConstColor.GREY);
        button1.setBounds(0, 0, 220, 40);
        button1.setFont(new Font("Arial", Font.PLAIN, 16));
        button1.setBorderPainted(false);
        button1.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon homeIcon = new ImageIcon("src\\source\\Home Icon.png");
        button1.setIcon(homeIcon);
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        button2 = new JButton("Flight");
        button2.setBackground(ConstColor.PURPLE2);
        button2.setForeground(ConstColor.GREY);
        button2.setBounds(0, button1.getY() + 40, 220, 40);
        button2.setFont(new Font("Arial", Font.PLAIN, 16));
        button2.setBorderPainted(false);
        button2.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon flightIcon = new ImageIcon("src\\source\\Flight Icon.png");
        button2.setIcon(flightIcon);
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        button3 = new JButton("Train");
        button3.setBackground(ConstColor.PURPLE2);
        button3.setForeground(ConstColor.GREY);
        button3.setBounds(0, button2.getY() + 40, 220, 40);
        button3.setFont(new Font("Arial", Font.PLAIN, 16));
        button3.setBorderPainted(false);
        button3.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon trainIcon = new ImageIcon("src\\source\\Train Icon.png");
        button3.setIcon(trainIcon);
        button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        button4 = new JButton("Bus");
        button4.setBackground(ConstColor.PURPLE2);
        button4.setForeground(ConstColor.GREY);
        button4.setBounds(0, button3.getY() + 40, 220, 40);
        button4.setFont(new Font("Arial", Font.PLAIN, 16));
        button4.setBorderPainted(false);
        button4.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon busIcon = new ImageIcon("src\\source\\Bus Icon.png");
        button4.setIcon(busIcon);
        button4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        button5 = new JButton("Hotel");
        button5.setBackground(ConstColor.PURPLE2);
        button5.setForeground(ConstColor.GREY);
        button5.setBounds(0, button4.getY() + 40, 220, 40);
        button5.setFont(new Font("Arial", Font.PLAIN, 16));
        button5.setBorderPainted(false);
        button5.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon hotelIcon = new ImageIcon("src\\source\\Hotel Icon.png");
        button5.setIcon(hotelIcon);
        button5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // button6 = new JButton("XTourience");
        // button6.setBackground(ConstColor.PURPLE2);
        // button6.setForeground(ConstColor.GREY);
        // button6.setBounds(0, button5.getY() + 40, 220, 40);
        // button6.setFont(new Font("Arial", Font.PLAIN, 16));
        // button6.setBorderPainted(false);
        // button6.setHorizontalAlignment(SwingConstants.LEFT);
        // ImageIcon xTourienceIcon = new ImageIcon("src\\source\\XTourience Icon.png");
        // button6.setIcon(xTourienceIcon);
        // button6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        button6 = new JButton("Your Order");
        button6.setBackground(ConstColor.PURPLE2);
        button6.setForeground(ConstColor.GREY);
        button6.setBounds(0, height - 180, 220, 40);
        button6.setFont(new Font("Arial", Font.PLAIN, 16));
        button6.setBorderPainted(false);
        button6.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon orderIcon = new ImageIcon("src\\source\\Account Icon.png");
        button6.setIcon(orderIcon);
        button6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button7 = new JButton("Profile");
        button7.setBackground(ConstColor.PURPLE2);
        button7.setForeground(ConstColor.GREY);
        button7.setBounds(0, height - 140, 220, 40);
        button7.setFont(new Font("Arial", Font.PLAIN, 16));
        button7.setBorderPainted(false);
        button7.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon accountIcon = new ImageIcon("src\\source\\Account Icon.png");
        button7.setIcon(accountIcon);
        button7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        button8 = new JButton("Logout");
        button8.setBackground(ConstColor.PURPLE2);
        button8.setForeground(ConstColor.RED2);
        button8.setBounds(0, height - 100, 220, 40);
        button8.setFont(new Font("Arial", Font.PLAIN, 16));
        button8.setBorderPainted(false);
        button8.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon logoutIcon = new ImageIcon("src\\source\\LogOut Icon.png");
        button8.setIcon(logoutIcon);
        button8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);
        button5.addMouseListener(this);
        button6.addMouseListener(this);
        button7.addMouseListener(this);

        // Adding components
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);

        // Set vicibility
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();

        switch(name) {
            case "Home":
                MainFrame.cardLayout.show(MainFrame.cardPanelUser, "userHomePanel");
                break;
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
            // case "XTourience":
            //     MainFrame.cardLayout.show(MainFrame.cardPanelUser, "panelC");
            //     break;
            case "Your Order":
                MainFrame.cardLayout.show(MainFrame.cardPanelUser, "userProfilePanel");
                break;
            case "Profile":
                MainFrame.cardLayout.show(MainFrame.cardPanelUser, "userProfilePanel");
                break;
            case "Logout":
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure want to logout ?", "Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choice == 0) {

                    // Set current user data back to null
                    SingletonManager.getInstance().setUser(null);

                    // Set UI
                    MainFrame.cardPanel1.setVisible(true);
                    MainFrame.buttonContainerUser.setVisible(false);
                    MainFrame.cardPanelUser.setVisible(false);
                    MainFrame.cardLayout.show(MainFrame.cardPanelUser, "userHomePanel");
                }
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
            case "Home":
                hoverIcon = new ImageIcon("src\\source\\Home Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Flight":
                hoverIcon = new ImageIcon("src\\source\\Flight Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Train":
                hoverIcon = new ImageIcon("src\\source\\Train Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Bus":
                hoverIcon = new ImageIcon("src\\source\\Bus Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Hotel":
                hoverIcon = new ImageIcon("src\\source\\Hotel Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            // case "XTourience":
            //     hoverIcon = new ImageIcon("src\\source\\XTourience Icon_Hover.png");
            //     button.setBackground(ConstColor.PURPLE4);
            //     button.setForeground(ConstColor.WHITE);
            //     break;
            case "Your Order":
                hoverIcon = new ImageIcon("src\\source\\Order Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Profile":
                hoverIcon = new ImageIcon("src\\source\\Account Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Logout":
                hoverIcon = new ImageIcon("src\\source\\LogOut Icon.png");
                button.setBackground(ConstColor.RED1);
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
        
        ImageIcon icon = new ImageIcon();
        switch(name) {
            case "Home":
                icon = new ImageIcon("src\\source\\Home Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
                break;
            case "Flight":
                icon = new ImageIcon("src\\source\\Flight Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
                break;
            case "Train":
                icon = new ImageIcon("src\\source\\Train Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
                break;
            case "Bus":
                icon = new ImageIcon("src\\source\\Bus Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
                break;
            case "Hotel":
                icon = new ImageIcon("src\\source\\Hotel Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
                break;
            // case "XTourience":
            //     icon = new ImageIcon("src\\source\\XTourience Icon.png");
            //     button.setBackground(ConstColor.PURPLE2);
            //     button.setForeground(ConstColor.GREY);
            //     break;
            case "Your Order":
                icon = new ImageIcon("src\\source\\Order Icon.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Profile":
                icon = new ImageIcon("src\\source\\Account Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
                break;
            case "Logout":
                icon = new ImageIcon("src\\source\\LogOut Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                break;
            default: 
                break;
        }
        button.setIcon(icon);
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
