/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Danny
 */
public class Muur extends Item
{
     public Veld huidigeVeld;
    
    public Muur()
    {
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            
            super.paintComponent(g);
               g.setColor(Color.red);
                g.fillRect(0, 0 , 100, 100); 

        }
}
