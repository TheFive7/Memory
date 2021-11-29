package memory;

public class Chrono extends Thread {
    private double temps;
    private boolean demarre;

    public Chrono(){
        this.demarre = false;
        this.temps = 0;
    }

    @Override
    public void run(){
        demarre = true;

        while (demarre) {
            try{
                sleep(100);
                temps+=0.1;
                temps = (double)Math.round(temps * 100) / 100;
                ControlMenu.labelTemps.setText("Temps: "+(this.affiche())+" s");
            }
            catch(InterruptedException ignored){}
        }
    }

    public void terminate(){
        demarre = false;
    }

    public String affiche() {return this.temps + "";}
}