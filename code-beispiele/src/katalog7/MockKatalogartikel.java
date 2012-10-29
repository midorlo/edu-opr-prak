package katalog7;

/**
 * Ein Objekt dieser Klasse repräsentiert eine Attrappe
 * eines Katalogartikels. Objekte dieser Klasse enthalten
 * einen String, um sie anhand ihrer Inhalte unterscheidbar
 * zu machen.
 *
 * Diese Klasse wird zum Test der Klasse Katalogartikel
 * benötigt.
 *
 * Siehe Kommentar zur Klasse KatalogartikelTest.
 */
public class MockKatalogartikel extends Katalogartikel {

    /** Text dieses Artikels. */
    private String text;

    /**
     * Erzeugt ein Objekt dieser Klasse für
     * den angegebenen Text.
     *
     * @param text  Text dieses Artikels
     */
    public MockKatalogartikel(String text) {

        super(0.0f);  // Oberklasse hat nur diesen Konstruktor
        this.text = text;
    }

    /**
     * Liefert textuelle Darstellung dieses Artikels.
     *
     * @return Text dieses Artikels
     */
    @Override
    public String gibText() {

        return this.gibSuchtext();
    }

    /**
     * Liefert den Text dieses Artikels als Suchtext.
     *
     * @return Suchtext dieses Artikels
     */
    @Override
    protected String gibSuchtext() {

        return text;
    }
}
