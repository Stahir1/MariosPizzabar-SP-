package mariospizzabar;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Menukort {

    private ArrayList<Pizza> menukort;
    private MenukortMaker menukortMaker;
    private Pizza pizza;

    public Menukort() {
        this.menukortMaker = new MenukortMaker();
        this.menukortMaker.fillCardWithPizza();
        this.pizza = null;
        this.menukort = MenukortShow();
    }

    public void addPizza(Pizza pizza) {
        menukort.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        menukort.remove(pizza);
    }

    public ArrayList MenukortShow() {

        ArrayList<Pizza> marioMenu = new ArrayList();

        marioMenu.add(new Pizza(1, "Vesuvio", "tomatsauce, ost, skinke og oregano", 57));
        marioMenu.add(new Pizza(2, "Amerikaner", "tomatsauce, ost, oksefars og oregano", 53));
        marioMenu.add(new Pizza(3, "Cacciatore", "tomatsauce, ost, pepperoni og oregano", 57));
        marioMenu.add(new Pizza(4, "Carbona", "tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano", 63));
        marioMenu.add(new Pizza(5, "Dennis", "tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano", 65));
        marioMenu.add(new Pizza(6, "Bertil", "tomatsauce, ost, bacon og oregano", 57));
        marioMenu.add(new Pizza(7, "Silvia", "tomatsauce, ost, pepperoni, rød peber, løg og oregano", 61));
        marioMenu.add(new Pizza(8, "Victoria", "tomatsauce, ost, skinke, ananas, champignon, løg og oregano", 61));
        marioMenu.add(new Pizza(9, "Toronfo", "tomatsauce, ost, skinke, bacon, kebab, chili og oregano", 61));
        marioMenu.add(new Pizza(10, "Capricciosa", "tomatsauce, ost, skinke, champignon og oregano", 61));
        marioMenu.add(new Pizza(11, "Hawaii", "tomatsauce, ost, skinke, ananas og oregano", 61));
        marioMenu.add(new Pizza(12, "Le Blissola", "tomatsauce, ost, skinke, rejer og oregano", 61));
        marioMenu.add(new Pizza(13, "Venezia", "tomatsauce, ost, skinke, bacon og oregano", 61));
        marioMenu.add(new Pizza(14, "Mafia", "tomatsauce, ost, pepperoni, bacon, løg og oregano", 61));
        marioMenu.add(new Pizza(15, "Danala", "tomatsauce, ost, kylling, bacon, løg og oregano", 61));
        marioMenu.add(new Pizza(16, "Mexicano", "tomatsauce, ost, kødsauce, chili, løg, majs og oregano", 65));
        marioMenu.add(new Pizza(17, "Harry Potter", "tomatsauce, ost, kylling, bearnaise, hvidløg og oregano", 70));
        marioMenu.add(new Pizza(18, "Terminator", "tomatsauce, ost, kylling, creme fraiche , hvidløg og oregano", 72));
        marioMenu.add(new Pizza(19, "Jackson", "tomatsauce, ost, kylling, oksekød, Paprika og oregano", 64));
        marioMenu.add(new Pizza(20, "Voldamort", "tomatsauce, ost, kylling, creme fraiche , hvidløg og chili", 66));
        marioMenu.add(new Pizza(21, "Løkke", "tomatsauce, ost, kylling, bearnaise, hvidløg og oregano", 69));
        marioMenu.add(new Pizza(22, "DC", "tomatsauce, ost, kylling, bearnaise, Kødsauce og oregano", 65));
        marioMenu.add(new Pizza(23, "Marvel", "tomatsauce, ost, kylling, bearnaise, hvidløg og creme fraiche ", 70));
        marioMenu.add(new Pizza(24, "Chicago", "tomatsauce, ost, kylling, bearnaise, hvidløg og Kødsauce", 70));
        marioMenu.add(new Pizza(25, "Bae", "tomatsauce, ost, kylling, bearnaise, creme fraiche  og oregano", 70));
        marioMenu.add(new Pizza(26, "Margrethe", "tomatsauce, ost, kylling, bacon, hvidløg og oregano", 70));
        marioMenu.add(new Pizza(27, "København", "tomatsauce, ost, kylling, bearnaise, hvidløg og ananas", 70));
        marioMenu.add(new Pizza(28, "Daniela", "tomatsauce, ost, kylling, bacon, løg, creme fraiche og oregano", 65));
        marioMenu.add(new Pizza(29, "SoHype", "tomatsauce, ost, kylling, ananas, hvidløg, oksekød og oregano", 70));
        marioMenu.add(new Pizza(30, "GitEmil", "tomatsauce, ost, kylling, bearnaise, hvidløg og oregano", 68));
        marioMenu.add(new Pizza(30, "Jimmay", "tomatsauce, ost, kylling, bearnaise, creme fraiche og oregano", 75));
        marioMenu.add(new Pizza(31, "Tullebob", "tomatsauce, ost, kylling, bearnaise, hvidløg og oregano", 80));

        return marioMenu;
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
