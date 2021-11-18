package test;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Panel0 extends JPanel implements MouseInputListener{
    
    // Declaring variable
    JLabel lTitle, lTitle2, lDate, lIncome, lIncomeValue, lTransaction, lTransactionValue;
    JLabel lNewUser, lNewUserValue, lTotalUser, lTotalUserValue;
    JLabel lNewPartner, lNewPartnerValue, lTotalPartner, lTotalPartnerValue;
    JPanel container;

    // Get screen size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)size.getWidth();
    int height = (int)size.getHeight();

    public Panel0() {

        // Set JPanel (this)
        this.setBackground(ConstColor.PURPLE1);
        this.setBounds(220, 0, width-220, height);
        this.setLayout(null);
        this.setVisible(true);

        // Set components
        // Set JLabel (title)
        lTitle = new JLabel("Admin Menu");
        lTitle.setForeground(ConstColor.WHITE);
        lTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lTitle.setBounds(20, 20, 450, 40);

        // Set JPanel
        container = new RoundedPanel(20, ConstColor.PURPLE3);
        container.setBounds(20, 80, width-270, height-200);
        container.setLayout(null);
        container.setOpaque(false);

        // Set JLabel (components)
        lTitle2 = new JLabel("Today's Information");
        lTitle2.setForeground(ConstColor.WHITE);
        lTitle2.setFont(new Font("Arial", Font.BOLD, 20));
        lTitle2.setBounds(20, 20, 200, 20);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);
        lDate = new JLabel(currentTime);
        lDate.setForeground(ConstColor.WHITE);
        lDate.setFont(new Font("Arial", Font.PLAIN, 16));
        lDate.setBounds(20, lTitle2.getY()+20, 200, 20);
        
        lIncome = new JLabel("Total Income");
        lIncome.setForeground(ConstColor.GREEN4);
        lIncome.setFont(new Font("Arial", Font.BOLD, 20));
        lIncome.setBounds(20, lDate.getY()+60, 200, 20);
        
        lIncomeValue = new JLabel("dummy");
        lIncomeValue.setForeground(ConstColor.WHITE);
        lIncomeValue.setFont(new Font("Arial", Font.PLAIN, 16));
        lIncomeValue.setBounds(20, lIncome.getY()+20, 200, 20);

        lTransaction = new JLabel("Total Transaction");
        lTransaction.setForeground(ConstColor.BLUE4);
        lTransaction.setFont(new Font("Arial", Font.BOLD, 20));
        lTransaction.setBounds(300, lIncome.getY(), 200, 20);

        lTransactionValue = new JLabel("dummy");
        lTransactionValue.setForeground(ConstColor.WHITE);
        lTransactionValue.setFont(new Font("Arial", Font.PLAIN, 16));
        lTransactionValue.setBounds(300, lIncomeValue.getY(), 200, 20);

        lNewUser = new JLabel("New User");
        lNewUser.setForeground(ConstColor.WHITE);
        lNewUser.setFont(new Font("Arial", Font.BOLD, 20));
        lNewUser.setBounds(20, lIncomeValue.getY()+60, 200, 20);

        lNewUserValue = new JLabel("dummy");
        lNewUserValue.setForeground(ConstColor.WHITE);
        lNewUserValue.setFont(new Font("Arial", Font.PLAIN, 16));
        lNewUserValue.setBounds(20, lNewUser.getY()+20, 200, 20);
        
        lNewPartner = new JLabel("New Partner");
        lNewPartner.setForeground(ConstColor.WHITE);
        lNewPartner.setFont(new Font("Arial", Font.BOLD, 20));
        lNewPartner.setBounds(300, lNewUser.getY(), 200, 20);

        lNewPartnerValue = new JLabel("dummy");
        lNewPartnerValue.setForeground(ConstColor.WHITE);
        lNewPartnerValue.setFont(new Font("Arial", Font.PLAIN, 16));
        lNewPartnerValue.setBounds(300, lNewUserValue.getY(), 200, 20);

        lTotalUser = new JLabel("Total User");
        lTotalUser.setForeground(ConstColor.WHITE);
        lTotalUser.setFont(new Font("Arial", Font.BOLD, 20));
        lTotalUser.setBounds(20, lNewUserValue.getY()+60, 200, 20);

        lTotalUserValue = new JLabel("dummy");
        lTotalUserValue.setForeground(ConstColor.WHITE);
        lTotalUserValue.setFont(new Font("Arial", Font.PLAIN, 16));
        lTotalUserValue.setBounds(20, lTotalUser.getY()+20, 200, 20);

        lTotalPartner = new JLabel("Total Partner");
        lTotalPartner.setForeground(ConstColor.WHITE);
        lTotalPartner.setFont(new Font("Arial", Font.BOLD, 20));
        lTotalPartner.setBounds(300, lTotalUser.getY(), 200, 20);

        lTotalPartnerValue = new JLabel("dummy");
        lTotalPartnerValue.setForeground(ConstColor.WHITE);
        lTotalPartnerValue.setFont(new Font("Arial", Font.PLAIN, 16));
        lTotalPartnerValue.setBounds(300, lTotalUserValue.getY(), 200, 20);

        // Adding components
        this.add(lTitle);
        container.add(lTitle2);
        container.add(lDate);
        container.add(lIncome);
        container.add(lIncomeValue);
        container.add(lTransaction);
        container.add(lTransactionValue);
        container.add(lNewUser);
        container.add(lNewUserValue);
        container.add(lNewPartner);
        container.add(lNewPartnerValue);
        container.add(lTotalUser);
        container.add(lTotalUserValue);
        container.add(lTotalPartner);
        container.add(lTotalPartnerValue);
        this.add(container);

        // Set vicibility
        this.setVisible(true);
        container.setVisible(true);
    }

    class RoundedPanel extends JPanel {
        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
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
