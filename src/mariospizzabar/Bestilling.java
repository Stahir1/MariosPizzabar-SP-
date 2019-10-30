package mariospizzabar;

import java.util.ArrayList;

// @author Sohaib, Jimmy, Daniel & Emil.
public class Bestilling {

    /**
     * ************************************************************************
     * Vores bestillingsklasse kan kun have én pizza pr. bestilling. Dette
     * skyldes, at vi ikke har lavet en addPizzaToOrder-metode. Men da hver
     * pizza bliver printet og tilføjet til Mariosliste.csv vil pizzaerne blive
     * gemt der.
     *
     * Minusset her er, at man ikke kan bestille f.eks. 3 pizzaer på en gang og
     * få den skrevet ind under samme bestillings ID. Men det var heller ikke et
     * krav i kravspecifikationen.
     *************************************************************************
     */
    
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
