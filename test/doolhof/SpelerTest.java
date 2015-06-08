/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import static doolhof.Direction.Up;
import static doolhof.Direction.Down;
import static doolhof.Direction.Left;
import static doolhof.Direction.Right;
import static org.junit.Assert.assertEquals;
import org.junit.*;

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
     * Test of move method With a direction 
     */
    @Test
    public void testMoveMethod() {

        Direction direction = Right;
        Speler instance = new Speler();
        
        Veld veld = new Veld();
        
        Veld Noord = new Veld();
        Veld Zuid = new Veld();
        Veld West = new Veld();
        Veld Oost = new Veld();

        veld.fillBuurMap(Noord, Zuid, West ,Oost);
 
        instance.setVeld(veld);
        instance.move(direction);
        assertEquals(instance.getVeld(), Oost);
    }
    
    
       @Test
    public void testOldVeld() {

        Direction direction = Up;
        Speler instance = new Speler();
        
        Veld veld = new Veld();
        
        Veld Noord = new Veld();
        Veld Zuid = new Veld();
        Veld West = new Veld();
        Veld Oost = new Veld();

        veld.fillBuurMap(Noord, Zuid, West ,Oost);
 
        instance.setVeld(veld);
        instance.move(direction);
        assertEquals(veld.getItem(), null);
    }
    
      @Test
    public void testMoveWall() {

        Direction direction = Up;
        Speler instance = new Speler();
        
        Veld veld = new Veld();
        
        Veld Noord = new Veld();
        Muur muur = new Muur(false);
        Noord.setItem(muur);
        Veld Zuid = new Veld();
        Veld West = new Veld();
        Veld Oost = new Veld();

        veld.fillBuurMap(Noord, Zuid, West ,Oost);
 
        instance.setVeld(veld);
        instance.move(direction);
        assertEquals(instance.getVeld(), veld);
        
    }
    
    
     
      @Test
    public void testBazookaPickUp() {

        Direction direction = Up;
        Speler instance = new Speler();
        
        Veld veld = new Veld();
        
        Veld Noord = new Veld();
        Bazooka bazooka = new Bazooka();
        Noord.setItem(bazooka);
        Veld Zuid = new Veld();
        Veld West = new Veld();
        Veld Oost = new Veld();

        veld.fillBuurMap(Noord, Zuid, West ,Oost);
 
        instance.setVeld(veld);
        instance.move(direction);
        assertEquals(instance.getBazooka(), bazooka);
        
    }


}
