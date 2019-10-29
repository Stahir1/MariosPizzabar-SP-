
package mariospizzabar;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class ListeTest {
    
    public ListeTest() {
    }
    

    /**
     * Test of addBestilling method, of class Liste.
     */
    @Test
    public void testAddBestilling() {
        System.out.println("addBestilling");
        Bestilling bestilling = null;
        Liste instance = null;
        instance.addBestilling(bestilling);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeBestilling method, of class Liste.
     */
    @Test
    public void testRemoveBestilling() {
        System.out.println("removeBestilling");
        Bestilling bestilling = null;
        Liste instance = null;
        instance.removeBestilling(bestilling);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listeMaker method, of class Liste.
     */
    @Test
    public void testListeMaker() {
        System.out.println("listeMaker");
        Bestilling bestilling = null;
        Liste instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.listeMaker(bestilling);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeFile method, of class Liste.
     */
    @Test
    public void testWriteFile() throws Exception {
        System.out.println("writeFile");
        Liste liste = null;
        String filename = "";
        String filename2 = "";
        int count = 0;
        Liste.writeFile(liste, filename, filename2, count);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFile method, of class Liste.
     */
    @Test
    public void testReadFile() throws Exception {
        System.out.println("readFile");
        String filename = "";
        Liste.readFile(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editFile2 method, of class Liste.
     */
    @Test
    public void testEditFile2() {
        System.out.println("editFile2");
        String filename = "";
        String removeTerm = "";
        int positionOfTerm = 0;
        String delimiter = "";
        Liste.editFile2(filename, removeTerm, positionOfTerm, delimiter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fileToEksp method, of class Liste.
     */
    @Test
    public void testFileToEksp() throws Exception {
        System.out.println("fileToEksp");
        String filename = "";
        Liste.fileToEksp(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
