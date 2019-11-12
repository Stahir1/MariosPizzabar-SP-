/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariopizzabar.Datamappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mariospizzabar.Pizza;
import mariospizzabar.Util.DBConnector;

/**
 *
 * @author Jimmy
 */
public class PizzaMapper {
    public static ArrayList<Pizza> PizzaList() throws ClassNotFoundException, SQLException {
        ArrayList<Pizza> returnList = new ArrayList<Pizza>();
        Connection myConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;

        myConnector = DBConnector.getConnector();
        String query = "SELECT * FROM orders";
        statement = myConnector.createStatement();
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int ProductID = resultSet.getInt("ProductID");
            String ProductName = resultSet.getString("ProductName");
            String Topping = resultSet.getString("Topping");
            int Price = resultSet.getInt("Price");
            Pizza tmpPizza = new Pizza(ProductID, ProductName, Topping, Price);
            returnList.add(tmpPizza);

        }

        resultSet.close();
        statement.close();
        myConnector.close();

        return returnList;
    }
    public static Pizza getPizzaFromDB(int id) throws ClassNotFoundException, SQLException {
        Pizza retValPizza = null;
        // TODO: Get movie from DB
        String query = "SELECT * FROM mariopizza.Products WHERE ProductID = ?";
        
        Connection myConnector = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        myConnector = DBConnector.getConnector();
        
        pstmt = myConnector.prepareStatement(query);
        pstmt.setInt(1, id);
        resultSet = pstmt.executeQuery();
        while(resultSet.next()) {
            int ProductID = resultSet.getInt("ProductID");
            String ProductName = resultSet.getString("ProductName");
            String Topping = resultSet.getString("Topping");
            int Price = resultSet.getInt("Price");
            retValPizza = new Pizza(ProductID, ProductName, Topping, Price);
            
        }
        resultSet.close();
        pstmt.close();
        myConnector.close();
        
        return retValPizza;
    }
}
