/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Danny
 */
public class MazeGen {

    int Aantal;
    Node[][] nodeList;
    Node[][] nodeListBIg;
    ArrayList<Node> listOpen;
    ArrayList<Node> listClosed;

    public MazeGen(int _aantal) {
        Aantal =_aantal;
        nodeList = new Node[Aantal][Aantal];
        nodeListBIg = new Node[Aantal][Aantal];
        listClosed = new ArrayList<>();
        listOpen = new ArrayList<>();
        
    }

    public void NodesGen() {
        try
        {
        for (int i = 0; i < Aantal; i++) 
        {
            for (int j = 0; j < Aantal; j++) 
            {
                Veld veld = new Veld();
                veld.setX(j);
                veld.setY(i);
                Node node = new Node(veld);
                nodeList[i][j] = node;
            }
        }
        
        //top layer velden y = 1 en Lower layer veld y = aantal -1
        for (int i = 3; i < Aantal - 2; i=i+2) 
        {
            nodeList[1][i].setUpNode(nodeList[1 - 1][i]);
            nodeList[1][i].setDownNode(nodeList[1 + 2][i]);
            nodeList[1][i].setLeftNode(nodeList[1][i - 2]);
            nodeList[1][i].setRightNode(nodeList[1][i + 2]);
            nodeList[1][i].makeList();
            
            nodeList[Aantal - 2][i].setUpNode(nodeList[Aantal - 4][i]);
            nodeList[Aantal - 2][i].setDownNode(nodeList[Aantal - 1][i]);
            nodeList[Aantal - 2][i].setLeftNode(nodeList[Aantal - 2][i - 2]);
            nodeList[Aantal - 2][i].setRightNode(nodeList[Aantal - 2][i + 2]);
            nodeList[Aantal - 2][i].makeList();
            
//            nodeList[Aantal - 1][i].setUpNode(nodeList[Aantal - 3][i]);
//            nodeList[Aantal - 1][i].setDownNode(null);
//            nodeList[Aantal - 1][i].setLeftNode(nodeList[Aantal - 1][i - 2]);
//            nodeList[Aantal - 1][i].setRightNode(nodeList[Aantal - 1][i + 2]);
//            nodeList[Aantal - 1][i].makeList();
        }
        
        //Left layer velden y = 1 en right layer veld y = aantal -1
        for (int i = 3; i < Aantal - 2; i=i+2) 
            {
                nodeList[i][1].setUpNode(nodeList[i - 2][1]);
                nodeList[i][1].setDownNode(nodeList[i + 2][1]);
                nodeList[i][1].setLeftNode(nodeList[i][1 - 1]);
                nodeList[i][1].setRightNode(nodeList[i][1 + 2]);
                nodeList[i][1].makeList();
                
                nodeList[i][Aantal - 2].setUpNode(nodeList[i - 2][Aantal - 2]);
                nodeList[i][Aantal - 2].setDownNode(nodeList[i + 2][Aantal - 2]);
                nodeList[i][Aantal - 2].setLeftNode(nodeList[i][Aantal - 4]);
                nodeList[i][Aantal - 2].setRightNode(nodeList[i][Aantal - 1]);
                nodeList[i][Aantal - 2].makeList();
            }
            
                nodeList[1][1].setUpNode(nodeList[0][1]);
                nodeList[1][1].setDownNode(nodeList[1 + 2][1]);
                nodeList[1][1].setLeftNode(nodeList[1][0]);
                nodeList[1][1].setRightNode(nodeList[1][1+2]);
                nodeList[1][1].makeList();
                
//                nodeList[Aantal -1][1].setUpNode(nodeList[Aantal -2][1]);
//                nodeList[Aantal -1][1].setDownNode(nodeList[Aantal +1][1]);
//                nodeList[Aantal -1][1].setLeftNode(nodeList[Aantal -2][0]);
//                nodeList[Aantal -1][1].setRightNode(nodeList[Aantal -2][1+2]);
//                nodeList[Aantal -1][1].makeList();
                
                nodeList[1][Aantal -2].setUpNode(nodeList[0][Aantal -2]);
                nodeList[1][Aantal -2].setDownNode(nodeList[1 + 2][Aantal -2]);
                nodeList[1][Aantal -2].setLeftNode(nodeList[Aantal -2 -2][Aantal -2]);
                nodeList[1][Aantal -2].setRightNode(nodeList[Aantal -2 +1][Aantal -2]);
                nodeList[1][Aantal -2].makeList();
                
//                nodeList[Aantal -2][Aantal -2].setUpNode(nodeList[Aantal -2-2][Aantal -2]);
//                nodeList[Aantal -2][Aantal -2].setDownNode(nodeList[Aantal -2 +1][Aantal -2]);
//                nodeList[Aantal -2][Aantal -2].setLeftNode(nodeList[Aantal -2 -2][Aantal -2]);
//                nodeList[Aantal -2][Aantal -2].setRightNode(nodeList[Aantal -2 +1][Aantal -2]);
//                nodeList[Aantal -2][Aantal -2].makeList();
//        
        
        
        for (int i = 3; i < Aantal - 2; i++) 
        {
            for (int j = 3; j < Aantal - 2; j++) 
            {
                nodeList[i][j].setUpNode(nodeList[i - 2][j]);
                nodeList[i][j].setDownNode(nodeList[i + 2][j]);
                nodeList[i][j].setLeftNode(nodeList[i][j - 2]);
                nodeList[i][j].setRightNode(nodeList[i][j + 2]);
                nodeList[i][j].makeList();
            }
        }
        }catch(Exception e)
        {
            System.out.println(e + " Line " + Thread.currentThread().getStackTrace()[2].getLineNumber());  
        }

    }
    
