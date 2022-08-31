package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2;
    JComboBox c1, c2, c3, c4;

    CustomerInfo() {

        t1 = new JTable();
        t1.setBounds(0, 40, 1000, 300);
        add(t1);

        c1 = new JComboBox(new String[]{"Country Region", "Local", "Foreigner"});
        c1.setBounds(160, 400, 150, 25);
        c1.setBackground(Color.WHITE);
        c1.addActionListener(this);
        add(c1);

        c2 = new JComboBox(new String[]{"Sort By", "Room"});
        c2.setBounds(440, 400, 150, 25);
        c2.setBackground(Color.WHITE);
        c2.addActionListener(this);
        add(c2);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(50, 10, 70, 20);
        add(l1);

        JLabel l2 = new JLabel("Phone");
        l2.setBounds(190, 10, 70, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330, 10, 70, 20);
        add(l3);

        JLabel l4 = new JLabel("Country");
        l4.setBounds(470, 10, 70, 20);
        add(l4);

        JLabel l5 = new JLabel("Room");
        l5.setBounds(620, 10, 70, 20);
        add(l5);

        JLabel l6 = new JLabel("Checked In");
        l6.setBounds(750, 10, 70, 20);
        add(l6);

        JLabel l7 = new JLabel("Deposit");
        l7.setBounds(890, 10, 70, 20);
        add(l7);

        b1 = new JButton("Load Data");
        b1.setBounds(350, 560, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(530, 560, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(450, 200, 1000, 650);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                ConnectMSSQL c = new ConnectMSSQL();
                String str = "select name, phone, gender, country, room, status, deposit from customer";
                ResultSet rs = c.s.executeQuery(str);

                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {

            new Reception().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == c1) {

            if (c1.getSelectedItem() == "Local") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, phone, gender, country, room, status, deposit from customer where country = 'Bangladesh'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c1.getSelectedItem() == "Foreigner") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, phone, gender, country, room, status, deposit from customer where not country = 'Bangladesh'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            }

        } else if (ae.getSource() == c2) {

            if (c2.getSelectedItem() == "Room") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, phone, gender, country, room, status, deposit from customer order by room + 0";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            }

        }

    }

    public static void main(String[] args) {
        new CustomerInfo().setVisible(true);
    }

}
