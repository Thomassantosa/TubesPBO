package view;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import org.jdatepicker.impl.*;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import controller.QueryController;
import model.*;
import java.awt.Toolkit;
import java.awt.Image;
public class ShowFlight {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    JFrame fShowFlight;
    JPanel pShowFlght;
    JLabel lTitle;
    public ShowFlight(){
        fShowFlight = new JFrame("Flight");
        fShowFlight.setSize((int) width, (int) height);
        fShowFlight.setLayout(null);
        fShowFlight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fShowFlight.setExtendedState(JFrame.MAXIMIZED_BOTH);

        pShowFlght = new JPanel();
        pShowFlght.setBackground(new Color(40, 25, 54));
        pShowFlght.setSize((int) width, (int) height);
        pShowFlght.setLayout(null);

        lTitle = new JLabel("LIST FLIGHT");
        lTitle.setBounds((int) width / 2 - 250, (int) height / 60, 500, 50);
        lTitle.setForeground(Color.white);
        lTitle.setFont(new Font("Tahoma", Font.BOLD, 40));

        
        pShowFlght.add(lTitle);
        fShowFlight.add(pShowFlght);
        fShowFlight.setVisible(true);
    }
    public static void main(String[] args) {
        new ShowFlight();
    }
}
