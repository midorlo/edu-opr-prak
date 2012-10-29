package ausnahmen;

/**
 * Ein Objekt dieser Klasse repräsentiert eine Ausnahme,
 * die dazu dient, den Ausnahme-Mechanismus von Java
 * zu erläutern. Es enthält neben einem Meldungstext eine Zahl,
 * die die Ursache der Ausnahme erläutert.
 */
public class DemoException extends Exception {

    /** Zahleninformation zu dieser Ausnahme. */
    private int zahl;

    /**
     * Erzeugt ein Objekt dieser Klasse für die
     * angegebenen Daten.
     *
     * @param meldung  Meldungstext zu dieser Ausnahme
     * @param zahl  Zahl zu dieser Ausnahme
     */
    public DemoException(String meldung, int zahl) {

        /* Die Klasse Exception besitzt einen Konstruktor, dem ein
         * erläuternder Text zu der Ausnahme übergeben werden kann.
         */
        super(meldung);

        this.zahl = zahl;
    }

    /**
     * Liefert die Zahl dieser Ausnahme.
     *
     * @return Zahl dieser Ausnahme
     */
    public int gibZahl() {

        return zahl;
    }
}
