package memory;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import static memory.ControlMenu.nbLIGNE;

public class Plateau extends JPanel {

    // Image de base
    private Image imgBase;

    public Plateau(Model model){
        // Image de base
        try{imgBase = ImageIO.read(Plateau.class.getResource("/imageBase.jfif"));}catch(IOException e){e.printStackTrace();}
        model.iconeBase = new ImageIcon(imgBase);

        ControlButton controlButton = new ControlButton(model,this);

        setBackground(Color.WHITE);
        GridLayout layout = new GridLayout(nbLIGNE, nbLIGNE, 5, 5);
        setLayout(layout);
        setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        model.deckJeu = new Carte[nbLIGNE][nbLIGNE];
        model.deckDepart = ControlMenu.deck;
        model.melange();
        model.poseCarte(this,controlButton);
    }
}