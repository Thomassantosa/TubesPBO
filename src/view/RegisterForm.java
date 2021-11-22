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
import controller.QueryController;


public class RegisterForm {

    public RegisterForm() {
        QueryController controller = new QueryController();

        // frame
        JFrame fRegister = new JFrame("Registration");
        fRegister.setSize(550, 650);
        fRegister.setLayout(null);
  
        fRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // panel
        JPanel panelRegister = new JPanel();
        panelRegister.setBackground(new Color(129, 173, 181));
        panelRegister.setSize(550, 650);
        panelRegister.setLayout(null);
       

        // lable
        JLabel lRegister = new JLabel("Hello!");
        lRegister.setFont(new Font("Sans-Serif", Font.BOLD, 45));
        lRegister.setBounds(200, 5, 300, 80);

        JLabel lInfo = new JLabel("Please insert your data !");
        lInfo.setFont(new Font("Helvetica", Font.ITALIC, 15));
        lInfo.setBounds(180, 90, 300, 30);

        JLabel lFullname = new JLabel("Full name :");
        lFullname.setBounds(25, 150, 200, 30);
        lFullname.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lUsername = new JLabel("Username :");
        lUsername.setBounds(25, 200, 200, 30);
        lUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lEmail = new JLabel("Email :");
        lEmail.setBounds(25, 250, 200, 30);
        lEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lPassword = new JLabel("Password :");
        lPassword.setBounds(25, 300, 200, 30);
        lPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lRetype = new JLabel("Re-Type Password :");
        lRetype.setBounds(25, 350, 220, 30);
        lRetype.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lAddress = new JLabel("Address :");
        lAddress.setBounds(25, 400, 200, 30);
        lAddress.setFont(new Font("Tahoma ", Font.PLAIN, 20));

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(200, 500, 120, 50);

        // textfield
        JTextField jtFullname = new JTextField();
        jtFullname.setBounds(250, 150, 200, 25);

        JTextField jtUsername = new JTextField();
        jtUsername.setBounds(250, 200, 200, 25);

        JTextField jtEmail = new JTextField();
        jtEmail.setBounds(250, 250, 200, 25);

        JTextField jtAddress = new JTextField();
        jtAddress.setBounds(250, 400, 200, 25);

        // PasswordFIeld;
        JPasswordField jPassword = new JPasswordField();
        jPassword.setBounds(250, 300, 200, 25);

        JPasswordField jRetype = new JPasswordField();
        jRetype.setBounds(250, 350, 200, 25);

        // action
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = controller.CheckRegistration();
                if (result) {
                    controller.insertData();
                    fRegister.dispose();
                    new MainMenu();
                }
            }
        });

        // add to panel
        panelRegister.add(lRegister);
        panelRegister.add(btnRegister);
        panelRegister.add(lInfo);
        panelRegister.add(lFullname);
        panelRegister.add(lUsername);
        panelRegister.add(lEmail);
        panelRegister.add(lPassword);
        panelRegister.add(lRetype);
        panelRegister.add(lAddress);
        panelRegister.add(jtAddress);
        panelRegister.add(jtEmail);
        panelRegister.add(jtFullname);
        panelRegister.add(jtUsername);
        panelRegister.add(jPassword);
        panelRegister.add(jRetype);

        panelRegister.setVisible(true);
        // add to Frame
        fRegister.add(panelRegister);
        fRegister.setVisible(true);

    }
}
