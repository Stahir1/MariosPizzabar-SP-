package mariospizzabar;

 // @author Sohaib 
 
public class Bestilling {
          private int ordreID;
          private String bestillingsTidspunkt;

    public Bestilling(int ordreID, String bestillingsTidspunkt) {
        this.ordreID = ordreID;
        this.bestillingsTidspunkt = bestillingsTidspunkt;
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

    @Override
    public String toString() {
        return "Pizzanummer: " + ordreID + ", Bestilt klokken: " + bestillingsTidspunkt;
    }
    
    
}
   
    


