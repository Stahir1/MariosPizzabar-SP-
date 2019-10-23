
package mariospizzabar;

// @author jimmy
public class Pizza {
    private String ID;
    private String topping;
    private int price;

    public Pizza(String ID, String topping, int price) {
        this.ID = ID;
        this.topping = topping;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
        return ID + ": " + topping + " - " + price + " kr.";
    }
}
