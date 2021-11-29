package memory;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private static final int FENETRE_LARGEUR = 900;
    private static final int FENETRE_HAUTEUR = 900;

    public Game() {
        ImageIcon icon = new ImageIcon("src/icon.PNG");
        setIconImage(icon.getImage());
        setSize(new Dimension(FENETRE_LARGEUR, FENETRE_HAUTEUR));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Memory");
        setResizable(true);
        setVisible(true);
        Fenetre f = new Fenetre();
        add(f);
    }
}
