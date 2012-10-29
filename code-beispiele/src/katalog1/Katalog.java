package katalog1;

/**
 * Ein Objekt dieser Klasse repräsentiert einen einfachen Katalog
 * für Bücher.
 */
public class Katalog {

    /*
     * Die Bücher des Katalogs werden in einem Array verwaltet.
     * Bei Erreichen der Arraygrenze wird ein größeres Array
     * erzeugt, in das die Bücher aus dem kleineren Array
     * umkopiert werden.
     */

    /** Anfangsgröße des Arrays. */
    private static final int ANFANGSGROESSE = 5;

    /** Vergrößerungsschritt für Array. */
    private static final int SCHRITTWEITE = 10;

    /** Bücher dieses Katalogs. */
    private Buch[] buecher;

    /** Anzahl Bücher dieses Katalogs. */
    private int anzahlBuecher;

    /**
     * Erzeugt ein Objekt dieser Klasse. Der Katalog ist anfangs leer.
     */
    public Katalog() {

        buecher = new Buch[ANFANGSGROESSE];
        anzahlBuecher = 0;
    }

    /**
     * Fügt diesem Katalog ein Buch hinzu.
     *
     * @param buch  Buch, das hinzugefügt wird
     */
    public void fuegeHinzu(Buch buch) {

        if (anzahlBuecher == buecher.length) {
            this.vergroessereKatalog();
        }

        buecher[anzahlBuecher] = buch;
        anzahlBuecher++;
    }

    /**
     * Vergrößert das Array zur Verwaltung der Bücher.
     */
    private void vergroessereKatalog() {

        Buch[] buecherliste = new Buch[buecher.length + SCHRITTWEITE];

        /* Bücher in größeres Array übertragen
         */
        for (int i = 0; i < buecher.length; i++) {
            buecherliste[i] = buecher[i];
        }

        buecher = buecherliste;
    }

    /**
     * Liefert den Inhalt dieses Katalogs als Zeichenkette. Der String
     * enthält pro Zeile die Textdarstellung je eines Buchs.
     *
     * @return Liste der Bücher dieses Katalogs als String
     */
    public String gibArtikelliste() {

        String katalogdarstellung = "";

        /* über Artikel des Katalogs iterieren und Textdarstellungen
         * der Katalogartikel verketten.
         */
        for (int i = 0; i < anzahlBuecher; i++) {
            katalogdarstellung = katalogdarstellung
                                 + buecher[i].gibText() + "\n";
        }

        return katalogdarstellung;
    }

    /**
     * Liefert die Anzahl der Bücher dieses Katalogs,
     * die zum Suchbegriff passen.
     *
     * @param suchbegriff  Begriff, für den die Anzahl der
     *        passenden Bücher bestimmt wird
     * @return Anzahl der Bücher, die zum Suchbegriff passen
     */
    private int gibAnzahlTreffer(String suchbegriff) {

        int anzahlTreffer = 0;

        /* über Bücher dieses Katalogs iterieren und Anzahl der
         * passenden Bücher bestimmen.
         */
        for (int i = 0; i < anzahlBuecher; i++) {
            if (buecher[i].passtZu(suchbegriff)) {
                anzahlTreffer++;
            }
        }

        return anzahlTreffer;
    }

    /**
     * Liefert die Bücher dieses Katalogs, die zum Suchbegriff passen.
     *
     * @param suchbegriff  Begriff, für den die passenden Bücher
     *        gesucht werden
     * @return Bücher, die zum Suchbegriff passen
     */
    public Buch[] gibTreffer(String suchbegriff) {

        /* Array für Trefferliste erzeugen
         */
        Buch[] trefferliste = new Buch[this.gibAnzahlTreffer(suchbegriff)];

        int trefferindex = 0;

        /* über Bücher dieses Katalogs iterieren und passende Bücher
         * in Array für Trefferliste übernehmen.
         */
        for (int i = 0; i < anzahlBuecher; i++) {
            if (buecher[i].passtZu(suchbegriff)) {
                trefferliste[trefferindex] = buecher[i];
                trefferindex++;
            }
        }

        return trefferliste;
    }
}
