package katalog7;

/**
 * Diese Klasse realisiert einen speziellen Artikelverarbeiter.
 * Die Verarbeitung besteht darin, einen Artikel in einen Katalog
 * zu importieren. Der Katalog wird beim Konstruieren eines
 * Artikelimportierers übergeben.
 */
public class Artikelimportierer implements Artikelverarbeiter {

    /** Katalog, in den Artikel importiert werden. */
    private Katalog katalog;

    /**
     * Erzeugt ein Objekt dieser Klasse für den
     * übergebenen Katalog.
     *
     * @param katalog  Katalog, in den Artikel importiert werden
     */
    public Artikelimportierer(Katalog katalog) {

        this.katalog = katalog;
    }

    /**
     * Die Methode verarbeitet den übergebenen Artikel, indem sie ihn
     * in den Katalog importiert.
     *
     * @param artikel  Artikel, der importiert wird
     */
    @Override
    public void verarbeiteArtikel(Verkaufbares artikel) {

        katalog.fuegeHinzu(artikel);
    }
}
