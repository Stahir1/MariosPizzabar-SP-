package mariospizzabar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Daniel
 */
public class Liste {
    static String filename = "Data/Mariosliste.csv";
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
    
    public ArrayList ListeMaker(Bestilling bestilling){
        ArrayList<Bestilling> marioListe = new ArrayList();
        
        marioListe.add(bestilling);
        
        return marioListe;
    }
    
    // Skal også overføre til statistik csv-filen, men man skal kune kunne 
    // fjerne fra Mariosliste.csv.
    public static void WriteFile(Liste liste, String filename, int count) throws IOException{
        File file = new File(filename );
        FileWriter fw = new FileWriter(file, true);
	fw.write(count + ";" + liste.toString());
        count++;
        fw.close();
    }

    @Override
    public String toString() {
        return bestillingsListe + "\n";
    }
    
    
    

    
    
}
