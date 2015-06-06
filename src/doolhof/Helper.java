/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;



import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Helper extends Item{

    private TimerTask task;
    private  Timer timer;
    private int rotation;
    private Grid grid;
    private Node lastNode;
    
      
    public Helper(Grid gridGet)
    {
        setImage(new  ImageIcon(getClass().getClassLoader().getResource("Images/helper.png")).getImage());
      task = new Task();
      timer = new Timer();
      rotation=90;
      timer.schedule(task, 0, 200);
      grid = gridGet;
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
                 int translateX =0;
            int translateY =0;
            if(rotation == 180)
             {
                 
                translateX =getBoxsize();
                translateY =getBoxsize();
             }
               if(rotation == 90)
             {
              
                translateX =getBoxsize();
                translateY =0;
             }
              if(rotation == 270)
             {
             
                translateX =0;
                translateY =getBoxsize();
             }
              if(rotation == 0)
             {
               
                translateX =0;
                translateY =0;
             }
            
            super.paintComponent(g);
            Graphics2D g2d=(Graphics2D)g; // Create a Java2D version of g.
            g2d.translate(translateX, translateY); // Translate the center of our coordinates.
            g2d.rotate(Math.toRadians(rotation));  // Rotate the image by 1 radian.
            g2d.drawImage(getImage(), 0, 0, getBoxsize(), getBoxsize(), null,this);

        }
     
     private void Rotation()
     {
         if(rotation > 270)
         {
             rotation = 90;
         }
         else
         {
           rotation = rotation + 90;   
         }
         repaint();
     }
        
     
     
     private class Task extends TimerTask {


        @Override
        public void run() 
        {
           Rotation();
        }
    
     }
     
     public void GetLocation()
     {

        Node  playerPos= new Node(getVeld());
        Node current = null;
        Node target = null;
        Node [][] nodeList = new Node[grid.getRows()][grid.getRows()];
        ArrayList<Node> listOpen = new ArrayList<>();
        ArrayList<Node> listClosed  = new ArrayList<>();
        
          for (int i = 0; i < grid.getRows(); i++) 
        {
            for (int j = 0; j < grid.getRows(); j++) 
            {
                 if(grid.getGrid()[i][j].getItem() instanceof Vriend)
                {
                   target = new Node(grid.getGrid()[i][j]);
                   nodeList[i][j] = target;
                }
                 else
                 {
                Node node = new Node(grid.getGrid()[i][j]);
                nodeList[i][j] = node;
                 }
            }
        }
   

         for (int i = 1; i < grid.getRows() -1; i++) 
        {
            for (int j = 1; j < grid.getRows() -1; j++) 
            { 
                nodeList[i][j].upNode = nodeList[i-1][j];
                nodeList[i][j].downNode = nodeList[i+1][j];
                nodeList[i][j].leftNode = nodeList[i][j-1];
                nodeList[i][j].rightNode = nodeList[i][j+1];
                nodeList[i][j].makeList();
            }
        } 
         
         nodeList[getVeld().getY()][getVeld().getX()] = playerPos;
         current = playerPos;
         playerPos.upNode = nodeList[playerPos.veld.getY() -1][playerPos.veld.getX()];
         playerPos.downNode = nodeList[playerPos.veld.getY()+1][playerPos.veld.getX()];
         playerPos.leftNode = nodeList[playerPos.veld.getY()][playerPos.veld.getX()-1];
         playerPos.rightNode = nodeList[playerPos.veld.getY()][playerPos.veld.getX()+1];
         playerPos.makeList();
         
         listOpen.add(current);
         current.fCost = current.getFCost(playerPos.veld, target.veld);
         
            while(!listOpen.isEmpty()) {
                Node kleinste = listOpen.get(0);
                current = listOpen.get(0);
             for (int k = 0; k < listOpen.size(); k++) 
             {
                 int a = listOpen.get(k).getFCost(playerPos.veld,target.veld);
                 int b = kleinste.getFCost(playerPos.veld,target.veld);
             if(a<= b)
             {
                 kleinste = listOpen.get(k);
                 current = listOpen.get(k);
             }
             }
             listClosed.add(current);
             listOpen.remove(current);
             
             if(current.veld == target.veld)
             {
                 lastNode = current;
                 break;
                 
             }
             for (Node node : current.nodeList) 
                {
                    if(node.veld.getItem() instanceof Muur ==false && listClosed.contains(node) == false)
             {
                 int tentative_g_score = current.getGCost(playerPos.veld) + current.verschilBuur(node.veld);
                 if(tentative_g_score <= node.getGCost(playerPos.veld) || listOpen.contains(node) == false)
                 {
                     node.parentNode = current;
                     node.gCost = tentative_g_score;
                     node.fCost = node.getGCost(playerPos.veld) + node.getHCost(target.veld);
                     if(listOpen.contains(node) == false)
                     {
                         listOpen.add(node);                                               
                     }
                 }
             }   
                }
         }
        roepSetPath();
     }
     
     private void roepSetPath()
     {
         setPath(lastNode);
     }
     
     private void setPath(Node node)
     {
         if(node.parentNode != null)
         {
            Item cheat = new Path();
            Container panelContainer = this.getParent();
            Grid grid = (Grid)panelContainer;
            cheat.setBounds(node.veld.getX() * getBoxsize(), node.veld.getY() * getBoxsize(), getBoxsize(), getBoxsize());
            grid.add(cheat);
            grid.repaint();
            System.out.println("X :" +node.veld.getX() +"   Y:" + node.veld.getY());
            setPath(node.parentNode);
         }    
     }
     
     public class Path extends Item
     {
         public Path()
         {
             setImage(new  ImageIcon(getClass().getClassLoader().getResource("Images/path.png")).getImage()) ;
         }
          @Override
     public void paintComponent(Graphics g) 
        {
            
            super.paintComponent(g);
            g.drawImage(getImage(), 0, 0, getBoxsize(), getBoxsize(), null, this);

        }
     }
   
}
    

