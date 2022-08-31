package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStatus extends JFrame implements ActionListener {

    JButton b1, b2, b3;
    Choice c1;
    JTextField t1, t2, t3, t4, t5;

    UpdateStatus() {

        JLabel l1 = new JLabel("Check-in Details");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(80, 30, 200, 30);
        add(l1);

        JLabel l2 = new JLabel("Room");
        l2.setBounds(30, 80, 120, 20);
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

        c1.setBounds(160, 80, 150, 25);
        add(c1);

        JLabel l3 = new JLabel("Phone No.");
        l3.setBounds(30, 130, 100, 20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(160, 130, 150, 25);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(30, 180, 100, 20);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(160, 180, 150, 25);
        add(t2);

        JLabel l5 = new JLabel("Check-in");
        l5.setBounds(30, 230, 100, 20);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(160, 230, 150, 25);
        add(t3);

        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(30, 280, 100, 20);
        add(l6);

        t4 = new JTextField();
        t4.setBounds(160, 280, 150, 25);
        add(t4);

        JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(30, 330, 100, 20);
        add(l7);

        t5 = new JTextField();
        t5.setBounds(160, 330, 150, 25);
        add(t5);

        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(30, 390, 100, 30);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(150, 390, 100, 30);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setBounds(270, 390, 100, 30);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/nine.jpg"));
        JLabel l9 = new JLabel(i1);
        l9.setBounds(400, 50, 500, 300);
        add(l9);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(500, 200, 960, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                ConnectMSSQL c = new ConnectMSSQL();

                String room = null;
                
                String deposit = null;
                
                int amountPaid;
                
                String price = null;
                
                String id = c1.getSelectedItem();

                String str = "select * from customer where room = '" + id + "'";

                ResultSet rs = c.s.executeQuery(str);

                while (rs.next()) {

                    t1.setText(rs.getString("phone"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));

                    room = rs.getString("room");
                    deposit = rs.getString("deposit");

                }

                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '" + room + "'");

                while (rs2.next()) {

                    price = rs2.getString("price");

                    amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);

                    t5.setText(Integer.toString(amountPaid));

                }

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {

            try {

                ConnectMSSQL c = new ConnectMSSQL();

                String s1 = c1.getSelectedItem();
                String s2 = t1.getText();
                int s3 = Integer.parseInt(s2);
                String s4 = t2.getText();
                String s5 = t3.getText();
                String s6 = t4.getText();
                int s7 = Integer.parseInt(s6);

                String str = "update customer set phone = '" + s3 + "', name = '" + s4 + "', status = '" + s5 + "', deposit = '" + s7 + "' where room = '" + s1 + "'";

                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "Data Updated Successfully");

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b3) {

            new Reception().setVisible(true);
            this.setVisible(false);

        }

    }

    public static void main(String[] args) {

        new UpdateStatus().setVisible(true);

    }

}
