package katalog4;

import katalog3.Katalogartikel;

/**
 * Ein Objekt dieser Klasse repräsentiert ein Buch.
 */
public class Buch extends Katalogartikel {

    /** Titel dieses Buchs. */
    private String titel;

    /** Autor dieses Buchs. */
    private String autor;

    /** Erscheinungsjahr dieses Buchs. */
    private int erscheinungsjahr;

    /**
     * Erzeugt ein Objekt dieser Klasse für die angegebenen Daten.
     *
     * @param titel  Titel dieses Buchs
     * @param autor  Autor dieses Buchs
     * @param preis  Preis dieses Buchs
     * @param erscheinungsjahr  Erscheinungsjahr dieses Buchs
     */
    public Buch(String titel, String autor, float preis, int erscheinungsjahr) {

        super(preis);
        this.titel = titel;
        this.autor = autor;
        this.erscheinungsjahr = erscheinungsjahr;
    }

    /**
     * Liefert den Autor dieses Buchs.
     *
     * @return Autor dieses Buchs
     */
    public String gibAutor() {

        return autor;
    }

    /**
     * Liefert textuelle Darstellung dieses Buchs.
     *
     * @return textuelle Darstellung dieses Buchs (Titel, Autor,
     *         Erscheinungsjahr und Preis durch Semikolon getrennt)
     */
    @Override
    public String gibText() {

        return (titel + "; " + autor + "; "
                + erscheinungsjahr + "; €" + gibPreis());
    }

    /**
     * Liefert den Suchtext dieses Buchs. Anhand des Suchtexts
     * lässt sich entscheiden, ob das Buch zu einem Suchbegriff passt.
     *
     * @return Suchtext dieses Buchs
     */
    @Override
    protected String gibSuchtext() {

        return (titel + " " + autor);
    }
}
