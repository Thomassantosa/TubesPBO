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
public class ShowTrain {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    JFrame fShowTrain;
    JPanel pShowTrain;
    JLabel lTitle;
    JButton btnBack;
    public ShowTrain(){
        fShowTrain = new JFrame("Train");
        fShowTrain.setSize((int) width, (int) height);
        fShowTrain.setLayout(null);
        fShowTrain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fShowTrain.setExtendedState(JFrame.MAXIMIZED_BOTH);

        pShowTrain = new JPanel();
        pShowTrain.setBackground(new Color(40, 25, 54));
        pShowTrain.setSize((int) width, (int) height);
        pShowTrain.setLayout(null);

        lTitle = new JLabel("LIST TRAIN");
        lTitle.setBounds((int) width / 2 - 250, (int) height / 60, 500, 50);
        lTitle.setForeground(Color.white);
        lTitle.setFont(new Font("Tahoma", Font.BOLD, 40));

        btnBack = new JButton("Back");
        btnBack.setBounds((int) width - 1800, (int) height / 60, 100, 25);
        btnBack.setBackground(Color.orange);

        pShowTrain.add(btnBack);
        pShowTrain.add(lTitle);
        fShowTrain.add(pShowTrain);
        fShowTrain.setVisible(true);
    }
    public static void main(String[] args) {
        new ShowTrain();
    }
}
