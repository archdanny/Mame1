/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.Container;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;


/**
 *
 * @author Danny
 */
public class Bazooka extends Item{
    
    private int kogels;
    private int printKogels;
    ArrayList<Raket> raketArray;
    
    public Bazooka()
    {
      setImage(new  ImageIcon(getClass().getClassLoader().getResource("Images/bazooka.png")).getImage());
      raketArray = new ArrayList<>();
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            g.drawImage(getImage(), 0, 0, getBoxsize(), getBoxsize(), null, this);
        }
     
     public void afschieten(Direction d, Veld veld)
     {

         if(kogels <3)
         {
         raketArray.get(kogels).flying(d, veld);
         kogels ++;
         printKogels--;
         }
     }
     
     public void opgepakt()
     {
         kogels =0;
         printKogels= 3;
     }
     
     public int getKogels()
     {
        return kogels; 
     }
     
     public int getPrintKogels()
     {
         return printKogels;
     }
     
     public void setKogels(int _kogels)
     {
         kogels = _kogels;
     }
     
     public ArrayList<Raket> setRakets()
     {
         return raketArray;
     }
     
    
}
