
import org.junit.Test;

/**
 * Testklasse für Methoden der Klasse EndlicheFolge.
 */
public class EndlicheFolgeTest extends ZahlenfolgeTest {

    /**
     * Testet Methoden hatNaechstes und naechstes.
     */
    @Test
    public void testZugriffAufFolge() {

        testZugriffAufFolge(new EndlicheFolge(new int[0]),
                            new Integer[0],
                            false);

        testZugriffAufFolge(new EndlicheFolge(new int[]{8, 5, 2, 5}),
                            new Integer[]{8, 5, 2, 5},
                            false);
    }
}
