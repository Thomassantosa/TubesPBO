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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Image;

public class RegisterForm implements MouseInputListener {
    JFrame frameRegister;
    JPanel bigPanel , panelLogo;
    JLabel logo;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    
    public RegisterForm() {
        Controller controller = new Controller();

        //image 
        ImageIcon icon = new ImageIcon("src\\source\\Logo_Splashscreen.png");
        Image scaleImage = icon.getImage().getScaledInstance(220, 250, Image.SCALE_REPLICATE);
        
        // frame
        frameRegister = new JFrame("Register");
        frameRegister.setSize((int) width , (int) height);
        frameRegister.setLayout(null);
        frameRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegister.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // panel
        bigPanel = new JPanel();
        bigPanel.setSize((int) width, (int) height);
        bigPanel.setLayout(null);
        bigPanel.setBackground(new Color(40, 25, 54));

        panelLogo = new JPanel();
        panelLogo.setSize(500,(int)height);
        panelLogo.setLayout(null);
        panelLogo.setBackground(new Color(60, 46, 72));
        
        // lable
        logo = new JLabel(new ImageIcon(scaleImage));
        logo.setBounds(0,(int)height/6, 500 , 500);
        // add to panel

        panelLogo.add(logo);
        bigPanel.add(panelLogo);
       
        // add to Frame
        frameRegister.add(bigPanel);

        //set visible
        panelLogo.setVisible(true);
        bigPanel.setVisible(true);
        frameRegister.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();

      
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
