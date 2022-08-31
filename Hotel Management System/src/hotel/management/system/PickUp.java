package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame implements ActionListener {

    Choice c1;
    JButton b1, b2, b3;
    JTable t1;
    JCheckBox cb1, cb2;

    PickUp() {

        JLabel l1 = new JLabel("PickUp Service");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setBounds(400, 30, 200, 30);
        add(l1);

        JLabel l2 = new JLabel("Type of Car");
        l2.setBounds(50, 100, 100, 20);
        add(l2);

        c1 = new Choice();

        try {

            ConnectMSSQL c = new ConnectMSSQL();

            ResultSet rs = c.s.executeQuery("select distinct model from driver");

            while (rs.next()) {

                c1.addItem(rs.getString("model"));

            }

        } catch (Exception e) {

        }

        c1.setBounds(150, 100, 200, 25);
        add(c1);

        cb1 = new JCheckBox("Available Drivers (At Hotel)");
        cb1.setBackground(Color.WHITE);
        cb1.addActionListener(this);
        cb1.setBounds(650, 100, 200, 25);
        add(cb1);

        cb2 = new JCheckBox("Experienced Drivers");
        cb2.setBackground(Color.WHITE);
        cb2.addActionListener(this);
        cb2.setBounds(400, 100, 200, 25);
        add(cb2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(64, 170, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Age");
        l4.setBounds(240, 170, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(390, 170, 100, 20);
        add(l5);

        JLabel l7 = new JLabel("Model");
        l7.setBounds(570, 170, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Availability");
        l8.setBounds(720, 170, 100, 20);
        add(l8);

        JLabel l9 = new JLabel("Location");
        l9.setBounds(880, 170, 100, 20);
        add(l9);

        t1 = new JTable();
        t1.setBounds(0, 200, 1000, 300);
        add(t1);

        b1 = new JButton("Search");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(200, 520, 120, 30);
        add(b1);

        b3 = new JButton("Load Data");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setBounds(360, 520, 120, 30);
        add(b3);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(520, 520, 120, 30);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(500, 200, 1000, 650);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                ConnectMSSQL c = new ConnectMSSQL();

                String str = "select name, age, gender, model, available, location from driver where model = '" + c1.getSelectedItem() + "'";

                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {

            new Reception().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == cb1) {

            if (cb1.isSelected()) {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, model, available, location from driver where location = 'At Hotel'";

                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (!cb1.isSelected()) {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, model, available, location from driver";

                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            }

        } else if (ae.getSource() == cb2) {

            if (cb2.isSelected()) {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, model, available, location from driver where age >= 35";

                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (!cb2.isSelected()) {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, model, available, location from driver";

                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            }

        } else if (ae.getSource() == b3) {

            try {

                ConnectMSSQL c = new ConnectMSSQL();

                String str = "select name, age, gender, model, available, location from driver";

                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {

            }

        }

    }

    public static void main(String[] args) {

        new PickUp().setVisible(true);

    }

}
