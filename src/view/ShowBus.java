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
public class ShowBus {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    JFrame fShowBus;
    JPanel pShowBus;
    JLabel lTitle;
    JButton btnBack;
    public ShowBus(){
        fShowBus = new JFrame("Bus");
        fShowBus.setSize((int) width, (int) height);
        fShowBus.setLayout(null);
        fShowBus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fShowBus.setExtendedState(JFrame.MAXIMIZED_BOTH);

        pShowBus = new JPanel();
        pShowBus.setBackground(new Color(40, 25, 54));
        pShowBus.setSize((int) width, (int) height);
        pShowBus.setLayout(null);

        lTitle = new JLabel("LIST BUS");
        lTitle.setBounds((int) width / 2 - 250, (int) height / 60, 500, 50);
        lTitle.setForeground(Color.white);
        lTitle.setFont(new Font("Tahoma", Font.BOLD, 40));

        btnBack = new JButton("Back");
        btnBack.setBounds((int) width - 1800, (int) height / 60, 100, 25);
        btnBack.setBackground(Color.orange);

        pShowBus.add(btnBack);
        pShowBus.add(lTitle);
        fShowBus.add(pShowBus);
        fShowBus.setVisible(true);
    }
}
