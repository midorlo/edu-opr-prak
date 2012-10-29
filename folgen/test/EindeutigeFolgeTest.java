
import org.junit.Test;

/**
 * Testklasse für Methoden der Klasse EindeutigeFolge.
 */
public class EindeutigeFolgeTest extends ZahlenfolgeTest {

    /**
     * Testet Methoden hatNaechstes und naechstes.
     */
    @Test
    public void testZugriffAufFolge() {

        testZugriffAufFolge(new EindeutigeFolge(new EndlicheFolge(new int[0])),
                            new Integer[0],
                            false);

        testZugriffAufFolge(
                new EindeutigeFolge(
                        new EndlicheFolge(new int[]{0, 0, 0, 1, 2, 3, 3, 4, 4})),
                new Integer[]{0, 1, 2, 3, 4},
                false);

        testZugriffAufFolge(new EindeutigeFolge(new FibonacciFolge()),
                            new Integer[]{0, 1, 2, 3, 5},
                            true);
    }
}
