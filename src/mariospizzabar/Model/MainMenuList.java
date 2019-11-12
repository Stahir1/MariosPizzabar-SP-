
package mariospizzabar.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import mariopizzabar.Datamappers.PizzaMapper;
import mariospizzabar.Pizza;

public class MainMenuList {

    ArrayList<Pizza> pizzas;

    public MainMenuList() throws ClassNotFoundException, SQLException {
        pizzas = new ArrayList<>();
        FillListFromDB();
    }

    public ArrayList<Pizza> getMovieList() {

        return pizzas;
    }

    public void FillListFromDB() throws ClassNotFoundException, SQLException {
        pizzas = PizzaMapper.PizzaList();
    }
    
    public static Pizza getPizzaFromDBByID(int id) throws ClassNotFoundException, SQLException {
        Pizza pizza = null;
       // pizza = PizzaMapper.getPizzaFromDBByID(id);
        return pizza;
    }
}