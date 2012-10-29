package katalog7;

/**
 * Diese Schnittstelle definiert die Anforderungen an einen
 * Artikelverarbeiter. Ein Objekt, das diese Schnittstelle
 * implementiert, muss in der Lage, verkaufbare Artikel
 * zu verarbeiten.
 */
public interface Artikelverarbeiter {

    /**
     * Verarbeitet den übergebenen Artikel.
     *
     * @param artikel  Artikel, der verarbeitet wird
     */
    void verarbeiteArtikel(Verkaufbares artikel);
}
