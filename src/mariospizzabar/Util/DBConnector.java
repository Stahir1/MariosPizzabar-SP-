package mariospizzabar.Util;

import java.sql.*;

public class DBConnector {

    public static Connection getConnector() {
        Connection connector = null;
        String url = "jdbc:mysql://localhost:3306/mariopizza?";
        url += "serverTimezone=UTC&allowPublicKeyRetrieval=true&";
        url += "useSSL=false";
        String user = "root";
        String password = "Cph23168";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Kan ikke finde stien.");

        }
        try {
            connector = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Kan ikke kommunikere korrekt med databasen.");
        }

        return connector;
    }
}
