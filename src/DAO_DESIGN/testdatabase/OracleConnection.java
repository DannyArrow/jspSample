package DAO_DESIGN.testdatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnection {

    public Connection  getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
           // String connect = "jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false";

            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/new_schema","root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }


}
