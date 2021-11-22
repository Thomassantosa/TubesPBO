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

public class MenuTrainPartner implements MouseInputListener {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    JFrame fMainMenuTrain;
    JPanel panelMenu, panelShowData, panelDelete, panelAdd;
    JButton btnShow, btnAdd, btnDelete, btnSave, btnLogout , deleteBtn;
    JTable dataTable;
    JLabel lTitle, lAddTrain, lDelete, lTrainName, lderpatureStation, ldestinationStation, lTrainType,
            lTrainNumber, lderpatureTime, larrivalTime, lderpatureDate, larivalDate, ltravelTime , lDeletebyID;

    JScrollPane scrollpane;
    DefaultTableModel model;
    JTextField TrainNumber, derpatureTime, arrivalTime, travelTime , delete;
    JComboBox cbTrainName, cbderpatureStation, cbdestinationStation;
    JDatePanelImpl derpatureDate, arivalDate;
    
    MenuTrainPartner() {

        // frame
        fMainMenuTrain = new JFrame("Travelokay");
        fMainMenuTrain.setSize((int) width, (int) height);
        fMainMenuTrain.setLayout(null);
        fMainMenuTrain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fMainMenuTrain.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // panel Home
        panelShowData = new JPanel();
        panelShowData.setBackground(new Color(40, 25, 54));
        panelShowData.setBounds((int) width / 10, 0, (int) width, (int) height);
        panelShowData.setLayout(null);

        // panel add data
        panelAdd = new JPanel();
        panelAdd = new JPanel();
        panelAdd.setBackground(new Color(40, 25, 54));
        panelAdd.setBounds((int) width / 10, 0, (int) width, (int) height);
        panelAdd.setLayout(null);

        // panel delete data
        panelDelete = new JPanel();
        panelDelete = new JPanel();
        panelDelete.setBackground(new Color(40, 25, 54));
        panelDelete.setBounds((int) width / 10, 0, (int) width, (int) height);
        panelDelete.setLayout(null);

        lTitle = new JLabel("Train Data ");
        lTitle.setForeground(Color.white);
        lTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
        lTitle.setBounds((int) width / 2 - 200, (int) height / 60, 500, 50);

        panelMenu = new JPanel();
        panelMenu.setBackground(new Color(100, 88, 110));
        panelMenu.setBounds(0, 0, (int) width / 10, (int) height);
        panelMenu.setLayout(null);

        // set jtable
        dataTable = new JTable();
        dataTable.setBounds(panelMenu.getWidth() + 100, lTitle.getY() + lTitle.getHeight() + 50, 1200, 350);

        // Set JScrollPane
        scrollpane = new JScrollPane(dataTable);
        scrollpane.setBounds(panelMenu.getWidth() + 100, lTitle.getY() + lTitle.getHeight() + 50, 1200, 350);

        // Set value
        String[] columnData = { "Train Name", "Derparture Station ", "Destination Station", "Train type",
                "Train Number", "Departure Time", "Arrival Time", "Derpature Date", "Arrival Date", "Travel Time" };

        model = new DefaultTableModel(columnData, 0);

        dataTable.setModel(model);

        // button add Data
        // nama Kereta , statisun brangkat tujuan , Train type (hardcode),
        // Trainnumber (text), departure time arrival time (String), departure date
        // arrival date (String),travel time

        btnShow = new JButton("Show Train Data");
        btnShow.setBounds(panelMenu.getX(), panelMenu.getY(), panelMenu.getWidth(), panelMenu.getHeight() / 4);
        btnShow.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnShow.setBackground(new Color(100, 88, 110));
        btnShow.setForeground(Color.white);
        btnShow.addMouseListener(this);
        btnShow.setHorizontalAlignment(SwingConstants.LEFT);

        btnAdd = new JButton("Add Train Data");
        btnAdd.setBounds(btnShow.getX(), btnShow.getY() + btnShow.getHeight(), btnShow.getWidth(),
                panelMenu.getHeight() / 4);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAdd.setBackground(new Color(100, 88, 110));
        btnAdd.setForeground(Color.white);
        btnAdd.addMouseListener(this);
        btnAdd.setHorizontalAlignment(SwingConstants.LEFT);

        // delete button
        btnDelete = new JButton("Delete Train Data");
        btnDelete.setBounds(btnAdd.getX(), btnAdd.getHeight() + btnAdd.getY(), btnAdd.getWidth(),
                panelMenu.getHeight() / 4);
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnDelete.setBackground(new Color(100, 88, 110));
        btnDelete.setForeground(Color.white);
        btnDelete.addMouseListener(this);
        btnDelete.setHorizontalAlignment(SwingConstants.LEFT);

        // logout button
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(btnAdd.getX(), panelMenu.getHeight() - 150, btnAdd.getWidth(), 50);
        btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnLogout.setBackground(new Color(100, 88, 110));
        btnLogout.setForeground(new Color(255, 55, 58));
        btnLogout.addMouseListener(this);
        btnLogout.setHorizontalAlignment(SwingConstants.LEFT);

        // add component
        panelMenu.add(btnShow);
        panelMenu.add(btnAdd);
        panelMenu.add(btnDelete);
        panelMenu.add(btnLogout);

        panelShowData.add(lTitle);
        panelShowData.add(scrollpane);

        fMainMenuTrain.add(panelMenu);
        fMainMenuTrain.add(panelShowData);
        fMainMenuTrain.add(panelAdd);
        fMainMenuTrain.add(panelDelete);

        scrollpane.setVisible(true);
        panelMenu.setVisible(true);
        panelShowData.setVisible(true);
        panelAdd.setVisible(false);
        panelDelete.setVisible(false);

        fMainMenuTrain.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(new Color(100, 88, 110));
        JButton button = (JButton) e.getSource();
        String name = button.getText();

        switch (name) {

        case "Show Train Data":

            scrollpane.setVisible(true);
            panelMenu.setVisible(true);
            panelShowData.setVisible(true);
            panelAdd.setVisible(false);
            panelDelete.setVisible(false);

            break;

        case "Add Train Data":

            // label for adding a Train
            lAddTrain = new JLabel("Add Train");
            lAddTrain.setForeground(Color.white);
            lAddTrain.setFont(new Font("Tahoma", Font.BOLD, 40));
            lAddTrain.setBounds((int) width / 2 - 200, (int) height / 60, 500, 50);

            lTrainName = new JLabel("Train Name");
            lTrainName.setBounds(panelMenu.getX() + panelMenu.getWidth() - 50, lAddTrain.getY() + lAddTrain.getHeight() + 50, 250, 33);
            lTrainName.setForeground(Color.white);
            lTrainName.setFont(new Font("Tahoma", Font.PLAIN, 30));
          
            // cb Train
            cbTrainName = new JComboBox<>();
            cbTrainName.setBackground(new Color(100, 88, 110));
            cbTrainName.setForeground(Color.white);
            cbTrainName.setBounds(lTrainName.getX(), lTrainName.getY() + lTrainName.getHeight() + 30, 200, 33);

            lderpatureStation = new JLabel("Derpature Station");
            lderpatureStation.setForeground(Color.white);
            lderpatureStation.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lderpatureStation.setBounds(cbTrainName.getX(),cbTrainName.getY()+cbTrainName.getHeight()+80,250,33);

            cbderpatureStation = new JComboBox<>();
            cbderpatureStation.setForeground(Color.white);
            cbderpatureStation.setBackground(new Color(100,88,110));
            cbderpatureStation.setBounds(lderpatureStation.getX(), lderpatureStation.getY() + lderpatureStation.getHeight() + 30, 200, 33);

            ldestinationStation = new JLabel("Destination Station");
            ldestinationStation.setForeground(Color.white);
            ldestinationStation.setFont(new Font("Tahoma", Font.PLAIN, 30));
            ldestinationStation.setBounds(cbderpatureStation.getX(),cbderpatureStation.getY()+cbderpatureStation.getHeight()+80,250,33);

            cbdestinationStation = new JComboBox<>();
            cbdestinationStation.setForeground(Color.white);
            cbdestinationStation.setBackground(new Color(100,88,110));
            cbdestinationStation.setBounds(ldestinationStation.getX(), ldestinationStation.getY() + ldestinationStation.getHeight() + 30, 200, 33);

            //Train number 
            lTrainNumber=new JLabel("Train Number");
            lTrainNumber.setBounds(lAddTrain.getX(), lTrainName.getY(), 250, 33);
            lTrainNumber.setForeground(Color.white);
            lTrainNumber.setFont(new Font("Tahoma", Font.PLAIN, 30));
          
            TrainNumber = new JTextField();
            TrainNumber.setForeground(Color.white);
            TrainNumber.setBackground(new Color(100,88,110));
            TrainNumber.setBounds(lTrainNumber.getX(),lTrainNumber.getY()+lTrainNumber.getHeight()+30,200,33);

            //derpature time 
            lderpatureTime = new JLabel("Derparture Time");
            lderpatureTime.setForeground(Color.white);
            lderpatureTime.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lderpatureTime.setBounds(lTrainNumber.getX()+lTrainNumber.getWidth()+20, lTrainNumber.getY(), 250, 33);

            derpatureTime = new JTextField();
            derpatureTime.setForeground(Color.white);
            derpatureTime.setBackground(new Color(100,88,110));
            derpatureTime.setBounds(lderpatureTime.getX(),lderpatureTime.getY()+lderpatureTime.getHeight()+30,250,33);

            //arival time
            larrivalTime = new JLabel("Arrival Time");
            larrivalTime.setForeground(Color.white);
            larrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 30));
            larrivalTime.setBounds(lTrainNumber.getX(), TrainNumber.getY()+TrainNumber.getHeight()+30, 250, 33);

