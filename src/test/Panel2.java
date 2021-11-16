package test;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Panel2 extends JPanel{
    
    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public Panel2() {
        this.setBackground(Color.RED);
        this.setBounds(400, 0, width, height);
        this.setLayout(null);
    }
}
