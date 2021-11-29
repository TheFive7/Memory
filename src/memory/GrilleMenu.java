package memory;

import javax.swing.*;
import java.awt.*;

public class GrilleMenu {

    public GrilleMenu(Model m){
        /* Choix taille grille */
        JMenu tailleGrille = new JMenu("Taille Grille");
        tailleGrille.setPreferredSize(new Dimension(70, 30));
        ControlMenu.options.add(tailleGrille);

        /* Menu 3*3 */
        JMenuItem taille1 = new JMenuItem("3*3");
        taille1.setPreferredSize(new Dimension(50, 30));
        tailleGrille.add(taille1);
        taille1.addActionListener(ae -> {
            m.score = 0;
            ControlMenu.nbLIGNE = 3;
            ControlMenu.deck = new String[]{"Chien", "Chien", "Koala", "Koala", "Lapin", "Lapin", "Loup", "Loup", "Piege"};
            App.begin();
        });

        /* Menu 4*4 */
        JMenuItem taille2 = new JMenuItem("4*4");
        taille2.setPreferredSize(new Dimension(50, 30));
        tailleGrille.add(taille2);
        taille2.addActionListener(ae -> {
            m.score = 0;
            ControlMenu.nbLIGNE = 4;
            ControlMenu.deck = new String[]{"Chien", "Chien", "Koala", "Koala", "Lapin", "Lapin", "Loup", "Loup",
                    "Ours", "Ours", "Renard", "Renard", "Rhinoceros", "Rhinoceros", "Tigre", "Tigre"};
            App.begin();
        });

        /* Menu 5*5 */
        JMenuItem taille3 = new JMenuItem("5*5");
        taille3.setPreferredSize(new Dimension(50, 30));
        tailleGrille.add(taille3);
        taille3.addActionListener(ae -> {
            m.score = 0;
            ControlMenu.nbLIGNE = 5;
            ControlMenu.deck = new String[]{"bleu", "bleu", "rouge", "rouge","vert", "vert", "jaune", "jaune",
                    "orange", "orange","multi", "multi","cyan", "cyan", "magenta", "magenta",
                    "rose","rose","noir","noir","gris","gris","berk","berk", "Piege"};
            App.begin();
        });
    }
}
