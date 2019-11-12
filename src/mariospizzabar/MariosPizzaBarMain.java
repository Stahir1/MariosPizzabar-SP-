package mariospizzabar;

// @author Sohaib, Jimmy, Daniel & Emil.
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import mariospizzabar.Menukort;

public class MariosPizzaBarMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Menukort marioMenukort = new Menukort();
        boolean runProg = true;
        boolean bestGo = true;
        int count = 1;
        int choice = 0;

        System.out.println("Velkommen til Marios Pizzabar.");
        // runProg loopet håndtere afslutningen af programmet. 
        // Vi har en runProg boolean som er true som bliver ved med at køre programmet
        // indtil at runProg bliver false, hvorefter programmet lukkes. 
        
        while(runProg) {
            System.out.println("Tast 1 for at se menukortet.");
            System.out.println("Tast 2 for at oprette en bestilling.");
            System.out.println("Tast 3 for at se bestillingslisten.");
            System.out.println("Tast 4 for at se omsætningen.");
            System.out.println("Tast 5 for at lukke programmet.");
            int number = IntScanner();
            String tidspunkt = "";

            /**
             * *****************************************************************
             * I menuen er der mulighed for at indtaste forskellige numre som
             * input og hvert nummer har en handling kodet.
             * *****************************************************************
             */
            switch (number) {
                case 1:
                    Menukort.getPizzaFromDB();
                    break;
                case 2:
                    bestGo = true;
                    while(bestGo) {
                        BestilProces(tidspunkt,marioMenukort);
                        // Her bliver der spurgt om man vil oprette en ny bestilling eller ej.
                        // "1" for exit, alt andet for mere under samme bestilling.
                        number = IntScanner();
                        if(number == 1) {
                        bestGo = false;
                        } else {
                        }
                    }
                    break;
                case 3:
                    //Liste.readFile("Data/Mariosliste.csv");
                    Liste.readOrdersFromDB();
                    System.out.println("Vil du fjerne en bestilling og markere den som ekspederet? (1 = JA, 2 = NEJ)");
                    number = IntScanner();
                    if (number == 1) {
                        System.out.println("Hvilken bestilling vil du fjerne? (\"-n\")");
                        String textIn = StringScanner();
                        Liste.editFile2("Data/Mariosliste.csv", textIn, 1, ";");
                    } else if (number == 2) {
                    } else {
                        System.out.println("Du har hverken tastet \"1\" eller \"2\"");
                    }
                    break;
                case 4:
                    //Liste.readFile("Data/MariosEkspederet.csv"); // Mulighed for at læse MariosEkspederet.csv i programmet, hvis ønskes.
                    Liste.fileToEksp("Data/MariosEkspederet.csv");
                    System.out.println("\nVil du se listen over ekspederet ordre? (1 = JA, 2 = NEJ)");
                    number = IntScanner();
                    if (number == 1) {
                        Liste.readFile("Data/MariosEkspederet.csv");
                    } else if (number == 2) {

                    }
                    break;
                case 5: {
                    runProg = false;
                }

               /* System.out.println("Vil du lukke programmet? (1 = JA, 2 = NEJ)");
                number = IntScanner();
                if (number == 1) {
                    runProg = false;
                } else if (number == 2) {
                    runProg = true;
                }*/ 
                System.out.println("Programmet lukkes...");
                break;

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

    
    public static void BestilProces(String tidspunkt, Menukort marioMenukort) throws ClassNotFoundException, SQLException, IOException {
        ArrayList<Pizza> marioBestilling = new ArrayList();
        int number = 0;
        boolean bestGo = true;
        int count = 1;
        System.out.println("\nLav en bestilling. \nIndtast Pizzanummer: ");
        while(number != -1) {
            number = IntScanner();
            Pizza tempPizza = marioMenukort.getPizzaByID(number);
            marioBestilling.add(tempPizza);
            System.out.println("Tast \"-1\" når du er færdig med bestillingen.");
            System.out.println("Indtast Pizzanummer: ");
        }
        Bestilling bestilling = new Bestilling(number, tidspunkt, marioBestilling);
        Liste marioListe = new Liste(bestilling);
        System.out.println("Indtast afhentingstidspunkt (Eks. \"10:30\"): ");
        tidspunkt = StringScanner();
        System.out.println("\nBestilling gennemført:");
        
        bestilling.getPizzaer();
        System.out.println(bestilling + "\n");
            marioListe.listeMaker(bestilling);
      //      Liste.writeFile(marioListe, "Data/Mariosliste.csv", count++);
        Liste.addPizzaToDB(marioBestilling, bestilling);
        //    marioListe.removeBestilling(bestilling);
        System.out.println("Klik på \"1\" for at afslutte bestilling.");
        System.out.println("Klik på et andet tal for at fortsætte.");
        
    }
            
            
}
