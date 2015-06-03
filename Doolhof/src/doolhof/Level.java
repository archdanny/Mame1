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
    public Grid grid;
    public SpelStat spelstat;
    
    public Level()
    {
       spelstat = new SpelStat();
       spelstat.level = this;
       grid = new Grid();
       grid.makeGrid();
       grid.readGrid();
       
       

    }
    

}
