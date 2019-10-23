
package mariospizzabar;

import java.util.ArrayList;

public class MariosPizzaBar {

    public static void main(String[] args) {
        Menukort marioMenukort = new Menukort();
        
        System.out.println(marioMenukort.toString());
        
        System.out.println(Menukort.getPizzaByID(4));
        
    }
    
}
