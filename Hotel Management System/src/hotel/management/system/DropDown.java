package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DropDown extends JFrame implements ActionListener {

    JButton b1, b2, b3;

    DropDown() {

        b1 = new JButton("Add Employee");
        b1.setFont(new Font("Tahoma", Font.BOLD, 16));
        b1.addActionListener(this);
        b1.setBounds(5, 30, 160, 40);
        add(b1);

        b2 = new JButton("Add Room");
        b2.setFont(new Font("Tahoma", Font.BOLD, 16));
        b2.addActionListener(this);
        b2.setBounds(5, 100, 160, 40);
        add(b2);

        b3 = new JButton("Add Driver");
        b3.setFont(new Font("Tahoma", Font.BOLD, 16));
        b3.addActionListener(this);
        b3.setBounds(5, 170, 160, 40);
        add(b3);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(230, 337, 190, 290);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            new AddEmployee().setVisible(true);

        } else if (ae.getSource() == b2) {

            new AddRooms().setVisible(true);

        } else if (ae.getSource() == b3) {

            new AddDriver().setVisible(true);

        }

    }

    public static void main(String[] args) {

        new DropDown().setVisible(true);

    }

}
