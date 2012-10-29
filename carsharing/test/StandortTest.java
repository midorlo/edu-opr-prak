/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carsharing;

import java.util.ArrayList;
import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apex
 */
public class StandortTest {

    private static Standort duisburg;
    private static Fahrzeug auto;

    public StandortTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        duisburg = new Standort("Duisburg");
        auto = new Fahrzeug("BMW", "Duisburg");
    }
    
//    @Before
//    public void classSetUp() {
//    }

    /**
     * Test of toString method, of class Standort.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Assert.assertEquals("Standort{name=Duisburg, fahrzeugListe=[]}", duisburg.toString());
    }

    /**
     * Test of gibName method, of class Standort.
     */
    @Test
    public void testGibName() {
        System.out.println("gibName");
        Assert.assertEquals("Duisburg", duisburg.gibName());
    }

    /**
     * Test of fuegeFahrzeugHinzu method, of class Standort.
     */
    @Test
    public void testFuegeFahrzeugHinzu() {
        System.out.println("fuegeFahrzeugHinzu");
        duisburg.fuegeFahrzeugHinzu(auto);
        Assert.assertEquals(auto, duisburg.fahrzeugListe.get(0));
        System.out.println(duisburg.getIdent());
    }

    /**
     * Test of getFahrzeugListe method, of class Standort.
     */
    @Test
    public void testGetFahrzeugListe() {
//        duisburg.fuegeFahrzeugHinzu(auto);
        System.out.println(duisburg.getIdent());
        System.out.println("getFahrzeugListe");
        ArrayList<Fahrzeug> fahrzeuge = new ArrayList<Fahrzeug>();
        fahrzeuge.add(auto);
        Assert.assertEquals(fahrzeuge, duisburg.getFahrzeugListe());
    }
//    /**
//     * Test of equals method, of class Standort.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object obj = null;
//        Standort instance = null;
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
