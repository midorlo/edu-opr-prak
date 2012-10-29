/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carsharing;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author apex
 */
public class FahrzeugmanagerTest {

    public Fahrzeugmanager fahrzeugmanager = new Fahrzeugmanager();

    public FahrzeugmanagerTest() {
        fahrzeugmanager.fuegeFahrzeugHinzu("Rathaus 1", "Rathaus");
        fahrzeugmanager.fuegeFahrzeugHinzu("Bahnhof 1", "Bahnhof");
        fahrzeugmanager.fuegeFahrzeugHinzu("Bahnhof 2", "Bahnhof");
        fahrzeugmanager.fuegeFahrzeugHinzu("Bahnhof 3", "Bahnhof");

        fahrzeugmanager.bucheFahrzeug("Bahnhof 1", "2005/04/14 20:00", "2005/04/15 08:00");
        fahrzeugmanager.bucheFahrzeug("Bahnhof 1", "2005/04/15 18:00", "2005/04/16 00:00");
        fahrzeugmanager.bucheFahrzeug("Bahnhof 2", "2005/04/14 11:00", "2005/04/15 12:00");
        fahrzeugmanager.bucheFahrzeug("Bahnhof 3", "2005/04/15 10:00", "2005/04/15 19:00");
    }

    @Before
    public void setUp() {
        
    }

    /**
     * Test of gibFahrzeugnamen method, of class Fahrzeugmanager.
     */
    @Test
    public void testGibFahrzeugnamen() {

        ArrayList sollErgebnis = new ArrayList();
        sollErgebnis.add(new Fahrzeug("Bahnhof 1", "Bahnhof").gibName());
        sollErgebnis.add(new Fahrzeug("Bahnhof 2", "Bahnhof").gibName());
        sollErgebnis.add(new Fahrzeug("Bahnhof 3", "Bahnhof").gibName());
        sollErgebnis.add(new Fahrzeug("Rathaus 1", "Rathaus").gibName());

        Assert.assertEquals(sollErgebnis, fahrzeugmanager.gibFahrzeugnamen());
    }

    /**
     * Test of gibVerfuegbareFahrzeuge method, of class Fahrzeugmanager.
     */
    @Test
    public void testGibVerfuegbareFahrzeuge() {
        ArrayList sollErgebnis1 = new ArrayList();

        ArrayList sollErgebnis2 = new ArrayList();
        sollErgebnis2.add(new Fahrzeug("Bahnhof 1", "Bahnhof"));
        sollErgebnis2.add(new Fahrzeug("Bahnhof 2", "Bahnhof"));

        ArrayList sollErgebnis3 = new ArrayList();
        sollErgebnis2.add(new Fahrzeug("Bahnhof 2", "Bahnhof"));
        sollErgebnis2.add(new Fahrzeug("Bahnhof 3", "Bahnhof"));

        Assert.assertEquals(sollErgebnis1, fahrzeugmanager.gibVerfuegbareFahrzeuge
                ("Bahnhof", "2005/04/15 11:30", "2005/04/15 19:00"));
        Assert.assertEquals(sollErgebnis2, fahrzeugmanager.gibVerfuegbareFahrzeuge
                ("Bahnhof", "2005/04/15 12:00", "2005/04/15 18:00"));
        Assert.assertEquals(sollErgebnis3, fahrzeugmanager.gibVerfuegbareFahrzeuge
                ("Bahnhof", "2005/04/15 19:15", "2005/04/15 23:00"));
    }

    /**
     * Test of bucheFahrzeug method, of class Fahrzeugmanager.
     */
    @Test
    public void testBucheFahrzeug() {
         Assert.assertEquals(true, fahrzeugmanager.bucheFahrzeug
                ("Bahnhof 3", "2005/04/15 09:00", "2005/04/15 10:00"));
        Assert.assertEquals(false, fahrzeugmanager.bucheFahrzeug
                ("Bahnhof 3", "2005/04/15 19:00", "2005/04/15 11:00"));
        Assert.assertEquals(false, fahrzeugmanager.bucheFahrzeug
                ("Bahnhof 3", "2005/04/15 11:00", "2005/04/15 18:00"));
         Assert.assertEquals(false, fahrzeugmanager.bucheFahrzeug
                ("Bahnhof 3", "2005/04/15 18:00", "2005/04/15 20:00"));
        Assert.assertEquals(true, fahrzeugmanager.bucheFahrzeug
                ("Bahnhof 3", "2005/04/15 19:00", "2005/04/15 20:00"));
        Assert.assertEquals(false, fahrzeugmanager.bucheFahrzeug
                ("Bahnhof 3", "2005/04/15 09:00", "2005/04/15 20:00"));
    }

//    /**
//     * Test of fuegeFahrzeugHinzu method, of class Fahrzeugmanager.
//     */
//    @Test
//    public void testFuegeFahrzeugHinzu() {
//        System.out.println("fuegeFahrzeugHinzu");
//        String fahrzeugname = "";
//        String standort = "";
//        Fahrzeugmanager instance = new Fahrzeugmanager();
//        instance.fuegeFahrzeugHinzu(fahrzeugname, standort);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of bestimmeStandort method, of class Fahrzeugmanager.
//     */
//    @Test
//    public void testBestimmeStandort() {
//        System.out.println("bestimmeStandort");
//        String standort = "";
//        Fahrzeug fahrzeug = null;
//        Fahrzeugmanager instance = new Fahrzeugmanager();
//        instance.bestimmeStandort(standort, fahrzeug);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
