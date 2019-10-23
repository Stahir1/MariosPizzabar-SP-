



package mariospizzabar;


 // @author Sohaib 
 
public class Bestillinger {
          private int ordreID;
          private String bestillingsTidspunkt;
          private Pizza pizza;

    public Bestillinger(int ordreID, String bestillingsTidspunkt, Pizza pizza) {
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
          
          
          
          
    
    }
   
    


