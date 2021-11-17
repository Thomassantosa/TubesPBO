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
import javax.swing.ImageIcon;
import java.awt.Image;


public class LoginForm {

    public LoginForm() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        // object
        Controller controller = new Controller();

        JPanel splashPanel = new JPanel();
        splashPanel.setBackground(new Color(40, 25, 54));
        splashPanel.setSize((int) width , (int) height );
        splashPanel.setLayout(null);

        // Set components
        // Set splashscreen component
        ImageIcon icon = new ImageIcon("src\\source\\Logo_Splashscreen.png");
        Image scaleImage = icon.getImage().getScaledInstance(220, 250, Image.SCALE_REPLICATE);

        JLabel lSplashLogo = new JLabel(new ImageIcon(scaleImage));
        lSplashLogo.setBounds((int) width / 5 + 65, (int) height / 6, 900, 550);

        //frame login
        JFrame fLogin = new JFrame("Login Form");
        fLogin.setSize((int) width , (int) height );
        fLogin.setLayout(null);
        fLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JPanel bigPanel = new JPanel();
        bigPanel.setSize((int) width, (int) height);
        bigPanel.setLayout(null);
        bigPanel.setBackground(new Color(40, 25, 54));



        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(new Color(60, 46, 72));
        panelLogin.setBounds((int) width / 5 + 100, (int) height / 6, 900, 550);
        panelLogin.setLayout(null);

        JLabel lLogin = new JLabel("Welcome!");
        lLogin.setFont(new Font("Tahoma", Font.BOLD, 34));
        lLogin.setBounds(panelLogin.getWidth() / 3 + 80, 15, 300, 30);
        lLogin.setForeground(Color.white);

        JLabel moto = new JLabel("Start Your Journey Today");
        moto.setFont(new Font("Sans-serif", Font.ITALIC, 16));
        moto.setForeground(Color.white);
        moto.setBounds(lLogin.getX() - 5, lLogin.getY() + 50, 310, 30);
        moto.setLayout(null);

        // username input
        JLabel lUsername = new JLabel("USERNAME ");
        lUsername.setFont(new Font("Tahoma", Font.BOLD, 19));
        lUsername.setBounds(panelLogin.getWidth() / 3 + 100, 70, 120, 150);
        lUsername.setForeground(Color.WHITE);

        JTextField jtUsername = new JTextField();
        jtUsername.setBounds(lLogin.getWidth(), lUsername.getY() + 100, 310, 30);
        jtUsername.setBackground(new Color(100,88,110));
        jtUsername.setForeground(Color.white);

        // password input
        JLabel lPassword = new JLabel("PASSWORD ");
        lPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
        lPassword.setBounds(panelLogin.getWidth() / 3 + 100, jtUsername.getY(), 120, 150);
        lPassword.setForeground(Color.WHITE);

        JPasswordField jPassword = new JPasswordField();
        jPassword.setBounds(lLogin.getWidth(), lPassword.getY() + 100, 310, 30);
        jPassword.setBackground(new Color(100,88,110));
        jPassword.setForeground(Color.white);

        // button
        JButton btnLogin = new JButton("Log In");
        btnLogin.setBounds(lLogin.getWidth(), jPassword.getY() + 100, 310, 50);
        btnLogin.setBackground(new Color(136, 94, 254));
        btnLogin.setForeground(Color.WHITE);
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
        info.setFont(new Font("Tahoma", Font.PLAIN, 12));
        info.setForeground(Color.white);
        info.setBounds(15, btnLogin.getY() + 120, 150, 30);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(info.getX() + 130, info.getY(), 90, 30);
        btnRegister.setBackground(new Color(60, 46, 72));
        btnRegister.setForeground(new Color(4, 170, 168));

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fLogin.dispose();
                new RegisterStatus();
            }
        });

        // add to panel

        splashPanel.add(lSplashLogo);

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
        fLogin.add(splashPanel);
        fLogin.add(bigPanel);

        fLogin.setVisible(true);
        splashPanel.setVisible(true);
        bigPanel.setVisible(false);
        panelLogin.setVisible(false);

        //splash screen (loading screen)
        try {
            Thread.sleep(2300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splashPanel.setVisible(false);
        panelLogin.setVisible(true);
        bigPanel.setVisible(true);

    }

}
