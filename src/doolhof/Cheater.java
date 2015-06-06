/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;



import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;


/**
 *
 * @author Mehmet
 */
public class Cheater extends Item {
   
//     public Task task;
    private final int stappenMin = 20;
    
    public Cheater()
    {
         setImage(new  ImageIcon(getClass().getClassLoader().getResource("Images/cheater.png")).getImage());
    }
    public int cheat(int stappen)
    {
         return stappen + stappenMin;
    }
    
    @Override
     public void paintComponent(Graphics g) 
        {
            
            super.paintComponent(g);
            Graphics2D g2d=(Graphics2D)g; 
            g2d.drawImage(getImage(), 0, 0, getBoxsize(), getBoxsize(), null,this);
        }
     
    
}