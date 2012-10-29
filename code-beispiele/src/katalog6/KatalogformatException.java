package katalog6;

/**
 * Diese Ausnahme zeigt einen Fehler im Format
 * von Katalogdaten an.
 */
public class KatalogformatException extends Exception {

    /** Datenzeile, auf die sich die Ausnahme bezieht. */
    private String zeile;

    /**
     * Erzeugt ein neues Objekt dieser Klasse für die
     * angegebenen Daten.
     *
     * @param meldung  Meldungstext zu dieser Ausnahme
     * @param zeile  Datenzeile, auf die sich diese Ausnahme bezieht
     */
    public KatalogformatException(String meldung, String zeile) {

        super(meldung);
        this.zeile = zeile;
    }

    /**
     * Erzeugt ein neues Objekt dieser Klasse. Diese Ausnahme bezieht
     * sich auf keine Datenzeile.
     *
     * @param meldung  Meldungstext zu dieser Ausnahme
     */
    public KatalogformatException(String meldung) {

        this(meldung, null);
    }

    /**
     * Liefert Datenzeile, auf die sich diese Ausnahme bezieht.
     *
     * @return Datenzeile zu dieser Ausnahme
     */
    public String gibZeile() {

        return zeile;
    }

    /**
     * Liefert textuelle Darstellung dieser Ausnahme.
     *
     * @return textuelle Darstellung
     */
    @Override
    public String toString() {

        return "KatalogformatException: " + this.getMessage()
                + (zeile == null ? "" : " " + zeile);
    }
}
