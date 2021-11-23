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
import javax.swing.event.MouseInputListener;

public class FormPembayaran implements MouseInputListener {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    JFrame fFormPembayaran;
    JPanel pFormPembayaran;
    JLabel lTitle, lHarga, lPilihMetodeBayar;
    JComboBox cbMetodePembayaran;
    JButton btnCalculate;
    String metodePembayaran[] = { "CBA", "PayGO", "INB" };

    public FormPembayaran() {
        fFormPembayaran = new JFrame("Form Data Diri");
        fFormPembayaran.setSize((int) width, (int) height);
        fFormPembayaran.setLayout(null);
        fFormPembayaran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fFormPembayaran.setExtendedState(JFrame.MAXIMIZED_BOTH);

        pFormPembayaran = new JPanel();
        pFormPembayaran.setBackground(new Color(40, 25, 54));
        pFormPembayaran.setSize((int) width, (int) height);
        pFormPembayaran.setLayout(null);

        lTitle = new JLabel("FORM PEMBAYARAN");
        lTitle.setBounds((int) width / 2 - 250, (int) height / 60, 500, 50);
        lTitle.setForeground(Color.white);
        lTitle.setFont(new Font("Tahoma", Font.BOLD, 40));

        int harga = 100000;
        lHarga = new JLabel();
        lHarga.setForeground(Color.white);
        lHarga.setFont(new Font("Tahoma", Font.BOLD, 20));
        lHarga.setBounds((int) width - 1800, (int) height / 7, 500, 30);
        lHarga.setText("Harga : " + harga);

        lPilihMetodeBayar = new JLabel("Pilih Metode Pembayaran : ");
        lPilihMetodeBayar.setForeground(Color.white);
        lPilihMetodeBayar.setFont(new Font("Tahoma", Font.BOLD, 20));
        lPilihMetodeBayar.setBounds((int) width - 1800, (int) height / 5, 500, 30);

        cbMetodePembayaran = new JComboBox<>(metodePembayaran);
        cbMetodePembayaran.setBounds((int) width - 1520, (int) height / 5 + 5, 200, 30);

        btnCalculate = new JButton("Search Flight");
        btnCalculate.setBounds((int) width - 1800, (int) height / 4, 230, 50);
        btnCalculate.setBackground(Color.orange);
        btnCalculate.addMouseListener(this);

        pFormPembayaran.add(btnCalculate);
        pFormPembayaran.add(cbMetodePembayaran);
        pFormPembayaran.add(lPilihMetodeBayar);
        pFormPembayaran.add(lHarga);
        pFormPembayaran.add(cbMetodePembayaran);
        pFormPembayaran.add(lTitle);
        fFormPembayaran.add(pFormPembayaran);
        fFormPembayaran.setVisible(true);
    }

    public static void main(String[] args) {
        new FormPembayaran();
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
