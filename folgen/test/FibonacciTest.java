
import org.junit.Test;

/**
 * Testklasse für Methoden der Klasse FibonacciFolge.
 */
public class FibonacciTest extends ZahlenfolgeTest {

    /**
     * Testet Methoden hatNaechstes und naechstes.
     */
    @Test
    public void testZugriffAufFolge() {

        testZugriffAufFolge(new FibonacciFolge(),
                            new Integer[0],
                            true);

        testZugriffAufFolge(
                new FibonacciFolge(),
                    new Integer[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144},
                true);
    }
}
