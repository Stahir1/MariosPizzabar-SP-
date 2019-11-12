package mariospizzabar;

// @author Sohaib, Jimmy, Daniel & Emil.
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import mariospizzabar.Menukort;
import mariospizzabar.Util.DBConnector;

public class MariosPizzaBarMain {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        
        
        Menukort marioMenukort = new Menukort();
        boolean runProg = true;
        boolean bestGo = true;
        int count = 1;
        int choice = 0;
         HashMap<Integer, ArrayList<Pizza>> PizzaMap = new HashMap<Integer, ArrayList<Pizza>>();
        /// load previous orders
        LoadOrdersFromDB(PizzaMap, marioMenukort);

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
            int OrderID = PizzaMap.size() + 1;
            
            PizzaMap.clear();
            
            switch (number) {
                case 1:
                    Menukort.getPizzaFromDB();
                    break;
                case 2:
                    bestGo = true;
                    while(bestGo) {
                        BestilProces(number, tidspunkt, marioMenukort, PizzaMap, OrderID);
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
                    Liste.readFile("Data/Mariosliste.csv");
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

    
    public static void BestilProces(int number, String tidspunkt, Menukort marioMenukort, HashMap<Integer, ArrayList<Pizza>> PizzaMap, int OrderID) throws ClassNotFoundException, SQLException, IOException {
        ArrayList<Pizza> marioBestilling = new ArrayList();
        boolean bestGo = true;
        int count = 1;
        System.out.println("\nLav en bestilling. \nIndtast Pizzanummer: ");
        number = IntScanner();
        System.out.println("Indtast afhentingstidspunkt (Eks. \"10:30\"): ");
        tidspunkt = StringScanner();
        System.out.println("\nBestilling gennemført:");
        Pizza tempPizza = marioMenukort.getPizzaByID(number);
        marioBestilling.add(tempPizza);
        Bestilling bestilling = new Bestilling(number, tidspunkt, marioBestilling);
        Liste marioListe = new Liste(bestilling);
        bestilling.getPizzaer();
        System.out.println(bestilling + "\n");
            marioListe.listeMaker(bestilling);
      //      Liste.writeFile(marioListe, "Data/Mariosliste.csv", count++);
      
            if(!PizzaMap.containsKey(OrderID))
            {
                PizzaMap.put(OrderID, new ArrayList<Pizza>());
                PizzaMap.get(OrderID).add(tempPizza);
            }
            else
                PizzaMap.get(OrderID).add(tempPizza);
      
        Liste.addPizzaToDB(marioBestilling, bestilling, PizzaMap);
            marioListe.removeBestilling(bestilling);
        System.out.println("Klik på \"1\" for at afslutte bestilling.");
        System.out.println("Klik på et andet tal for at fortsætte.");
        
    }
    
    public static void LoadOrdersFromDB(HashMap<Integer, ArrayList<Pizza>> PizzaMap, Menukort marioMenukort) throws ClassNotFoundException, SQLException
    {
        String query = "SELECT OrderID, PizzaName, Price, PizzaNumber, PickupTime FROM mariopizza.orders ORDER by OrderID, ordering";
          
        Connection myConnector = DBConnector.getConnector();
        Statement stmt = myConnector.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        
        if(resultSet == null)
        {
            myConnector.close();
            return;
        }
        
        while (resultSet.next())
        {
            int OrderID = resultSet.getInt(1);
            //String PizzaName = resultSet.getString(2);
            //int Price = resultSet.getInt(3);
            int PizzaNumber = resultSet.getInt(4);
            //String PickupTime = resultSet.getString(5);
            
            if(!PizzaMap.containsKey(OrderID))
            {
                PizzaMap.put(OrderID, new ArrayList<Pizza>());
                PizzaMap.get(OrderID).add(marioMenukort.getPizzaByID(PizzaNumber));
            }
            else
                PizzaMap.get(OrderID).add(marioMenukort.getPizzaByID(PizzaNumber));
            
            
        }
        
        myConnector.close();
    }
            
            
}
