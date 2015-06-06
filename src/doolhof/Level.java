/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Danny
 */
public class Level 
{
    private int levelNum;
    private Grid grid;
    private SpelStat spelstat;
    private ArrayList<File> levels;
    
    public Level(ArrayList<File> _levels)
    {
       levels = _levels;
       levelNum =0;
       spelstat = new SpelStat();
       spelstat.setLevel(this);
       grid = new Grid(this);
       grid.makeGrid(levels.get(levelNum));
       grid.readGrid(levels.get(levelNum));
       grid.IndVeld();

    }
    
    public void starten()
    {
       grid.requestFocus();
    }
    
    public void herstarten()
    {
        grid.removeAll();
        grid.resetSpeler();
        grid.makeGrid(levels.get(levelNum));
        grid.readGrid(levels.get(levelNum));
        grid.IndVeld();
        grid.repaint();

    }
    
    public SpelStat getSpelstat()
    {
        return spelstat;
    }
    
    public Grid getGrid()
    {
        return grid;
    }
    
    public void volgendeLevel()
    {
        if(levelNum < levels.size()-1)
        {
        levelNum ++;
        herstarten();
        }
    }
}
