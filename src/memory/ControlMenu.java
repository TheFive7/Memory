package memory;

import javax.swing.*;
import java.awt.*;

public class ControlMenu extends JPanel{
    public static int nbLIGNE = 4;
    public static String[] deck = {"Chien", "Chien", "Koala", "Koala", "Lapin", "Lapin", "Loup", "Loup",
            "Ours", "Ours", "Renard", "Renard", "Rhinoceros", "Rhinoceros", "Tigre", "Tigre"};
    public static JMenu options;
    public static JLabel labelCoups,labelVie,labelTemps;
    public static JCheckBox checkVie;

    public ControlMenu(Model model) {
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        // Menu
        JMenuBar menu = new JMenuBar();
        options = new JMenu("Options");
        options.setPreferredSize(new Dimension(70, 35));
        menu.add(options);
        add(menu);

        /* Controller Bouton */
        JMenuItem buttonRestart = new JMenuItem("Nouvelle Partie");
        buttonRestart.setPreferredSize(new Dimension(150, 30));
        buttonRestart.addActionListener(ae -> {
            model.score = 0;
            model.nbVie = nbLIGNE-1;
            App.begin();
        });
        options.add(buttonRestart);

        // CLassement
        ClassementMenu menuClassement = new ClassementMenu();
        menu.add(menuClassement);

        // Menu
        new GrilleMenu(model);

        /* Vies */
        checkVie = new JCheckBox("Vie illimitée",true);
        options.add(checkVie);

        /* Regles */
        JMenuItem menuRegles = new JMenuItem("Règles");
        options.add(menuRegles);
        String message =
                """
                Le but du jeu est de trouver toutes les paires qui s'associent entre elles.\s
                Le mode de jeu par défaut est la grille 4*4.\s
                Les grilles 3*3 et 5*5 contiennent une carte piege.\s
                De plus, dans ces modes, il faut valider la derniere carte en appuyant une 2eme fois dessus.\s
                Vous pouvez aussi consulter les classements généraux, modifier quelques paramètres...\s
                Amusez - vous bien !\s
                
                © HENNEQUIN Maxime S2-B1 ©
                """;
        menuRegles.addActionListener(ae -> JOptionPane.showMessageDialog(this, message, "Règles",JOptionPane.INFORMATION_MESSAGE));

        /* Coups */
        labelCoups = new JLabel("" + labelCoups, SwingConstants.CENTER);
        labelCoups.setPreferredSize(new Dimension(150, 30));
        labelCoups.setFont(new Font("Arial", Font.BOLD, 16));
        labelCoups.setText("Coups: "+ model.score);
        add(labelCoups);

        /* Vies */
        labelVie = new JLabel("" + labelVie, SwingConstants.CENTER);
        labelVie.setPreferredSize(new Dimension(150, 30));
        labelVie.setFont(new Font("Arial", Font.BOLD, 16));
        if (!checkVie.isSelected()){labelVie.setText("Vie: "+ model.nbVie);}else{labelVie.setText("Vie: illimité");}
        add(labelVie);

        /* Temps */
        labelTemps = new JLabel("" + labelTemps, SwingConstants.CENTER);
        labelTemps.setPreferredSize(new Dimension(150, 30));
        labelTemps.setFont(new Font("Arial", Font.BOLD, 16));
        labelTemps.setText("Temps: "+ "0" + " s");
        add(labelTemps);

        /* Layout */
        borderLayout.addLayoutComponent(menu, BorderLayout.NORTH);
        borderLayout.addLayoutComponent(labelCoups, BorderLayout.EAST);
        borderLayout.addLayoutComponent(labelVie, BorderLayout.CENTER);
        borderLayout.addLayoutComponent(labelTemps, BorderLayout.WEST);
    }
}
