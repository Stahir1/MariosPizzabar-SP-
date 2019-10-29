package mariospizzabar;

// @author Emil
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MariosPizzaBarMain {

    public static void main(String[] args) throws IOException {
        Menukort marioMenukort = new Menukort();
        boolean runProg = true;
        int count = 1;

        System.out.println("Velkommen til Marios Pizzabar.");
        // runProg loopet håndtere afslutningen af programmet. 
        // Vi har en runProg boolean som er true som bliver ved med at køre programmet
        // indtil at runProg bliver false, hvorefter programmet lukkes. 
        while (runProg) { 
            System.out.println("Tast 1 for at se menukortet.");
            System.out.println("Tast 2 for at oprette en bestilling.");
            System.out.println("Tast 3 for at se bestillingslisten.");
            System.out.println("Tast 4 for at se omsætningen.");
            System.out.println("Tast 5 for at lukke programmet.");

            int number = IntScanner();
            String tidspunkt = "";
            
            /******************************************************************* 
            * I menuen er der mulighed for at indtaste forskellige numre 
            * som input og hvert nummer har en handling kodet. 
            *******************************************************************/ 

            if (number == 1) {
                System.out.println("\n" + marioMenukort.toString());

            } else if (number == 2) {
                System.out.println("\nLav en bestilling. \nIndtast Pizzanummer: ");
                number = IntScanner();
                System.out.println("Indtast afhentingstidspunkt: ");
                tidspunkt = StringScanner();
                System.out.println("\nBestilling gennemført:");
                Pizza tempPizza = marioMenukort.getPizzaByID(number);
                Bestilling bestilling = new Bestilling(number, tempPizza, tidspunkt);
                Liste marioListe = new Liste(bestilling);
                System.out.println(bestilling + "\n");
                marioListe.listeMaker(bestilling);
                Liste.writeFile(marioListe, "Data/Mariosliste.csv", count++);
                marioListe.removeBestilling(bestilling);
            } else if (number == 3) {
                Liste.readFile("Data/Mariosliste.csv");
                System.out.println("Vil du fjerne en bestilling og markere den som ekspederet? (1 = JA, 2 = NEJ)");
                number = IntScanner();
                if (number == 1) {
                    System.out.println("Hvilken bestilling vil du fjerne? (\"-n\")");
                    String textIn = StringScanner();
                    Liste.editFile2("Data/Mariosliste.csv", textIn, 1, ";");
                } else if (number == 2) {

                }

            } else if (number == 4) {
                //Liste.readFile("Data/MariosEkspederet.csv"); // Mulighed for at læse MariosEkspederet.csv i programmet, hvis ønskes.
                Liste.fileToEksp("Data/MariosEkspederet.csv");
            } else if (number == 5) {
                runProg = false;
            }

            System.out.println("Vil du lukke programmet? (1 = JA, 2 = NEJ)");
            number = IntScanner();
            if (number == 1) {
                runProg = false;
            } else if (number == 2) {
                runProg = true;
            }

        }

    }

    // Vi har to forskellige scannere. Én til Int som eksempelvis bruges til at nagivere rundt i menuen.
    // Og én til String som bl.a. bruges til afhentningstidspunkt. 
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
