import java.util.NoSuchElementException;

/**
 * Diese Klasse repraesentiert die Folge, die aus den gemeinsamen Werten zweier
 * Folgen besteht. Sind diese beiden Folgen sortiert, ist die Mischfolge
 * ebenfalls sortiert. (Ansonsten kann die Mischfolge die Elemente in einer
 * beliebigen Reihenfolge liefern.
 */
public class Mischfolge implements Zahlenfolge {

    /** Zwei PusbBackFolgen von denen immer die graessere ausgeben werden kann
     *  und die kleiner zurueckgeschrieben wird. */
    private PushBackFolge folge0, folge1;

    /**
     * Erzeugt eine neue Mischfolge aus 2 Zahlenfolgen.
     * @param folge0 erste Folge
     * @param folge1 zweite Folge
     */
    public Mischfolge(Zahlenfolge folge0, Zahlenfolge folge1) {
        this.folge0 = (PushBackFolge) (folge0 instanceof PushBackFolge
                                       ? folge0 : new PushBackFolge(folge0));
        this.folge1 = (PushBackFolge) (folge1 instanceof PushBackFolge
                                       ? folge1 : new PushBackFolge(folge1));
    }

    /**
    * Prueft ob eine Zahlenfolge noch ein weiteres Element besitzt.
    * @return Liefert genau dann true, wenn noch mindestens ein Element
    *         vorhanden ist.
    */
    public boolean hatNaechstes() {
        return this.folge0.hatNaechstes() || this.folge1.hatNaechstes();
    }

    /**
    * Gibt das naechse Element zurueck.
    * @return naechstes Element.
    * @throws NoSuchElementException Kein Element mehr vorhanden.
    */
    public int naechstes() throws NoSuchElementException {
        int zahl0, zahl1, rueckgabeWert;
        if (this.folge0.hatNaechstes() && !this.folge1.hatNaechstes()) {
            rueckgabeWert = this.folge0.naechstes();
        } else if (!this.folge0.hatNaechstes() && this.folge1.hatNaechstes()) {
            rueckgabeWert = this.folge1.naechstes();
        } else if (!this.folge0.hatNaechstes() && !this.folge1.hatNaechstes()) {
            throw new NoSuchElementException();
        } else {
            zahl0 = this.folge0.naechstes();
            zahl1 = this.folge1.naechstes();
            if (zahl0 < zahl1) {
                rueckgabeWert = zahl0;
                this.folge1.schreibeZurueck(zahl1);
            } else {
                rueckgabeWert = zahl1;
                this.folge0.schreibeZurueck(zahl0);
            }
        }
        return rueckgabeWert;
    }

}
