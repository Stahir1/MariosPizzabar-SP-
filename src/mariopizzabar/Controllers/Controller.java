
package mariopizzabar.Controllers;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.SQLException;

import java.util.Scanner;
import mariospizzabar.Model.MainMenuList;
import pizzabar.view.MainRunMenu;
import pizzabar.view.PizzaUI;


public class Controller {
    

    public static void runProgram() throws ClassNotFoundException, SQLException {
        int choice = 0;
        int exitValue = 5;
        Scanner myScanner = new Scanner(System.in);
        MainMenuList myList = new MainMenuList();
        while (choice != exitValue) {
            MainRunMenu.showMainMenu();
            choice = myScanner.nextInt();
            switch(choice){
                case 1: 
                    PizzaUI.viewPizzaList(myList);
                    break;
                /*case 2:
                    System.out.println("Indtast ID på fil");
                    int movieID = myScanner.nextInt();
                    PizzaUI.viewMovieById(movieID);
                    break;
                default:
                        System.out.println("Exit");
                        choice = exitValue;
            */}
        }
    }
  
}
