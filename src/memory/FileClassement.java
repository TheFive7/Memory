package memory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileClassement {
    private final List<Double> lSecondes = new ArrayList<>();
    private final List<Integer> lCoups = new ArrayList<>();
    private final List<Integer> lPartieId = new ArrayList<>();

    private final List<Double> lClassement33 = new ArrayList<>();
    private final List<Double> lClassement44 = new ArrayList<>();
    private final List<Double> lClassement55 = new ArrayList<>();

    public FileClassement(String s) {
        try {
            FileWriter f = new FileWriter("classement.txt",true);
            f.write(s+"\n");
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileClassement(){
        double minTemps;

        try {
            // Choix du fichier + init Scanner
            FileInputStream file = new FileInputStream("classement.txt");
            Scanner input = new Scanner(file);

            int tailleBase = lireFichier(input);

            // Classement décroissant
            int place = 0;

            for (int i = 0; i < tailleBase; i++) {
                minTemps = 0;
                for (int s = 0; s < lSecondes.size(); s++) {
                    if (lSecondes.get(s) > minTemps) {
                        minTemps = lSecondes.get(s);
                        place = s;
                    }
                }

                // Ajout et remove (selon le type de partie)
                switch (lPartieId.get(place)) {
                    case 3 -> {
                        lClassement33.add(lSecondes.get(place));
                        lClassement33.add((double) lCoups.get(place));
                    }
                    case 4 -> {
                        lClassement44.add(lSecondes.get(place));
                        lClassement44.add((double) lCoups.get(place));
                    }
                    case 5 -> {
                        lClassement55.add(lSecondes.get(place));
                        lClassement55.add((double) lCoups.get(place));
                    }
                }
                lSecondes.remove(place);
                lCoups.remove(place);
                lPartieId.remove(place);
            }

            // Liste des classements
            List<String> lClassement = new ArrayList<>();
            ajoutString(lClassement,lClassement33);
            ajoutString(lClassement,lClassement44);
            ajoutString(lClassement,lClassement55);

            attribute();

            input.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Lit classement.txt et ajoute toutes les données dans des listes.
     * @param input : Le Scanner
     * @return : Le nombre de lignes lues.
     */
    public int lireFichier(Scanner input){
        String SEPARATEUR = ",";
        String ligne;
        int tailleBase;

        // Traiter tout le fichier
        while(input.hasNextLine()){
            ligne = input.nextLine();
            String[] mots = ligne.split(SEPARATEUR);
            lSecondes.add(Double.parseDouble(mots[0]));
            lCoups.add(Integer.parseInt(mots[1]));
            lPartieId.add(Integer.parseInt(mots[2]));
        }
        tailleBase = lSecondes.size();
        return tailleBase;
    }

    /**
     * Ajoute des String de l2 dans la liste de String l1.
     * @param l1 : Liste de String.
     * @param l2 : Liste de Double.
     */
    public void ajoutString(List<String> l1,List<Double> l2){
        for (int i=1;i<6;i+=2){
            l1.add(l2.get(l2.size()-(i+1)) + "s. en " + l2.get(l2.size()-i).intValue() + " coups");
        }
    }

    /**
     * Vérification de la taille des liste + attribution.
     */
    public void attribute(){
        String not = "Pas assez de données.";
        if (lClassement44.size()>=6){
            ClassementMenu.s144 = lClassement44.get(lClassement44.size()-2) + "s. en " + lClassement44.get(lClassement44.size()-1).intValue() + " coups";
            ClassementMenu.s244 = lClassement44.get(lClassement44.size()-4) + "s. en " + lClassement44.get(lClassement44.size()-3).intValue() + " coups";
            ClassementMenu.s344 = lClassement44.get(lClassement44.size()-6) + "s. en " + lClassement44.get(lClassement44.size()-5).intValue() + " coups";
        } else {
            ClassementMenu.s144 = not;
            ClassementMenu.s244 = not;
            ClassementMenu.s344 = not;
        }

        if (lClassement33.size()>=6){
            ClassementMenu.s133 = lClassement33.get(lClassement33.size()-2) + "s. en " + lClassement33.get(lClassement33.size()-1).intValue() + " coups";
            ClassementMenu.s233 = lClassement33.get(lClassement33.size()-4) + "s. en " + lClassement33.get(lClassement33.size()-3).intValue() + " coups";
            ClassementMenu.s333 = lClassement33.get(lClassement33.size()-6) + "s. en " + lClassement33.get(lClassement33.size()-5).intValue() + " coups";
        } else {
            ClassementMenu.s133 = not;
            ClassementMenu.s233 = not;
            ClassementMenu.s333 = not;
        }

        if (lClassement55.size()>=6){
            ClassementMenu.s155 = lClassement55.get(lClassement55.size()-2) + "s. en " + lClassement55.get(lClassement55.size()-1).intValue() + " coups";
            ClassementMenu.s255 = lClassement55.get(lClassement55.size()-4) + "s. en " + lClassement55.get(lClassement55.size()-3).intValue() + " coups";
            ClassementMenu.s355 = lClassement55.get(lClassement55.size()-6) + "s. en " + lClassement55.get(lClassement55.size()-5).intValue() + " coups";
        } else {
            ClassementMenu.s155 = not;
            ClassementMenu.s255 = not;
            ClassementMenu.s355 = not;
        }
    }
}
