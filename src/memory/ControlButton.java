package memory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static memory.ControlMenu.nbLIGNE;

public class ControlButton implements ActionListener {
    private final Model m;
    private final Plateau p;

    public ControlButton(Model model,Plateau plateau){this.m = model;this.p = plateau;}

    @Override
    public void actionPerformed(ActionEvent e) {
        // Selection de la carte
        Object source;
        source = e.getSource();
        m.selectedCarte = (Carte) source;

        // Debut
        if (m.click == 0){
            App.chrono = new Chrono();
            App.chrono.start();
        }

        // Selection Carte
        if (!m.selectedCarte.getMatchCarte()){
            m.tourneCarte();
            m.score++;
            if (m.compteurCartes >= m.objectif && !m.selectedCarte.getReturnCarte().equals("Piege")){m.clickAvantFin ++;}else{m.clickAvantFin=0;}
        } else {
            System.out.println("Carte déjà retournée");
        }

        // Affichage
        ControlMenu.labelCoups.setText("Coups: "+ m.score);
        if (!ControlMenu.checkVie.isSelected()){
            ControlMenu.labelVie.setText("Vie: "+ m.nbVie);
        }

        // Fin
        if (m.isGameOver()) {
            App.chrono.terminate();
            JOptionPane.showMessageDialog(p, "FELICITATIONS ! \n Fini en " + App.chrono.affiche() + " s et " + m.score + " coups!","BRAVO !", JOptionPane.INFORMATION_MESSAGE);
            new FileClassement(App.chrono.affiche() + "," + m.score + "," + nbLIGNE);
        }

        // Fin de Vie
        if (m.nbVie == 0){
            App.chrono.terminate();
            JOptionPane.showMessageDialog(p, "Game Over","C'est la fin !",JOptionPane.INFORMATION_MESSAGE);
            m.score = 0;
            m.nbVie = nbLIGNE-1;
            App.begin();
        }
    }
}
