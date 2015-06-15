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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;


/**
 *
 * @author Danny
 */
public class Raket extends Item {

    private Direction direction;
    private TimerTask task;
    private  Timer timer;

    public Raket()
    { 
        setImage(new  ImageIcon(getClass().getClassLoader().getResource("Images/raket.png")).getImage());
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
                translateX =getBoxsize();
                translateY =getBoxsize();
             }
               if(direction == Left)
             {
                rotation = 90;
                translateX =getBoxsize();
                translateY =0;
             }
              if(direction == Right)
             {
                 rotation = 270;
                translateX =0;
                translateY =getBoxsize();
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
            g2d.drawImage(getImage(), 0, 0, getBoxsize(), getBoxsize(), null,this);
            
      
        }

    public void flying(Direction d,Veld veld)
    {
        setVeld(veld);
        direction =d;
        task = new Task();
        timer = new Timer();
        timer.schedule(task, 0, 50);
    }
    
         
     private Veld getVeldDirection()
     {
            Veld veld;
            veld = getVeld().getBuurMap().get(direction);
            return veld;
     }
    
    public void destroyCheck()
    {
         Veld veldCheck = getVeldDirection();
        if(veldCheck.getItem()  instanceof Muur)
        {
            if(!DestroyVeld(veldCheck))
            {
            this.setVisible(false);
            timer.cancel();
            }
        }
        else
        {
        setBounds(getVeld().getX() * getBoxsize(), getVeld().getY() * getBoxsize() , getBoxsize(), getBoxsize());
        setVeld(getVeldDirection());
        }

    }

     public boolean DestroyVeld(Veld veld)
     {
         boolean destroy = false;
         
          if(veld.getItem() instanceof Muur)
          {
                 Muur m = (Muur)veld.getItem() ;
                 if(m.getBreekbaar() == true)
                 {
                    m.destroy();
                 }
                 else
                 {
                    this.setVisible(false);
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
           destroyCheck();
        }
     }
}