            arrivalTime = new JTextField();
            arrivalTime.setForeground(Color.white);
            arrivalTime.setBackground(new Color(100,88,110));
            arrivalTime.setBounds(larrivalTime.getX(),larrivalTime.getY()+larrivalTime.getHeight()+30,200,33);
            
            //travel time
            ltravelTime = new JLabel("Travel Time");
            ltravelTime.setForeground(Color.white);
            ltravelTime.setFont(new Font("Tahoma", Font.PLAIN, 30));
            ltravelTime.setBounds(larrivalTime.getX()+larrivalTime.getWidth()+20, TrainNumber.getY()+TrainNumber.getHeight()+30, 250, 33);
           
            travelTime = new JTextField();
            travelTime.setForeground(Color.white);
            travelTime.setBackground(new Color(100,88,110));
            travelTime.setBounds(ltravelTime.getX(),ltravelTime.getY()+ltravelTime.getHeight()+30,250,33);

            //derpature date
            lderpatureDate=new JLabel("Derparture Date");
            lderpatureDate.setForeground(Color.white);
            lderpatureDate.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lderpatureDate.setBounds(arrivalTime.getX(), arrivalTime.getY()+arrivalTime.getHeight()+30, 250, 33);
          
            //datepicker
            Properties p = new Properties();
            SqlDateModel model = new SqlDateModel();
            p.put("text.day", "Day");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
            derpatureDate = new JDatePanelImpl(model, p);
            derpatureDate.setBounds(lderpatureDate.getX(), lderpatureDate.getY()+lderpatureDate.getHeight()+50 , 200, 200);

