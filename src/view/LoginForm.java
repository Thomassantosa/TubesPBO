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

public class LoginForm {

    public LoginForm() {
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

        //username input
        JLabel lUsername = new JLabel("USERNAME ");
        lUsername.setFont( new Font("Tahoma", Font.BOLD, 15));
        lUsername.setBounds(180, 50, 100, 100);

        JTextField jtUsername = new JTextField();
        jtUsername.setBounds(115, 130, 220, 30);
        

        //password input
        JLabel lPassword = new JLabel("PASSWORD ");
        lPassword.setFont( new Font("Tahoma", Font.BOLD, 15));
        lPassword.setBounds(180, 140, 100, 100);

        JPasswordField jPassword = new JPasswordField();
        jPassword.setBounds(115, 220,220, 30);

        // JButton btnLogin = new JButton("Log In");
        // btnLogin.setBounds(50, 170, 90, 50);
        // JButton btnRegister = new JButton("Register");
        // btnRegister.setBounds(150, 170, 90, 50);
        // JButton btnQuit = new JButton("Quit");
        // btnQuit.setBounds(250, 170, 90, 50);

        // add to panel
        panelLogin.add(lLogin);
        panelLogin.add(lUsername);
        panelLogin.add(lPassword);
        panelLogin.add(jtUsername);
        panelLogin.add(jPassword);
        // panelLogin.add(btnLogin);
        // panelLogin.add(btnRegister);
        // panelLogin.add(btnQuit);

        // add to Frame
        fLogin.add(panelLogin);
    }

}
