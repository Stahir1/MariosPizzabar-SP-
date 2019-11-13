package mariospizzabar;

import java.sql.*;
import java.util.ArrayList;
import mariospizzabar.Util.DBConnector;

/**
 *
 * @author Sohaib, Jimmy, Daniel & Emil.
 */
public class Menukort {

    private ArrayList<Pizza> menukort;
    private MenukortMaker menukortMaker;
    private Pizza pizza;

    public Menukort() {
        this.menukortMaker = new MenukortMaker();
        this.menukortMaker.fillCardWithPizza();
        this.pizza = null;
        //   this.menukort = MenukortShow();
    }

    public void addPizza(Pizza pizza) {
        menukort.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        menukort.remove(pizza);
    }

    public static void getPizzaFromDB() {
        try {
            String query = "SELECT * FROM mariopizza.Products";
            Connection myConnector = null;
            PreparedStatement pstmt = null;
            ResultSet resultSet = null;
            myConnector = DBConnector.getConnector();

            pstmt = myConnector.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                // Nedenfor deklarerer vi vores kolonne-navne, så vi ikke behøver at
                // tilføje det inde i vores printline for hver pizza (dvs. 30+ gange)
                int ProductID = resultSet.getInt("ProductID");
                String ProductName = resultSet.getString("ProductName");
                String Topping = resultSet.getString("Topping");
                int Price = resultSet.getInt("Price");
                System.out.println(ProductID + ". " + "" + ProductName + ": " + Topping + ", " + Price + " kr");
            }

            resultSet.close();
            pstmt.close();
            myConnector.close();
        } catch (SQLException ex) {
            System.out.println("Kan ikke kommunikere korrekt med databasen.");
        }
    }

    public Pizza getPizzaByID(int pizzaID) {
        pizza = menukortMaker.getPizzaByID(pizzaID);
        return pizza;
    }

    @Override
    public String toString() {
        String result = "Menuen indeholder:\n";
        for (Pizza pizza : menukort) {
            result += pizza.toString() + "\n";
        }
        return result;
    }

}
