
package mariospizzabar;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Menukort {
    private ArrayList<Pizza> menukort;

    public Menukort() {
        this.menukort = MenukortMaker();
    }
    
    
    public void addPizza(Pizza pizza) {
        menukort.add(pizza);
    }
    
    public void removePizza(Pizza pizza) {
        menukort.remove(pizza);
    }
    
    public static ArrayList MenukortMaker() {
        
        ArrayList<Pizza> marioMenu = new ArrayList();
        
        marioMenu.add(new Pizza(1, "Vesuvio", "tomatsauce, ost, skinke og oregano", 57));
        //indsæt nyhed:
        marioMenu.add(new Pizza(2, "Amerikaner", "tomatsauce, ost, oksefars og oregano", 53));
        marioMenu.add(new Pizza(3, "Cacciatore", "tomatsauce, ost, pepperoni og oregano", 57));
        //indsæt nyhed:
        marioMenu.add(new Pizza(4, "Carbona", "tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano", 63));
        //indsæt nyhed:
        marioMenu.add(new Pizza(5, "Dennis", "tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano", 65));
        marioMenu.add(new Pizza(6, "Bertil", "tomatsauce, ost, bacon og oregano", 57));
        marioMenu.add(new Pizza(7, "Silvia", "tomatsauce, ost, pepperoni, rød peber, løg og oregano", 61));
        marioMenu.add(new Pizza(8, "Victoria", "tomatsauce, ost, skinke, ananas, champignon, løg og oregano", 61));
        //indsæt nyhed:
        marioMenu.add(new Pizza(9, "Toronfo", "tomatsauce, ost, skinke, bacon, kebab, chili og oregano", 61));
        marioMenu.add(new Pizza(10, "Capricciosa", "tomatsauce, ost, skinke, champignon og oregano", 61));
        marioMenu.add(new Pizza(11, "Hawaii", "tomatsauce, ost, skinke, ananas og oregano", 61));
        marioMenu.add(new Pizza(12, "Le Blissola", "tomatsauce, ost, skinke, rejer og oregano", 61));
        marioMenu.add(new Pizza(13, "Venezia", "tomatsauce, ost, skinke, bacon og oregano", 61));
        //indsæt nyhed:
        marioMenu.add(new Pizza(14, "Mafia", "tomatsauce, ost, pepperoni, bacon, løg og oregano", 61));
        //TODO: lav op til 31 pizzaer.
        
        return marioMenu;
    }
    
        public static Object getPizzaByID(int pizzaID){
            pizzaID -= 1;
            return MenukortMaker().get(pizzaID);
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
