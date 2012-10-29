package katalog6;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

import katalog3.Katalogartikel;
import katalog5.Buch;
import katalog5a.Katalog;

/**
 * Testklasse für Methoden der Klasse Katalog.
 */
public class KatalogartikelleserTest {

    /** Zeilenumbruch. */
    private static final String UMBRUCH = System.getProperty("line.separator");

    /**
     * Testet Methode importiereInKatalog der Klasse Katalogartikelleser
     * mit korrekt geformten Katalogdaten.
     *
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     */
    @Test
    public void testImportiereInKatalog() throws IOException {

        StringReader katalogdaten;
        StringWriter fehlerprotokoll;

        Katalog katalog;
        ArrayList<Katalogartikel> sollergebnis;

        katalogdaten = new StringReader(
            "Buch;Asterix der Gallier;Uderzo;1967;6.50\n"
            + "Buch;\"Asterix bei den\nOlympischen Spielen\";Uderzo;1970;6.80\n"
            + "CD;Soundtrack zu Asterix der Gallier;1988\n"
            + "Buch;Asterix bei den Goten;Uderzo;1972 ;6.90\n"
            + "Buch;Asterix und der Seher;Uderzo\";1973;6.90\n"
            + "Buch;Asterix der Gallier;Uderzo;1965;6.7.0\n"
            + "Buch;\"Asterix; Ein gallischer \"\"Held\"\"\";N.N.;1988;17.50");
        fehlerprotokoll = new StringWriter();

        try {
            katalog = new Katalog();
            new Katalogartikelleser(katalogdaten, fehlerprotokoll)
                    .importiereInKatalog(katalog);

            sollergebnis = new ArrayList<Katalogartikel>();
            sollergebnis.add(new Buch("Asterix der Gallier",
                                      "Uderzo", 6.50f, 1967));
            sollergebnis.add(new Buch("Asterix bei den\nOlympischen Spielen",
                                      "Uderzo", 6.80f, 1970));
            sollergebnis.add(new Buch("Asterix; Ein gallischer \"Held\"",
                                      "N.N.", 17.50f, 1988));
            assertEquals(sollergebnis, katalog.gibTreffer(""));
            
            assertEquals("KatalogformatException: Ungültiges Buchformat. "
                    + "CD;Soundtrack zu Asterix der Gallier;1988" + UMBRUCH
                    + "KatalogformatException: Ungültiges Zahlenformat. "
                    + "Buch;Asterix bei den Goten;Uderzo;1972 ;6.90" + UMBRUCH
                    + "KatalogformatException: Ungültiges Format einer Zelle. "
                    + "Buch;Asterix und der Seher;Uderzo\";1973;6.90" + UMBRUCH
                    + "KatalogformatException: Ungültiges Zahlenformat. "
                    + "Buch;Asterix der Gallier;Uderzo;1965;6.7.0" + UMBRUCH,
                    fehlerprotokoll.toString());

        } finally {
            katalogdaten.close();
            fehlerprotokoll.close();
        }
    }
}
