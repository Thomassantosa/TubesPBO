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

public class FormDataDiri {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    JFrame fFormDataDiri;
    JPanel pFormDataDiri;
    JLabel lTitle, lNama, lEmail, lNomorHP;
    JButton btnSubmit;
    int tot = 20;
    JTextField[] tfNama = new JTextField[7];
    JTextField[] tfNomorHP = new JTextField[7];
    JTextField[] tfEmail = new JTextField[7];
    public FormDataDiri() {
        fFormDataDiri = new JFrame("Form Data Diri");
        fFormDataDiri.setSize((int) width, (int) height);
        fFormDataDiri.setLayout(null);
        fFormDataDiri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fFormDataDiri.setExtendedState(JFrame.MAXIMIZED_BOTH);

        pFormDataDiri = new JPanel();
        pFormDataDiri.setBackground(new Color(40, 25, 54));
        pFormDataDiri.setSize((int) width, (int) height);
        pFormDataDiri.setLayout(null);

        lTitle = new JLabel("FORM DATA DIRI");
        lTitle.setBounds((int) width / 2 - 250, (int) height / 60, 500, 50);
        lTitle.setForeground(Color.white);
        lTitle.setFont(new Font("Tahoma", Font.BOLD, 40));

        for (int i = 0; i < 5; i++) {
            lNama = new JLabel("Nama : ");
            lNama.setFont(new Font("Tahoma", Font.BOLD, 20));
            lNama.setForeground(Color.white);
            lNama.setBounds((int) width - 1800, (int) height / 10 + tot, 500, 20);

            tfNama[i] = new JTextField();
            tfNama[i].setBounds((int) width - 1720, (int) height / 10 + tot, 300, 30);

            lEmail = new JLabel("Email : ");
            lEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
            lEmail.setForeground(Color.white);
            lEmail.setBounds((int) width - 1400, (int) height / 10 + tot, 500, 20);

            tfEmail[i] = new JTextField();
            tfEmail[i].setBounds((int) width - 1320, (int) height / 10 + tot, 300, 30);

            lNomorHP = new JLabel("No HP : ");
            lNomorHP.setFont(new Font("Tahoma", Font.BOLD, 20));
            lNomorHP.setForeground(Color.white);
            lNomorHP.setBounds((int) width - 1000, (int) height / 10 + tot, 500, 20);

            tfNomorHP[i] = new JTextField();
            tfNomorHP[i].setBounds((int) width - 920, (int) height / 10 + tot, 300, 30);
            tot += 100;


            pFormDataDiri.add(tfNomorHP[i]);
            pFormDataDiri.add(lNomorHP);
            pFormDataDiri.add(tfEmail[i]);
            pFormDataDiri.add(lEmail);
            pFormDataDiri.add(tfNama[i]);
            pFormDataDiri.add(lNama);
        }

        pFormDataDiri.add(lTitle);
        fFormDataDiri.add(pFormDataDiri);
        fFormDataDiri.setVisible(true);
    }

    public static void main(String[] args) {
        new FormDataDiri();
    }
}
