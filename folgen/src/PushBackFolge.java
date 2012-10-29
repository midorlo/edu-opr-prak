import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Diese Klasse basiert auf einer Zahlenfolge und ergaenzt diese um die
 * Faehigkeit, Werte „zurueckzuschreiben“.
 */
public class PushBackFolge implements Zahlenfolge {

    /** List in die die Zahlen zurueckgeschrieben werden koennen. */
    private List<Integer> list;
    /** Zahlenfolge auf die zugegriffen wird. */
    private Zahlenfolge folge;

    /** erzeugt eine neue PushBackFolge aus einer Zahlenfolge.
     * @param folge Zahlenfolge.
     */
    public PushBackFolge(Zahlenfolge folge) {
        this.folge = folge;
        this.list = new LinkedList();
    }

    /**
    * Prueft ob eine Zahlenfolge noch ein weiteres Element besitzt.
    * @return Liefert genau dann true, wenn noch mindestens ein Element
    *         vorhanden ist.
    */
    public boolean hatNaechstes() {
        return !this.list.isEmpty() || this.folge.hatNaechstes();
    }

    /**
    * Gibt das naechse Element zurueck.
    * @return naechstes Element.
    * @throws NoSuchElementException Kein Element mehr vorhanden.
    */
    public int naechstes() throws NoSuchElementException {
        int ruegabeWert;
        if (!this.list.isEmpty()) {
            ruegabeWert = this.list.remove(0);
        } else {
            ruegabeWert = this.folge.naechstes();
        }
        return ruegabeWert;
    }

    /**
     * Schreibt einen Zahlenwert zurueck in die Folge.
     * @param wert Wert der zurueckgeschrieben werden soll.
     */
    public void schreibeZurueck(int wert) {
        this.list.add(wert);
    }

}
