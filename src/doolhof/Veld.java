/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.util.HashMap;

/**
 *
 * @author Danny
 */
public class Veld 
{
    private int x;
    private int y;
    private Item item;
    private HashMap<Direction, Veld> buurMap;
    
    public Veld()
        {
            buurMap = new HashMap<>();
        }
    public void fillBuurMap(Veld Noord, Veld Zuid, Veld West, Veld Oost)
    {
            buurMap.put(Direction.Up, Noord);
            buurMap.put(Direction.Down, Zuid);  
            buurMap.put(Direction.Left, West);  
            buurMap.put(Direction.Right, Oost); 
    }
    public void setItem(Item _item)
    {
       item = _item; 
       item.setVeld(this);
    }
    
    public void setLeeg()
    {
         item = null; 
    }
    
    public Item getItem()
    {
        return item;
    }
    
    public HashMap<Direction, Veld> getBuurMap()
    {
       return buurMap;
    }
    
    public void setX(int _x)
    {
        x = _x;
    }
     public void setY(int _y)
    {
       y = _y;
    }
     
     public int getX()
     {
         return x;
     }
     
        public int getY()
     {
         return y;
     }
   
}
