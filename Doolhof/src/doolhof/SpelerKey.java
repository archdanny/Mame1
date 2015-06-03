/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author Danny
 */
public class SpelerKey implements KeyListener {
    
    Speler speler;
    
    public SpelerKey()
    {
       
    }
    
    @Override
        public void keyTyped(KeyEvent e) {


        }

        @Override
        public void keyPressed(KeyEvent e) {
                
            
            if(e.getKeyCode() == KeyEvent.VK_UP)
             {
                 
                 speler.moveUp();
  
            }
            
            if(e.getKeyCode() == KeyEvent.VK_DOWN)
             {
                speler.moveDown();
            }
                       
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
             {
                 speler.moveLeft();
            }
                        
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
             {
                speler.moveRight();
            }
           
        }

        @Override
        public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_R)
             {
   
            }
  
        }
 
    
}
