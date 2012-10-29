package katalog6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import katalog3.Katalogartikel;
import katalog5.Buch;
import katalog5a.Katalog;

/**
 * <p>Diese Klasse dient dazu, Beschreibungen von Katalogartikeln aus
 * einer Datenquelle zu lesen, daraus Katalogartikel zu erzeugen
 * und diese einem Katalog hinzuzufügen. Diese Klasse funktioniert
 * zunächst nur für Bücher.</p>
 *
 * <p>Die Daten müssen folgendes Format besitzen:
 * Buch;<i>Titel</i>;<i>Autor</i>;<i>Erscheinungsjahr</i>;<i>Preis</i></p>
 *
 * <ul>
 * <li>Buch ist ein fester Text und gibt an, dass es sich bei dem Artikel
 * um ein Buch handelt.</li>
 *
 * <li><i>Titel</i> ist der Titel des Buchs. Enthält der Titel ein
 * Semikolon, so muss der Titel durch Anführungsstriche geklammert
 * sein. Enthält der Titel Anführungsstriche, so muss er ebenfalls
 * durch Anführungsstriche geklammert sein und die Anführungsstriche
 * müssen doppelt enthalten sein ("").</li>
 *
 * <li><i>Autor</i> ist der Autor des Buchs. Die Aussagen zu Semikolon und
 * Anführungszeichen gelten entsprechend.</li>
 *
 * <li><i>Erscheinungsjahr</i> und <i>Preis</i> geben das Erscheinungsjahr
 * und den Preis des Buchs an.</li>
 * </ul>
 */
public class Katalogartikelleser {

    /*
     * Zustände des endlichen Automaten zur Erkennung
     * der Katalogdaten.
     */

    /** Am Anfang einer Zelle. */
    private static final String START = "Start";

    /** Am Ende einer Zelle. */
    private static final String ENDE = "Ende";

    /** In einer Zelle, die nicht durch Anführungsstriche geklammert ist. */
    private static final String OHNE_ANFUEHRUNGSSTRICHE =
            "ohne Anführungsstriche";

    /** In einer Zelle, die durch Anführungsstriche geklammert ist. */
    private static final String MIT_ANFUEHRUNGSSTRICHEN =
            "mit Anführungsstrichen";

    /**
     * Nach einem "-Zeichen innerhalb einer Zelle, die durch
     * Anführungsstriche geklammert ist.
     */
    private static final String ANFUEHRUNGSSTRICH = "Anführungsstrich";

    /** Undefinierter Zustand. */
    private static final String UNDEFINIERT = "undefiniert";

    /** Trennzeichen zwischen Daten zu einem Katalogartikel. */
    private static final char TRENNER = ';';

    /**
     * Zeichen, mit dem eine Textzelle, die das Trennzeichen enthält,
     * umgeben sein muss.
     */
    private static final char TEXTKLAMMER = '"';

    /** Zeichen für Zeilenumbruch. */
    private static final char ZEILENUMBRUCH = '\n';

    /**
     * Meldung für KatalogformatException: Katalogdaten
     * enden unerwartet.
     */
    private static final String MSG_UNERWARTETES_ENDE =
            "Unerwartetes Ende der Eingabe.";

    /**
     * Meldung für KatalogformatException: Nummerische
     * Angabe hat ungültiges Format.
     */
    private static final String MSG_UNGUELTIGES_ZAHLENFORMAT =
            "Ungültiges Zahlenformat.";

    /**
     * Meldung für KatalogformatException: Eine Datenzelle
     * hat ungültiges Format.
     */
    private static final String MSG_UNGUELTIGE_ZELLE =
            "Ungültiges Format einer Zelle.";

    /**
     * Meldung für KatalogformatException: Der Artikeltyp
     * ist ungültig.
     */
    private static final String MSG_UNGUELTIGER_ARTIKELTYP =
            "Ungültiges Buchformat.";

    /** Anfang einer Datenzeile für ein Buch. */
    private static final String BUCH = "Buch";

    /** Für den zeilenweisen Zugriff auf die Katalogdaten. */
    private BufferedReader katalogdaten;

    /** Für die Ausgabe von Fehlern. */
    private PrintWriter fehlerprotokoll;

    /*
     * Der Leser liest zeilenweise aus der Datenquelle. Das Verarbeiten
     * der eingelesenen Daten erfolgt zeichenweise.
     */

    /** Zeile, die zuletzt eingelesen wurde. */
    private String aktuelleZeile;

    /** Position des nächsten Zeichens, das verarbeitet werden muss. */
    private int aktuellePosition;

