package mariospizzabar;

// @author jimmy
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

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ID + ". " + navn + ": " + topping + " - " + price + " kr.";
    }
}
