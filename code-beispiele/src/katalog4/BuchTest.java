package katalog4;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testklasse für Methoden der Klasse Buch.
 */
public class BuchTest {

    /** Enthält Buch, das getestet wird. */
    private Buch buch;

    /**
     * Testdaten aufbauen.
     */
    @Before
    public void setUp() {

        buch = new Buch("Asterix der Gallier", "Uderzo", 9.80f, 1965);
    }

    /**
     * Testet Methode gibSuchtext der Klasse Buch.
     *
     * gibSuchtext ist protected in der Klasse Buch und hier nur deshalb
     * testbar, weil sich beide Klassen im selben Paket befinden.
     * In der Praxis wäre dies nicht der Fall.
     *
     * Schlechte Lösung: Man deklariert die Methode als public.
     *
     * Gute Lösung: Man definiert, einzig zu Testzwecken, eine Unterklasse
     * von Buch und überschreibt dort die geerbte Methode als public und
     * mit dem Methodenrumpf <code>return super.gibSuchtext()</code>.
     * Im Test arbeitet man dann mit einem Objekt der abgeleiteten Klasse.
     */
    @Test
    public void testGibSuchtext() {

        assertEquals("Asterix der Gallier Uderzo", buch.gibSuchtext());
    }

    /**
     * Testet Methode gibAutor der Klasse Buch.
     */
    @Test
    public void testGibAutor() {

        assertEquals("Uderzo", buch.gibAutor());
    }

    /**
     * Testet Methode gibText der Klasse Buch.
     */
    @Test
    public void testGibText() {

        assertEquals("Asterix der Gallier; Uderzo; 1965; €9.8",
                     buch.gibText());
    }
}
