package mariospizzabar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Daniel, Emil
 */
public class Liste {

    static String filename = "Data/Mariosliste.csv";
    private String removeTerm = "";
    private ArrayList<Bestilling> bestillingsListe;
    private int count;

    public Liste(Bestilling bestilling) {
        this.bestillingsListe = ListeMaker(bestilling);
    }

    public void addBestilling(Bestilling bestilling) {
        bestillingsListe.add(bestilling);
    }

    // TODO: Når man fjerner en bestilling fra listen, skal den gemmes i
    // statistik-klassen.
    public void removeBestilling(Bestilling bestilling) {
        bestillingsListe.remove(bestilling);
    }

    public ArrayList ListeMaker(Bestilling bestilling) {
        ArrayList<Bestilling> marioListe = new ArrayList();

        marioListe.add(bestilling);

        return marioListe;
    }

    public static void WriteFile(Liste liste, String filename, String filename2, int count) throws IOException {
        File file = new File(filename);
        File file2 = new File(filename2);
        FileWriter fw = new FileWriter(file, true);
        FileWriter fw2 = new FileWriter(file2, true);
        fw.write(count + ";" + liste.toString());
        fw2.write("-" + count + ";" + liste.toString());
        count++;
        fw.close();
        fw2.close();
    }

    public static void ReadFile(String filename) throws FileNotFoundException, IOException {
        
        File file = new File(filename);
        
        FileReader fr = new FileReader(filename);
        Scanner in = new Scanner(file);
        
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
        }
        
        in.close();
    }
    public static void EditFile (String filename){
        File file = new File(filename);
        
        
        
    }

    @Override
    public String toString() {
        return bestillingsListe + "\n";
    }

}
