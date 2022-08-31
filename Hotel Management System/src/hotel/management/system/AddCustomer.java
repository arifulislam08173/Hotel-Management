package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2;
    Choice c1;
    JRadioButton r1, r2;

    AddCustomer() {

        JLabel l1 = new JLabel("New Customer Form");
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setBounds(100, 20, 300, 30);
        add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(35, 80, 100, 20);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 80, 150, 25);
        add(t1);

        JLabel l3 = new JLabel("Phone");
        l3.setBounds(35, 120, 100, 20);
        add(l3);

        t2 = new JTextField();
        t2.setBounds(150, 120, 150, 25);
        add(t2);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(35, 160, 100, 20);
        add(l4);

        r1 = new JRadioButton("Male");
        r1.setBounds(150, 160, 60, 25);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(220, 160, 80, 25);
        r2.setBackground(Color.WHITE);
        add(r2);

        JLabel l6 = new JLabel("Country");
        l6.setBounds(35, 200, 100, 20);
        add(l6);

        t3 = new JTextField();
        t3.setBounds(150, 200, 150, 25);
        add(t3);

        JLabel l7 = new JLabel("Allocated Room");
        l7.setBounds(35, 240, 100, 20);
        add(l7);

        c1 = new Choice();
        try {

            ConnectMSSQL c = new ConnectMSSQL();

            String str = "select * from room where available = 'Available'";

            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()) {

                c1.add(rs.getString("room_number"));

            }

        } catch (Exception e) {

        }

        c1.setBounds(150, 240, 150, 25);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel l8 = new JLabel("Checked In");
        l8.setBounds(35, 280, 100, 20);
        add(l8);

        t4 = new JTextField();
        t4.setBounds(150, 280, 150, 25);
        add(t4);

        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(35, 320, 100, 20);
        add(l9);

        t5 = new JTextField();
        t5.setBounds(150, 320, 150, 25);
        add(t5);

        b1 = new JButton("Add Customer");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(50, 370, 120, 30);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(200, 370, 120, 30);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/customer.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(400, 20, 300, 400);
        add(l10);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(500, 200, 800, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String name = t1.getText();
            String phone = t2.getText();
            String gender = null;
            
            if (r1.isSelected()) {
                
                gender = "Male";
                
            } else if (r2.isSelected()) {
                
                gender = "Female";
                
            }
            
            String country = t3.getText();
            String room = c1.getSelectedItem();
            int roomInt = Integer.parseInt(room);
            String status = t4.getText();
            String deposit = t5.getText();
            int depositInt = Integer.parseInt(deposit);

            ConnectMSSQL c = new ConnectMSSQL();

            String str = "insert into customer values ('" + name + "','" + phone + "','" + gender + "','" + country + "','" + roomInt + "','" + status + "','" + depositInt + "')";

            String str2 = "update room set available = 'Occupied' where room_number = '" + roomInt + "'";

            try {

                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);

                JOptionPane.showMessageDialog(null, "Customer Added");
                
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {

            new Reception().setVisible(true);
            this.setVisible(false);

        }

    }

    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }

}
