/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Bazooka extends Item{
    
    private int kogels;
    
    public Bazooka()
    {
      image = new  ImageIcon(getClass().getClassLoader().getResource("Images/bazooka.png")).getImage();
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, boxSize, boxSize, null, this);
        }
     
     public void afschieten(Direction d, Veld veld)
     {
         Container panelContainer = this.getParent();
         JPanel panel = (JPanel)panelContainer;
         if(kogels !=0)
         {
         Raket shoot = new Raket(d,veld,panel);
         kogels --;
         Grid grid = (Grid)panelContainer;
         SpelStat stat = grid.getLevel().getSpelstat();
         stat.aantalKogels(kogels);
         stat.repaint();
         }
     }
     
     public void opgepakt()
     {
         Container panelContainer = this.getParent();
         Grid grid = (Grid)panelContainer;
         SpelStat stat = grid.getLevel().getSpelstat();
         kogels +=3;
         stat.aantalKogels(kogels);
     }
     
     public int getKogels()
     {
        return kogels; 
     }
     
     public void setKogels(int _kogels)
     {
         kogels = _kogels;
     }
     
    
}
