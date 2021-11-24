package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.QueryController;
import model.User;

public class RegisterUserPanel extends JPanel implements ActionListener, ItemListener {
    
    // Declaring variable
    JPanel logoPanel, formPanel;
    JLabel logo, lTitle, lUsername, lPassword, lVerify, lEmail, lFullname, lAddress;
    JPasswordField pfPassword, pfVerify;
    char passwordDefault, verifyDefault;
    JTextField tfUsername, tfEmail, tfFullname;
    JTextArea taAddress;
    JCheckBox showPassword, showVerify;
    JButton btnRegister, btnBack;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public RegisterUserPanel() {

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(0, 0, width, height);
        this.setLayout(null);

        // Set JPanel (container)
        logoPanel = new JPanel();
        logoPanel.setBounds(0, 0, width/4, height);
        logoPanel.setLayout(null);
        logoPanel.setBackground(ConstColor.PURPLE1);

        formPanel = new JPanel();
        formPanel.setBounds(logoPanel.getWidth(), 0, width - logoPanel.getWidth(), height);
        formPanel.setLayout(null);
        formPanel.setBackground(ConstColor.PURPLE2);

        // Set JLabel (with image)
        ImageIcon icon = new ImageIcon("src\\source\\Logo_Splashscreen.png");
        Image scaleImage = icon.getImage().getScaledInstance(220, 250, Image.SCALE_SMOOTH);
        logo = new JLabel(new ImageIcon(scaleImage));
        logo.setBounds(logoPanel.getWidth()/2-110, height/2 - 200, 220, 250);
        
        // Set JLabel (lTitle)
        lTitle = new JLabel("Join The Journey");
        lTitle.setBounds(20, 15, 300, 50);
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("ARIAL", Font.BOLD, 30));

        // Set JLabel (lUsername)
        lUsername = new JLabel("Username");
        lUsername.setForeground(ConstColor.WHITE);
        lUsername.setFont(new Font("Arial", Font.PLAIN, 20));
        lUsername.setBounds(lTitle.getX(), lTitle.getY() + 70, 120, 50);

        // Set JTextfield (tfUsername)
        tfUsername = new JTextField();
        tfUsername.setForeground(ConstColor.WHITE);
        tfUsername.setBackground(ConstColor.PURPLE3);
        tfUsername.setBounds(lTitle.getX(), lUsername.getY() + 40, 300, 40);
        tfUsername.setMargin(new Insets(0, 10, 0, 0));

        // Set JLabel (lPassword)
        lPassword = new JLabel("Password");
        lPassword.setForeground(ConstColor.WHITE);
        lPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        lPassword.setBounds(lTitle.getX(), tfUsername.getY() + 70, 120, 50);

        // Set JPasswordField (pfPassword)
        pfPassword = new JPasswordField();
        pfPassword.setForeground(ConstColor.WHITE);
        pfPassword.setBackground(ConstColor.PURPLE3);
        pfPassword.setBounds(lTitle.getX(), lPassword.getY() + 40, 300, 40);
        pfPassword.setMargin(new Insets(0, 10, 0, 0));

        // Set JCheckBok (for showing pfPassword)
        showPassword = new JCheckBox("Show Password");
        showPassword.setForeground(ConstColor.WHITE);
        showPassword.setBackground(ConstColor.PURPLE2);
        showPassword.setBounds(lTitle.getX(), pfPassword.getY() + 40, 120, 20);
        passwordDefault = pfPassword.getEchoChar();
        showPassword.addItemListener(this);

        // Set JLabel (lVerify)
        lVerify = new JLabel("Verify Password");
        lVerify.setForeground(ConstColor.WHITE);
        lVerify.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lVerify.setBounds(lTitle.getX(), pfPassword.getY() + 70, 150, 50);

        // Set JPasswordField (pfVerify)
        pfVerify = new JPasswordField();
        pfVerify.setForeground(ConstColor.WHITE);
        pfVerify.setBackground(ConstColor.PURPLE3);
        pfVerify.setBounds(lTitle.getX(), lVerify.getY() + 40, 300, 40);
        pfVerify.setMargin(new Insets(0, 10, 0, 0));

        // Set JCheckBok (for showing pfVerify)
        showVerify = new JCheckBox("Show Verify");
        showVerify.setForeground(ConstColor.WHITE);
        showVerify.setBackground(ConstColor.PURPLE2);
        showVerify.setBounds(lTitle.getX(), pfVerify.getY() + 40, 120, 20);
        verifyDefault = pfVerify.getEchoChar();
        showVerify.addItemListener(this);

        // Set Jlabel (lEmail)
        lEmail = new JLabel("Email");
        lEmail.setForeground(ConstColor.WHITE);
        lEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        lEmail.setBounds(400, lUsername.getY(), 120, 50);

        // Set Jtextfield (tfEmail)
        tfEmail = new JTextField();
        tfEmail.setForeground(ConstColor.WHITE);
        tfEmail.setBackground(ConstColor.PURPLE3);
        tfEmail.setBounds(lEmail.getX(), lEmail.getY() + 40, 300, 40);
        tfEmail.setMargin(new Insets(0, 10, 0, 0));

