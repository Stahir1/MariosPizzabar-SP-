
package mariospizzabar;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sohaib, Jimmy, Daniel & Emil.
 */
public class BestillingTest {
    
    public BestillingTest() {
    }
    
    Pizza pizzaTest = new Pizza(7, "Test", "tomat, ost, skinke", 60);
    
    Bestilling bestTest = new Bestilling(1, pizzaTest, "14:54");
    
    /**************************************************************************
     * Vores bestillingsklasse kan kun have én pizza pr. bestilling.
     * Dette skyldes, at vi ikke har lavet en addPizzaToOrder-metode.
     * Men da hver pizza bliver printet og tilføjet til Mariosliste.csv
     * vil pizzaerne blive gemt der.
     * 
     * Minusset her er, at man ikke kan bestille f.eks. 3 pizzaer på en gang
     * og få den skrevet ind under samme bestillings ID. Men det var heller
     * ikke et krav i kravspecifikationen.
     **************************************************************************/
    
    
    /**
     * Test of getOrdreID method, of class Bestilling.
     */
    @Test
    public void testGetOrdreID() {
        System.out.println("getOrdreID");
        Bestilling instance = bestTest;
        int expResult = 1;
        int result = instance.getOrdreID();
        assertEquals(expResult, result);
    }


    /**
     * Test of getBestillingsTidspunkt method, of class Bestilling.
     */
    @Test
    public void testGetBestillingsTidspunkt() {
        System.out.println("getBestillingsTidspunkt");
        Bestilling instance = bestTest;
        String expResult = "14:54";
        String result = instance.getBestillingsTidspunkt();
        assertEquals(expResult, result);
    }

  

    /**
     * Test of getPizza method, of class Bestilling.
     */
    @Test
    public void testGetPizza() {
        System.out.println("getPizza");
        Bestilling instance = bestTest;
        Pizza expResult = pizzaTest;
        Pizza result = instance.getPizza();
        assertEquals(expResult, result);
    }

    
}
