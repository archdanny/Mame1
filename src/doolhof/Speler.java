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
import javax.swing.ImageIcon;

/**
 *
 * @author Danny
 */
public class Speler extends Item implements Beweeg
{
    private Bazooka bazooka;
    private GameKey keys;
    private Direction direction;
    private int stappen;
    

    public Speler()
    {
        keys = new GameKey();
        setImage(new  ImageIcon(getClass().getClassLoader().getResource("Images/player.png")).getImage());
        direction = Down;
        stappen =0;
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            setBounds(getVeld().getX() * getBoxsize(), getVeld().getY() * getBoxsize(), getBoxsize(), getBoxsize());
            int rotation =0;
            super.paintComponent(g);
            int translateX =0;
            int translateY =0;
             
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
             
            Graphics2D g2d=(Graphics2D)g; 
            g2d.translate(translateX, translateY); 
            g2d.rotate(Math.toRadians(rotation)); 
            g2d.drawImage(getImage(), 0, 0, getBoxsize(), getBoxsize(), null,this);
           
        }

    @Override
     public void move(Direction d)
     {
        direction = d;
        Veld veld = getVeld().getBuurMap().get(direction);
        if(veld.getItem()  instanceof Muur == false)
            {
            checkItem(veld);
            setVeld(veld);
            stappen++;
            }
          
     }
     
     public int getStappen()
     {
         return stappen;
     }

     
   
      private void checkItem(Veld veld)
      {
           if(veld.getItem()  instanceof Cheater)
         {
            Cheater cheater = (Cheater) veld.getItem() ;
            stappen = cheater.cheat(stappen);          
            removeItem(veld);
         }
            if(veld.getItem()  instanceof Vriend)
         {
           Vriend vriend = (Vriend) veld.getItem() ;
           resetSpeler();
           vriend.volgendeLevel();
           removeItem(veld);
         }
              if(veld.getItem()  instanceof Helper)
         {
             Helper help = (Helper) veld.getItem() ;
             help.GetLocation();
             removeItem(veld);
         }
               if(veld.getItem()  instanceof Bazooka)
         {
            bazooka = (Bazooka) veld.getItem();
            bazooka.opgepakt();
            bazooka.setVeld(getVeld());
            setImage(new  ImageIcon(getClass().getClassLoader().getResource("Images/playerBazooka.png")).getImage());
            repaint();
            removeItem(veld);
         }
         if(bazooka != null)
         {
             if(bazooka.getKogels() == 3)
             {
                resetSpeler();
             }
         }
      }
      
     public void removeItem(Veld _veld)
     {
         _veld.getItem() .setVisible(false);
         _veld.setItem(null);
     }
     
     public void resetSpeler()
     {
        bazooka = null;
        stappen =0;
        setImage(new  ImageIcon(getClass().getClassLoader().getResource("Images/player.png")).getImage()); 
     }
     
     public void schieten()
     {
         if(bazooka != null)
         {
             if(bazooka.getKogels() == 3)
             {
                 resetSpeler();
             }
             else
             {
            bazooka.afschieten(direction, getVeld());
             }
         }
 
     }
     
     public void setSpelerKeys(GameKey _keys)
     {
         keys = _keys;
     }
     
      public GameKey getSpelerKeys()
     {
         return keys;
     }
     
      public Bazooka getBazooka()
      {
          return bazooka;
      }
  
}
