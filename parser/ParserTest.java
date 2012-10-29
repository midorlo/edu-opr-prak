import java.text.ParseException;
import junit.framework.TestCase;

/**
 * Test Klasse zum Testen der Parser Klasse.
 */
public class ParserTest extends TestCase {
    /** Parser fuer dir Testautrufe. */
    private Parser parser;

    /**
     * Erzeuge neue Instanz der Test Klasse.
     * @param name Name der Klasse.
     */
    public ParserTest(String name) {
        super(name);
    } 

    /**
     * startet die Test Klasse.
     * @param args nicht benutzt.
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(ParserTest.class);
    }

    /**
     * Initialisierung der Testklasse.
     */
    @Override
    public void setUp() {
         this.parser = new Parser();
    }

    /**
     * Testet die Methode parse aus der Klasse Parser fuer die Faelle das ein
     * ungueltiges Token vorhanden ist.
     */
    public void testParseUngueltigesToken() {
        try {
            parser.parse("( )");
            fail("( )");
        } catch (ParseException ex) {
            assertEquals("ungueltiges Token )", ex.getMessage());
            assertEquals(2, ex.getErrorOffset());
        }

        try {
            parser.parse("( + )");
            fail("( + )");
        } catch (ParseException ex) {
            assertEquals("ungueltiges Token +", ex.getMessage());
            assertEquals(2, ex.getErrorOffset());
        }


        try {
            parser.parse("(( 10) 10)");
            fail("(( 10) 10)");
        } catch (ParseException ex) {
            assertEquals("ungueltiges Token 10", ex.getMessage());
            assertEquals(5, ex.getErrorOffset());
        }

        try {
            parser.parse("1a");
            fail("1a");
        } catch (ParseException ex) {
            assertEquals("ungueltiges Token 1a", ex.getMessage());
            assertEquals(1, ex.getErrorOffset());
        }

        try {
            parser.parse("a 1");
            fail("a 1");
        } catch (ParseException ex) {
            assertEquals("ungueltiges Token 1", ex.getMessage());
            assertEquals(2, ex.getErrorOffset());
        }

        try {
            parser.parse("2 - )");
            fail("2 - )");
        } catch (ParseException ex) {
            assertEquals("ungueltiges Token )", ex.getMessage());
            assertEquals(3, ex.getErrorOffset());
        }

        try {
            parser.parse("2 * (s - t * a_b)");
            fail("2 * (s - t * a_b)");
        } catch (ParseException ex) {
            assertEquals("ungueltiges Token a_b", ex.getMessage());
            assertEquals(8, ex.getErrorOffset());
        }

        try {
            parser.parse("2 * (s - )");
            fail("2 * (s - )");
        } catch (ParseException ex) {
            assertEquals("ungueltiges Token )", ex.getMessage());
            assertEquals(6, ex.getErrorOffset());
        }

        try {
            parser.parse("2 * (s - t) (");
            fail("2 * (s - t) (");
        } catch (ParseException ex) {
            assertEquals("ungueltiges Token (", ex.getMessage());
            assertEquals(8, ex.getErrorOffset());
        }
       
    }

    /**
    * Testet die Methode parse aus der Klasse Parser fuer die Faelle das ein
    * unerwartetes Ende auftritt.
    */
    public void testParseUnerwartetesEnde() {
        try {
            this.parser.parse("");
            fail("");
        } catch (ParseException ex) {
            assertEquals("unerwartetes Ende", ex.getMessage());
        }

        try {
            this.parser.parse("2 * (s - t * 5");
            fail("2 * (s - t * 5");
        } catch (ParseException ex) {
            assertEquals("unerwartetes Ende", ex.getMessage());
        }

        try {
            this.parser.parse("2 * (3 * (i + 4)");
            fail("");
        } catch (ParseException ex) {
            assertEquals("unerwartetes Ende", ex.getMessage());
        }
    }


    /**
    * Testet die Methode parse aus der Klasse Parser fuer die Faelle das ein
    * gueltiger Ausdruck vorliegt.
    */
    public void testParseGueltig() {
        try {
            assertEquals(new OperatorAusdruck(
                            new Variable("a"), '+', new Konstante(1)),
                         this.parser.parse("a + 1"));
        } catch (ParseException ex) {
            fail(ex.getMessage());
        }

        try {
            assertEquals(new OperatorAusdruck(
                            new OperatorAusdruck(
                                new Variable("ab"), '+', new Variable("b")),
                                    '/' , new Konstante(2)),
                         this.parser.parse("(ab   +    b) / 2"));
        } catch (ParseException ex) {
            fail(ex.getMessage());
        }

        try {
        assertEquals(new OperatorAusdruck(new OperatorAusdruck(
                                              new Konstante(1), '+',
                                              new Variable("a")),
                                          '*', new OperatorAusdruck(
                                                  new Konstante(2), '-',
                                                  new Variable("b"))),
                     this.parser.parse("(1   +a)*   (2-   b)"));
        } catch (ParseException ex) {
            fail(ex.getMessage());
        }
    }
}
