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
public class Speler extends Item implements BeweegE
{
    public Veld huidigeVeld;
    SpelerKey keys;
    public  int x;
    public  int y;
    Grid grid;
    
    public Speler()
    {
        keys = new SpelerKey();
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            
            super.paintComponent(g);
               g.setColor(Color.BLUE);
                g.fillRect(0, 0 , 20, 20); 
                g.setColor(Color.PINK);
                g.fillOval(3, 5, 5, 5);
                g.setColor(Color.PINK);
                g.fillOval(13, 5, 5, 5);
                  g.setColor(Color.PINK);
                g.fillOval(5, 13, 10, 5);
                

        }
     public void moveUp()
     {
         int checkY = huidigeVeld.y -1;
         boolean a = grid.gridVeld[checkY][huidigeVeld.x].muur == null;
         if(a)
         {
            grid.gridVeld[huidigeVeld.y][huidigeVeld.x].speler= null;
            grid.gridVeld[checkY][huidigeVeld.x ].speler = this;
            
            this.huidigeVeld.y = huidigeVeld.y -1;
            
            y = y -20;
            setBounds(x, y , 20, 20);
            repaint(); 
         }
     }
     
     public void moveDown()
     {
         int checkY = huidigeVeld.y +1;
         boolean a = grid.gridVeld[checkY][huidigeVeld.x].muur == null;
         if(a)
         {
            grid.gridVeld[huidigeVeld.y][huidigeVeld.x].speler= null;
            grid.gridVeld[checkY][huidigeVeld.x ].speler = this;

            this.huidigeVeld.y = huidigeVeld.y +1;
            
          y = y +20;
          setBounds(x, y , 20, 20);
          repaint();
         }
          
     }
     public void moveLeft()
     {
          int checkX = huidigeVeld.x -1;
         boolean a = grid.gridVeld[huidigeVeld.y][checkX].muur == null;
         if(a)
         {
             grid.gridVeld[huidigeVeld.y][huidigeVeld.x].speler= null;
            grid.gridVeld[huidigeVeld.y][checkX ].speler = this;
             
            this.huidigeVeld.x = huidigeVeld.x -1;
            x = x -20;
            setBounds(x,y , 20, 20);
            repaint();   
         }
     }
     public void moveRight()
     {
          int checkX = huidigeVeld.x +1;
         boolean a = grid.gridVeld[huidigeVeld.y][checkX].muur == null;
         if(a)
         {
              grid.gridVeld[huidigeVeld.y][huidigeVeld.x].speler= null;
            grid.gridVeld[huidigeVeld.y][checkX ].speler = this;
            
             this.huidigeVeld.x = huidigeVeld.x +1;
         x = x +20;
        setBounds(x,y , 20, 20);
        repaint();   
         }
         
     }
}
