package katalog7;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testklasse für Methoden der Klasse Katalog.
 */
public class KatalogTest {

    /** Enthält Katalog, der getestet wird. */
    private Katalog katalog;

    /** Enthält Artikel des Katalogs. */
    private Katalogartikel artikel1;

    /** Enthält Artikel des Katalogs. */
    private Katalogartikel artikel2;

    /**
     * Testdaten aufbauen.
     */
    @Before
    public void setUp() {

        katalog = new Katalog();

        /* Zur Verwendung der Klasse MockKatalogartikel siehe
         * Kommentar in der Klasse KatalogartikelTest.
         */

        artikel1 = new MockKatalogartikel("a1");
        artikel2 = new MockKatalogartikel("a2");

        katalog.fuegeHinzu(artikel1);
        katalog.fuegeHinzu(artikel2);
    }

    /**
     * Testet Methode gibTreffer der Klasse Katalog.
     */
    @Test
    public void testGibTreffer() {

        List<Verkaufbares> sollErgebnis = new ArrayList<Verkaufbares>();
        sollErgebnis.add(artikel1);
        sollErgebnis.add(artikel2);
        assertEquals(sollErgebnis, katalog.gibTreffer("a"));

        sollErgebnis = new ArrayList<Verkaufbares>();
        sollErgebnis.add(artikel1);
        assertEquals(sollErgebnis, katalog.gibTreffer("a1"));

        sollErgebnis = new ArrayList<Verkaufbares>();
        assertEquals(sollErgebnis, katalog.gibTreffer("b"));
    }

    /**
     * Testet Methode gibArtikelliste der Klasse Katalog.
     */
    @Test
    public void testGibArtikelliste() {

        assertEquals("a1\na2\n", katalog.gibArtikelliste());
    }
}
