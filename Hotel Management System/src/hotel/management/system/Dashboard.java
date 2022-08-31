package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4;

    Dashboard() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/luxury.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1720, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(230, 0, 1720, 1000);
        add(l1);

        b1 = new JButton("Admin");
        b1.setFont(new Font("Tahoma", Font.BOLD, 26));
        b1.addActionListener(this);
        b1.setBounds(20, 300, 190, 60);
        add(b1);

        b2 = new JButton("Reception");
        b2.setFont(new Font("Tahoma", Font.BOLD, 26));
        b2.addActionListener(this);
        b2.setBounds(20, 470, 190, 60);
        add(b2);

        b4 = new JButton("Logout");
        b4.setFont(new Font("Tahoma", Font.BOLD, 26));
        b4.addActionListener(this);
        b4.setBounds(20, 640, 190, 60);
        add(b4);

        getContentPane().setBackground(Color.decode("#6e5853"));

        setLayout(null);
        setBounds(0, 0, 1950, 1020);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            new DropDown().setVisible(true);

        } else if (ae.getSource() == b2) {

            new Reception().setVisible(true);

        } else if (ae.getSource() == b3) {

        } else if (ae.getSource() == b4) {

            new Login().setVisible(true);
            this.setVisible(false);

        }

    }

    public static void main(String[] args) {

        new Dashboard().setVisible(true);

    }

}
