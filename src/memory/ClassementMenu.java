package memory;

import javax.swing.*;
import java.awt.*;

public class ClassementMenu extends JPanel{
    public static String s144;public static String s244;public static String s344;
    public static String s133;public static String s233;public static String s333;
    public static String s155;public static String s255;public static String s355;

    public ClassementMenu(){
        /* Scores */
        JMenu itemScore = new JMenu("Meilleurs Scores");
        itemScore.setPreferredSize(new Dimension(70, 30));
        ControlMenu.options.add(itemScore);

        JMenu itemScore0 = new JMenu("3*3");
        itemScore0.setPreferredSize(new Dimension(70, 30));
        itemScore.add(itemScore0);
        JMenu itemScore1 = new JMenu("4*4");
        itemScore1.setPreferredSize(new Dimension(70, 30));
        itemScore.add(itemScore1);
        JMenu itemScore2 = new JMenu("5*5");
        itemScore2.setPreferredSize(new Dimension(70, 30));
        itemScore.add(itemScore2);

        new FileClassement();

        /* Tout Classement */
        String classement =
                "Grille 3*3: \n" +
                        s133 + "\n" + s233 + "\n" + s333 + "\n\n" +
                        "Grille 4*4: \n" +
                        s144 + "\n" + s244 + "\n" + s344 + "\n\n" +
                        "Grille 5*5: \n" +
                        s155 + "\n" + s255 + "\n" + s355;

        JMenuItem tousClassements = new JMenuItem("Tout");
        tousClassements.setPreferredSize(new Dimension(70, 30));
        itemScore.add(tousClassements);
        tousClassements.addActionListener(ae -> JOptionPane.showMessageDialog(this,classement,"Classement",JOptionPane.INFORMATION_MESSAGE));


        /* Classement 3*3 */
        JMenuItem num133 = new JMenuItem("1.   "+ s133);
        num133.setPreferredSize(new Dimension(200, 30));
        itemScore0.add(num133);

        JMenuItem num233 = new JMenuItem("2.   "+ s233);
        num233.setPreferredSize(new Dimension(200, 30));
        itemScore0.add(num233);

        JMenuItem num333 = new JMenuItem("3.   "+ s333);
        num333.setPreferredSize(new Dimension(200, 30));
        itemScore0.add(num333);

        /* Classement 4*4 */
        JMenuItem num144 = new JMenuItem("1.   "+ s144);
        num144.setPreferredSize(new Dimension(200, 30));
        itemScore1.add(num144);

        JMenuItem num244 = new JMenuItem("2.   "+ s244);
        num244.setPreferredSize(new Dimension(200, 30));
        itemScore1.add(num244);

        JMenuItem num344 = new JMenuItem("3.   "+ s344);
        num344.setPreferredSize(new Dimension(200, 30));
        itemScore1.add(num344);

        /* Classement 5*5 */
        JMenuItem num155 = new JMenuItem("1.   "+ s155);
        num155.setPreferredSize(new Dimension(200, 30));
        itemScore2.add(num155);

        JMenuItem num255 = new JMenuItem("2.   "+ s255);
        num255.setPreferredSize(new Dimension(200, 30));
        itemScore2.add(num255);

        JMenuItem num355 = new JMenuItem("3.   "+ s355);
        num355.setPreferredSize(new Dimension(200, 30));
        itemScore2.add(num355);
    }
}
