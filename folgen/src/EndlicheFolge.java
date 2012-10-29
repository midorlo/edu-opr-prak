import java.util.NoSuchElementException;

/**
 * Diese Klasse repraesentiert eine endliche Folge, deren Werte beim Erzeugen
 * explizit angegeben werden.
 */
public class EndlicheFolge implements Zahlenfolge {

    /** interne Folge die eine endliche Folge an Zahlen speichert. */
    private int[] folge;
    /** enthaelt eine Referenz auf das momentan anktuelle Element. */
    private int aktuellesElement;

    /**
     * Erzeugt eine neue EndlicheFolge.
     * @param folge Int-Array aus der die Zahlenfolge generiert wird.
     */
    public EndlicheFolge(int[] folge) {
        this.folge = folge;
        this.aktuellesElement = 0;
    }

    /**
    * Prueft ob eine Zahlenfolge noch ein weiteres Element besitzt.
    * @return Liefert genau dann true, wenn noch mindestens ein Element
    *         vorhanden ist.
    */
    public boolean hatNaechstes() {
        return (this.aktuellesElement < this.folge.length);
    }

    /**
    * Gibt das naechse Element zurueck.
    * @return naechstes Element.
    * @throws NoSuchElementException Kein Element mehr vorhanden.
    */
    public int naechstes() throws NoSuchElementException {
        int rueckgabeWert;
        try {
            rueckgabeWert = this.folge[aktuellesElement];
            aktuellesElement++;
        } catch (Exception ex) {
            throw new NoSuchElementException();
        }
        return rueckgabeWert;
    }

}
