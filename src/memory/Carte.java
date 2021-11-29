package memory;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Carte extends JButton {

    private boolean isReturn;
    private final String returnCarte;
    private final boolean selectCarte;
    private boolean matchCarte;

    public Carte(String s){
        this.isReturn = false;
        this.returnCarte = s;
        selectCarte = false;
        matchCarte = false;
        Border border = BorderFactory.createLineBorder(Color.BLACK,3);
        this.setBorder(border);
    }

    // Getter
    public String getReturnCarte(){ return returnCarte; }

    public boolean getSelectCarte(){ return selectCarte; }

    public boolean getMatchCarte(){ return matchCarte; }

    // Setter
    public void setMatch(boolean b){ this.matchCarte = b; }

}
