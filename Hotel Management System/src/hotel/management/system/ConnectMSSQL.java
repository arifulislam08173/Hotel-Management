package hotel.management.system;

import java.sql.*;

public class ConnectMSSQL {

    Connection c;
    Statement s;

    public ConnectMSSQL() {

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=projecthms;selectMethod=cursor", "sa", "@15sultanali16@");
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
