package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    JTextField t1, t2;
    JComboBox c1, c2, c3;
    JButton b1, b2;

    AddRooms() {

        JLabel available = new JLabel("Availability");
        available.setFont(new Font("Tahoma", Font.BOLD, 17));
        available.setBounds(60, 130, 140, 30);
        add(available);

        c1 = new JComboBox(new String[]{"Available", "Occupied"});
        c1.setBounds(220, 130, 150, 30);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel status = new JLabel("Cleaning Status");
        status.setFont(new Font("Tahoma", Font.BOLD, 17));
        status.setBounds(60, 180, 140, 30);
        add(status);

        c2 = new JComboBox(new String[]{"Cleaned", "Dirty"});
        c2.setBounds(220, 180, 150, 30);
        c2.setBackground(Color.WHITE);
        add(c2);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma", Font.BOLD, 17));
        price.setBounds(60, 230, 140, 30);
        add(price);

        t2 = new JTextField();
        t2.setBounds(220, 230, 150, 30);
        add(t2);

        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("Tahoma", Font.BOLD, 17));
        type.setBounds(60, 280, 140, 30);
        add(type);

        c3 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        c3.setBounds(220, 280, 150, 30);
        c3.setBackground(Color.WHITE);
        add(c3);

        b1 = new JButton("Add Room");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(150, 350, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(270, 350, 100, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/twelve.jpg"));
        JLabel l2 = new JLabel(i1);
        l2.setBounds(440, 30, 500, 350);
        add(l2);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(450, 200, 1000, 470);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String available = (String) c1.getSelectedItem();
            String status = (String) c2.getSelectedItem();
            String price = t2.getText();
            int priceInt = Integer.parseInt(price);
            String type = (String) c3.getSelectedItem();

            ConnectMSSQL c = new ConnectMSSQL();

            String str = "insert into room values('" + available + "','" + status + "','" + priceInt + "','" + type + "')";

            try {

                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "Room Added");

                t2.setText("");

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {

            this.setVisible(false);

        }

    }

    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }

}
