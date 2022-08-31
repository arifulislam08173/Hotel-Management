package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;

    Reception() {

        b1 = new JButton("New Customer Form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(10, 70, 200, 30);
        b1.addActionListener(this);
        add(b1);
        
        b4 = new JButton("All Employee Info");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(10, 110, 200, 30);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Customer Info");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(10, 150, 200, 30);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Manager Info");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(10, 190, 200, 30);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("Check Out");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(10, 230, 200, 30);
        b7.addActionListener(this);
        add(b7);

        b8 = new JButton("Update Check Status");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setBounds(10, 270, 200, 30);
        b8.addActionListener(this);
        add(b8);

        b9 = new JButton("Update Room Status");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setBounds(10, 310, 200, 30);
        b9.addActionListener(this);
        add(b9);

        b10 = new JButton("Pick up Service");
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.setBounds(10, 350, 200, 30);
        b10.addActionListener(this);
        add(b10);

        b11 = new JButton("Search Room");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.setBounds(10, 390, 200, 30);
        b11.addActionListener(this);
        add(b11);

        b12 = new JButton("Back");
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.setBounds(10, 430, 200, 30);
        b12.addActionListener(this);
        add(b12);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/fourth.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(250, 30, 530, 430);
        add(l1);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(550, 200, 800, 530);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            new AddCustomer().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == b4) {

            new EmployeeInfo().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == b5) {

            new CustomerInfo().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == b6) {

            new ManagerInfo().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == b7) {

            new CheckOut().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == b8) {

            new UpdateStatus().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == b9) {

            new UpdateRoom().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == b10) {

            new PickUp().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == b11) {

            new SearchRoom().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == b12) {
            
            this.setVisible(false);
            
        }

    }

    public static void main(String[] args) {
        new Reception().setVisible(true);
    }

}
