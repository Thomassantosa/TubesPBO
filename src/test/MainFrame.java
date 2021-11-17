package test;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;

public class MainFrame extends JFrame implements MouseInputListener{
    
    // Declaring variable
    JPanel buttonContainer, cardPanel;
    JLabel lSplashLogo;
    JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;
    Panel0 panel0;
    Panel1 panel1;
    Panel2 panel2;
    CardLayout cardLayout;
    SplashPanel splashPanel;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();
    
    public MainFrame() {

        // Set JFrame
        this.setTitle("Travelokay");
        this.setSize(width, height);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);  
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\source\\Logo.png");  
        this.setIconImage(icon);

        // Set Fixed JPanel
        buttonContainer = new JPanel();
        buttonContainer.setBackground(ConstColor.PURPLE2);
        buttonContainer.setSize(220, height);
        buttonContainer.setLayout(null);
        
        // Set JPanel
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        cardPanel.setBounds(220, 0, width-220, height);

        splashPanel = new SplashPanel();
        panel0 = new Panel0();
        panel1 = new Panel1();
        panel2 = new Panel2();

        // Set components
        // Set JButton
        button1 = new JButton("Home");
        button1.setBackground(ConstColor.PURPLE2);
        button1.setForeground(ConstColor.GREY);
        button1.setBounds(0, 0, 220, 40);
        button1.setFont(new Font("Arial", Font.PLAIN, 16));
        button1.setBorderPainted(false);
        button1.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon homeIcon = new ImageIcon("src\\source\\Asset 20.png");
        // homeIcon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        button1.setIconTextGap(10);
        button1.setIcon(homeIcon);
        
        button2 = new JButton("Flight");
        button2.setBackground(ConstColor.PURPLE2);
        button2.setForeground(ConstColor.GREY);
        button2.setBounds(0, button1.getY()+40, 220, 40);
        button2.setFont(new Font("Arial", Font.PLAIN, 16));
        button2.setBorderPainted(false);
        button2.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon flightIcon = new ImageIcon("src\\source\\Flight Icon.png");
        flightIcon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        button2.setIcon(flightIcon);
        
        button3 = new JButton("Train");
        button3.setBackground(ConstColor.PURPLE2);
        button3.setForeground(ConstColor.GREY);
        button3.setBounds(0, button2.getY()+40, 220, 40);
        button3.setFont(new Font("Arial", Font.PLAIN, 16));
        button3.setBorderPainted(false);
        button3.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon trainIcon = new ImageIcon("src\\source\\Train Icon.png");
        trainIcon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        button3.setIcon(trainIcon);
        
        button4 = new JButton("Bus");
        button4.setBackground(ConstColor.PURPLE2);
        button4.setForeground(ConstColor.GREY);
        button4.setBounds(0, button3.getY()+40, 220, 40);
        button4.setFont(new Font("Arial", Font.PLAIN, 16));
        button4.setBorderPainted(false);
        button4.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon busIcon = new ImageIcon("src\\source\\Bus Icon.png");
        busIcon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        button4.setIcon(busIcon);
        
        button5 = new JButton("Hotel");
        button5.setBackground(ConstColor.PURPLE2);
        button5.setForeground(ConstColor.GREY);
        button5.setBounds(0, button4.getY()+40, 220, 40);
        button5.setFont(new Font("Arial", Font.PLAIN, 16));
        button5.setBorderPainted(false);
        button5.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon hotelIcon = new ImageIcon("src\\source\\Hotel Icon.png");
        hotelIcon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        button5.setIcon(hotelIcon);
        
        button6 = new JButton("XTourience");
        button6.setBackground(ConstColor.PURPLE2);
        button6.setForeground(ConstColor.GREY);
        button6.setBounds(0, button5.getY()+40, 220, 40);
        button6.setFont(new Font("Arial", Font.PLAIN, 16));
        button6.setBorderPainted(false);
        button6.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon xTourienceIcon = new ImageIcon("src\\source\\XTourience Icon.png");
        xTourienceIcon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        button6.setIcon(xTourienceIcon);
        
        button7 = new JButton("User");
        button7.setBackground(ConstColor.PURPLE2);
        button7.setForeground(ConstColor.GREY);
        button7.setBounds(0, button6.getY()+40, 220, 40);
        button7.setFont(new Font("Arial", Font.PLAIN, 16));
        button7.setBorderPainted(false);
        button7.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon accountIcon = new ImageIcon("src\\source\\Account Icon.png");
        accountIcon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        button7.setIcon(accountIcon);
        
