package view;

import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class MainMenu implements MouseInputListener {
    JFrame fMainMenu;
    JPanel panelMenu, panelMainMenu, panelProfile, panelPesawat, panelBus, panelHotel, panelWisata;
    JButton btnNama, btnPesawat, btnKeretaApi, btnBus, btnHotel, btnWisata, btnLogOut;

    public MainMenu() {

        fMainMenu = new JFrame("MAIN MENU");
        fMainMenu.setSize(1500, 700);
        fMainMenu.setLayout(null);
        fMainMenu.setVisible(true);
        fMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelMenu = new JPanel();
        panelMenu.setBackground(Color.WHITE);
        panelMenu.setBounds(0, 0, 250, 700);
        panelMenu.setLayout(null);
        panelMenu.setVisible(true);

        panelProfile = new JPanel();
        panelProfile.setBackground(Color.DARK_GRAY);
        panelProfile.setBounds(250, 0, 1500, 700);
        panelProfile.setLayout(null);
        panelProfile.setVisible(true);

        panelPesawat = new JPanel();
        panelPesawat.setBackground(Color.black);
        panelPesawat.setBounds(250, 0, 1500, 700);
        panelPesawat.setLayout(null);
        panelPesawat.setVisible(true);

        panelBus = new JPanel();
        panelBus.setBackground(Color.red);
        panelBus.setBounds(250, 0, 1500, 700);
        panelBus.setLayout(null);
        panelBus.setVisible(true);

        panelHotel = new JPanel();
        panelHotel.setBackground(Color.ORANGE);
        panelHotel.setBounds(250, 0, 1500, 700);
        panelHotel.setLayout(null);
        panelHotel.setVisible(true);

        panelWisata = new JPanel();
        panelWisata.setBackground(Color.pink);
        panelWisata.setBounds(250, 0, 1500, 700);
        panelWisata.setLayout(null);
        panelWisata.setVisible(true);

        panelMainMenu = new JPanel();
        panelMainMenu.setBackground(new Color(129, 173, 181));
        panelMainMenu.setBounds(250, 0, 1500, 700);
        panelMainMenu.setLayout(null);
        panelMainMenu.setVisible(true);

        btnNama = new JButton("Profile");
        btnNama.setBounds(10, 10, 230, 230);
        btnNama.setBackground(Color.white);
        btnNama.addMouseListener(this);

        btnPesawat = new JButton("Pesawat");
        btnPesawat.setBounds(10, 245, 230, 50);
        btnPesawat.setBackground(Color.white);
        btnPesawat.addMouseListener(this);

        btnKeretaApi = new JButton("Kereta Api");
        btnKeretaApi.setBounds(10, 300, 230, 50);
        btnKeretaApi.setBackground(Color.white);
        btnKeretaApi.addMouseListener(this);

        btnBus = new JButton("Bus");
        btnBus.setBounds(10, 355, 230, 50);
        btnBus.setBackground(Color.white);
        btnBus.addMouseListener(this);

        btnHotel = new JButton("Hotel");
        btnHotel.setBounds(10, 410, 230, 50);
        btnHotel.setBackground(Color.white);
        btnHotel.addMouseListener(this);

        btnWisata = new JButton("Wisata");
        btnWisata.setBounds(10, 465, 230, 50);
        btnWisata.setBackground(Color.white);
        btnWisata.addMouseListener(this);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(10, 600, 230, 50);
        btnLogOut.setForeground(Color.white);
        btnLogOut.setBackground(Color.red);

        
        panelMenu.add(btnLogOut);
        panelMenu.add(btnWisata);
        panelMenu.add(btnHotel);
        panelMenu.add(btnBus);
        panelMenu.add(btnKeretaApi);
        panelMenu.add(btnPesawat);
        panelMenu.add(btnNama);
        fMainMenu.add(panelMainMenu);
        fMainMenu.add(panelMenu);
    }

    public static void main(String[] args) {
        new MainMenu();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getText();
        switch (name) {
        case "Profile":
            System.out.println("TEST BUTTON 1");
            break;
        case "Pesawat":
            System.out.println("TEST BUTTON 13");
            break;
        case "Kereta Api":
            System.out.println("TEST BUTTON 1123");
            break;
        case "Bus":
            System.out.println("TEST BUTTON 1231");
            break;
        case "Hotel":
            System.out.println("TEST BUTTON 1123");
            break;
        case "Wisata":
            System.out.println("TEST BUTTON 153");
            break;
        default:
            System.out.println("TEST BUTTON ELSE");
            break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(Color.CYAN);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(Color.white);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
