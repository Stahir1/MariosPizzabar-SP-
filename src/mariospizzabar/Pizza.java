
package mariospizzabar;

// @author jimmy
public class Pizza {
    private String ID;
    private String size;
    private String topping;
    private int price;

    public Pizza(String ID, String size, String topping, int price) {
        this.ID = ID;
        this.size = size;
        this.topping = topping;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
    
    
    
    
}
