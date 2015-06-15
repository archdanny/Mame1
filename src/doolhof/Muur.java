/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;


import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Danny
 */
public class Muur extends Item
{
     
    private boolean breekbaar;
    
      public Muur(boolean d)
    {
        if(d ==true)
        {
           breekbaar = false; 
        }
           if(d ==false)
        {
           breekbaar = true; 
        }
        setImage( new  ImageIcon(getClass().getClassLoader().getResource("Images/block.png")).getImage());
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            g.drawImage(getImage(), 0, 0, getBoxsize(), getBoxsize(), null, this);
        }

     public boolean getBreekbaar()
     {
        return breekbaar;
     }
             
}
