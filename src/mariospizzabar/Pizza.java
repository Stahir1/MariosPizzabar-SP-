package mariospizzabar;

// @author Sohaib, Jimmy, Daniel & Emil.
public class Pizza {

    private int ID;
    private String navn;
    private String topping;
    private int price;

    public Pizza(int ID, String navn, String topping, int price) {
        this.ID = ID;
        this.navn = navn;
        this.topping = topping;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public String getNavn() {
        return navn;
    }

    public String getTopping() {
        return topping;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return ID + ". " + navn + ": " + topping + " - " + price + " kr.";
    }
}
