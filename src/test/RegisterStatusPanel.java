package test;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.event.MouseInputListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RegisterStatusPanel extends JPanel implements MouseInputListener {

    // Declaring variable
    JPanel container;
    JLabel lTitle1, lTitle2;
    JButton btnTraveller, btnPartner;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public RegisterStatusPanel() {

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(0, 0, width, height);
        this.setLayout(null);

        // Set JPanel (container)
        container = new RoundedPanel(30);
        container.setBounds(width/2 - 300, height/2 - 270, 600, 400);
        container.setLayout(null);
        container.setOpaque(false);
        container.setBackground(ConstColor.PURPLE2);

        // Set components
        // Set JLabel (title)
        lTitle1 = new JLabel("Register");
        lTitle1.setFont(new Font("Arial", Font.BOLD, 34));
        lTitle1.setForeground(ConstColor.WHITE);
        lTitle1.setBackground(ConstColor.PURPLE4);
        lTitle1.setBounds(container.getWidth()/2 - 150, 40, 300, 30);
        lTitle1.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Set JLabel (title2)
        lTitle2 = new JLabel("Start Your Journey Today");
        lTitle2.setFont(new Font("Arial", Font.ITALIC, 16));
        lTitle2.setForeground(ConstColor.WHITE);
        lTitle2.setBounds(container.getWidth()/2 - 150, lTitle1.getY() + 30, 300, 30);
        lTitle2.setHorizontalAlignment(SwingConstants.CENTER);

        // Set JButton
        btnTraveller = new JButton("Traveller");
        btnTraveller.setBorder(new RoundedBorder(20));
        btnTraveller.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnTraveller.setForeground(ConstColor.WHITE);
        btnTraveller.setBackground(ConstColor.PURPLE2);
        btnTraveller.setBounds(container.getWidth()/2 - 270, lTitle2.getY() + 70, 250, 200);
        btnTraveller.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnTraveller.addMouseListener(this);

        btnPartner = new JButton("Partner");
        btnPartner.setBorder(new RoundedBorder(20));
        btnPartner.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnPartner.setForeground(ConstColor.WHITE);
        btnPartner.setBackground(ConstColor.PURPLE2);
        btnPartner.setBounds(container.getWidth()/2 + 20, btnTraveller.getY(), 250, 200);
        btnPartner.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnPartner.addMouseListener(this);

        // Adding components
        container.add(lTitle1);
        container.add(lTitle2);
        container.add(btnTraveller);
        container.add(btnPartner);
        this.add(container);

        // Set vicibility
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();

        switch(name) {
            case "Traveller":
                MainFrame.cardLayout.show(MainFrame.cardPanel1, "registerUser");
                break;
            case "Partner":
                MainFrame.cardLayout.show(MainFrame.cardPanel1, "registerPartner");
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
        JButton button = (JButton) e.getSource();
        String name = button.getText();
        
        switch(name) {
            case "Traveller":
                button.setBackground(ConstColor.PURPLE4);
                break;
            case "Partner":
                button.setBackground(ConstColor.PURPLE4);
                break;
            default: 
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();
        
        switch(name) {
            case "Traveller":
                button.setBackground(ConstColor.PURPLE3);
                break;
            case "Partner":
                button.setBackground(ConstColor.PURPLE3);
                break;
            default: 
                break;
        }
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
