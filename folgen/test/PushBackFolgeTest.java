
import org.junit.Assert;
import org.junit.Test;

/**
 * Testklasse für Methoden der Klasse PushBackFolge.
 */
public class PushBackFolgeTest extends ZahlenfolgeTest {

    /**
     * Testet Methoden hatNaechstes und naechstes.
     */
    @Test
    public void testZugriffAufFolge() {

        PushBackFolge folge = new PushBackFolge(new EndlicheFolge(new int[0]));
        testZugriffAufFolge(folge, new Integer[0], false);

        folge = new PushBackFolge(new EndlicheFolge(new int[0]));
        folge.schreibeZurueck(8);
        folge.schreibeZurueck(5);
        folge.schreibeZurueck(2);
        folge.schreibeZurueck(5);
        testZugriffAufFolge(folge, new Integer[]{8, 5, 2, 5}, false);

        folge = new PushBackFolge(new FibonacciFolge());
        Assert.assertEquals(0, folge.naechstes());
        Assert.assertEquals(1, folge.naechstes());
        folge.schreibeZurueck(-100);
        folge.schreibeZurueck(-200);
        Assert.assertEquals(-100, folge.naechstes());
        folge.schreibeZurueck(-300);
        testZugriffAufFolge(folge,
                            new Integer[]{-200, -300, 1, 2, 3, 5, 8},
                            true);
    }
}
