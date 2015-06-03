/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Danny
 */
public class Muur extends Item
{
     
    private boolean breekbaar;
    
    public Muur()
    {
      image = new  ImageIcon(getClass().getClassLoader().getResource("Images/block.png")).getImage();
      breekbaar =true;
    }
    
      public Muur(boolean d)
    {
        if(d ==true)
        {
           breekbaar = false; 
        }
      image = new  ImageIcon(getClass().getClassLoader().getResource("Images/block.png")).getImage();
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            
            super.paintComponent(g);
            g.drawImage(image, 0, 0, boxSize, boxSize, null, this);

        }
     
     public void destroy(Item item)
     {
          setVisible(false);  
          item = null;
     }
     
     public boolean getBreekbaar()
     {
         return breekbaar;
     }
             
}
