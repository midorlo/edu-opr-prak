import java.util.NoSuchElementException;

/**
 * Diese Klasse repraeseniert die Zahlen der Fibonacci-Folge.
 */
public class FibonacciFolge implements Zahlenfolge {

    /** die beiden letzen Zahlen der Fibonacii-Folge um die naechste Zahl
      * auszurechnen. */
    private int zahl0, zahl1;
    /** Counter nachdem der eigentliche Algorithmus startet, da die ersten
      * beiden Ziffern sonst nicht zu errechnen sind. */
    private int starteAlgorithmus;

    /**
     * Erzeugt eine neue Fibonacci-Folge.
     */
    public FibonacciFolge() {
        this.zahl0 = 0;
        this.zahl1 = 1;
        this.starteAlgorithmus = 2;
    }

    /**
    * Prueft ob eine Zahlenfolge noch ein weiteres Element besitzt.
    * @return Liefert genau dann true, wenn noch mindestens ein Element
    *         vorhanden ist.
    */
    public boolean hatNaechstes() {
        return true;
    }

    /**
    * Gibt das naechse Element zurueck.
    * @return naechstes Element.
    * @throws NoSuchElementException Kein Element mehr vorhanden.
    */
    public int naechstes() throws NoSuchElementException {
        int zahl2 = 2;
        if (starteAlgorithmus != 0) {
            zahl2 -= this.starteAlgorithmus;
            this.starteAlgorithmus--;
        } else {
            zahl2 = this.zahl1 + this.zahl0;
            this.zahl0 = this.zahl1;
            this.zahl1 = zahl2;
        }
        return zahl2;
    }

}
