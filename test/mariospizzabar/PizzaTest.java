package mariospizzabar;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sohaib, Jimmy, Daniel & Emil.
 */
public class PizzaTest {

    Pizza pizzaTest = new Pizza(4, "Test", "tomat, ost, skinke", 60);

    
    /*
    * Her testes getNavn() metoden.
    * Her kan man få navnet tilbage fra en pizza.
    */
    @Test
    public void testGetNavn() {
        System.out.println("getNavn");
        Pizza instance = pizzaTest;
        String expResult = "Test";
        String result = instance.getNavn();
        assertEquals(expResult, result);

    }
    
    
    /*
    * Her testes getPrice() metoden.
    * Her kan man få pricen fra en pizza.
    */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Pizza instance = pizzaTest;
        int expResult = 60;
        int result = instance.getPrice();
        assertEquals(expResult, result);

    }

}
