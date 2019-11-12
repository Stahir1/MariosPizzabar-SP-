
package pizzabar.view;

import java.sql.SQLException;
import static mariopizzabar.Datamappers.PizzaMapper.PizzaList;
import mariospizzabar.Model.MainMenuList;
import mariospizzabar.Pizza;

public class PizzaUI {
    public static void viewPizzaList(MainMenuList movieList) throws ClassNotFoundException, SQLException {
        for (Pizza m : PizzaList()) {
            System.out.println("Title" + m.toString());
        }
    }
    /*public static void viewMovieById(int movieid) throws ClassNotFoundException, SQLException{
        Movie movie = null;
        movie = MainMovieList.getMovieFromDBByID(movieid);
        System.out.println("Movie" + movie);
    }*/
}
