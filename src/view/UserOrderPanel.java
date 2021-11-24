package view;

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
import controller.SingletonManager;
import model.Order;
import model.TripTypesEnum;

public class UserOrderPanel extends JPanel {
    
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

    public UserOrderPanel() {

        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Your Order Menu");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);
        
        // Set JTable
        dataTable = new JTable();
        dataTable.setBounds(20, 80, width-270, height-200);
        String[] columnData = {"Order Date", "Order Type", "Person Name", "Phone Number", "Email", "Transaction Type"};
        model = new DefaultTableModel(columnData, 0);
        
        ArrayList<Order> orders = queryController.selectUserOrder(SingletonManager.getInstance().getUser().getUserID());
        for (int i = 0; i < orders.size(); i++) {
            String[] newModel = new String[6];

            Order currentOrder = orders.get(i);
            newModel[0] = currentOrder.getOrderDate();

            if (currentOrder.getOrderType() == TripTypesEnum.FLIGHT) {
                newModel[1] = "Flight";
            } else if (currentOrder.getOrderType() == TripTypesEnum.TRAIN) {
                newModel[1] = "Train";
            } else if (currentOrder.getOrderType() == TripTypesEnum.BUS) {
                newModel[1] = "Bus";
            } else if (currentOrder.getOrderType() == TripTypesEnum.HOTEL) {
                newModel[1] = "Hotel";
            }

            newModel[2] = currentOrder.getPersonName();
            newModel[3] = currentOrder.getPhoneNumber();
            newModel[4] = currentOrder.getEmail();
            newModel[5] = currentOrder.getTransactionType();

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
