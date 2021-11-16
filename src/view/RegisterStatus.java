package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import controller.Controller;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Toolkit;

public class RegisterStatus {
    Dimension screenSize;
    double width;
    double height;
    JFrame frame;
    JPanel bigPanel , registerPanel;
    JLabel logo,moto;

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
        bigPanel.setBackground(new Color(23,42,62));

        registerPanel = new JPanel();
        registerPanel.setBackground(new Color(32,59,87));
        registerPanel.setBounds((int)width/3,(int)height/6,450, 550);




        bigPanel.add(registerPanel);
        frame.add(bigPanel);

        registerPanel.setVisible(true);
        bigPanel.setVisible(true);
        frame.setVisible(true);
    }
}
