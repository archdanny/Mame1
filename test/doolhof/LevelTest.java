/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

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
public class LevelTest {
    
    public LevelTest() {
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
     * Test of starten method, of class Level.
     */
    @Test
    public void testStarten() {
        System.out.println("starten");
        Level instance = null;
        instance.starten();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of herstarten method, of class Level.
     */
    @Test
    public void testHerstarten() {
        System.out.println("herstarten");
        Level instance = null;
        instance.herstarten();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpelstat method, of class Level.
     */
    @Test
    public void testGetSpelstat() {
        System.out.println("getSpelstat");
        Level instance = null;
        SpelStat expResult = null;
        SpelStat result = instance.getSpelstat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrid method, of class Level.
     */
    @Test
    public void testGetGrid() {
        System.out.println("getGrid");
        Level instance = null;
        Grid expResult = null;
        Grid result = instance.getGrid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volgendeLevel method, of class Level.
     */
    @Test
    public void testVolgendeLevel() {
        System.out.println("volgendeLevel");
        Level instance = null;
        instance.volgendeLevel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
