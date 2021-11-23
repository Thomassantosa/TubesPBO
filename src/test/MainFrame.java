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
    static JPanel cardPanel1, cardPanelAdmin, cardPanelUser;
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
    static AdminHomePanel adminHomePanel;
    static AdminFlightPanel adminFlightPanel;
    static AdminTrainPanel adminTrainPanel;
    static AdminBusPanel adminBusPanel;
    static AdminHotelPanel adminHotelPanel;
    static AdminUserPanel adminUserPanel;
    static AdminPartnerPanel adminPartnerPanel;
    static AdminProfilePanel adminProfilePanel;
    static ButtonContainerUser buttonContainerUser;

    
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

        // Set components
        // Set Fixed JPanel
        buttonContainer = new JPanel();
        buttonContainer.setBackground(ConstColor.PURPLE2);
        buttonContainer.setSize(220, height);
        buttonContainer.setLayout(null);
        
        // Set JPanel (cardlayout)
        cardPanel1 = new JPanel();
        cardLayout = new CardLayout();
        cardPanel1.setLayout(cardLayout);
        cardPanel1.setBounds(0, 0, width, height);

        cardPanelAdmin = new JPanel();
        cardPanelAdmin.setLayout(cardLayout);
        cardPanelAdmin.setBounds(220, 0, width - 220, height);

        cardPanelUser = new JPanel();
        cardPanelUser.setLayout(cardLayout);
        cardPanelUser.setBounds(220, 0, width - 220, height);

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
        adminHotelPanel = new AdminHotelPanel();
        adminUserPanel = new AdminUserPanel();
        adminPartnerPanel = new AdminPartnerPanel();
        // adminProfilePanel = new AdminProfilePanel();

        buttonContainerUser = new ButtonContainerUser();
        panel1 = new Panel1();

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
        cardPanelAdmin.add(adminHotelPanel, "adminHotelPanel");
        cardPanelAdmin.add(adminUserPanel, "adminUserPanel");
        cardPanelAdmin.add(adminPartnerPanel, "adminPartnerPanel");
        // cardPanelAdmin.add(adminProfilePanel, "adminProfilePanel");
        this.add(cardPanelAdmin);
        
        cardPanelUser.add(panel1, "panelA");
        this.add(cardPanelUser);

        this.add(buttonContainerAdmin);
        this.add(buttonContainerUser);

        // Set Vicibility
        this.setVisible(true);
        splashPanel.setVisible(true);
        buttonContainer.setVisible(false);
        cardPanel1.setVisible(false);
        cardPanelAdmin.setVisible(false);
        cardPanelUser.setVisible(false);
        buttonContainerAdmin.setVisible(false);
        buttonContainerUser.setVisible(false);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splashPanel.setVisible(false);
        cardPanel1.setVisible(true);
    }

    public static void setCardPanelAdmin() {
        adminProfilePanel = new AdminProfilePanel();
        cardPanelAdmin.add(adminProfilePanel, "adminProfilePanel");
    }

    public static void setCardPanelUser() {
        // adminProfilePanel = new AdminProfilePanel();
        // cardPanelAdmin.add(adminProfilePanel, "adminProfilePanel");
    }
}