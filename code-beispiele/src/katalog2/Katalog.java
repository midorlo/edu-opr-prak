package katalog2;

/**
 * Ein Objekt dieser Klasse repräsentiert einen einfachen Katalog
 * für beliebige katalogisierbare Artikel.
 */
public class Katalog {

    /*
     * Die Artikel des Katalogs werden in einem Array verwaltet.
     * Bei Erreichen der Arraygrenze wird ein größeres Array
     * erzeugt, in das die Artikel aus dem kleineren Array
     * umkopiert werden.
     */

    /** Anfangsgröße des Arrays. */
    private static final int ANFANGSGROESSE = 5;

    /** Vergrößerungsschritt für Array. */
    private static final int SCHRITTWEITE = 10;

    /** Artikel dieses Katalogs. */
    private Katalogartikel[] katalogartikel;

    /** Anzahl Artikel dieses Katalogs. */
    private int anzahlArtikel;

    /**
     * Erzeugt ein Objekt dieser Klasse. Der Katalog ist anfangs leer.
     */
    public Katalog() {

        katalogartikel = new Katalogartikel[ANFANGSGROESSE];
        anzahlArtikel = 0;
    }

    /**
     * Fügt diesem Katalog einen Katalogartikel hinzu.
     *
     * @param artikel  Katalogartikel, der hinzugefügt wird
     */
    public void fuegeHinzu(Katalogartikel artikel) {

        if (anzahlArtikel == katalogartikel.length) {
            this.vergroessereKatalog();
        }

        katalogartikel[anzahlArtikel] = artikel;
        anzahlArtikel++;
    }

    /**
     * Vergrößert das Array zur Verwaltung der Katalogartikel.
     */
    private void vergroessereKatalog() {

        Katalogartikel[] artikelliste =
                new Katalogartikel[katalogartikel.length + SCHRITTWEITE];

        /* Katalogartikel in größeres Array übertragen
         */
        for (int i = 0; i < katalogartikel.length; i++) {
            artikelliste[i] = katalogartikel[i];
        }

        katalogartikel = artikelliste;
    }

    /**
     * Liefert den Inhalt dieses Katalogs als Zeichenkette. Der String
     * enthält pro Zeile die Textdarstellung je eines Katalogartikels.
     *
     * @return Liste der Artikel dieses Katalogs als String
     */
    public String gibArtikelliste() {

        String katalogdarstellung = "";

        /* über Artikel des Katalogs iterieren und Textdarstellungen
         * der Katalogartikel verketten.
         */
        for (int i = 0; i < anzahlArtikel; i++) {
            katalogdarstellung = katalogdarstellung
                                 + katalogartikel[i].gibText() + "\n";
        }

        return katalogdarstellung;
    }

    /**
     * Liefert die Anzahl der Katalogartikel dieses Katalogs,
     * die zum Suchbegriff passen.
     *
     * @param suchbegriff  Begriff, für den die Anzahl der
     *        passenden Katalogartikel bestimmt wird
     * @return Anzahl der Katalogartikel, die zum Suchbegriff passen
     */
    private int gibAnzahlTreffer(String suchbegriff) {

        int anzahlTreffer = 0;

        /* über Artikel dieses Katalogs iterieren und Anzahl der
         * passenden Katalogartikel bestimmen.
         */
        for (int i = 0; i < anzahlArtikel; i++) {
            if (katalogartikel[i].passtZu(suchbegriff)) {
                anzahlTreffer++;
            }
        }

        return anzahlTreffer;
    }

    /**
     * Liefert die Artikel dieses Katalogs, die zum Suchbegriff passen.
     *
     * @param suchbegriff  Begriff, für den die passenden Katalogartikel
     *        gesucht werden
     * @return Katalogartikel, die zum Suchbegriff passen
     */
    public Katalogartikel[] gibTreffer(String suchbegriff) {

        /* Array für Trefferliste erzeugen
         */
        Katalogartikel[] trefferliste =
                new Katalogartikel[this.gibAnzahlTreffer(suchbegriff)];

        int trefferindex = 0;

        /* über Artikel dieses Katalogs iterieren und passende Artikel
         * in Array für Trefferliste übernehmen.
         */
        for (int i = 0; i < anzahlArtikel; i++) {
            if (katalogartikel[i].passtZu(suchbegriff)) {
                trefferliste[trefferindex] = katalogartikel[i];
                trefferindex++;
            }
        }

        return trefferliste;
    }
}
