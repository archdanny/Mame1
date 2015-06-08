/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Grid extends JPanel
{
    private final int frameHoogte = 600;
    private final int frameBreedte = 600;
    private int rows = 20;
    private Veld gridVeld [][];
    private Speler speler;
    private Level level;
    
    public Grid(Level _level)
    {
       
            level = _level;
            Color color = new Color(221, 210,197);
            setBackground(color);
            speler = new Speler();
            speler.getSpelerKeys().setSpeler(speler);
            speler.getSpelerKeys().setLevel(level);
            addKeyListener(speler.getSpelerKeys());
            setFocusable(true);
            requestFocus();
            requestFocusInWindow(true);

    }
    public void resetSpeler()
    {
        speler.resetSpeler();
        remove(speler);
        speler =null;
        speler = new Speler();
        speler.getSpelerKeys().setSpeler(speler);
        speler.getSpelerKeys().setLevel(level);
        addKeyListener(speler.getSpelerKeys());
    }
    
    public Veld [][] getGrid()
    {
        return gridVeld;
    }
    
    public Level getLevel()
    {
        return level;
    }
    
     public Speler getSpeler()
    {
        return speler;
    }

    public int getRows()
    {
        return rows;
    }
    
    public void makeGrid(File file)
    {
        add(speler);
        setSize(frameHoogte, frameBreedte);
        setLayout(null);
           String  length = new String();
            FileInputStream fis;
             try {

               fis = new FileInputStream(file);
                
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                      length = br.readLine();
                rows = length.length();
              int boxSize = frameHoogte/rows;
             Item.setBoxSize(boxSize);
    }catch (Exception e) 
    {
        System.out.println(e);
    }
             makeGridVelden();
    }
    
        public void makeGridVelden()
    {
         gridVeld = new Veld[rows][rows];
        
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < rows; j++) 
            {
                Veld veld = new Veld();
                veld.setX(j);
                veld.setY(i);
                gridVeld[i][j] = veld;
            }
        }
        
    }
        
        public void IndVeld()
        {
             
        for (int i = 1; i < rows -1; i++) 
        {
            for (int j = 1; j < rows -1; j++) 
            { 
            gridVeld[i][j].fillBuurMap(gridVeld[i-1][j],gridVeld[i+1][j],gridVeld[i][j-1],gridVeld[i][j+1]);
            }
        } 
        }

        public void readGrid(File file)
        {
           String [] mapArray = new String[rows];

           FileInputStream fis;
           
            try {
               fis = new FileInputStream(file);
                
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                for (int i = 0; i < rows; i++) 
                {
                      mapArray[i] = br.readLine();
                }
                
            } catch (Exception e) 
            {
                System.out.println(e);
            }
            int Xposition = 0;
            int Yposition = 0;
        
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < rows; j++) 
            {
                 if(mapArray[i].substring(j, j+1).equals("b"))
                {
                    Item b = new Muur(true);
                    b.setVeld(gridVeld[i][j]);
                    gridVeld[i][j].setItem(b);
                    b.setBounds(Xposition, Yposition, Item.getBoxsize(), Item.getBoxsize());
                    add(b);
                }
                 
                if(mapArray[i].substring(j, j+1).equals("w"))
                {
                    Item muur = new Muur(false);
                    gridVeld[i][j].setItem(muur);
                    muur.setBounds(Xposition, Yposition, Item.getBoxsize(), Item.getBoxsize());
                    add(muur);
                }
                
                 if(mapArray[i].substring(j, j+1).equals("h"))
                {
                    Item help = new Helper(this);
                    
                    gridVeld[i][j].setItem(help);
                    help.setVeld(gridVeld[i][j]);
                    help.setBounds(Xposition, Yposition, Item.getBoxsize(), Item.getBoxsize());
                    add(help);
                }
                  if(mapArray[i].substring(j, j+1).equals("v"))
                {
                    Item vriend = new Vriend();
                    gridVeld[i][j].setItem(vriend);

                    vriend.setBounds(Xposition, Yposition, Item.getBoxsize(), Item.getBoxsize());
                    add(vriend);
                }
                  if(mapArray[i].substring(j, j+1).equals("B"))
                {
                    Bazooka bazooka = new Bazooka();
                    for (int k = 0; k < 3; k++) {
                        Raket raket = new Raket();
                        add(raket);
                        bazooka.setRakets().add(raket);
                    }
                    Item bazookaI = (Item) bazooka;
                    gridVeld[i][j].setItem(bazookaI);
                    bazookaI.setBounds(Xposition, Yposition, Item.getBoxsize(), Item.getBoxsize());
                    add(bazookaI);
                }
                 if(mapArray[i].substring(j, j+1).equals("g"))
                {
                    gridVeld[i][j].setItem(null);
                }
                  if(mapArray[i].substring(j, j+1).equals("c"))
                {
                    Cheater cheater = new Cheater();
                   
                    gridVeld[i][j].setItem(cheater);
                    add(cheater);
                    cheater.setBounds(Xposition, Yposition, Item.getBoxsize(), Item.getBoxsize());
                   

                }
                 if(mapArray[i].substring(j, j+1).equals("s"))
                 {
                    gridVeld[i][j].setItem(speler);
                    speler.setBounds(Xposition, Yposition, Item.getBoxsize(), Item.getBoxsize());
                    speler.setVeld(gridVeld[i][j]);
                 }

                Xposition = Xposition+Item.getBoxsize();
            }
            Yposition = Yposition +Item.getBoxsize();
            Xposition = 0;
       }
 
    }
  
}
