package test;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Panel1 extends JPanel{
    
    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public Panel1() {
        this.setBackground(Color.BLUE);
        this.setBounds(400, 0, width, height);
        this.setLayout(null);
    }
}
