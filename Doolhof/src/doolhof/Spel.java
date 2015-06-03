/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Spel extends JFrame 
{
    private final int frameHoogte = 400;
    private final int frameBreedte = 470;
    public Level level;
    
    public Spel()
    {
        
        setSize(frameHoogte, frameBreedte);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    }
    
    public void makeComponents()
    {
        level = new Level();
        add(level.spelstat);
        level.spelstat.setBounds(0, 0, 400, 50);
        add(level.grid);
        level.grid.setBounds(0, 50, 400, 400);

    }
           
}
