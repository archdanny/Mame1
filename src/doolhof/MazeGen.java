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

    private int aantal;
    private Node[][] nodeList;
    private ArrayList<Node> listOpen;
    private ArrayList<Node> listClosed;

    public MazeGen(int _aantal) 
    {
        aantal =_aantal;
        nodeList = new Node[aantal][aantal];
        listClosed = new ArrayList<>();
        listOpen = new ArrayList<>();
        
    }
    
    public void nodesGen() {
        try
        {
        for (int i = 0; i < getAantal(); i++) 
        {
            for (int j = 0; j < getAantal(); j++) 
            {
                Veld veld = new Veld();
                veld.setX(j);
                veld.setY(i);
                Node node = new Node(veld);
                    getNodeList()[i][j] = node;
            }
        }
        
        //top layer velden y = 1 en Lower layer veld y = aantal -1
        for (int i = 3; i < getAantal() - 2; i=i+2) 
        {
                getNodeList()[1][i].setUpNode(getNodeList()[1 - 1][i]);
                getNodeList()[1][i].setDownNode(getNodeList()[1 + 2][i]);
                getNodeList()[1][i].setLeftNode(getNodeList()[1][i - 2]);
                getNodeList()[1][i].setRightNode(getNodeList()[1][i + 2]);
                getNodeList()[1][i].makeList();
            
                getNodeList()[getAantal() - 2][i].setUpNode(getNodeList()[getAantal() - 4][i]);
                getNodeList()[getAantal() - 2][i].setDownNode(getNodeList()[getAantal() - 1][i]);
                getNodeList()[getAantal() - 2][i].setLeftNode(getNodeList()[getAantal() - 2][i - 2]);
                getNodeList()[getAantal() - 2][i].setRightNode(getNodeList()[getAantal() - 2][i + 2]);
                getNodeList()[getAantal() - 2][i].makeList();

        }
        
        //Left layer velden y = 1 en right layer veld y = aantal -1
        for (int i = 3; i < getAantal() - 2; i=i+2) 
            {
                getNodeList()[i][1].setUpNode(getNodeList()[i - 2][1]);
                getNodeList()[i][1].setDownNode(getNodeList()[i + 2][1]);
                getNodeList()[i][1].setLeftNode(getNodeList()[i][1 - 1]);
                getNodeList()[i][1].setRightNode(getNodeList()[i][1 + 2]);
                getNodeList()[i][1].makeList();
                
                getNodeList()[i][getAantal() - 2].setUpNode(getNodeList()[i - 2][getAantal() - 2]);
                getNodeList()[i][getAantal() - 2].setDownNode(getNodeList()[i + 2][getAantal() - 2]);
                getNodeList()[i][getAantal() - 2].setLeftNode(getNodeList()[i][getAantal() - 4]);
                getNodeList()[i][getAantal() - 2].setRightNode(getNodeList()[i][getAantal() - 1]);
                getNodeList()[i][getAantal() - 2].makeList();
            }
            
                getNodeList()[1][1].setUpNode(getNodeList()[0][1]);
                getNodeList()[1][1].setDownNode(getNodeList()[1 + 2][1]);
                getNodeList()[1][1].setLeftNode(getNodeList()[1][0]);
                getNodeList()[1][1].setRightNode(getNodeList()[1][1+2]);
                getNodeList()[1][1].makeList();
                
                getNodeList()[1][getAantal() -2].setUpNode(getNodeList()[0][getAantal() -2]);
                getNodeList()[1][getAantal() -2].setDownNode(getNodeList()[1 + 2][getAantal() -2]);
                getNodeList()[1][getAantal() -2].setLeftNode(getNodeList()[getAantal() -2 -2][getAantal() -2]);
                getNodeList()[1][getAantal() -2].setRightNode(getNodeList()[getAantal() -2 +1][getAantal() -2]);
                getNodeList()[1][getAantal() -2].makeList();
                
        
        
        for (int i = 3; i < getAantal() - 2; i++) 
        {
            for (int j = 3; j < getAantal() - 2; j++) 
            {
                    getNodeList()[i][j].setUpNode(getNodeList()[i - 2][j]);
                    getNodeList()[i][j].setDownNode(getNodeList()[i + 2][j]);
                    getNodeList()[i][j].setLeftNode(getNodeList()[i][j - 2]);
                    getNodeList()[i][j].setRightNode(getNodeList()[i][j + 2]);
                    getNodeList()[i][j].makeList();
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
          for (int i = 1; i < getAantal() - 1; i++) 
        {
            for (int j = 2; j < getAantal() - 1; j= j+2) 
            {
                Muur muur = new Muur(false);
                getNodeList()[i][j].getVeld().setItem(muur);
            }
        }
          //fill horizontal muren
          for (int k = 0; k < getAantal() -1; k=k+2) 
          {
          for (int i = 0; i < getAantal() -1; i++) 
          {
               Muur muur = new Muur(false);
                getNodeList()[k][i].getVeld().setItem(muur);
            
            }
          }

          int checkTelNotMuur = 1;  //was 2
          for (int i = 1; i < getAantal() - 2; i++) 
        {
            for (int j = checkTelNotMuur; j < getAantal() - 2; j= j+2) 
            {
                getListOpen().add(getNodeList()[i][j]);
            }
        }
               //Horizontal buitenmuren
        for (int i = 0; i < getAantal(); i++) 
        {
             Muur muur = new Muur(true);
             getNodeList()[0][i].getVeld().setItem(muur);
              Muur muur1 = new Muur(true);
             getNodeList()[getAantal() -1][i].getVeld().setItem(muur1);
        }
        //verticaly buitenmuur
        for (int i = 0; i < getAantal(); i++) 
        {
             Muur muur = new Muur(true);
             getNodeList()[i][0].getVeld().setItem(muur);
              Muur muur1 = new Muur(true);
             getNodeList()[i][getAantal() -1].getVeld().setItem(muur1);
        }
    }

    public Node[][] makeNodeGrid() 
    {
          Node first = getNodeList()[1][1];
          Node current = null;
 
        //int totaal = (((Aantal - 1) * (Aantal - 1))/ 2) - ((4 * Aantal) +4);
        int totaal = (((getAantal() - 2) * (getAantal() - 2))/ 2);
        int visited = 0; 
          //while (!listOpen.isEmpty()) {
        boolean didBreak = false;
        current = first;
        getListClosed().add(current);
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
                            getNodeList()[current.getVeld().getY() +1][current.getVeld().getX()].getVeld().setLeeg();
                        node.setParentNode(current);
                        current = node;
                            getListClosed().add(current);
                        visited++;
                        didBreak = true;
                        break;
                    }
                    if (node ==current.getUpNode()) 
                    {
                            getNodeList()[current.getVeld().getY() -1][current.getVeld().getX()].getVeld().setLeeg();
                        node.setParentNode(current);
                         current = node;
                            getListClosed().add(current);
                         visited++;
                         didBreak = true;
                         break;
                    }
                    if (node ==current.getLeftNode()) 
                    {
                            getNodeList()[current.getVeld().getY()][current.getVeld().getX()-1].getVeld().setLeeg();
                        node.setParentNode(current);
                         current = node;
                            getListClosed().add(current);
                         visited++;
                         didBreak = true;
                         break;
                    }
                    if (node ==current.getRightNode()) 
                    {
                            getNodeList()[current.getVeld().getY()][current.getVeld().getX()+1].getVeld().setLeeg();
                        node.setParentNode(current);
                         current = node;
                            getListClosed().add(current);
                         visited++;
                         didBreak = true;
                         break;
                    }
                }
                else
                {
                        getListClosed().add(node);
                }
                
            }
             if(didBreak == false)         // !listOpen.isEmpty() &&
                    {
                    current = current.getParentNode();
                    }
        }
        }catch(Exception e)
        {
            //System.out.println(e + " Line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
            
             
        }
        Speler speler = new Speler();
        getNodeList()[1][1].getVeld().setItem(speler);
        Item bazooka = new Bazooka();
        setItemClose(bazooka);
        Item helper = new Helper();
        setItemClose(helper);
        Item vriend = new Vriend();
        setItemFar(vriend);
        Item cheater1 = new Cheater();
        setItemClose(cheater1);
        Item cheater2 = new Cheater();
        setItemFar(cheater2);
        
        return getNodeList();
    }
    
    
    
    public boolean checkNode(Node node)
    {
        boolean wall = false;
        if(node.getVeld().getY() !=0)
                {
                if(getNodeList()[node.getVeld().getY() -1][node.getVeld().getX()].getVeld().getItem() instanceof Muur ==false)
                {
                    wall = true;
                }
                }
                if(node.getVeld().getY() !=getAantal() -1)
                {
                if(getNodeList()[node.getVeld().getY() +1][node.getVeld().getX()].getVeld().getItem() instanceof Muur ==false)
                {
                    wall = true;
                }
                }
                if(node.getVeld().getX() !=0)
                {
                if(getNodeList()[node.getVeld().getY()][node.getVeld().getX()-1].getVeld().getItem() instanceof Muur ==false)
                {
                    wall = true;
                }
                }
                if(node.getVeld().getX() !=getAantal() -1)
                {
                if(getNodeList()[node.getVeld().getY()][node.getVeld().getX()+1].getVeld().getItem() instanceof Muur ==false)
                {
                    wall = true;
                }
                }
                return  wall;
    }
    
    
    public void setItemClose(Item item)
    {
        
        int randomCheck =getAantal()/2;
        //int beginPunt = getAantal()- randomCheck;
                
        Random rand = new Random();
        int  randomX = rand.nextInt(randomCheck) + 1;
        int  randomY = rand.nextInt(randomCheck) + 1;
        while(getNodeList()[randomY][randomX].getVeld().getItem() instanceof Muur == true && getNodeList()[randomY][randomX].getVeld().getItem() != null)
        {
           randomX = rand.nextInt(randomCheck) + 1;
           randomY = rand.nextInt(randomCheck) + 1;
        }
        
        getNodeList()[randomY][randomX].getVeld().setItem(item);
    }
    
     public void setItemFar(Item item)
    {
        
        int randomCheck =getAantal()/4;
        //int beginPunt = getAantal()- randomCheck;
                
        Random rand = new Random();
        int  randomX = getAantal()/2 + rand.nextInt(randomCheck) + 1;
        int  randomY = getAantal()/2 +rand.nextInt(randomCheck) + 1;
        while(getNodeList()[randomY][randomX].getVeld().getItem() instanceof Muur == true && getNodeList()[randomY][randomX].getVeld().getItem() != null)
        {
           randomX = getAantal()/2 + rand.nextInt(randomCheck) + 1;
           randomY = getAantal()/2 +rand.nextInt(randomCheck) + 1;
        }
        
        getNodeList()[randomY][randomX].getVeld().setItem(item);
    }

 
    public int getAantal() {
        return aantal;
    }

 
    public void setAantal(int Aantal) {
        this.aantal = Aantal;
    }


    public Node[][] getNodeList() {
        return nodeList;
    }


    public void setNodeList(Node[][] nodeList) {
        this.nodeList = nodeList;
    }


    public ArrayList<Node> getListOpen() {
        return listOpen;
    }


    public void setListOpen(ArrayList<Node> listOpen) {
        this.listOpen = listOpen;
    }

   
    public ArrayList<Node> getListClosed() {
        return listClosed;
    }

 
    public void setListClosed(ArrayList<Node> listClosed) {
        this.listClosed = listClosed;
    }
    
    
    
}

    

        
  
    
    

