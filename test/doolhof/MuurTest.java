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
public class MuurTest {
    
    public MuurTest() {
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
     * Test of paintComponent method, of class Muur.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        Muur instance = new Muur(false);
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class Muur.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy");
        Item item = null;
        Muur instance = new Muur(false);
        instance.destroy(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBreekbaar method, of class Muur.
     */
    @Test
    public void testGetBreekbaar() {
        System.out.println("getBreekbaar");
        Muur instance = new Muur(false);
        boolean expResult = false;
        boolean result = instance.getBreekbaar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
