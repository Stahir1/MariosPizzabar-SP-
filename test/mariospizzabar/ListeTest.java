
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
     * Test of addBestilling method, of class Liste.
     */
    @Test
    public void testAddBestilling() {
        System.out.println("addBestilling");
        Bestilling bestilling = bestTest;
        Liste instance = listeTest;
        instance.addBestilling(bestilling);
    }

    /**
     * Test of removeBestilling method, of class Liste.
     */
    @Test
    public void testRemoveBestilling() {
        System.out.println("removeBestilling");
        Bestilling bestilling = bestTest;
        Liste instance = listeTest;
        instance.removeBestilling(bestilling);
    }


    /**
     * Test of writeFile method, of class Liste.
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
     * Test of readFile method, of class Liste.
     */
    @Test
    public void testReadFile() throws Exception {
        System.out.println("readFile");
        String filename = "Data/testReadFile.txt";
        Liste.readFile(filename);
    }
    
    
    
    /**
     * Test of fileToEksp method, of class Liste.
     */
    @Test
    public void testFileToEksp() throws Exception {
        System.out.println("fileToEksp");
        String filename = "Data/testFileToEksp.txt";
        Liste.fileToEksp(filename);
    }
    
    
    
    
    /*
    Scanner myScan = new Scanner(System.in);
    String removeTermIn = myScan.nextLine();


    @Test
    public void testEditFile2() {
        System.out.println("editFile2");
        String filename = "Data/testEditFile.txt";
        String removeTerm = removeTermIn;
        int positionOfTerm = 0;
        String delimiter = ";";
        Liste.editFile2(filename, removeTerm, positionOfTerm, delimiter);
    }
   
    */
    
    
    
    
    
  

    
    
}
