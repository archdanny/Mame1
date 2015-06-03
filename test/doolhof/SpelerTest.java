/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import static doolhof.Direction.Up;
import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Danny
 */
public class SpelerTest {
    
    public SpelerTest() {
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
     * Test of paintComponent method, of class Speler.
     */
//    @Test
//    public void testPaintComponent() {
//        System.out.println("paintComponent");
//        Graphics g = null;
//        Speler instance = new Speler();
//        instance.paintComponent(g);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of move method, of class Speler.
     */
    @Test
    public void testMove() {
        

        Direction direction = Up;
        Speler instance = new Speler();
        
        Veld veld = new Veld();
        Veld Noord = new Veld();

        veld.Noord = Noord;
        Veld Zuid = new Veld();

        veld.Zuid = Zuid;
        Veld West = new Veld();

        veld.West = West;
        Veld Oost = new Veld();

        veld.Oost =Oost;
        veld.filHash();
 

        instance.huidigeVeld = veld;
        instance.move(direction);
        assertEquals(instance.huidigeVeld, Zuid);
    }

//    /**
//     * Test of resetSpeler method, of class Speler.
//     */
//    @Test
//    public void testResetSpeler() {
//        System.out.println("resetSpeler");
//        Speler instance = new Speler();
//        instance.resetSpeler();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of schieten method, of class Speler.
//     */
//    @Test
//    public void testSchieten() {
//        System.out.println("schieten");
//        Speler instance = new Speler();
//        instance.schieten();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
