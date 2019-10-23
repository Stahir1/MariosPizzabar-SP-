package mariospizzabar;


 // @author Sohaib 
 
public class Bestillinger {
          private int ordreID;
          private String bestillingsTidspunkt;

    public Bestillinger(int ordreID, String bestillingsTidspunkt) {
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
        return "Bestilling gennemført. \nPizzanummer: " + ordreID + ", Bestilt klokken: " + bestillingsTidspunkt;
    }
    
    
}
   
    


