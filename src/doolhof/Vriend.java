/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Danny
 */
public class Vriend extends Item {
   
    
      @Override
     public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
             Graphics2D g2d=(Graphics2D)g; 
           
            g2d.drawImage(image, 0, 0, boxSize, boxSize, null,this);
        }
    public Vriend()
    {
        
        image = new  ImageIcon(getClass().getClassLoader().getResource("Images/vriend.png")).getImage();
    }
}
