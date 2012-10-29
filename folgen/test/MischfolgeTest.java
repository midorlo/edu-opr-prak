
import org.junit.Test;


/**
 * Testklasse für Methoden der Klasse Mischfolge.
 */
public class MischfolgeTest extends ZahlenfolgeTest {

    /**
     * Testet Methoden hatNaechstes und naechstes.
     */
    @Test
    public void testZugriffAufFolge() {

        testZugriffAufFolge(new Mischfolge(
                                new EndlicheFolge(new int[0]),
                                new EndlicheFolge(new int[0])),
                            new Integer[0],
                            false);

        testZugriffAufFolge(new Mischfolge(
                                new EndlicheFolge(new int[0]),
                                new EndlicheFolge(new int[]{8, 5, 2, 5})),
                            new Integer[]{8, 5, 2, 5},
                            false);

        testZugriffAufFolge(new Mischfolge(
                                new FibonacciFolge(),
                                new EndlicheFolge(new int[]{-1, 0, 1, 5, 50})),
                            new Integer[]{-1, 0, 0, 1, 1, 1, 2, 3, 5, 5, 8, 13,
                                          21, 34, 50, 55, 89},
                            true);
    }
}
