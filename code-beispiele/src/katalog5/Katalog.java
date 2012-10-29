package katalog5;

import java.util.ArrayList;

import katalog3.Katalogartikel;

/**
 * Ein Objekt dieser Klasse repräsentiert einen einfachen Katalog
 * für beliebige katalogisierbare Artikel.
 */
public class Katalog {

    /** Artikel dieses Katalogs. */
    private ArrayList katalogartikel;

    /**
     * Erzeugt ein Objekt dieser Klasse. Der Katalog ist anfangs leer.
     */
    public Katalog() {

        katalogartikel = new ArrayList();
    }

    /**
     * Fügt diesem Katalog einen Katalogartikel hinzu.
     *
     * @param artikel  Katalogartikel, der hinzugefügt wird
     */
    public void fuegeHinzu(Katalogartikel artikel) {

        katalogartikel.add(artikel);
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
        for (int i = 0; i < katalogartikel.size(); i++) {
            katalogdarstellung = katalogdarstellung
                    + ((Katalogartikel) katalogartikel.get(i)).gibText() + "\n";
        }

        return katalogdarstellung;
    }

    /**
     * Liefert die Artikel dieses Katalogs, die zum Suchbegriff passen.
     *
     * @param suchbegriff  Begriff, für den die passenden Katalogartikel
     *        gesucht werden
     * @return Katalogartikel, die zum Suchbegriff passen
     */
    public ArrayList gibTreffer(String suchbegriff) {

        /* ArrayList für Trefferliste erzeugen
         */
        ArrayList trefferliste = new ArrayList();

        /* über Artikel dieses Katalogs iterieren und passende Artikel
         * in Trefferliste übernehmen.
         */
        for (int i = 0; i < katalogartikel.size(); i++) {
            if (((Katalogartikel) katalogartikel.get(i)).passtZu(suchbegriff)) {
                trefferliste.add(katalogartikel.get(i));
            }
        }

        return trefferliste;
    }
}