            //Arrival Date 

            //label Arival Date
            larivalDate = new JLabel("Arrival Date");
            larivalDate.setForeground(Color.white);
            larivalDate.setFont(new Font("Tahoma", Font.PLAIN, 30));
            larivalDate.setBounds(lderpatureDate.getX()+lderpatureDate.getWidth()+20, lderpatureDate.getY(), 250, 33);
          
            Properties prop = new Properties();
            SqlDateModel model2 = new SqlDateModel();
            prop.put("text.day", "Day");
            prop.put("text.month", "Month");
            prop.put("text.year", "Year");
            arivalDate = new JDatePanelImpl(model2, p);
            arivalDate.setBounds(larivalDate.getX(), larivalDate.getY()+larivalDate.getHeight()+50 , 200, 200);

            //btn Save
            btnSave = new JButton("Save");
            btnSave.setForeground(Color.white);
            btnSave.setBackground(new Color(100, 88, 110));
            btnSave.setBounds(lTrainName.getX(),panelShowData.getHeight()-200,200,50);
            btnSave.setFont(new Font ("Tahoma",Font.BOLD,30));
            btnSave.addMouseListener(this);

            panelAdd.add(lAddTrain);   
            panelAdd.add(lTrainName);
            panelAdd.add(lderpatureStation);
            panelAdd.add(ldestinationStation);
            panelAdd.add(lTrainNumber);
            panelAdd.add(lderpatureTime);
            panelAdd.add(larrivalTime);
            panelAdd.add(ltravelTime);
            panelAdd.add(lderpatureDate);   
            panelAdd.add(larivalDate);

