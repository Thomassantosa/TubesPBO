package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import controller.Controller;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import controller.QueryController;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ItemListener;

public class RegisterForm implements MouseInputListener, ItemListener {

    JFrame frameRegister;
    JPanel bigPanel, panelLogo;
    JLabel logo, title, lUsername, lPassword, lRetype, lEmail, lFullname, lAddress, lCompany;
    JPasswordField password, retype;
    JTextField username, email, fullname, company;
    JTextArea address;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    JCheckBox showPassword, showRetype;
    JButton regisButton;

    public RegisterForm() {
        QueryController controller = new QueryController();

        // image
        ImageIcon icon = new ImageIcon("src\\source\\Logo_Splashscreen.png");
        Image scaleImage = icon.getImage().getScaledInstance(220, 250, Image.SCALE_REPLICATE);

        // frame
        frameRegister = new JFrame("Register");
        frameRegister.setSize((int) width, (int) height);
        frameRegister.setLayout(null);
        frameRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegister.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // panel
        bigPanel = new JPanel();
        bigPanel.setSize((int) width, (int) height);
        bigPanel.setLayout(null);
        bigPanel.setBackground(new Color(60, 46, 72));

        panelLogo = new JPanel();
        panelLogo.setSize(500, (int) height);
        panelLogo.setLayout(null);
        panelLogo.setBackground(new Color(40, 25, 54));

        // lable
        logo = new JLabel(new ImageIcon(scaleImage));
        logo.setBounds(0, (int) height / 6, 500, 650);

        title = new JLabel("Join The Journey");
        title.setBounds(panelLogo.getWidth() + 150, 15, 300, 100);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Tahoma", Font.BOLD, 35));

        // label username
        lUsername = new JLabel("Username");
        lUsername.setForeground(Color.white);
        lUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lUsername.setBounds(title.getX(), title.getHeight() + 50, 120, 50);

        // textfield
        username = new JTextField();
        username.setBackground(new Color(100, 88, 110));
        username.setForeground(Color.white);
        username.setBounds(lUsername.getX(), lUsername.getY() + 50, 300, 40);

        // label password
        lPassword = new JLabel("Password");
        lPassword.setForeground(Color.white);
        lPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lPassword.setBounds(title.getX(), lUsername.getY() + 120, 120, 50);

        // pass field
        password = new JPasswordField();
        password.setBackground(new Color(100, 88, 110));
        password.setForeground(Color.white);
        password.setBounds(lPassword.getX(), lPassword.getY() + 50, 300, 40);

        // button for showing password
        showPassword = new JCheckBox("Show Password");
        showPassword.setForeground(Color.white);
        showPassword.setBackground(new Color(60, 46, 72));
        showPassword.setBounds(title.getX(), password.getY() + 60, 120, 20);

        // to get default char
        char passwordDefault = password.getEchoChar();
        showPassword.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    password.setEchoChar((char) 0);
                } else {
                    password.setEchoChar(passwordDefault);
                }
            }
        });

        // label re password
        lRetype = new JLabel("Verify Password");
        lRetype.setForeground(Color.white);
        lRetype.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lRetype.setBounds(title.getX(), lPassword.getY() + 150, 250, 50);

        // re password field
        retype = new JPasswordField();
        retype.setBackground(new Color(100, 88, 110));
        retype.setForeground(Color.white);
        retype.setBounds(title.getX(), lRetype.getY() + 50, 300, 40);

        // button for showing re password
        showRetype = new JCheckBox("Show Password");
        showRetype.setForeground(Color.white);
        showRetype.setBackground(new Color(60, 46, 72));
        showRetype.setBounds(title.getX(), retype.getY() + 60, 120, 20);

        // to get default char
        char retypeDefault = retype.getEchoChar();
        showRetype.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    retype.setEchoChar((char) 0);
                } else {
                    retype.setEchoChar(retypeDefault);
                }
            }
        });

        // label email
        lEmail = new JLabel("Email");
        lEmail.setForeground(Color.white);
        lEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lEmail.setBounds(username.getX() + username.getWidth() + 200, lUsername.getY(), 120, 50);

        // textfield for email
        email = new JTextField();
        email.setBackground(new Color(100, 88, 110));
        email.setForeground(Color.white);
        email.setBounds(username.getX() + username.getWidth() + 200, lEmail.getY() + 50, 300, 40);

        // label fullname
        lFullname = new JLabel("Fullname");
        lFullname.setForeground(Color.white);
        lFullname.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lFullname.setBounds(username.getX() + username.getWidth() + 200, lEmail.getY() + 120, 120, 50);

        // textfield for fullname
        fullname = new JTextField();
        fullname.setBackground(new Color(100, 88, 110));
        fullname.setForeground(Color.white);
        fullname.setBounds(username.getX() + username.getWidth() + 200, lFullname.getY() + 50, 300, 40);

        // label for address
        lAddress = new JLabel("Address");
        lAddress.setForeground(Color.white);
        lAddress.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lAddress.setBounds(username.getX() + username.getWidth() + 200, lFullname.getY() + 120, 120, 50);

        // textfield for address;
        address = new JTextArea();
        address.setBackground(new Color(100, 88, 110));
        address.setForeground(Color.white);
        address.setBounds(username.getX() + username.getWidth() + 200, lAddress.getY() + 50, 300, 150);

        lCompany = new JLabel("Company Name");
        lCompany.setForeground(Color.white);
        lCompany.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lCompany.setBounds(username.getX() + username.getWidth() + 200, lAddress.getY() + 200, 250, 50);

        // textfield
        company = new JTextField();
        company.setBackground(new Color(100, 88, 110));
        company.setForeground(Color.white);
        company.setBounds(username.getX() + username.getWidth() + 200, lCompany.getY() + 50, 300, 40);

        // Register Button
        regisButton = new JButton("Register");
        regisButton.setForeground(Color.white);
        regisButton.setBackground(new Color(136, 94, 254));
        regisButton.setBounds(title.getX(), company.getY() + company.getHeight() + 150, 250, 40);
        regisButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
        regisButton.addMouseListener(this);

        // add to panel
        panelLogo.add(logo);
        bigPanel.add(panelLogo);
        bigPanel.add(title);

        bigPanel.add(lUsername);
        bigPanel.add(username);

        bigPanel.add(lPassword);
        bigPanel.add(password);
        bigPanel.add(showPassword);

        bigPanel.add(lRetype);
        bigPanel.add(retype);
        bigPanel.add(showRetype);

        bigPanel.add(lEmail);
        bigPanel.add(email);

        bigPanel.add(lFullname);
        bigPanel.add(fullname);

        bigPanel.add(lAddress);
        bigPanel.add(address);

        bigPanel.add(lCompany);
        bigPanel.add(company);
        bigPanel.add(regisButton);

        // add to Frame
        frameRegister.add(bigPanel);

        // set visible
        panelLogo.setVisible(true);
        bigPanel.setVisible(true);
        frameRegister.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();

        switch (name) {
        case "Register":
            // controller for checking , and queery for inserting to database
            frameRegister.dispose();
            new MainMenu();
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
        Component component = e.getComponent();
        component.setBackground(new Color(4, 170, 168));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(new Color(136, 94, 254));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Not implemented
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Not implemented
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // already implemented in top

    }

}
