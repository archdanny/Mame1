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
public class SpelStatTest {
    
    public SpelStatTest() {
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
     * Test of stappenTeller method, of class SpelStat.
     */
    @Test
    public void testStappenTeller() {
        System.out.println("stappenTeller");
        int stappen = 0;
        SpelStat instance = new SpelStat();
        instance.stappenTeller(stappen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aantalKogels method, of class SpelStat.
     */
    @Test
    public void testAantalKogels() {
        System.out.println("aantalKogels");
        int kogels = 0;
        SpelStat instance = new SpelStat();
        instance.aantalKogels(kogels);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
