package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2, b3, b4;
    JComboBox c1, c2, c3, c4, c5, c6, c7, c8;

    EmployeeInfo() {

        t1 = new JTable();
        t1.setBounds(0, 40, 1010, 300);
        add(t1);

        c1 = new JComboBox(new String[]{"Sort By", "Name", "Age", "Job"});
        c1.setBounds(10, 400, 100, 25);
        c1.setBackground(Color.WHITE);
        c1.addActionListener(this);
        add(c1);

        c2 = new JComboBox(new String[]{"Salary Range", "1k-20k", "21k-40k", "41k-60k", "60k+"});
        c2.setBounds(140, 400, 100, 25);
        c2.setBackground(Color.WHITE);
        c2.addActionListener(this);
        add(c2);

        c3 = new JComboBox(new String[]{"Job", "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Stuff", "Room Service", "Waiter", "Manager", "Accountant", "Chef"});
        c3.setBounds(280, 400, 140, 25);
        c3.setBackground(Color.WHITE);
        c3.addActionListener(this);
        add(c3);

        c4 = new JComboBox(new String[]{"No. of employees according to job", "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Stuff", "Room Service", "Waiter", "Manager", "Accountant", "Chef"});
        c4.setBounds(460, 400, 230, 25);
        c4.setBackground(Color.WHITE);
        c4.addActionListener(this);
        add(c4);

        c5 = new JComboBox(new String[]{"Mobile SIM operator", "Grameenphone", "Robi", "Banglalink", "Airtel", "Teletalk"});
        c5.setBounds(730, 400, 160, 25);
        c5.setBackground(Color.WHITE);
        c5.addActionListener(this);
        add(c5);

        c6 = new JComboBox(new String[]{"Average Salary according to job", "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Stuff", "Room Service", "Waiter", "Manager", "Accountant", "Chef"});
        c6.setBounds(80, 470, 230, 25);
        c6.setBackground(Color.WHITE);
        c6.addActionListener(this);
        add(c6);

        c7 = new JComboBox(new String[]{"Salary greater than Average Salary", "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Stuff", "Room Service", "Waiter", "Manager", "Accountant", "Chef"});
        c7.setBounds(360, 470, 230, 25);
        c7.setBackground(Color.WHITE);
        c7.addActionListener(this);
        add(c7);

        c8 = new JComboBox(new String[]{"Salary less than Average Salary", "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Stuff", "Room Service", "Waiter", "Manager", "Accountant", "Chef"});
        c8.setBounds(640, 470, 230, 25);
        c8.setBackground(Color.WHITE);
        c8.addActionListener(this);
        add(c8);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 10, 70, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(170, 10, 70, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(290, 10, 70, 20);
        add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(400, 10, 70, 20);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(540, 10, 70, 20);
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(670, 10, 70, 20);
        add(l6);

        JLabel l7 = new JLabel("NID");
        l7.setBounds(790, 10, 70, 20);
        add(l7);

        JLabel l8 = new JLabel("Email");
        l8.setBounds(910, 10, 70, 20);
        add(l8);

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

        b4 = new JButton("Delete");
        b4.setBounds(680, 560, 120, 30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        add(b4);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(450, 200, 1030, 650);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                ConnectMSSQL c = new ConnectMSSQL();
                String str = "select name, age, gender, job, salary, phone, nid, email from employee";
                ResultSet rs = c.s.executeQuery(str);

                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {

            new Reception().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == c1) {

            if (c1.getSelectedItem() == "Name") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();
                    String str = "select name, age, gender, job, salary, phone, nid, email from employee order by name";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c1.getSelectedItem() == "Age") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();
                    String str = "select name, age, gender, job, salary, phone, nid, email from employee order by age + 0";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c1.getSelectedItem() == "Job") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee order by job";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            }

        } else if (ae.getSource() == c2) {

            if (c2.getSelectedItem() == "1k-20k") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary between 1000 and 20000";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c2.getSelectedItem() == "21k-40k") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary between 20001 and 40000";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c2.getSelectedItem() == "41k-60k") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary between 40001 and 60000";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c2.getSelectedItem() == "60k+") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary > 60001";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            }

        } else if (ae.getSource() == b4) {

            int row = t1.getSelectedRow();

            String cell = t1.getModel().getValueAt(row, 0).toString();

            System.out.println(cell);

            try {

                ConnectMSSQL c = new ConnectMSSQL();

                String str = "delete from employee where name = '" + cell + "'";

                c.s.executeQuery(str);

                JOptionPane.showMessageDialog(null, "Row deleted");

            } catch (Exception e) {

                System.out.println(e);

            }

        } else if (ae.getSource() == c3) {

            if (c3.getSelectedItem() == "Front Desk Clerks") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where job = 'Front Desk Clerks'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c3.getSelectedItem() == "Porters") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where job = 'Porters'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c3.getSelectedItem() == "Housekeeping") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where job = 'Housekeeping'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c3.getSelectedItem() == "Kitchen Stuff") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where job = 'Kitchen Stuff'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c3.getSelectedItem() == "Room Service") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where job = 'Room Service'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c3.getSelectedItem() == "Waiter") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where job = 'Waiter'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c3.getSelectedItem() == "Manager") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where job = 'Manager'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c3.getSelectedItem() == "Accountant") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where job = 'Accountant'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            } else if (c3.getSelectedItem() == "Chef") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where job = 'Chef'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                }

            }

        } else if (ae.getSource() == c4) {

            if (c4.getSelectedItem() == "Front Desk Clerks") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select count(job) from employee where job = 'Front Desk Clerks'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "There are currently " + String.valueOf(i) + " Front Desk Clerks in our hotel");

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c4.getSelectedItem() == "Porters") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select count(job) from employee where job = 'Porters'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "There are currently " + String.valueOf(i) + " Porters in our hotel");

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c4.getSelectedItem() == "Housekeeping") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select count(job) from employee where job = 'Housekeeping'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "There are currently " + String.valueOf(i) + " Housekeepers in our hotel");

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c4.getSelectedItem() == "Kitchen Stuff") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select count(job) from employee where job = 'Kitchen Stuff'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "There are currently " + String.valueOf(i) + " Kitchen Stuffs in our hotel");

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c4.getSelectedItem() == "Room Service") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select count(job) from employee where job = 'Room Service'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "There are currently " + String.valueOf(i) + " Room Service person in our hotel");

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c4.getSelectedItem() == "Waiter") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select count(job) from employee where job = 'Waiter'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "There are currently " + String.valueOf(i) + " Waiters in our hotel");

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c4.getSelectedItem() == "Manager") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select count(job) from employee where job = 'Manager'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "There are currently " + String.valueOf(i) + " Managers in our hotel");

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c4.getSelectedItem() == "Accountant") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select count(job) from employee where job = 'Accountant'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "There are currently " + String.valueOf(i) + " Accountants in our hotel");

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c4.getSelectedItem() == "Chef") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select count(job) from employee where job = 'Chef'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "There are currently " + String.valueOf(i) + " Chefs in our hotel");

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            }

        } else if (ae.getSource() == c5) {

            if (c5.getSelectedItem() == "Grameenphone") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where ((phone like '017%') or (phone like '013%'))";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c5.getSelectedItem() == "Robi") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where phone like '018%'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c5.getSelectedItem() == "Banglalink") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where ((phone like '019%') or (phone like '014%'))";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c5.getSelectedItem() == "Airtel") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where phone like '016%'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c5.getSelectedItem() == "Teletalk") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where phone like '015%'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            }

        } else if (ae.getSource() == c6) {

            if (c6.getSelectedItem() == "Front Desk Clerks") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select AVG(salary) from employee where job = 'Front Desk Clerks';";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "Average salary of Front Desk Clerk is " + String.valueOf(i));

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c6.getSelectedItem() == "Porters") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select AVG(salary) from employee where job = 'Porters'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "Average salary of Porter is " + String.valueOf(i));

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c6.getSelectedItem() == "Housekeeping") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select AVG(salary) from employee where job = 'Housekeeping'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "Average salary of Housekeeper is " + String.valueOf(i));

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c6.getSelectedItem() == "Kitchen Stuff") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select AVG(salary) from employee where job = 'Kitchen Stuff'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "Average salary of Kitchen Stuff is " + String.valueOf(i));

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c6.getSelectedItem() == "Room Service") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select AVG(salary) from employee where job = 'Room Service'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "Average salary of Room Service is " + String.valueOf(i));

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c6.getSelectedItem() == "Waiter") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select AVG(salary) from employee where job = 'Waiter'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "Average salary of Waiter is " + String.valueOf(i));

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c6.getSelectedItem() == "Manager") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select AVG(salary) from employee where job = 'Manager'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "Average salary of Manager is " + String.valueOf(i));

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c6.getSelectedItem() == "Accountant") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select AVG(salary) from employee where job = 'Accountant'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "Average salary of Accountant is " + String.valueOf(i));

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c6.getSelectedItem() == "Chef") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select AVG(salary) from employee where job = 'Chef'";

                    ResultSet rs = c.s.executeQuery(str);

                    while (rs.next()) {

                        int i = rs.getInt(1);

                        JOptionPane.showMessageDialog(null, "Average salary of Chef is " + String.valueOf(i));

                    }

                } catch (Exception e) {

                    System.out.println(e);

                }

            }

        } else if (ae.getSource() == c7) {

            if (c7.getSelectedItem() == "Front Desk Clerks") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary > (select AVG(salary) from employee where job = 'Front Desk Clerks') and job = 'Front Desk Clerks'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c7.getSelectedItem() == "Porters") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary > (select AVG(salary) from employee where job = 'Porters') and job = 'Porters'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c7.getSelectedItem() == "Housekeeping") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary > (select AVG(salary) from employee where job = 'Housekeeping') and job = 'Housekeeping'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c7.getSelectedItem() == "Kitchen Stuff") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary > (select AVG(salary) from employee where job = 'Kitchen Stuff') and job = 'Kitchen Stuff'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c7.getSelectedItem() == "Room Service") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary > (select AVG(salary) from employee where job = 'Room Service') and job = 'Room Service'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c7.getSelectedItem() == "Waiter") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary > (select AVG(salary) from employee where job = 'Waiter') and job = 'Waiter'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c7.getSelectedItem() == "Manager") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary > (select AVG(salary) from employee where job = 'Manager') and job = 'Manager'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c7.getSelectedItem() == "Accountant") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary > (select AVG(salary) from employee where job = 'Accountant') and job = 'Accountant'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c7.getSelectedItem() == "Chef") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary > (select AVG(salary) from employee where job = 'Chef') and job = 'Chef'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            }

        } else if (ae.getSource() == c8) {

            if (c8.getSelectedItem() == "Front Desk Clerks") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary < (select AVG(salary) from employee where job = 'Front Desk Clerks') and job = 'Front Desk Clerks'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c8.getSelectedItem() == "Porters") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary < (select AVG(salary) from employee where job = 'Porters') and job = 'Porters'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c8.getSelectedItem() == "Housekeeping") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary < (select AVG(salary) from employee where job = 'Housekeeping') and job = 'Housekeeping'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c8.getSelectedItem() == "Kitchen Stuff") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary < (select AVG(salary) from employee where job = 'Kitchen Stuff') and job = 'Kitchen Stuff'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c8.getSelectedItem() == "Room Service") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary < (select AVG(salary) from employee where job = 'Room Service') and job = 'Room Service'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c8.getSelectedItem() == "Waiter") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary < (select AVG(salary) from employee where job = 'Waiter') and job = 'Waiter'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c8.getSelectedItem() == "Manager") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary < (select AVG(salary) from employee where job = 'Manager') and job = 'Manager'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c8.getSelectedItem() == "Accountant") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary < (select AVG(salary) from employee where job = 'Accountant') and job = 'Accountant'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            } else if (c8.getSelectedItem() == "Chef") {

                try {

                    ConnectMSSQL c = new ConnectMSSQL();

                    String str = "select name, age, gender, job, salary, phone, nid, email from employee where salary < (select AVG(salary) from employee where job = 'Chef') and job = 'Chef'";

                    ResultSet rs = c.s.executeQuery(str);

                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {

                    System.out.println(e);

                }

            }

        }

    }

    public static void main(String[] args) {

        new EmployeeInfo().setVisible(true);

    }

}
