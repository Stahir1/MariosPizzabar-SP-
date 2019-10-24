package mariospizzabar;

// @author Emil

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MariosPizzaBarMain {
    public static void main(String[] args) throws IOException {
        Menukort marioMenukort = new Menukort();
        boolean run = true;
        int count = 1;
        
        System.out.println("Velkommen til Marios Pizzabar.");
        while(run) {
            System.out.println("Tast 1 for at se menukortet.");
            System.out.println("Tast 2 for at oprette en bestilling.");
            System.out.println("Tast 3 for at lukke programmet.");
            // ToDo: Indtast 3 for se liste over bestillinger
            // ToDo: Indtast 4 for statistik
            // ToDo: Lav resten af indtastningerne (og find ud af hvilke)
            int number = IntScanner();
            String tidspunkt = "";
        
            if (number == 1) {
                System.out.println(marioMenukort.toString());
                // ToDo: Lav metode/klasse som kan starte programmet forfra, fra velkomstskærmen. 
                // Eg., så når man har set menu-kortet kan man bagefter indtaste pizzanr.
            } else if(number == 2) {
                System.out.println("Lav en bestilling. \nIndtast Pizzanummer: ");
                number = IntScanner();
                System.out.println("Indtast bestillingstidspunkt: ");
                tidspunkt = StringScanner();
                System.out.println("Bestilling gennemført:");
                Bestilling bestilling = new Bestilling(number, tidspunkt);
                Liste marioListe = new Liste(bestilling);
                System.out.println(bestilling);
                marioListe.ListeMaker(bestilling);
                System.out.println(marioListe.toString());
                Liste.WriteFile(marioListe, "Data/Mariosliste.csv", count++);
            } else if(number == 3) {
                run = false;
            }
            
            System.out.println("Vil du afslutte programmet? (1 = JA, 2 = NEJ)");
            number = IntScanner();
            if(number == 1) {
                run = false;
            } else if(number == 2) {
                run = true;
            }
            
        }
        




// ToDo: Brug getPizzaById ud fra bestillinger-klassen til statistik delen.
// System.out.println(Menukort.getPizzaByID(4));
        
    }
    
    public static int IntScanner() {
        Scanner myScan = new Scanner(System.in);
	int number = myScan.nextInt();
        
        return number;
    }
    
    public static String StringScanner() {
        Scanner myScan = new Scanner(System.in);
	String bogstaver = myScan.nextLine();
        
        return bogstaver;
    }
    
}
