package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {

    JComboBox c1;
    JCheckBox c2;
    JButton b1, b2, b3, b4;
    JTable t1;
    JTextField t2, t3;

    SearchRoom() {

        JLabel l1 = new JLabel("Search For Room");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setBounds(400, 30, 200, 30);
        add(l1);

        JLabel l2 = new JLabel("Room Bed Type");
        l2.setBounds(50, 100, 100, 20);
        add(l2);

        c1 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        c1.setBounds(150, 100, 150, 25);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel l8 = new JLabel("Room Price");
        l8.setBounds(450, 80, 120, 20);
        add(l8);

        t2 = new JTextField();
        t2.addActionListener(this);
        t2.setBounds(360, 120, 100, 25);
        add(t2);

        t3 = new JTextField();
        t3.addActionListener(this);
        t3.setBounds(480, 120, 100, 25);
        add(t3);

        c2 = new JCheckBox("Only Display Available");
        c2.setBackground(Color.WHITE);
        c2.setBounds(650, 100, 150, 25);
        add(c2);

        JLabel l3 = new JLabel("Room");
        l3.setBounds(90, 170, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Availability");
        l4.setBounds(270, 170, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Cleaning Status");
        l5.setBounds(450, 170, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Price");
        l6.setBounds(680, 170, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Bed Type");
        l7.setBounds(850, 170, 100, 20);
        add(l7);

        t1 = new JTable();
        t1.setBounds(0, 200, 1000, 380);
        add(t1);

        b1 = new JButton("Search");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(250, 610, 120, 30);
        add(b1);

        b4 = new JButton("Load Data");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        b4.setBounds(430, 610, 120, 30);
        add(b4);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(610, 610, 120, 30);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(500, 150, 1000, 720);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                ConnectMSSQL c = new ConnectMSSQL();

                String str = "select * from room where bed_type = '" + c1.getSelectedItem() + "' AND price between " + t2.getText() + " and " + t3.getText() + "";

                String str2 = "select * from room where available = 'Available' AND bed_type = '" + c1.getSelectedItem() + "'  and price between " + t2.getText() + " AND " + t3.getText() + "";

                ResultSet rs;

                if (c2.isSelected()) {

                    rs = c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } else {

                    rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                }

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {

            new Reception().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == b4) {

            try {

                ConnectMSSQL c = new ConnectMSSQL();

                String str = "select * from room";

                ResultSet rs = c.s.executeQuery(str);

                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {

            }

        }

    }

    public static void main(String[] args) {

        new SearchRoom().setVisible(true);

    }

}
