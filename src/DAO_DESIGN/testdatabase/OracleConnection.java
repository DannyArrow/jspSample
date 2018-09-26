package DAO_DESIGN.testdatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnection {

    public Connection  getConnection() {
        Connection connection = null;

        try {
         //   Class.forName("com.mysql.jdbc.Driver");

           //mysql connector
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/new_schema","root","123456");

            //oracle connecter to database for the case study
//            Connection con = DriverManager.getConnection(
//                    "jdbc:myDriver:myDatabase",
//                    username,
//                    password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }


}
