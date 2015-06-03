/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import doolhof.SpelStat.Task;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Mehmet
 */
public class Cheater extends Item {
   
     public Task task;

    public void cheat(){
        int cheat = 20;
     task.countdown -= cheat;
    }
    
    @Override
     public void paintComponent(Graphics g) 
        {
            
            super.paintComponent(g);
            
               g.setColor(Color.red);
                g.fillRect(0, 0 , 100, 100); 
                g.drawImage(image, 0, 0, boxSize, boxSize, null, this);

        }
}