    public void vulMuur()
    {
 
        //Fill verticaly ish
          for (int i = 1; i < Aantal - 1; i++) 
        {
            for (int j = 2; j < Aantal - 1; j= j+2) 
            {
                Muur muur = new Muur(false);
                nodeList[i][j].getVeld().setItem(muur);
            }
        }
          //fill horizontal muren
          for (int k = 0; k < Aantal -1; k=k+2) 
          {
          for (int i = 0; i < Aantal -1; i++) 
          {
               Muur muur = new Muur(false);
                nodeList[k][i].getVeld().setItem(muur);
            
            }
          }

          int checkTelNotMuur = 1;  //was 2
          for (int i = 1; i < Aantal - 2; i++) 
        {
            for (int j = checkTelNotMuur; j < Aantal - 2; j= j+2) 
            {
                listOpen.add(nodeList[i][j]);
            }
        }
               //Horizontal buitenmuren
        for (int i = 0; i < Aantal; i++) 
        {
             Muur muur = new Muur(true);
             nodeList[0][i].getVeld().setItem(muur);
              Muur muur1 = new Muur(true);
             nodeList[Aantal -1][i].getVeld().setItem(muur1);
        }
        //verticaly buitenmuur
        for (int i = 0; i < Aantal; i++) 
        {
             Muur muur = new Muur(true);
             nodeList[i][0].getVeld().setItem(muur);
              Muur muur1 = new Muur(true);
             nodeList[i][Aantal -1].getVeld().setItem(muur1);
        }
    }

