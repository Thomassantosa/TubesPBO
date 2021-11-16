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
    JPanel bigPanel , registerPanel;
    JLabel logo,moto,lRegister;
    JButton btnTraveller , btnPartner;

    public RegisterStatus() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width=screenSize.getWidth();
        height = screenSize.getHeight();
        
        frame = new JFrame("Register As");
        frame.setSize((int)width-100, (int)height-100);
        frame.setLayout(null);

        bigPanel = new JPanel();
        bigPanel.setSize((int)width-100, (int)height-100);
        bigPanel.setLayout(null);
        bigPanel.setBackground(new Color(40, 25, 54));

        registerPanel = new JPanel();
        registerPanel.setBackground(new Color(60, 46, 72));
        registerPanel.setBounds((int) width / 5 + 100, (int) height / 6, 900, 550);
        
        lRegister = new JLabel("Welcome!");
        lRegister.setFont(new Font("Tahoma", Font.BOLD, 34));
        lRegister.setBounds(registerPanel.getWidth() / 3 + 80, 15, 300, 30);
        lRegister.setForeground(Color.white);

        moto = new JLabel("Start Your Journey Today");
        moto.setFont(new Font("Sans-serif", Font.ITALIC, 16));
        moto.setForeground(Color.white);
        moto.setBounds(lRegister.getX() - 5, lRegister.getY() + 50, 310, 30);
        moto.setLayout(null);

        btnTraveller = new JButton("Traveller");
        btnTraveller.addMouseListener(this);
        
        btnPartner = new JButton("Partner");
        btnPartner.addMouseListener(this);

        registerPanel.add(lRegister,moto);
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

        switch(name) {
            case "Test":
                System.out.println("TEST BUTTON 1");
                break;
            case "":
                break;
            case "bla":
                break;
            default: 
                System.out.println("TEST BUTTON ELSE");
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
        component.setBackground(new Color(211, 228, 205));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(new Color(173, 194, 169));
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
