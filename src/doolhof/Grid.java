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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.logging.Logger;
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
    private int boxSize = 20;
    public Veld gridVeld [][];
    private Speler speler;
    private Level level;
    
    public Grid(Level _level)
    {
       
            level = _level;
            Color color = new Color(221, 210,197);
            setBackground(color);
            speler = new Speler();
            speler.keys.speler = speler;
            addKeyListener(speler.keys);
            setFocusable(true);
            requestFocus();
            requestFocusInWindow(true);

    }
    public void resetSpeler()
    {
        remove(speler);
        speler =null;
        speler = new Speler();
        speler.keys.speler = speler;
        addKeyListener(speler.keys);
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
               boxSize = frameHoogte/rows;
             Item.boxSize = boxSize;
    }catch (Exception e) 
    {
        System.out.println(e);
    }      
    }
    
        public void makeGridVelden()
    {
         gridVeld = new Veld[rows][rows];
        
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < rows; j++) 
            {
                Veld veld = new Veld();
                veld.x = j;
                veld.y = i;
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
                gridVeld[i][j].Noord=gridVeld[i-1][j];
                gridVeld[i][j].Zuid = gridVeld[i+1][j];
                gridVeld[i][j].West = gridVeld[i][j-1];
                gridVeld[i][j].Oost = gridVeld[i][j+1];
                gridVeld[i][j].filHash();
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
                    gridVeld[i][j].item = b;
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    b.setBounds(Xposition, Yposition, boxSize, boxSize);
                    add(b);
                }
                 
                if(mapArray[i].substring(j, j+1).equals("w"))
                {
                    Item muur = new Muur();
                    gridVeld[i][j].item = muur;
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    muur.setBounds(Xposition, Yposition, boxSize, boxSize);
                    add(muur);
                }
                
                 if(mapArray[i].substring(j, j+1).equals("h"))
                {
                    Item help = new Helper(this);
                    
                    gridVeld[i][j].item = help;
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    help.huidigeVeld = gridVeld[i][j];
                    help.setBounds(Xposition, Yposition, boxSize, boxSize);
                    add(help);
                }
                  if(mapArray[i].substring(j, j+1).equals("v"))
                {
                    Item vriend = new Vriend();
                    gridVeld[i][j].item = vriend;
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    vriend.setBounds(Xposition, Yposition, boxSize, boxSize);
                    add(vriend);
                }
                  if(mapArray[i].substring(j, j+1).equals("B"))
                {
                    Item bazooka = new Bazooka();
                    gridVeld[i][j].item = bazooka;
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    bazooka.setBounds(Xposition, Yposition, boxSize, boxSize);
                    add(bazooka);
                }
                 if(mapArray[i].substring(j, j+1).equals("g"))
                {
                    gridVeld[i][j].item = null;
                }
                  if(mapArray[i].substring(j, j+1).equals("c"))
                {
                    Cheater cheater = new Cheater();
                   
                    gridVeld[i][j].item = cheater;
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    cheater.setBounds(Xposition, Yposition, boxSize, boxSize);
                    add(cheater);

                }
                 if(mapArray[i].substring(j, j+1).equals("s"))
                 {
                    gridVeld[i][j].item = speler;
                    speler.setBounds(Xposition, Yposition, boxSize, boxSize);
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    speler.huidigeVeld = gridVeld[i][j];
                    repaint();
                 }

                Xposition = Xposition+boxSize;
            }
            Yposition = Yposition +boxSize;
            Xposition = 0;
       }
 
    }
  
}
