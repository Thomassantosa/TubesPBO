package test;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.QueryController;
import model.User;

public class AdminUserPanel extends JPanel {
    
    // Declaring variable
    JLabel lTitle;
    QueryController queryController;
    JTable dataTable;
    DefaultTableModel model;
    JScrollPane scrollpane;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public AdminUserPanel() {

        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Admin Menu (User/Traveller Data)");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 550, 40);

        // Set JTable
        dataTable = new JTable();
        dataTable.setBounds(20, 80, width-270, height-200);
        String[] columnData = {"User_id", "Fullname", "Username", "Email", "Address", "Date Created"};
        model = new DefaultTableModel(columnData, 0);
        
        ArrayList<User> users = queryController.selectAllTraveller();
        for (int i = 0; i < users.size(); i++) {
            String[] newModel = new String[6];

            User currentUser = users.get(i);
            newModel[0] = String.valueOf(currentUser.getUserID());
            newModel[1] = currentUser.getFullname();
            newModel[2] = currentUser.getUsername();
            newModel[3] = currentUser.getEmail();
            newModel[4] = currentUser.getAddress();
            newModel[5] = currentUser.getDateCreated();
            model.addRow(newModel);
        }
        dataTable.setModel(model);

        // Set JScrollPane
        scrollpane = new JScrollPane(dataTable); 
        scrollpane.setBounds(20, 80, width-270, height-200);
        
        // Adding components
        this.add(lTitle);
        this.add(scrollpane);

        // Set vicibility
        this.setVisible(true);
    }
}
