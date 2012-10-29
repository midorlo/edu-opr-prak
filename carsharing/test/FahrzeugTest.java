/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carsharing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author apex
 */
public class FahrzeugTest {
    
    Fahrzeug auto;
    
    public FahrzeugTest() {
    }
    
    @Before
    public void setUp() {
        auto = new Fahrzeug("BMW", "Essen");
    }

    /**
     * Test of toString method, of class Fahrzeug.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String descr = "Fahrzeug{name=BMW, standort=Essen, startzeit=null, endzeit=null}";
        Assert.assertEquals(descr, auto.toString());
    }

    /**
     * Test of gibName method, of class Fahrzeug.
     */
    @Test
    public void testGibName() {
        System.out.println("gibName");
        Assert.assertEquals("BMW", auto.gibName());
    }

    /**
     * Test of gibStandort method, of class Fahrzeug.
     */
    @Test
    public void testGibStandort() {
        System.out.println("gibStandort");
        Assert.assertEquals("Essen", auto.gibStandort());
    }

    /**
     * Test of istFrei method, of class Fahrzeug.
     */
    @Test
    public void testIstFrei() {
        System.out.println("istFrei");
        Assert.assertEquals(true, auto.istFrei("2005/04/15 10:00", "2005/04/16 08:00"));
        auto.startzeit = new Zeitraum("2005/04/15 08:00");
        auto.endzeit = new Zeitraum("2005/04/16 10:00");
        Assert.assertEquals(false, auto.istFrei("2005/04/15 10:00", "2005/04/16 08:00"));
    }

    /**
     * Test of setzeBuchung method, of class Fahrzeug.
     */
    @Test
    public void testSetzeBuchung() {
        System.out.println("setzeBuchung");
        auto.setzeBuchung("2005/04/15 09:30", "2005/04/16 11:10");
        Assert.assertEquals(200504150930L, auto.startzeit.getZeitraum());
        Assert.assertEquals(200504161110L, auto.endzeit.getZeitraum());
    }
    
//    /**
//     * Test of equals method, of class Fahrzeug.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object obj = null;
//        Fahrzeug instance = null;
//        boolean expResult = false;
//        boolean result = instance.equals(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
//    @After
//    public void tearDown() {
//    }
}
