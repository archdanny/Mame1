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
      protected Veld huidigeVeld;
      protected Image image;
      public static int boxSize;
      
    
    @Override
     public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            
        }  
}
