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
import java.awt.Dimension;
import java.awt.Toolkit;

public class LoginForm {

    public LoginForm() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
       
        // object
        Controller controller = new Controller();

        JFrame fLogin = new JFrame("Login Form");
        fLogin.setSize((int)width-100, (int)height-100);
        fLogin.setLayout(null);
        
        JPanel bigPanel = new JPanel();
        bigPanel.setSize((int)width-100, (int)height-100);
        bigPanel.setLayout(null);
        bigPanel.setBackground(new Color(23,42,62));

        fLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(new Color(32,59,87));
        panelLogin.setBounds((int)width/5+100,(int)height/6,900, 550);
        panelLogin.setLayout(null);
       

        JLabel lLogin = new JLabel("Welcome!");
        lLogin.setFont(new Font("Tahoma", Font.BOLD, 34));
        lLogin.setBounds(panelLogin.getWidth()/3+80, 15, 300, 30);
        lLogin.setForeground(Color.white);

        JLabel moto = new JLabel("Start Your Journey Today");
        moto.setFont(new Font ("Sans-serif",Font.ITALIC,16));
        moto.setForeground(Color.white);
        moto.setBounds(lLogin.getX()-5,lLogin.getY()+50,310 ,30);
        moto.setLayout(null);

    

        // username input
        JLabel lUsername = new JLabel("USERNAME ");
        lUsername.setFont(new Font("Tahoma", Font.BOLD, 19));
        lUsername.setBounds(panelLogin.getWidth()/3+100, 70, 120, 150);
        lUsername.setForeground(Color.WHITE);

        JTextField jtUsername = new JTextField();
        jtUsername.setBounds(lLogin.getWidth(), lUsername.getY()+100, 310, 30);

        // password input
        JLabel lPassword = new JLabel("PASSWORD ");
        lPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
        lPassword.setBounds(panelLogin.getWidth()/3+100, jtUsername.getY(), 120, 150);
        lPassword.setForeground(Color.WHITE);

        JPasswordField jPassword = new JPasswordField();
        jPassword.setBounds(lLogin.getWidth(), lPassword.getY()+100, 310, 30);

        // button
        JButton btnLogin = new JButton("Log In");
        btnLogin.setBounds(lLogin.getWidth(), jPassword.getY()+100, 310, 50);
        btnLogin.setBackground(new Color(57,189,118));
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = controller.CheckLogin(jtUsername.getText(), jPassword.getText());
                if (check) {
                    fLogin.dispose();
                    new MainMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Please insert all the field correctly !", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JLabel info = new JLabel("Don't have Account ?");
        info.setFont(new Font("Tahoma",Font.PLAIN,12));
        info.setForeground(Color.white);
        info.setBounds(15,btnLogin.getY()+120,150,30);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(info.getX()+130, info.getY(), 90, 30);
        btnRegister.setBackground(new Color(32,59,87));
        btnRegister.setForeground(new Color(57,189,118));
        
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fLogin.dispose();
                new RegisterStatus();
            }
        });

        // add to panel
        panelLogin.add(lLogin);
        panelLogin.add(moto);
        panelLogin.add(lUsername);
        panelLogin.add(lPassword);
        panelLogin.add(info);
        panelLogin.add(jtUsername);
        panelLogin.add(jPassword);
        panelLogin.add(btnLogin);    
        panelLogin.add(btnRegister);

        bigPanel.add(panelLogin);
        // add to Frame
        fLogin.add(bigPanel);

        bigPanel.setVisible(true);
        panelLogin.setVisible(true);
        fLogin.setVisible(true);

    }

}
