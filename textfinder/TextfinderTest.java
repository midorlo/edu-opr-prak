/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author apex
 */
public class TextfinderTest {

    private String s;
    private Textfinder tf3;
    private Textfinder tf4;
    private Textfinder tf5;
    private HashMap<String, Integer> woerter;

    /**
     * 
     * @throws IOException 
     */
    @Before
    public void setUp() throws IOException {
        s = "H>-p>Chd>(9&i@90P6=X,(cb0E(eh9#Chd";
        tf3 = new Textfinder(new ByteArrayInputStream(s.getBytes()), 3);
        tf4 = new Textfinder(new ByteArrayInputStream(s.getBytes()), 4);
        tf5 = new Textfinder(new ByteArrayInputStream(s.getBytes()), 5);
    }

    /**
     * Test of gibWoerter method, of class Textfinder.
     */
    @Test
    public void testGibWoerter() {
        woerter = new HashMap<String, Integer>();
        woerter.put("90P6", 1);
        woerter.put("Chd", 2);
        woerter.put("cb0E", 1);
        woerter.put("eh9", 1);
        assertEquals(woerter.keySet(), tf3.gibWoerter());

        woerter = new HashMap<String, Integer>();
        woerter.put("90P6", 1);
        woerter.put("cb0E", 1);
        assertEquals(woerter.keySet(), tf4.gibWoerter());

        woerter = new HashMap<String, Integer>();
        assertEquals(woerter.keySet(), tf5.gibWoerter());
    }

    /**
     * Test of gibHaeufigkeit method, of class Textfinder.
     */
    @Test
    public void testGibHaeufigkeit() {
        woerter = new HashMap<String, Integer>();
        woerter.put("90P6", 1);
        woerter.put("Chd", 2);
        woerter.put("cb0E", 1);
        woerter.put("eh9", 1);
        assertEquals(2, tf3.gibHaeufigkeit("Chd"));
        assertEquals(0, tf3.gibHaeufigkeit("hf2z"));
        assertEquals(1, tf3.gibHaeufigkeit("cb0E"));

        woerter = new HashMap<String, Integer>();
        woerter.put("90P6", 1);
        woerter.put("cb0E", 1);
        assertEquals(1, tf4.gibHaeufigkeit("90P6"));
        assertEquals(1, tf4.gibHaeufigkeit("cb0E"));
        assertEquals(0, tf4.gibHaeufigkeit(".,mnadfk4kjb4"));

        woerter = new HashMap<String, Integer>();
        assertEquals(0, tf5.gibHaeufigkeit("hf2z"));
        assertEquals(0, tf5.gibHaeufigkeit("cb0E"));

    }
}
