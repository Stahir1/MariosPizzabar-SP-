package mariospizzabar;

import java.util.ArrayList;
import static mariospizzabar.Menukort.MenukortMaker;

/**
 *
 * @author Daniel
 */
public class Liste {
    private ArrayList<Bestilling> bestillingsListe;
    
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

    @Override
    public String toString() {
        return bestillingsListe + "\n";
    }
    
    
    

    
    
}
