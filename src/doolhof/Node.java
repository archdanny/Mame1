/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.util.ArrayList;

/**
 *
 * @author Danny
 */
public class Node {
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

