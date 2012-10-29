import java.util.NoSuchElementException;

/**
 * Methoden die eine Zahlenfolge implementieren muss.
 */
public interface Zahlenfolge {

    /**
     * Prueft ob eine Zahlenfolge noch ein weiteres Element besitzt.
     * @return Liefert genau dann true, wenn noch mindestens ein Element
     *         vorhanden ist.
     */
    boolean hatNaechstes();

    /**
     * Gibt das naechse Element zurueck.
     * @return naechstes Element.
     * @throws NoSuchElementException Kein Element mehr vorhanden.
     */
    int naechstes() throws NoSuchElementException;

}
