package mariospizzabar;

 // @author Sohaib 
 
public class Bestilling {
          private int ordreID;
          private String bestillingsTidspunkt;
          private Object pizza;

    public Bestilling(int ordreID, Object pizza, String bestillingsTidspunkt) {
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

    public Object getPizza() {
        return pizza;
    }

    public void setPizza(Object pizza) {
        this.pizza = pizza;
    }
    
    


    @Override
    public String toString() {
        return "Pizza: " + pizza + ", Bestilt klokken: " + bestillingsTidspunkt;
    }
    
    
}
   
    


