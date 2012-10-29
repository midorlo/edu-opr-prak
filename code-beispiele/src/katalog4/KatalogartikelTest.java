package katalog4;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import katalog3.Katalogartikel;

/**
 * Testklasse für Methoden der Klasse Katalogartikel.
 *
 * Da die Klasse Katalogartikel abstrakt ist, wird zum Test
 * eine konkrete Unterklasse benötigt. Die Klasse Buch ist
 * dazu zwar prinzipiell geeignet, jedoch würden dann
 * zwangsläufig die Methoden der Klasse Buch mitgetestet.
 *
 * Falls ein Test fehlschlägt, ist dann nicht unmittelbar zu
 * erkennen, in welcher Klasse die Ursache liegt.
 *
 * Deshalb nutzt man - einzig zu Testzwecken - eine "Attrappe"
 * eines Katalogartikels. Ein Objekt der Klasse
 * MockKatalogartikel ist solch ein spezieller Katalogartikel
 * mit einem trivialem Verhalten.
 */
public class KatalogartikelTest {

    /** Enthält Katalogartikel, der getestet wird. */
    private Katalogartikel katalogartikel;

    /**
     * Testdaten aufbauen.
     */
    @Before
    public void setUp() {

        katalogartikel = new MockKatalogartikel("das diebesgut");
    }

    /**
     * Testet Methode passtZu der Klasse Katalogartikel.
     */
    @Test
    public void testPasstZu() {

        // Wortanfang, aber Ausschlusswort
        assertFalse(katalogartikel.passtZu("da"));

        // Wortanfang, kein Ausschlusswort
        assertTrue(katalogartikel.passtZu("die"));

        // kein Wortanfang
        assertFalse(katalogartikel.passtZu("xyungelöst"));
    }
}