            panelAdd.add(arivalDate);
            panelAdd.add(derpatureDate);
            panelAdd.add(travelTime);
            panelAdd.add(arrivalTime);
            panelAdd.add(TrainNumber);
            panelAdd.add(cbTrainName);
            panelAdd.add(cbderpatureStation);
            panelAdd.add(cbdestinationStation);
            panelAdd.add(derpatureTime);
            panelAdd.add(btnSave);

            scrollpane.setVisible(false);
            panelMenu.setVisible(true);
            panelShowData.setVisible(false);
            panelAdd.setVisible(true);
            panelDelete.setVisible(false);


            break;

        case "Delete Train Data":

            //label title delete 
            lDelete = new JLabel("Delete Train");
            lDelete.setForeground(Color.white);
            lDelete.setFont(new Font("Tahoma", Font.BOLD, 40));
            lDelete.setBounds((int) width / 2 - 200, (int) height / 60, 500, 50);
            
            //label 
            lDeletebyID = new JLabel("Delete Train by ID");
            lDeletebyID.setBounds(panelMenu.getX() + panelMenu.getWidth() - 50, lDelete.getY() + lDelete.getHeight() + 150, 300, 33);
            lDeletebyID.setForeground(Color.white);
            lDeletebyID.setFont(new Font("Tahoma", Font.BOLD, 30));

            //jtextfield
            delete = new JTextField();
            delete.setForeground(Color.white);
            delete.setBackground(new Color(100,88,110));
            delete.setBounds (lDeletebyID.getX(), lDeletebyID.getY()+lDeletebyID.getHeight()+20 , 300 , 33);

            deleteBtn = new JButton("Delete");
            deleteBtn.setForeground(Color.white);
            deleteBtn.setBackground(new Color(100, 88, 110));
            deleteBtn.setBounds(lDeletebyID.getX(),panelDelete.getHeight()-200,200,50);
            deleteBtn.setFont(new Font ("Tahoma",Font.BOLD,30));
            deleteBtn.addMouseListener(this);

            panelDelete.add(lDelete);   
            panelDelete.add(lDeletebyID);
            panelDelete.add(delete);
            panelDelete.add(deleteBtn);
            
            scrollpane.setVisible(false);
            panelMenu.setVisible(true);
            panelShowData.setVisible(false);
            panelAdd.setVisible(false);
            panelDelete.setVisible(true);

        default:
            break;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(new Color(136, 94, 254));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // not implemented

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(new Color(136, 94, 254));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component component = e.getComponent();
        component.setBackground(new Color(100, 88, 110));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // not implemented
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // not implemented
    }

    public static void main(String[] args) {
        new MenuTrainPartner();
    }
}
