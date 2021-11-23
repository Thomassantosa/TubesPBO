package test;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.event.MouseInputListener;

import controller.QueryController;
import controller.SingletonManager;
import model.User;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPanel extends JPanel implements ItemListener, MouseInputListener {
    
    // Declaring variable
    JPanel container;
    JLabel lTitle1, lTitle2, lUsername, lPassword, info, lRegister;
    JTextField tfUsername;
    JPasswordField pfPassword;
    JCheckBox showPassword;
    char passwordDefault;
    JButton btnLogin, btnRegister;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public LoginPanel() {

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(0, 0, width, height);
        this.setLayout(null);

        // Set JPanel (container)
        container = new RoundedPanel(30);
        container.setBounds(width/2 - 300, height/2 - 270, 600, 500);
        container.setLayout(null);
        container.setOpaque(false);
        container.setBackground(ConstColor.PURPLE2);

        // Set components
        // Set JLabel (title)
        lTitle1 = new JLabel("Welcome!");
        lTitle1.setFont(new Font("Arial", Font.BOLD, 34));
        lTitle1.setForeground(ConstColor.WHITE);
        lTitle1.setBackground(ConstColor.PURPLE4);
        lTitle1.setBounds(container.getWidth()/2 - 150, 40, 300, 30);
        lTitle1.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Set JLabel (title2)
        lTitle2 = new JLabel("Start Your Journey Today");
        lTitle2.setFont(new Font("Arial", Font.ITALIC, 16));
        lTitle2.setForeground(ConstColor.WHITE);
        lTitle2.setBounds(container.getWidth()/2 - 150, lTitle1.getY() + 30, 300, 30);
        lTitle2.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Set JLabel (username)
        lUsername = new JLabel("Email / Username ");
        lUsername.setFont(new Font("Arial", Font.BOLD, 18));
        lUsername.setForeground(ConstColor.WHITE);
        lUsername.setBounds(container.getWidth()/2 - 85, lTitle2.getY() + 40, 170, 40);
        lUsername.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Set JTextField (username)
        tfUsername = new JTextField();
        tfUsername.setBackground(ConstColor.PURPLE3);
        tfUsername.setForeground(ConstColor.WHITE);
        tfUsername.setBounds(container.getWidth()/2 - 150, lUsername.getY() + 40, 300, 40);
        tfUsername.setMargin(new Insets(0, 10, 0, 0));
        
        // Set JLabel (password)
        lPassword = new JLabel("Password");
        lPassword.setFont(new Font("Arial", Font.BOLD, 18));
        lPassword.setForeground(ConstColor.WHITE);
        lPassword.setBounds(container.getWidth()/2 - 60, tfUsername.getY() + 60, 120, 40);
        lPassword.setHorizontalAlignment(SwingConstants.CENTER);

        // Set JPasswordField (password)
        pfPassword = new JPasswordField();
        pfPassword.setBackground(ConstColor.PURPLE3);
        pfPassword.setForeground(ConstColor.WHITE);
        pfPassword.setBounds(container.getWidth()/2 - 150, lPassword.getY() + 40, 300, 40);
        pfPassword.setMargin(new Insets(0, 10, 0, 0));

        // Set JCheckbok (for showing password)
        showPassword = new JCheckBox("Show Password ");
        showPassword.setBackground(ConstColor.PURPLE2);
        showPassword.setForeground(ConstColor.WHITE);
        showPassword.setBounds(pfPassword.getX(), pfPassword.getY() + 40, 150, 20);
        passwordDefault = pfPassword.getEchoChar();
        showPassword.addItemListener(this);

        // Set JButton (login)
        btnLogin = new JButton("Login");
        btnLogin.setBounds(container.getWidth()/2 - 150, showPassword.getY() + 50, 300, 40);
        btnLogin.setBackground(ConstColor.PURPLE4);
        btnLogin.setForeground(ConstColor.WHITE);
        btnLogin.setFont(new Font("Arial", Font.PLAIN, 20));
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin.addMouseListener(this);

        // Set JLabel (register question)
        info = new JLabel("Does't have account ?");
        info.setFont(new Font("Arial", Font.PLAIN, 12));
        info.setForeground(ConstColor.WHITE);
        info.setBounds(btnLogin.getX(), btnLogin.getY() + 80, 150, 30);

        // Set JLabel (register)
        lRegister = new JLabel("Register");
        lRegister.setFont(new Font("Arial", Font.BOLD, 12));
        lRegister.setForeground(ConstColor.BLUE6);
        lRegister.setBounds(info.getX() + 130, info.getY(), 90, 30);
        lRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lRegister.addMouseListener(this);

        // Adding components
        container.add(lTitle1);
        container.add(lTitle2);
        container.add(lUsername);
        container.add(tfUsername);
        container.add(lPassword);
        container.add(pfPassword);
        container.add(showPassword);
        container.add(btnLogin);
        container.add(info);
        container.add(lRegister);
        this.add(container);

        // Set vicibility
        this.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            pfPassword.setEchoChar((char) 0);
        } else {
            pfPassword.setEchoChar(passwordDefault);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().getClass().toString().equals("class javax.swing.JButton")) {
            
            // Get value
            String email = tfUsername.getText();
            String password = String.valueOf(pfPassword.getPassword());

            // Checking value
            if (email.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all field !");
            } else {

                // Get data from database
                QueryController queryController = new QueryController();
                User user = queryController.selectUserByEmail(email, password);
                if (user == null) {
                    JOptionPane.showMessageDialog(null, "User not found");
                } else {
                    String userType = user.getUserType();
                    switch (userType) {
                        case "Admin":
                            // JOptionPane.showMessageDialog(null, "USER FOUND");

                            // Set current user data with singleton
                            SingletonManager.getInstance().setUser(user);

                            // Set UI
                            MainFrame.setCardPanelAdmin();
                            MainFrame.cardPanel1.setVisible(false);
                            MainFrame.buttonContainerAdmin.setVisible(true);
                            MainFrame.cardPanelAdmin.setVisible(true);
                            break;
                        case "User":
                            // JOptionPane.showMessageDialog(null, "USER FOUND");

                            // Set current user data with singleton
                            SingletonManager.getInstance().setUser(user);

                            // Set UI
                            MainFrame.setCardPanelUser();
                            MainFrame.cardPanel1.setVisible(false);
                            MainFrame.buttonContainerUser.setVisible(true);
                            MainFrame.cardPanelUser.setVisible(true);
                            break;
                        case "Partner":
                            JOptionPane.showMessageDialog(null, "PARTNER FOUND");


                            break;
                        default:
                            break;
                    }
                    tfUsername.setText("");
                    pfPassword.setText("");
                }
            }
        } else {
            MainFrame.cardLayout.show(MainFrame.cardPanel1, "registerStatus");
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
        // Not implemented
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Not implemented
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
