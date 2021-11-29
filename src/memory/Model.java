package memory;

import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static memory.ControlMenu.nbLIGNE;

public class Model {
    int nbVie = nbLIGNE * 2 ;
    int score = 0;
    int clickAvantFin = 0;
    int click = 0;
    int compteurCartes = 0;
    int objectif = 14;

    ImageIcon iconeBase;
    Carte selectedCarte;
    Carte carte1,carte2,carte3;
    Carte[][] deckJeu;
    String[] deckDepart;


    /**
     * Mélange les cartes du deck de départ.
     */
    protected void melange() {
        Random random = new Random();
        for (int i = 0; i < deckDepart.length; i++) {
            int a = random.nextInt(deckDepart.length);
            String temp = deckDepart[i];
            deckDepart[i] = deckDepart[a];
            deckDepart[a] = temp;
        }
    }

    /**
     * Pose les cartes sur le plateau et les mets dans le deck de jeu.
     */
    protected void poseCarte(Plateau plateau,ControlButton controlButton){
        int compteur = 0;
        for (int ligne = 0; ligne < deckJeu.length; ligne++) {
            for (int colonne = 0; colonne < deckJeu[0].length; colonne++) {
                deckJeu[ligne][colonne] = new Carte(deckDepart[compteur]);
                plateau.add(deckJeu[ligne][colonne],compteur);
                deckJeu[ligne][colonne].addActionListener(controlButton);
                deckJeu[ligne][colonne].setIcon(iconeBase);
                compteur++;
            }
        }
    }

    /**
     * Montre la carte sélectionnée.
     */
    protected void montreCarte() {
        for (Carte[] value : deckJeu) {
            for (int colonne = 0; colonne < deckJeu[0].length; colonne++) {
                if (selectedCarte == value[colonne]) {
                    if (!value[colonne].getMatchCarte()) {
                        verifCarteSelected(value,colonne);
                    }
                }
            }
        }
    }

    /**
     * Vérifie la carte sélectionnée.
     * @param value : La carte à vérifier.
     * @param colonne : La position de la carte.
     */
    protected void verifCarteSelected(Carte [] value,int colonne){
        if (!value[colonne].getSelectCarte()) {
            afficheCarte(value[colonne]);
            value[colonne].setSelected(true);
            click++;
        }
    }

    /**
     * Processus qui remet la carte à son état original (retournée).
     */
    protected void cacheCarte() {
        if (click > 1 && click % 2 != 0) {
            carte1.setIcon(iconeBase);carte2.setIcon(iconeBase);
            carte1 = null;carte2 = null;
        }
    }

    /**
     * Processus qui montre l'image sur la carte.
     * @param carte : La carte sélectionnée.
     */
    protected static void afficheCarte(Carte carte) {
        try {
            String s = carte.getReturnCarte();
            ImageIcon icon;
            if (nbLIGNE != 5) {
                icon = new ImageIcon(new ImageIcon("src/img/" + s + ".png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
            } else {
                icon = new ImageIcon(new ImageIcon("src/imgCouleur/" + s + ".png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
            }
            carte.setIcon(icon);
        } catch (Exception ignored) {}
    }

    /**
     * Savoir si c'est la fin de la partie.
     * @return : Fin de la partie.
     */
    protected boolean isGameOver() {
        // Fin en fonction de la partie
        compteurCartes = 0;
        int nb = 1;
        if (nbLIGNE == 3) {
            objectif = 6;
            nb = 2;
        } else if (nbLIGNE == 5) {
            objectif = 22;
            nb = 2;
        } else {
            objectif = 14;
        }
        for (Carte[] c0 : deckJeu) {
            for (Carte c1 : c0) {
                if (c1.getMatchCarte()){
                    compteurCartes ++;
                }
            }
        }
        return ((compteurCartes == objectif) && (clickAvantFin == nb));
    }

    /**
     * Tourne la carte.
     */
    protected void tourneCarte() {
        // Cas depart
        if (carte1 == null && carte2 == null) {
            if (!selectedCarte.getMatchCarte()) {
                carte1 = selectedCarte;
                montreCarte();
            }
        }
        // Cas 1ere carte
        if (carte1 != null && carte1 != selectedCarte && carte2 == null) {
            if (!selectedCarte.getMatchCarte()) {
                carte2 = selectedCarte;
                montreCarte();
            }
        }
        // Cas 2eme carte
        if (carte1 != null && carte2 != null && carte2 != selectedCarte && carte3 == null) {
            carte3 = selectedCarte;
            verification();
        }
    }

    /**
     * Processus de vérification de la carte.
     */
    protected void verification() {
        // Cartes égales
        if (carte1.getReturnCarte().equals(carte2.getReturnCarte())) {
            carte1.setMatch(true);carte2.setMatch(true);
            carte1 = null;carte2 = null;carte3 = null;
            carte1 = selectedCarte;
            montreCarte();
        } else {
            montreCarte();
            carte1.setSelected(false);
            carte2.setSelected(false);
            cacheCarte();
            carte1 = carte3;
            carte3 = null;
            if (!ControlMenu.checkVie.isSelected()){nbVie --;}
        }
    }
}
