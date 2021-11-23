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
public class ShowHotel {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    JFrame fShowHotel;
    JPanel pShowHotel;
    JLabel lTitle;
    JButton btnBack;
    public ShowHotel(){
        fShowHotel = new JFrame("Hotel");
        fShowHotel.setSize((int) width, (int) height);
        fShowHotel.setLayout(null);
        fShowHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fShowHotel.setExtendedState(JFrame.MAXIMIZED_BOTH);

        pShowHotel = new JPanel();
        pShowHotel.setBackground(new Color(40, 25, 54));
        pShowHotel.setSize((int) width, (int) height);
        pShowHotel.setLayout(null);

        lTitle = new JLabel("LIST HOTEL");
        lTitle.setBounds((int) width / 2 - 250, (int) height / 60, 500, 50);
        lTitle.setForeground(Color.white);
        lTitle.setFont(new Font("Tahoma", Font.BOLD, 40));

        btnBack = new JButton("Back");
        btnBack.setBounds((int) width - 1800, (int) height / 60, 100, 25);
        btnBack.setBackground(Color.orange);
        
        pShowHotel.add(btnBack);
        pShowHotel.add(lTitle);
        fShowHotel.add(pShowHotel);
        fShowHotel.setVisible(true);
    }
}
