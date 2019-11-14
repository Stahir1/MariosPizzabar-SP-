package mariospizzabar;

import java.util.ArrayList;
import java.sql.*;
import java.util.Scanner;
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

    // Her tilføjes bestillinger/pizzaer til databasen.
    // Metoden kræver en ArrayList med pizzaer, en bestilling samt et autogenereret ordre id.
    public static void addPizzaToDB(ArrayList<Pizza> pizzaer, Bestilling bestilling, int orderId) {
        try {
            String query = "INSERT INTO mariopizza.activeorders (OrderId, Ordering, Pizzaname, Price, PickupTime) VALUES (?, ?, ?, ?, ?)";
            Connection myConnector = null;
            PreparedStatement pstmt = null;
            ResultSet resultSet = null;
            myConnector = DBConnector.getConnector();

            pstmt = myConnector.prepareStatement(query);
            
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

    // Her kan man intaste ordre id'et på den bestilling man ønsker at fjerne.
    // Når man fjerner en bestilling, ryger den af Marios liste over,
    // hvilke pizzaer han skal lave til ovre i statistik-listen (orderhistory).
    public static void removePizzaFromDB(int orderId) {
        try {
            String query2 = "INSERT INTO orderhistory (OrderID, Pizzaname, Price) SELECT OrderId, Pizzaname, Price FROM activeorders WHERE OrderId = ?";
            String query = "DELETE FROM mariopizza.activeorders WHERE OrderId = ?";
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
            System.out.println("Kunne ikke kommunikere med databasen.");;
        }

    }

    // Her ses den mest solgte pizza samt den samlede omsætning.
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
