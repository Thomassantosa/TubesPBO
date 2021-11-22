package test;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    
    // Declaring variable
    static JPanel buttonContainer;
    static JPanel cardPanel1, cardPanelAdmin;
    static CardLayout cardLayout;
    JLabel lSplashLogo;
    JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;
    
    // Declaring variable (JPanel from another class)
    Panel1 panel1;
    Panel2 panel2;
    SplashPanel splashPanel;
    LoginPanel loginPanel;
    RegisterStatusPanel registerStatusPanel;
    RegisterUserPanel registerUserPanel;
    RegisterPartnerPanel registerPartnerPanel;
    static ButtonContainerAdmin buttonContainerAdmin;
    AdminHomePanel adminHomePanel;
    AdminFlightPanel adminFlightPanel;
    AdminTrainPanel adminTrainPanel;
    AdminBusPanel adminBusPanel;

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
        cardPanel1 = new JPanel();
        cardLayout = new CardLayout();
        cardPanel1.setLayout(cardLayout);
        cardPanel1.setBounds(0, 0, width, height);

        cardPanelAdmin = new JPanel();
        // cardLayout = new CardLayout();
        cardPanelAdmin.setLayout(cardLayout);
        cardPanelAdmin.setBounds(220, 0, width - 220, height);

        splashPanel = new SplashPanel();
        loginPanel = new LoginPanel();
        registerStatusPanel = new RegisterStatusPanel();
        registerUserPanel = new RegisterUserPanel();
        registerPartnerPanel = new RegisterPartnerPanel();

        buttonContainerAdmin = new ButtonContainerAdmin();
        adminHomePanel = new AdminHomePanel();
        adminFlightPanel = new AdminFlightPanel();
        adminTrainPanel = new AdminTrainPanel();
        adminBusPanel = new AdminBusPanel();
        panel1 = new Panel1();
        panel2 = new Panel2();

        // Set components

        // Adding component
        this.add(splashPanel);

        cardPanel1.add(loginPanel, "loginPanel");
        cardPanel1.add(registerStatusPanel, "registerStatus");
        cardPanel1.add(registerUserPanel, "registerUser");
        cardPanel1.add(registerPartnerPanel, "registerPartner");
        this.add(cardPanel1);

        cardPanelAdmin.add(adminHomePanel, "adminHomePanel");
        cardPanelAdmin.add(adminFlightPanel, "adminFlightPanel");
        cardPanelAdmin.add(adminTrainPanel, "adminTrainPanel");
        cardPanelAdmin.add(adminBusPanel, "adminBusPanel");
        cardPanelAdmin.add(panel1, "panelB");
        cardPanelAdmin.add(panel2, "panelC");
        this.add(cardPanelAdmin);

        this.add(buttonContainerAdmin);

        // Set Vicibility
        this.setVisible(true);
        splashPanel.setVisible(true);
        buttonContainer.setVisible(false);
        cardPanel1.setVisible(false);
        cardPanelAdmin.setVisible(false);
        buttonContainerAdmin.setVisible(false);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splashPanel.setVisible(false);

        // buttonContainer.setVisible(true);
        cardPanel1.setVisible(true);
        // buttonContainer.setVisible(false);
    }
}