        // Set Jlabel (lFullname)
        lFullname = new JLabel("Fullname");
        lFullname.setForeground(ConstColor.WHITE);
        lFullname.setFont(new Font("Arial", Font.PLAIN, 20));
        lFullname.setBounds(lEmail.getX(), tfEmail.getY() + 70, 120, 50);

        // Set JTextfield (tfFullname)
        tfFullname = new JTextField();
        tfFullname.setForeground(ConstColor.WHITE);
        tfFullname.setBackground(ConstColor.PURPLE3);
        tfFullname.setBounds(lEmail.getX(), lFullname.getY() + 40, 300, 40);
        tfFullname.setMargin(new Insets(0, 10, 0, 0));

        // Set Jlabel (lAddress)
        lAddress = new JLabel("Address");
        lAddress.setForeground(ConstColor.WHITE);
        lAddress.setFont(new Font("Arial", Font.PLAIN, 20));
        lAddress.setBounds(lEmail.getX(), tfFullname.getY() + 70, 120, 50);

        // Set JTextArea (taAddress)
        taAddress = new JTextArea();
        taAddress.setForeground(ConstColor.WHITE);
        taAddress.setBackground(ConstColor.PURPLE3);
        taAddress.setBounds(lEmail.getX(), lAddress.getY() + 40, 300, 100);
        taAddress.setMargin(new Insets(10, 10, 0, 0));
        taAddress.setBorder(new JTextField().getBorder());

        // Set JButton (btnRegister)
        btnRegister = new JButton("Register");
        btnRegister.setForeground(ConstColor.WHITE);
        btnRegister.setBackground(ConstColor.PURPLE4);
        btnRegister.setBounds(lUsername.getX(), taAddress.getY() + 250, 200, 40);
        btnRegister.setFont(new Font("Arial", Font.PLAIN, 20));
        btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegister.addActionListener(this);

        // Set JButton (btnBack)
        btnBack = new JButton("Back");
        btnBack.setForeground(ConstColor.WHITE);
        btnBack.setBackground(ConstColor.PURPLE4);
        btnBack.setBounds(btnRegister.getX() + btnRegister.getWidth() + 40, btnRegister.getY(), 200, 40);
        btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(this);

        // Adding components
        logoPanel.add(logo);
        this.add(logoPanel);

        formPanel.add(lTitle);
        formPanel.add(lUsername);
        formPanel.add(tfUsername);
        formPanel.add(lPassword);
        formPanel.add(pfPassword);
        formPanel.add(showPassword);
        formPanel.add(lVerify);
        formPanel.add(pfVerify);
        formPanel.add(showVerify);
        formPanel.add(lEmail);
        formPanel.add(tfEmail);
        formPanel.add(lFullname);
        formPanel.add(tfFullname);
        formPanel.add(lAddress);
        formPanel.add(taAddress);
        formPanel.add(btnRegister);
        formPanel.add(btnBack);
        this.add(formPanel);

        // Set vicibility
        this.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox checkbox = (JCheckBox) e.getItem();
        String text = checkbox.getText();

        switch (text) {
            case "Show Password":
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    pfPassword.setEchoChar((char) 0);
                } else {
                    pfPassword.setEchoChar(passwordDefault);
                }
                break;
            case "Show Verify":
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    pfVerify.setEchoChar((char) 0);
                } else {
                    pfVerify.setEchoChar(verifyDefault);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        String name = button.getText();

        switch (name) {
            case "Register":
                
                // Get value
                String username = tfUsername.getText();
                String password = String.valueOf(pfPassword.getPassword());
                String verify = String.valueOf(pfVerify.getPassword());
                String email = tfEmail.getText();
                String fullname = tfFullname.getText();
                String address = taAddress.getText();

                if (username.equals("") || password.equals("") || verify.equals("") || email.equals("") || fullname.equals("") || address.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all field !");
                } else if (!password.equals(verify)){
                    JOptionPane.showMessageDialog(null, "Verify password failed !");
                } else {
                    
                    // Check if email / username already taken
                    QueryController queryController = new QueryController();

                    int emailTaken = queryController.isEmailTaken(email);
                    switch (emailTaken) {
                        case 0:

                            int usernameTaken = queryController.isUsernameTaken(username);
                            switch (usernameTaken) {
                                case 0:
                                    
                                    // Make new user and insert to database
                                    User newUser = new User(fullname, username, email, password, address);

                                    boolean success = queryController.insertUser(newUser);

                                    if (success) {
                                        JOptionPane.showMessageDialog(null, "Register success");
                                        MainFrame.cardLayout.show(MainFrame.cardPanel1, "loginPanel");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Register failed");
                                    }
                                    break;
                                case 1:
                                JOptionPane.showMessageDialog(null, "Username already taken");
                                    break;
                                case -1:
                                    JOptionPane.showMessageDialog(null, "Database connection failed");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "Email already taken");
                            break;
                        case -1:
                            JOptionPane.showMessageDialog(null, "Database connection failed");
                            break;
                        default:
                            break;
                    }
                }
                break;
            case "Back":
                MainFrame.cardLayout.show(MainFrame.cardPanel1, "loginPanel");
                break;
            default:
                break;
        }
        
    }
}
