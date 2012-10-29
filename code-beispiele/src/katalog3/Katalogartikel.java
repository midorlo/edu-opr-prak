package katalog3;

import java.util.StringTokenizer;

/**
 * Ein Objekt dieser Klasse repräsentiert einen Katalogartikel.
 */
public abstract class Katalogartikel {

    /**
     * Wörter, die bei der Prüfung, ob ein Artikel zu einem Suchbegriff
     * passt, nicht berücksichtigt werden sollen.
     */
    private static String[] ausschlusswoerter =
            new String[]{"der", "die", "das", "und", "oder"};

    /** Preis dieses Katalogartikels. */
    private float preis;

    /**
     * Erzeugt einen neuen Katalogartikel und setzt den angegebenen Preis.
     *
     * @param preis  Preis dieses Katalogartikels
     */
    public Katalogartikel(float preis) {

        this.preis = preis;
    }

    /**
     * Gibt zurück, ob das übergebene Wort in der Liste der
     * Ausschlusswörter enthalten ist.
     *
     * @param wort  Wort, für das geprüft werden soll, ob es ein
     *        Ausschlusswort ist
     * @return <code>true</code> genau dann, wenn das Wort ein
     *         Ausschlusswort ist
     */
    private static boolean istAusschlusswort(String wort) {

        int i = 0;

        /* über Ausschlusswörter iterieren und diese mit
         * dem übergebenen Wort vergleichen
         */
        while ((i < ausschlusswoerter.length)
               && !ausschlusswoerter[i].equalsIgnoreCase(wort)) {
            i++;
        }

        return (i < ausschlusswoerter.length);
    }

    /**
     * Prüft, ob dieser Artikel zum Suchbegriff passt. Der Artikel passt,
     * wenn sein Suchtext ein Wort enthält, das kein Ausschlusswort ist
     * und mit dem Suchbegriff beginnt.
     *
     * @param suchbegriff  Begriff, für den geprüft wird,
     *        ob dieser Katalogartikel dazu passt
     * @return <code>true</code> genau dann, wenn dieser Artikel
     *         zum Suchbegriff passt
     */
    public boolean passtZu(String suchbegriff) {

        /* StringTokenizer verwenden, da die einzelnen Wörter
         * des Suchtexts untersucht werden müssen.
         */
        StringTokenizer st = new StringTokenizer(this.gibSuchtext());

        /* Gibt an, ob ein passendes Wort aus dem Titel gefunden wurde.
         */
        boolean wortGefunden = false;

        /* Wörter des Titels mit Suchbegriff vergleichen
         */
        while (st.hasMoreTokens() && !wortGefunden) {
            String token = st.nextToken();
            if (token.startsWith(suchbegriff) && !istAusschlusswort(token)) {
                wortGefunden = true;
            }
        }

        return wortGefunden;
    }

    /**
     * Liefert den Preis dieses Katalogartikels.
     *
     * @return Preis dieses Artikels
     */
    protected float gibPreis() {

        return preis;
    }

    /**
     * Liefert textuelle Darstellung dieses Katalogartikels.
     *
     * @return textuelle Darstellung dieses Katalogartikels
     */
    public abstract String gibText();

    /**
     * Liefert den Suchtext dieses Artikels. Anhand des Suchtexts
     * lässt sich entscheiden, ob der Artikel zu einem Suchbegriff passt.
     *
     * @return Suchtext dieses Artikels
     */
    protected abstract String gibSuchtext();
}
