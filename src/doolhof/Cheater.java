/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;


import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Mehmet
 */
public class Cheater extends Item {
   
//     public Task task;

    
    public Cheater()
    {
         image = new  ImageIcon(getClass().getClassLoader().getResource("Images/cheater.png")).getImage();
    }
    public void cheat(){
         Container panelContainer = this.getParent();
         Grid grid = (Grid)panelContainer;
         SpelStat stat =grid.level.getSpelstat();
         int cheat = 20;
         stat.stappenTeller(cheat);
         stat.repaint();
    }
    
    @Override
     public void paintComponent(Graphics g) 
        {
            
            super.paintComponent(g);
            
                    Graphics2D g2d=(Graphics2D)g; 
            g2d.drawImage(image, 0, 0, boxSize, boxSize, null,this);
        }
     
    
}