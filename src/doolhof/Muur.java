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
    
    public Muur()
    {
        setImage(new  ImageIcon(getClass().getClassLoader().getResource("Images/block.png")).getImage());
      breekbaar =true;
    }
    
      public Muur(boolean d)
    {
        if(d ==true)
        {
           breekbaar = false; 
        }
        setImage( new  ImageIcon(getClass().getClassLoader().getResource("Images/block.png")).getImage());
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            g.drawImage(getImage(), 0, 0, getBoxsize(), getBoxsize(), null, this);

        }
     
     public void destroy(Item _item)
     {
          setVisible(false);  
          _item = null;
     }
     
     public boolean getBreekbaar()
     {
         return breekbaar;
     }
             
}
