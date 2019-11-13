package mariospizzabar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariospizzabar.Util.DBConnector;

/**
 *
 * @author Sohaib, Jimmy, Daniel & Emil.
 */
public class Liste {

    static String filename = "Data/Mariosliste.csv";
    private ArrayList<Bestilling> bestillingsListe;
    private int count;
    private static Scanner x;

    public Liste(Bestilling bestilling) {
        this.bestillingsListe = listeMaker(bestilling);
    }

    public void addBestilling(Bestilling bestilling) {
        bestillingsListe.add(bestilling);
    }

    public void removeBestilling(Bestilling bestilling) {
        bestillingsListe.remove(bestilling);
    }

    public static void addPizzaToDB(ArrayList<Pizza> pizzaer, Bestilling bestilling, int orderId) {
        try {
            String query = "INSERT INTO mariopizza.activeorders (OrderId, Ordering, Pizzaname, Price, PickupTime) VALUES (?, ?, ?, ?, ?)";
            //ArrayList<Pizza> retValPizzaer = null;
            Connection myConnector = null;
            PreparedStatement pstmt = null;
            ResultSet resultSet = null;
            myConnector = DBConnector.getConnector();

            pstmt = myConnector.prepareStatement(query);
            //  int countID = 1;
            // pstmt.setInt(1, countID++);
            for (int i = 0; i < pizzaer.size(); i++) {
                pstmt.setInt(1, orderId);
                pstmt.setInt(2, i + 1); // for at lave ordering kolennen i order table starte på 1 i stedet for 0.
                pstmt.setString(3, pizzaer.get(i).getNavn());
                pstmt.setInt(4, pizzaer.get(i).getPrice());
                pstmt.setString(5, bestilling.getAfhentningsTidspunkt().toString());

                pstmt.executeUpdate();
            }

            pstmt.close();
            myConnector.close();
        } catch (SQLException ex) {
            System.out.println("Kan ikke kommunikere korrekt med databasen.");
        }
    }

    public static void removePizzaFromDB(int orderId) {
        try {
            String query2 = "INSERT INTO orderhistory (OrderID, Ordering, Pizzaname, Price) SELECT OrderID, Ordering, Pizzaname, Price FROM activeorders WHERE OrderId = ?";
            String query = "DELETE FROM mariopizza.activeorders WHERE OrderId = ?";
            //ArrayList<Pizza> retValPizzaer = null;
            Connection myConnector = null;
            PreparedStatement pstmt = null;
            PreparedStatement pstmt2 = null;
            ResultSet resultSet = null;
            myConnector = DBConnector.getConnector();

            pstmt2 = myConnector.prepareStatement(query2);
            pstmt = myConnector.prepareStatement(query);

            pstmt2.setInt(1, orderId);
            pstmt.setInt(1, orderId);

            pstmt2.executeUpdate();
            pstmt.executeUpdate();

            pstmt.close();
            myConnector.close();
            
            System.out.println("Bestilling fjernet.");
            
        } catch (SQLException ex) {
            System.out.println("Kan ikke kommunikere korrekt med databasen.");
        }
    }

    public static void insertPizzaToHistoryDB(ArrayList<Pizza> pizzaer, Bestilling bestilling, int orderId) {
        try {
            String query = "INSERT INTO mariopizza.orderhistory (OrderId, Pizzaname, Price) SELECT OrderId, Pizzaname, Price FROM mariopizza.activeorders";
            //ArrayList<Pizza> retValPizzaer = null;
            Connection myConnector = null;
            PreparedStatement pstmt = null;
            ResultSet resultSet = null;
            myConnector = DBConnector.getConnector();

            pstmt = myConnector.prepareStatement(query);

            for (int i = 0; i < pizzaer.size(); i++) {
                pstmt.setInt(1, orderId);
                pstmt.setString(2, pizzaer.get(i).getNavn());
                pstmt.setInt(3, pizzaer.get(i).getPrice());

                pstmt.executeUpdate();
            }

            pstmt.close();
            myConnector.close();
        } catch (SQLException ex) {
            System.out.println("Kan ikke kommunikere korrekt med databasen.");
        }
    }

    public static void pizzaStatistics() {
        try {
            String query = "SELECT Pizzaname, SUM(Price) FROM mariopizza.orderhistory GROUP BY Pizzaname ORDER BY SUM(Price) DESC LIMIT 1";
            Connection myConnector = null;
            PreparedStatement pstmt = null;
            ResultSet resultSet = null;
            myConnector = DBConnector.getConnector();

            pstmt = myConnector.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String ProductName = resultSet.getString(1);
                int Price = resultSet.getInt(2);
                System.out.println("Mest solgte pizza: " + ProductName + ", Omsætning: " + Price + "\n");

            }
        } catch (SQLException ex) {
            System.out.println("Kan ikke kommunikere korrekt med databasen.");
        }
    }

    public ArrayList listeMaker(Bestilling bestilling) {
        ArrayList<Bestilling> marioListe = new ArrayList();

        marioListe.add(bestilling);

        return marioListe;
    }

    @Override
    public String toString() {
        return bestillingsListe + "\n";
    }

}
