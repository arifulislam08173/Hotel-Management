package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddDriver extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5;
    JComboBox c1, c2;
    JButton b1, b2;

    AddDriver() {

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma", Font.BOLD, 17));
        name.setBounds(60, 80, 120, 30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(200, 80, 150, 30);
        add(t1);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma", Font.BOLD, 17));
        age.setBounds(60, 130, 120, 30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(200, 130, 150, 30);
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma", Font.BOLD, 17));
        gender.setBounds(60, 180, 120, 30);
        add(gender);

        c1 = new JComboBox(new String[]{"Male", "Female"});
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 180, 150, 30);
        add(c1);

        JLabel model = new JLabel("Car Model");
        model.setFont(new Font("Tahoma", Font.BOLD, 17));
        model.setBounds(60, 230, 120, 30);
        add(model);

        t4 = new JTextField();
        t4.setBounds(200, 230, 150, 30);
        add(t4);

        JLabel available = new JLabel("Availability");
        available.setFont(new Font("Tahoma", Font.BOLD, 17));
        available.setBounds(60, 280, 120, 30);
        add(available);

        c2 = new JComboBox(new String[]{"Available", "Busy"});
        c2.setBackground(Color.WHITE);
        c2.setBounds(200, 280, 150, 30);
        add(c2);

        JLabel location = new JLabel("Location");
        location.setFont(new Font("Tahoma", Font.BOLD, 17));
        location.setBounds(60, 330, 120, 30);
        add(location);

        t5 = new JTextField();
        t5.setBounds(200, 330, 150, 30);
        add(t5);

        b1 = new JButton("Add Driver");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(130, 410, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(250, 410, 100, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(440, 50, 500, 400);
        add(l1);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(400, 200, 1000, 560);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String name = t1.getText();
            String age = t2.getText();
            int ageInt = Integer.parseInt(age);
            String gender = (String) c1.getSelectedItem();
            String model = t4.getText();
            String available = (String) c2.getSelectedItem();
            String location = t5.getText();

            ConnectMSSQL c = new ConnectMSSQL();

            String str = "insert into driver values('" + name + "','" + ageInt + "','" + gender + "','" + model + "','" + available + "','" + location + "')";

            try {

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver Added");

                t1.setText("");
                t2.setText("");
                c1.setSelectedItem(null);
                t4.setText("");
                c2.setSelectedItem(null);
                t5.setText("");

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {

            this.setVisible(false);

        }

    }

    public static void main(String[] args) {

        new AddDriver().setVisible(true);

    }

}
