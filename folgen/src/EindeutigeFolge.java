import java.util.NoSuchElementException;

/**
 * Diese Klasse basiert auf einer Zahlenfolge und repraesentiert deren Werte
 * ohne doppelte Elemente. Es wird davon ausgegangen, dass die uebergebene Folge
 * sortiert ist.
 */
public class EindeutigeFolge implements Zahlenfolge {

    /** interngespeicherte Folge mit PushBack-Methoden. */
    private PushBackFolge folge;

    /**
     * Erzeugt eine Eindeutige Folge aus der uebergebenen Zahlenfolge.
     * @param folge Zahlenfolge.
     */
    public EindeutigeFolge(Zahlenfolge folge) {
        this.folge = (PushBackFolge) (folge instanceof PushBackFolge
                                      ? folge : new PushBackFolge(folge));
    }

    /**
     * Prueft ob eine Zahlenfolge noch ein weiteres Element besitzt.
     * @return Liefert genau dann true, wenn noch mindestens ein Element
     *         vorhanden ist.
     */
    public boolean hatNaechstes() {
        return this.folge.hatNaechstes();
    }

    /**
     * Gibt das naechse Element zurueck.
     * @return naechstes Element.
     * @throws NoSuchElementException Kein Element mehr vorhanden.
     */
    public int naechstes() throws NoSuchElementException {
        int rueckgabeWert;
        int nachestesElement;

        if (this.folge.hatNaechstes()) {
            rueckgabeWert = this.folge.naechstes();
            nachestesElement = rueckgabeWert;
            while (this.folge.hatNaechstes()
                   && (nachestesElement == rueckgabeWert)) {
                nachestesElement = this.folge.naechstes();
            }
            if (nachestesElement != rueckgabeWert) {
                this.folge.schreibeZurueck(nachestesElement);
            }
        } else {
            throw new NoSuchElementException();
        }
        return rueckgabeWert;
    }

}
