/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;


import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
    public Grid grid;
    public Node lastNode;
    
      
    public Helper(Grid gridGet)
    {
      image = new  ImageIcon(getClass().getClassLoader().getResource("Images/diamond.png")).getImage();
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
                 
                translateX =30;
                translateY =30;
             }
               if(rotation == 90)
             {
              
                translateX =30;
                translateY =0;
             }
              if(rotation == 270)
             {
             
                translateX =0;
                translateY =30;
             }
              if(rotation == 0)
             {
               
                translateX =0;
                translateY =0;
             }
            
            super.paintComponent(g);
                g.drawImage(image, 0, 0, boxSize, boxSize, null, this);
                 Graphics2D g2d=(Graphics2D)g; // Create a Java2D version of g.
            g2d.translate(translateX, translateY); // Translate the center of our coordinates.
            g2d.rotate(Math.toRadians(rotation));  // Rotate the image by 1 radian.
            g2d.drawImage(image, 0, 0, boxSize, boxSize, null,this);

        }
     
     public void Rotation()
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
        
     
     
     public class Task extends TimerTask {


        @Override
        public void run() 
        {
           Rotation();
        }
    
     }
     
     public void GetLocation(Veld veld, JPanel panel)
     {

         Node  playerPos= new Node(grid.speler.huidigeVeld);
         Node current = null;
         Node target = null;
         Node [][] nodeList = new Node[20][20];
        ArrayList<Node> listOpen = new ArrayList<>();
        ArrayList<Node> listClosed  = new ArrayList<>();
        
          for (int i = 0; i < 20; i++) 
        {
            for (int j = 0; j < 20; j++) 
            {
                 if(grid.gridVeld[i][j].item instanceof Vriend)
                {
                   target = new Node(grid.gridVeld[i][j]);
                   nodeList[i][j] = target;
                }
                 else
                 {
                Node node = new Node(grid.gridVeld[i][j]);
                nodeList[i][j] = node;
                 }
            }
        }
   

         for (int i = 1; i < 19; i++) 
        {
            for (int j = 1; j < 19; j++) 
            { 
                nodeList[i][j].upNode = nodeList[i-1][j];
                nodeList[i][j].downNode = nodeList[i+1][j];
                nodeList[i][j].leftNode = nodeList[i][j-1];
                nodeList[i][j].rightNode = nodeList[i][j+1];
                nodeList[i][j].makeList();
            }
        } 
         
         nodeList[grid.speler.huidigeVeld.y][grid.speler.huidigeVeld.x] = playerPos;
         current = playerPos;
         playerPos.upNode = nodeList[playerPos.veld.y -1][playerPos.veld.x];
         playerPos.downNode = nodeList[playerPos.veld.y+1][playerPos.veld.x];
         playerPos.leftNode = nodeList[playerPos.veld.y][playerPos.veld.x-1];
         playerPos.rightNode = nodeList[playerPos.veld.y][playerPos.veld.x+1];
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
                    if(node.veld.item instanceof Muur ==false && listClosed.contains(node) == false)
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
     }
     
     public void roepSetPath()
     {
         setPath(lastNode);
     }
     
     public void setPath(Node node)
     {
         if(node.parentNode != null)
         {
            Item cheat = new Helper(grid);
            Container panelContainer = this.getParent();
            Grid grid = (Grid)panelContainer;
            cheat.setBounds(node.veld.x * 30, node.veld.y * 30, boxSize, boxSize);
            grid.add(cheat);
            grid.repaint();
            System.out.println("X :" +node.veld.x +"   Y:" + node.veld.y);
            setPath(node.parentNode);
         }    
     }
     
     public class Node
     {
         int gCost;
         int fCost;
         int hCost;
         public Veld veld;
         Node parentNode;
         Node leftNode;
         Node rightNode;
         Node upNode;
         Node downNode;
         ArrayList<Node> nodeList;
         
         
         public Node(Veld _veld)
         {
             veld = _veld;
             gCost = -1;
             fCost = -1;
             hCost = -1;
            
         }

         public int getHCost(Veld targetVeld)
         {
              if(hCost == -1 )
             {
            int curentX = Math.abs(targetVeld.x - veld.x);
            int curentY = Math.abs(targetVeld.y - veld.y);
            return curentX + curentY;
             }
               else
             {
                 return hCost;
             }
         }
         
            public int getGCost(Veld StartNode)
         {
             if(gCost == -1)
             {
            int curentX = Math.abs(StartNode.x - veld.x);
            int curentY = Math.abs(StartNode.y - veld.y);
            return curentX + curentY;
             }
             else
             {
                 return gCost;
             }
         }
           public int getFCost(Veld StartNode , Veld targetVeld)
         {
             if(fCost == -1)
             {
            return getGCost(StartNode) + getHCost(targetVeld);
             }
              else
             {
                 return fCost;
             }
         }
           
            public int verschilBuur(Veld buur)
         {
            int curentX = Math.abs(buur.x - veld.x);
            int curentY = Math.abs(buur.y - veld.y);
            return curentX + curentY;
         }
            
         public void makeList()
         {
            nodeList = new ArrayList<>();
            nodeList.add(upNode);
            nodeList.add(downNode);
            nodeList.add(leftNode);
            nodeList.add(rightNode);
         }
         
         
     }
     
     
 
}
    

