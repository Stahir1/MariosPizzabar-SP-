package mariospizzabar;

import java.util.ArrayList;

 // @author Sohaib 
 
public class Bestilling {
          private int ordreID;
          private String bestillingsTidspunkt;
          private Pizza pizza;
          
    public Bestilling(int ordreID, Pizza pizza, String bestillingsTidspunkt) {
        this.ordreID = ordreID;
        this.bestillingsTidspunkt = bestillingsTidspunkt;
        this.pizza = pizza;
    }
    

    public int getOrdreID() {
        return ordreID;
    }

    public void setOrdreID(int ordreID) {
        this.ordreID = ordreID;
    }

    public String getBestillingsTidspunkt() {
        return bestillingsTidspunkt;
    }

    public void setBestillingsTidspunkt(String bestillingsTidspunkt) {
        this.bestillingsTidspunkt = bestillingsTidspunkt;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
    
    
    @Override
    public String toString() {
        return "Pizzanavn: ;" + pizza.getNavn() + "; Pris: ;" + pizza.getPrice() + "; kr., Afhentingstidspunkt: " + bestillingsTidspunkt;
    }
    
    
}
   
    


