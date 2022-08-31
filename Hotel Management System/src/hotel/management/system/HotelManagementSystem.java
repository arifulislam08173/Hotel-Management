package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    public HotelManagementSystem() {
        
        setBounds(300, 200, 1366, 565);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/hotel.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1366, 565);
        add(l1);

        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(20, 430, 1000, 90);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.PLAIN, 70));
        l1.add(l2);

        JButton b1 = new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(1150, 450, 150, 50);
        b1.addActionListener(this);
        l1.add(b1);

        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new HotelManagementSystem().setVisible(true);
    }

}
