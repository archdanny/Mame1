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
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Speler extends Item implements Beweeg
{
    private Bazooka bazooka;
    protected SpelerKey keys;
    private Direction direction;
    private int stappen;
    

    public Speler()
    {
        keys = new SpelerKey();
        image = new  ImageIcon(getClass().getClassLoader().getResource("Images/player.png")).getImage();
        direction = Down;
        stappen =0;
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            int rotation =0;
            super.paintComponent(g);
            int translateX =0;
            int translateY =0;
             
             if(direction == Up)
             {
                rotation = 180;
                translateX =boxSize;
                translateY =boxSize;
             }
               if(direction == Left)
             {
                rotation = 90;
                translateX =boxSize;
                translateY =0;
             }
              if(direction == Right)
             {
                 rotation = 270;
                translateX =0;
                translateY =boxSize;
             }
              if(direction == Down)
             {
                rotation = 0;
                translateX =0;
                translateY =0;
             }
             
            Graphics2D g2d=(Graphics2D)g; 
            g2d.translate(translateX, translateY); 
            g2d.rotate(Math.toRadians(rotation)); 
            g2d.drawImage(image, 0, 0, boxSize, boxSize, null,this);
           
        }

    @Override
     public void move(Direction d)
     {
        direction = d;
        Veld veld = huidigeVeld.veldHash.get(direction);
        if(veld.item instanceof Muur == false)
            {
            checkItem(veld);
            huidigeVeld =veld;
            setBounds(huidigeVeld.x * boxSize, huidigeVeld.y * boxSize, boxSize, boxSize);
            stappen++;
            stappen();
            }
            repaint(); 
     }
     
     private void stappen()
     {
//        Container panelContainer = this.getParent();
//        Grid grid = (Grid)panelContainer;
//        SpelStat stat = grid.getLevel().getSpelstat();
//        stat.stappenTeller(stappen);
     }
     
   
      private void checkItem(Veld veld)
      {
           if(veld.item instanceof Cheater)
         {
            Cheater cheater = (Cheater) veld.item;
            cheater.cheat();          
            repaint();
            veld.item.setVisible(false);
            veld.item= null;
         }
            if(veld.item instanceof Vriend)
         {
           Vriend vriend = (Vriend) veld.item;
           
           vriend.volgendeLevel();
            veld.item = null;
         }
              if(veld.item instanceof Helper)
         {
            Container panelContainer = this.getParent();
            JPanel panel = (JPanel)panelContainer;
             Helper help = (Helper) veld.item;
             help.setVisible(false);
             help.GetLocation(veld, panel);
             help.roepSetPath();
             veld.item = null;
         }
               if(veld.item instanceof Bazooka)
         {
            bazooka = (Bazooka) veld.item;
            bazooka.opgepakt();
            bazooka.huidigeVeld = huidigeVeld;
            image = new  ImageIcon(getClass().getClassLoader().getResource("Images/playerBazooka.png")).getImage();
            repaint();
            veld.item.setVisible(false);
            veld.item = null;
         }
         if(bazooka != null)
         {
             if(bazooka.getKogels() == 0)
             {
            image = new  ImageIcon(getClass().getClassLoader().getResource("Images/player.png")).getImage();
            resetSpeler();
             }
         }
      }
     
     public void resetSpeler()
     {
        bazooka = null;
        stappen =0;
        image = new  ImageIcon(getClass().getClassLoader().getResource("Images/player.png")).getImage();  
     }
     
     public void schieten()
     {
         if(bazooka != null)
         {
             if(bazooka.getKogels() == 0)
             {
                 resetSpeler();
             }
             else
             {
            bazooka.afschieten(direction, huidigeVeld);
             }
         }
 
     }  
  
}
