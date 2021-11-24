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

public class ButtonContainerPartner extends JPanel implements MouseInputListener {

    // Declaring variable
    JButton button1, button2, button3, button4, button5;
    
    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public ButtonContainerPartner() {

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE2);
        this.setSize(220, height);
        this.setLayout(null);

        // Set components
        // Set JButton
        button1 = new JButton("Show Data");
        button1.setBackground(ConstColor.PURPLE2);
        button1.setForeground(ConstColor.GREY);
        button1.setBounds(0, 0, 220, 40);
        button1.setFont(new Font("Arial", Font.PLAIN, 16));
        button1.setBorderPainted(false);
        button1.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon dataIcon = new ImageIcon("src\\source\\Data Icon.png");
        button1.setIcon(dataIcon);
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        button2 = new JButton("Add Data");
        button2.setBackground(ConstColor.PURPLE2);
        button2.setForeground(ConstColor.GREY);
        button2.setBounds(0, button1.getY() + 40, 220, 40);
        button2.setFont(new Font("Arial", Font.PLAIN, 16));
        button2.setBorderPainted(false);
        button2.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon addIcon = new ImageIcon("src\\source\\Add Icon.png");
        button2.setIcon(addIcon);
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        button3 = new JButton("Delete Data");
        button3.setBackground(ConstColor.PURPLE2);
        button3.setForeground(ConstColor.GREY);
        button3.setBounds(0, button2.getY() + 40, 220, 40);
        button3.setFont(new Font("Arial", Font.PLAIN, 16));
        button3.setBorderPainted(false);
        button3.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon deteleIcon = new ImageIcon("src\\source\\Delete Icon.png");
        button3.setIcon(deteleIcon);
        button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button4 = new JButton("Profile");
        button4.setBackground(ConstColor.PURPLE2);
        button4.setForeground(ConstColor.GREY);
        button4.setBounds(0, height - 140, 220, 40);
        button4.setFont(new Font("Arial", Font.PLAIN, 16));
        button4.setBorderPainted(false);
        button4.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon accountIcon = new ImageIcon("src\\source\\Account Icon.png");
        button4.setIcon(accountIcon);
        button4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        button5 = new JButton("Logout");
        button5.setBackground(ConstColor.PURPLE2);
        button5.setForeground(ConstColor.RED2);
        button5.setBounds(0, height - 100, 220, 40);
        button5.setFont(new Font("Arial", Font.PLAIN, 16));
        button5.setBorderPainted(false);
        button5.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon logoutIcon = new ImageIcon("src\\source\\LogOut Icon.png");
        button5.setIcon(logoutIcon);
        button5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);
        button5.addMouseListener(this);

        // Adding components
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);

        // Set vicibility
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();

        String partnerType = SingletonManager.getInstance().getPartner().getPartnerType();

        switch(name) {
            case "Show Data":

                switch (partnerType) {
                    case "Flight":
                        MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "partnerFlightShowPanel");
                        break;
                    case "Train":
                        MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "partnerTrainShowPanel");
                        break;
                    case "Bus":
                        MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "partnerBusShowPanel");
                        break;
                    case "Hotel":
                        MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "partnerHotelShowPanel");
                        break;
                    default:
                        break;
                }
                break;
            case "Add Data":

                switch (partnerType) {
                    case "Flight":
                        MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "partnerFlightAddPanel");
                        break;
                    case "Train":
                        MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "partnerTrainAddPanel");
                        break;
                    case "Bus":
                        MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "partnerBusAddPanel");
                        break;
                    case "Hotel":
                        MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "partnerHotelAddPanel");
                        break;
                    default:
                        break;
                }
                break;
            case "Delete Data":

                switch (partnerType) {
                    case "Flight":
                        MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "panel1");
                        break;
                    case "Train":
                        MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "panel1");
                        break;
                    case "Bus":
                        MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "panel1");
                        break;
                    case "Hotel":
                        MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "panel1");
                        break;
                    default:
                        break;
                }
                break;
            case "Profile":
                MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "partnerProfilePanel");
                break;
            case "Logout":
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure want to logout ?", "Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choice == 0) {

                    // Set current user data back to null
                    SingletonManager.getInstance().setPartner(null);

                    // Set UI
                    MainFrame.cardPanel1.setVisible(true);
                    MainFrame.buttonContainerPartner.setVisible(false);
                    MainFrame.cardPanelPartner.setVisible(false);
                    // MainFrame.cardLayout.show(MainFrame.cardPanelPartner, "partnerShowData");
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
            case "Show Data":
                hoverIcon = new ImageIcon("src\\source\\Data Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Add Data":
                hoverIcon = new ImageIcon("src\\source\\Add Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Delete Data":
                hoverIcon = new ImageIcon("src\\source\\Delete Icon_Hover.png");
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
            case "Show Data":
                icon = new ImageIcon("src\\source\\Data Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
                break;
            case "Add Data":
                icon = new ImageIcon("src\\source\\Add Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
                break;
            case "Delete Data":
                icon = new ImageIcon("src\\source\\Delete Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
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
