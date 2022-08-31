package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1, t2, t3;
    JButton b1, b2, b3;

    UpdateRoom() {

        JLabel l1 = new JLabel("Update Room Status");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        l1.setForeground(Color.BLUE);
        l1.setBounds(30, 20, 250, 30);
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

        JLabel l3 = new JLabel("Customer Phone No.");
        l3.setBounds(30, 130, 120, 20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(160, 130, 150, 25);
        add(t1);

        JLabel l4 = new JLabel("Availability");
        l4.setBounds(30, 180, 120, 20);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(160, 180, 150, 25);
        add(t2);

        JLabel l5 = new JLabel("Cleaning Status");
        l5.setBounds(30, 230, 120, 20);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(160, 230, 150, 25);
        add(t3);

        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(30, 300, 100, 30);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(140, 300, 100, 30);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setBounds(250, 300, 100, 30);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(400, 0, 500, 400);
        add(icon);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(500, 200, 970, 430);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String room = null;
            String s1 = c1.getSelectedItem();

            ConnectMSSQL c = new ConnectMSSQL();

            try {

                ResultSet rs = c.s.executeQuery("select * from customer where room = '" + s1 + "'");

                while (rs.next()) {

                    t1.setText(rs.getString("phone"));
                    room = rs.getString("phone");

                }

                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '" + s1 + "'");

                while (rs2.next()) {

                    t2.setText(rs2.getString("available"));
                    t3.setText(rs2.getString("status"));

                }

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {

            try {

                ConnectMSSQL c = new ConnectMSSQL();

                String room = t1.getText();
                String available = t2.getText();
                String status = t3.getText();

                String str = "update room set available = '" + available + "', status = '" + status + "' where room_number = '" + room + "'";
                
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "Room Updated Successfully");

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b3) {

            new Reception().setVisible(true);
            this.setVisible(false);

        }

    }

    public static void main(String[] args) {

        new UpdateRoom().setVisible(true);

    }

}
