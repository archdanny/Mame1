/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;


import static doolhof.Direction.Down;
import static doolhof.Direction.Left;
import static doolhof.Direction.Right;
import static doolhof.Direction.Up;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author Danny
 */
public class GameKey implements KeyListener {
    
    private Speler speler;
    private Level level;
    
    public GameKey()
    {
       
    }
    
    @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
                
            
            if(e.getKeyCode() == KeyEvent.VK_UP)
            {
                 speler.move(Up);
            }
           
            if(e.getKeyCode() == KeyEvent.VK_DOWN)
                {
                speler.move(Down);
                }
                       
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
             {
                 speler.move(Left);
            }
                        
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
             {
                speler.move(Right);
            }
             if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                speler.schieten();
            }
           refresh();
        }

        @Override
        public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_R)
             {
   
            }
  
        }
        
        public void setSpeler(Speler _speler)
        {
            speler = _speler;
        }
        
        public void setLevel(Level _level)
        {
            level = _level;
        }
        
        public void refresh()
        {
           speler.repaint();
           level.getSpelstat().stappenTeller(speler.getStappen());
           if (speler.getBazooka() != null)
           {
           level.getSpelstat().aantalKogels(speler.getBazooka().getPrintKogels());
           }
           else
           {
               level.getSpelstat().aantalKogels(0);
           }
           level.getSpelstat().repaint();
           
        }
    
}
