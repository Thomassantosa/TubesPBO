package test;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.QueryController;
import controller.SingletonManager;
import model.User;

public class PartnerProfilePanel extends JPanel implements ActionListener, ItemListener {
    
    // Declaring variable
    JLabel lTitle, lUsername, lPassword, lVerify, lEmail, lFullname, lAddress;
    JPasswordField pfPassword, pfVerify;
    char passwordDefault, verifyDefault;
    JTextField tfUsername, tfEmail, tfFullname;
    JTextArea taAddress;
    JCheckBox showPassword, showVerify;
    JButton btnUpdate;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public PartnerProfilePanel() {

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);
        
        // Set JLabel (lTitle)
        lTitle = new JLabel("Your Profile");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);

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
        tfUsername.setText(SingletonManager.getInstance().getPartner().getUsername());
        // tfUsername.setText("SingletonManager.getInstance().getUser().getUsername()");
        System.out.println("value = " + SingletonManager.getInstance().getPartner().getUsername());
        System.out.println(SingletonManager.getInstance().getPartner().getUsername().getClass());
        System.out.println(SingletonManager.getInstance().getPartner().toString() + "\n");

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
        pfPassword.setText(SingletonManager.getInstance().getPartner().getPassword());

        // Set JCheckBok (for showing pfPassword)
        showPassword = new JCheckBox("Show Password");
        showPassword.setForeground(ConstColor.WHITE);
        showPassword.setBackground(ConstColor.PURPLE1);
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
        pfVerify.setText(SingletonManager.getInstance().getPartner().getPassword());

        // Set JCheckBok (for showing pfVerify)
        showVerify = new JCheckBox("Show Verify");
        showVerify.setForeground(ConstColor.WHITE);
        showVerify.setBackground(ConstColor.PURPLE1);
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
        tfEmail.setText(SingletonManager.getInstance().getPartner().getEmail());

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
        tfFullname.setText(SingletonManager.getInstance().getPartner().getFullname());

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
        taAddress.setText(SingletonManager.getInstance().getPartner().getAddress());

        // Set JButton (btnUpdate)
        btnUpdate = new JButton("Update");
        btnUpdate.setForeground(ConstColor.WHITE);
        btnUpdate.setBackground(ConstColor.PURPLE4);
        btnUpdate.setBounds(lUsername.getX(), taAddress.getY() + 250, 250, 40);
        btnUpdate.setFont(new Font("Arial", Font.PLAIN, 20));
        btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(this);

        // Adding components

        this.add(lTitle);
        this.add(lUsername);
        this.add(tfUsername);
        this.add(lPassword);
        this.add(pfPassword);
        this.add(showPassword);
        this.add(lVerify);
        this.add(pfVerify);
        this.add(showVerify);
        this.add(lEmail);
        this.add(tfEmail);
        this.add(lFullname);
        this.add(tfFullname);
        this.add(lAddress);
        this.add(taAddress);
        this.add(btnUpdate);

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
            
            QueryController queryController = new QueryController();
            
            boolean somethingChanged = !username.equals(SingletonManager.getInstance().getPartner().getUsername()) ||
            !password.equals(SingletonManager.getInstance().getPartner().getUsername()) ||
            !email.equals(SingletonManager.getInstance().getPartner().getEmail()) ||
            !fullname.equals(SingletonManager.getInstance().getPartner().getEmail()) ||
            !address.equals(SingletonManager.getInstance().getPartner().getAddress());

            if (somethingChanged) {
                
                boolean willUpdate = false;
                int emailTaken = -1;
                int usernameTaken = -1;

                if (!username.equals(SingletonManager.getInstance().getPartner().getUsername()) && !email.equals(SingletonManager.getInstance().getPartner().getEmail())) {
                    emailTaken = queryController.isEmailTaken(email);
                    usernameTaken = queryController.isUsernameTaken(username);
                    if (emailTaken == 0 && usernameTaken == 0) {
                        willUpdate = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or Email already taken");
                    }
                } else if (!username.equals(SingletonManager.getInstance().getPartner().getUsername())) {
                    usernameTaken = queryController.isUsernameTaken(username);
                    if (usernameTaken == 0) {
                        willUpdate = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Username already taken");
                    }
                } else if (!email.equals(SingletonManager.getInstance().getPartner().getEmail())) {
                    emailTaken = queryController.isEmailTaken(email);
                    if (emailTaken == 0) {
                        willUpdate = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Email already taken");
                    }
                }

                if (willUpdate) {
                    // Update database
                    int userID = SingletonManager.getInstance().getPartner().getUserID();
                    User updateUser = new User(fullname, username, email, password, address);

                    JOptionPane.showMessageDialog(null, "ON PROGRESS");
                    // boolean success = queryController.updateUser(userID, updateUser);

                    // if (success) {
                    //     JOptionPane.showMessageDialog(null, "Update success");
                    // } else {
                    //     JOptionPane.showMessageDialog(null, "Update failed");
                    // }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nothing changed");
            }
        }
    }
}
