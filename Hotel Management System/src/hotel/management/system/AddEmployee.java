package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5, t6;
    JRadioButton r1, r2;
    JComboBox c1;
    JButton b1, b2;

    AddEmployee() {

        JLabel name = new JLabel("NAME");
        name.setBounds(60, 30, 120, 30);
        name.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(name);

        t1 = new JTextField();
        t1.setBounds(200, 30, 150, 30);
        add(t1);

        JLabel age = new JLabel("AGE");
        age.setBounds(60, 80, 120, 30);
        age.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(age);

        t2 = new JTextField();
        t2.setBounds(200, 80, 150, 30);
        add(t2);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60, 130, 120, 30);
        gender.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r1.setBounds(200, 130, 70, 30);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r2.setBounds(280, 130, 70, 30);
        r2.setBackground(Color.WHITE);
        add(r2);

        JLabel job = new JLabel("JOB");
        job.setBounds(60, 180, 120, 30);
        job.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(job);

        String str[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Stuff", "Room Service", "Waiter", "Manager", "Accountant", "Chef"};
        c1 = new JComboBox(str);
        c1.setBounds(200, 180, 150, 30);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60, 230, 120, 30);
        salary.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(salary);

        t3 = new JTextField();
        t3.setBounds(200, 230, 150, 30);
        add(t3);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60, 280, 120, 30);
        phone.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(phone);

        t4 = new JTextField();
        t4.setBounds(200, 280, 150, 30);
        add(t4);

        JLabel nid = new JLabel("NID");
        nid.setBounds(60, 330, 120, 30);
        nid.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(nid);

        t5 = new JTextField();
        t5.setBounds(200, 330, 150, 30);
        add(t5);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(60, 380, 120, 30);
        email.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(email);

        t6 = new JTextField();
        t6.setBounds(200, 380, 150, 30);
        add(t6);

        b1 = new JButton("Submit");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(250, 440, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(130, 440, 100, 30);
        b2.addActionListener(this);
        add(b2);

        JLabel l1 = new JLabel("ADD EMPLOYEE DETAILS");
        l1.setForeground(Color.darkGray);
        l1.setBounds(420, 50, 400, 30);
        l1.setFont(new Font("Tahoma", Font.BOLD, 28));
        add(l1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(520, 520, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(380, 55, 450, 450);
        add(l2);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(400, 200, 900, 580);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String name = t1.getText();
            String age = t2.getText();
            int ageInt = Integer.parseInt(age);
            String salary = t3.getText();
            int salaryInt = Integer.parseInt(salary);
            String phone = t4.getText();
            String nid = t5.getText();
            String email = t6.getText();

            String gender = "null";

            if (r1.isSelected()) {
                
                gender = "Male";
                
            } else if (r2.isSelected()) {
                
                gender = "Female";
                
            }

            String job = (String) c1.getSelectedItem();

            ConnectMSSQL c = new ConnectMSSQL();

            String str = "insert into employee values('" + name + "','" + ageInt + "','" + gender + "','" + job + "','" + salaryInt + "','" + phone + "','" + nid + "','" + email + "')";

            try {

                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "Employee added");

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                r1.setSelected(false);
                r2.setSelected(false);
                c1.setSelectedItem(null);

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {

            this.setVisible(false);

        }

    }

    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }

}
