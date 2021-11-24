package test;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    
    // Declaring variable
    static JPanel buttonContainer;
    static JPanel cardPanel1, cardPanelAdmin, cardPanelUser, cardPanelPartner;
    static CardLayout cardLayout;
    JLabel lSplashLogo;
    JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;
    
    // Declaring variable (JPanel from another class)
    static Panel1 panel1;
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
    static UserHomePanel userHomePanel;
    static UserFlightPanel userFlightPanel;
    static UserTrainPanel userTrainPanel;
    static UserBusPanel userBusPanel;
    static UserHotelPanel userHotelPanel;
    static UserOrderPanel userOrderPanel;
    static UserProfilePanel userProfilePanel;
    // static SearchFlightPanel searchFlightPanel;

    static ButtonContainerPartner buttonContainerPartner;
    static PartnerFlightShowPanel partnerFlightShowPanel;
    static PartnerTrainShowPanel partnerTrainShowPanel;
    static PartnerBusShowPanel partnerBusShowPanel;
    static PartnerHotelShowPanel partnerHotelShowPanel;
    static PartnerFlightAddPanel partnerFlightAddPanel;
    static PartnerTrainAddPanel partnerTrainAddPanel;
    static PartnerBusAddPanel partnerBusAddPanel;
    static PartnerHotelAddPanel partnerHotelAddPanel;
    static PartnerProfilePanel partnerProfilePanel;

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

        cardPanelPartner = new JPanel();
        cardPanelPartner.setLayout(cardLayout);
        cardPanelPartner.setBounds(220, 0, width - 220, height);

        splashPanel = new SplashPanel();
        loginPanel = new LoginPanel();
        registerStatusPanel = new RegisterStatusPanel();
        registerUserPanel = new RegisterUserPanel();
        registerPartnerPanel = new RegisterPartnerPanel();

        buttonContainerAdmin = new ButtonContainerAdmin();
        // adminHomePanel = new AdminHomePanel();
        // adminFlightPanel = new AdminFlightPanel();
        // adminTrainPanel = new AdminTrainPanel();
        // adminBusPanel = new AdminBusPanel();
        // adminHotelPanel = new AdminHotelPanel();
        // adminUserPanel = new AdminUserPanel();
        // adminPartnerPanel = new AdminPartnerPanel();
        // adminProfilePanel = new AdminProfilePanel();

        buttonContainerUser = new ButtonContainerUser();
        // userHomePanel = new UserHomePanel();
        // userFlightPanel = new UserFlightPanel();
        // userTrainPanel = new UserTrainPanel();
        // userBusPanel = new UserBusPanel();
        // userHotelPanel = new UserHotelPanel();
        // userOrderPanel = new UserOrderPanel();
        // userProfilePanel = new UserProfilePanel();
        
        buttonContainerPartner = new ButtonContainerPartner();

        panel1 = new Panel1();

        // Adding component
        this.add(splashPanel);

        cardPanel1.add(loginPanel, "loginPanel");
        cardPanel1.add(registerStatusPanel, "registerStatus");
        cardPanel1.add(registerUserPanel, "registerUser");
        cardPanel1.add(registerPartnerPanel, "registerPartner");
        this.add(cardPanel1);

        // cardPanelAdmin.add(adminHomePanel, "adminHomePanel");
        // cardPanelAdmin.add(adminFlightPanel, "adminFlightPanel");
        // cardPanelAdmin.add(adminTrainPanel, "adminTrainPanel");
        // cardPanelAdmin.add(adminBusPanel, "adminBusPanel");
        // cardPanelAdmin.add(adminHotelPanel, "adminHotelPanel");
        // cardPanelAdmin.add(adminUserPanel, "adminUserPanel");
        // cardPanelAdmin.add(adminPartnerPanel, "adminPartnerPanel");
        // cardPanelAdmin.add(adminProfilePanel, "adminProfilePanel");
        this.add(cardPanelAdmin);
        
        // cardPanelUser.add(userHomePanel, "userHomePanel");
        // cardPanelUser.add(userFlightPanel, "userFlightPanel");
        // cardPanelUser.add(userTrainPanel, "userTrainPanel");
        // cardPanelUser.add(userBusPanel, "userBusPanel");
        // cardPanelUser.add(userHotelPanel, "userHotelPanel");
        // cardPanelUser.add(userOrderPanel, "userOrderPanel");
        // cardPanelUser.add(userProfilePanel, "userProfilePanel");
        this.add(cardPanelUser);

        this.add(cardPanelPartner);

        this.add(buttonContainerAdmin);
        this.add(buttonContainerUser);
        this.add(buttonContainerPartner);

        // Set Vicibility
        this.setVisible(true);
        splashPanel.setVisible(true);
        buttonContainer.setVisible(false);
        cardPanel1.setVisible(false);
        cardPanelAdmin.setVisible(false);
        cardPanelUser.setVisible(false);
        cardPanelPartner.setVisible(false);
        buttonContainerAdmin.setVisible(false);
        buttonContainerUser.setVisible(false);
        buttonContainerPartner.setVisible(false);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splashPanel.setVisible(false);
        cardPanel1.setVisible(true);
    }

    public static void setCardPanelAdmin() {
        adminHomePanel = new AdminHomePanel();
        adminFlightPanel = new AdminFlightPanel();
        adminTrainPanel = new AdminTrainPanel();
        adminBusPanel = new AdminBusPanel();
        adminHotelPanel = new AdminHotelPanel();
        adminUserPanel = new AdminUserPanel();
        adminPartnerPanel = new AdminPartnerPanel();
        adminProfilePanel = new AdminProfilePanel();
        
        cardPanelAdmin.add(adminHomePanel, "adminHomePanel");
        cardPanelAdmin.add(adminFlightPanel, "adminFlightPanel");
        cardPanelAdmin.add(adminTrainPanel, "adminTrainPanel");
        cardPanelAdmin.add(adminBusPanel, "adminBusPanel");
        cardPanelAdmin.add(adminHotelPanel, "adminHotelPanel");
        cardPanelAdmin.add(adminUserPanel, "adminUserPanel");
        cardPanelAdmin.add(adminPartnerPanel, "adminPartnerPanel");
        cardPanelAdmin.add(adminProfilePanel, "adminProfilePanel");
    }

    public static void setCardPanelUser() {
        userHomePanel = new UserHomePanel();
        userFlightPanel = new UserFlightPanel();
        userTrainPanel = new UserTrainPanel();
        userBusPanel = new UserBusPanel();
        userHotelPanel = new UserHotelPanel();
        userOrderPanel = new UserOrderPanel();
        userProfilePanel = new UserProfilePanel();

        cardPanelUser.add(userHomePanel, "userHomePanel");
        cardPanelUser.add(userFlightPanel, "userFlightPanel");
        cardPanelUser.add(userTrainPanel, "userTrainPanel");
        cardPanelUser.add(userBusPanel, "userBusPanel");
        cardPanelUser.add(userHotelPanel, "userHotelPanel");
        cardPanelUser.add(userOrderPanel, "userOrderPanel");
        cardPanelUser.add(userProfilePanel, "userProfilePanel");
    }

    public static void setSearchFlight(String departureCity, String destinationCity, String noPassenger, String departureDate, String seatClass) {
        SearchFlightPanel searchFlightPanel = new SearchFlightPanel(departureCity, destinationCity, noPassenger, departureDate, seatClass);
        cardPanelUser.add(searchFlightPanel, "searchFlightPanel");
    }

    public static void setCardPanelPartner(String partnerType) {

        switch (partnerType) {
        case "Flight":
            partnerFlightShowPanel = new PartnerFlightShowPanel();
            partnerFlightAddPanel = new PartnerFlightAddPanel();
            panel1 = new Panel1();

            cardPanelPartner.add(partnerFlightShowPanel, "partnerFlightShowPanel");
            cardPanelPartner.add(partnerFlightAddPanel, "partnerFlightAddPanel");
            cardPanelPartner.add(panel1, "panel1");
            cardLayout.show(cardPanelPartner, "partnerFlightShowPanel");
            break;
        case "Train":
            partnerTrainShowPanel = new PartnerTrainShowPanel();
            partnerTrainAddPanel = new PartnerTrainAddPanel();
            panel1 = new Panel1();

            cardPanelPartner.add(partnerTrainShowPanel, "partnerTrainShowPanel");
            cardPanelPartner.add(partnerTrainAddPanel, "partnerTrainAddPanel");
            cardPanelPartner.add(panel1, "panel1");
            cardLayout.show(cardPanelPartner, "partnerTrainShowPanel");
            break;
        case "Bus":
            partnerBusShowPanel = new PartnerBusShowPanel();
            partnerBusAddPanel = new PartnerBusAddPanel();
            panel1 = new Panel1();

            cardPanelPartner.add(partnerBusShowPanel, "partnerBusShowPanel");
            cardPanelPartner.add(partnerBusAddPanel, "partnerBusAddPanel");
            cardPanelPartner.add(panel1, "panel1");
            cardLayout.show(cardPanelPartner, "partnerBusShowPanel");
            break;
        case "Hotel":
            partnerHotelShowPanel = new PartnerHotelShowPanel();
            partnerHotelAddPanel = new PartnerHotelAddPanel();
            panel1 = new Panel1();

            cardPanelPartner.add(partnerHotelShowPanel, "partnerHotelShowPanel");
            cardPanelPartner.add(partnerHotelAddPanel, "partnerHotelAddPanel");
            cardPanelPartner.add(panel1, "panel1");
            cardLayout.show(cardPanelPartner, "partnerHotelShowPanel");
            break;
        default:
            break;
        }

        partnerProfilePanel = new PartnerProfilePanel();
        cardPanelPartner.add(partnerProfilePanel, "partnerProfilePanel");
    }
}