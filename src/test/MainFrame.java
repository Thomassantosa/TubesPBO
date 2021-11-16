package test;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class MainFrame extends JFrame implements MouseInputListener{
    
    // Declaring variable
    JPanel buttonContainer, cards;
    JButton button1, button2;
    Panel1 panel1;
    Panel2 panel2;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();
    
    public MainFrame() {

        // Set JFrame
        this.setName("Travelokay");
        this.setSize(width, height);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);  
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\source\\Logo_Splashscreen.png");  
        this.setIconImage(icon);

        // Set Fixed JPanel
        buttonContainer = new JPanel();
        buttonContainer.setBackground(new Color(23, 42, 62));
        buttonContainer.setSize(400, this.getHeight());
        // buttonContainer.setSize(width, height);
        buttonContainer.setLayout(null);

        cards = new JPanel();
        cards.setLayout(new CardLayout());
        panel1 = new Panel1();
        panel2 = new Panel2();
        cards.add(panel1);
        cards.add(panel2);

        // Set JButton
        button1 = new JButton("Panel1");
        button1.setBackground(new Color(173, 194, 169));
        button1.setForeground(new Color(63, 77, 63));
        button1.setBounds(0, 0, 220, 60);
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        
        button2 = new JButton("Panel2");
        button2.setBackground(new Color(173, 194, 169));
        button2.setForeground(new Color(63, 77, 63));
        button2.setBounds(0, button1.getHeight()+60, 220, 60);
        button2.setFont(new Font("Arial", Font.BOLD, 20));
        
        button1.addMouseListener(this);
        button2.addMouseListener(this);

        // Adding component
        buttonContainer.add(button1);
        buttonContainer.add(button2);
        this.add(buttonContainer);
        this.add(cards);

        // Set Vicibility
        this.setVisible(true);
        buttonContainer.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
