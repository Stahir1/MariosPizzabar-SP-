package mariospizzabar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariospizzabar.Util.DBConnector;

// @author Sohaib, Jimmy, Daniel & Emil.
public class Bestilling {

    /**
     * ************************************************************************
     * Vores bestillingsklasse kan kun have én pizza pr. bestilling. Dette
     * skyldes, at vi ikke har lavet en addPizzaToOrder-metode. Men da hver
     * pizza bliver printet og tilføjet til Mariosliste.csv vil pizzaerne blive
     * gemt der.
     *
     * Minusset her er, at man ikke kan bestille f.eks. 3 pizzaer på en gang og
     * få den skrevet ind under samme bestillings ID. Men det var heller ikke et
     * krav i kravspecifikationen.
     * ************************************************************************
     */
    private int ordreID;
    private LocalTime afhentningsTidspunkt;
    private ArrayList<Pizza> pizzaer;

    public Bestilling(int ordreID, String afhentningsTidspunkt, ArrayList<Pizza> pizzaer) {
        this.ordreID = ordreID;
        String[] temp = afhentningsTidspunkt.split(":");
        this.afhentningsTidspunkt = LocalTime.of(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        this.pizzaer = pizzaer;
    }

    public ArrayList<Pizza> getPizzaer() {
        return pizzaer;
    }

    public int getOrdreID() {
        return ordreID;
    }

    public void setOrdreID(int ordreID) {
        this.ordreID = ordreID;
    }

    public LocalTime getAfhentningsTidspunkt() {
        return afhentningsTidspunkt;
    }

    public void setAfhentningsTidspunkt(LocalTime afhentningsTidspunkt) {
        this.afhentningsTidspunkt = afhentningsTidspunkt;
    }

    public static void getBestillingFromDB() {
        try {
            String query = "SELECT OrderID, Pizzaname, Price, PickupTime FROM mariopizza.activeorders";
            Connection myConnector = null;
            PreparedStatement pstmt = null;
            ResultSet resultSet = null;
            myConnector = DBConnector.getConnector();

            pstmt = myConnector.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int OrderID = resultSet.getInt("OrderID");
                String ProductName = resultSet.getString("Pizzaname");
                int Price = resultSet.getInt("Price");
                String PickupTime = resultSet.getString("PickupTime");

                System.out.println("Ordre ID: " + OrderID + ", Pizzanavn: " + ProductName + ", Pris: " + Price + ", Afhentningstidspunkt: " + PickupTime);

            }
        } catch (SQLException ex) {
            System.out.println("Kan ikke kommunikere korrekt med databasen.");
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Pizza pizza : pizzaer) {
            result += pizza.toString() + "\n";
        }
        return result;
    }

}
