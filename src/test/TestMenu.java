package test;

import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputListener;

public class TestMenu implements MouseInputListener {
    
    // Declaring variable
    JFrame frame;
    JPanel splashPanel, panel;
    JLabel lSplashLogo, label1;
    JButton button1;
    JTextArea textArea1;
    JScrollPane scrollPane1;


    public TestMenu() {

        // Get screen size
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth()-100;
        int height = (int)size.getHeight()-100;

        // Set frame
        frame = new JFrame("Test Menu");
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set panel
        panel = new JPanel();
        panel.setBackground(new Color(254, 245, 237));
        panel.setSize(width, height);
        panel.setLayout(null);
        
        splashPanel = new JPanel();
        splashPanel.setBackground(new Color(23, 42, 62));
        splashPanel.setSize(width, height);
        splashPanel.setLayout(null);
        
        // Set components
        // Set splashscreen component
        ImageIcon icon = new ImageIcon("src\\source\\Logo_Splashscreen.png");
        Image scaleImage = icon.getImage().getScaledInstance(220, 250,Image.SCALE_SMOOTH);
        lSplashLogo = new JLabel(new ImageIcon(scaleImage));
        lSplashLogo.setBounds(width/2-110, height/2-170, 220, 250);
        
        // Set JButton
        button1 = new JButton("Test");
        button1.setBackground(new Color(173, 194, 169));
        button1.setForeground(new Color(63, 77, 63));
        button1.setBounds(width/2-110, height/2-30, 220, 60);
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        
        button1.addMouseListener(this);

        // Adding component
        splashPanel.add(lSplashLogo);
        panel.add(button1);
        frame.add(splashPanel);
        frame.add(panel);

        // Set vicibility
        frame.setVisible(true);
        splashPanel.setVisible(true);
        panel.setVisible(false);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splashPanel.setVisible(false);
        panel.setVisible(true);
        
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
