/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import javax.swing.JComponent;

/**
 *
 * @author Danny
 */
public abstract class Item extends JComponent
{
      private Veld huidigeVeld;
      private Image image;
      private static int boxSize;
      
    
    @Override
     public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            
        }  
     public void setVeld(Veld veld)
     {
         huidigeVeld = veld;
     }
     
     public Veld getVeld()
     {
         return huidigeVeld;
     }
     
     public static void setBoxSize(int size)
     {
         boxSize = size;
     }
     
     public int getBoxsize()
     {
         return boxSize;
     }
     
     public void setImage(Image _image)
     {
       image =  _image; 
     }
     
     public Image getImage()
     {
         return image;
     }
}
