package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class CheckOut extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1;
    JButton b1, b2, b3;

    CheckOut() {

        JLabel l1 = new JLabel("Check Out");
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setBounds(100, 20, 100, 30);
        add(l1);

        JLabel l2 = new JLabel("Room");
        l2.setBounds(30, 80, 120, 30);
        add(l2);

        c1 = new Choice();

        try {

            ConnectMSSQL c = new ConnectMSSQL();

            ResultSet rs = c.s.executeQuery("select * from room where available = 'Occupied'");

            while (rs.next()) {

                c1.add(rs.getString("room_number"));

            }

        } catch (Exception e) {

        }

        c1.setBounds(170, 80, 150, 30);
        add(c1);

        JLabel l3 = new JLabel("Customer Phone No.");
        l3.setBounds(30, 130, 120, 30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(170, 130, 150, 30);
        add(t1);

        b1 = new JButton("Checkout");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(40, 200, 120, 30);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(180, 200, 120, 30);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(330, 80, 20, 20);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 210, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(370, 10, 400, 250);
        add(l4);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(500, 200, 800, 300);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String room = c1.getSelectedItem();
            String phone = t1.getText();

            ConnectMSSQL c = new ConnectMSSQL();

            String str2 = "update room set available = 'Available' where room_number = '" + room + "'";

            try {
                
                c.s.executeUpdate(str2);

                JOptionPane.showMessageDialog(null, "Checkout Done");

            } catch (Exception e) {

                System.out.println(e);

            }

        } else if (ae.getSource() == b2) {

            new Reception().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == b3) {

            ConnectMSSQL c = new ConnectMSSQL();

            String s = c1.getSelectedItem();

            try {

                ResultSet rs = c.s.executeQuery("select * from customer where room = '" + s + "'");

                while (rs.next()) {

                    t1.setText(rs.getString("phone"));

                }

            } catch (Exception e) {

            }

        }

    }

    public static void main(String[] args) {

        new CheckOut().setVisible(true);

    }

}
