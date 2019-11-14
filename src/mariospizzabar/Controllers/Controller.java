package mariospizzabar.Controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import mariospizzabar.Bestilling;
import mariospizzabar.Liste;
import mariospizzabar.Menukort;
import mariospizzabar.Pizza;
import mariospizzabar.Util.DBConnector;
import mariospizzabar.View.MainMenuView;

public class Controller {

    public static void runProg() {

        Menukort marioMenukort = new Menukort();
        boolean runProg = true;
        boolean bestGo = true;
        int count = 1;
        int choice = 0;

        System.out.println("Velkommen til Marios Pizzabar.");

        // runProg loopet håndtere afslutningen af programmet. 
        // Vi har en runProg boolean som er true som bliver ved med at køre programmet
        // indtil at runProg bliver false, hvorefter programmet lukkes. 
        while (runProg) {
            try {
                MainMenuView.showMainMenu();
                int number = IntScanner();
                String tidspunkt = "";

                /**
                 * *****************************************************************
                 * I menuen er der mulighed for at indtaste forskellige numre
                 * som input og hvert nummer har en handling kodet.
                 * *****************************************************************
                 */
                switch (number) {
                    case 1:
                        Menukort.getPizzaFromDB();
                        break;
                    case 2: {
                        BestilProces(tidspunkt, marioMenukort);
                    }
                    break;
                    case 3:
                        Bestilling.getBestillingFromDB();
                        System.out.println("Vil du fjerne en bestilling og markere den som ekspederet? (1 = JA, 2 = NEJ)");
                        number = IntScanner();
                        if (number == 1) {
                            System.out.println("Hvilken bestilling vil du fjerne? (\"n\")");
                            number = IntScanner();
                            FjernProces(number);

                        } else if (number == 2) {
                        } else {
                            System.out.println("Du har hverken tastet \"1\" eller \"2\".");
                        }
                        break;
                    case 4:
                        System.out.println("\nØnsker du at se statistikken? (1 = JA, 2 = NEJ)");
                        number = IntScanner();
                        if (number == 1) {
                            Liste.pizzaStatistics();
                        } else if (number == 2) {
                        } else {
                            System.out.println("Du har hverken tastet \"1\" eller \"2\".");
                        }
                        break;
                    case 5: {
                        runProg = false;
                    }

                    System.out.println("Programmet lukkes...");
                    break;

                }

            } catch (InputMismatchException e) {
                System.out.println("Du har ikke tastet et tal.");
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

    
    // Denne metode bliver kaldt i switch-casen i runProg(). 
    // Her laves der et nyt array, hvor man kan smide, så mange pizzaer man har lyst til ind.
    // Man går ud af pizzaloopet ved at taste "-1".
    // Hvis man taster forkert tidspunkt, bliver man bedt om at taste igen.
    public static void BestilProces(String tidspunkt, Menukort marioMenukort) {
        try {
            ArrayList<Pizza> marioBestilling = new ArrayList();
            int number = 0;
            boolean bestGo = true;
            int count = 1;
            System.out.println("\nLav en bestilling. \nIndtast Pizzanummer: ");

            int orderId = 0;

            String query = "SELECT MAX(orderid) FROM activeorders;";

            Connection myConnector = DBConnector.getConnector();
            Statement stmt = myConnector.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet == null) // hvis querien (åbenbart) ikke kan finde orderid,
            // sætter vi default orderID til 1 og lukker forbindelsen.
            {
                myConnector.close();
                orderId = 1;
            } else {
                if (resultSet.next()) // Dette undgår at programmet crasher når nedenstående resultSet.getInt bliver kaldt.
                {
                    orderId = resultSet.getInt(1) + 1; // benytter vores MAX query
                }                 // som er angivet i String query og tilføj +1 til den nye ordre.
                // sat til 1 da indexet starter ved 1 og ikke 0.
            }

            myConnector.close();

            while (number != -1) {
                number = IntScanner();
                Pizza tempPizza = marioMenukort.getPizzaByID(number);

                if (tempPizza != null) {
                    marioBestilling.add(tempPizza);
                }
                System.out.println("Tast \"-1\" når du er færdig med bestillingen.");
                System.out.println("Indtast Pizzanummer: ");
            }
            while (bestGo) {
                System.out.println("Indtast afhentingstidspunkt (Eks. \"10:30\"): ");
                tidspunkt = StringScanner();
                if (tidspunkt.contains(":")) {
                    System.out.println("\nBestilling gennemført:");
                    Bestilling bestilling = new Bestilling(number, tidspunkt, marioBestilling);
                    Liste marioListe = new Liste(bestilling);

                    bestilling.getPizzaer();
                    System.out.println(bestilling.toString() + "\n");
                    marioListe.listeMaker(bestilling);
                    Liste.addPizzaToDB(marioBestilling, bestilling, orderId);
                    System.out.println("Klik på \"1\" for at afslutte bestilling.");
                    System.out.println("Klik på et andet tal for at fortsætte.");
                    bestGo = false;
                } else {
                    System.out.println("Du har ikke indtastet tidspunktet korrekt.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Kunne ikke kommunikere med databasen.");;
        }

    }

    public static void FjernProces(int number) {
        Liste.removePizzaFromDB(number);
    }
}