        button8 = new JButton("Partner");
        button8.setBackground(ConstColor.PURPLE2);
        button8.setForeground(ConstColor.GREY);
        button8.setBounds(0, button7.getY()+40, 220, 40);
        button8.setFont(new Font("Arial", Font.PLAIN, 16));
        button8.setBorderPainted(false);
        button8.setHorizontalAlignment(SwingConstants.LEFT);
        accountIcon = new ImageIcon("src\\source\\Account Icon.png");
        accountIcon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        button8.setIcon(accountIcon);
        
        button9 = new JButton("Account");
        button9.setBackground(ConstColor.PURPLE2);
        button9.setForeground(ConstColor.GREY);
        button9.setBounds(0, height-140, 220, 40);
        button9.setFont(new Font("Arial", Font.PLAIN, 16));
        button9.setBorderPainted(false);
        button9.setHorizontalAlignment(SwingConstants.LEFT);
        accountIcon = new ImageIcon("src\\source\\Account Icon.png");
        accountIcon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        button9.setIcon(accountIcon);
        
        button10 = new JButton("Log-Out");
        button10.setBackground(ConstColor.PURPLE2);
        button10.setForeground(ConstColor.RED2);
        button10.setBounds(0, height-100, 220, 40);
        button10.setFont(new Font("Arial", Font.PLAIN, 16));
        button10.setBorderPainted(false);
        button10.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon logoutIcon = new ImageIcon("src\\source\\LogOut Icon.png");
        logoutIcon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        button10.setIcon(logoutIcon);
        
        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);
        button5.addMouseListener(this);
        button6.addMouseListener(this);
        button7.addMouseListener(this);
        button8.addMouseListener(this);
        button9.addMouseListener(this);
        button10.addMouseListener(this);

        // Adding component
        this.add(splashPanel);

        buttonContainer.add(button1);
        buttonContainer.add(button2);
        buttonContainer.add(button3);
        buttonContainer.add(button4);
        buttonContainer.add(button5);
        buttonContainer.add(button6);
        buttonContainer.add(button7);
        buttonContainer.add(button8);
        buttonContainer.add(button9);
        buttonContainer.add(button10);
        this.add(buttonContainer);

        cardPanel.add(panel0, "panelA");
        cardPanel.add(panel1, "panelB");
        cardPanel.add(panel2, "panelC");
        this.add(cardPanel);

        // Set Vicibility
        this.setVisible(true);
        buttonContainer.setVisible(false);
        splashPanel.setVisible(true);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splashPanel.setVisible(false);

        buttonContainer.setVisible(true);
        cardPanel.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();

        switch(name) {
            case "Home":
                cardLayout.show(cardPanel, "panelB");
                break;
            case "Flight":
                cardLayout.show(cardPanel, "panelC");
                break;
            default: 
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
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
            case "XTourience":
                hoverIcon = new ImageIcon("src\\source\\XTourience Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "User":
                hoverIcon = new ImageIcon("src\\source\\Account Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Partner":
                hoverIcon = new ImageIcon("src\\source\\Account Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Account":
                hoverIcon = new ImageIcon("src\\source\\Account Icon_Hover.png");
                button.setBackground(ConstColor.PURPLE4);
                button.setForeground(ConstColor.WHITE);
                break;
            case "Log-Out":
                hoverIcon = new ImageIcon("src\\source\\LogOut Icon.png");
                button.setBackground(ConstColor.RED1);
                break;
            default: 
                break;
        }
        hoverIcon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
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
            case "XTourience":
                icon = new ImageIcon("src\\source\\XTourience Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
                break;
            case "User":
                icon = new ImageIcon("src\\source\\Account Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
                break;
            case "Partner":
                icon = new ImageIcon("src\\source\\Account Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
                break;
            case "Account":
                icon = new ImageIcon("src\\source\\Account Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                button.setForeground(ConstColor.GREY);
                break;
            case "Log-Out":
                icon = new ImageIcon("src\\source\\LogOut Icon.png");
                button.setBackground(ConstColor.PURPLE2);
                break;
            default: 
                break;
        }
        icon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        button.setIcon(icon);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