    /**
     * Erzeugt ein Objekt dieser Klasse für die angegebene Datenquelle.
     *
     * @param katalogdaten  Reader, aus dem die Katalogdaten gelesen
     *        werden
     * @param fehlerprotokoll  Writer, in den Fehlerausgaben geschrieben
     *        werden
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     */
    public Katalogartikelleser(Reader katalogdaten, Writer fehlerprotokoll)
        throws IOException {

        this.katalogdaten = new BufferedReader(katalogdaten);
        this.fehlerprotokoll = new PrintWriter(fehlerprotokoll);

        /* Erste Zeile laden.
         */
        this.ladeNaechsteZeile();
    }

    /**
     * Lädt die nächste Zeile aus der Datenquelle und setzt die aktuelle
     * Position auf das erste Zeichen dieser Zeile.
     *
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     */
    private void ladeNaechsteZeile() throws IOException {

        aktuelleZeile = katalogdaten.readLine();
        aktuellePosition = 0;
    }

    /**
     * Liefert das nächste Zeichen aus der zuletzt gelesenen Zeile.
     * Auch das Ende einer Zeile wird als ein Zeichen geliefert.
     * Dadurch können Aufrufer dieser Methode erkennen, wann das Ende
     * einer Zeile erreicht ist.
     *
     * @return nächstes Zeichen der zuletzt gelesenen Zeile. '\n' wird
     *         als Zeichen für das Zeilenende geliefert.
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     * @throws KatalogformatException wird geworfen, wenn kein weiteres
     *         Zeichen zur Verfügung steht
     */
    private char gibNaechstesZeichen()
        throws IOException, KatalogformatException {

        char naechstesZeichen;

        /* Das letzte Lesen aus der Datenquelle lieferte null, d.h.
         * es gibt keine weiteren Zeichen.
         */
        if (aktuelleZeile == null) {
            throw new KatalogformatException(MSG_UNERWARTETES_ENDE);
        }

        if (aktuellePosition < aktuelleZeile.length()) {
            naechstesZeichen = aktuelleZeile.charAt(aktuellePosition);
            aktuellePosition++;
        } else {

            /* Alle Zeichen der zuletzt gelesenen Zeile sind schon
             * verarbeitet. Es wird das Zeichen für das Zeilenende
             * zurückgegeben.
             */
            naechstesZeichen = ZEILENUMBRUCH;

            /* Nächste Zeile laden, sodass beim nächsten Aufruf dieser Methode
             * das Zeichen geliefert werden kann, das dem Zeilenumbruch folgt.
             */
            this.ladeNaechsteZeile();
        }

        return naechstesZeichen;
    }

    /**
     * Liefert die nächste Zelle. Eine Zelle endet mit einem Semikolon
     * oder einem Zeilenumbruch. Siehe Zeilenformat in der Beschreibung
     * dieser Klasse.
     *
     * @return nächste Datenzelle
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     * @throws KatalogformatException wird geworfen, wenn die Zelle wegen
     *         eines fehlerhaften Datenformats nicht geliefert werden kann
     */
    private String gibZelle() throws IOException, KatalogformatException {

        String zeile = aktuelleZeile;

        /* Diese Methode realisiert einen endlichen Automaten. Der Zustand
         * OHNE_ANFUEHRUNGSSTRICHE gibt an, dass die Daten der Zelle nicht
         * mit einem Anführungsstrich beginnen. Der Zustand
         * MIT_ANFUEHRUNGSSTRICHEN gibt an, dass die Daten mit
         * Anführungsstrichen beginnen. Sie müssen dann auch damit enden.
         */

        String zelle = "";
        String zustand = START;

        while ((zustand != ENDE) && (zustand != UNDEFINIERT)) {

            char c = this.gibNaechstesZeichen();

            String folgezustand = UNDEFINIERT;

            if (zustand == START) {
                if (c == TRENNER || c == ZEILENUMBRUCH) {
                    folgezustand = ENDE;
                } else if (c == TEXTKLAMMER) {
                    folgezustand = MIT_ANFUEHRUNGSSTRICHEN;
                } else {
                    folgezustand = OHNE_ANFUEHRUNGSSTRICHE;
                    zelle = zelle + c;
                }
            } else if (zustand == OHNE_ANFUEHRUNGSSTRICHE) {
                if (c == TRENNER || c == ZEILENUMBRUCH) {
                    folgezustand = ENDE;
                } else if (c != TEXTKLAMMER) {
                    folgezustand = OHNE_ANFUEHRUNGSSTRICHE;
                    zelle = zelle + c;
                }
            } else if (zustand == MIT_ANFUEHRUNGSSTRICHEN) {
                if (c == TEXTKLAMMER) {
                    folgezustand = ANFUEHRUNGSSTRICH;
                } else {
                    folgezustand = MIT_ANFUEHRUNGSSTRICHEN;
                    zelle = zelle + c;
                }
            } else if (zustand == ANFUEHRUNGSSTRICH) {
                if (c == TEXTKLAMMER) {
                    folgezustand = MIT_ANFUEHRUNGSSTRICHEN;
                    zelle = zelle + TEXTKLAMMER;
                } else if (c == TRENNER || c == ZEILENUMBRUCH) {
                    folgezustand = ENDE;
                }
            }

            zustand = folgezustand;
        }

        if (zustand == UNDEFINIERT) {
            throw new KatalogformatException(MSG_UNGUELTIGE_ZELLE, zeile);
        }

        return zelle;
    }

