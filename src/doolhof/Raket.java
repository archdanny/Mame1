/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import static doolhof.Direction.Down;
import static doolhof.Direction.Left;
import static doolhof.Direction.Right;
import static doolhof.Direction.Up;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Raket extends Item {
    

    
    private Veld veldCheck;
    private Direction direction;
    private JPanel panel;
    private TimerTask task;
    private  Timer timer;
  
    
    public Raket(Direction d,Veld veld, JPanel panel)
    {
        
        image = new  ImageIcon(getClass().getClassLoader().getResource("Images/raket.png")).getImage();
        huidigeVeld = veld;
        direction =d;
        this.panel = panel;
        veldCheck = getVeldDirection();
        flying();
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            int translateX =0;
            int translateY =0;
            int rotation = 0;
             
             if(direction == Up)
             {
                rotation = 180;
                translateX =30;
                translateY =30;
             }
               if(direction == Left)
             {
                rotation = 90;
                translateX =30;
                translateY =0;
             }
              if(direction == Right)
             {
                 rotation = 270;
                translateX =0;
                translateY =30;
             }
              if(direction == Down)
             {
                rotation = 0;
                translateX =0;
                translateY =0;
             }
              
            super.paintComponent(g);
            Graphics2D g2d=(Graphics2D)g; 
            g2d.translate(translateX, translateY); 
            g2d.rotate(Math.toRadians(rotation)); 
            g2d.drawImage(image, 0, 0, boxSize, boxSize, null,this);
      
        }
     
     
     private Veld getVeldDirection()
     {
            Veld veld;
            veld = huidigeVeld.veldHash.get(direction);
            return veld;
     }

    public void flying()
    {
         if(veldCheck.item instanceof Muur)
             {
                 DestroyVeld();
             }
         else
         {  
                panel.add(this);
                task = new Task();
                timer = new Timer();
                timer.schedule(task, 0, 50);
         }    
    }
    
    public void destroy()
    {
        if(veldCheck.item instanceof Muur)
        {
            if(!DestroyVeld())
            {
            this.setVisible(false);
            panel.remove(this);
            timer.cancel();
            }
        }
        else
        {
        setBounds(huidigeVeld.x * boxSize, huidigeVeld.y * boxSize , boxSize, boxSize);
        huidigeVeld = getVeldDirection();
        veldCheck = getVeldDirection();
        
        this.repaint();
        panel.revalidate();
        panel.repaint();
        }

    }

     public boolean DestroyVeld()
     {
         boolean destroy = false;
          if(veldCheck.item instanceof Muur)
          {
                 Muur m = (Muur)veldCheck.item;
                 if(m.getBreekbaar() == true)
                 {
                    m.destroy(veldCheck.item);
                    veldCheck.item = null;
                 }
                 else
                 {
                    this.setVisible(false);
                    panel.remove(this);
                    timer.cancel();
                    destroy = true;
                 }
          }
          return destroy;
     }
    
     
         public class Task extends TimerTask 
     {
        @Override
        public void run() 
        {
           destroy();
        }
     }
}
