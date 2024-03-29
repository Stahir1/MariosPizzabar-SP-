package mariospizzabar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Sohaib, Jimmy, Daniel & Emil.
 */
public class Liste {

    static String filename = "Data/Mariosliste.csv";
    private ArrayList<Bestilling> bestillingsListe;
    private int count;
    private static Scanner x;

    public Liste(Bestilling bestilling) {
        this.bestillingsListe = listeMaker(bestilling);
    }

    public void addBestilling(Bestilling bestilling) {
        bestillingsListe.add(bestilling);
    }

    public void removeBestilling(Bestilling bestilling) {
        bestillingsListe.remove(bestilling);
    }

    public ArrayList listeMaker(Bestilling bestilling) {
        ArrayList<Bestilling> marioListe = new ArrayList();

        marioListe.add(bestilling);

        return marioListe;
    }

    public static void writeFile(Liste liste, String filename, int count) throws IOException {
        File file = new File(filename);
        FileWriter fw = new FileWriter(file, true);
        // Minus-tegnet bruges til at fjerne en bestilling fra Mariosliste.csv.
        // Dette giver også mening ift. brugeren - at man skriver "-" for at fjerne en bestilling.  
        fw.write("-" + count + ";" + liste.toString());

        count++;
        fw.close();

    }

    // Metoden bruges til at læse og printe Mariolistens indhold i programmet.
    public static void readFile(String filename) throws FileNotFoundException, IOException {

        File file = new File(filename);

        FileReader fr = new FileReader(filename);
        Scanner in = new Scanner(file);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
        }

        in.close();
        fr.close();
    }

    // Inspiration til kode fra: https://www.youtube.com/watch?v=NceIYifVAQQ
    // Metoden fjerner en bestilling fra Mariosliste.csv og tilføjer den fjernede bestilling til MariosEkspederet.csv
    public static void editFile2(String filename, String removeTerm, int positionOfTerm, String delimiter) {
        int position = positionOfTerm - 1;
        String tempFile = "Data/temp.txt";
        File oldFile = new File(filename);
        File newFile = new File(tempFile);
        String tempFile2 = "Data/MariosEkspederet.csv";
        File ekspFile = new File(tempFile2);

        String currentLine;
        String data[];
        String currentLine2;
        String data2[];

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            FileWriter fw2 = new FileWriter(tempFile2, true);

            BufferedWriter bw = new BufferedWriter(fw);
            BufferedWriter bw2 = new BufferedWriter(fw2);

            PrintWriter pw = new PrintWriter(bw);
            PrintWriter pw2 = new PrintWriter(bw2);

            FileReader fr = new FileReader(filename);
            FileReader fr2 = new FileReader(filename);

            BufferedReader br = new BufferedReader(fr);
            BufferedReader br2 = new BufferedReader(fr2);

            // Dette bruges til at indsætte alt undtagen brugerens indtastning.
            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(";");
                if (!(data[position].equalsIgnoreCase(removeTerm))) {
                    pw.println(currentLine);
                }
            }

            // Dette bruges til at indsætte netop brugerens indtastning. 
            while ((currentLine2 = br2.readLine()) != null) {
                data2 = currentLine2.split(";");
                if ((data2[position].equalsIgnoreCase(removeTerm))) {
                    pw2.println(currentLine2);
                }
            }

            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            pw2.close();
            fw2.close();
            bw2.close();
            fr2.close();
            br2.close();

            // Original-filen slettes og den nye fil omdøbbes til original-filens navn.
            // På denne måde erstattes original-filen.
            if (oldFile.delete()) {
                File dump = new File(filename);
                newFile.renameTo(dump);
                System.out.println("Bestilling ekspederet og fjernet.");
            } else {
                System.out.println("Bestilling kunne IKKE fjernes.");
            }

        } catch (Exception e) {
            System.out.println("Pizza ikke på listen.");
        }
    }

    // Metoden isolerer priserne i Mariosekspederet.csv, laver dem herefter om til Integers og lægger dem sammen.
    public static void fileToEksp(String filename) throws IOException {
        File file = new File(filename);
        Scanner myScan = new Scanner(file);
        String line = "";
        int sum = 0;

        while (myScan.hasNextLine()) {
            line = myScan.nextLine();
            // Der splittes i forhold til følgende layout: -2;[Pizzanavn: ;Amerikaner; Pris: ;53; kr., Afhentingstidspunkt: 15:16]
            String[] lineArr = line.split(";");
            sum += Integer.parseInt(lineArr[4]);
        }

        System.out.println("Din omsætning er: " + sum + " kr.");

    }

    @Override
    public String toString() {
        return bestillingsListe + "\n";
    }

}
