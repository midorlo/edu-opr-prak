/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carsharing;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author apex
 */
public class ZeitraumTest {

    Zeitraum testZeitraum; 
    
    public ZeitraumTest() {
    }
    
    @Before
    public void setUp() {
        testZeitraum = new Zeitraum("2005/04/15 10:00");
    }

    /**
     * Test of getZeitraum method, of class Zeitraum.
     */
    @Test
    public void testGetZeitraum() {
        System.out.println("getZeitraum");
        Assert.assertEquals(200504151000L, testZeitraum.getZeitraum());
        
    }

    /**
     * Test of getDatum method, of class Zeitraum.
     */
    @Test
    public void testGetDatum() {
        System.out.println("getDatum");
        Assert.assertEquals(20050415L, testZeitraum.getDatum());
    }

    /**
     * Test of getUhrzeit method, of class Zeitraum.
     */
    @Test
    public void testGetUhrzeit() {
        System.out.println("getUhrzeit");
        Assert.assertEquals(1000L, testZeitraum.getUhrzeit());
    }

    /**
     * Test of getJahr method, of class Zeitraum.
     */
    @Test
    public void testGetJahr() {
        System.out.println("getJahr");
        Assert.assertEquals(2005L, testZeitraum.getJahr());
    }

    /**
     * Test of getMinute method, of class Zeitraum.
     */
    @Test
    public void testGetMinute() {
        System.out.println("getMinute");
        Assert.assertEquals(0L, testZeitraum.getMinute());
    }

    /**
     * Test of getMonat method, of class Zeitraum.
     */
    @Test
    public void testGetMonat() {
        System.out.println("getMonat");
        Assert.assertEquals(4L, testZeitraum.getMonat());
    }

    /**
     * Test of getStunde method, of class Zeitraum.
     */
    @Test
    public void testGetStunde() {
        System.out.println("getStunde");
        Assert.assertEquals(10L, testZeitraum.getStunde());
    }

    /**
     * Test of getTag method, of class Zeitraum.
     */
    @Test
    public void testGetTag() {
        System.out.println("getTag");
        Assert.assertEquals(15L, testZeitraum.getTag());
    }

    /**
     * Test of pruefeRelation method, of class Zeitraum.
     */
    @Test
    public void testPruefeRelation() {
        System.out.println("pruefeRelation");
        Assert.assertEquals(0, testZeitraum.pruefeRelation(200504140900L));
        Assert.assertEquals(1, testZeitraum.pruefeRelation(200504161000L));
    }

//    /**
//     * Test of equals method, of class Zeitraum.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object obj = null;
//        Zeitraum instance = null;
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
