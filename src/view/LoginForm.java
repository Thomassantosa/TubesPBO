package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import controller.Controller;
import javax.swing.JOptionPane;

public class LoginForm {

    public LoginForm() {
        // object check
        Controller controller = new Controller();

        JFrame fLogin = new JFrame("LogIn");
        fLogin.setSize(450, 550);
        fLogin.setLayout(null);
        fLogin.setVisible(true);
        fLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(new Color(129, 173, 181));
        panelLogin.setSize(450, 550);
        panelLogin.setLayout(null);
        panelLogin.setVisible(true);

        JLabel lLogin = new JLabel("Welcome!");
        lLogin.setFont(new Font("Sans-Serif", Font.BOLD, 34));
        lLogin.setBounds(145, 15, 300, 30);

        // username input
        JLabel lUsername = new JLabel("USERNAME ");
        lUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
        lUsername.setBounds(180, 50, 100, 100);

        JTextField jtUsername = new JTextField();
        jtUsername.setBounds(115, 130, 220, 30);

        // password input
        JLabel lPassword = new JLabel("PASSWORD ");
        lPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        lPassword.setBounds(180, 140, 100, 100);

        JPasswordField jPassword = new JPasswordField();
        jPassword.setBounds(115, 220, 220, 30);

        // button
        JButton btnLogin = new JButton("Log In");
        btnLogin.setBounds(175, 280, 90, 30);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = controller.CheckLogin(jtUsername.getText(), jPassword.getText());
                if (check) {
                    fLogin.dispose();
                    new MainMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Please insert all the field correctly !", "Warning",  JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(175, 350, 90, 30);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fLogin.dispose();
                new RegisterForm();
            }
        });

        // add to panel
        panelLogin.add(lLogin);
        panelLogin.add(lUsername);
        panelLogin.add(lPassword);
        panelLogin.add(jtUsername);
        panelLogin.add(jPassword);
        panelLogin.add(btnLogin);
        panelLogin.add(btnRegister);

        // add to Frame
        fLogin.add(panelLogin);

    }

}
