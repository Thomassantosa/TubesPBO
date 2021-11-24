package test;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.QueryController;

public class PartnerFlightDeletePanel extends JPanel implements ActionListener {
    
    // Declaring variable
    JLabel lTitle, lTitle2, lDelete;
    QueryController queryController;
    JPanel container;
    JTextField tfDelete;
    JButton btnDelete;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public PartnerFlightDeletePanel() {

        queryController = new QueryController();

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Delete Flight Data");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);
        
        container = new RoundedPanel(20, ConstColor.PURPLE2);
        container.setBounds(20, 100, width-270, height-200);
        container.setLayout(null);
        container.setOpaque(false);

        lTitle2 = new JLabel("Delete Flight Data by Flight ID");
        lTitle2.setForeground(ConstColor.WHITE);
        lTitle2.setFont(new Font("Arial", Font.BOLD, 20));
        lTitle2.setBounds(20, 20, 450, 40);

        lDelete = new JLabel("Flight ID");
        lDelete.setForeground(ConstColor.WHITE);
        lDelete.setFont(new Font("Arial", Font.PLAIN, 16));
        lDelete.setBounds(lTitle2.getX(), lTitle2.getY() + lTitle2.getHeight() + 60, 200, 40);

        tfDelete = new JTextField();
        tfDelete.setBackground(ConstColor.PURPLE3);
        tfDelete.setForeground(ConstColor.WHITE);
        tfDelete.setBounds(lDelete.getX(), lDelete.getY() + lDelete.getHeight() + 20, 200, 40);
        tfDelete.setMargin(new Insets(0, 10, 0, 0));

        btnDelete = new JButton("Delete Data");
        btnDelete.setBounds(tfDelete.getX() + tfDelete.getWidth() + 40, tfDelete.getY(), 200, 40);
        btnDelete.setBackground(ConstColor.PURPLE4);
        btnDelete.setForeground(ConstColor.WHITE);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
        btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDelete.addActionListener(this);

        // Adding components
        this.add(lTitle);

        container.add(lTitle2);
        container.add(lDelete);
        container.add(tfDelete);
        container.add(btnDelete);
        this.add(container);

        // Set vicibility
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String flightID = tfDelete.getText();

        if (flightID.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all field !");
        } else {
            
            boolean success = queryController.deleteFlight(flightID);

            if (success) {
                JOptionPane.showMessageDialog(null, "Delete Flight Data Success");
            } else {
                JOptionPane.showMessageDialog(null, "Delete Flight Data Failed");
            }
        }
    }
}
