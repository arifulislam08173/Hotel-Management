package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;
    JCheckBox check;

    SignUp() {

        l1 = new JLabel("Username");
        l1.setBounds(40, 50, 100, 30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 100, 100, 30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 50, 150, 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 100, 150, 30);
        add(t2);

        check = new JCheckBox("Show Password");
        check.setBounds(185, 140, 140, 30);
        check.setBackground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        b1 = new JButton("Signup");
        b1.setBounds(40, 230, 120, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 230, 120, 30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 10, 200, 200);
        add(l3);

        JMenuItem l4 = new JMenuItem("<HTML><U>Already have an account? Login</U></HTML>");
        l4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l4.setBackground(Color.WHITE);
        l4.setBounds(360, 310, 200, 30);
        l4.addActionListener(this);
        add(l4);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(700, 300, 600, 400);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String username = t1.getText();
            String password = t2.getText();

            ConnectMSSQL c = new ConnectMSSQL();

            String str = "insert into login values('" + username + "','" + password + "')";

            try {

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Account Created");

                new Login().setVisible(true);

            } catch (Exception e) {

            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
            new HotelManagementSystem().setVisible(true);

        } else if (ae.getActionCommand().equals("<HTML><U>Already have an account? Login</U></HTML>")) {

            new Login().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == check) {

            if (check.isSelected()) {

                t2.setEchoChar((char) 0);

            } else {

                t2.setEchoChar('*');

            }

        }

    }

    public static void main(String[] args) {
        new SignUp().setVisible(true);
    }

}