    /**
     * Gibt an, ob die Datenquelle noch Daten für einen weiteren
     * Artikel enthält.
     *
     * @return <code>true</code> genau dann, wenn die Datenquelle
     *         noch weitere Daten enthält
     */
    private boolean gibtEsWeiterenArtikel() {

        return (aktuelleZeile != null);
    }

    /**
     * Liefert nächsten Artikel, der anhand der Daten aus der Datenquelle
     * erzeugt wird.
     *
     * @return nächster Katalogartikel
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     * @throws KatalogformatException  wird geworfen, wenn das Datenformat
     *         fehlerhaft ist und deshalb kein Artikel erzeugt werden kann
     */
    private Katalogartikel gibArtikel()
        throws IOException, KatalogformatException {

        String zeile = aktuelleZeile;

        if (BUCH.equals(this.gibZelle())) {

            /* Bei korrektem Format ist die Reihenfolge der Zellen:
             * Titel, Autor, Erscheinungsjahr, Preis.
             */
            String titel = this.gibZelle();
            String autor = this.gibZelle();
            try {
                int erscheinungsjahr = Integer.parseInt(this.gibZelle());
                float preis = Float.parseFloat(this.gibZelle());
                return new Buch(titel, autor, preis, erscheinungsjahr);
            } catch (NumberFormatException e) {
                throw new KatalogformatException(MSG_UNGUELTIGES_ZAHLENFORMAT,
                                                 zeile);
            }
        } else {
            throw new KatalogformatException(MSG_UNGUELTIGER_ARTIKELTYP,
                                             zeile);
        }
    }

    /**
     * Liest aus der Datenquelle und fügt die eingelesenen Katalogartikel
     * dem übergebenen Katalog hinzu.
     *
     * @param katalog  Katalog, dem die eingelesenen Artikel
     *        hinzugefügt werden
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     */
    public void importiereInKatalog(Katalog katalog) throws IOException {

        while (this.gibtEsWeiterenArtikel()) {
            try {
                katalog.fuegeHinzu(this.gibArtikel());
            } catch (KatalogformatException e) {
                fehlerprotokoll.println(e);

                /* Alles in der aktuellen Zeile überspringen und mit nächster
                 * Zeile fortfahren. Falls aktuellePosition == 0, so wurde
                 * nach dem Lesen des letzten Zeichens schon die nächste
                 * Zeile geladen.
                 */
                if (this.aktuellePosition > 0) {
                    this.ladeNaechsteZeile();
                }
            }
        }
    }

    /**
     * Diese Methode zeigt beispielhaft die Anwendung der Klasse
     * Katalogartikelleser.
     *
     * @param args  wird nicht verwendet
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     */
    public static void main(String[] args) throws IOException {

        /* Verzeichnis- und Dateinamen werden in dieser Klasse nicht
         * als Konstanten definiert, da sie nicht zur Klasse Katalogdatenleser
         * gehören, sondern nur mit der beispielhaften Anwendung
         * dieser Klasse zu tun haben.
         */

        /* Verzeichnis für Testdateien zur Ein- und Ausgabe.
         * Muss auf Ihre Verzeichnisstruktur angepasst werden.
         */
        File verzeichnis = new File("src/katalog6");

        File datendatei = new File(verzeichnis, "KatalogdatenKlein.txt");
        File protokolldatei = new File(verzeichnis, "Protokoll.txt");

        FileReader katalogdaten = new FileReader(datendatei);
        FileWriter fehlerprotokoll = new FileWriter(protokolldatei);

        /* Katalog, dem Artikel hinzugefügt werden, erzeugen.
         */
        Katalog katalog = new Katalog();

        try {
            Katalogartikelleser leser =
                    new Katalogartikelleser(katalogdaten, fehlerprotokoll);
            leser.importiereInKatalog(katalog);
        } finally {
            katalogdaten.close();
            fehlerprotokoll.close();
        }

        /* Alle Artikel des Katalogs ausgeben.
         */
        System.out.println(katalog.gibArtikelliste());
    }
}
