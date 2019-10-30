package mariospizzabar;

import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sohaib, Jimmy, Daniel & Emil.
 */
public class ListeTest {

    public ListeTest() {
    }

    Pizza pizzaTest = new Pizza(5, "Test", "tomat, ost, tun", 60);

    Bestilling bestTest = new Bestilling(1, pizzaTest, "15:54");

    Liste listeTest = new Liste(bestTest);

    /**
     * Her testes addBestilling() metoden.
     * Her kan man tilføje en bestilling til sin liste.
     */
    @Test
    public void testAddBestilling() {
        System.out.println("addBestilling");
        Bestilling bestilling = bestTest;
        Liste instance = listeTest;
        instance.addBestilling(bestilling);
    }

    /**
     * Her testes removeBestilling() metoden.
     * Her kan man fjerne en bestilling fra sin liste.
     */
    @Test
    public void testRemoveBestilling() {
        System.out.println("removeBestilling");
        Bestilling bestilling = bestTest;
        Liste instance = listeTest;
        instance.removeBestilling(bestilling);
    }

    /**
     * Her testes writeFile() metoden.
     * Alt der tilføjes til ens bestilling vil blive skrevet i Mariosliste.csv.
     * Da vi kun arbejder med en bestilling, og der maks kan være en bestilling,
     * når en bestilling oprettes, tilføjes der en ny linje pr. bestilling.
     * På denne måde går bestillingen ikke tabt, da den er gemt i csv-filen.
     */
    @Test
    public void testWriteFile() throws Exception {
        System.out.println("writeFile");
        Liste liste = listeTest;
        String filename = "Data/testWriteFile.txt";
        int count = 0;
        Liste.writeFile(liste, filename, count);
        // TODO review the generated test code an
    }

    /**
     * Her testes readFile() metoden.
     * Her printes Mariosliste.csv til programmet, så Mario kan se bestillingslisten.
     * Så behøver han ikke åbne selve filen, men behøver blot taste 3 i hovedmenuen
     * for at se bestillingerne.
     */
    @Test
    public void testReadFile() throws Exception {
        System.out.println("readFile");
        String filename = "Data/testReadFile.txt";
        Liste.readFile(filename);
    }

    /**
     * Her testes filetoEksp() metoden.
     * Når en bestilling er blevet fjernet fra Mariosliste.csv og tilføjet til
     * MariosEkspederet.csv, isolerer denne metoden prisen, laver den om til 
     * en integer og ligger priserne sammen og viser omsætningen.
     */
    @Test
    public void testFileToEksp() throws Exception {
        System.out.println("fileToEksp");
        String filename = "Data/testFileToEksp.txt";
        Liste.fileToEksp(filename);
    }
}
