/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Spel extends JFrame 
{
    private final int frameHoogte = 600;
    private final int frameBreedte = 670;
    private Level level;
    
    public Spel()
    {
        
        setSize(frameHoogte, frameBreedte);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    }
    
    public void makeComponents()
    {
        level = new Level(listLevels());
        add(level.getSpelstat());
        level.getSpelstat().setBounds(0, 0, 600, 50);
        add(level.getGrid());
        level.getGrid().setBounds(0, 50, 600, 600);
    }
       
    private ArrayList<File> listLevels()
    {
        ArrayList<File> levels = new ArrayList<>();
          try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources("Levels");
            
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                try {
                    Scanner ag = new Scanner((InputStream) url.getContent());
                    while(ag.hasNext())
                    {
                     File file = new File(getClass().getClassLoader().getResource("Levels/" + ag.next() ).getFile());  
                     levels.add(file);
                    }
           
                } catch (IOException ex) {
                    Logger.getLogger(Grid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }   } catch (IOException ex) {
            Logger.getLogger(Grid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
          return levels;
    }
    
}
