package mariospizzabar.Util;

import java.sql.*;


public class DBConnector {

    public static Connection getConnector() throws ClassNotFoundException, SQLException {
        Connection connector = null;
        String url = "jdbc:mysql://localhost:3306/movies?";
        url += "serverTimezone=UTC&allowPublicKeyRetrieval=true&";
        url += "useSSL=false";
        String user = "root1";
        String password = "ascent";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connector = DriverManager.getConnection(url,user,password);
        
        return connector;
    }
}
