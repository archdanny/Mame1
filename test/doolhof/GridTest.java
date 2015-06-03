/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.io.File;
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
public class GridTest {
    
    public GridTest() {
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
     * Test of resetSpeler method, of class Grid.
     */
    @Test
    public void testResetSpeler() {
        System.out.println("resetSpeler");
        Grid instance = null;
        instance.resetSpeler();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLevel method, of class Grid.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        Grid instance = null;
        Level expResult = null;
        Level result = instance.getLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpeler method, of class Grid.
     */
    @Test
    public void testGetSpeler() {
        System.out.println("getSpeler");
        Grid instance = null;
        Speler expResult = null;
        Speler result = instance.getSpeler();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRows method, of class Grid.
     */
    @Test
    public void testGetRows() {
        System.out.println("getRows");
        Grid instance = null;
        int expResult = 0;
        int result = instance.getRows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeGrid method, of class Grid.
     */
    @Test
    public void testMakeGrid() {
        System.out.println("makeGrid");
        File file = null;
        Grid instance = null;
        instance.makeGrid(file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeGridVelden method, of class Grid.
     */
    @Test
    public void testMakeGridVelden() {
        System.out.println("makeGridVelden");
        Grid instance = null;
        instance.makeGridVelden();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IndVeld method, of class Grid.
     */
    @Test
    public void testIndVeld() {
        System.out.println("IndVeld");
        Grid instance = null;
        instance.IndVeld();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readGrid method, of class Grid.
     */
    @Test
    public void testReadGrid() {
        System.out.println("readGrid");
        File file = null;
        Grid instance = null;
        instance.readGrid(file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
