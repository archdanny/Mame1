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
public class NodeTest {
    
    public NodeTest() {
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
     * Test of getHCost method, of class Node.
     */
    @Test
    public void testGetHCost() {
        System.out.println("getHCost");
        Veld targetVeld = null;
        Node instance = null;
        int expResult = 0;
        int result = instance.getHCost(targetVeld);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGCost method, of class Node.
     */
    @Test
    public void testGetGCost() {
        System.out.println("getGCost");
        Veld StartNode = null;
        Node instance = null;
        int expResult = 0;
        int result = instance.getGCost(StartNode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFCost method, of class Node.
     */
    @Test
    public void testGetFCost() {
        System.out.println("getFCost");
        Veld StartNode = null;
        Veld targetVeld = null;
        Node instance = null;
        int expResult = 0;
        int result = instance.getFCost(StartNode, targetVeld);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verschilBuur method, of class Node.
     */
    @Test
    public void testVerschilBuur() {
        System.out.println("verschilBuur");
        Veld buur = null;
        Node instance = null;
        int expResult = 0;
        int result = instance.verschilBuur(buur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeList method, of class Node.
     */
    @Test
    public void testMakeList() {
        System.out.println("makeList");
        Node instance = null;
        instance.makeList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
