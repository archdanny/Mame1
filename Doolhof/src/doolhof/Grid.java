/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Grid extends JPanel
{
    private final int frameHoogte = 400;
    private final int frameBreedte = 400;
    private int rows = 20;
    private int colum = 20;
    public Veld gridVeld [][];
    Speler speler;
    
    public Grid()
    {
        setSize(frameHoogte, frameBreedte);
        setLayout(null);
        speler = new Speler();
    }
    
    
        public void makeGrid()
    {
         gridVeld = new Veld[rows][colum];
        
        for (int i = 0; i < 20; i++) 
        {
            for (int j = 0; j < 20; j++) 
            {
                Veld veld = new Veld();
                gridVeld[i][j] = veld;
            }
            
        }
        
    }
        
         public void readGrid()
        {
            String w = "w";
            String g = "g";
            String s = "s";
            
            String [][] myArray = new String[][]{
        {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w},
        {w, s, w, g, w, g, g, g, w, g, g, g, w, g, g, g, g, g, g, w},
        {w, g, w, g, w, g, w, g, w, g, w, g, w, g, w, w, w, w, g, w},
        {w, g, w, g, w, g, w, g, w, g, w, g, w, g, w, g, g, g, g, w},
        {w, g, g, g, w, g, w, g, g, g, w, g, w, g, w, w, g, w, w, w},
        {w, w, w, g, w, g, w, w, w, w, w, g, w, g, g, w, g, w, g, w},
        {w, g, w, g, w, g, g, g, g, g, g, g, w, w, g, w, g, w, g, w},
        {w, g, w, g, w, g, w, w, w, w, w, g, g, w, g, w, g, w, g, w},
        {w, g, w, g, w, g, g, g, g, g, w, w, g, w, g, w, g, w, g, w},
        {w, g, w, g, w, w, w, w, w, g, g, w, g, w, g, w, g, w, g, w},
        {w, g, w, g, w, g, g, g, w, w, g, w, g, g, g, w, g, w, g, w},
        {w, g, g, g, w, g, w, g, g, g, g, w, g, w, g, g, g, w, g, w},
        {w, g, w, w, w, g, w, w, w, w, g, w, g, w, g, g, w, w, g, w},
        {w, g, w, g, g, g, g, g, g, w, g, w, g, w, w, g, w, g, g, w},
        {w, g, w, g, w, w, w, w, g, w, g, w, g, g, w, g, w, g, g, w},
        {w, g, w, g, g, g, g, w, g, w, g, w, w, g, w, g, w, g, g, w},
        {w, g, w, w, w, w, g, w, g, w, g, g, w, g, w, g, w, g, g, w},
        {w, g, g, g, g, g, g, w, g, w, w, g, w, g, w, g, w, w, g, w},
        {w, g, g, g, g, g, g, w, g, g, g, g, w, g, w, g, g, g, g, w},
        {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w}};
            
            
            int Xposition = 0;
        int Yposition = 0;
        
        for (int i = 0; i < 20; i++) 
        {
            
            for (int j = 0; j < 20; j++) 
            {
                if(myArray[i][j].equals("w"))
                {
                    Muur m = new Muur();
                    gridVeld[i][j].muur = m;
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    
                    m.setBounds(Xposition, Yposition, 20, 20);
                    add(m);
                }
                 if(myArray[i][j].equals("g"))
                {
                    gridVeld[i][j].muur = null;
                    gridVeld[i][j].speler =null;
                
                }
                 if(myArray[i][j].equals("s"))
                 {
                     
                     gridVeld[i][j].speler = speler;
                     speler.x = Xposition;
                     speler.y = Yposition;
                     speler.setBounds(speler.x, speler.y, 20, 20);
                      gridVeld[i][j].y = i;
                        gridVeld[i][j].x = j;
                     speler.huidigeVeld = gridVeld[i][j];
                     add(speler);
                       
                        speler.keys.speler = speler;
                        addKeyListener(speler.keys);
                        setFocusable(true);
                        requestFocus();
                        requestFocusInWindow(true);
                 }

                Xposition = Xposition+20;
            }
            Yposition = Yposition +20;
            Xposition = 0;
       }
       
        speler.grid = this;
    }
         
          
    
    
}
