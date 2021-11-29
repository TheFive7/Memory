package memory;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JPanel{
    public Fenetre() {
        BorderLayout borderLayout = new BorderLayout(1, 1);
        setLayout(borderLayout);

        Model model = new Model();
        ControlMenu barre = new ControlMenu(model);
        Plateau plateau = new Plateau(model);
        add(plateau);
        add(barre);

        borderLayout.addLayoutComponent(plateau, BorderLayout.CENTER);
        borderLayout.addLayoutComponent(barre, BorderLayout.NORTH);

        setSize(800,800);
        setVisible(true);
    }
}
