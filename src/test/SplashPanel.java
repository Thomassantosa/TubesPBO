package test;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SplashPanel extends JPanel{
    
    // Declaring variable
    JLabel lSplashLogo;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();
    
    public SplashPanel() {

        // Set JPanel
        this.setBackground(new Color(40,25,54));
        this.setSize(width, height);
        this.setLayout(null);

        // Set components
        ImageIcon logo = new ImageIcon("src\\source\\Logo_Splashscreen.png");
        Image scaleImage = logo.getImage().getScaledInstance(220, 250,Image.SCALE_SMOOTH);
        lSplashLogo = new JLabel(new ImageIcon(scaleImage));
        lSplashLogo.setBounds(width/2-110, height/2-170, 220, 250);

        // Adding components
        this.add(lSplashLogo);
    }
}