    public Node[][] makeNodeGrid() 
    {
          Node first = nodeList[1][1];
          Node current = null;
 
        //int totaal = (((Aantal - 1) * (Aantal - 1))/ 2) - ((4 * Aantal) +4);
        int totaal = (((Aantal - 2) * (Aantal - 2))/ 2);
        int visited = 0; 
          //while (!listOpen.isEmpty()) {
        boolean didBreak = false;
        current = first;
        listClosed.add(current);
        try
        {
          while (visited< totaal) 
          {
            if(current.getNodeList() !=null)
            {
            ArrayList<Node> _nodeList = current.getNodeList();
            Collections.shuffle(_nodeList);
            current.setNodeList(_nodeList);
            }
            
            for (Node node : current.getNodeList()) 
            {
                didBreak = false;
                boolean wall = checkNode(node);
                
                if (node.getVeld().getItem() instanceof Muur == false  && wall == false) //&& listClosed.contains(node) == false
                {
                    if (node ==current.getDownNode()) 
                    {
                        nodeList[current.getVeld().getY() +1][current.getVeld().getX()].getVeld().setLeeg();
                        node.setParentNode(current);
                        current = node;
                        listClosed.add(current);
                        visited++;
                        didBreak = true;
                        break;
                    }
                    if (node ==current.getUpNode()) 
                    {
                        nodeList[current.getVeld().getY() -1][current.getVeld().getX()].getVeld().setLeeg();
                        node.setParentNode(current);
                         current = node;
                         listClosed.add(current);
                         visited++;
                         didBreak = true;
                         break;
                    }
                    if (node ==current.getLeftNode()) 
                    {
                        nodeList[current.getVeld().getY()][current.getVeld().getX()-1].getVeld().setLeeg();
                        node.setParentNode(current);
                         current = node;
                         listClosed.add(current);
                         visited++;
                         didBreak = true;
                         break;
                    }
                    if (node ==current.getRightNode()) 
                    {
                        nodeList[current.getVeld().getY()][current.getVeld().getX()+1].getVeld().setLeeg();
                        node.setParentNode(current);
                         current = node;
                         listClosed.add(current);
                         visited++;
                         didBreak = true;
                         break;
                    }
                }
                else
                {
                    listClosed.add(node);
                }
                
            }
             if(didBreak == false)         // !listOpen.isEmpty() &&
                    {
                    current = current.getParentNode();
                    }
        }
        }catch(Exception e)
        {
            System.out.println(e + " Line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
            
             
        }
        Speler speler = new Speler();
        nodeList[1][1].getVeld().setItem(speler);
        Item bazooka = new Bazooka();
        setItemClose(bazooka);
        Item helper = new Helper();
        setItemClose(helper);
        Item vriend = new Vriend();
        setItemFar(vriend);
 
        return nodeList;
    }
    
    
    
    public boolean checkNode(Node node)
    {
        boolean wall = false;
        if(node.getVeld().getY() !=0)
                {
                if(nodeList[node.getVeld().getY() -1][node.getVeld().getX()].getVeld().getItem() instanceof Muur ==false)
                {
                    wall = true;
                }
                }
                if(node.getVeld().getY() !=Aantal -1)
                {
                if(nodeList[node.getVeld().getY() +1][node.getVeld().getX()].getVeld().getItem() instanceof Muur ==false)
                {
                    wall = true;
                }
                }
                if(node.getVeld().getX() !=0)
                {
                if(nodeList[node.getVeld().getY()][node.getVeld().getX()-1].getVeld().getItem() instanceof Muur ==false)
                {
                    wall = true;
                }
                }
                if(node.getVeld().getX() !=Aantal -1)
                {
                if(nodeList[node.getVeld().getY()][node.getVeld().getX()+1].getVeld().getItem() instanceof Muur ==false)
                {
                    wall = true;
                }
                }
                return  wall;
    }
    
    
    public void setItemClose(Item item)
    {
        
        int randomCheck =Aantal/2;
        int beginPunt = Aantal- randomCheck;
                
        Random rand = new Random();
        int  randomX = rand.nextInt(randomCheck) + 1;
        int  randomY = rand.nextInt(randomCheck) + 1;
        while(nodeList[randomY][randomX].getVeld().getItem() instanceof Muur == true)
        {
           randomX = rand.nextInt(randomCheck) + 1;
           randomY = rand.nextInt(randomCheck) + 1;
        }
        
        nodeList[randomY][randomX].getVeld().setItem(item);
    }
    
     public void setItemFar(Item item)
    {
        
        int randomCheck =Aantal/4;
        int beginPunt = Aantal- randomCheck;
                
        Random rand = new Random();
        int  randomX = Aantal/2 + rand.nextInt(randomCheck) + 1;
        int  randomY = Aantal/2 +rand.nextInt(randomCheck) + 1;
        while(nodeList[randomY][randomX].getVeld().getItem() instanceof Muur == true)
        {
           randomX = Aantal/2 + rand.nextInt(randomCheck) + 1;
           randomY = Aantal/2 +rand.nextInt(randomCheck) + 1;
        }
        
        nodeList[randomY][randomX].getVeld().setItem(item);
    }
    
    
    
}

    

        
  
    
    

