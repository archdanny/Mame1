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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javax.swing.JPanel;
import sun.security.util.Resources;

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
    private int colum = 20;
    public Veld gridVeld [][];
    public Speler speler;
    public Level level;
    
    public Grid()
    {
       speler = new Speler();
       add(speler);          
       speler.keys.speler = speler;
       addKeyListener(speler.keys);
       setFocusable(true);
       requestFocus();
       requestFocusInWindow(true);
    }

    public void makeLength()
    {
            String  length = new String();
            File file;
            FileInputStream fis;
             try {
            file = new File(getClass().getClassLoader().getResource("Levels/levelDos.txt").getFile());
           
               fis = new FileInputStream(file);
                
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));

               
                      length = br.readLine();
               
                int i = length.length();

                rows = i;
               boxSize = frameHoogte/rows;
             Item.boxSize = boxSize;
    }catch (Exception e) 
    {
        System.out.println(e);
    }
             
        }
    
    public int getRows()
    {
        return rows;
    }
    
    public void makeGrid()
    {
        add(speler);
        speler.resetSpeler();
        setSize(frameHoogte, frameBreedte);
        setLayout(null);
        //speler = null;
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
        
        public Speler getSpeler()
        {
            return speler;
        }
         public void readGrid()
        {
           String [] mapArray = new String[rows];
           File file;
           FileInputStream fis;

            try {
               
               file = new File(getClass().getClassLoader().getResource("Levels/levelDos.txt").getFile());
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
                    b.boxSize = boxSize;
                    gridVeld[i][j].item = b;
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    b.setBounds(Xposition, Yposition, boxSize, boxSize);
                    add(b);
                }
                 
                if(mapArray[i].substring(j, j+1).equals("w"))
                {
                    Item muur = new Muur();
                    muur.boxSize = boxSize;
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
                     help.boxSize = boxSize;
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    help.setBounds(Xposition, Yposition, boxSize, boxSize);
                    add(help);
                }
                  if(mapArray[i].substring(j, j+1).equals("v"))
                {
                    Item vriend = new Vriend();
                     vriend.boxSize = boxSize;
                    gridVeld[i][j].item = vriend;
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    vriend.setBounds(Xposition, Yposition, boxSize, boxSize);
                    add(vriend);
                }
                  if(mapArray[i].substring(j, j+1).equals("B"))
                {
                    Item bazooka = new Bazooka();
                     bazooka.boxSize = boxSize;
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
                     cheater.boxSize = boxSize;
                    //cheater.task = level.getSpelstat().task;
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    cheater.setBounds(Xposition, Yposition, boxSize, boxSize);
                    add(cheater);

                }
                 if(mapArray[i].substring(j, j+1).equals("s"))
                 {
                    gridVeld[i][j].item = speler;
                     speler.boxSize = boxSize;
                    speler.setBounds(Xposition, Yposition, boxSize, boxSize);
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    speler.huidigeVeld = gridVeld[i][j];
                 }

                Xposition = Xposition+boxSize;
            }
            Yposition = Yposition +boxSize;
            Xposition = 0;
       }
 
    }
         
          public void leegGrid()
    {
        for (int i = 1; i < rows -1; i++) 
        {
            for (int j = 1; j < rows -1; j++) 
            { 
                gridVeld[i][j].item = null;
            }
        }
    }
  
}
