package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.JLabel;
import controller.Controller;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class RegisterStatus implements MouseInputListener {
    Dimension screenSize;
    double width;
    double height;
    JFrame frame;
    JPanel bigPanel, registerPanel;
    JLabel logo, moto, lRegister;
    JButton btnTraveller, btnPartner;

    public RegisterStatus() {
        
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.getWidth();
        height = screenSize.getHeight();

        frame = new JFrame("Register As");
        frame.setSize((int) width , (int) height );
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        bigPanel = new JPanel();
        bigPanel.setSize((int) width, (int) height);
        bigPanel.setLayout(null);
        bigPanel.setBackground(new Color(40, 25, 54));

        registerPanel = new JPanel();
        registerPanel.setBackground(new Color(60, 46, 72));
        registerPanel.setBounds((int) width / 5 + 100, (int) height / 6, 900, 550);
        registerPanel.setLayout(null);

        lRegister = new JLabel("Register");
        lRegister.setFont(new Font("Tahoma", Font.BOLD, 34));
        lRegister.setBounds(registerPanel.getWidth() / 3 + 80, 15, 300, 45);
        lRegister.setForeground(Color.white);
        lRegister.setLayout(null);

        moto = new JLabel("Start Your Journey Today");
        moto.setFont(new Font("Sans-serif", Font.ITALIC, 16));
        moto.setForeground(Color.white);
        moto.setBounds(lRegister.getX() - 15, lRegister.getY() + 50, 310, 30);
        moto.setLayout(null);

        btnTraveller = new JButton("Traveller");
        btnTraveller.setBounds((int) width / 5 - 300, moto.getY() + 70, 350, 350);
        btnTraveller.setFont(new Font("Tahoma", Font.BOLD, 40));
        btnTraveller.setBackground(new Color (60, 46, 72));
        btnTraveller.setForeground(Color.white);
        btnTraveller.addMouseListener(this);

        btnPartner = new JButton("Partner");
        btnPartner.setBounds((int) width / 5 + 100, moto.getY() + 70, 350, 350);
        btnPartner.setFont(new Font("Tahoma", Font.BOLD, 40));
        btnPartner.setBackground(new Color (60, 46, 72));
        btnPartner.setForeground(Color.white);
        btnPartner.addMouseListener(this);

        registerPanel.add(lRegister);
        registerPanel.add(moto);
        registerPanel.add(btnTraveller);
        registerPanel.add(btnPartner);
        
        bigPanel.add(registerPanel);
        frame.add(bigPanel);

        registerPanel.setVisible(true);
        bigPanel.setVisible(true);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();

        switch (name) {
        case "Traveller":
            //masukin queery untuk traveller disini 
            frame.dispose();
            new RegisterForm();
            break;

        case "Partner":
           //masukin queery untuk partner disini 
            frame.dispose();
            new RegisterFormPartner();
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
        component.setBackground(new Color(60, 46, 72));
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
