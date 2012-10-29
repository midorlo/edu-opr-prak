package katalog2;

/**
 * Ein Objekt dieser Klasse repräsentiert einen Katalogartikel.
 */
public class Katalogartikel {

    /** Preis dieses Katalogartikels. */
    protected float preis;

    /**
     * Prüft, ob dieser Katalogartikel zum Suchbegriff passt.
     * Ein "vernünftiges" Verhalten kann in dieser allgemeinen
     * Klasse nicht realisiert werden.
     *
     * @param suchbegriff  Begriff, für den geprüft wird,
     *        ob dieser Katalogartikel dazu passt
     * @return <code>false</code>
     */
    public boolean passtZu(String suchbegriff) {

        return false;
    }

    /**
     * Liefert textuelle Darstellung dieses Katalogartikels.
     * Ein "vernünftiges" Verhalten kann in dieser allgemeinen
     * Klasse nicht realisiert werden.
     *
     * @return Hinweis, dass diese Methode in Unterklassen
     *         überschrieben werden muss
     */
    public String gibText() {

        return "Diese Methode muss von Unterklassen überschrieben werden.";
    }
}
