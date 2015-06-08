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
    
    private int gCost;
    private int fCost;
    private int hCost;
    private Veld veld;
    private Node parentNode;
    private Node leftNode;
    private Node rightNode;
    private Node upNode;
    private Node downNode;
    private ArrayList<Node> nodeList;
         
         
         public Node(Veld _veld)
         {
             veld = _veld;
             gCost = -1;
             fCost = -1;
             hCost = -1;
            
         }

         public int getHCost(Veld targetVeld)
         {
              if(gethCost() == -1 )
             {
            int curentX = Math.abs(targetVeld.getX() - getVeld().getX());
            int curentY = Math.abs(targetVeld.getY() - getVeld().getY());
            return curentX + curentY;
             }
               else
             {
                 return gethCost();
             }
         }
         
            public int getGCost(Veld StartNode)
         {
             if(getgCost() == -1)
             {
            int curentX = Math.abs(StartNode.getX() - getVeld().getX());
            int curentY = Math.abs(StartNode.getY() - getVeld().getY());
            return curentX + curentY;
             }
             else
             {
                 return getgCost();
             }
         }
           public int getFCost(Veld StartNode , Veld targetVeld)
         {
             if(getfCost() == -1)
             {
            return getGCost(StartNode) + getHCost(targetVeld);
             }
              else
             {
                 return getfCost();
             }
         }
           
            public int verschilBuur(Veld buur)
         {
            int curentX = Math.abs(buur.getX() - getVeld().getX());
            int curentY = Math.abs(buur.getY() - getVeld().getY());
            return curentX + curentY;
         }
            
         public void makeList()
         {
            nodeList = new ArrayList<>();
            getNodeList().add(upNode);
            getNodeList().add(downNode);
            getNodeList().add(leftNode);
            getNodeList().add(rightNode);
         }

    
    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Veld getVeld() {
        return veld;
    }

    public void setVeld(Veld veld) {
        this.veld = veld;
    }

 
    public Node getLeftNode() {
        return leftNode;
    }

  
    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

  
    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

 
    public Node getUpNode() {
        return upNode;
    }

    public void setUpNode(Node upNode) {
        this.upNode = upNode;
    }

    public Node getDownNode() {
        return downNode;
    }

    public void setDownNode(Node downNode) {
        this.downNode = downNode;
    }

    public ArrayList<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(ArrayList<Node> nodeList) {
        this.nodeList = nodeList;
    }

 
    public int gethCost() {
        return hCost;
    }

    public void sethCost(int hCost) {
        this.hCost = hCost;
    }

 
    public int getfCost() {
        return fCost;
    }

 
    public void setfCost(int fCost) {
        this.fCost = fCost;
    }

 
    public int getgCost() {
        return gCost;
    }


    public void setgCost(int gCost) {
        this.gCost = gCost;
    }
   
     }

