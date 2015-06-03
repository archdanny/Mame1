/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

/**
 *
 * @author Danny
 */
public class Level 
{
    private int score;
    private Grid grid;
    private SpelStat spelstat;
    
    public Level()
    {
       spelstat = new SpelStat();
       spelstat.level = this;
       grid = new Grid(this);
       grid.makeGrid();
       grid.makeGridVelden();
       grid.readGrid();
       grid.IndVeld();

    }
    
    public void starten()
    {
       grid.requestFocus();
    }
    
    public void herstarten()
    {

        grid.removeAll();
        grid.makeGrid();
        grid.makeGridVelden();
        grid.readGrid();
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

}
