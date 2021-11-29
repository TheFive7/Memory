package memory;

public class App {
    public static Chrono chrono = new Chrono();

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(App::begin);
    }

    public static void begin(){
        App.chrono.terminate();
        new Game();
    }
}
