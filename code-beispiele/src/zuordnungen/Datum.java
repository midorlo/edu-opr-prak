package zuordnungen;

/**
 * Ein Objekt dieser Klasse repräsentiert ein Kalenderdatum.
 */
public class Datum {

    /** Anzahl der Tage eines Jahrs. */
    private static final int TAGE_PRO_JAHR = 360;

    /** Anzahl der Tage eines Monats. */
    private static final int TAGE_PRO_MONAT = 30;

    /** Jahr dieses Datums. */
    private int jahr;

    /** Monat dieses Datums. */
    private int monat;

    /** Tag dieses Datums. */
    private int tag;

    /**
     * Erzeugt ein neues Objekt dieser Klasse für die
     * angegebenen Daten.
     *
     * @param tag  Tag
     * @param monat  Monat
     * @param jahr  Jahr
     */
    public Datum(int tag, int monat, int jahr) {

        this.jahr = jahr;
        this.monat = monat;
        this.tag = tag;
    }

    /**
     * Gibt an, ob dieses Datum gleich dem übergebenen Objekt ist.
     *
     * @param obj  ein Objekt
     * @return <code>true</code> genau dann, wenn das übergebene Objekt
     *         ein Datum ist und dessen Tag, Monat und Jahr mit diesem
     *         Datum übereinstimmen
     */
    @Override
    public boolean equals(Object obj) {

        boolean istGleich = false;
        if (obj instanceof Datum) {
            Datum d = (Datum) obj;
            istGleich = (d.jahr == jahr)
                        && (d.monat == monat)
                        && (d.tag == tag);
        }
        return istGleich;
    }

    /**
     * Liefert Hash-Code dieses Datums.
     *
     * @return Hash-Code dieses Datums
     */
    @Override
    public int hashCode() {

        return jahr * TAGE_PRO_JAHR + monat * TAGE_PRO_MONAT + tag;
    }
}
