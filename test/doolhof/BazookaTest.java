/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Danny
 */
public class BazookaTest {
    
    public BazookaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of paintComponent method, of class Bazooka.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        Bazooka instance = new Bazooka();
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afschieten method, of class Bazooka.
     */
    @Test
    public void testAfschieten() {
        System.out.println("afschieten");
        Direction d = null;
        Veld veld = null;
        Bazooka instance = new Bazooka();
        instance.afschieten(d, veld);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of opgepakt method, of class Bazooka.
     */
    @Test
    public void testOpgepakt() {
        System.out.println("opgepakt");
        Bazooka instance = new Bazooka();
        instance.opgepakt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKogels method, of class Bazooka.
     */
    @Test
    public void testGetKogels() {
        System.out.println("getKogels");
        Bazooka instance = new Bazooka();
        int expResult = 0;
        int result = instance.getKogels();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKogels method, of class Bazooka.
     */
    @Test
    public void testSetKogels() {
        System.out.println("setKogels");
        int _kogels = 0;
        Bazooka instance = new Bazooka();
        instance.setKogels(_kogels);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
